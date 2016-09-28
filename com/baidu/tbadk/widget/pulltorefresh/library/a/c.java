package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends b {
    private final Matrix aHG;
    private float aHH;
    private float aHI;
    private final boolean aHJ;
    private final Animation aHt;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aHJ = typedArray.getBoolean(15, true);
        this.aHx.setScaleType(ImageView.ScaleType.MATRIX);
        this.aHG = new Matrix();
        this.aHx.setImageMatrix(this.aHG);
        this.aHt = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aHt.setInterpolator(aHv);
        this.aHt.setDuration(1200L);
        this.aHt.setRepeatCount(-1);
        this.aHt.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aHH = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aHI = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void P(float f) {
        float max;
        if (this.aHJ) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aHG.setRotate(max, this.aHH, this.aHI);
        this.aHx.setImageMatrix(this.aHG);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HU() {
        this.aHx.startAnimation(this.aHt);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HW() {
        this.aHx.clearAnimation();
        HX();
    }

    private void HX() {
        if (this.aHG != null) {
            this.aHG.reset();
            this.aHx.setImageMatrix(this.aHG);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HT() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HV() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return r.f.default_ptr_rotate;
    }
}
