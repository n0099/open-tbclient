package com.baidu.tieba.enterForum.c;

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
    private int bFE;
    private int bFF;
    private int bFG;
    private com.baidu.tieba.enterForum.a.d bFH;
    private int bFI;
    private Runnable bFJ;
    private int mOffset;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFJ = new d(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.d) {
            this.bFH = (com.baidu.tieba.enterForum.a.d) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void af(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bFE && pointToPosition != -1) {
            this.bFH.hg(pointToPosition);
            this.bFH.ac(this.bFE, pointToPosition);
            this.bFE = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bFF = (int) motionEvent.getRawX();
        this.bFG = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.VD().VE()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.fM().removeCallbacks(this.bFJ);
                    com.baidu.tieba.enterForum.model.a.VD().VH();
                    this.bFH.hg(-1);
                    this.bFH.TH();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.bFI, getHeight());
                    com.baidu.tieba.enterForum.model.a.VD().ad(this.bFF, this.bFG - this.mOffset);
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
        this.bFE = i;
        com.baidu.tieba.enterForum.model.a.VD().a(getContext(), view, this.bFF, this.bFG);
        this.bFH.hg(i);
        this.bFH.TH();
        this.bFI = view.getHeight();
        com.baidu.adp.lib.g.h.fM().postDelayed(this.bFJ, 200L);
        return true;
    }
}
