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
    private final Animation bHW;
    private final Matrix bIj;
    private float bIk;
    private float bIl;
    private final boolean bIm;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.bIm = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.bIa.setScaleType(ImageView.ScaleType.MATRIX);
        this.bIj = new Matrix();
        this.bIa.setImageMatrix(this.bIj);
        this.bHW = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bHW.setInterpolator(bHY);
        this.bHW.setDuration(1200L);
        this.bHW.setRepeatCount(-1);
        this.bHW.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void k(Drawable drawable) {
        if (drawable != null) {
            this.bIk = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.bIl = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Y(float f) {
        float max;
        if (this.bIm) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.bIj.setRotate(max, this.bIk, this.bIl);
        this.bIa.setImageMatrix(this.bIj);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Qy() {
        this.bIa.startAnimation(this.bHW);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void QA() {
        this.bIa.clearAnimation();
        QB();
    }

    private void QB() {
        if (this.bIj != null) {
            this.bIj.reset();
            this.bIa.setImageMatrix(this.bIj);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Qx() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Qz() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
