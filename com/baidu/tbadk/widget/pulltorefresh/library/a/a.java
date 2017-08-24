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
    private final Animation aQj;
    private final Animation aQk;

    public a(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        this.aQj = new RotateAnimation(0.0f, i, 1, 0.5f, 1, 0.5f);
        this.aQj.setInterpolator(aQl);
        this.aQj.setDuration(150L);
        this.aQj.setFillAfter(true);
        this.aQk = new RotateAnimation(i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.aQk.setInterpolator(aQl);
        this.aQk.setDuration(150L);
        this.aQk.setFillAfter(true);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void f(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.aQn.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.aQn.requestLayout();
            this.aQn.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.aQn.setImageMatrix(matrix);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Q(float f) {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ih() {
        if (this.aQj == this.aQn.getAnimation()) {
            this.aQn.startAnimation(this.aQk);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ii() {
        this.aQn.setVisibility(0);
        this.aQo.setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ij() {
        this.aQn.startAnimation(this.aQj);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ik() {
        this.aQn.clearAnimation();
        this.aQo.setVisibility(8);
        this.aQn.setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.g.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (this.aPD) {
            case PULL_FROM_END:
                if (this.aQs == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 90.0f;
                }
                return 180.0f;
            case PULL_FROM_START:
                if (this.aQs != PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 0.0f;
                }
                return 270.0f;
            default:
                return 0.0f;
        }
    }
}
