package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class SimpleDragSortListView extends BdListView {
    private c ezO;
    private AttributeSet ezP;
    private final d ezQ;

    public SimpleDragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezQ = new d() { // from class: com.baidu.tbadk.widget.dragsort.SimpleDragSortListView.1
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
        this.ezP = attributeSet;
    }

    public void setDragSortViewEventDelegate(c cVar) {
        this.ezO = cVar;
        cVar.a(this, getContext(), this.ezP);
    }

    public d getViewSuperMethods() {
        return this.ezQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.ezO != null) {
            this.ezO.setAdapter(listAdapter);
        } else {
            super.setAdapter(listAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.ezO != null) {
            this.ezO.dispatchDraw(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ezO != null) {
            this.ezO.onDraw(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ezO != null ? this.ezO.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.ezO != null ? this.ezO.onInterceptTouchEvent(motionEvent) : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.ezO != null) {
            this.ezO.onSizeChanged(i, i2, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ezO != null) {
            this.ezO.requestLayout();
        } else {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.ezO != null) {
            this.ezO.onMeasure(i, i2);
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        if (this.ezO != null) {
            this.ezO.layoutChildren();
        } else {
            super.layoutChildren();
        }
    }
}
