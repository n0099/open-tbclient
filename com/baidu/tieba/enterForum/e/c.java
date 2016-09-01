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
    private int bHL;
    private int bHM;
    private int bHN;
    private com.baidu.tieba.enterForum.a.d bHO;
    private int bHP;
    private Runnable bHQ;
    private int mOffset;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHQ = new d(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.d) {
            this.bHO = (com.baidu.tieba.enterForum.a.d) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void ad(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bHL && pointToPosition != -1) {
            this.bHO.hj(pointToPosition);
            this.bHO.aa(this.bHL, pointToPosition);
            this.bHL = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bHM = (int) motionEvent.getRawX();
        this.bHN = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.XD().XE()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bHQ);
                    com.baidu.tieba.enterForum.c.a.XD().XH();
                    this.bHO.hj(-1);
                    this.bHO.WX();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.XI().a(motionEvent.getY(), this.bHP, getHeight());
                    com.baidu.tieba.enterForum.c.a.XD().ab(this.bHM, this.bHN - this.mOffset);
                    ad((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.bHL = i;
        com.baidu.tieba.enterForum.c.a.XD().a(getContext(), view, this.bHM, this.bHN);
        this.bHO.hj(i);
        this.bHO.WX();
        this.bHP = view.getHeight();
        com.baidu.adp.lib.h.h.eG().postDelayed(this.bHQ, 200L);
        return true;
    }
}
