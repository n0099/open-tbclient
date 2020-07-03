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
    private final Animation cCI;
    private final Matrix eMW;
    private float eMX;
    private float eMY;
    private final boolean eMZ;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.eMZ = typedArray.getBoolean(8, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        this.eMW = new Matrix();
        this.mHeaderImage.setImageMatrix(this.eMW);
        this.cCI = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.cCI.setInterpolator(cCH);
        this.cCI.setDuration(1200L);
        this.cCI.setRepeatCount(-1);
        this.cCI.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.eMX = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.eMY = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
        float max;
        if (this.eMZ) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.eMW.setRotate(max, this.eMX, this.eMY);
        this.mHeaderImage.setImageMatrix(this.eMW);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.cCI);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        bkM();
    }

    private void bkM() {
        if (this.eMW != null) {
            this.eMW.reset();
            this.mHeaderImage.setImageMatrix(this.eMW);
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
