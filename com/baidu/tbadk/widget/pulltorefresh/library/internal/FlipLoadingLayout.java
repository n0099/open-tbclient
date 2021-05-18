package com.baidu.tbadk.widget.pulltorefresh.library.internal;

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
import com.baidu.tieba.R;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class FlipLoadingLayout extends LoadingLayout {
    public final Animation q;
    public final Animation r;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13326a;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            f13326a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13326a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FlipLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        float f2 = mode == PullToRefreshBase.Mode.PULL_FROM_START ? -180 : 180;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f2, 1, 0.5f, 1, 0.5f);
        this.q = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.p);
        this.q.setDuration(150L);
        this.q.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(f2, 0.0f, 1, 0.5f, 1, 0.5f);
        this.r = rotateAnimation2;
        rotateAnimation2.setInterpolator(LoadingLayout.p);
        this.r.setDuration(150L);
        this.r.setFillAfter(true);
    }

    private float getDrawableRotationAngle() {
        int i2 = a.f13326a[this.k.ordinal()];
        return i2 != 1 ? (i2 == 2 && this.l == PullToRefreshBase.Orientation.HORIZONTAL) ? 270.0f : 0.0f : this.l == PullToRefreshBase.Orientation.HORIZONTAL ? 90.0f : 180.0f;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void a(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.f13328f.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.f13328f.requestLayout();
            this.f13328f.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.f13328f.setImageMatrix(matrix);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void c(float f2) {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void e() {
        if (this.q == this.f13328f.getAnimation()) {
            this.f13328f.startAnimation(this.r);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void g() {
        this.f13328f.setVisibility(0);
        this.f13329g.setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public int getDefaultDrawableResId() {
        return R.drawable.default_ptr_flip;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void i() {
        this.f13328f.startAnimation(this.q);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void k() {
        this.f13328f.clearAnimation();
        this.f13329g.setVisibility(8);
        this.f13328f.setVisibility(0);
    }
}
