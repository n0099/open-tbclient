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
    private final Animation aOT;
    private final Matrix aPg;
    private float aPh;
    private float aPi;
    private final boolean aPj;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aPj = typedArray.getBoolean(d.n.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aOX.setScaleType(ImageView.ScaleType.MATRIX);
        this.aPg = new Matrix();
        this.aOX.setImageMatrix(this.aPg);
        this.aOT = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aOT.setInterpolator(aOV);
        this.aOT.setDuration(1200L);
        this.aOT.setRepeatCount(-1);
        this.aOT.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aPh = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aPi = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Q(float f) {
        float max;
        if (this.aPj) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aPg.setRotate(max, this.aPh, this.aPi);
        this.aOX.setImageMatrix(this.aPg);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ia() {
        this.aOX.startAnimation(this.aOT);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ic() {
        this.aOX.clearAnimation();
        Ie();
    }

    private void Ie() {
        if (this.aPg != null) {
            this.aPg.reset();
            this.aOX.setImageMatrix(this.aPg);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HZ() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ib() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.g.default_ptr_rotate;
    }
}
