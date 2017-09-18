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
    private int cdY;
    private int cdZ;
    private int cea;
    private com.baidu.tieba.enterForum.a.c ceb;
    private int cec;
    private Runnable ced;
    private int mOffset;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ced = new Runnable() { // from class: com.baidu.tieba.enterForum.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mOffset != 0) {
                    a.this.smoothScrollBy(a.this.mOffset > 0 ? a.this.cec : -a.this.cec, 200);
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
            this.ceb = (com.baidu.tieba.enterForum.a.c) listAdapter;
        } else {
            BdLog.e("the adapter must be implements IDragAdapter");
        }
    }

    private void ap(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition != this.cdY && pointToPosition != -1) {
            this.ceb.io(pointToPosition);
            this.ceb.am(this.cdY, pointToPosition);
            this.cdY = pointToPosition;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cdZ = (int) motionEvent.getRawX();
        this.cea = (int) motionEvent.getRawY();
        if (com.baidu.tieba.enterForum.model.a.adm().adn()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.ced);
                    com.baidu.tieba.enterForum.model.a.adm().adq();
                    this.ceb.io(-1);
                    this.ceb.Zm();
                    break;
                case 2:
                    this.mOffset = com.baidu.tieba.enterForum.model.b.a(motionEvent.getY(), this.cec, getHeight());
                    com.baidu.tieba.enterForum.model.a.adm().an(this.cdZ, this.cea - this.mOffset);
                    ap((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.mOffset);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(getContext(), "list_drag_order", null);
        this.cdY = i;
        com.baidu.tieba.enterForum.model.a.adm().a(getContext(), view, this.cdZ, this.cea);
        this.ceb.io(i);
        this.ceb.Zm();
        this.cec = view.getHeight();
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.ced, 200L);
        return true;
    }
}
