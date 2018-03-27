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
    private final Animation bJR;
    private final Matrix bKe;
    private float bKf;
    private float bKg;
    private final boolean bKh;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.bKh = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.bJV.setScaleType(ImageView.ScaleType.MATRIX);
        this.bKe = new Matrix();
        this.bJV.setImageMatrix(this.bKe);
        this.bJR = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bJR.setInterpolator(bJT);
        this.bJR.setDuration(1200L);
        this.bJR.setRepeatCount(-1);
        this.bJR.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void k(Drawable drawable) {
        if (drawable != null) {
            this.bKf = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.bKg = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void ae(float f) {
        float max;
        if (this.bKh) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.bKe.setRotate(max, this.bKf, this.bKg);
        this.bJV.setImageMatrix(this.bKe);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rd() {
        this.bJV.startAnimation(this.bJR);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rf() {
        this.bJV.clearAnimation();
        Rg();
    }

    private void Rg() {
        if (this.bKe != null) {
            this.bKe.reset();
            this.bJV.setImageMatrix(this.bKe);
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
