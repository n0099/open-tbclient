package com.baidu.tieba.enterForum.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class c extends ListView implements AdapterView.OnItemLongClickListener {
    private int byA;
    private com.baidu.tieba.enterForum.a.d byB;
    private int byC;
    private Runnable byD;
    private int byy;
    private int byz;
    private int mOffset;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.byD = new d(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.d) {
            this.byB = (com.baidu.tieba.enterForum.a.d) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void Z(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.byy && pointToPosition != -1) {
            this.byB.hk(pointToPosition);
            this.byB.W(this.byy, pointToPosition);
            this.byy = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.byz = (int) motionEvent.getRawX();
        this.byA = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.UF().UG()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.eE().removeCallbacks(this.byD);
                    com.baidu.tieba.enterForum.model.a.UF().UJ();
                    this.byB.hk(-1);
                    this.byB.SH();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.byC, getHeight());
                    com.baidu.tieba.enterForum.model.a.UF().X(this.byz, this.byA - this.mOffset);
                    Z((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.byy = i;
        com.baidu.tieba.enterForum.model.a.UF().a(getContext(), view, this.byz, this.byA);
        this.byB.hk(i);
        this.byB.SH();
        this.byC = view.getHeight();
        com.baidu.adp.lib.g.h.eE().postDelayed(this.byD, 200L);
        return true;
    }
}
