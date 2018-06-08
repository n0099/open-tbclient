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
    private int cTm;
    private int cTn;
    private int cTo;
    private com.baidu.tieba.enterForum.a.c cTp;
    private int cTq;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.cTq : -DragGridView.this.cTq, 200);
                }
                e.im().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.cTp = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void ax(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cTm && pointToPosition != -1) {
            this.cTp.jx(pointToPosition);
            this.cTp.at(this.cTm, pointToPosition);
            this.cTm = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cTn = (int) motionEvent.getRawX();
        this.cTo = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.apd().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.im().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.apd().apg();
                    this.cTp.jx(-1);
                    this.cTp.akl();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.cTq, getHeight());
                    com.baidu.tieba.enterForum.model.a.apd().av(this.cTn, this.cTo - this.mOffset);
                    ax((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cTm = i;
        com.baidu.tieba.enterForum.model.a.apd().a(getContext(), view, this.cTn, this.cTo);
        this.cTp.jx(i);
        this.cTp.akl();
        this.cTq = view.getHeight();
        e.im().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
