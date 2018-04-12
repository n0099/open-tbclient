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
    private final Animation aUG;
    private final Matrix aUT;
    private float aUU;
    private float aUV;
    private final boolean aUW;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aUW = typedArray.getBoolean(d.m.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aUK.setScaleType(ImageView.ScaleType.MATRIX);
        this.aUT = new Matrix();
        this.aUK.setImageMatrix(this.aUT);
        this.aUG = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aUG.setInterpolator(aUI);
        this.aUG.setDuration(1200L);
        this.aUG.setRepeatCount(-1);
        this.aUG.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aUU = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aUV = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void S(float f) {
        float max;
        if (this.aUW) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aUT.setRotate(max, this.aUU, this.aUV);
        this.aUK.setImageMatrix(this.aUT);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void JF() {
        this.aUK.startAnimation(this.aUG);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void JH() {
        this.aUK.clearAnimation();
        JI();
    }

    private void JI() {
        if (this.aUT != null) {
            this.aUT.reset();
            this.aUK.setImageMatrix(this.aUT);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void JE() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void JG() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
