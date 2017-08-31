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
    private final Animation aPR;
    private final Matrix aQe;
    private float aQf;
    private float aQg;
    private final boolean aQh;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aQh = typedArray.getBoolean(d.n.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aPV.setScaleType(ImageView.ScaleType.MATRIX);
        this.aQe = new Matrix();
        this.aPV.setImageMatrix(this.aQe);
        this.aPR = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aPR.setInterpolator(aPT);
        this.aPR.setDuration(1200L);
        this.aPR.setRepeatCount(-1);
        this.aPR.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void c(Drawable drawable) {
        if (drawable != null) {
            this.aQf = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aQg = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void F(float f) {
        float max;
        if (this.aQh) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aQe.setRotate(max, this.aQf, this.aQg);
        this.aPV.setImageMatrix(this.aQe);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ip() {
        this.aPV.startAnimation(this.aPR);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ir() {
        this.aPV.clearAnimation();
        It();
    }

    private void It() {
        if (this.aQe != null) {
            this.aQe.reset();
            this.aPV.setImageMatrix(this.aQe);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Io() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Iq() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.g.default_ptr_rotate;
    }
}
