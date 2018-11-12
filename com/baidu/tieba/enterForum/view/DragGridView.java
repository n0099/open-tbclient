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
/* loaded from: classes4.dex */
public class DragGridView extends GridView implements AdapterView.OnItemLongClickListener {
    private int dje;
    private int djf;
    private int djg;
    private com.baidu.tieba.enterForum.a.c djh;
    private int dji;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.dji : -DragGridView.this.dji, 200);
                }
                e.jG().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.djh = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aI(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dje && pointToPosition != -1) {
            this.djh.kV(pointToPosition);
            this.djh.aE(this.dje, pointToPosition);
            this.dje = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.djf = (int) motionEvent.getRawX();
        this.djg = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.atI().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.jG().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.atI().atL();
                    this.djh.kV(-1);
                    this.djh.notifyDataChanged();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.dji, getHeight());
                    com.baidu.tieba.enterForum.model.a.atI().aG(this.djf, this.djg - this.mOffset);
                    aI((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.dje = i;
        com.baidu.tieba.enterForum.model.a.atI().a(getContext(), view, this.djf, this.djg);
        this.djh.kV(i);
        this.djh.notifyDataChanged();
        this.dji = view.getHeight();
        e.jG().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
