package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class FrsPicVoteLayout extends ViewGroup {
    private int cfs;
    private int cft;
    private int mChildCount;
    private int mItemSize;
    private int mPadding;

    public FrsPicVoteLayout(Context context) {
        super(context);
        this.mItemSize = 0;
        this.cfs = 110;
        this.cft = 0;
        this.mPadding = 3;
        this.mChildCount = 3;
        init(context);
    }

    public FrsPicVoteLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemSize = 0;
        this.cfs = 110;
        this.cft = 0;
        this.mPadding = 3;
        this.mChildCount = 3;
        init(context);
    }

    private void init(Context context) {
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, this.mPadding);
        this.mItemSize = com.baidu.adp.lib.util.k.dip2px(context, this.cfs);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int i3 = (this.mItemSize * this.mChildCount) + (this.mPadding * (this.mChildCount - 1));
        if (this.mItemSize == 0) {
            this.mItemSize = this.cfs;
        } else if (i3 > size) {
            this.mItemSize = (size - (this.mPadding * (this.mChildCount - 1))) / this.mChildCount;
        } else {
            size = i3;
        }
        this.cft = (int) (this.mItemSize * 0.75d);
        setMeasuredDimension(size, this.cft);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < this.mChildCount) {
                if (getChildAt(i5) instanceof FrsPicVotePhotoFrame) {
                    FrsPicVotePhotoFrame frsPicVotePhotoFrame = (FrsPicVotePhotoFrame) getChildAt(i5);
                    if (frsPicVotePhotoFrame.getLayoutParams() != null) {
                        measureChild(frsPicVotePhotoFrame, View.MeasureSpec.makeMeasureSpec(this.mItemSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.cft, 1073741824));
                    }
                }
                i4 = i5 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mChildCount != 0) {
            for (int i5 = 0; i5 < this.mChildCount; i5++) {
                if (getChildAt(i5) != null) {
                    View childAt = getChildAt(i5);
                    int i6 = (this.mPadding * i5) + (this.mItemSize * i5);
                    int i7 = (this.mPadding * i5) + (this.mItemSize * (i5 + 1));
                    if (childAt.getLayoutParams() != null) {
                        childAt.layout(i6, 0, i7, i4 - i2);
                    }
                }
            }
        }
    }
}
