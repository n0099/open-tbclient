package com.baidu.tieba.ala.alasquare.widget.banner;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes10.dex */
public abstract class d {
    private int mLastTotalSpace;
    protected final RecyclerView.LayoutManager mLayoutManager;
    final Rect mTmpRect;

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    private d(RecyclerView.LayoutManager layoutManager) {
        this.mLastTotalSpace = Integer.MIN_VALUE;
        this.mTmpRect = new Rect();
        this.mLayoutManager = layoutManager;
    }

    public static d a(RecyclerView.LayoutManager layoutManager) {
        return new d(layoutManager) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.d.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getEnd() {
                return this.mLayoutManager.getWidth();
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getStartAfterPadding() {
                return this.mLayoutManager.getPaddingLeft();
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getDecoratedStart(View view) {
                return this.mLayoutManager.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getTotalSpace() {
                return (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight();
            }
        };
    }

    public static d b(RecyclerView.LayoutManager layoutManager) {
        return new d(layoutManager) { // from class: com.baidu.tieba.ala.alasquare.widget.banner.d.2
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getEnd() {
                return this.mLayoutManager.getHeight();
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getStartAfterPadding() {
                return this.mLayoutManager.getPaddingTop();
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getDecoratedStart(View view) {
                return this.mLayoutManager.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public int getTotalSpace() {
                return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
            }
        };
    }
}
