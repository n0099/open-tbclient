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
    private final Animation aQR;
    private final Matrix aRe;
    private float aRf;
    private float aRg;
    private final boolean aRh;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aRh = typedArray.getBoolean(d.n.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aQV.setScaleType(ImageView.ScaleType.MATRIX);
        this.aRe = new Matrix();
        this.aQV.setImageMatrix(this.aRe);
        this.aQR = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aQR.setInterpolator(aQT);
        this.aQR.setDuration(1200L);
        this.aQR.setRepeatCount(-1);
        this.aQR.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void e(Drawable drawable) {
        if (drawable != null) {
            this.aRf = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aRg = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void I(float f) {
        float max;
        if (this.aRh) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aRe.setRotate(max, this.aRf, this.aRg);
        this.aQV.setImageMatrix(this.aRe);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Iy() {
        this.aQV.startAnimation(this.aQR);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void IA() {
        this.aQV.clearAnimation();
        IC();
    }

    private void IC() {
        if (this.aRe != null) {
            this.aRe.reset();
            this.aQV.setImageMatrix(this.aRe);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ix() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Iz() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.g.default_ptr_rotate;
    }
}
