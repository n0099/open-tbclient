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
    static final Interpolator aPT = new LinearInterpolator();
    private FrameLayout aPU;
    protected final ImageView aPV;
    protected final ProgressBar aPW;
    private boolean aPX;
    private final TextView aPY;
    private final TextView aPZ;
    protected final PullToRefreshBase.Mode aPm;
    protected final PullToRefreshBase.Orientation aQa;
    private CharSequence aQb;
    private CharSequence aQc;
    private CharSequence aQd;

    protected abstract void F(float f);

    protected abstract void Io();

    protected abstract void Ip();

    protected abstract void Iq();

    protected abstract void Ir();

    protected abstract void c(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aPm = mode;
        this.aQa = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aPU = (FrameLayout) findViewById(d.h.fl_inner);
        this.aPY = (TextView) this.aPU.findViewById(d.h.pull_to_refresh_text);
        this.aPW = (ProgressBar) this.aPU.findViewById(d.h.pull_to_refresh_progress);
        this.aPZ = (TextView) this.aPU.findViewById(d.h.pull_to_refresh_sub_text);
        this.aPV = (ImageView) this.aPU.findViewById(d.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aPU.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aQb = context.getString(d.l.pull_to_refresh_pull_label);
                this.aQc = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQd = context.getString(d.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aQb = context.getString(d.l.pull_to_refresh_pull_label);
                this.aQc = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQd = context.getString(d.l.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            e.a(this, drawable);
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
                    d.av("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableTop)) {
                    d.av("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableTop);
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
        switch (this.aQa) {
            case HORIZONTAL:
                return this.aPU.getWidth();
            default:
                return this.aPU.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aPX) {
            F(f);
        }
    }

    public final void Is() {
        if (this.aPY != null) {
            this.aPY.setText(this.aQb);
        }
        Io();
    }

    public final void ld() {
        if (this.aPY != null) {
            this.aPY.setText(this.aQc);
        }
        if (this.aPX) {
            ((AnimationDrawable) this.aPV.getDrawable()).start();
        } else {
            Ip();
        }
        if (this.aPZ != null) {
            this.aPZ.setVisibility(8);
        }
    }

    public final void lc() {
        if (this.aPY != null) {
            this.aPY.setText(this.aQd);
        }
        Iq();
    }

    public final void reset() {
        if (this.aPY != null) {
            this.aPY.setText(this.aQb);
        }
        this.aPV.setVisibility(0);
        if (this.aPX) {
            ((AnimationDrawable) this.aPV.getDrawable()).stop();
        } else {
            Ir();
        }
        if (this.aPZ != null) {
            if (TextUtils.isEmpty(this.aPZ.getText())) {
                this.aPZ.setVisibility(8);
            } else {
                this.aPZ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aPV.setImageDrawable(drawable);
        this.aPX = drawable instanceof AnimationDrawable;
        c(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aQb = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aQc = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aQd = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aPY.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aPZ != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aPZ.setVisibility(8);
                return;
            }
            this.aPZ.setText(charSequence);
            if (8 == this.aPZ.getVisibility()) {
                this.aPZ.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aPZ != null) {
            this.aPZ.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aPZ != null) {
            this.aPZ.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aPY != null) {
            this.aPY.setTextAppearance(getContext(), i);
        }
        if (this.aPZ != null) {
            this.aPZ.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aPY != null) {
            this.aPY.setTextColor(colorStateList);
        }
        if (this.aPZ != null) {
            this.aPZ.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aPY != null) {
            this.aPY.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aPY != null) {
            this.aPY.setTextSize(0, i);
        }
    }
}
