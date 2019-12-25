package com.baidu.tieba.ala.alasquare.widget.banner;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class f {
    private int mLastTotalSpace;
    protected final RecyclerView.LayoutManager mLayoutManager;
    final Rect mTmpRect;

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    private f(RecyclerView.LayoutManager layoutManager) {
        this.mLastTotalSpace = Integer.MIN_VALUE;
        this.mTmpRect = new Rect();
        this.mLayoutManager = layoutManager;
    }

    public static f a(RecyclerView.LayoutManager layoutManager) {
        return new f(layoutManager) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.f.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getEnd() {
                return this.mLayoutManager.getWidth();
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getStartAfterPadding() {
                return this.mLayoutManager.getPaddingLeft();
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getDecoratedStart(View view) {
                return this.mLayoutManager.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getTotalSpace() {
                return (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight();
            }
        };
    }

    public static f b(RecyclerView.LayoutManager layoutManager) {
        return new f(layoutManager) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.f.2
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getEnd() {
                return this.mLayoutManager.getHeight();
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getStartAfterPadding() {
                return this.mLayoutManager.getPaddingTop();
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getDecoratedStart(View view) {
                return this.mLayoutManager.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.f
            public int getTotalSpace() {
                return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
            }
        };
    }
}
