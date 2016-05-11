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
    private final Matrix aDG;
    private float aDH;
    private float aDI;
    private final boolean aDJ;
    private final Animation aDt;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aDJ = typedArray.getBoolean(15, true);
        this.aDx.setScaleType(ImageView.ScaleType.MATRIX);
        this.aDG = new Matrix();
        this.aDx.setImageMatrix(this.aDG);
        this.aDt = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aDt.setInterpolator(aDv);
        this.aDt.setDuration(1200L);
        this.aDt.setRepeatCount(-1);
        this.aDt.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void d(Drawable drawable) {
        if (drawable != null) {
            this.aDH = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aDI = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void t(float f) {
        float max;
        if (this.aDJ) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aDG.setRotate(max, this.aDH, this.aDI);
        this.aDx.setImageMatrix(this.aDG);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Gx() {
        this.aDx.startAnimation(this.aDt);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Gz() {
        this.aDx.clearAnimation();
        GA();
    }

    private void GA() {
        if (this.aDG != null) {
            this.aDG.reset();
            this.aDx.setImageMatrix(this.aDG);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Gw() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Gy() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return t.f.default_ptr_rotate;
    }
}
