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
    private int cuh;
    private int cui;
    private int cuj;
    private com.baidu.tieba.enterForum.a.c cuk;
    private int cul;
    private Runnable cum;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cum = new Runnable() { // from class: com.baidu.tieba.enterForum.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.cul : -a.this.cul, 200);
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
            this.cuk = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void au(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cuh && pointToPosition != -1) {
            this.cuk.jk(pointToPosition);
            this.cuk.ar(this.cuh, pointToPosition);
            this.cuh = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cui = (int) motionEvent.getRawX();
        this.cuj = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.ahd().ahe()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cum);
                    com.baidu.tieba.enterForum.model.a.ahd().ahh();
                    this.cuk.jk(-1);
                    this.cuk.acW();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.cul, getHeight());
                    com.baidu.tieba.enterForum.model.a.ahd().as(this.cui, this.cuj - this.mOffset);
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
        this.cuh = i;
        com.baidu.tieba.enterForum.model.a.ahd().a(getContext(), view, this.cui, this.cuj);
        this.cuk.jk(i);
        this.cuk.acW();
        this.cul = view.getHeight();
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cum, 200L);
        return true;
    }
}
