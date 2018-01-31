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
    private int dnN;
    private int dnO;
    private int dnP;
    private com.baidu.tieba.enterForum.a.c dnQ;
    private int dnR;
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
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.dnR : -a.this.dnR, 200);
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
            this.dnQ = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void bu(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dnN && pointToPosition != -1) {
            this.dnQ.mn(pointToPosition);
            this.dnQ.br(this.dnN, pointToPosition);
            this.dnN = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dnO = (int) motionEvent.getRawX();
        this.dnP = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.apT().apU()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.ns().removeCallbacks(this.YL);
                    com.baidu.tieba.enterForum.model.a.apT().apX();
                    this.dnQ.mn(-1);
                    this.dnQ.alT();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.dnR, getHeight());
                    com.baidu.tieba.enterForum.model.a.apT().bs(this.dnO, this.dnP - this.mOffset);
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
        this.dnN = i;
        com.baidu.tieba.enterForum.model.a.apT().a(getContext(), view, this.dnO, this.dnP);
        this.dnQ.mn(i);
        this.dnQ.alT();
        this.dnR = view.getHeight();
        com.baidu.adp.lib.g.e.ns().postDelayed(this.YL, 200L);
        return true;
    }
}
