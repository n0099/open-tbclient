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
    private com.baidu.tieba.enterForum.a.c dsA;
    private int dsB;
    private int dsx;
    private int dsy;
    private int dsz;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.dsB : -DragGridView.this.dsB, 200);
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
            this.dsA = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aJ(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dsx && pointToPosition != -1) {
            this.dsA.ly(pointToPosition);
            this.dsA.aG(this.dsx, pointToPosition);
            this.dsx = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dsy = (int) motionEvent.getRawX();
        this.dsz = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.awi().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.jG().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.awi().awl();
                    this.dsA.ly(-1);
                    this.dsA.notifyDataChanged();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.dsB, getHeight());
                    com.baidu.tieba.enterForum.model.a.awi().aH(this.dsy, this.dsz - this.mOffset);
                    aJ((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.dsx = i;
        com.baidu.tieba.enterForum.model.a.awi().a(getContext(), view, this.dsy, this.dsz);
        this.dsA.ly(i);
        this.dsA.notifyDataChanged();
        this.dsB = view.getHeight();
        e.jG().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
