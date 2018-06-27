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
    static final Interpolator beb = new LinearInterpolator();
    protected final PullToRefreshBase.Mode bdy;
    private FrameLayout bec;
    protected final ImageView bed;
    protected final ProgressBar bee;
    private boolean bef;
    private final TextView beh;
    private final TextView bei;
    protected final PullToRefreshBase.Orientation bej;
    private CharSequence bek;
    private CharSequence bel;
    private CharSequence bem;

    protected abstract void Nu();

    protected abstract void Nv();

    protected abstract void Nw();

    protected abstract void Nx();

    protected abstract void ac(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.bdy = mode;
        this.bej = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.i.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.i.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bec = (FrameLayout) findViewById(d.g.fl_inner);
        this.beh = (TextView) this.bec.findViewById(d.g.pull_to_refresh_text);
        this.bee = (ProgressBar) this.bec.findViewById(d.g.pull_to_refresh_progress);
        this.bei = (TextView) this.bec.findViewById(d.g.pull_to_refresh_sub_text);
        this.bed = (ImageView) this.bec.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bec.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bek = context.getString(d.k.pull_to_refresh_pull_label);
                this.bel = context.getString(d.k.pull_to_refresh_refreshing_label);
                this.bem = context.getString(d.k.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bek = context.getString(d.k.pull_to_refresh_pull_label);
                this.bel = context.getString(d.k.pull_to_refresh_refreshing_label);
                this.bem = context.getString(d.k.pull_to_refresh_release_label);
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
        switch (this.bej) {
            case HORIZONTAL:
                return this.bec.getWidth();
            default:
                return this.bec.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bef) {
            ac(f);
        }
    }

    public final void nV() {
        if (this.beh != null) {
            this.beh.setText(this.bek);
        }
        Nu();
    }

    public final void np() {
        if (this.beh != null) {
            this.beh.setText(this.bel);
        }
        if (this.bef) {
            ((AnimationDrawable) this.bed.getDrawable()).start();
        } else {
            Nv();
        }
        if (this.bei != null) {
            this.bei.setVisibility(8);
        }
    }

    public final void no() {
        if (this.beh != null) {
            this.beh.setText(this.bem);
        }
        Nw();
    }

    public final void reset() {
        if (this.beh != null) {
            this.beh.setText(this.bek);
        }
        this.bed.setVisibility(0);
        if (this.bef) {
            ((AnimationDrawable) this.bed.getDrawable()).stop();
        } else {
            Nx();
        }
        if (this.bei != null) {
            if (TextUtils.isEmpty(this.bei.getText())) {
                this.bei.setVisibility(8);
            } else {
                this.bei.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.bed.setImageDrawable(drawable);
        this.bef = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bek = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bel = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bem = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.beh.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bei != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bei.setVisibility(8);
                return;
            }
            this.bei.setText(charSequence);
            if (8 == this.bei.getVisibility()) {
                this.bei.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bei != null) {
            this.bei.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bei != null) {
            this.bei.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.beh != null) {
            this.beh.setTextAppearance(getContext(), i);
        }
        if (this.bei != null) {
            this.bei.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.beh != null) {
            this.beh.setTextColor(colorStateList);
        }
        if (this.bei != null) {
            this.bei.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.beh != null) {
            this.beh.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.beh != null) {
            this.beh.setTextSize(0, i);
        }
    }
}
