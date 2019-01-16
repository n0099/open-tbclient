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
    private int dtg;
    private int dth;
    private int dti;
    private com.baidu.tieba.enterForum.a.c dtj;
    private int dtk;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.dtk : -DragGridView.this.dtk, 200);
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
            this.dtj = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aJ(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dtg && pointToPosition != -1) {
            this.dtj.lz(pointToPosition);
            this.dtj.aG(this.dtg, pointToPosition);
            this.dtg = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dth = (int) motionEvent.getRawX();
        this.dti = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.awF().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.jG().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.awF().awI();
                    this.dtj.lz(-1);
                    this.dtj.notifyDataChanged();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.dtk, getHeight());
                    com.baidu.tieba.enterForum.model.a.awF().aH(this.dth, this.dti - this.mOffset);
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
        this.dtg = i;
        com.baidu.tieba.enterForum.model.a.awF().a(getContext(), view, this.dth, this.dti);
        this.dtj.lz(i);
        this.dtj.notifyDataChanged();
        this.dtk = view.getHeight();
        e.jG().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
