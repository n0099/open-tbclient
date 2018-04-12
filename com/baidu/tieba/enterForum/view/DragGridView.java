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
    private int cJa;
    private int cJb;
    private int cJc;
    private com.baidu.tieba.enterForum.a.c cJd;
    private int cJe;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.cJe : -DragGridView.this.cJe, 200);
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
            this.cJd = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aw(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cJa && pointToPosition != -1) {
            this.cJd.jw(pointToPosition);
            this.cJd.as(this.cJa, pointToPosition);
            this.cJa = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cJb = (int) motionEvent.getRawX();
        this.cJc = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.akX().akY()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.fw().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.akX().alb();
                    this.cJd.jw(-1);
                    this.cJd.agD();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.cJe, getHeight());
                    com.baidu.tieba.enterForum.model.a.akX().au(this.cJb, this.cJc - this.mOffset);
                    aw((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cJa = i;
        com.baidu.tieba.enterForum.model.a.akX().a(getContext(), view2, this.cJb, this.cJc);
        this.cJd.jw(i);
        this.cJd.agD();
        this.cJe = view2.getHeight();
        e.fw().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
