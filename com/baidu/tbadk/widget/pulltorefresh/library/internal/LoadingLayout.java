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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator dpr = new LinearInterpolator();
    private FrameLayout fGQ;
    private boolean fGR;
    private final TextView fGS;
    private final TextView fGT;
    protected final PullToRefreshBase.Orientation fGU;
    private CharSequence fGV;
    private CharSequence fGW;
    private CharSequence fGX;
    protected final PullToRefreshBase.Mode fGv;
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
        this.fGv = mode;
        this.fGU = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.fGQ = (FrameLayout) findViewById(R.id.fl_inner);
        this.fGS = (TextView) this.fGQ.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.fGQ.findViewById(R.id.pull_to_refresh_progress);
        this.fGT = (TextView) this.fGQ.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.fGQ.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fGQ.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.fGV = context.getString(R.string.pull_to_refresh_pull_label);
                this.fGW = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.fGX = context.getString(R.string.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.fGV = context.getString(R.string.pull_to_refresh_pull_label);
                this.fGW = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.fGX = context.getString(R.string.pull_to_refresh_release_label);
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
                    a.ea("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrDrawableTop)) {
                    a.ea("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? ap.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.fGU) {
            case HORIZONTAL:
                return this.fGQ.getWidth();
            default:
                return this.fGQ.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.fGR) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.fGS != null) {
            this.fGS.setText(this.fGV);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.fGS != null) {
            this.fGS.setText(this.fGW);
        }
        if (this.fGR) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.fGT != null) {
            this.fGT.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.fGS != null) {
            this.fGS.setText(this.fGX);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.fGS != null) {
            this.fGS.setText(this.fGV);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.fGR) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.fGT != null) {
            if (TextUtils.isEmpty(this.fGT.getText())) {
                this.fGT.setVisibility(8);
            } else {
                this.fGT.setVisibility(0);
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
        this.fGR = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.fGV = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.fGW = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.fGX = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.fGS.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.fGT != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.fGT.setVisibility(8);
                return;
            }
            this.fGT.setText(charSequence);
            if (8 == this.fGT.getVisibility()) {
                this.fGT.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.fGT != null) {
            this.fGT.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.fGT != null) {
            this.fGT.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.fGS != null) {
            this.fGS.setTextAppearance(getContext(), i);
        }
        if (this.fGT != null) {
            this.fGT.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.fGS != null) {
            this.fGS.setTextColor(colorStateList);
        }
        if (this.fGT != null) {
            this.fGT.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.fGS != null) {
            this.fGS.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.fGS != null) {
            this.fGS.setTextSize(0, i);
        }
    }
}
