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
    static final Interpolator bKd = new LinearInterpolator();
    protected final PullToRefreshBase.Mode bJx;
    private FrameLayout bKe;
    protected final ImageView bKf;
    protected final ProgressBar bKg;
    private boolean bKh;
    private final TextView bKi;
    private final TextView bKj;
    protected final PullToRefreshBase.Orientation bKk;
    private CharSequence bKl;
    private CharSequence bKm;
    private CharSequence bKn;

    protected abstract void Rc();

    protected abstract void Rd();

    protected abstract void Re();

    protected abstract void Rf();

    protected abstract void ae(float f);

    protected abstract int getDefaultDrawableResId();

    protected abstract void k(Drawable drawable);

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.bJx = mode;
        this.bKk = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bKe = (FrameLayout) findViewById(d.g.fl_inner);
        this.bKi = (TextView) this.bKe.findViewById(d.g.pull_to_refresh_text);
        this.bKg = (ProgressBar) this.bKe.findViewById(d.g.pull_to_refresh_progress);
        this.bKj = (TextView) this.bKe.findViewById(d.g.pull_to_refresh_sub_text);
        this.bKf = (ImageView) this.bKe.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bKe.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bKl = context.getString(d.j.pull_to_refresh_pull_label);
                this.bKm = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bKn = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bKl = context.getString(d.j.pull_to_refresh_pull_label);
                this.bKm = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bKn = context.getString(d.j.pull_to_refresh_release_label);
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
        switch (this.bKk) {
            case HORIZONTAL:
                return this.bKe.getWidth();
            default:
                return this.bKe.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bKh) {
            ae(f);
        }
    }

    public final void sU() {
        if (this.bKi != null) {
            this.bKi.setText(this.bKl);
        }
        Rc();
    }

    public final void sv() {
        if (this.bKi != null) {
            this.bKi.setText(this.bKm);
        }
        if (this.bKh) {
            ((AnimationDrawable) this.bKf.getDrawable()).start();
        } else {
            Rd();
        }
        if (this.bKj != null) {
            this.bKj.setVisibility(8);
        }
    }

    public final void su() {
        if (this.bKi != null) {
            this.bKi.setText(this.bKn);
        }
        Re();
    }

    public final void reset() {
        if (this.bKi != null) {
            this.bKi.setText(this.bKl);
        }
        this.bKf.setVisibility(0);
        if (this.bKh) {
            ((AnimationDrawable) this.bKf.getDrawable()).stop();
        } else {
            Rf();
        }
        if (this.bKj != null) {
            if (TextUtils.isEmpty(this.bKj.getText())) {
                this.bKj.setVisibility(8);
            } else {
                this.bKj.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.bKf.setImageDrawable(drawable);
        this.bKh = drawable instanceof AnimationDrawable;
        k(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bKl = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bKm = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bKn = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.bKi.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bKj != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bKj.setVisibility(8);
                return;
            }
            this.bKj.setText(charSequence);
            if (8 == this.bKj.getVisibility()) {
                this.bKj.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bKj != null) {
            this.bKj.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bKj != null) {
            this.bKj.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.bKi != null) {
            this.bKi.setTextAppearance(getContext(), i);
        }
        if (this.bKj != null) {
            this.bKj.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.bKi != null) {
            this.bKi.setTextColor(colorStateList);
        }
        if (this.bKj != null) {
            this.bKj.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.bKi != null) {
            this.bKi.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.bKi != null) {
            this.bKi.setTextSize(0, i);
        }
    }
}
