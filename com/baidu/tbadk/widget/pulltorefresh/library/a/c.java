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
    private final Animation aIj;
    private final Matrix aIw;
    private float aIx;
    private float aIy;
    private final boolean aIz;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aIz = typedArray.getBoolean(15, true);
        this.aIn.setScaleType(ImageView.ScaleType.MATRIX);
        this.aIw = new Matrix();
        this.aIn.setImageMatrix(this.aIw);
        this.aIj = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aIj.setInterpolator(aIl);
        this.aIj.setDuration(1200L);
        this.aIj.setRepeatCount(-1);
        this.aIj.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aIx = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aIy = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void P(float f) {
        float max;
        if (this.aIz) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aIw.setRotate(max, this.aIx, this.aIy);
        this.aIn.setImageMatrix(this.aIw);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HX() {
        this.aIn.startAnimation(this.aIj);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HZ() {
        this.aIn.clearAnimation();
        Ia();
    }

    private void Ia() {
        if (this.aIw != null) {
            this.aIw.reset();
            this.aIn.setImageMatrix(this.aIw);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HW() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HY() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return r.f.default_ptr_rotate;
    }
}
