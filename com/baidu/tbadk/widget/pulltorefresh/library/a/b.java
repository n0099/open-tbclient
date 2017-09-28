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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator aQT = new LinearInterpolator();
    private FrameLayout aQU;
    protected final ImageView aQV;
    protected final ProgressBar aQW;
    private boolean aQX;
    private final TextView aQY;
    private final TextView aQZ;
    protected final PullToRefreshBase.Mode aQn;
    protected final PullToRefreshBase.Orientation aRa;
    private CharSequence aRb;
    private CharSequence aRc;
    private CharSequence aRd;

    protected abstract void I(float f);

    protected abstract void IA();

    protected abstract void Ix();

    protected abstract void Iy();

    protected abstract void Iz();

    protected abstract void e(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aQn = mode;
        this.aRa = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aQU = (FrameLayout) findViewById(d.h.fl_inner);
        this.aQY = (TextView) this.aQU.findViewById(d.h.pull_to_refresh_text);
        this.aQW = (ProgressBar) this.aQU.findViewById(d.h.pull_to_refresh_progress);
        this.aQZ = (TextView) this.aQU.findViewById(d.h.pull_to_refresh_sub_text);
        this.aQV = (ImageView) this.aQU.findViewById(d.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aQU.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aRb = context.getString(d.l.pull_to_refresh_pull_label);
                this.aRc = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aRd = context.getString(d.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aRb = context.getString(d.l.pull_to_refresh_pull_label);
                this.aRc = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aRd = context.getString(d.l.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            e.a(this, drawable);
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
                    d.av("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableTop)) {
                    d.av("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? aj.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.aRa) {
            case HORIZONTAL:
                return this.aQU.getWidth();
            default:
                return this.aQU.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aQX) {
            I(f);
        }
    }

    public final void IB() {
        if (this.aQY != null) {
            this.aQY.setText(this.aRb);
        }
        Ix();
    }

    public final void lf() {
        if (this.aQY != null) {
            this.aQY.setText(this.aRc);
        }
        if (this.aQX) {
            ((AnimationDrawable) this.aQV.getDrawable()).start();
        } else {
            Iy();
        }
        if (this.aQZ != null) {
            this.aQZ.setVisibility(8);
        }
    }

    public final void le() {
        if (this.aQY != null) {
            this.aQY.setText(this.aRd);
        }
        Iz();
    }

    public final void reset() {
        if (this.aQY != null) {
            this.aQY.setText(this.aRb);
        }
        this.aQV.setVisibility(0);
        if (this.aQX) {
            ((AnimationDrawable) this.aQV.getDrawable()).stop();
        } else {
            IA();
        }
        if (this.aQZ != null) {
            if (TextUtils.isEmpty(this.aQZ.getText())) {
                this.aQZ.setVisibility(8);
            } else {
                this.aQZ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aQV.setImageDrawable(drawable);
        this.aQX = drawable instanceof AnimationDrawable;
        e(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aRb = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aRc = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aRd = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aQY.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aQZ != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aQZ.setVisibility(8);
                return;
            }
            this.aQZ.setText(charSequence);
            if (8 == this.aQZ.getVisibility()) {
                this.aQZ.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aQZ != null) {
            this.aQZ.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aQZ != null) {
            this.aQZ.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aQY != null) {
            this.aQY.setTextAppearance(getContext(), i);
        }
        if (this.aQZ != null) {
            this.aQZ.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aQY != null) {
            this.aQY.setTextColor(colorStateList);
        }
        if (this.aQZ != null) {
            this.aQZ.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aQY != null) {
            this.aQY.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aQY != null) {
            this.aQY.setTextSize(0, i);
        }
    }
}
