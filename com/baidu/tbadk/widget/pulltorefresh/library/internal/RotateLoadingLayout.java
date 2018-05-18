package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class RotateLoadingLayout extends LoadingLayout {
    private final Animation aUH;
    private final Matrix aUU;
    private float aUV;
    private float aUW;
    private final boolean aUX;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aUX = typedArray.getBoolean(d.m.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aUL.setScaleType(ImageView.ScaleType.MATRIX);
        this.aUU = new Matrix();
        this.aUL.setImageMatrix(this.aUU);
        this.aUH = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aUH.setInterpolator(aUJ);
        this.aUH.setDuration(1200L);
        this.aUH.setRepeatCount(-1);
        this.aUH.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aUV = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aUW = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void S(float f) {
        float max;
        if (this.aUX) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aUU.setRotate(max, this.aUV, this.aUW);
        this.aUL.setImageMatrix(this.aUU);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void JD() {
        this.aUL.startAnimation(this.aUH);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void JF() {
        this.aUL.clearAnimation();
        JG();
    }

    private void JG() {
        if (this.aUU != null) {
            this.aUU.reset();
            this.aUL.setImageMatrix(this.aUU);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void JC() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void JE() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
