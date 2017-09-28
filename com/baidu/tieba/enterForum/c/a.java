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
    private int cdZ;
    private int cea;
    private int ceb;
    private com.baidu.tieba.enterForum.a.c cec;
    private int ced;
    private Runnable cee;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cee = new Runnable() { // from class: com.baidu.tieba.enterForum.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.ced : -a.this.ced, 200);
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
            this.cec = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void au(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cdZ && pointToPosition != -1) {
            this.cec.iw(pointToPosition);
            this.cec.ar(this.cdZ, pointToPosition);
            this.cdZ = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cea = (int) motionEvent.getRawX();
        this.ceb = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.acZ().ada()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cee);
                    com.baidu.tieba.enterForum.model.a.acZ().add();
                    this.cec.iw(-1);
                    this.cec.YV();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.ced, getHeight());
                    com.baidu.tieba.enterForum.model.a.acZ().as(this.cea, this.ceb - this.mOffset);
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
        this.cdZ = i;
        com.baidu.tieba.enterForum.model.a.acZ().a(getContext(), view, this.cea, this.ceb);
        this.cec.iw(i);
        this.cec.YV();
        this.ced = view.getHeight();
        com.baidu.adp.lib.g.e.fP().postDelayed(this.cee, 200L);
        return true;
    }
}
