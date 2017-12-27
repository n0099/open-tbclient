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
    private final Animation bHG;
    private final Matrix bHT;
    private float bHU;
    private float bHV;
    private final boolean bHW;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.bHW = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.bHK.setScaleType(ImageView.ScaleType.MATRIX);
        this.bHT = new Matrix();
        this.bHK.setImageMatrix(this.bHT);
        this.bHG = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bHG.setInterpolator(bHI);
        this.bHG.setDuration(1200L);
        this.bHG.setRepeatCount(-1);
        this.bHG.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void k(Drawable drawable) {
        if (drawable != null) {
            this.bHU = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.bHV = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Y(float f) {
        float max;
        if (this.bHW) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.bHT.setRotate(max, this.bHU, this.bHV);
        this.bHK.setImageMatrix(this.bHT);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void QI() {
        this.bHK.startAnimation(this.bHG);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void QK() {
        this.bHK.clearAnimation();
        QL();
    }

    private void QL() {
        if (this.bHT != null) {
            this.bHT.reset();
            this.bHK.setImageMatrix(this.bHT);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void QH() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void QJ() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
