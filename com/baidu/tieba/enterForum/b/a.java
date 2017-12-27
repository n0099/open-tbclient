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
    private int diR;
    private int diS;
    private int diT;
    private com.baidu.tieba.enterForum.a.c diU;
    private int diV;
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
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.diV : -a.this.diV, 200);
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
            this.diU = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void bu(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.diR && pointToPosition != -1) {
            this.diU.mk(pointToPosition);
            this.diU.br(this.diR, pointToPosition);
            this.diR = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.diS = (int) motionEvent.getRawX();
        this.diT = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.aoL().aoM()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.nr().removeCallbacks(this.YL);
                    com.baidu.tieba.enterForum.model.a.aoL().aoP();
                    this.diU.mk(-1);
                    this.diU.akL();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.diV, getHeight());
                    com.baidu.tieba.enterForum.model.a.aoL().bs(this.diS, this.diT - this.mOffset);
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
        this.diR = i;
        com.baidu.tieba.enterForum.model.a.aoL().a(getContext(), view, this.diS, this.diT);
        this.diU.mk(i);
        this.diU.akL();
        this.diV = view.getHeight();
        com.baidu.adp.lib.g.e.nr().postDelayed(this.YL, 200L);
        return true;
    }
}
