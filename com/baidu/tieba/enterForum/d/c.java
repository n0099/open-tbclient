package com.baidu.tieba.enterForum.d;

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
    private int bcN;
    private int bcO;
    private int bcP;
    private com.baidu.tieba.enterForum.a.c bcQ;
    private int bcR;
    private Runnable bcS;
    private int mOffset;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcS = new d(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.bcQ = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void S(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bcN && pointToPosition != -1) {
            this.bcQ.gb(pointToPosition);
            this.bcQ.P(this.bcN, pointToPosition);
            this.bcN = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bcO = (int) motionEvent.getRawX();
        this.bcP = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.NT().NU()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.hx().removeCallbacks(this.bcS);
                    com.baidu.tieba.enterForum.c.a.NT().NX();
                    this.bcQ.gb(-1);
                    this.bcQ.Nr();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.NY().a(motionEvent.getY(), this.bcR, getHeight());
                    com.baidu.tieba.enterForum.c.a.NT().Q(this.bcO, this.bcP - this.mOffset);
                    S((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.bcN = i;
        com.baidu.tieba.enterForum.c.a.NT().a(getContext(), view, this.bcO, this.bcP);
        this.bcQ.gb(i);
        this.bcQ.Nr();
        this.bcR = view.getHeight();
        com.baidu.adp.lib.h.h.hx().postDelayed(this.bcS, 200L);
        return true;
    }
}
