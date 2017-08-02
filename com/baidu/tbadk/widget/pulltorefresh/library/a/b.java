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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator aOV = new LinearInterpolator();
    private FrameLayout aOW;
    protected final ImageView aOX;
    protected final ProgressBar aOY;
    private boolean aOZ;
    protected final PullToRefreshBase.Mode aOn;
    private final TextView aPa;
    private final TextView aPb;
    protected final PullToRefreshBase.Orientation aPc;
    private CharSequence aPd;
    private CharSequence aPe;
    private CharSequence aPf;

    protected abstract void HZ();

    protected abstract void Ia();

    protected abstract void Ib();

    protected abstract void Ic();

    protected abstract void Q(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aOn = mode;
        this.aPc = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aOW = (FrameLayout) findViewById(d.h.fl_inner);
        this.aPa = (TextView) this.aOW.findViewById(d.h.pull_to_refresh_text);
        this.aOY = (ProgressBar) this.aOW.findViewById(d.h.pull_to_refresh_progress);
        this.aPb = (TextView) this.aOW.findViewById(d.h.pull_to_refresh_sub_text);
        this.aOX = (ImageView) this.aOW.findViewById(d.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aOW.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aPd = context.getString(d.l.pull_to_refresh_pull_label);
                this.aPe = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aPf = context.getString(d.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aPd = context.getString(d.l.pull_to_refresh_pull_label);
                this.aPe = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aPf = context.getString(d.l.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            e.b(this, drawable);
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
                    d.as("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableTop)) {
                    d.as("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? ai.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.aPc) {
            case HORIZONTAL:
                return this.aOW.getWidth();
            default:
                return this.aOW.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aOZ) {
            Q(f);
        }
    }

    public final void Id() {
        if (this.aPa != null) {
            this.aPa.setText(this.aPd);
        }
        HZ();
    }

    public final void lc() {
        if (this.aPa != null) {
            this.aPa.setText(this.aPe);
        }
        if (this.aOZ) {
            ((AnimationDrawable) this.aOX.getDrawable()).start();
        } else {
            Ia();
        }
        if (this.aPb != null) {
            this.aPb.setVisibility(8);
        }
    }

    public final void lb() {
        if (this.aPa != null) {
            this.aPa.setText(this.aPf);
        }
        Ib();
    }

    public final void reset() {
        if (this.aPa != null) {
            this.aPa.setText(this.aPd);
        }
        this.aOX.setVisibility(0);
        if (this.aOZ) {
            ((AnimationDrawable) this.aOX.getDrawable()).stop();
        } else {
            Ic();
        }
        if (this.aPb != null) {
            if (TextUtils.isEmpty(this.aPb.getText())) {
                this.aPb.setVisibility(8);
            } else {
                this.aPb.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aOX.setImageDrawable(drawable);
        this.aOZ = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aPd = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aPe = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aPf = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aPa.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aPb != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aPb.setVisibility(8);
                return;
            }
            this.aPb.setText(charSequence);
            if (8 == this.aPb.getVisibility()) {
                this.aPb.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aPb != null) {
            this.aPb.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aPb != null) {
            this.aPb.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aPa != null) {
            this.aPa.setTextAppearance(getContext(), i);
        }
        if (this.aPb != null) {
            this.aPb.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aPa != null) {
            this.aPa.setTextColor(colorStateList);
        }
        if (this.aPb != null) {
            this.aPb.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aPa != null) {
            this.aPa.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aPa != null) {
            this.aPa.setTextSize(0, i);
        }
    }
}
