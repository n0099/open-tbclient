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
    private int aVR;
    private int aVS;
    private int aVT;
    private com.baidu.tieba.enterForum.a.c aVU;
    private int aVV;
    private Runnable aVW;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aVW = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aVU = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void V(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aVR && pointToPosition != -1) {
            this.aVU.fm(pointToPosition);
            this.aVU.S(this.aVR, pointToPosition);
            this.aVR = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aVS = (int) motionEvent.getRawX();
        this.aVT = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.Ko().Kp()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.hj().removeCallbacks(this.aVW);
                    com.baidu.tieba.enterForum.c.a.Ko().Ks();
                    this.aVU.fm(-1);
                    this.aVU.JP();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.Kt().a(motionEvent.getY(), this.aVV, getHeight());
                    com.baidu.tieba.enterForum.c.a.Ko().T(this.aVS, this.aVT - this.mOffset);
                    V((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.aVR = i;
        com.baidu.tieba.enterForum.c.a.Ko().a(getContext(), view, this.aVS, this.aVT);
        this.aVU.fm(i);
        this.aVU.JP();
        this.aVV = view.getHeight();
        com.baidu.adp.lib.h.h.hj().postDelayed(this.aVW, 200L);
        return true;
    }
}
