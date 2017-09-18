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
    static final Interpolator aPQ = new LinearInterpolator();
    private FrameLayout aPR;
    protected final ImageView aPS;
    protected final ProgressBar aPT;
    private boolean aPU;
    private final TextView aPV;
    private final TextView aPW;
    protected final PullToRefreshBase.Orientation aPX;
    private CharSequence aPY;
    private CharSequence aPZ;
    protected final PullToRefreshBase.Mode aPj;
    private CharSequence aQa;

    protected abstract void F(float f);

    protected abstract void Io();

    protected abstract void Ip();

    protected abstract void Iq();

    protected abstract void Ir();

    protected abstract void c(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aPj = mode;
        this.aPX = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aPR = (FrameLayout) findViewById(d.h.fl_inner);
        this.aPV = (TextView) this.aPR.findViewById(d.h.pull_to_refresh_text);
        this.aPT = (ProgressBar) this.aPR.findViewById(d.h.pull_to_refresh_progress);
        this.aPW = (TextView) this.aPR.findViewById(d.h.pull_to_refresh_sub_text);
        this.aPS = (ImageView) this.aPR.findViewById(d.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aPR.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aPY = context.getString(d.l.pull_to_refresh_pull_label);
                this.aPZ = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQa = context.getString(d.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aPY = context.getString(d.l.pull_to_refresh_pull_label);
                this.aPZ = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQa = context.getString(d.l.pull_to_refresh_release_label);
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
        switch (this.aPX) {
            case HORIZONTAL:
                return this.aPR.getWidth();
            default:
                return this.aPR.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aPU) {
            F(f);
        }
    }

    public final void Is() {
        if (this.aPV != null) {
            this.aPV.setText(this.aPY);
        }
        Io();
    }

    public final void ld() {
        if (this.aPV != null) {
            this.aPV.setText(this.aPZ);
        }
        if (this.aPU) {
            ((AnimationDrawable) this.aPS.getDrawable()).start();
        } else {
            Ip();
        }
        if (this.aPW != null) {
            this.aPW.setVisibility(8);
        }
    }

    public final void lc() {
        if (this.aPV != null) {
            this.aPV.setText(this.aQa);
        }
        Iq();
    }

    public final void reset() {
        if (this.aPV != null) {
            this.aPV.setText(this.aPY);
        }
        this.aPS.setVisibility(0);
        if (this.aPU) {
            ((AnimationDrawable) this.aPS.getDrawable()).stop();
        } else {
            Ir();
        }
        if (this.aPW != null) {
            if (TextUtils.isEmpty(this.aPW.getText())) {
                this.aPW.setVisibility(8);
            } else {
                this.aPW.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aPS.setImageDrawable(drawable);
        this.aPU = drawable instanceof AnimationDrawable;
        c(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aPY = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aPZ = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aQa = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aPV.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aPW != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aPW.setVisibility(8);
                return;
            }
            this.aPW.setText(charSequence);
            if (8 == this.aPW.getVisibility()) {
                this.aPW.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aPW != null) {
            this.aPW.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aPW != null) {
            this.aPW.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aPV != null) {
            this.aPV.setTextAppearance(getContext(), i);
        }
        if (this.aPW != null) {
            this.aPW.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aPV != null) {
            this.aPV.setTextColor(colorStateList);
        }
        if (this.aPW != null) {
            this.aPW.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aPV != null) {
            this.aPV.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aPV != null) {
            this.aPV.setTextSize(0, i);
        }
    }
}
