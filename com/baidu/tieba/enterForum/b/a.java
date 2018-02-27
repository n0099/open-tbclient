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
/* loaded from: classes2.dex */
public class a extends GridView implements AdapterView.OnItemLongClickListener {
    private Runnable YE;
    private int dqv;
    private int dqw;
    private int dqx;
    private com.baidu.tieba.enterForum.a.c dqy;
    private int dqz;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YE = new Runnable() { // from class: com.baidu.tieba.enterForum.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.dqz : -a.this.dqz, 200);
                }
                com.baidu.adp.lib.g.e.ns().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.dqy = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void bs(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dqv && pointToPosition != -1) {
            this.dqy.mk(pointToPosition);
            this.dqy.bp(this.dqv, pointToPosition);
            this.dqv = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dqw = (int) motionEvent.getRawX();
        this.dqx = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.aqI().aqJ()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.ns().removeCallbacks(this.YE);
                    com.baidu.tieba.enterForum.model.a.aqI().aqM();
                    this.dqy.mk(-1);
                    this.dqy.amC();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.dqz, getHeight());
                    com.baidu.tieba.enterForum.model.a.aqI().bq(this.dqw, this.dqx - this.mOffset);
                    bs((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.dqv = i;
        com.baidu.tieba.enterForum.model.a.aqI().a(getContext(), view, this.dqw, this.dqx);
        this.dqy.mk(i);
        this.dqy.amC();
        this.dqz = view.getHeight();
        com.baidu.adp.lib.g.e.ns().postDelayed(this.YE, 200L);
        return true;
    }
}
