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
    private final Animation aTQ;
    private final Matrix aUd;
    private float aUe;
    private float aUf;
    private final boolean aUg;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aUg = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aTU.setScaleType(ImageView.ScaleType.MATRIX);
        this.aUd = new Matrix();
        this.aTU.setImageMatrix(this.aUd);
        this.aTQ = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aTQ.setInterpolator(aTS);
        this.aTQ.setDuration(1200L);
        this.aTQ.setRepeatCount(-1);
        this.aTQ.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void c(Drawable drawable) {
        if (drawable != null) {
            this.aUe = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aUf = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void I(float f) {
        float max;
        if (this.aUg) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aUd.setRotate(max, this.aUe, this.aUf);
        this.aTU.setImageMatrix(this.aUd);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jl() {
        this.aTU.startAnimation(this.aTQ);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jn() {
        this.aTU.clearAnimation();
        Jp();
    }

    private void Jp() {
        if (this.aUd != null) {
            this.aUd.reset();
            this.aTU.setImageMatrix(this.aUd);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jk() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jm() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
