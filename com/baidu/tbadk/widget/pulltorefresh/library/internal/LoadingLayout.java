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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.d;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator bel = new LinearInterpolator();
    protected final PullToRefreshBase.Mode bdI;
    private FrameLayout bem;
    protected final ImageView ben;
    protected final ProgressBar beo;
    private boolean bep;
    private final TextView beq;
    private final TextView ber;
    protected final PullToRefreshBase.Orientation bes;
    private CharSequence beu;
    private CharSequence bev;
    private CharSequence bew;

    protected abstract void Nr();

    protected abstract void Ns();

    protected abstract void Nt();

    protected abstract void Nu();

    protected abstract void ad(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.bdI = mode;
        this.bes = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bem = (FrameLayout) findViewById(d.g.fl_inner);
        this.beq = (TextView) this.bem.findViewById(d.g.pull_to_refresh_text);
        this.beo = (ProgressBar) this.bem.findViewById(d.g.pull_to_refresh_progress);
        this.ber = (TextView) this.bem.findViewById(d.g.pull_to_refresh_sub_text);
        this.ben = (ImageView) this.bem.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bem.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.beu = context.getString(d.j.pull_to_refresh_pull_label);
                this.bev = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bew = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.beu = context.getString(d.j.pull_to_refresh_pull_label);
                this.bev = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bew = context.getString(d.j.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            b.setBackground(this, drawable);
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
                    a.aw("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableTop)) {
                    a.aw("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableTop);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? am.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (this.bes) {
            case HORIZONTAL:
                return this.bem.getWidth();
            default:
                return this.bem.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bep) {
            ad(f);
        }
    }

    public final void nX() {
        if (this.beq != null) {
            this.beq.setText(this.beu);
        }
        Nr();
    }

    public final void nr() {
        if (this.beq != null) {
            this.beq.setText(this.bev);
        }
        if (this.bep) {
            ((AnimationDrawable) this.ben.getDrawable()).start();
        } else {
            Ns();
        }
        if (this.ber != null) {
            this.ber.setVisibility(8);
        }
    }

    public final void nq() {
        if (this.beq != null) {
            this.beq.setText(this.bew);
        }
        Nt();
    }

    public final void reset() {
        if (this.beq != null) {
            this.beq.setText(this.beu);
        }
        this.ben.setVisibility(0);
        if (this.bep) {
            ((AnimationDrawable) this.ben.getDrawable()).stop();
        } else {
            Nu();
        }
        if (this.ber != null) {
            if (TextUtils.isEmpty(this.ber.getText())) {
                this.ber.setVisibility(8);
            } else {
                this.ber.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.ben.setImageDrawable(drawable);
        this.bep = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.beu = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bev = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bew = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.beq.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.ber != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.ber.setVisibility(8);
                return;
            }
            this.ber.setText(charSequence);
            if (8 == this.ber.getVisibility()) {
                this.ber.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.ber != null) {
            this.ber.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.ber != null) {
            this.ber.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.beq != null) {
            this.beq.setTextAppearance(getContext(), i);
        }
        if (this.ber != null) {
            this.ber.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.beq != null) {
            this.beq.setTextColor(colorStateList);
        }
        if (this.ber != null) {
            this.ber.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.beq != null) {
            this.beq.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.beq != null) {
            this.beq.setTextSize(0, i);
        }
    }
}
