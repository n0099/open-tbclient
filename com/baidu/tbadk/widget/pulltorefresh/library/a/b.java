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
    static final Interpolator aQS = new LinearInterpolator();
    private FrameLayout aQT;
    protected final ImageView aQU;
    protected final ProgressBar aQV;
    private boolean aQW;
    private final TextView aQX;
    private final TextView aQY;
    protected final PullToRefreshBase.Orientation aQZ;
    protected final PullToRefreshBase.Mode aQm;
    private CharSequence aRa;
    private CharSequence aRb;
    private CharSequence aRc;

    protected abstract void H(float f);

    protected abstract void IM();

    protected abstract void IN();

    protected abstract void IO();

    protected abstract void IP();

    protected abstract void c(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aQm = mode;
        this.aQZ = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aQT = (FrameLayout) findViewById(d.g.fl_inner);
        this.aQX = (TextView) this.aQT.findViewById(d.g.pull_to_refresh_text);
        this.aQV = (ProgressBar) this.aQT.findViewById(d.g.pull_to_refresh_progress);
        this.aQY = (TextView) this.aQT.findViewById(d.g.pull_to_refresh_sub_text);
        this.aQU = (ImageView) this.aQT.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aQT.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aRa = context.getString(d.j.pull_to_refresh_pull_label);
                this.aRb = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aRc = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aRa = context.getString(d.j.pull_to_refresh_pull_label);
                this.aRb = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aRc = context.getString(d.j.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            e.a(this, drawable);
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
                    d.at("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableTop)) {
                    d.at("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableTop);
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
        switch (this.aQZ) {
            case HORIZONTAL:
                return this.aQT.getWidth();
            default:
                return this.aQT.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aQW) {
            H(f);
        }
    }

    public final void IQ() {
        if (this.aQX != null) {
            this.aQX.setText(this.aRa);
        }
        IM();
    }

    public final void kZ() {
        if (this.aQX != null) {
            this.aQX.setText(this.aRb);
        }
        if (this.aQW) {
            ((AnimationDrawable) this.aQU.getDrawable()).start();
        } else {
            IN();
        }
        if (this.aQY != null) {
            this.aQY.setVisibility(8);
        }
    }

    public final void kY() {
        if (this.aQX != null) {
            this.aQX.setText(this.aRc);
        }
        IO();
    }

    public final void reset() {
        if (this.aQX != null) {
            this.aQX.setText(this.aRa);
        }
        this.aQU.setVisibility(0);
        if (this.aQW) {
            ((AnimationDrawable) this.aQU.getDrawable()).stop();
        } else {
            IP();
        }
        if (this.aQY != null) {
            if (TextUtils.isEmpty(this.aQY.getText())) {
                this.aQY.setVisibility(8);
            } else {
                this.aQY.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aQU.setImageDrawable(drawable);
        this.aQW = drawable instanceof AnimationDrawable;
        c(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aRa = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aRb = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aRc = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aQX.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aQY != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aQY.setVisibility(8);
                return;
            }
            this.aQY.setText(charSequence);
            if (8 == this.aQY.getVisibility()) {
                this.aQY.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aQY != null) {
            this.aQY.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aQY != null) {
            this.aQY.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aQX != null) {
            this.aQX.setTextAppearance(getContext(), i);
        }
        if (this.aQY != null) {
            this.aQY.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aQX != null) {
            this.aQX.setTextColor(colorStateList);
        }
        if (this.aQY != null) {
            this.aQY.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aQX != null) {
            this.aQX.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aQX != null) {
            this.aQX.setTextSize(0, i);
        }
    }
}
