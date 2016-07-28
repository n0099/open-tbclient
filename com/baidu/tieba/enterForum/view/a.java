package com.baidu.tieba.enterForum.view;

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
    private com.baidu.tieba.enterForum.a.d bwA;
    private int bwB;
    private Runnable bwC;
    private int bwx;
    private int bwy;
    private int bwz;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwC = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.d) {
            this.bwA = (com.baidu.tieba.enterForum.a.d) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void Y(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bwx && pointToPosition != -1) {
            this.bwA.gH(pointToPosition);
            this.bwA.V(this.bwx, pointToPosition);
            this.bwx = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bwy = (int) motionEvent.getRawX();
        this.bwz = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.SS().ST()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.dL().removeCallbacks(this.bwC);
                    com.baidu.tieba.enterForum.c.a.SS().SW();
                    this.bwA.gH(-1);
                    this.bwA.Sl();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.SX().a(motionEvent.getY(), this.bwB, getHeight());
                    com.baidu.tieba.enterForum.c.a.SS().W(this.bwy, this.bwz - this.mOffset);
                    Y((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.bwx = i;
        com.baidu.tieba.enterForum.c.a.SS().a(getContext(), view, this.bwy, this.bwz);
        this.bwA.gH(i);
        this.bwA.Sl();
        this.bwB = view.getHeight();
        com.baidu.adp.lib.h.h.dL().postDelayed(this.bwC, 200L);
        return true;
    }
}
