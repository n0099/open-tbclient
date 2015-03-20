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
    private com.baidu.tieba.enterForum.a.c aDA;
    private int aDB;
    private Runnable aDC;
    private int aDx;
    private int aDy;
    private int aDz;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDC = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aDA = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void J(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aDx && pointToPosition != -1) {
            this.aDA.eq(pointToPosition);
            this.aDA.G(this.aDx, pointToPosition);
            this.aDx = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aDy = (int) motionEvent.getRawX();
        this.aDz = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.GL().GM()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.i.hI().removeCallbacks(this.aDC);
                    com.baidu.tieba.enterForum.c.a.GL().GP();
                    this.aDA.eq(-1);
                    this.aDA.Gl();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.GQ().a(motionEvent.getY(), this.aDB, getHeight());
                    com.baidu.tieba.enterForum.c.a.GL().H(this.aDy, this.aDz - this.mOffset);
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
        this.aDx = i;
        com.baidu.tieba.enterForum.c.a.GL().a(getContext(), view, this.aDy, this.aDz);
        this.aDA.eq(i);
        this.aDA.Gl();
        this.aDB = view.getHeight();
        com.baidu.adp.lib.g.i.hI().postDelayed(this.aDC, 200L);
        return true;
    }
}
