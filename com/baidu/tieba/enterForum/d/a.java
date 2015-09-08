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
    private int aNu;
    private int aNv;
    private int aNw;
    private com.baidu.tieba.enterForum.a.c aNx;
    private int aNy;
    private Runnable aNz;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNz = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.aNx = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void U(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.aNu && pointToPosition != -1) {
            this.aNx.eP(pointToPosition);
            this.aNx.R(this.aNu, pointToPosition);
            this.aNu = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aNv = (int) motionEvent.getRawX();
        this.aNw = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.Iv().Iw()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.hf().removeCallbacks(this.aNz);
                    com.baidu.tieba.enterForum.c.a.Iv().Iz();
                    this.aNx.eP(-1);
                    this.aNx.HZ();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.IA().a(motionEvent.getY(), this.aNy, getHeight());
                    com.baidu.tieba.enterForum.c.a.Iv().S(this.aNv, this.aNw - this.mOffset);
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
        this.aNu = i;
        com.baidu.tieba.enterForum.c.a.Iv().a(getContext(), view, this.aNv, this.aNw);
        this.aNx.eP(i);
        this.aNx.HZ();
        this.aNy = view.getHeight();
        com.baidu.adp.lib.g.h.hf().postDelayed(this.aNz, 200L);
        return true;
    }
}
