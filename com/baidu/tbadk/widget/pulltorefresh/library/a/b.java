package com.baidu.tbadk.widget.pulltorefresh.library.a;

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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator aQj = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aPB;
    private FrameLayout aQk;
    protected final ImageView aQl;
    protected final ProgressBar aQm;
    private boolean aQn;
    private final TextView aQo;
    private final TextView aQp;
    protected final PullToRefreshBase.Orientation aQq;
    private CharSequence aQr;
    private CharSequence aQs;
    private CharSequence aQt;

    protected abstract void Ih();

    protected abstract void Ii();

    protected abstract void Ij();

    protected abstract void Ik();

    protected abstract void Q(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aPB = mode;
        this.aQq = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aQk = (FrameLayout) findViewById(d.h.fl_inner);
        this.aQo = (TextView) this.aQk.findViewById(d.h.pull_to_refresh_text);
        this.aQm = (ProgressBar) this.aQk.findViewById(d.h.pull_to_refresh_progress);
        this.aQp = (TextView) this.aQk.findViewById(d.h.pull_to_refresh_sub_text);
        this.aQl = (ImageView) this.aQk.findViewById(d.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aQk.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aQr = context.getString(d.l.pull_to_refresh_pull_label);
                this.aQs = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQt = context.getString(d.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aQr = context.getString(d.l.pull_to_refresh_pull_label);
                this.aQs = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQt = context.getString(d.l.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            e.b(this, drawable);
        }
        if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(d.n.PullToRefresh_tb_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrSubHeaderTextAppearance)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(d.n.PullToRefresh_tb_ptrSubHeaderTextAppearance, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrHeaderTextColor) && (colorStateList2 = typedArray.getColorStateList(d.n.PullToRefresh_tb_ptrHeaderTextColor)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrHeaderSubTextColor) && (colorStateList = typedArray.getColorStateList(d.n.PullToRefresh_tb_ptrHeaderSubTextColor)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawable) ? typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawable) : null;
        switch (mode) {
            case PULL_FROM_END:
                if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableEnd)) {
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableEnd);
                    break;
                } else if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableBottom)) {
                    d.as("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableTop)) {
                    d.as("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? ai.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.aQq) {
            case HORIZONTAL:
                return this.aQk.getWidth();
            default:
                return this.aQk.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aQn) {
            Q(f);
        }
    }

    public final void Il() {
        if (this.aQo != null) {
            this.aQo.setText(this.aQr);
        }
        Ih();
    }

    public final void lm() {
        if (this.aQo != null) {
            this.aQo.setText(this.aQs);
        }
        if (this.aQn) {
            ((AnimationDrawable) this.aQl.getDrawable()).start();
        } else {
            Ii();
        }
        if (this.aQp != null) {
            this.aQp.setVisibility(8);
        }
    }

    public final void ll() {
        if (this.aQo != null) {
            this.aQo.setText(this.aQt);
        }
        Ij();
    }

    public final void reset() {
        if (this.aQo != null) {
            this.aQo.setText(this.aQr);
        }
        this.aQl.setVisibility(0);
        if (this.aQn) {
            ((AnimationDrawable) this.aQl.getDrawable()).stop();
        } else {
            Ik();
        }
        if (this.aQp != null) {
            if (TextUtils.isEmpty(this.aQp.getText())) {
                this.aQp.setVisibility(8);
            } else {
                this.aQp.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aQl.setImageDrawable(drawable);
        this.aQn = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aQr = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aQs = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aQt = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aQo.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aQp != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aQp.setVisibility(8);
                return;
            }
            this.aQp.setText(charSequence);
            if (8 == this.aQp.getVisibility()) {
                this.aQp.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aQp != null) {
            this.aQp.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aQp != null) {
            this.aQp.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aQo != null) {
            this.aQo.setTextAppearance(getContext(), i);
        }
        if (this.aQp != null) {
            this.aQp.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aQo != null) {
            this.aQo.setTextColor(colorStateList);
        }
        if (this.aQp != null) {
            this.aQp.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aQo != null) {
            this.aQo.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aQo != null) {
            this.aQo.setTextSize(0, i);
        }
    }
}
