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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator bcN = new LinearInterpolator();
    private FrameLayout bcO;
    protected final ImageView bcP;
    protected final ProgressBar bcQ;
    private boolean bcR;
    private final TextView bcS;
    private final TextView bcT;
    protected final PullToRefreshBase.Orientation bcU;
    private CharSequence bcV;
    private CharSequence bcW;
    private CharSequence bcX;
    protected final PullToRefreshBase.Mode bck;

    protected abstract void Nb();

    protected abstract void Nc();

    protected abstract void Nd();

    protected abstract void Ne();

    protected abstract void ac(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.bck = mode;
        this.bcU = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.i.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.i.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bcO = (FrameLayout) findViewById(d.g.fl_inner);
        this.bcS = (TextView) this.bcO.findViewById(d.g.pull_to_refresh_text);
        this.bcQ = (ProgressBar) this.bcO.findViewById(d.g.pull_to_refresh_progress);
        this.bcT = (TextView) this.bcO.findViewById(d.g.pull_to_refresh_sub_text);
        this.bcP = (ImageView) this.bcO.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bcO.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bcV = context.getString(d.k.pull_to_refresh_pull_label);
                this.bcW = context.getString(d.k.pull_to_refresh_refreshing_label);
                this.bcX = context.getString(d.k.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bcV = context.getString(d.k.pull_to_refresh_pull_label);
                this.bcW = context.getString(d.k.pull_to_refresh_refreshing_label);
                this.bcX = context.getString(d.k.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(d.m.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            b.setBackground(this, drawable);
        }
        if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(d.m.PullToRefresh_tb_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrSubHeaderTextAppearance)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(d.m.PullToRefresh_tb_ptrSubHeaderTextAppearance, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrHeaderTextColor) && (colorStateList2 = typedArray.getColorStateList(d.m.PullToRefresh_tb_ptrHeaderTextColor)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrHeaderSubTextColor) && (colorStateList = typedArray.getColorStateList(d.m.PullToRefresh_tb_ptrHeaderSubTextColor)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(d.m.PullToRefresh_tb_ptrDrawable) ? typedArray.getDrawable(d.m.PullToRefresh_tb_ptrDrawable) : null;
        switch (mode) {
            case PULL_FROM_END:
                if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrDrawableEnd)) {
                    drawable2 = typedArray.getDrawable(d.m.PullToRefresh_tb_ptrDrawableEnd);
                    break;
                } else if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrDrawableBottom)) {
                    a.aA("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.m.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.m.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrDrawableTop)) {
                    a.aA("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(d.m.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? al.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.bcU) {
            case HORIZONTAL:
                return this.bcO.getWidth();
            default:
                return this.bcO.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bcR) {
            ac(f);
        }
    }

    public final void nV() {
        if (this.bcS != null) {
            this.bcS.setText(this.bcV);
        }
        Nb();
    }

    public final void np() {
        if (this.bcS != null) {
            this.bcS.setText(this.bcW);
        }
        if (this.bcR) {
            ((AnimationDrawable) this.bcP.getDrawable()).start();
        } else {
            Nc();
        }
        if (this.bcT != null) {
            this.bcT.setVisibility(8);
        }
    }

    public final void no() {
        if (this.bcS != null) {
            this.bcS.setText(this.bcX);
        }
        Nd();
    }

    public final void reset() {
        if (this.bcS != null) {
            this.bcS.setText(this.bcV);
        }
        this.bcP.setVisibility(0);
        if (this.bcR) {
            ((AnimationDrawable) this.bcP.getDrawable()).stop();
        } else {
            Ne();
        }
        if (this.bcT != null) {
            if (TextUtils.isEmpty(this.bcT.getText())) {
                this.bcT.setVisibility(8);
            } else {
                this.bcT.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.bcP.setImageDrawable(drawable);
        this.bcR = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bcV = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bcW = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bcX = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.bcS.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bcT != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bcT.setVisibility(8);
                return;
            }
            this.bcT.setText(charSequence);
            if (8 == this.bcT.getVisibility()) {
                this.bcT.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bcT != null) {
            this.bcT.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bcT != null) {
            this.bcT.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.bcS != null) {
            this.bcS.setTextAppearance(getContext(), i);
        }
        if (this.bcT != null) {
            this.bcT.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.bcS != null) {
            this.bcS.setTextColor(colorStateList);
        }
        if (this.bcT != null) {
            this.bcT.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.bcS != null) {
            this.bcS.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.bcS != null) {
            this.bcS.setTextSize(0, i);
        }
    }
}
