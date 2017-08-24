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
    private final Animation aQj;
    private final Matrix aQw;
    private float aQx;
    private float aQy;
    private final boolean aQz;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aQz = typedArray.getBoolean(d.n.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aQn.setScaleType(ImageView.ScaleType.MATRIX);
        this.aQw = new Matrix();
        this.aQn.setImageMatrix(this.aQw);
        this.aQj = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aQj.setInterpolator(aQl);
        this.aQj.setDuration(1200L);
        this.aQj.setRepeatCount(-1);
        this.aQj.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aQx = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aQy = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Q(float f) {
        float max;
        if (this.aQz) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aQw.setRotate(max, this.aQx, this.aQy);
        this.aQn.setImageMatrix(this.aQw);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ii() {
        this.aQn.startAnimation(this.aQj);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ik() {
        this.aQn.clearAnimation();
        Im();
    }

    private void Im() {
        if (this.aQw != null) {
            this.aQw.reset();
            this.aQn.setImageMatrix(this.aQw);
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
