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
    private final Matrix aGF;
    private float aGG;
    private float aGH;
    private final boolean aGI;
    private final Animation aGs;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aGI = typedArray.getBoolean(15, true);
        this.aGw.setScaleType(ImageView.ScaleType.MATRIX);
        this.aGF = new Matrix();
        this.aGw.setImageMatrix(this.aGF);
        this.aGs = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aGs.setInterpolator(aGu);
        this.aGs.setDuration(1200L);
        this.aGs.setRepeatCount(-1);
        this.aGs.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aGG = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aGH = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void R(float f) {
        float max;
        if (this.aGI) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aGF.setRotate(max, this.aGG, this.aGH);
        this.aGw.setImageMatrix(this.aGF);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hl() {
        this.aGw.startAnimation(this.aGs);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hn() {
        this.aGw.clearAnimation();
        Ho();
    }

    private void Ho() {
        if (this.aGF != null) {
            this.aGF.reset();
            this.aGw.setImageMatrix(this.aGF);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hk() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Hm() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return r.g.default_ptr_rotate;
    }
}
