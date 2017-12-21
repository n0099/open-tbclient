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
    static final Interpolator aTV = new LinearInterpolator();
    private FrameLayout aTW;
    protected final ImageView aTX;
    protected final ProgressBar aTY;
    private boolean aTZ;
    protected final PullToRefreshBase.Mode aTp;
    private final TextView aUa;
    private final TextView aUb;
    protected final PullToRefreshBase.Orientation aUc;
    private CharSequence aUd;
    private CharSequence aUe;
    private CharSequence aUf;

    protected abstract void I(float f);

    protected abstract void Jk();

    protected abstract void Jl();

    protected abstract void Jm();

    protected abstract void Jn();

    protected abstract void c(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aTp = mode;
        this.aUc = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aTW = (FrameLayout) findViewById(d.g.fl_inner);
        this.aUa = (TextView) this.aTW.findViewById(d.g.pull_to_refresh_text);
        this.aTY = (ProgressBar) this.aTW.findViewById(d.g.pull_to_refresh_progress);
        this.aUb = (TextView) this.aTW.findViewById(d.g.pull_to_refresh_sub_text);
        this.aTX = (ImageView) this.aTW.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aTW.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aUd = context.getString(d.j.pull_to_refresh_pull_label);
                this.aUe = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aUf = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aUd = context.getString(d.j.pull_to_refresh_pull_label);
                this.aUe = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aUf = context.getString(d.j.pull_to_refresh_release_label);
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
                    d.au("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableTop)) {
                    d.au("ptrDrawableTop", "ptrDrawableStart");
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
        switch (this.aUc) {
            case HORIZONTAL:
                return this.aTW.getWidth();
            default:
                return this.aTW.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aTZ) {
            I(f);
        }
    }

    public final void Jo() {
        if (this.aUa != null) {
            this.aUa.setText(this.aUd);
        }
        Jk();
    }

    public final void kZ() {
        if (this.aUa != null) {
            this.aUa.setText(this.aUe);
        }
        if (this.aTZ) {
            ((AnimationDrawable) this.aTX.getDrawable()).start();
        } else {
            Jl();
        }
        if (this.aUb != null) {
            this.aUb.setVisibility(8);
        }
    }

    public final void kY() {
        if (this.aUa != null) {
            this.aUa.setText(this.aUf);
        }
        Jm();
    }

    public final void reset() {
        if (this.aUa != null) {
            this.aUa.setText(this.aUd);
        }
        this.aTX.setVisibility(0);
        if (this.aTZ) {
            ((AnimationDrawable) this.aTX.getDrawable()).stop();
        } else {
            Jn();
        }
        if (this.aUb != null) {
            if (TextUtils.isEmpty(this.aUb.getText())) {
                this.aUb.setVisibility(8);
            } else {
                this.aUb.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aTX.setImageDrawable(drawable);
        this.aTZ = drawable instanceof AnimationDrawable;
        c(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aUd = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aUe = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aUf = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aUa.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aUb != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aUb.setVisibility(8);
                return;
            }
            this.aUb.setText(charSequence);
            if (8 == this.aUb.getVisibility()) {
                this.aUb.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aUb != null) {
            this.aUb.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aUb != null) {
            this.aUb.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aUa != null) {
            this.aUa.setTextAppearance(getContext(), i);
        }
        if (this.aUb != null) {
            this.aUb.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aUa != null) {
            this.aUa.setTextColor(colorStateList);
        }
        if (this.aUb != null) {
            this.aUb.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aUa != null) {
            this.aUa.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aUa != null) {
            this.aUa.setTextSize(0, i);
        }
    }
}
