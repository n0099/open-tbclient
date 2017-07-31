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
    private int bZA;
    private int bZB;
    private com.baidu.tieba.enterForum.a.c bZC;
    private int bZD;
    private Runnable bZE;
    private int bZz;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZE = new Runnable() { // from class: com.baidu.tieba.enterForum.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.bZD : -a.this.bZD, 200);
                }
                com.baidu.adp.lib.g.e.ga().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.bZC = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void am(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bZz && pointToPosition != -1) {
            this.bZC.ia(pointToPosition);
            this.bZC.aj(this.bZz, pointToPosition);
            this.bZz = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bZA = (int) motionEvent.getRawX();
        this.bZB = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.abK().abL()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bZE);
                    com.baidu.tieba.enterForum.model.a.abK().abO();
                    this.bZC.ia(-1);
                    this.bZC.XG();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.bZD, getHeight());
                    com.baidu.tieba.enterForum.model.a.abK().ak(this.bZA, this.bZB - this.mOffset);
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
        this.bZz = i;
        com.baidu.tieba.enterForum.model.a.abK().a(getContext(), view, this.bZA, this.bZB);
        this.bZC.ia(i);
        this.bZC.XG();
        this.bZD = view.getHeight();
        com.baidu.adp.lib.g.e.ga().postDelayed(this.bZE, 200L);
        return true;
    }
}
