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
    private int cRk;
    private int cRl;
    private int cRm;
    private com.baidu.tieba.enterForum.a.c cRn;
    private int cRo;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.cRo : -DragGridView.this.cRo, 200);
                }
                e.im().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.cRn = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aw(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cRk && pointToPosition != -1) {
            this.cRn.jv(pointToPosition);
            this.cRn.as(this.cRk, pointToPosition);
            this.cRk = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cRl = (int) motionEvent.getRawX();
        this.cRm = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.aoy().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.im().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.aoy().aoB();
                    this.cRn.jv(-1);
                    this.cRn.ajF();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.cRo, getHeight());
                    com.baidu.tieba.enterForum.model.a.aoy().au(this.cRl, this.cRm - this.mOffset);
                    aw((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cRk = i;
        com.baidu.tieba.enterForum.model.a.aoy().a(getContext(), view, this.cRl, this.cRm);
        this.cRn.jv(i);
        this.cRn.ajF();
        this.cRo = view.getHeight();
        e.im().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
