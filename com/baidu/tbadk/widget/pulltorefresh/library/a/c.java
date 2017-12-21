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
    private final Animation aTT;
    private final Matrix aUg;
    private float aUh;
    private float aUi;
    private final boolean aUj;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aUj = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aTX.setScaleType(ImageView.ScaleType.MATRIX);
        this.aUg = new Matrix();
        this.aTX.setImageMatrix(this.aUg);
        this.aTT = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aTT.setInterpolator(aTV);
        this.aTT.setDuration(1200L);
        this.aTT.setRepeatCount(-1);
        this.aTT.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void c(Drawable drawable) {
        if (drawable != null) {
            this.aUh = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aUi = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void I(float f) {
        float max;
        if (this.aUj) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aUg.setRotate(max, this.aUh, this.aUi);
        this.aTX.setImageMatrix(this.aUg);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jl() {
        this.aTX.startAnimation(this.aTT);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Jn() {
        this.aTX.clearAnimation();
        Jp();
    }

    private void Jp() {
        if (this.aUg != null) {
            this.aUg.reset();
            this.aTX.setImageMatrix(this.aUg);
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
