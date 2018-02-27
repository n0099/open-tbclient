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
    private final Animation bJO;
    private final Matrix bKb;
    private float bKc;
    private float bKd;
    private final boolean bKe;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.bKe = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.bJS.setScaleType(ImageView.ScaleType.MATRIX);
        this.bKb = new Matrix();
        this.bJS.setImageMatrix(this.bKb);
        this.bJO = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bJO.setInterpolator(bJQ);
        this.bJO.setDuration(1200L);
        this.bJO.setRepeatCount(-1);
        this.bJO.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void k(Drawable drawable) {
        if (drawable != null) {
            this.bKc = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.bKd = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void ae(float f) {
        float max;
        if (this.bKe) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.bKb.setRotate(max, this.bKc, this.bKd);
        this.bJS.setImageMatrix(this.bKb);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rc() {
        this.bJS.startAnimation(this.bJO);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Re() {
        this.bJS.clearAnimation();
        Rf();
    }

    private void Rf() {
        if (this.bKb != null) {
            this.bKb.reset();
            this.bJS.setImageMatrix(this.bKb);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rb() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rd() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
