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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.f;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator beo = new LinearInterpolator();
    protected final PullToRefreshBase.Mode bdL;
    private FrameLayout bep;
    private boolean beq;
    private final TextView ber;
    private final TextView bes;
    protected final PullToRefreshBase.Orientation beu;
    private CharSequence bev;
    private CharSequence bew;
    private CharSequence bex;
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
        this.bdL = mode;
        this.beu = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(f.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(f.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bep = (FrameLayout) findViewById(f.g.fl_inner);
        this.ber = (TextView) this.bep.findViewById(f.g.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.bep.findViewById(f.g.pull_to_refresh_progress);
        this.bes = (TextView) this.bep.findViewById(f.g.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.bep.findViewById(f.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bep.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bev = context.getString(f.j.pull_to_refresh_pull_label);
                this.bew = context.getString(f.j.pull_to_refresh_refreshing_label);
                this.bex = context.getString(f.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bev = context.getString(f.j.pull_to_refresh_pull_label);
                this.bew = context.getString(f.j.pull_to_refresh_refreshing_label);
                this.bex = context.getString(f.j.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(f.l.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(f.l.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            b.setBackground(this, drawable);
        }
        if (typedArray.hasValue(f.l.PullToRefresh_tb_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(f.l.PullToRefresh_tb_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(f.l.PullToRefresh_tb_ptrSubHeaderTextAppearance)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(f.l.PullToRefresh_tb_ptrSubHeaderTextAppearance, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(f.l.PullToRefresh_tb_ptrHeaderTextColor) && (colorStateList2 = typedArray.getColorStateList(f.l.PullToRefresh_tb_ptrHeaderTextColor)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(f.l.PullToRefresh_tb_ptrHeaderSubTextColor) && (colorStateList = typedArray.getColorStateList(f.l.PullToRefresh_tb_ptrHeaderSubTextColor)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(f.l.PullToRefresh_tb_ptrDrawable) ? typedArray.getDrawable(f.l.PullToRefresh_tb_ptrDrawable) : null;
        switch (mode) {
            case PULL_FROM_END:
                if (typedArray.hasValue(f.l.PullToRefresh_tb_ptrDrawableEnd)) {
                    drawable2 = typedArray.getDrawable(f.l.PullToRefresh_tb_ptrDrawableEnd);
                    break;
                } else if (typedArray.hasValue(f.l.PullToRefresh_tb_ptrDrawableBottom)) {
                    a.aw("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(f.l.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(f.l.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(f.l.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(f.l.PullToRefresh_tb_ptrDrawableTop)) {
                    a.aw("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(f.l.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? am.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.beu) {
            case HORIZONTAL:
                return this.bep.getWidth();
            default:
                return this.bep.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.beq) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.ber != null) {
            this.ber.setText(this.bev);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.ber != null) {
            this.ber.setText(this.bew);
        }
        if (this.beq) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.bes != null) {
            this.bes.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.ber != null) {
            this.ber.setText(this.bex);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.ber != null) {
            this.ber.setText(this.bev);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.beq) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.bes != null) {
            if (TextUtils.isEmpty(this.bes.getText())) {
                this.bes.setVisibility(8);
            } else {
                this.bes.setVisibility(0);
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
        this.beq = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bev = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bew = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bex = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.ber.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bes != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bes.setVisibility(8);
                return;
            }
            this.bes.setText(charSequence);
            if (8 == this.bes.getVisibility()) {
                this.bes.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bes != null) {
            this.bes.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bes != null) {
            this.bes.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.ber != null) {
            this.ber.setTextAppearance(getContext(), i);
        }
        if (this.bes != null) {
            this.bes.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.ber != null) {
            this.ber.setTextColor(colorStateList);
        }
        if (this.bes != null) {
            this.bes.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.ber != null) {
            this.ber.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.ber != null) {
            this.ber.setTextSize(0, i);
        }
    }
}
