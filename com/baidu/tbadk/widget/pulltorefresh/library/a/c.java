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
    private final Animation aNK;
    private final Matrix aNX;
    private float aNY;
    private float aNZ;
    private final boolean aOa;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aOa = typedArray.getBoolean(15, true);
        this.aNO.setScaleType(ImageView.ScaleType.MATRIX);
        this.aNX = new Matrix();
        this.aNO.setImageMatrix(this.aNX);
        this.aNK = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aNK.setInterpolator(aNM);
        this.aNK.setDuration(1200L);
        this.aNK.setRepeatCount(-1);
        this.aNK.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aNY = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aNZ = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Q(float f) {
        float max;
        if (this.aOa) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aNX.setRotate(max, this.aNY, this.aNZ);
        this.aNO.setImageMatrix(this.aNX);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HO() {
        this.aNO.startAnimation(this.aNK);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HQ() {
        this.aNO.clearAnimation();
        HS();
    }

    private void HS() {
        if (this.aNX != null) {
            this.aNX.reset();
            this.aNO.setImageMatrix(this.aNX);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HN() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HP() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return w.g.default_ptr_rotate;
    }
}
