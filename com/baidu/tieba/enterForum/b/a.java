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
    private int dqA;
    private com.baidu.tieba.enterForum.a.c dqB;
    private int dqC;
    private int dqy;
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
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.dqC : -a.this.dqC, 200);
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
            this.dqB = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void bs(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dqy && pointToPosition != -1) {
            this.dqB.mk(pointToPosition);
            this.dqB.bp(this.dqy, pointToPosition);
            this.dqy = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dqz = (int) motionEvent.getRawX();
        this.dqA = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.aqJ().aqK()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.ns().removeCallbacks(this.YE);
                    com.baidu.tieba.enterForum.model.a.aqJ().aqN();
                    this.dqB.mk(-1);
                    this.dqB.amD();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.dqC, getHeight());
                    com.baidu.tieba.enterForum.model.a.aqJ().bq(this.dqz, this.dqA - this.mOffset);
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
        this.dqy = i;
        com.baidu.tieba.enterForum.model.a.aqJ().a(getContext(), view, this.dqz, this.dqA);
        this.dqB.mk(i);
        this.dqB.amD();
        this.dqC = view.getHeight();
        com.baidu.adp.lib.g.e.ns().postDelayed(this.YE, 200L);
        return true;
    }
}
