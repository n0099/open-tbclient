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
    static final Interpolator bJQ = new LinearInterpolator();
    private FrameLayout bJR;
    protected final ImageView bJS;
    protected final ProgressBar bJT;
    private boolean bJU;
    private final TextView bJV;
    private final TextView bJW;
    protected final PullToRefreshBase.Orientation bJX;
    private CharSequence bJY;
    private CharSequence bJZ;
    protected final PullToRefreshBase.Mode bJk;
    private CharSequence bKa;

    protected abstract void Rb();

    protected abstract void Rc();

    protected abstract void Rd();

    protected abstract void Re();

    protected abstract void ae(float f);

    protected abstract int getDefaultDrawableResId();

    protected abstract void k(Drawable drawable);

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.bJk = mode;
        this.bJX = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bJR = (FrameLayout) findViewById(d.g.fl_inner);
        this.bJV = (TextView) this.bJR.findViewById(d.g.pull_to_refresh_text);
        this.bJT = (ProgressBar) this.bJR.findViewById(d.g.pull_to_refresh_progress);
        this.bJW = (TextView) this.bJR.findViewById(d.g.pull_to_refresh_sub_text);
        this.bJS = (ImageView) this.bJR.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bJR.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bJY = context.getString(d.j.pull_to_refresh_pull_label);
                this.bJZ = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bKa = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bJY = context.getString(d.j.pull_to_refresh_pull_label);
                this.bJZ = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bKa = context.getString(d.j.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            e.setBackground(this, drawable);
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
        switch (this.bJX) {
            case HORIZONTAL:
                return this.bJR.getWidth();
            default:
                return this.bJR.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bJU) {
            ae(f);
        }
    }

    public final void sU() {
        if (this.bJV != null) {
            this.bJV.setText(this.bJY);
        }
        Rb();
    }

    public final void sv() {
        if (this.bJV != null) {
            this.bJV.setText(this.bJZ);
        }
        if (this.bJU) {
            ((AnimationDrawable) this.bJS.getDrawable()).start();
        } else {
            Rc();
        }
        if (this.bJW != null) {
            this.bJW.setVisibility(8);
        }
    }

    public final void su() {
        if (this.bJV != null) {
            this.bJV.setText(this.bKa);
        }
        Rd();
    }

    public final void reset() {
        if (this.bJV != null) {
            this.bJV.setText(this.bJY);
        }
        this.bJS.setVisibility(0);
        if (this.bJU) {
            ((AnimationDrawable) this.bJS.getDrawable()).stop();
        } else {
            Re();
        }
        if (this.bJW != null) {
            if (TextUtils.isEmpty(this.bJW.getText())) {
                this.bJW.setVisibility(8);
            } else {
                this.bJW.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.bJS.setImageDrawable(drawable);
        this.bJU = drawable instanceof AnimationDrawable;
        k(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bJY = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bJZ = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bKa = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.bJV.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bJW != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bJW.setVisibility(8);
                return;
            }
            this.bJW.setText(charSequence);
            if (8 == this.bJW.getVisibility()) {
                this.bJW.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bJW != null) {
            this.bJW.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bJW != null) {
            this.bJW.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.bJV != null) {
            this.bJV.setTextAppearance(getContext(), i);
        }
        if (this.bJW != null) {
            this.bJW.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.bJV != null) {
            this.bJV.setTextColor(colorStateList);
        }
        if (this.bJW != null) {
            this.bJW.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.bJV != null) {
            this.bJV.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.bJV != null) {
            this.bJV.setTextSize(0, i);
        }
    }
}
