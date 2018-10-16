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
    private int dhZ;
    private int dia;
    private int dib;
    private com.baidu.tieba.enterForum.a.c dic;
    private int did;
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
                    DragGridView.this.smoothScrollBy(DragGridView.this.mOffset > 0 ? DragGridView.this.did : -DragGridView.this.did, 200);
                }
                e.jI().postDelayed(this, 200L);
            }
        };
        setOnItemLongClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof com.baidu.tieba.enterForum.a.c) {
            this.dic = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void aG(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.dhZ && pointToPosition != -1) {
            this.dic.kD(pointToPosition);
            this.dic.aC(this.dhZ, pointToPosition);
            this.dhZ = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dia = (int) motionEvent.getRawX();
        this.dib = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.auj().isDragging()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    e.jI().removeCallbacks(this.mScrollRunnable);
                    com.baidu.tieba.enterForum.model.a.auj().aum();
                    this.dic.kD(-1);
                    this.dic.notifyDataChanged();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.b(motionEvent.getY(), this.did, getHeight());
                    com.baidu.tieba.enterForum.model.a.auj().aE(this.dia, this.dib - this.mOffset);
                    aG((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.dhZ = i;
        com.baidu.tieba.enterForum.model.a.auj().a(getContext(), view, this.dia, this.dib);
        this.dic.kD(i);
        this.dic.notifyDataChanged();
        this.did = view.getHeight();
        e.jI().postDelayed(this.mScrollRunnable, 200L);
        return true;
    }
}
