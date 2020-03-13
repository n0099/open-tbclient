package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class SimpleDragSortListView extends BdListView {
    private c dKN;
    private AttributeSet dKO;
    private final d dKP;

    public SimpleDragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKP = new d() { // from class: com.baidu.tbadk.widget.dragsort.SimpleDragSortListView.1
            @Override // com.baidu.tbadk.widget.dragsort.d
            public void setAdapter(ListAdapter listAdapter) {
                SimpleDragSortListView.super.setAdapter(listAdapter);
            }

            @Override // com.baidu.tbadk.widget.dragsort.d
            public void dispatchDraw(Canvas canvas) {
                SimpleDragSortListView.super.dispatchDraw(canvas);
            }

            @Override // com.baidu.tbadk.widget.dragsort.d
            public void onDraw(Canvas canvas) {
                SimpleDragSortListView.super.onDraw(canvas);
            }

            @Override // com.baidu.tbadk.widget.dragsort.d
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return SimpleDragSortListView.super.onTouchEvent(motionEvent);
            }

            @Override // com.baidu.tbadk.widget.dragsort.d
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return SimpleDragSortListView.super.onInterceptTouchEvent(motionEvent);
            }

            @Override // com.baidu.tbadk.widget.dragsort.d
            public void onSizeChanged(int i, int i2, int i3, int i4) {
                SimpleDragSortListView.super.onSizeChanged(i, i2, i3, i4);
            }

            @Override // com.baidu.tbadk.widget.dragsort.d
            public void requestLayout() {
                SimpleDragSortListView.super.requestLayout();
            }

            @Override // com.baidu.tbadk.widget.dragsort.d
            public void onMeasure(int i, int i2) {
                SimpleDragSortListView.super.onMeasure(i, i2);
            }

            @Override // com.baidu.tbadk.widget.dragsort.d
            public void layoutChildren() {
                SimpleDragSortListView.super.layoutChildren();
            }
        };
        this.dKO = attributeSet;
    }

    public void setDragSortViewEventDelegate(c cVar) {
        this.dKN = cVar;
        cVar.a(this, getContext(), this.dKO);
    }

    public d getViewSuperMethods() {
        return this.dKP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.dKN != null) {
            this.dKN.setAdapter(listAdapter);
        } else {
            super.setAdapter(listAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.dKN != null) {
            this.dKN.dispatchDraw(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dKN != null) {
            this.dKN.onDraw(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.dKN != null ? this.dKN.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.dKN != null ? this.dKN.onInterceptTouchEvent(motionEvent) : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.dKN != null) {
            this.dKN.onSizeChanged(i, i2, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.dKN != null) {
            this.dKN.requestLayout();
        } else {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.dKN != null) {
            this.dKN.onMeasure(i, i2);
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        if (this.dKN != null) {
            this.dKN.layoutChildren();
        } else {
            super.layoutChildren();
        }
    }
}
