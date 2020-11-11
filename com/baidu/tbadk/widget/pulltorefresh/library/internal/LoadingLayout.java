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
    static final Interpolator dqY = new LinearInterpolator();
    protected final PullToRefreshBase.Mode fGT;
    private FrameLayout fHo;
    private boolean fHp;
    private final TextView fHq;
    private final TextView fHr;
    protected final PullToRefreshBase.Orientation fHs;
    private CharSequence fHt;
    private CharSequence fHu;
    private CharSequence fHv;
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
        this.fGT = mode;
        this.fHs = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.fHo = (FrameLayout) findViewById(R.id.fl_inner);
        this.fHq = (TextView) this.fHo.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.fHo.findViewById(R.id.pull_to_refresh_progress);
        this.fHr = (TextView) this.fHo.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.fHo.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fHo.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.fHt = context.getString(R.string.pull_to_refresh_pull_label);
                this.fHu = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.fHv = context.getString(R.string.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.fHt = context.getString(R.string.pull_to_refresh_pull_label);
                this.fHu = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.fHv = context.getString(R.string.pull_to_refresh_release_label);
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
        switch (this.fHs) {
            case HORIZONTAL:
                return this.fHo.getWidth();
            default:
                return this.fHo.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.fHp) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.fHq != null) {
            this.fHq.setText(this.fHt);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.fHq != null) {
            this.fHq.setText(this.fHu);
        }
        if (this.fHp) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.fHr != null) {
            this.fHr.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.fHq != null) {
            this.fHq.setText(this.fHv);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.fHq != null) {
            this.fHq.setText(this.fHt);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.fHp) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.fHr != null) {
            if (TextUtils.isEmpty(this.fHr.getText())) {
                this.fHr.setVisibility(8);
            } else {
                this.fHr.setVisibility(0);
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
        this.fHp = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.fHt = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.fHu = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.fHv = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.fHq.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.fHr != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.fHr.setVisibility(8);
                return;
            }
            this.fHr.setText(charSequence);
            if (8 == this.fHr.getVisibility()) {
                this.fHr.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.fHr != null) {
            this.fHr.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.fHr != null) {
            this.fHr.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.fHq != null) {
            this.fHq.setTextAppearance(getContext(), i);
        }
        if (this.fHr != null) {
            this.fHr.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.fHq != null) {
            this.fHq.setTextColor(colorStateList);
        }
        if (this.fHr != null) {
            this.fHr.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.fHq != null) {
            this.fHq.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.fHq != null) {
            this.fHq.setTextSize(0, i);
        }
    }
}
