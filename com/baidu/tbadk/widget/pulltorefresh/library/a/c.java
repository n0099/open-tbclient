package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends b {
    private final Animation aHD;
    private final Matrix aHQ;
    private float aHR;
    private float aHS;
    private final boolean aHT;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aHT = typedArray.getBoolean(15, true);
        this.aHH.setScaleType(ImageView.ScaleType.MATRIX);
        this.aHQ = new Matrix();
        this.aHH.setImageMatrix(this.aHQ);
        this.aHD = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aHD.setInterpolator(aHF);
        this.aHD.setDuration(1200L);
        this.aHD.setRepeatCount(-1);
        this.aHD.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aHR = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aHS = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Q(float f) {
        float max;
        if (this.aHT) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aHQ.setRotate(max, this.aHR, this.aHS);
        this.aHH.setImageMatrix(this.aHQ);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ht() {
        this.aHH.startAnimation(this.aHD);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hv() {
        this.aHH.clearAnimation();
        Hw();
    }

    private void Hw() {
        if (this.aHQ != null) {
            this.aHQ.reset();
            this.aHH.setImageMatrix(this.aHQ);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hs() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hu() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return r.f.default_ptr_rotate;
    }
}
