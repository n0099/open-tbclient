package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends b {
    private static /* synthetic */ int[] aHG;
    private final Animation aHU;
    private final Animation aHV;

    static /* synthetic */ int[] HR() {
        int[] iArr = aHG;
        if (iArr == null) {
            iArr = new int[PullToRefreshBase.Mode.valuesCustom().length];
            try {
                iArr[PullToRefreshBase.Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PullToRefreshBase.Mode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            aHG = iArr;
        }
        return iArr;
    }

    public a(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        this.aHU = new RotateAnimation(0.0f, i, 1, 0.5f, 1, 0.5f);
        this.aHU.setInterpolator(aHW);
        this.aHU.setDuration(150L);
        this.aHU.setFillAfter(true);
        this.aHV = new RotateAnimation(i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.aHV.setInterpolator(aHW);
        this.aHV.setDuration(150L);
        this.aHV.setFillAfter(true);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void f(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.aHY.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.aHY.requestLayout();
            this.aHY.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.aHY.setImageMatrix(matrix);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void P(float f) {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HU() {
        if (this.aHU == this.aHY.getAnimation()) {
            this.aHY.startAnimation(this.aHV);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HV() {
        this.aHY.setVisibility(0);
        this.aHZ.setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HW() {
        this.aHY.startAnimation(this.aHU);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void HX() {
        this.aHY.clearAnimation();
        this.aHZ.setVisibility(8);
        this.aHY.setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return t.f.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (HR()[this.aHo.ordinal()]) {
            case 2:
                if (this.aId != PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 0.0f;
                }
                return 270.0f;
            case 3:
                if (this.aId == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 90.0f;
                }
                return 180.0f;
            default:
                return 0.0f;
        }
    }
}
