package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends b {
    private final Animation aMf;
    private final Matrix aMs;
    private float aMt;
    private float aMu;
    private final boolean aMv;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aMv = typedArray.getBoolean(15, true);
        this.aMj.setScaleType(ImageView.ScaleType.MATRIX);
        this.aMs = new Matrix();
        this.aMj.setImageMatrix(this.aMs);
        this.aMf = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aMf.setInterpolator(aMh);
        this.aMf.setDuration(1200L);
        this.aMf.setRepeatCount(-1);
        this.aMf.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aMt = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aMu = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void R(float f) {
        float max;
        if (this.aMv) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aMs.setRotate(max, this.aMt, this.aMu);
        this.aMj.setImageMatrix(this.aMs);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ij() {
        this.aMj.startAnimation(this.aMf);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Il() {
        this.aMj.clearAnimation();
        Im();
    }

    private void Im() {
        if (this.aMs != null) {
            this.aMs.reset();
            this.aMj.setImageMatrix(this.aMs);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ii() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ik() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return w.g.default_ptr_rotate;
    }
}
