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
    private final Animation bHO;
    private final Matrix bIb;
    private float bIc;
    private float bId;
    private final boolean bIe;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.bIe = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.bHS.setScaleType(ImageView.ScaleType.MATRIX);
        this.bIb = new Matrix();
        this.bHS.setImageMatrix(this.bIb);
        this.bHO = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bHO.setInterpolator(bHQ);
        this.bHO.setDuration(1200L);
        this.bHO.setRepeatCount(-1);
        this.bHO.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void k(Drawable drawable) {
        if (drawable != null) {
            this.bIc = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.bId = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Y(float f) {
        float max;
        if (this.bIe) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.bIb.setRotate(max, this.bIc, this.bId);
        this.bHS.setImageMatrix(this.bIb);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Qw() {
        this.bHS.startAnimation(this.bHO);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Qy() {
        this.bHS.clearAnimation();
        Qz();
    }

    private void Qz() {
        if (this.bIb != null) {
            this.bIb.reset();
            this.bHS.setImageMatrix(this.bIb);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Qv() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Qx() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
