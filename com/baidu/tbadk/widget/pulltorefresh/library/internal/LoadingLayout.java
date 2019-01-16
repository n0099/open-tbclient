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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.e;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    private FrameLayout bqR;
    private boolean bqS;
    private final TextView bqT;
    private final TextView bqU;
    protected final PullToRefreshBase.Orientation bqV;
    private CharSequence bqW;
    private CharSequence bqX;
    private CharSequence bqY;
    protected final PullToRefreshBase.Mode bqv;
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
        this.bqv = mode;
        this.bqV = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(e.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(e.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bqR = (FrameLayout) findViewById(e.g.fl_inner);
        this.bqT = (TextView) this.bqR.findViewById(e.g.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.bqR.findViewById(e.g.pull_to_refresh_progress);
        this.bqU = (TextView) this.bqR.findViewById(e.g.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.bqR.findViewById(e.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bqR.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bqW = context.getString(e.j.pull_to_refresh_pull_label);
                this.bqX = context.getString(e.j.pull_to_refresh_refreshing_label);
                this.bqY = context.getString(e.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bqW = context.getString(e.j.pull_to_refresh_pull_label);
                this.bqX = context.getString(e.j.pull_to_refresh_refreshing_label);
                this.bqY = context.getString(e.j.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(e.l.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            b.setBackground(this, drawable);
        }
        if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(e.l.PullToRefresh_tb_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrSubHeaderTextAppearance)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(e.l.PullToRefresh_tb_ptrSubHeaderTextAppearance, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrHeaderTextColor) && (colorStateList2 = typedArray.getColorStateList(e.l.PullToRefresh_tb_ptrHeaderTextColor)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrHeaderSubTextColor) && (colorStateList = typedArray.getColorStateList(e.l.PullToRefresh_tb_ptrHeaderSubTextColor)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(e.l.PullToRefresh_tb_ptrDrawable) ? typedArray.getDrawable(e.l.PullToRefresh_tb_ptrDrawable) : null;
        switch (mode) {
            case PULL_FROM_END:
                if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrDrawableEnd)) {
                    drawable2 = typedArray.getDrawable(e.l.PullToRefresh_tb_ptrDrawableEnd);
                    break;
                } else if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrDrawableBottom)) {
                    a.aT("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(e.l.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(e.l.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrDrawableTop)) {
                    a.aT("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(e.l.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? al.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.bqV) {
            case HORIZONTAL:
                return this.bqR.getWidth();
            default:
                return this.bqR.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bqS) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.bqT != null) {
            this.bqT.setText(this.bqW);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.bqT != null) {
            this.bqT.setText(this.bqX);
        }
        if (this.bqS) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.bqU != null) {
            this.bqU.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.bqT != null) {
            this.bqT.setText(this.bqY);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.bqT != null) {
            this.bqT.setText(this.bqW);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.bqS) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.bqU != null) {
            if (TextUtils.isEmpty(this.bqU.getText())) {
                this.bqU.setVisibility(8);
            } else {
                this.bqU.setVisibility(0);
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
        this.bqS = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bqW = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bqX = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bqY = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.bqT.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bqU != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bqU.setVisibility(8);
                return;
            }
            this.bqU.setText(charSequence);
            if (8 == this.bqU.getVisibility()) {
                this.bqU.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bqU != null) {
            this.bqU.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bqU != null) {
            this.bqU.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.bqT != null) {
            this.bqT.setTextAppearance(getContext(), i);
        }
        if (this.bqU != null) {
            this.bqU.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.bqT != null) {
            this.bqT.setTextColor(colorStateList);
        }
        if (this.bqU != null) {
            this.bqU.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.bqT != null) {
            this.bqT.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.bqT != null) {
            this.bqT.setTextSize(0, i);
        }
    }
}
