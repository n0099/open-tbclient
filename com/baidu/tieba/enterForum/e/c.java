package com.baidu.tieba.enterForum.e;

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
    private int aYr;
    private int aYs;
    private int aYt;
    private com.baidu.tieba.enterForum.a.c aYu;
    private int aYv;
    private Runnable aYw;
    private int mOffset;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYw = new d(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aYu = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void T(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aYr && pointToPosition != -1) {
            this.aYu.fH(pointToPosition);
            this.aYu.Q(this.aYr, pointToPosition);
            this.aYr = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aYs = (int) motionEvent.getRawX();
        this.aYt = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.MI().MJ()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aYw);
                    com.baidu.tieba.enterForum.c.a.MI().MM();
                    this.aYu.fH(-1);
                    this.aYu.Mc();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.MN().a(motionEvent.getY(), this.aYv, getHeight());
                    com.baidu.tieba.enterForum.c.a.MI().R(this.aYs, this.aYt - this.mOffset);
                    T((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.aYr = i;
        com.baidu.tieba.enterForum.c.a.MI().a(getContext(), view, this.aYs, this.aYt);
        this.aYu.fH(i);
        this.aYu.Mc();
        this.aYv = view.getHeight();
        com.baidu.adp.lib.h.h.dL().postDelayed(this.aYw, 200L);
        return true;
    }
}
