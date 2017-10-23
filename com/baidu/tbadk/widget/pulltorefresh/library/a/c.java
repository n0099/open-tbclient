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
    private final Animation aQE;
    private final Matrix aQR;
    private float aQS;
    private float aQT;
    private final boolean aQU;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aQU = typedArray.getBoolean(d.n.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aQI.setScaleType(ImageView.ScaleType.MATRIX);
        this.aQR = new Matrix();
        this.aQI.setImageMatrix(this.aQR);
        this.aQE = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aQE.setInterpolator(aQG);
        this.aQE.setDuration(1200L);
        this.aQE.setRepeatCount(-1);
        this.aQE.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void e(Drawable drawable) {
        if (drawable != null) {
            this.aQS = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aQT = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void I(float f) {
        float max;
        if (this.aQU) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aQR.setRotate(max, this.aQS, this.aQT);
        this.aQI.setImageMatrix(this.aQR);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Is() {
        this.aQI.startAnimation(this.aQE);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Iu() {
        this.aQI.clearAnimation();
        Iw();
    }

    private void Iw() {
        if (this.aQR != null) {
            this.aQR.reset();
            this.aQI.setImageMatrix(this.aQR);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ir() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void It() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.g.default_ptr_rotate;
    }
}
