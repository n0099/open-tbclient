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
    private int clB;
    private int clC;
    private int clD;
    private com.baidu.tieba.enterForum.a.c clE;
    private int clF;
    private Runnable clG;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clG = new Runnable() { // from class: com.baidu.tieba.enterForum.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.clF : -a.this.clF, 200);
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
            this.clE = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void av(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.clB && pointToPosition != -1) {
            this.clE.iM(pointToPosition);
            this.clE.as(this.clB, pointToPosition);
            this.clB = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.clC = (int) motionEvent.getRawX();
        this.clD = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.afr().afs()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(this.clG);
                    com.baidu.tieba.enterForum.model.a.afr().afv();
                    this.clE.iM(-1);
                    this.clE.abn();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.clF, getHeight());
                    com.baidu.tieba.enterForum.model.a.afr().at(this.clC, this.clD - this.mOffset);
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
        this.clB = i;
        com.baidu.tieba.enterForum.model.a.afr().a(getContext(), view, this.clC, this.clD);
        this.clE.iM(i);
        this.clE.abn();
        this.clF = view.getHeight();
        com.baidu.adp.lib.g.e.fP().postDelayed(this.clG, 200L);
        return true;
    }
}
