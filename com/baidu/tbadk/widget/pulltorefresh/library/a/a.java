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
    private final Animation aQE;
    private final Animation aQF;

    public a(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        this.aQE = new RotateAnimation(0.0f, i, 1, 0.5f, 1, 0.5f);
        this.aQE.setInterpolator(aQG);
        this.aQE.setDuration(150L);
        this.aQE.setFillAfter(true);
        this.aQF = new RotateAnimation(i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.aQF.setInterpolator(aQG);
        this.aQF.setDuration(150L);
        this.aQF.setFillAfter(true);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void e(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.aQI.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.aQI.requestLayout();
            this.aQI.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.aQI.setImageMatrix(matrix);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void I(float f) {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ir() {
        if (this.aQE == this.aQI.getAnimation()) {
            this.aQI.startAnimation(this.aQF);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Is() {
        this.aQI.setVisibility(0);
        this.aQJ.setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void It() {
        this.aQI.startAnimation(this.aQE);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Iu() {
        this.aQI.clearAnimation();
        this.aQJ.setVisibility(8);
        this.aQI.setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return d.g.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (this.aQa) {
            case PULL_FROM_END:
                if (this.aQN == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 90.0f;
                }
                return 180.0f;
            case PULL_FROM_START:
                if (this.aQN != PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 0.0f;
                }
                return 270.0f;
            default:
                return 0.0f;
        }
    }
}
