package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes2.dex */
public class DragGridView extends GridView implements AdapterView.OnItemLongClickListener {
    private int cKg;
    private int cKh;
    private int cKi;
    private com.baidu.tieba.enterForum.a.c cKj;
    private int cKk;
    private int mOffset;
    private Runnable mScrollRunnable;

    public DragGridView(Context context) {
        this(context, null);
    }

    public DragGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.enterForum.view.DragGridView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DragGridView.this.mOffset != 0) {
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.cKk : -DragGridView.this.cKk, 200);
                }
                e.fw().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.cKj = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void av(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cKg && pointToPosition != -1) {
            this.cKj.ju(pointToPosition);
            this.cKj.ar(this.cKg, pointToPosition);
            this.cKg = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cKh = (int) motionEvent.getRawX();
        this.cKi = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.akX().akY()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.fw().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.akX().alb();
                    this.cKj.ju(-1);
                    this.cKj.agD();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.cKk, getHeight());
                    com.baidu.tieba.enterForum.model.a.akX().at(this.cKh, this.cKi - this.mOffset);
                    av((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cKg = i;
        com.baidu.tieba.enterForum.model.a.akX().a(getContext(), view2, this.cKh, this.cKi);
        this.cKj.ju(i);
        this.cKj.agD();
        this.cKk = view2.getHeight();
        e.fw().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
