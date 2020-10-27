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
    static final Interpolator dld = new LinearInterpolator();
    private final TextView fBA;
    private final TextView fBB;
    protected final PullToRefreshBase.Orientation fBC;
    private CharSequence fBD;
    private CharSequence fBE;
    private CharSequence fBF;
    protected final PullToRefreshBase.Mode fBd;
    private FrameLayout fBy;
    private boolean fBz;
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
        this.fBd = mode;
        this.fBC = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.fBy = (FrameLayout) findViewById(R.id.fl_inner);
        this.fBA = (TextView) this.fBy.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.fBy.findViewById(R.id.pull_to_refresh_progress);
        this.fBB = (TextView) this.fBy.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.fBy.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fBy.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.fBD = context.getString(R.string.pull_to_refresh_pull_label);
                this.fBE = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.fBF = context.getString(R.string.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.fBD = context.getString(R.string.pull_to_refresh_pull_label);
                this.fBE = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.fBF = context.getString(R.string.pull_to_refresh_release_label);
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
        switch (this.fBC) {
            case HORIZONTAL:
                return this.fBy.getWidth();
            default:
                return this.fBy.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.fBz) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.fBA != null) {
            this.fBA.setText(this.fBD);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.fBA != null) {
            this.fBA.setText(this.fBE);
        }
        if (this.fBz) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.fBB != null) {
            this.fBB.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.fBA != null) {
            this.fBA.setText(this.fBF);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.fBA != null) {
            this.fBA.setText(this.fBD);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.fBz) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.fBB != null) {
            if (TextUtils.isEmpty(this.fBB.getText())) {
                this.fBB.setVisibility(8);
            } else {
                this.fBB.setVisibility(0);
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
        this.fBz = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.fBD = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.fBE = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.fBF = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.fBA.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.fBB != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.fBB.setVisibility(8);
                return;
            }
            this.fBB.setText(charSequence);
            if (8 == this.fBB.getVisibility()) {
                this.fBB.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.fBB != null) {
            this.fBB.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.fBB != null) {
            this.fBB.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.fBA != null) {
            this.fBA.setTextAppearance(getContext(), i);
        }
        if (this.fBB != null) {
            this.fBB.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.fBA != null) {
            this.fBA.setTextColor(colorStateList);
        }
        if (this.fBB != null) {
            this.fBB.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.fBA != null) {
            this.fBA.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.fBA != null) {
            this.fBA.setTextSize(0, i);
        }
    }
}
