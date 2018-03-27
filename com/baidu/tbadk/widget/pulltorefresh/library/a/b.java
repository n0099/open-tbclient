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
    static final Interpolator bJT = new LinearInterpolator();
    private FrameLayout bJU;
    protected final ImageView bJV;
    protected final ProgressBar bJW;
    private boolean bJX;
    private final TextView bJY;
    private final TextView bJZ;
    protected final PullToRefreshBase.Mode bJn;
    protected final PullToRefreshBase.Orientation bKa;
    private CharSequence bKb;
    private CharSequence bKc;
    private CharSequence bKd;

    protected abstract void Rc();

    protected abstract void Rd();

    protected abstract void Re();

    protected abstract void Rf();

    protected abstract void ae(float f);

    protected abstract int getDefaultDrawableResId();

    protected abstract void k(Drawable drawable);

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.bJn = mode;
        this.bKa = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bJU = (FrameLayout) findViewById(d.g.fl_inner);
        this.bJY = (TextView) this.bJU.findViewById(d.g.pull_to_refresh_text);
        this.bJW = (ProgressBar) this.bJU.findViewById(d.g.pull_to_refresh_progress);
        this.bJZ = (TextView) this.bJU.findViewById(d.g.pull_to_refresh_sub_text);
        this.bJV = (ImageView) this.bJU.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bJU.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bKb = context.getString(d.j.pull_to_refresh_pull_label);
                this.bKc = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bKd = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bKb = context.getString(d.j.pull_to_refresh_pull_label);
                this.bKc = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bKd = context.getString(d.j.pull_to_refresh_release_label);
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
        switch (this.bKa) {
            case HORIZONTAL:
                return this.bJU.getWidth();
            default:
                return this.bJU.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bJX) {
            ae(f);
        }
    }

    public final void sU() {
        if (this.bJY != null) {
            this.bJY.setText(this.bKb);
        }
        Rc();
    }

    public final void sv() {
        if (this.bJY != null) {
            this.bJY.setText(this.bKc);
        }
        if (this.bJX) {
            ((AnimationDrawable) this.bJV.getDrawable()).start();
        } else {
            Rd();
        }
        if (this.bJZ != null) {
            this.bJZ.setVisibility(8);
        }
    }

    public final void su() {
        if (this.bJY != null) {
            this.bJY.setText(this.bKd);
        }
        Re();
    }

    public final void reset() {
        if (this.bJY != null) {
            this.bJY.setText(this.bKb);
        }
        this.bJV.setVisibility(0);
        if (this.bJX) {
            ((AnimationDrawable) this.bJV.getDrawable()).stop();
        } else {
            Rf();
        }
        if (this.bJZ != null) {
            if (TextUtils.isEmpty(this.bJZ.getText())) {
                this.bJZ.setVisibility(8);
            } else {
                this.bJZ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.bJV.setImageDrawable(drawable);
        this.bJX = drawable instanceof AnimationDrawable;
        k(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bKb = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bKc = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bKd = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.bJY.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bJZ != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bJZ.setVisibility(8);
                return;
            }
            this.bJZ.setText(charSequence);
            if (8 == this.bJZ.getVisibility()) {
                this.bJZ.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bJZ != null) {
            this.bJZ.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bJZ != null) {
            this.bJZ.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.bJY != null) {
            this.bJY.setTextAppearance(getContext(), i);
        }
        if (this.bJZ != null) {
            this.bJZ.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.bJY != null) {
            this.bJY.setTextColor(colorStateList);
        }
        if (this.bJZ != null) {
            this.bJZ.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.bJY != null) {
            this.bJY.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.bJY != null) {
            this.bJY.setTextSize(0, i);
        }
    }
}
