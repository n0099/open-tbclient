package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator bgi = new LinearInterpolator();
    private final TextView cVA;
    private final TextView cVB;
    protected final PullToRefreshBase.Orientation cVC;
    private CharSequence cVD;
    private CharSequence cVE;
    private CharSequence cVF;
    protected final PullToRefreshBase.Mode cVd;
    private FrameLayout cVy;
    private boolean cVz;
    protected final ImageView mHeaderImage;
    protected final ProgressBar mHeaderProgress;

    protected abstract int getDefaultDrawableResId();

    protected abstract void onLoadingDrawableSet(Drawable drawable);

    protected abstract void onPullImpl(float f);

    protected abstract void pullToRefreshImpl();

    protected abstract void refreshingImpl();

    protected abstract void releaseToRefreshImpl();

    protected abstract void resetImpl();

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.cVd = mode;
        this.cVC = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.cVy = (FrameLayout) findViewById(R.id.fl_inner);
        this.cVA = (TextView) this.cVy.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.cVy.findViewById(R.id.pull_to_refresh_progress);
        this.cVB = (TextView) this.cVy.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.cVy.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cVy.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.cVD = context.getString(R.string.pull_to_refresh_pull_label);
                this.cVE = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.cVF = context.getString(R.string.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.cVD = context.getString(R.string.pull_to_refresh_pull_label);
                this.cVE = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.cVF = context.getString(R.string.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(18) && (drawable = typedArray.getDrawable(18)) != null) {
            b.setBackground(this, drawable);
        }
        if (typedArray.hasValue(2)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(2, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(11)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(11, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(4) && (colorStateList2 = typedArray.getColorStateList(4)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(0) && (colorStateList = typedArray.getColorStateList(0)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(14) ? typedArray.getDrawable(14) : null;
        switch (mode) {
            case PULL_FROM_END:
                if (typedArray.hasValue(5)) {
                    drawable2 = typedArray.getDrawable(5);
                    break;
                } else if (typedArray.hasValue(7)) {
                    a.cc("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(7);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(16)) {
                    drawable2 = typedArray.getDrawable(16);
                    break;
                } else if (typedArray.hasValue(17)) {
                    a.cc("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(17);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? am.getDrawable(getDefaultDrawableResId()) : drawable2);
        reset();
    }

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }

    public final int getContentSize() {
        switch (this.cVC) {
            case HORIZONTAL:
                return this.cVy.getWidth();
            default:
                return this.cVy.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.cVz) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.cVA != null) {
            this.cVA.setText(this.cVD);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.cVA != null) {
            this.cVA.setText(this.cVE);
        }
        if (this.cVz) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.cVB != null) {
            this.cVB.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.cVA != null) {
            this.cVA.setText(this.cVF);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.cVA != null) {
            this.cVA.setText(this.cVD);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.cVz) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.cVB != null) {
            if (TextUtils.isEmpty(this.cVB.getText())) {
                this.cVB.setVisibility(8);
            } else {
                this.cVB.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.mHeaderImage.setImageDrawable(drawable);
        this.cVz = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.cVD = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.cVE = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.cVF = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.cVA.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.cVB != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cVB.setVisibility(8);
                return;
            }
            this.cVB.setText(charSequence);
            if (8 == this.cVB.getVisibility()) {
                this.cVB.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.cVB != null) {
            this.cVB.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.cVB != null) {
            this.cVB.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.cVA != null) {
            this.cVA.setTextAppearance(getContext(), i);
        }
        if (this.cVB != null) {
            this.cVB.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.cVA != null) {
            this.cVA.setTextColor(colorStateList);
        }
        if (this.cVB != null) {
            this.cVB.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.cVA != null) {
            this.cVA.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.cVA != null) {
            this.cVA.setTextSize(0, i);
        }
    }
}
