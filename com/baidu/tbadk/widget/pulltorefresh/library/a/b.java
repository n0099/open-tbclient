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
    static final Interpolator aQl = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aPD;
    private FrameLayout aQm;
    protected final ImageView aQn;
    protected final ProgressBar aQo;
    private boolean aQp;
    private final TextView aQq;
    private final TextView aQr;
    protected final PullToRefreshBase.Orientation aQs;
    private CharSequence aQt;
    private CharSequence aQu;
    private CharSequence aQv;

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
        this.aPD = mode;
        this.aQs = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aQm = (FrameLayout) findViewById(d.h.fl_inner);
        this.aQq = (TextView) this.aQm.findViewById(d.h.pull_to_refresh_text);
        this.aQo = (ProgressBar) this.aQm.findViewById(d.h.pull_to_refresh_progress);
        this.aQr = (TextView) this.aQm.findViewById(d.h.pull_to_refresh_sub_text);
        this.aQn = (ImageView) this.aQm.findViewById(d.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aQm.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aQt = context.getString(d.l.pull_to_refresh_pull_label);
                this.aQu = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQv = context.getString(d.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aQt = context.getString(d.l.pull_to_refresh_pull_label);
                this.aQu = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQv = context.getString(d.l.pull_to_refresh_release_label);
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
        switch (this.aQs) {
            case HORIZONTAL:
                return this.aQm.getWidth();
            default:
                return this.aQm.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aQp) {
            Q(f);
        }
    }

    public final void Il() {
        if (this.aQq != null) {
            this.aQq.setText(this.aQt);
        }
        Ih();
    }

    public final void ll() {
        if (this.aQq != null) {
            this.aQq.setText(this.aQu);
        }
        if (this.aQp) {
            ((AnimationDrawable) this.aQn.getDrawable()).start();
        } else {
            Ii();
        }
        if (this.aQr != null) {
            this.aQr.setVisibility(8);
        }
    }

    public final void lk() {
        if (this.aQq != null) {
            this.aQq.setText(this.aQv);
        }
        Ij();
    }

    public final void reset() {
        if (this.aQq != null) {
            this.aQq.setText(this.aQt);
        }
        this.aQn.setVisibility(0);
        if (this.aQp) {
            ((AnimationDrawable) this.aQn.getDrawable()).stop();
        } else {
            Ik();
        }
        if (this.aQr != null) {
            if (TextUtils.isEmpty(this.aQr.getText())) {
                this.aQr.setVisibility(8);
            } else {
                this.aQr.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aQn.setImageDrawable(drawable);
        this.aQp = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aQt = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aQu = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aQv = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aQq.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aQr != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aQr.setVisibility(8);
                return;
            }
            this.aQr.setText(charSequence);
            if (8 == this.aQr.getVisibility()) {
                this.aQr.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aQr != null) {
            this.aQr.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aQr != null) {
            this.aQr.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aQq != null) {
            this.aQq.setTextAppearance(getContext(), i);
        }
        if (this.aQr != null) {
            this.aQr.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aQq != null) {
            this.aQq.setTextColor(colorStateList);
        }
        if (this.aQr != null) {
            this.aQr.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aQq != null) {
            this.aQq.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aQq != null) {
            this.aQq.setTextSize(0, i);
        }
    }
}
