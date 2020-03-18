package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class RotateLoadingLayout extends LoadingLayout {
    private final Animation bNE;
    private final Matrix dOb;
    private float dOc;
    private float dOd;
    private final boolean dOe;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.dOe = typedArray.getBoolean(8, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        this.dOb = new Matrix();
        this.mHeaderImage.setImageMatrix(this.dOb);
        this.bNE = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bNE.setInterpolator(bND);
        this.bNE.setDuration(1200L);
        this.bNE.setRepeatCount(-1);
        this.bNE.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.dOc = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.dOd = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
        float max;
        if (this.dOe) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.dOb.setRotate(max, this.dOc, this.dOd);
        this.mHeaderImage.setImageMatrix(this.dOb);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.bNE);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        aTV();
    }

    private void aTV() {
        if (this.dOb != null) {
            this.dOb.reset();
            this.mHeaderImage.setImageMatrix(this.dOb);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void pullToRefreshImpl() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void releaseToRefreshImpl() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        return R.drawable.default_ptr_rotate;
    }
}
