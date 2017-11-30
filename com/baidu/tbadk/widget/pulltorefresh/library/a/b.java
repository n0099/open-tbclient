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
    static final Interpolator aTP = new LinearInterpolator();
    private FrameLayout aTQ;
    protected final ImageView aTR;
    protected final ProgressBar aTS;
    private boolean aTT;
    private final TextView aTU;
    private final TextView aTV;
    protected final PullToRefreshBase.Orientation aTW;
    private CharSequence aTX;
    private CharSequence aTY;
    private CharSequence aTZ;
    protected final PullToRefreshBase.Mode aTj;

    protected abstract void I(float f);

    protected abstract void Jj();

    protected abstract void Jk();

    protected abstract void Jl();

    protected abstract void Jm();

    protected abstract void c(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aTj = mode;
        this.aTW = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aTQ = (FrameLayout) findViewById(d.g.fl_inner);
        this.aTU = (TextView) this.aTQ.findViewById(d.g.pull_to_refresh_text);
        this.aTS = (ProgressBar) this.aTQ.findViewById(d.g.pull_to_refresh_progress);
        this.aTV = (TextView) this.aTQ.findViewById(d.g.pull_to_refresh_sub_text);
        this.aTR = (ImageView) this.aTQ.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aTQ.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aTX = context.getString(d.j.pull_to_refresh_pull_label);
                this.aTY = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aTZ = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aTX = context.getString(d.j.pull_to_refresh_pull_label);
                this.aTY = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aTZ = context.getString(d.j.pull_to_refresh_release_label);
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
        switch (this.aTW) {
            case HORIZONTAL:
                return this.aTQ.getWidth();
            default:
                return this.aTQ.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aTT) {
            I(f);
        }
    }

    public final void Jn() {
        if (this.aTU != null) {
            this.aTU.setText(this.aTX);
        }
        Jj();
    }

    public final void kZ() {
        if (this.aTU != null) {
            this.aTU.setText(this.aTY);
        }
        if (this.aTT) {
            ((AnimationDrawable) this.aTR.getDrawable()).start();
        } else {
            Jk();
        }
        if (this.aTV != null) {
            this.aTV.setVisibility(8);
        }
    }

    public final void kY() {
        if (this.aTU != null) {
            this.aTU.setText(this.aTZ);
        }
        Jl();
    }

    public final void reset() {
        if (this.aTU != null) {
            this.aTU.setText(this.aTX);
        }
        this.aTR.setVisibility(0);
        if (this.aTT) {
            ((AnimationDrawable) this.aTR.getDrawable()).stop();
        } else {
            Jm();
        }
        if (this.aTV != null) {
            if (TextUtils.isEmpty(this.aTV.getText())) {
                this.aTV.setVisibility(8);
            } else {
                this.aTV.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aTR.setImageDrawable(drawable);
        this.aTT = drawable instanceof AnimationDrawable;
        c(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aTX = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aTY = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aTZ = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aTU.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aTV != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aTV.setVisibility(8);
                return;
            }
            this.aTV.setText(charSequence);
            if (8 == this.aTV.getVisibility()) {
                this.aTV.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aTV != null) {
            this.aTV.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aTV != null) {
            this.aTV.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aTU != null) {
            this.aTU.setTextAppearance(getContext(), i);
        }
        if (this.aTV != null) {
            this.aTV.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aTU != null) {
            this.aTU.setTextColor(colorStateList);
        }
        if (this.aTV != null) {
            this.aTV.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aTU != null) {
            this.aTU.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aTU != null) {
            this.aTU.setTextSize(0, i);
        }
    }
}
