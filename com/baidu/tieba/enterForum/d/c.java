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
    private int aYe;
    private int aYf;
    private int aYg;
    private com.baidu.tieba.enterForum.a.c aYh;
    private int aYi;
    private Runnable aYj;
    private int mOffset;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYj = new d(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aYh = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void U(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aYe && pointToPosition != -1) {
            this.aYh.fL(pointToPosition);
            this.aYh.R(this.aYe, pointToPosition);
            this.aYe = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aYf = (int) motionEvent.getRawX();
        this.aYg = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.Mf().Mg()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.hr().removeCallbacks(this.aYj);
                    com.baidu.tieba.enterForum.c.a.Mf().Mj();
                    this.aYh.fL(-1);
                    this.aYh.LD();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.Mk().a(motionEvent.getY(), this.aYi, getHeight());
                    com.baidu.tieba.enterForum.c.a.Mf().S(this.aYf, this.aYg - this.mOffset);
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
        this.aYe = i;
        com.baidu.tieba.enterForum.c.a.Mf().a(getContext(), view, this.aYf, this.aYg);
        this.aYh.fL(i);
        this.aYh.LD();
        this.aYi = view.getHeight();
        com.baidu.adp.lib.h.h.hr().postDelayed(this.aYj, 200L);
        return true;
    }
}
