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
    private final Matrix aMK;
    private float aML;
    private float aMM;
    private final boolean aMN;
    private final Animation aMx;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aMN = typedArray.getBoolean(15, true);
        this.aMB.setScaleType(ImageView.ScaleType.MATRIX);
        this.aMK = new Matrix();
        this.aMB.setImageMatrix(this.aMK);
        this.aMx = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aMx.setInterpolator(aMz);
        this.aMx.setDuration(1200L);
        this.aMx.setRepeatCount(-1);
        this.aMx.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aML = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aMM = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void R(float f) {
        float max;
        if (this.aMN) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aMK.setRotate(max, this.aML, this.aMM);
        this.aMB.setImageMatrix(this.aMK);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hw() {
        this.aMB.startAnimation(this.aMx);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hy() {
        this.aMB.clearAnimation();
        HA();
    }

    private void HA() {
        if (this.aMK != null) {
            this.aMK.reset();
            this.aMB.setImageMatrix(this.aMK);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hv() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hx() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return w.g.default_ptr_rotate;
    }
}
