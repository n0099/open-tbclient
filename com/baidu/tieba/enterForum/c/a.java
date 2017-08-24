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
    private int cam;
    private int can;
    private int cao;
    private com.baidu.tieba.enterForum.a.c cap;
    private int caq;
    private Runnable car;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.car = new Runnable() { // from class: com.baidu.tieba.enterForum.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.caq : -a.this.caq, 200);
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
            this.cap = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void am(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cam && pointToPosition != -1) {
            this.cap.ic(pointToPosition);
            this.cap.aj(this.cam, pointToPosition);
            this.cam = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.can = (int) motionEvent.getRawX();
        this.cao = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.acb().acc()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.ga().removeCallbacks(this.car);
                    com.baidu.tieba.enterForum.model.a.acb().acf();
                    this.cap.ic(-1);
                    this.cap.XY();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.caq, getHeight());
                    com.baidu.tieba.enterForum.model.a.acb().ak(this.can, this.cao - this.mOffset);
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
        this.cam = i;
        com.baidu.tieba.enterForum.model.a.acb().a(getContext(), view, this.can, this.cao);
        this.cap.ic(i);
        this.cap.XY();
        this.caq = view.getHeight();
        com.baidu.adp.lib.g.e.ga().postDelayed(this.car, 200L);
        return true;
    }
}
