package com.baidu.tieba.enterForum.b;

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
    private int cuq;
    private int cur;
    private int cus;
    private com.baidu.tieba.enterForum.a.c cut;
    private int cuu;
    private Runnable cuv;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cuv = new Runnable() { // from class: com.baidu.tieba.enterForum.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.cuu : -a.this.cuu, 200);
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
            this.cut = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void av(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cuq && pointToPosition != -1) {
            this.cut.jm(pointToPosition);
            this.cut.as(this.cuq, pointToPosition);
            this.cuq = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cur = (int) motionEvent.getRawX();
        this.cus = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.ahl().ahm()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cuv);
                    com.baidu.tieba.enterForum.model.a.ahl().ahp();
                    this.cut.jm(-1);
                    this.cut.adg();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.cuu, getHeight());
                    com.baidu.tieba.enterForum.model.a.ahl().at(this.cur, this.cus - this.mOffset);
                    av((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cuq = i;
        com.baidu.tieba.enterForum.model.a.ahl().a(getContext(), view, this.cur, this.cus);
        this.cut.jm(i);
        this.cut.adg();
        this.cuu = view.getHeight();
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cuv, 200L);
        return true;
    }
}
