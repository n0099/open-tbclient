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
    private int aNh;
    private int aNi;
    private int aNj;
    private com.baidu.tieba.enterForum.a.c aNk;
    private int aNl;
    private Runnable aNm;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNm = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aNk = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void U(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aNh && pointToPosition != -1) {
            this.aNk.eI(pointToPosition);
            this.aNk.R(this.aNh, pointToPosition);
            this.aNh = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aNi = (int) motionEvent.getRawX();
        this.aNj = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.IH().II()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.hi().removeCallbacks(this.aNm);
                    com.baidu.tieba.enterForum.c.a.IH().IL();
                    this.aNk.eI(-1);
                    this.aNk.Il();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.IM().a(motionEvent.getY(), this.aNl, getHeight());
                    com.baidu.tieba.enterForum.c.a.IH().S(this.aNi, this.aNj - this.mOffset);
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
        this.aNh = i;
        com.baidu.tieba.enterForum.c.a.IH().a(getContext(), view, this.aNi, this.aNj);
        this.aNk.eI(i);
        this.aNk.Il();
        this.aNl = view.getHeight();
        com.baidu.adp.lib.g.h.hi().postDelayed(this.aNm, 200L);
        return true;
    }
}
