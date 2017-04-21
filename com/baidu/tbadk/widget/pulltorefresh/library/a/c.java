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
    private final Animation aMh;
    private final Matrix aMu;
    private float aMv;
    private float aMw;
    private final boolean aMx;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aMx = typedArray.getBoolean(15, true);
        this.aMl.setScaleType(ImageView.ScaleType.MATRIX);
        this.aMu = new Matrix();
        this.aMl.setImageMatrix(this.aMu);
        this.aMh = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aMh.setInterpolator(aMj);
        this.aMh.setDuration(1200L);
        this.aMh.setRepeatCount(-1);
        this.aMh.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aMv = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aMw = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void R(float f) {
        float max;
        if (this.aMx) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aMu.setRotate(max, this.aMv, this.aMw);
        this.aMl.setImageMatrix(this.aMu);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ij() {
        this.aMl.startAnimation(this.aMh);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Il() {
        this.aMl.clearAnimation();
        Im();
    }

    private void Im() {
        if (this.aMu != null) {
            this.aMu.reset();
            this.aMl.setImageMatrix(this.aMu);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ii() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ik() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return w.g.default_ptr_rotate;
    }
}
