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
    private final Animation aQh;
    private final Matrix aQu;
    private float aQv;
    private float aQw;
    private final boolean aQx;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aQx = typedArray.getBoolean(d.n.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aQl.setScaleType(ImageView.ScaleType.MATRIX);
        this.aQu = new Matrix();
        this.aQl.setImageMatrix(this.aQu);
        this.aQh = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aQh.setInterpolator(aQj);
        this.aQh.setDuration(1200L);
        this.aQh.setRepeatCount(-1);
        this.aQh.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aQv = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aQw = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Q(float f) {
        float max;
        if (this.aQx) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aQu.setRotate(max, this.aQv, this.aQw);
        this.aQl.setImageMatrix(this.aQu);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ii() {
        this.aQl.startAnimation(this.aQh);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ik() {
        this.aQl.clearAnimation();
        Im();
    }

    private void Im() {
        if (this.aQu != null) {
            this.aQu.reset();
            this.aQl.setImageMatrix(this.aQu);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ih() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ij() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.g.default_ptr_rotate;
    }
}
