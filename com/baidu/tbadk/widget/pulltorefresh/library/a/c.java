package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends b {
    private final Matrix aHI;
    private float aHJ;
    private float aHK;
    private final boolean aHL;
    private final Animation aHv;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aHL = typedArray.getBoolean(15, true);
        this.aHz.setScaleType(ImageView.ScaleType.MATRIX);
        this.aHI = new Matrix();
        this.aHz.setImageMatrix(this.aHI);
        this.aHv = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aHv.setInterpolator(aHx);
        this.aHv.setDuration(1200L);
        this.aHv.setRepeatCount(-1);
        this.aHv.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void d(Drawable drawable) {
        if (drawable != null) {
            this.aHJ = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aHK = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void v(float f) {
        float max;
        if (this.aHL) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aHI.setRotate(max, this.aHJ, this.aHK);
        this.aHz.setImageMatrix(this.aHI);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ih() {
        this.aHz.startAnimation(this.aHv);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ij() {
        this.aHz.clearAnimation();
        Ik();
    }

    private void Ik() {
        if (this.aHI != null) {
            this.aHI.reset();
            this.aHz.setImageMatrix(this.aHI);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ig() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ii() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return t.f.default_ptr_rotate;
    }
}
