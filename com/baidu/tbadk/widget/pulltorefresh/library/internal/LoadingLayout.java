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
    static final Interpolator aJV = new LinearInterpolator();
    private FrameLayout cBC;
    private boolean cBD;
    private final TextView cBE;
    private final TextView cBF;
    protected final PullToRefreshBase.Orientation cBG;
    private CharSequence cBH;
    private CharSequence cBI;
    private CharSequence cBJ;
    protected final PullToRefreshBase.Mode cBg;
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
        this.cBg = mode;
        this.cBG = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.cBC = (FrameLayout) findViewById(d.g.fl_inner);
        this.cBE = (TextView) this.cBC.findViewById(d.g.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.cBC.findViewById(d.g.pull_to_refresh_progress);
        this.cBF = (TextView) this.cBC.findViewById(d.g.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.cBC.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cBC.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.cBH = context.getString(d.j.pull_to_refresh_pull_label);
                this.cBI = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.cBJ = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.cBH = context.getString(d.j.pull_to_refresh_pull_label);
                this.cBI = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.cBJ = context.getString(d.j.pull_to_refresh_release_label);
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
        switch (this.cBG) {
            case HORIZONTAL:
                return this.cBC.getWidth();
            default:
                return this.cBC.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.cBD) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.cBE != null) {
            this.cBE.setText(this.cBH);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.cBE != null) {
            this.cBE.setText(this.cBI);
        }
        if (this.cBD) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.cBF != null) {
            this.cBF.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.cBE != null) {
            this.cBE.setText(this.cBJ);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.cBE != null) {
            this.cBE.setText(this.cBH);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.cBD) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.cBF != null) {
            if (TextUtils.isEmpty(this.cBF.getText())) {
                this.cBF.setVisibility(8);
            } else {
                this.cBF.setVisibility(0);
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
        this.cBD = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.cBH = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.cBI = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.cBJ = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.cBE.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.cBF != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cBF.setVisibility(8);
                return;
            }
            this.cBF.setText(charSequence);
            if (8 == this.cBF.getVisibility()) {
                this.cBF.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.cBF != null) {
            this.cBF.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.cBF != null) {
            this.cBF.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.cBE != null) {
            this.cBE.setTextAppearance(getContext(), i);
        }
        if (this.cBF != null) {
            this.cBF.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.cBE != null) {
            this.cBE.setTextColor(colorStateList);
        }
        if (this.cBF != null) {
            this.cBF.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.cBE != null) {
            this.cBE.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.cBE != null) {
            this.cBE.setTextSize(0, i);
        }
    }
}
