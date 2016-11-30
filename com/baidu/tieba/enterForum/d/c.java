package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class c extends ListView implements AdapterView.OnItemLongClickListener {
    private int bKH;
    private int bKI;
    private int bKJ;
    private com.baidu.tieba.enterForum.a.d bKK;
    private int bKL;
    private Runnable bKM;
    private int mOffset;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKM = new d(this);
        setOnItemLongClickListener(this);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.d) {
            this.bKK = (com.baidu.tieba.enterForum.a.d) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void af(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.bKH && pointToPosition != -1) {
            this.bKK.ho(pointToPosition);
            this.bKK.ac(this.bKH, pointToPosition);
            this.bKH = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bKI = (int) motionEvent.getRawX();
        this.bKJ = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.c.a.YZ().Za()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bKM);
                    com.baidu.tieba.enterForum.c.a.YZ().Zd();
                    this.bKK.ho(-1);
                    this.bKK.Ys();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.c.b.a(motionEvent.getY(), this.bKL, getHeight());
                    com.baidu.tieba.enterForum.c.a.YZ().ad(this.bKI, this.bKJ - this.mOffset);
                    af((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.bKH = i;
        com.baidu.tieba.enterForum.c.a.YZ().a(getContext(), view, this.bKI, this.bKJ);
        this.bKK.ho(i);
        this.bKK.Ys();
        this.bKL = view.getHeight();
        com.baidu.adp.lib.h.h.eG().postDelayed(this.bKM, 200L);
        return true;
    }
}
