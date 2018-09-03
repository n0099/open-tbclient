package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class RotateLoadingLayout extends LoadingLayout {
    private float beA;
    private final boolean beB;
    private final Animation bem;
    private final Matrix bey;
    private float bez;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.beB = typedArray.getBoolean(f.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        this.bey = new Matrix();
        this.mHeaderImage.setImageMatrix(this.bey);
        this.bem = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bem.setInterpolator(beo);
        this.bem.setDuration(1200L);
        this.bem.setRepeatCount(-1);
        this.bem.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.bez = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.beA = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
        float max;
        if (this.beB) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.bey.setRotate(max, this.bez, this.beA);
        this.mHeaderImage.setImageMatrix(this.bey);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.bem);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        Nu();
    }

    private void Nu() {
        if (this.bey != null) {
            this.bey.reset();
            this.mHeaderImage.setImageMatrix(this.bey);
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
        return f.C0146f.default_ptr_rotate;
    }
}
