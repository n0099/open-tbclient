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
    private int cdN;
    private int cdO;
    private int cdP;
    private com.baidu.tieba.enterForum.a.c cdQ;
    private int cdR;
    private Runnable cdS;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdS = new Runnable() { // from class: com.baidu.tieba.enterForum.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.cdR : -a.this.cdR, 200);
                }
                com.baidu.adp.lib.g.e.fP().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.cdQ = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void au(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cdN && pointToPosition != -1) {
            this.cdQ.iv(pointToPosition);
            this.cdQ.ar(this.cdN, pointToPosition);
            this.cdN = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cdO = (int) motionEvent.getRawX();
        this.cdP = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.acV().acW()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cdS);
                    com.baidu.tieba.enterForum.model.a.acV().acZ();
                    this.cdQ.iv(-1);
                    this.cdQ.YR();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.cdR, getHeight());
                    com.baidu.tieba.enterForum.model.a.acV().as(this.cdO, this.cdP - this.mOffset);
                    au((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cdN = i;
        com.baidu.tieba.enterForum.model.a.acV().a(getContext(), view, this.cdO, this.cdP);
        this.cdQ.iv(i);
        this.cdQ.YR();
        this.cdR = view.getHeight();
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cdS, 200L);
        return true;
    }
}
