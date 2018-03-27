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
    private final Animation bJR;
    private final Animation bJS;

    public a(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        this.bJR = new RotateAnimation(0.0f, i, 1, 0.5f, 1, 0.5f);
        this.bJR.setInterpolator(bJT);
        this.bJR.setDuration(150L);
        this.bJR.setFillAfter(true);
        this.bJS = new RotateAnimation(i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.bJS.setInterpolator(bJT);
        this.bJS.setDuration(150L);
        this.bJS.setFillAfter(true);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void k(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.bJV.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.bJV.requestLayout();
            this.bJV.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.bJV.setImageMatrix(matrix);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void ae(float f) {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rc() {
        if (this.bJR == this.bJV.getAnimation()) {
            this.bJV.startAnimation(this.bJS);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rd() {
        this.bJV.setVisibility(0);
        this.bJW.setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Re() {
        this.bJV.startAnimation(this.bJR);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Rf() {
        this.bJV.clearAnimation();
        this.bJW.setVisibility(8);
        this.bJV.setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (this.bJn) {
            case PULL_FROM_END:
                if (this.bKa == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 90.0f;
                }
                return 180.0f;
            case PULL_FROM_START:
                if (this.bKa != PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 0.0f;
                }
                return 270.0f;
            default:
                return 0.0f;
        }
    }
}
