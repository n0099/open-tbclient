package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends b {
    private final Matrix aMH;
    private float aMI;
    private float aMJ;
    private final boolean aMK;
    private final Animation aMu;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aMK = typedArray.getBoolean(15, true);
        this.aMy.setScaleType(ImageView.ScaleType.MATRIX);
        this.aMH = new Matrix();
        this.aMy.setImageMatrix(this.aMH);
        this.aMu = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aMu.setInterpolator(aMw);
        this.aMu.setDuration(1200L);
        this.aMu.setRepeatCount(-1);
        this.aMu.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aMI = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aMJ = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Q(float f) {
        float max;
        if (this.aMK) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aMH.setRotate(max, this.aMI, this.aMJ);
        this.aMy.setImageMatrix(this.aMH);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hr() {
        this.aMy.startAnimation(this.aMu);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ht() {
        this.aMy.clearAnimation();
        Hv();
    }

    private void Hv() {
        if (this.aMH != null) {
            this.aMH.reset();
            this.aMy.setImageMatrix(this.aMH);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hq() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hs() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return w.g.default_ptr_rotate;
    }
}
