package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import d.b.i0.b1.e.c;
import d.b.i0.b1.e.d;
/* loaded from: classes3.dex */
public class SimpleDragSortListView extends BdListView {
    public c K;
    public AttributeSet L;
    public final d M;

    /* loaded from: classes3.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.b.i0.b1.e.d
        public void a() {
            SimpleDragSortListView.super.layoutChildren();
        }

        @Override // d.b.i0.b1.e.d
        public void b(Canvas canvas) {
            SimpleDragSortListView.super.dispatchDraw(canvas);
        }

        @Override // d.b.i0.b1.e.d
        public void c(ListAdapter listAdapter) {
            SimpleDragSortListView.super.setAdapter(listAdapter);
        }

        @Override // d.b.i0.b1.e.d
        public void onDraw(Canvas canvas) {
            SimpleDragSortListView.super.onDraw(canvas);
        }

        @Override // d.b.i0.b1.e.d
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return SimpleDragSortListView.super.onInterceptTouchEvent(motionEvent);
        }

        @Override // d.b.i0.b1.e.d
        public void onMeasure(int i, int i2) {
            SimpleDragSortListView.super.onMeasure(i, i2);
        }

        @Override // d.b.i0.b1.e.d
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            SimpleDragSortListView.super.onSizeChanged(i, i2, i3, i4);
        }

        @Override // d.b.i0.b1.e.d
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return SimpleDragSortListView.super.onTouchEvent(motionEvent);
        }

        @Override // d.b.i0.b1.e.d
        public void requestLayout() {
            SimpleDragSortListView.super.requestLayout();
        }
    }

    public SimpleDragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = new a();
        this.L = attributeSet;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c cVar = this.K;
        if (cVar != null) {
            cVar.b(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    public d getViewSuperMethods() {
        return this.M;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        c cVar = this.K;
        if (cVar != null) {
            cVar.a();
        } else {
            super.layoutChildren();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        c cVar = this.K;
        if (cVar != null) {
            cVar.onDraw(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        c cVar = this.K;
        if (cVar != null) {
            return cVar.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        c cVar = this.K;
        if (cVar != null) {
            cVar.onMeasure(i, i2);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        c cVar = this.K;
        if (cVar != null) {
            cVar.onSizeChanged(i, i2, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar = this.K;
        if (cVar != null) {
            return cVar.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        c cVar = this.K;
        if (cVar != null) {
            cVar.requestLayout();
        } else {
            super.requestLayout();
        }
    }

    public void setDragSortViewEventDelegate(c cVar) {
        this.K = cVar;
        cVar.d(this, getContext(), this.L);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        c cVar = this.K;
        if (cVar != null) {
            cVar.c(listAdapter);
        } else {
            super.setAdapter(listAdapter);
        }
    }
}
