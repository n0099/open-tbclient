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
    private int aDF;
    private int aDG;
    private int aDH;
    private com.baidu.tieba.enterForum.a.c aDI;
    private int aDJ;
    private Runnable aDK;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDK = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aDI = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void J(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aDF && pointToPosition != -1) {
            this.aDI.eq(pointToPosition);
            this.aDI.G(this.aDF, pointToPosition);
            this.aDF = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aDG = (int) motionEvent.getRawX();
        this.aDH = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.GR().GS()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.i.hI().removeCallbacks(this.aDK);
                    com.baidu.tieba.enterForum.c.a.GR().GV();
                    this.aDI.eq(-1);
                    this.aDI.Gr();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.GW().a(motionEvent.getY(), this.aDJ, getHeight());
                    com.baidu.tieba.enterForum.c.a.GR().H(this.aDG, this.aDH - this.mOffset);
                    J((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.aDF = i;
        com.baidu.tieba.enterForum.c.a.GR().a(getContext(), view, this.aDG, this.aDH);
        this.aDI.eq(i);
        this.aDI.Gr();
        this.aDJ = view.getHeight();
        com.baidu.adp.lib.g.i.hI().postDelayed(this.aDK, 200L);
        return true;
    }
}
