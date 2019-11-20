package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class FlipLoadingLayout extends LoadingLayout {
    private final Animation bfR;
    private final Animation cUG;

    public FlipLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        this.bfR = new RotateAnimation(0.0f, i, 1, 0.5f, 1, 0.5f);
        this.bfR.setInterpolator(bfQ);
        this.bfR.setDuration(150L);
        this.bfR.setFillAfter(true);
        this.cUG = new RotateAnimation(i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cUG.setInterpolator(bfQ);
        this.cUG.setDuration(150L);
        this.cUG.setFillAfter(true);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.mHeaderImage.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.mHeaderImage.requestLayout();
            this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.mHeaderImage.setImageMatrix(matrix);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void pullToRefreshImpl() {
        if (this.bfR == this.mHeaderImage.getAnimation()) {
            this.mHeaderImage.startAnimation(this.cUG);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        this.mHeaderImage.setVisibility(0);
        this.mHeaderProgress.setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void releaseToRefreshImpl() {
        this.mHeaderImage.startAnimation(this.bfR);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        this.mHeaderProgress.setVisibility(8);
        this.mHeaderImage.setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        return R.drawable.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (this.cUm) {
            case PULL_FROM_END:
                if (this.cUL == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 90.0f;
                }
                return 180.0f;
            case PULL_FROM_START:
                if (this.cUL != PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 0.0f;
                }
                return 270.0f;
            default:
                return 0.0f;
        }
    }
}
