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
    private int aFH;
    private int aFI;
    private int aFJ;
    private com.baidu.tieba.enterForum.a.c aFK;
    private int aFL;
    private Runnable aFM;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFM = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aFK = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void K(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aFH && pointToPosition != -1) {
            this.aFK.eC(pointToPosition);
            this.aFK.H(this.aFH, pointToPosition);
            this.aFH = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aFI = (int) motionEvent.getRawX();
        this.aFJ = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.HT().HU()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.i.hs().removeCallbacks(this.aFM);
                    com.baidu.tieba.enterForum.c.a.HT().HX();
                    this.aFK.eC(-1);
                    this.aFK.Hv();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.HY().a(motionEvent.getY(), this.aFL, getHeight());
                    com.baidu.tieba.enterForum.c.a.HT().I(this.aFI, this.aFJ - this.mOffset);
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
        this.aFH = i;
        com.baidu.tieba.enterForum.c.a.HT().a(getContext(), view, this.aFI, this.aFJ);
        this.aFK.eC(i);
        this.aFK.Hv();
        this.aFL = view.getHeight();
        com.baidu.adp.lib.g.i.hs().postDelayed(this.aFM, 200L);
        return true;
    }
}
