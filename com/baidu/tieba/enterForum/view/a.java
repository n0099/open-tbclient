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
    private int buj;
    private int buk;
    private int bul;
    private com.baidu.tieba.enterForum.a.d bum;
    private int bun;
    private Runnable buo;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buo = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.d) {
            this.bum = (com.baidu.tieba.enterForum.a.d) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void X(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.buj && pointToPosition != -1) {
            this.bum.gH(pointToPosition);
            this.bum.U(this.buj, pointToPosition);
            this.buj = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.buk = (int) motionEvent.getRawX();
        this.bul = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.Sk().Sl()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.dM().removeCallbacks(this.buo);
                    com.baidu.tieba.enterForum.c.a.Sk().So();
                    this.bum.gH(-1);
                    this.bum.RE();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.Sp().a(motionEvent.getY(), this.bun, getHeight());
                    com.baidu.tieba.enterForum.c.a.Sk().V(this.buk, this.bul - this.mOffset);
                    X((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.buj = i;
        com.baidu.tieba.enterForum.c.a.Sk().a(getContext(), view, this.buk, this.bul);
        this.bum.gH(i);
        this.bum.RE();
        this.bun = view.getHeight();
        com.baidu.adp.lib.h.h.dM().postDelayed(this.buo, 200L);
        return true;
    }
}
