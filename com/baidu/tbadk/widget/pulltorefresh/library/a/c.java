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
    private final Animation aQQ;
    private final Matrix aRd;
    private float aRe;
    private float aRf;
    private final boolean aRg;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aRg = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.aQU.setScaleType(ImageView.ScaleType.MATRIX);
        this.aRd = new Matrix();
        this.aQU.setImageMatrix(this.aRd);
        this.aQQ = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aQQ.setInterpolator(aQS);
        this.aQQ.setDuration(1200L);
        this.aQQ.setRepeatCount(-1);
        this.aQQ.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void c(Drawable drawable) {
        if (drawable != null) {
            this.aRe = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aRf = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void H(float f) {
        float max;
        if (this.aRg) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aRd.setRotate(max, this.aRe, this.aRf);
        this.aQU.setImageMatrix(this.aRd);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void IN() {
        this.aQU.startAnimation(this.aQQ);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void IP() {
        this.aQU.clearAnimation();
        IR();
    }

    private void IR() {
        if (this.aRd != null) {
            this.aRd.reset();
            this.aQU.setImageMatrix(this.aRd);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void IM() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void IO() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
