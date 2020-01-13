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
    private final Animation bJm;
    private final Matrix dJr;
    private float dJs;
    private float dJt;
    private final boolean dJu;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.dJu = typedArray.getBoolean(8, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        this.dJr = new Matrix();
        this.mHeaderImage.setImageMatrix(this.dJr);
        this.bJm = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bJm.setInterpolator(bJl);
        this.bJm.setDuration(1200L);
        this.bJm.setRepeatCount(-1);
        this.bJm.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.dJs = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.dJt = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
        float max;
        if (this.dJu) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.dJr.setRotate(max, this.dJs, this.dJt);
        this.mHeaderImage.setImageMatrix(this.dJr);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.bJm);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        aRx();
    }

    private void aRx() {
        if (this.dJr != null) {
            this.dJr.reset();
            this.mHeaderImage.setImageMatrix(this.dJr);
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
