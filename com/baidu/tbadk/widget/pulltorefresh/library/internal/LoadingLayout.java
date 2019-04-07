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
import com.baidu.tieba.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator aJY = new LinearInterpolator();
    private FrameLayout cBE;
    private boolean cBF;
    private final TextView cBG;
    private final TextView cBH;
    protected final PullToRefreshBase.Orientation cBI;
    private CharSequence cBJ;
    private CharSequence cBK;
    private CharSequence cBL;
    protected final PullToRefreshBase.Mode cBi;
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
        this.cBi = mode;
        this.cBI = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.cBE = (FrameLayout) findViewById(d.g.fl_inner);
        this.cBG = (TextView) this.cBE.findViewById(d.g.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.cBE.findViewById(d.g.pull_to_refresh_progress);
        this.cBH = (TextView) this.cBE.findViewById(d.g.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.cBE.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cBE.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.cBJ = context.getString(d.j.pull_to_refresh_pull_label);
                this.cBK = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.cBL = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.cBJ = context.getString(d.j.pull_to_refresh_pull_label);
                this.cBK = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.cBL = context.getString(d.j.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            b.setBackground(this, drawable);
        }
        if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(d.l.PullToRefresh_tb_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrSubHeaderTextAppearance)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(d.l.PullToRefresh_tb_ptrSubHeaderTextAppearance, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrHeaderTextColor) && (colorStateList2 = typedArray.getColorStateList(d.l.PullToRefresh_tb_ptrHeaderTextColor)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrHeaderSubTextColor) && (colorStateList = typedArray.getColorStateList(d.l.PullToRefresh_tb_ptrHeaderSubTextColor)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawable) ? typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawable) : null;
        switch (mode) {
            case PULL_FROM_END:
                if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableEnd)) {
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableEnd);
                    break;
                } else if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableBottom)) {
                    a.bY("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableTop)) {
                    a.bY("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableTop);
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
        switch (this.cBI) {
            case HORIZONTAL:
                return this.cBE.getWidth();
            default:
                return this.cBE.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.cBF) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.cBG != null) {
            this.cBG.setText(this.cBJ);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.cBG != null) {
            this.cBG.setText(this.cBK);
        }
        if (this.cBF) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.cBH != null) {
            this.cBH.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.cBG != null) {
            this.cBG.setText(this.cBL);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.cBG != null) {
            this.cBG.setText(this.cBJ);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.cBF) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.cBH != null) {
            if (TextUtils.isEmpty(this.cBH.getText())) {
                this.cBH.setVisibility(8);
            } else {
                this.cBH.setVisibility(0);
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
        this.cBF = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.cBJ = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.cBK = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.cBL = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.cBG.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.cBH != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cBH.setVisibility(8);
                return;
            }
            this.cBH.setText(charSequence);
            if (8 == this.cBH.getVisibility()) {
                this.cBH.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.cBH != null) {
            this.cBH.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.cBH != null) {
            this.cBH.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.cBG != null) {
            this.cBG.setTextAppearance(getContext(), i);
        }
        if (this.cBH != null) {
            this.cBH.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.cBG != null) {
            this.cBG.setTextColor(colorStateList);
        }
        if (this.cBH != null) {
            this.cBH.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.cBG != null) {
            this.cBG.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.cBG != null) {
            this.cBG.setTextSize(0, i);
        }
    }
}
