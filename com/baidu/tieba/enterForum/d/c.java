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
    private int bqL;
    private int bqM;
    private int bqN;
    private com.baidu.tieba.enterForum.a.d bqO;
    private int bqP;
    private Runnable bqQ;
    private int mOffset;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqQ = new d(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.d) {
            this.bqO = (com.baidu.tieba.enterForum.a.d) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aa(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bqL && pointToPosition != -1) {
            this.bqO.gy(pointToPosition);
            this.bqO.X(this.bqL, pointToPosition);
            this.bqL = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bqM = (int) motionEvent.getRawX();
        this.bqN = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.Tm().Tn()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bqQ);
                    com.baidu.tieba.enterForum.c.a.Tm().Tq();
                    this.bqO.gy(-1);
                    this.bqO.SD();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.a(motionEvent.getY(), this.bqP, getHeight());
                    com.baidu.tieba.enterForum.c.a.Tm().Y(this.bqM, this.bqN - this.mOffset);
                    aa((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.bqL = i;
        com.baidu.tieba.enterForum.c.a.Tm().a(getContext(), view, this.bqM, this.bqN);
        this.bqO.gy(i);
        this.bqO.SD();
        this.bqP = view.getHeight();
        com.baidu.adp.lib.h.h.eG().postDelayed(this.bqQ, 200L);
        return true;
    }
}
