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
    private int cZK;
    private int cZL;
    private int cZM;
    private com.baidu.tieba.enterForum.a.c cZN;
    private int cZO;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.cZO : -DragGridView.this.cZO, 200);
                }
                e.jt().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.cZN = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aD(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cZK && pointToPosition != -1) {
            this.cZN.kf(pointToPosition);
            this.cZN.az(this.cZK, pointToPosition);
            this.cZK = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cZL = (int) motionEvent.getRawX();
        this.cZM = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.aqN().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.jt().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.aqN().aqQ();
                    this.cZN.kf(-1);
                    this.cZN.alQ();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.cZO, getHeight());
                    com.baidu.tieba.enterForum.model.a.aqN().aB(this.cZL, this.cZM - this.mOffset);
                    aD((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cZK = i;
        com.baidu.tieba.enterForum.model.a.aqN().a(getContext(), view, this.cZL, this.cZM);
        this.cZN.kf(i);
        this.cZN.alQ();
        this.cZO = view.getHeight();
        e.jt().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
