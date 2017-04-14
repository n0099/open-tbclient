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
    private com.baidu.tieba.enterForum.a.d bFA;
    private int bFB;
    private Runnable bFC;
    private int bFx;
    private int bFy;
    private int bFz;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFC = new b(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.d) {
            this.bFA = (com.baidu.tieba.enterForum.a.d) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void af(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bFx && pointToPosition != -1) {
            this.bFA.hj(pointToPosition);
            this.bFA.ac(this.bFx, pointToPosition);
            this.bFx = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bFy = (int) motionEvent.getRawX();
        this.bFz = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.Wb().Wc()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bFC);
                    com.baidu.tieba.enterForum.model.a.Wb().Wf();
                    this.bFA.hj(-1);
                    this.bFA.Uf();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.bFB, getHeight());
                    com.baidu.tieba.enterForum.model.a.Wb().ad(this.bFy, this.bFz - this.mOffset);
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
        this.bFx = i;
        com.baidu.tieba.enterForum.model.a.Wb().a(getContext(), view, this.bFy, this.bFz);
        this.bFA.hj(i);
        this.bFA.Uf();
        this.bFB = view.getHeight();
        com.baidu.adp.lib.g.h.fR().postDelayed(this.bFC, 200L);
        return true;
    }
}
