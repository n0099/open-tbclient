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
    static final Interpolator bHY = new LinearInterpolator();
    private FrameLayout bHZ;
    protected final PullToRefreshBase.Mode bHs;
    protected final ImageView bIa;
    protected final ProgressBar bIb;
    private boolean bIc;
    private final TextView bId;
    private final TextView bIe;
    protected final PullToRefreshBase.Orientation bIf;
    private CharSequence bIg;
    private CharSequence bIh;
    private CharSequence bIi;

    protected abstract void QA();

    protected abstract void Qx();

    protected abstract void Qy();

    protected abstract void Qz();

    protected abstract void Y(float f);

    protected abstract int getDefaultDrawableResId();

    protected abstract void k(Drawable drawable);

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.bHs = mode;
        this.bIf = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.bHZ = (FrameLayout) findViewById(d.g.fl_inner);
        this.bId = (TextView) this.bHZ.findViewById(d.g.pull_to_refresh_text);
        this.bIb = (ProgressBar) this.bHZ.findViewById(d.g.pull_to_refresh_progress);
        this.bIe = (TextView) this.bHZ.findViewById(d.g.pull_to_refresh_sub_text);
        this.bIa = (ImageView) this.bHZ.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bHZ.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.bIg = context.getString(d.j.pull_to_refresh_pull_label);
                this.bIh = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bIi = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.bIg = context.getString(d.j.pull_to_refresh_pull_label);
                this.bIh = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.bIi = context.getString(d.j.pull_to_refresh_release_label);
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
                    d.as("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.l.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.l.PullToRefresh_tb_ptrDrawableTop)) {
                    d.as("ptrDrawableTop", "ptrDrawableStart");
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
        switch (this.bIf) {
            case HORIZONTAL:
                return this.bHZ.getWidth();
            default:
                return this.bHZ.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.bIc) {
            Y(f);
        }
    }

    public final void sV() {
        if (this.bId != null) {
            this.bId.setText(this.bIg);
        }
        Qx();
    }

    public final void sx() {
        if (this.bId != null) {
            this.bId.setText(this.bIh);
        }
        if (this.bIc) {
            ((AnimationDrawable) this.bIa.getDrawable()).start();
        } else {
            Qy();
        }
        if (this.bIe != null) {
            this.bIe.setVisibility(8);
        }
    }

    public final void sw() {
        if (this.bId != null) {
            this.bId.setText(this.bIi);
        }
        Qz();
    }

    public final void reset() {
        if (this.bId != null) {
            this.bId.setText(this.bIg);
        }
        this.bIa.setVisibility(0);
        if (this.bIc) {
            ((AnimationDrawable) this.bIa.getDrawable()).stop();
        } else {
            QA();
        }
        if (this.bIe != null) {
            if (TextUtils.isEmpty(this.bIe.getText())) {
                this.bIe.setVisibility(8);
            } else {
                this.bIe.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.bIa.setImageDrawable(drawable);
        this.bIc = drawable instanceof AnimationDrawable;
        k(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.bIg = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.bIh = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.bIi = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.bId.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.bIe != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bIe.setVisibility(8);
                return;
            }
            this.bIe.setText(charSequence);
            if (8 == this.bIe.getVisibility()) {
                this.bIe.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.bIe != null) {
            this.bIe.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.bIe != null) {
            this.bIe.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.bId != null) {
            this.bId.setTextAppearance(getContext(), i);
        }
        if (this.bIe != null) {
            this.bIe.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.bId != null) {
            this.bId.setTextColor(colorStateList);
        }
        if (this.bIe != null) {
            this.bIe.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.bId != null) {
            this.bId.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.bId != null) {
            this.bId.setTextSize(0, i);
        }
    }
}
