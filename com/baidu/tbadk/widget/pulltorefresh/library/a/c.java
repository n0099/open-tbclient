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
    private final Animation aLP;
    private final Matrix aMc;
    private float aMd;
    private float aMe;
    private final boolean aMf;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aMf = typedArray.getBoolean(15, true);
        this.aLT.setScaleType(ImageView.ScaleType.MATRIX);
        this.aMc = new Matrix();
        this.aLT.setImageMatrix(this.aMc);
        this.aLP = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aLP.setInterpolator(aLR);
        this.aLP.setDuration(1200L);
        this.aLP.setRepeatCount(-1);
        this.aLP.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aMd = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aMe = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void R(float f) {
        float max;
        if (this.aMf) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aMc.setRotate(max, this.aMd, this.aMe);
        this.aLT.setImageMatrix(this.aMc);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HK() {
        this.aLT.startAnimation(this.aLP);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HM() {
        this.aLT.clearAnimation();
        HN();
    }

    private void HN() {
        if (this.aMc != null) {
            this.aMc.reset();
            this.aLT.setImageMatrix(this.aMc);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HJ() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HL() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return w.g.default_ptr_rotate;
    }
}
