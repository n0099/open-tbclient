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
    private final Animation aMZ;
    private final Matrix cMn;
    private float cMo;
    private float cMp;
    private final boolean cMq;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.cMq = typedArray.getBoolean(8, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        this.cMn = new Matrix();
        this.mHeaderImage.setImageMatrix(this.cMn);
        this.aMZ = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aMZ.setInterpolator(aMY);
        this.aMZ.setDuration(1200L);
        this.aMZ.setRepeatCount(-1);
        this.aMZ.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.cMo = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.cMp = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void onPullImpl(float f) {
        float max;
        if (this.cMq) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.cMn.setRotate(max, this.cMo, this.cMp);
        this.mHeaderImage.setImageMatrix(this.cMn);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void refreshingImpl() {
        this.mHeaderImage.startAnimation(this.aMZ);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        ayX();
    }

    private void ayX() {
        if (this.cMn != null) {
            this.cMn.reset();
            this.mHeaderImage.setImageMatrix(this.cMn);
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
