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
    private Runnable YL;
    private int dns;
    private int dnt;
    private int dnu;
    private com.baidu.tieba.enterForum.a.c dnv;
    private int dnw;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YL = new Runnable() { // from class: com.baidu.tieba.enterForum.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.dnw : -a.this.dnw, 200);
                }
                com.baidu.adp.lib.g.e.nr().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.dnv = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void bu(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dns && pointToPosition != -1) {
            this.dnv.mn(pointToPosition);
            this.dnv.br(this.dns, pointToPosition);
            this.dns = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dnt = (int) motionEvent.getRawX();
        this.dnu = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.apO().apP()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.nr().removeCallbacks(this.YL);
                    com.baidu.tieba.enterForum.model.a.apO().apS();
                    this.dnv.mn(-1);
                    this.dnv.alO();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.dnw, getHeight());
                    com.baidu.tieba.enterForum.model.a.apO().bs(this.dnt, this.dnu - this.mOffset);
                    bu((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.dns = i;
        com.baidu.tieba.enterForum.model.a.apO().a(getContext(), view, this.dnt, this.dnu);
        this.dnv.mn(i);
        this.dnv.alO();
        this.dnw = view.getHeight();
        com.baidu.adp.lib.g.e.nr().postDelayed(this.YL, 200L);
        return true;
    }
}
