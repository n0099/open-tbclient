package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends b {
    private final Animation aHU;
    private final Matrix aIh;
    private float aIi;
    private float aIj;
    private final boolean aIk;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aIk = typedArray.getBoolean(15, true);
        this.aHY.setScaleType(ImageView.ScaleType.MATRIX);
        this.aIh = new Matrix();
        this.aHY.setImageMatrix(this.aIh);
        this.aHU = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aHU.setInterpolator(aHW);
        this.aHU.setDuration(1200L);
        this.aHU.setRepeatCount(-1);
        this.aHU.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aIi = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aIj = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void P(float f) {
        float max;
        if (this.aIk) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aIh.setRotate(max, this.aIi, this.aIj);
        this.aHY.setImageMatrix(this.aIh);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HV() {
        this.aHY.startAnimation(this.aHU);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HX() {
        this.aHY.clearAnimation();
        HY();
    }

    private void HY() {
        if (this.aIh != null) {
            this.aIh.reset();
            this.aHY.setImageMatrix(this.aIh);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HU() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HW() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return t.f.default_ptr_rotate;
    }
}
