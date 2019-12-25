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
    static final Interpolator bIB = new LinearInterpolator();
    protected final PullToRefreshBase.Mode dIF;
    private FrameLayout dJa;
    private boolean dJb;
    private final TextView dJc;
    private final TextView dJd;
    protected final PullToRefreshBase.Orientation dJe;
    private CharSequence dJf;
    private CharSequence dJg;
    private CharSequence dJh;
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
        this.dIF = mode;
        this.dJe = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.dJa = (FrameLayout) findViewById(R.id.fl_inner);
        this.dJc = (TextView) this.dJa.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.dJa.findViewById(R.id.pull_to_refresh_progress);
        this.dJd = (TextView) this.dJa.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.dJa.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dJa.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.dJf = context.getString(R.string.pull_to_refresh_pull_label);
                this.dJg = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.dJh = context.getString(R.string.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.dJf = context.getString(R.string.pull_to_refresh_pull_label);
                this.dJg = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.dJh = context.getString(R.string.pull_to_refresh_release_label);
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
                    a.cz("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(7);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(16)) {
                    drawable2 = typedArray.getDrawable(16);
                    break;
                } else if (typedArray.hasValue(17)) {
                    a.cz("ptrDrawableTop", "ptrDrawableStart");
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
        switch (this.dJe) {
            case HORIZONTAL:
                return this.dJa.getWidth();
            default:
                return this.dJa.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.dJb) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.dJc != null) {
            this.dJc.setText(this.dJf);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.dJc != null) {
            this.dJc.setText(this.dJg);
        }
        if (this.dJb) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.dJd != null) {
            this.dJd.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.dJc != null) {
            this.dJc.setText(this.dJh);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.dJc != null) {
            this.dJc.setText(this.dJf);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.dJb) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.dJd != null) {
            if (TextUtils.isEmpty(this.dJd.getText())) {
                this.dJd.setVisibility(8);
            } else {
                this.dJd.setVisibility(0);
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
        this.dJb = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.dJf = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.dJg = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.dJh = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.dJc.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.dJd != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dJd.setVisibility(8);
                return;
            }
            this.dJd.setText(charSequence);
            if (8 == this.dJd.getVisibility()) {
                this.dJd.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.dJd != null) {
            this.dJd.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.dJd != null) {
            this.dJd.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.dJc != null) {
            this.dJc.setTextAppearance(getContext(), i);
        }
        if (this.dJd != null) {
            this.dJd.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.dJc != null) {
            this.dJc.setTextColor(colorStateList);
        }
        if (this.dJd != null) {
            this.dJd.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.dJc != null) {
            this.dJc.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.dJc != null) {
            this.dJc.setTextSize(0, i);
        }
    }
}
