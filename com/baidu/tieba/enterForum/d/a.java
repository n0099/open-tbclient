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
    private int aMI;
    private int aMJ;
    private int aMK;
    private com.baidu.tieba.enterForum.a.c aML;
    private int aMM;
    private Runnable aMN;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMN = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aML = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void U(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aMI && pointToPosition != -1) {
            this.aML.fc(pointToPosition);
            this.aML.R(this.aMI, pointToPosition);
            this.aMI = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aMJ = (int) motionEvent.getRawX();
        this.aMK = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.ID().IE()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.hh().removeCallbacks(this.aMN);
                    com.baidu.tieba.enterForum.c.a.ID().IH();
                    this.aML.fc(-1);
                    this.aML.If();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.II().a(motionEvent.getY(), this.aMM, getHeight());
                    com.baidu.tieba.enterForum.c.a.ID().S(this.aMJ, this.aMK - this.mOffset);
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
        this.aMI = i;
        com.baidu.tieba.enterForum.c.a.ID().a(getContext(), view, this.aMJ, this.aMK);
        this.aML.fc(i);
        this.aML.If();
        this.aMM = view.getHeight();
        com.baidu.adp.lib.g.h.hh().postDelayed(this.aMN, 200L);
        return true;
    }
}
