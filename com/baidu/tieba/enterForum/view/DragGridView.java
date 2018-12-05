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
/* loaded from: classes4.dex */
public class DragGridView extends GridView implements AdapterView.OnItemLongClickListener {
    private int dpH;
    private int dpI;
    private int dpJ;
    private com.baidu.tieba.enterForum.a.c dpK;
    private int dpL;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.dpL : -DragGridView.this.dpL, 200);
                }
                e.jG().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.dpK = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aI(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dpH && pointToPosition != -1) {
            this.dpK.ll(pointToPosition);
            this.dpK.aF(this.dpH, pointToPosition);
            this.dpH = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dpI = (int) motionEvent.getRawX();
        this.dpJ = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.avt().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.jG().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.avt().avw();
                    this.dpK.ll(-1);
                    this.dpK.notifyDataChanged();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.dpL, getHeight());
                    com.baidu.tieba.enterForum.model.a.avt().aG(this.dpI, this.dpJ - this.mOffset);
                    aI((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.dpH = i;
        com.baidu.tieba.enterForum.model.a.avt().a(getContext(), view, this.dpI, this.dpJ);
        this.dpK.ll(i);
        this.dpK.notifyDataChanged();
        this.dpL = view.getHeight();
        e.jG().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
