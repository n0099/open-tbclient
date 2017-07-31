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
    private final Animation aQh;
    private final Animation aQi;

    public a(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        this.aQh = new RotateAnimation(0.0f, i, 1, 0.5f, 1, 0.5f);
        this.aQh.setInterpolator(aQj);
        this.aQh.setDuration(150L);
        this.aQh.setFillAfter(true);
        this.aQi = new RotateAnimation(i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.aQi.setInterpolator(aQj);
        this.aQi.setDuration(150L);
        this.aQi.setFillAfter(true);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void f(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.aQl.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.aQl.requestLayout();
            this.aQl.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.aQl.setImageMatrix(matrix);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Q(float f) {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ih() {
        if (this.aQh == this.aQl.getAnimation()) {
            this.aQl.startAnimation(this.aQi);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ii() {
        this.aQl.setVisibility(0);
        this.aQm.setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ij() {
        this.aQl.startAnimation(this.aQh);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ik() {
        this.aQl.clearAnimation();
        this.aQm.setVisibility(8);
        this.aQl.setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.g.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (this.aPB) {
            case PULL_FROM_END:
                if (this.aQq == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 90.0f;
                }
                return 180.0f;
            case PULL_FROM_START:
                if (this.aQq != PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 0.0f;
                }
                return 270.0f;
            default:
                return 0.0f;
        }
    }
}
