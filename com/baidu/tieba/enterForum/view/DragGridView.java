package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes2.dex */
public class DragGridView extends GridView implements AdapterView.OnItemLongClickListener {
    private int cTX;
    private int cTY;
    private int cTZ;
    private com.baidu.tieba.enterForum.a.c cUa;
    private int cUb;
    private int mOffset;
    private Runnable mScrollRunnable;

    public DragGridView(Context context) {
        this(context, null);
    }

    public DragGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.enterForum.view.DragGridView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DragGridView.this.mOffset != 0) {
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.cUb : -DragGridView.this.cUb, 200);
                }
                e.in().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.cUa = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void az(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cTX && pointToPosition != -1) {
            this.cUa.jH(pointToPosition);
            this.cUa.av(this.cTX, pointToPosition);
            this.cTX = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cTY = (int) motionEvent.getRawX();
        this.cTZ = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.aoY().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.in().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.aoY().apb();
                    this.cUa.jH(-1);
                    this.cUa.akd();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.cUb, getHeight());
                    com.baidu.tieba.enterForum.model.a.aoY().ax(this.cTY, this.cTZ - this.mOffset);
                    az((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cTX = i;
        com.baidu.tieba.enterForum.model.a.aoY().a(getContext(), view, this.cTY, this.cTZ);
        this.cUa.jH(i);
        this.cUa.akd();
        this.cUb = view.getHeight();
        e.in().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
