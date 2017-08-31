package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class a extends b {
    private final Animation aPR;
    private final Animation aPS;

    public a(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        this.aPR = new RotateAnimation(0.0f, i, 1, 0.5f, 1, 0.5f);
        this.aPR.setInterpolator(aPT);
        this.aPR.setDuration(150L);
        this.aPR.setFillAfter(true);
        this.aPS = new RotateAnimation(i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.aPS.setInterpolator(aPT);
        this.aPS.setDuration(150L);
        this.aPS.setFillAfter(true);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void c(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.aPV.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.aPV.requestLayout();
            this.aPV.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.aPV.setImageMatrix(matrix);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void F(float f) {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Io() {
        if (this.aPR == this.aPV.getAnimation()) {
            this.aPV.startAnimation(this.aPS);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ip() {
        this.aPV.setVisibility(0);
        this.aPW.setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Iq() {
        this.aPV.startAnimation(this.aPR);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ir() {
        this.aPV.clearAnimation();
        this.aPW.setVisibility(8);
        this.aPV.setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.g.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (this.aPm) {
            case PULL_FROM_END:
                if (this.aQa == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 90.0f;
                }
                return 180.0f;
            case PULL_FROM_START:
                if (this.aQa != PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 0.0f;
                }
                return 270.0f;
            default:
                return 0.0f;
        }
    }
}
