package com.baidu.tbadk.widget.pulltorefresh.library.a;

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
public class c extends b {
    private final Animation aTN;
    private final Matrix aUa;
    private float aUb;
    private float aUc;
    private final boolean aUd;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aUd = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aTR.setScaleType(ImageView.ScaleType.MATRIX);
        this.aUa = new Matrix();
        this.aTR.setImageMatrix(this.aUa);
        this.aTN = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aTN.setInterpolator(aTP);
        this.aTN.setDuration(1200L);
        this.aTN.setRepeatCount(-1);
        this.aTN.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void c(Drawable drawable) {
        if (drawable != null) {
            this.aUb = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aUc = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void I(float f) {
        float max;
        if (this.aUd) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aUa.setRotate(max, this.aUb, this.aUc);
        this.aTR.setImageMatrix(this.aUa);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jk() {
        this.aTR.startAnimation(this.aTN);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jm() {
        this.aTR.clearAnimation();
        Jo();
    }

    private void Jo() {
        if (this.aUa != null) {
            this.aUa.reset();
            this.aTR.setImageMatrix(this.aUa);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jj() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jl() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
