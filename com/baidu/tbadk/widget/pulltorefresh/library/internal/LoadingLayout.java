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
    protected final PullToRefreshBase.Mode bpE;
    private FrameLayout bqa;
    private boolean bqb;
    private final TextView bqc;
    private final TextView bqd;
    protected final PullToRefreshBase.Orientation bqe;
    private CharSequence bqf;
    private CharSequence bqg;
    private CharSequence bqh;
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
        this.bpE = mode;
        this.bqe = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(e.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(e.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bqa = (FrameLayout) findViewById(e.g.fl_inner);
        this.bqc = (TextView) this.bqa.findViewById(e.g.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.bqa.findViewById(e.g.pull_to_refresh_progress);
        this.bqd = (TextView) this.bqa.findViewById(e.g.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.bqa.findViewById(e.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bqa.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bqf = context.getString(e.j.pull_to_refresh_pull_label);
                this.bqg = context.getString(e.j.pull_to_refresh_refreshing_label);
                this.bqh = context.getString(e.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bqf = context.getString(e.j.pull_to_refresh_pull_label);
                this.bqg = context.getString(e.j.pull_to_refresh_refreshing_label);
                this.bqh = context.getString(e.j.pull_to_refresh_release_label);
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
                    a.aS("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(e.l.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(e.l.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrDrawableTop)) {
                    a.aS("ptrDrawableTop", "ptrDrawableStart");
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
        switch (this.bqe) {
            case HORIZONTAL:
                return this.bqa.getWidth();
            default:
                return this.bqa.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bqb) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.bqc != null) {
            this.bqc.setText(this.bqf);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.bqc != null) {
            this.bqc.setText(this.bqg);
        }
        if (this.bqb) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.bqd != null) {
            this.bqd.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.bqc != null) {
            this.bqc.setText(this.bqh);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.bqc != null) {
            this.bqc.setText(this.bqf);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.bqb) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.bqd != null) {
            if (TextUtils.isEmpty(this.bqd.getText())) {
                this.bqd.setVisibility(8);
            } else {
                this.bqd.setVisibility(0);
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
        this.bqb = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bqf = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bqg = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bqh = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.bqc.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bqd != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bqd.setVisibility(8);
                return;
            }
            this.bqd.setText(charSequence);
            if (8 == this.bqd.getVisibility()) {
                this.bqd.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bqd != null) {
            this.bqd.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bqd != null) {
            this.bqd.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.bqc != null) {
            this.bqc.setTextAppearance(getContext(), i);
        }
        if (this.bqd != null) {
            this.bqd.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.bqc != null) {
            this.bqc.setTextColor(colorStateList);
        }
        if (this.bqd != null) {
            this.bqd.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.bqc != null) {
            this.bqc.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.bqc != null) {
            this.bqc.setTextSize(0, i);
        }
    }
}
