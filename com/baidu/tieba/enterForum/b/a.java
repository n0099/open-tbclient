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
    private int cuu;
    private int cuv;
    private int cuw;
    private com.baidu.tieba.enterForum.a.c cux;
    private int cuy;
    private Runnable cuz;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cuz = new Runnable() { // from class: com.baidu.tieba.enterForum.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.cuy : -a.this.cuy, 200);
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
            this.cux = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void av(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cuu && pointToPosition != -1) {
            this.cux.jm(pointToPosition);
            this.cux.as(this.cuu, pointToPosition);
            this.cuu = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cuv = (int) motionEvent.getRawX();
        this.cuw = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.ahk().ahl()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cuz);
                    com.baidu.tieba.enterForum.model.a.ahk().aho();
                    this.cux.jm(-1);
                    this.cux.adf();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.cuy, getHeight());
                    com.baidu.tieba.enterForum.model.a.ahk().at(this.cuv, this.cuw - this.mOffset);
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
        this.cuu = i;
        com.baidu.tieba.enterForum.model.a.ahk().a(getContext(), view, this.cuv, this.cuw);
        this.cux.jm(i);
        this.cux.adf();
        this.cuy = view.getHeight();
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cuz, 200L);
        return true;
    }
}
