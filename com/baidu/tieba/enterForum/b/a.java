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
    private int cli;
    private int clj;
    private int clk;
    private com.baidu.tieba.enterForum.a.c cll;
    private int clm;
    private Runnable cln;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cln = new Runnable() { // from class: com.baidu.tieba.enterForum.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.clm : -a.this.clm, 200);
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
            this.cll = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void av(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cli && pointToPosition != -1) {
            this.cll.iO(pointToPosition);
            this.cll.as(this.cli, pointToPosition);
            this.cli = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.clj = (int) motionEvent.getRawX();
        this.clk = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.afd().afe()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cln);
                    com.baidu.tieba.enterForum.model.a.afd().afh();
                    this.cll.iO(-1);
                    this.cll.abb();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.clm, getHeight());
                    com.baidu.tieba.enterForum.model.a.afd().at(this.clj, this.clk - this.mOffset);
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
        this.cli = i;
        com.baidu.tieba.enterForum.model.a.afd().a(getContext(), view, this.clj, this.clk);
        this.cll.iO(i);
        this.cll.abb();
        this.clm = view.getHeight();
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cln, 200L);
        return true;
    }
}
