package com.baidu.tieba.enterForum.c;

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
    private int bUf;
    private int bUg;
    private int bUh;
    private com.baidu.tieba.enterForum.a.e bUi;
    private int bUj;
    private Runnable bUk;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUk = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.e) {
            this.bUi = (com.baidu.tieba.enterForum.a.e) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void am(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bUf && pointToPosition != -1) {
            this.bUi.hT(pointToPosition);
            this.bUi.aj(this.bUf, pointToPosition);
            this.bUf = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bUg = (int) motionEvent.getRawX();
        this.bUh = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.aaT().aaU()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bUk);
                    com.baidu.tieba.enterForum.model.a.aaT().aaX();
                    this.bUi.hT(-1);
                    this.bUi.WT();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.bUj, getHeight());
                    com.baidu.tieba.enterForum.model.a.aaT().ak(this.bUg, this.bUh - this.mOffset);
                    am((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.bUf = i;
        com.baidu.tieba.enterForum.model.a.aaT().a(getContext(), view, this.bUg, this.bUh);
        this.bUi.hT(i);
        this.bUi.WT();
        this.bUj = view.getHeight();
        com.baidu.adp.lib.g.h.fR().postDelayed(this.bUk, 200L);
        return true;
    }
}
