package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class a extends GridView implements AdapterView.OnItemLongClickListener {
    private int aMp;
    private int aMq;
    private int aMr;
    private com.baidu.tieba.enterForum.a.c aMs;
    private int aMt;
    private Runnable aMu;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMu = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aMs = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void U(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aMp && pointToPosition != -1) {
            this.aMs.eU(pointToPosition);
            this.aMs.R(this.aMp, pointToPosition);
            this.aMp = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aMq = (int) motionEvent.getRawX();
        this.aMr = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.Ir().Is()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.hg().removeCallbacks(this.aMu);
                    com.baidu.tieba.enterForum.c.a.Ir().Iv();
                    this.aMs.eU(-1);
                    this.aMs.HT();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.Iw().a(motionEvent.getY(), this.aMt, getHeight());
                    com.baidu.tieba.enterForum.c.a.Ir().S(this.aMq, this.aMr - this.mOffset);
                    U((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.aMp = i;
        com.baidu.tieba.enterForum.c.a.Ir().a(getContext(), view, this.aMq, this.aMr);
        this.aMs.eU(i);
        this.aMs.HT();
        this.aMt = view.getHeight();
        com.baidu.adp.lib.g.h.hg().postDelayed(this.aMu, 200L);
        return true;
    }
}
