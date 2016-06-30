package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c extends b {
    private final Animation aDT;
    private final Matrix aEg;
    private float aEh;
    private float aEi;
    private final boolean aEj;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aEj = typedArray.getBoolean(15, true);
        this.aDX.setScaleType(ImageView.ScaleType.MATRIX);
        this.aEg = new Matrix();
        this.aDX.setImageMatrix(this.aEg);
        this.aDT = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aDT.setInterpolator(aDV);
        this.aDT.setDuration(1200L);
        this.aDT.setRepeatCount(-1);
        this.aDT.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void d(Drawable drawable) {
        if (drawable != null) {
            this.aEh = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aEi = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void t(float f) {
        float max;
        if (this.aEj) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aEg.setRotate(max, this.aEh, this.aEi);
        this.aDX.setImageMatrix(this.aEg);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void GA() {
        this.aDX.startAnimation(this.aDT);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void GC() {
        this.aDX.clearAnimation();
        GD();
    }

    private void GD() {
        if (this.aEg != null) {
            this.aEg.reset();
            this.aDX.setImageMatrix(this.aEg);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Gz() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void GB() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return u.f.default_ptr_rotate;
    }
}
