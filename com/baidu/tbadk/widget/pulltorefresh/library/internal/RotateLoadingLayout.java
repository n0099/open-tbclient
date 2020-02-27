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
    private final Animation bNr;
    private final Matrix dNw;
    private float dNx;
    private float dNy;
    private final boolean dNz;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.dNz = typedArray.getBoolean(8, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        this.dNw = new Matrix();
        this.mHeaderImage.setImageMatrix(this.dNw);
        this.bNr = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bNr.setInterpolator(bNq);
        this.bNr.setDuration(1200L);
        this.bNr.setRepeatCount(-1);
        this.bNr.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.dNx = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.dNy = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
        float max;
        if (this.dNz) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.dNw.setRotate(max, this.dNx, this.dNy);
        this.mHeaderImage.setImageMatrix(this.dNw);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.bNr);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        aTO();
    }

    private void aTO() {
        if (this.dNw != null) {
            this.dNw.reset();
            this.mHeaderImage.setImageMatrix(this.dNw);
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
