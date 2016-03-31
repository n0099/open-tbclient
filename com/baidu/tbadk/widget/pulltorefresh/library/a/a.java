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
    private static /* synthetic */ int[] aHh;
    private final Animation aHv;
    private final Animation aHw;

    static /* synthetic */ int[] Id() {
        int[] iArr = aHh;
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
            aHh = iArr;
        }
        return iArr;
    }

    public a(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        this.aHv = new RotateAnimation(0.0f, i, 1, 0.5f, 1, 0.5f);
        this.aHv.setInterpolator(aHx);
        this.aHv.setDuration(150L);
        this.aHv.setFillAfter(true);
        this.aHw = new RotateAnimation(i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.aHw.setInterpolator(aHx);
        this.aHw.setDuration(150L);
        this.aHw.setFillAfter(true);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void d(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.aHz.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.aHz.requestLayout();
            this.aHz.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.aHz.setImageMatrix(matrix);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void v(float f) {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ig() {
        if (this.aHv == this.aHz.getAnimation()) {
            this.aHz.startAnimation(this.aHw);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ih() {
        this.aHz.setVisibility(0);
        this.aHA.setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ii() {
        this.aHz.startAnimation(this.aHv);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Ij() {
        this.aHz.clearAnimation();
        this.aHA.setVisibility(8);
        this.aHz.setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return t.f.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (Id()[this.aGP.ordinal()]) {
            case 2:
                if (this.aHE != PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 0.0f;
                }
                return 270.0f;
            case 3:
                if (this.aHE == PullToRefreshBase.Orientation.HORIZONTAL) {
                    return 90.0f;
                }
                return 180.0f;
            default:
                return 0.0f;
        }
    }
}
