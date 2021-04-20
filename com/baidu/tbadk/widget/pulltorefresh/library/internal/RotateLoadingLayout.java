package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
/* loaded from: classes3.dex */
public class RotateLoadingLayout extends LoadingLayout {
    public final Animation q;
    public final Matrix r;
    public float s;
    public float t;
    public final boolean u;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.u = typedArray.getBoolean(R$styleable.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.f13952f.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.r = matrix;
        this.f13952f.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.q = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.p);
        this.q.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.q.setRepeatCount(-1);
        this.q.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void a(Drawable drawable) {
        if (drawable != null) {
            this.s = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.t = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void c(float f2) {
        this.r.setRotate(this.u ? f2 * 90.0f : Math.max(0.0f, Math.min(180.0f, (f2 * 360.0f) - 180.0f)), this.s, this.t);
        this.f13952f.setImageMatrix(this.r);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void e() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void g() {
        this.f13952f.startAnimation(this.q);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public int getDefaultDrawableResId() {
        return R.drawable.default_ptr_rotate;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void i() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void k() {
        this.f13952f.clearAnimation();
        l();
    }

    public final void l() {
        Matrix matrix = this.r;
        if (matrix != null) {
            matrix.reset();
            this.f13952f.setImageMatrix(this.r);
        }
    }
}
