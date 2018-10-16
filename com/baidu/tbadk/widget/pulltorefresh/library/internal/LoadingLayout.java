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
    private FrameLayout blR;
    private boolean blS;
    private final TextView blT;
    private final TextView blU;
    protected final PullToRefreshBase.Orientation blV;
    private CharSequence blW;
    private CharSequence blX;
    private CharSequence blY;
    protected final PullToRefreshBase.Mode blv;
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
        this.blv = mode;
        this.blV = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(e.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(e.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.blR = (FrameLayout) findViewById(e.g.fl_inner);
        this.blT = (TextView) this.blR.findViewById(e.g.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.blR.findViewById(e.g.pull_to_refresh_progress);
        this.blU = (TextView) this.blR.findViewById(e.g.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.blR.findViewById(e.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.blR.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.blW = context.getString(e.j.pull_to_refresh_pull_label);
                this.blX = context.getString(e.j.pull_to_refresh_refreshing_label);
                this.blY = context.getString(e.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.blW = context.getString(e.j.pull_to_refresh_pull_label);
                this.blX = context.getString(e.j.pull_to_refresh_refreshing_label);
                this.blY = context.getString(e.j.pull_to_refresh_release_label);
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
                    a.aP("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(e.l.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(e.l.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(e.l.PullToRefresh_tb_ptrDrawableTop)) {
                    a.aP("ptrDrawableTop", "ptrDrawableStart");
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
        switch (this.blV) {
            case HORIZONTAL:
                return this.blR.getWidth();
            default:
                return this.blR.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.blS) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.blT != null) {
            this.blT.setText(this.blW);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.blT != null) {
            this.blT.setText(this.blX);
        }
        if (this.blS) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.blU != null) {
            this.blU.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.blT != null) {
            this.blT.setText(this.blY);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.blT != null) {
            this.blT.setText(this.blW);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.blS) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.blU != null) {
            if (TextUtils.isEmpty(this.blU.getText())) {
                this.blU.setVisibility(8);
            } else {
                this.blU.setVisibility(0);
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
        this.blS = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.blW = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.blX = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.blY = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.blT.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.blU != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.blU.setVisibility(8);
                return;
            }
            this.blU.setText(charSequence);
            if (8 == this.blU.getVisibility()) {
                this.blU.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.blU != null) {
            this.blU.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.blU != null) {
            this.blU.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.blT != null) {
            this.blT.setTextAppearance(getContext(), i);
        }
        if (this.blU != null) {
            this.blU.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.blT != null) {
            this.blT.setTextColor(colorStateList);
        }
        if (this.blU != null) {
            this.blU.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.blT != null) {
            this.blT.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.blT != null) {
            this.blT.setTextSize(0, i);
        }
    }
}
