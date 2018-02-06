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
    private Runnable YK;
    private int dqH;
    private int dqI;
    private int dqJ;
    private com.baidu.tieba.enterForum.a.c dqK;
    private int dqL;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YK = new Runnable() { // from class: com.baidu.tieba.enterForum.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.dqL : -a.this.dqL, 200);
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
            this.dqK = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void bs(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dqH && pointToPosition != -1) {
            this.dqK.mk(pointToPosition);
            this.dqK.bp(this.dqH, pointToPosition);
            this.dqH = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dqI = (int) motionEvent.getRawX();
        this.dqJ = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.aqJ().aqK()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.ns().removeCallbacks(this.YK);
                    com.baidu.tieba.enterForum.model.a.aqJ().aqN();
                    this.dqK.mk(-1);
                    this.dqK.amD();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.dqL, getHeight());
                    com.baidu.tieba.enterForum.model.a.aqJ().bq(this.dqI, this.dqJ - this.mOffset);
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
        this.dqH = i;
        com.baidu.tieba.enterForum.model.a.aqJ().a(getContext(), view, this.dqI, this.dqJ);
        this.dqK.mk(i);
        this.dqK.amD();
        this.dqL = view.getHeight();
        com.baidu.adp.lib.g.e.ns().postDelayed(this.YK, 200L);
        return true;
    }
}
