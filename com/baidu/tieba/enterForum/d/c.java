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
    private int aMA;
    private int aMB;
    private int aMC;
    private com.baidu.tieba.enterForum.a.c aMD;
    private int aME;
    private Runnable aMF;
    private int mOffset;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMF = new d(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aMD = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void U(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aMA && pointToPosition != -1) {
            this.aMD.eU(pointToPosition);
            this.aMD.R(this.aMA, pointToPosition);
            this.aMA = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aMB = (int) motionEvent.getRawX();
        this.aMC = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.In().Io()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.hg().removeCallbacks(this.aMF);
                    com.baidu.tieba.enterForum.c.a.In().Ir();
                    this.aMD.eU(-1);
                    this.aMD.HP();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.Is().a(motionEvent.getY(), this.aME, getHeight());
                    com.baidu.tieba.enterForum.c.a.In().S(this.aMB, this.aMC - this.mOffset);
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
        this.aMA = i;
        com.baidu.tieba.enterForum.c.a.In().a(getContext(), view, this.aMB, this.aMC);
        this.aMD.eU(i);
        this.aMD.HP();
        this.aME = view.getHeight();
        com.baidu.adp.lib.g.h.hg().postDelayed(this.aMF, 200L);
        return true;
    }
}
