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
    private int bHO;
    private int bHP;
    private int bHQ;
    private com.baidu.tieba.enterForum.a.d bHR;
    private int bHS;
    private Runnable bHT;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHT = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.d) {
            this.bHR = (com.baidu.tieba.enterForum.a.d) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void af(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bHO && pointToPosition != -1) {
            this.bHR.hp(pointToPosition);
            this.bHR.ac(this.bHO, pointToPosition);
            this.bHO = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bHP = (int) motionEvent.getRawX();
        this.bHQ = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.Xc().Xd()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bHT);
                    com.baidu.tieba.enterForum.model.a.Xc().Xg();
                    this.bHR.hp(-1);
                    this.bHR.Vg();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.bHS, getHeight());
                    com.baidu.tieba.enterForum.model.a.Xc().ad(this.bHP, this.bHQ - this.mOffset);
                    af((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.bHO = i;
        com.baidu.tieba.enterForum.model.a.Xc().a(getContext(), view, this.bHP, this.bHQ);
        this.bHR.hp(i);
        this.bHR.Vg();
        this.bHS = view.getHeight();
        com.baidu.adp.lib.g.h.fS().postDelayed(this.bHT, 200L);
        return true;
    }
}
