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
    private final Animation bKb;
    private final Matrix bKo;
    private float bKp;
    private float bKq;
    private final boolean bKr;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.bKr = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.bKf.setScaleType(ImageView.ScaleType.MATRIX);
        this.bKo = new Matrix();
        this.bKf.setImageMatrix(this.bKo);
        this.bKb = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bKb.setInterpolator(bKd);
        this.bKb.setDuration(1200L);
        this.bKb.setRepeatCount(-1);
        this.bKb.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void k(Drawable drawable) {
        if (drawable != null) {
            this.bKp = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.bKq = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void ae(float f) {
        float max;
        if (this.bKr) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.bKo.setRotate(max, this.bKp, this.bKq);
        this.bKf.setImageMatrix(this.bKo);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rd() {
        this.bKf.startAnimation(this.bKb);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rf() {
        this.bKf.clearAnimation();
        Rg();
    }

    private void Rg() {
        if (this.bKo != null) {
            this.bKo.reset();
            this.bKf.setImageMatrix(this.bKo);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rc() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Re() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
