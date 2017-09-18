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
    private final Animation aPO;
    private final Matrix aQb;
    private float aQc;
    private float aQd;
    private final boolean aQe;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aQe = typedArray.getBoolean(d.n.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aPS.setScaleType(ImageView.ScaleType.MATRIX);
        this.aQb = new Matrix();
        this.aPS.setImageMatrix(this.aQb);
        this.aPO = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aPO.setInterpolator(aPQ);
        this.aPO.setDuration(1200L);
        this.aPO.setRepeatCount(-1);
        this.aPO.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void c(Drawable drawable) {
        if (drawable != null) {
            this.aQc = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aQd = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void F(float f) {
        float max;
        if (this.aQe) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aQb.setRotate(max, this.aQc, this.aQd);
        this.aPS.setImageMatrix(this.aQb);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ip() {
        this.aPS.startAnimation(this.aPO);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ir() {
        this.aPS.clearAnimation();
        It();
    }

    private void It() {
        if (this.aQb != null) {
            this.aQb.reset();
            this.aPS.setImageMatrix(this.aQb);
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
