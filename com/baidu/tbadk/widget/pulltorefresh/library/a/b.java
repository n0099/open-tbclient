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
    static final Interpolator bHQ = new LinearInterpolator();
    private FrameLayout bHR;
    protected final ImageView bHS;
    protected final ProgressBar bHT;
    private boolean bHU;
    private final TextView bHV;
    private final TextView bHW;
    protected final PullToRefreshBase.Orientation bHX;
    private CharSequence bHY;
    private CharSequence bHZ;
    protected final PullToRefreshBase.Mode bHk;
    private CharSequence bIa;

    protected abstract void Qv();

    protected abstract void Qw();

    protected abstract void Qx();

    protected abstract void Qy();

    protected abstract void Y(float f);

    protected abstract int getDefaultDrawableResId();

    protected abstract void k(Drawable drawable);

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.bHk = mode;
        this.bHX = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bHR = (FrameLayout) findViewById(d.g.fl_inner);
        this.bHV = (TextView) this.bHR.findViewById(d.g.pull_to_refresh_text);
        this.bHT = (ProgressBar) this.bHR.findViewById(d.g.pull_to_refresh_progress);
        this.bHW = (TextView) this.bHR.findViewById(d.g.pull_to_refresh_sub_text);
        this.bHS = (ImageView) this.bHR.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bHR.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bHY = context.getString(d.j.pull_to_refresh_pull_label);
                this.bHZ = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bIa = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bHY = context.getString(d.j.pull_to_refresh_pull_label);
                this.bHZ = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bIa = context.getString(d.j.pull_to_refresh_release_label);
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
        switch (this.bHX) {
            case HORIZONTAL:
                return this.bHR.getWidth();
            default:
                return this.bHR.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bHU) {
            Y(f);
        }
    }

    public final void sU() {
        if (this.bHV != null) {
            this.bHV.setText(this.bHY);
        }
        Qv();
    }

    public final void sw() {
        if (this.bHV != null) {
            this.bHV.setText(this.bHZ);
        }
        if (this.bHU) {
            ((AnimationDrawable) this.bHS.getDrawable()).start();
        } else {
            Qw();
        }
        if (this.bHW != null) {
            this.bHW.setVisibility(8);
        }
    }

    public final void sv() {
        if (this.bHV != null) {
            this.bHV.setText(this.bIa);
        }
        Qx();
    }

    public final void reset() {
        if (this.bHV != null) {
            this.bHV.setText(this.bHY);
        }
        this.bHS.setVisibility(0);
        if (this.bHU) {
            ((AnimationDrawable) this.bHS.getDrawable()).stop();
        } else {
            Qy();
        }
        if (this.bHW != null) {
            if (TextUtils.isEmpty(this.bHW.getText())) {
                this.bHW.setVisibility(8);
            } else {
                this.bHW.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.bHS.setImageDrawable(drawable);
        this.bHU = drawable instanceof AnimationDrawable;
        k(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bHY = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bHZ = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bIa = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.bHV.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bHW != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bHW.setVisibility(8);
                return;
            }
            this.bHW.setText(charSequence);
            if (8 == this.bHW.getVisibility()) {
                this.bHW.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bHW != null) {
            this.bHW.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bHW != null) {
            this.bHW.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.bHV != null) {
            this.bHV.setTextAppearance(getContext(), i);
        }
        if (this.bHW != null) {
            this.bHW.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.bHV != null) {
            this.bHV.setTextColor(colorStateList);
        }
        if (this.bHW != null) {
            this.bHW.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.bHV != null) {
            this.bHV.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.bHV != null) {
            this.bHV.setTextSize(0, i);
        }
    }
}
