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
    private int aFI;
    private int aFJ;
    private int aFK;
    private com.baidu.tieba.enterForum.a.c aFL;
    private int aFM;
    private Runnable aFN;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFN = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aFL = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void K(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aFI && pointToPosition != -1) {
            this.aFL.eC(pointToPosition);
            this.aFL.H(this.aFI, pointToPosition);
            this.aFI = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aFJ = (int) motionEvent.getRawX();
        this.aFK = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.HU().HV()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.i.hs().removeCallbacks(this.aFN);
                    com.baidu.tieba.enterForum.c.a.HU().HY();
                    this.aFL.eC(-1);
                    this.aFL.Hw();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.HZ().a(motionEvent.getY(), this.aFM, getHeight());
                    com.baidu.tieba.enterForum.c.a.HU().I(this.aFJ, this.aFK - this.mOffset);
                    K((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.aFI = i;
        com.baidu.tieba.enterForum.c.a.HU().a(getContext(), view, this.aFJ, this.aFK);
        this.aFL.eC(i);
        this.aFL.Hw();
        this.aFM = view.getHeight();
        com.baidu.adp.lib.g.i.hs().postDelayed(this.aFN, 200L);
        return true;
    }
}
