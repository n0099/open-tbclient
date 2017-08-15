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
    private int cal;
    private int cam;
    private int can;
    private com.baidu.tieba.enterForum.a.c cao;
    private int cap;
    private Runnable caq;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.caq = new Runnable() { // from class: com.baidu.tieba.enterForum.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.cap : -a.this.cap, 200);
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
            this.cao = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void am(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cal && pointToPosition != -1) {
            this.cao.ic(pointToPosition);
            this.cao.aj(this.cal, pointToPosition);
            this.cal = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cam = (int) motionEvent.getRawX();
        this.can = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.acf().acg()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.ga().removeCallbacks(this.caq);
                    com.baidu.tieba.enterForum.model.a.acf().acj();
                    this.cao.ic(-1);
                    this.cao.Yb();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.cap, getHeight());
                    com.baidu.tieba.enterForum.model.a.acf().ak(this.cam, this.can - this.mOffset);
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
        this.cal = i;
        com.baidu.tieba.enterForum.model.a.acf().a(getContext(), view, this.cam, this.can);
        this.cao.ic(i);
        this.cao.Yb();
        this.cap = view.getHeight();
        com.baidu.adp.lib.g.e.ga().postDelayed(this.caq, 200L);
        return true;
    }
}
