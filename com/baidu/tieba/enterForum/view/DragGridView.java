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
    private int dth;
    private int dti;
    private int dtj;
    private com.baidu.tieba.enterForum.a.c dtk;
    private int dtl;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.dtl : -DragGridView.this.dtl, 200);
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
            this.dtk = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aJ(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dth && pointToPosition != -1) {
            this.dtk.lz(pointToPosition);
            this.dtk.aG(this.dth, pointToPosition);
            this.dth = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dti = (int) motionEvent.getRawX();
        this.dtj = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.awF().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.jG().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.awF().awI();
                    this.dtk.lz(-1);
                    this.dtk.notifyDataChanged();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.dtl, getHeight());
                    com.baidu.tieba.enterForum.model.a.awF().aH(this.dti, this.dtj - this.mOffset);
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
        this.dth = i;
        com.baidu.tieba.enterForum.model.a.awF().a(getContext(), view, this.dti, this.dtj);
        this.dtk.lz(i);
        this.dtk.notifyDataChanged();
        this.dtl = view.getHeight();
        e.jG().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
