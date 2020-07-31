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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator cFu = new LinearInterpolator();
    protected final PullToRefreshBase.Mode eSO;
    private FrameLayout eTj;
    private boolean eTk;
    private final TextView eTl;
    private final TextView eTm;
    protected final PullToRefreshBase.Orientation eTn;
    private CharSequence eTo;
    private CharSequence eTp;
    private CharSequence eTq;
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
        this.eSO = mode;
        this.eTn = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.eTj = (FrameLayout) findViewById(R.id.fl_inner);
        this.eTl = (TextView) this.eTj.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.eTj.findViewById(R.id.pull_to_refresh_progress);
        this.eTm = (TextView) this.eTj.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.eTj.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eTj.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.eTo = context.getString(R.string.pull_to_refresh_pull_label);
                this.eTp = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.eTq = context.getString(R.string.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.eTo = context.getString(R.string.pull_to_refresh_pull_label);
                this.eTp = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.eTq = context.getString(R.string.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            b.setBackground(this, drawable);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(R.styleable.PullToRefresh_tb_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrSubHeaderTextAppearance)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(R.styleable.PullToRefresh_tb_ptrSubHeaderTextAppearance, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrHeaderTextColor) && (colorStateList2 = typedArray.getColorStateList(R.styleable.PullToRefresh_tb_ptrHeaderTextColor)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrHeaderSubTextColor) && (colorStateList = typedArray.getColorStateList(R.styleable.PullToRefresh_tb_ptrHeaderSubTextColor)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrDrawable) ? typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawable) : null;
        switch (mode) {
            case PULL_FROM_END:
                if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrDrawableEnd)) {
                    drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawableEnd);
                    break;
                } else if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrDrawableBottom)) {
                    a.dv("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrDrawableTop)) {
                    a.dv("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? ao.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.eTn) {
            case HORIZONTAL:
                return this.eTj.getWidth();
            default:
                return this.eTj.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.eTk) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.eTl != null) {
            this.eTl.setText(this.eTo);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.eTl != null) {
            this.eTl.setText(this.eTp);
        }
        if (this.eTk) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.eTm != null) {
            this.eTm.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.eTl != null) {
            this.eTl.setText(this.eTq);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.eTl != null) {
            this.eTl.setText(this.eTo);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.eTk) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.eTm != null) {
            if (TextUtils.isEmpty(this.eTm.getText())) {
                this.eTm.setVisibility(8);
            } else {
                this.eTm.setVisibility(0);
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
        this.eTk = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.eTo = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.eTp = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.eTq = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.eTl.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.eTm != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.eTm.setVisibility(8);
                return;
            }
            this.eTm.setText(charSequence);
            if (8 == this.eTm.getVisibility()) {
                this.eTm.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.eTm != null) {
            this.eTm.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.eTm != null) {
            this.eTm.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.eTl != null) {
            this.eTl.setTextAppearance(getContext(), i);
        }
        if (this.eTm != null) {
            this.eTm.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.eTl != null) {
            this.eTl.setTextColor(colorStateList);
        }
        if (this.eTm != null) {
            this.eTm.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.eTl != null) {
            this.eTl.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.eTl != null) {
            this.eTl.setTextSize(0, i);
        }
    }
}
