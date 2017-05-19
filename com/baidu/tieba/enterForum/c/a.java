package com.baidu.tieba.enterForum.c;

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
    private com.baidu.tieba.enterForum.a.e bHA;
    private int bHB;
    private Runnable bHC;
    private int bHx;
    private int bHy;
    private int bHz;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHC = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.e) {
            this.bHA = (com.baidu.tieba.enterForum.a.e) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void ag(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bHx && pointToPosition != -1) {
            this.bHA.hm(pointToPosition);
            this.bHA.ad(this.bHx, pointToPosition);
            this.bHx = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bHy = (int) motionEvent.getRawX();
        this.bHz = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.Ws().Wt()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bHC);
                    com.baidu.tieba.enterForum.model.a.Ws().Ww();
                    this.bHA.hm(-1);
                    this.bHA.Uz();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.bHB, getHeight());
                    com.baidu.tieba.enterForum.model.a.Ws().ae(this.bHy, this.bHz - this.mOffset);
                    ag((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.bHx = i;
        com.baidu.tieba.enterForum.model.a.Ws().a(getContext(), view, this.bHy, this.bHz);
        this.bHA.hm(i);
        this.bHA.Uz();
        this.bHB = view.getHeight();
        com.baidu.adp.lib.g.h.fS().postDelayed(this.bHC, 200L);
        return true;
    }
}
