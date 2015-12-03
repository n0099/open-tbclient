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
    private int aRP;
    private int aRQ;
    private int aRR;
    private com.baidu.tieba.enterForum.a.c aRS;
    private int aRT;
    private Runnable aRU;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRU = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aRS = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void V(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aRP && pointToPosition != -1) {
            this.aRS.fr(pointToPosition);
            this.aRS.S(this.aRP, pointToPosition);
            this.aRP = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aRQ = (int) motionEvent.getRawX();
        this.aRR = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.JV().JW()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.hj().removeCallbacks(this.aRU);
                    com.baidu.tieba.enterForum.c.a.JV().JZ();
                    this.aRS.fr(-1);
                    this.aRS.Jy();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.Ka().a(motionEvent.getY(), this.aRT, getHeight());
                    com.baidu.tieba.enterForum.c.a.JV().T(this.aRQ, this.aRR - this.mOffset);
                    V((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.aRP = i;
        com.baidu.tieba.enterForum.c.a.JV().a(getContext(), view, this.aRQ, this.aRR);
        this.aRS.fr(i);
        this.aRS.Jy();
        this.aRT = view.getHeight();
        com.baidu.adp.lib.h.h.hj().postDelayed(this.aRU, 200L);
        return true;
    }
}
