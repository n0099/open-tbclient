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
    static final Interpolator aTS = new LinearInterpolator();
    private FrameLayout aTT;
    protected final ImageView aTU;
    protected final ProgressBar aTV;
    private boolean aTW;
    private final TextView aTX;
    private final TextView aTY;
    protected final PullToRefreshBase.Orientation aTZ;
    protected final PullToRefreshBase.Mode aTm;
    private CharSequence aUa;
    private CharSequence aUb;
    private CharSequence aUc;

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
        this.aTm = mode;
        this.aTZ = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aTT = (FrameLayout) findViewById(d.g.fl_inner);
        this.aTX = (TextView) this.aTT.findViewById(d.g.pull_to_refresh_text);
        this.aTV = (ProgressBar) this.aTT.findViewById(d.g.pull_to_refresh_progress);
        this.aTY = (TextView) this.aTT.findViewById(d.g.pull_to_refresh_sub_text);
        this.aTU = (ImageView) this.aTT.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aTT.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aUa = context.getString(d.j.pull_to_refresh_pull_label);
                this.aUb = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aUc = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aUa = context.getString(d.j.pull_to_refresh_pull_label);
                this.aUb = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aUc = context.getString(d.j.pull_to_refresh_release_label);
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
        switch (this.aTZ) {
            case HORIZONTAL:
                return this.aTT.getWidth();
            default:
                return this.aTT.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aTW) {
            I(f);
        }
    }

    public final void Jo() {
        if (this.aTX != null) {
            this.aTX.setText(this.aUa);
        }
        Jk();
    }

    public final void kZ() {
        if (this.aTX != null) {
            this.aTX.setText(this.aUb);
        }
        if (this.aTW) {
            ((AnimationDrawable) this.aTU.getDrawable()).start();
        } else {
            Jl();
        }
        if (this.aTY != null) {
            this.aTY.setVisibility(8);
        }
    }

    public final void kY() {
        if (this.aTX != null) {
            this.aTX.setText(this.aUc);
        }
        Jm();
    }

    public final void reset() {
        if (this.aTX != null) {
            this.aTX.setText(this.aUa);
        }
        this.aTU.setVisibility(0);
        if (this.aTW) {
            ((AnimationDrawable) this.aTU.getDrawable()).stop();
        } else {
            Jn();
        }
        if (this.aTY != null) {
            if (TextUtils.isEmpty(this.aTY.getText())) {
                this.aTY.setVisibility(8);
            } else {
                this.aTY.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aTU.setImageDrawable(drawable);
        this.aTW = drawable instanceof AnimationDrawable;
        c(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aUa = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aUb = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aUc = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aTX.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aTY != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aTY.setVisibility(8);
                return;
            }
            this.aTY.setText(charSequence);
            if (8 == this.aTY.getVisibility()) {
                this.aTY.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aTY != null) {
            this.aTY.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aTY != null) {
            this.aTY.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aTX != null) {
            this.aTX.setTextAppearance(getContext(), i);
        }
        if (this.aTY != null) {
            this.aTY.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aTX != null) {
            this.aTX.setTextColor(colorStateList);
        }
        if (this.aTY != null) {
            this.aTY.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aTX != null) {
            this.aTX.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aTX != null) {
            this.aTX.setTextSize(0, i);
        }
    }
}
