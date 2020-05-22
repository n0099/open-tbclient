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
    static final Interpolator cxX = new LinearInterpolator();
    protected final PullToRefreshBase.Mode eBZ;
    private CharSequence eCA;
    private CharSequence eCB;
    private FrameLayout eCu;
    private boolean eCv;
    private final TextView eCw;
    private final TextView eCx;
    protected final PullToRefreshBase.Orientation eCy;
    private CharSequence eCz;
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
        this.eBZ = mode;
        this.eCy = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.eCu = (FrameLayout) findViewById(R.id.fl_inner);
        this.eCw = (TextView) this.eCu.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.eCu.findViewById(R.id.pull_to_refresh_progress);
        this.eCx = (TextView) this.eCu.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.eCu.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eCu.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.eCz = context.getString(R.string.pull_to_refresh_pull_label);
                this.eCA = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.eCB = context.getString(R.string.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.eCz = context.getString(R.string.pull_to_refresh_pull_label);
                this.eCA = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.eCB = context.getString(R.string.pull_to_refresh_release_label);
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
                    a.dr("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(7);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(16)) {
                    drawable2 = typedArray.getDrawable(16);
                    break;
                } else if (typedArray.hasValue(17)) {
                    a.dr("ptrDrawableTop", "ptrDrawableStart");
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
        switch (this.eCy) {
            case HORIZONTAL:
                return this.eCu.getWidth();
            default:
                return this.eCu.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.eCv) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.eCw != null) {
            this.eCw.setText(this.eCz);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.eCw != null) {
            this.eCw.setText(this.eCA);
        }
        if (this.eCv) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.eCx != null) {
            this.eCx.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.eCw != null) {
            this.eCw.setText(this.eCB);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.eCw != null) {
            this.eCw.setText(this.eCz);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.eCv) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.eCx != null) {
            if (TextUtils.isEmpty(this.eCx.getText())) {
                this.eCx.setVisibility(8);
            } else {
                this.eCx.setVisibility(0);
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
        this.eCv = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.eCz = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.eCA = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.eCB = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.eCw.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.eCx != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.eCx.setVisibility(8);
                return;
            }
            this.eCx.setText(charSequence);
            if (8 == this.eCx.getVisibility()) {
                this.eCx.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.eCx != null) {
            this.eCx.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.eCx != null) {
            this.eCx.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.eCw != null) {
            this.eCw.setTextAppearance(getContext(), i);
        }
        if (this.eCx != null) {
            this.eCx.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.eCw != null) {
            this.eCw.setTextColor(colorStateList);
        }
        if (this.eCx != null) {
            this.eCx.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.eCw != null) {
            this.eCw.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.eCw != null) {
            this.eCw.setTextSize(0, i);
        }
    }
}
