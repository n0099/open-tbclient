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
    private int cdg;
    private int cdh;
    private int cdi;
    private com.baidu.tieba.enterForum.a.c cdj;
    private int cdk;
    private Runnable cdl;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdl = new Runnable() { // from class: com.baidu.tieba.enterForum.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.cdk : -a.this.cdk, 200);
                }
                com.baidu.adp.lib.g.e.fQ().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.cdj = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void al(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cdg && pointToPosition != -1) {
            this.cdj.im(pointToPosition);
            this.cdj.ai(this.cdg, pointToPosition);
            this.cdg = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cdh = (int) motionEvent.getRawX();
        this.cdi = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.adb().adc()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.cdl);
                    com.baidu.tieba.enterForum.model.a.adb().adf();
                    this.cdj.im(-1);
                    this.cdj.Zb();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.cdk, getHeight());
                    com.baidu.tieba.enterForum.model.a.adb().aj(this.cdh, this.cdi - this.mOffset);
                    al((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cdg = i;
        com.baidu.tieba.enterForum.model.a.adb().a(getContext(), view, this.cdh, this.cdi);
        this.cdj.im(i);
        this.cdj.Zb();
        this.cdk = view.getHeight();
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.cdl, 200L);
        return true;
    }
}
