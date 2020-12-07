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
    static final Interpolator dws = new LinearInterpolator();
    private FrameLayout fOC;
    private boolean fOD;
    private final TextView fOE;
    private final TextView fOF;
    protected final PullToRefreshBase.Orientation fOG;
    private CharSequence fOH;
    private CharSequence fOI;
    private CharSequence fOJ;
    protected final PullToRefreshBase.Mode fOh;
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
        this.fOh = mode;
        this.fOG = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.fOC = (FrameLayout) findViewById(R.id.fl_inner);
        this.fOE = (TextView) this.fOC.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.fOC.findViewById(R.id.pull_to_refresh_progress);
        this.fOF = (TextView) this.fOC.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.fOC.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fOC.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.fOH = context.getString(R.string.pull_to_refresh_pull_label);
                this.fOI = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.fOJ = context.getString(R.string.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.fOH = context.getString(R.string.pull_to_refresh_pull_label);
                this.fOI = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.fOJ = context.getString(R.string.pull_to_refresh_release_label);
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
                    a.eh("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(R.styleable.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(R.styleable.PullToRefresh_tb_ptrDrawableTop)) {
                    a.eh("ptrDrawableTop", "ptrDrawableStart");
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
        switch (this.fOG) {
            case HORIZONTAL:
                return this.fOC.getWidth();
            default:
                return this.fOC.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.fOD) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.fOE != null) {
            this.fOE.setText(this.fOH);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.fOE != null) {
            this.fOE.setText(this.fOI);
        }
        if (this.fOD) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.fOF != null) {
            this.fOF.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.fOE != null) {
            this.fOE.setText(this.fOJ);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.fOE != null) {
            this.fOE.setText(this.fOH);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.fOD) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.fOF != null) {
            if (TextUtils.isEmpty(this.fOF.getText())) {
                this.fOF.setVisibility(8);
            } else {
                this.fOF.setVisibility(0);
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
        this.fOD = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.fOH = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.fOI = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.fOJ = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.fOE.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.fOF != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.fOF.setVisibility(8);
                return;
            }
            this.fOF.setText(charSequence);
            if (8 == this.fOF.getVisibility()) {
                this.fOF.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.fOF != null) {
            this.fOF.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.fOF != null) {
            this.fOF.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.fOE != null) {
            this.fOE.setTextAppearance(getContext(), i);
        }
        if (this.fOF != null) {
            this.fOF.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.fOE != null) {
            this.fOE.setTextColor(colorStateList);
        }
        if (this.fOF != null) {
            this.fOF.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.fOE != null) {
            this.fOE.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.fOE != null) {
            this.fOE.setTextSize(0, i);
        }
    }
}
