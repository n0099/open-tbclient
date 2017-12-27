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
    static final Interpolator bHI = new LinearInterpolator();
    private FrameLayout bHJ;
    protected final ImageView bHK;
    protected final ProgressBar bHL;
    private boolean bHM;
    private final TextView bHN;
    private final TextView bHO;
    protected final PullToRefreshBase.Orientation bHP;
    private CharSequence bHQ;
    private CharSequence bHR;
    private CharSequence bHS;
    protected final PullToRefreshBase.Mode bHc;

    protected abstract void QH();

    protected abstract void QI();

    protected abstract void QJ();

    protected abstract void QK();

    protected abstract void Y(float f);

    protected abstract int getDefaultDrawableResId();

    protected abstract void k(Drawable drawable);

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.bHc = mode;
        this.bHP = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bHJ = (FrameLayout) findViewById(d.g.fl_inner);
        this.bHN = (TextView) this.bHJ.findViewById(d.g.pull_to_refresh_text);
        this.bHL = (ProgressBar) this.bHJ.findViewById(d.g.pull_to_refresh_progress);
        this.bHO = (TextView) this.bHJ.findViewById(d.g.pull_to_refresh_sub_text);
        this.bHK = (ImageView) this.bHJ.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bHJ.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bHQ = context.getString(d.j.pull_to_refresh_pull_label);
                this.bHR = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bHS = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bHQ = context.getString(d.j.pull_to_refresh_pull_label);
                this.bHR = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bHS = context.getString(d.j.pull_to_refresh_release_label);
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
        switch (this.bHP) {
            case HORIZONTAL:
                return this.bHJ.getWidth();
            default:
                return this.bHJ.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bHM) {
            Y(f);
        }
    }

    public final void sU() {
        if (this.bHN != null) {
            this.bHN.setText(this.bHQ);
        }
        QH();
    }

    public final void sw() {
        if (this.bHN != null) {
            this.bHN.setText(this.bHR);
        }
        if (this.bHM) {
            ((AnimationDrawable) this.bHK.getDrawable()).start();
        } else {
            QI();
        }
        if (this.bHO != null) {
            this.bHO.setVisibility(8);
        }
    }

    public final void sv() {
        if (this.bHN != null) {
            this.bHN.setText(this.bHS);
        }
        QJ();
    }

    public final void reset() {
        if (this.bHN != null) {
            this.bHN.setText(this.bHQ);
        }
        this.bHK.setVisibility(0);
        if (this.bHM) {
            ((AnimationDrawable) this.bHK.getDrawable()).stop();
        } else {
            QK();
        }
        if (this.bHO != null) {
            if (TextUtils.isEmpty(this.bHO.getText())) {
                this.bHO.setVisibility(8);
            } else {
                this.bHO.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.bHK.setImageDrawable(drawable);
        this.bHM = drawable instanceof AnimationDrawable;
        k(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bHQ = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bHR = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bHS = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.bHN.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bHO != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bHO.setVisibility(8);
                return;
            }
            this.bHO.setText(charSequence);
            if (8 == this.bHO.getVisibility()) {
                this.bHO.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bHO != null) {
            this.bHO.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bHO != null) {
            this.bHO.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.bHN != null) {
            this.bHN.setTextAppearance(getContext(), i);
        }
        if (this.bHO != null) {
            this.bHO.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.bHN != null) {
            this.bHN.setTextColor(colorStateList);
        }
        if (this.bHO != null) {
            this.bHO.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.bHN != null) {
            this.bHN.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.bHN != null) {
            this.bHN.setTextSize(0, i);
        }
    }
}
