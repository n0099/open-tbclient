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
    static final Interpolator aUJ = new LinearInterpolator();
    private FrameLayout aUK;
    protected final ImageView aUL;
    protected final ProgressBar aUM;
    private boolean aUN;
    private final TextView aUO;
    private final TextView aUP;
    protected final PullToRefreshBase.Orientation aUQ;
    private CharSequence aUR;
    private CharSequence aUS;
    private CharSequence aUT;
    protected final PullToRefreshBase.Mode aUg;

    protected abstract void JC();

    protected abstract void JD();

    protected abstract void JE();

    protected abstract void JF();

    protected abstract void S(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aUg = mode;
        this.aUQ = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.i.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.i.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aUK = (FrameLayout) findViewById(d.g.fl_inner);
        this.aUO = (TextView) this.aUK.findViewById(d.g.pull_to_refresh_text);
        this.aUM = (ProgressBar) this.aUK.findViewById(d.g.pull_to_refresh_progress);
        this.aUP = (TextView) this.aUK.findViewById(d.g.pull_to_refresh_sub_text);
        this.aUL = (ImageView) this.aUK.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aUK.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aUR = context.getString(d.k.pull_to_refresh_pull_label);
                this.aUS = context.getString(d.k.pull_to_refresh_refreshing_label);
                this.aUT = context.getString(d.k.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aUR = context.getString(d.k.pull_to_refresh_pull_label);
                this.aUS = context.getString(d.k.pull_to_refresh_refreshing_label);
                this.aUT = context.getString(d.k.pull_to_refresh_release_label);
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
        switch (this.aUQ) {
            case HORIZONTAL:
                return this.aUK.getWidth();
            default:
                return this.aUK.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aUN) {
            S(f);
        }
    }

    public final void lf() {
        if (this.aUO != null) {
            this.aUO.setText(this.aUR);
        }
        JC();
    }

    public final void kB() {
        if (this.aUO != null) {
            this.aUO.setText(this.aUS);
        }
        if (this.aUN) {
            ((AnimationDrawable) this.aUL.getDrawable()).start();
        } else {
            JD();
        }
        if (this.aUP != null) {
            this.aUP.setVisibility(8);
        }
    }

    public final void kA() {
        if (this.aUO != null) {
            this.aUO.setText(this.aUT);
        }
        JE();
    }

    public final void reset() {
        if (this.aUO != null) {
            this.aUO.setText(this.aUR);
        }
        this.aUL.setVisibility(0);
        if (this.aUN) {
            ((AnimationDrawable) this.aUL.getDrawable()).stop();
        } else {
            JF();
        }
        if (this.aUP != null) {
            if (TextUtils.isEmpty(this.aUP.getText())) {
                this.aUP.setVisibility(8);
            } else {
                this.aUP.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aUL.setImageDrawable(drawable);
        this.aUN = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aUR = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aUS = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aUT = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aUO.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aUP != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aUP.setVisibility(8);
                return;
            }
            this.aUP.setText(charSequence);
            if (8 == this.aUP.getVisibility()) {
                this.aUP.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aUP != null) {
            this.aUP.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aUP != null) {
            this.aUP.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aUO != null) {
            this.aUO.setTextAppearance(getContext(), i);
        }
        if (this.aUP != null) {
            this.aUP.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aUO != null) {
            this.aUO.setTextColor(colorStateList);
        }
        if (this.aUP != null) {
            this.aUP.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aUO != null) {
            this.aUO.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aUO != null) {
            this.aUO.setTextSize(0, i);
        }
    }
}
