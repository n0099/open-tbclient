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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator aUI = new LinearInterpolator();
    private FrameLayout aUJ;
    protected final ImageView aUK;
    protected final ProgressBar aUL;
    private boolean aUM;
    private final TextView aUN;
    private final TextView aUO;
    protected final PullToRefreshBase.Orientation aUP;
    private CharSequence aUQ;
    private CharSequence aUR;
    private CharSequence aUS;
    protected final PullToRefreshBase.Mode aUf;

    protected abstract void JE();

    protected abstract void JF();

    protected abstract void JG();

    protected abstract void JH();

    protected abstract void S(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aUf = mode;
        this.aUP = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.i.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.i.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aUJ = (FrameLayout) findViewById(d.g.fl_inner);
        this.aUN = (TextView) this.aUJ.findViewById(d.g.pull_to_refresh_text);
        this.aUL = (ProgressBar) this.aUJ.findViewById(d.g.pull_to_refresh_progress);
        this.aUO = (TextView) this.aUJ.findViewById(d.g.pull_to_refresh_sub_text);
        this.aUK = (ImageView) this.aUJ.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aUJ.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aUQ = context.getString(d.k.pull_to_refresh_pull_label);
                this.aUR = context.getString(d.k.pull_to_refresh_refreshing_label);
                this.aUS = context.getString(d.k.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aUQ = context.getString(d.k.pull_to_refresh_pull_label);
                this.aUR = context.getString(d.k.pull_to_refresh_refreshing_label);
                this.aUS = context.getString(d.k.pull_to_refresh_release_label);
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
                    a.at("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.m.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.m.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.m.PullToRefresh_tb_ptrDrawableTop)) {
                    a.at("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(d.m.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? ak.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.aUP) {
            case HORIZONTAL:
                return this.aUJ.getWidth();
            default:
                return this.aUJ.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aUM) {
            S(f);
        }
    }

    public final void lg() {
        if (this.aUN != null) {
            this.aUN.setText(this.aUQ);
        }
        JE();
    }

    public final void kC() {
        if (this.aUN != null) {
            this.aUN.setText(this.aUR);
        }
        if (this.aUM) {
            ((AnimationDrawable) this.aUK.getDrawable()).start();
        } else {
            JF();
        }
        if (this.aUO != null) {
            this.aUO.setVisibility(8);
        }
    }

    public final void kB() {
        if (this.aUN != null) {
            this.aUN.setText(this.aUS);
        }
        JG();
    }

    public final void reset() {
        if (this.aUN != null) {
            this.aUN.setText(this.aUQ);
        }
        this.aUK.setVisibility(0);
        if (this.aUM) {
            ((AnimationDrawable) this.aUK.getDrawable()).stop();
        } else {
            JH();
        }
        if (this.aUO != null) {
            if (TextUtils.isEmpty(this.aUO.getText())) {
                this.aUO.setVisibility(8);
            } else {
                this.aUO.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aUK.setImageDrawable(drawable);
        this.aUM = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aUQ = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aUR = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aUS = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aUN.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aUO != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aUO.setVisibility(8);
                return;
            }
            this.aUO.setText(charSequence);
            if (8 == this.aUO.getVisibility()) {
                this.aUO.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aUO != null) {
            this.aUO.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aUO != null) {
            this.aUO.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aUN != null) {
            this.aUN.setTextAppearance(getContext(), i);
        }
        if (this.aUO != null) {
            this.aUO.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aUN != null) {
            this.aUN.setTextColor(colorStateList);
        }
        if (this.aUO != null) {
            this.aUO.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aUN != null) {
            this.aUN.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aUN != null) {
            this.aUN.setTextSize(0, i);
        }
    }
}
