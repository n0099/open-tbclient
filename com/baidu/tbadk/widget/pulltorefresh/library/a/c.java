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
    private final Animation aQI;
    private final Matrix aQV;
    private float aQW;
    private float aQX;
    private final boolean aQY;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aQY = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aQM.setScaleType(ImageView.ScaleType.MATRIX);
        this.aQV = new Matrix();
        this.aQM.setImageMatrix(this.aQV);
        this.aQI = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aQI.setInterpolator(aQK);
        this.aQI.setDuration(1200L);
        this.aQI.setRepeatCount(-1);
        this.aQI.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void c(Drawable drawable) {
        if (drawable != null) {
            this.aQW = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aQX = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void H(float f) {
        float max;
        if (this.aQY) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aQV.setRotate(max, this.aQW, this.aQX);
        this.aQM.setImageMatrix(this.aQV);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void IC() {
        this.aQM.startAnimation(this.aQI);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void IE() {
        this.aQM.clearAnimation();
        IG();
    }

    private void IG() {
        if (this.aQV != null) {
            this.aQV.reset();
            this.aQM.setImageMatrix(this.aQV);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void IB() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void ID() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
