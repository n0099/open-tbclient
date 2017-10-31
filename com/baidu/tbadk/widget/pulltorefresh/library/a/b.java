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
    static final Interpolator aQK = new LinearInterpolator();
    private FrameLayout aQL;
    protected final ImageView aQM;
    protected final ProgressBar aQN;
    private boolean aQO;
    private final TextView aQP;
    private final TextView aQQ;
    protected final PullToRefreshBase.Orientation aQR;
    private CharSequence aQS;
    private CharSequence aQT;
    private CharSequence aQU;
    protected final PullToRefreshBase.Mode aQe;

    protected abstract void H(float f);

    protected abstract void IB();

    protected abstract void IC();

    protected abstract void ID();

    protected abstract void IE();

    protected abstract void c(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aQe = mode;
        this.aQR = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aQL = (FrameLayout) findViewById(d.g.fl_inner);
        this.aQP = (TextView) this.aQL.findViewById(d.g.pull_to_refresh_text);
        this.aQN = (ProgressBar) this.aQL.findViewById(d.g.pull_to_refresh_progress);
        this.aQQ = (TextView) this.aQL.findViewById(d.g.pull_to_refresh_sub_text);
        this.aQM = (ImageView) this.aQL.findViewById(d.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aQL.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aQS = context.getString(d.j.pull_to_refresh_pull_label);
                this.aQT = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aQU = context.getString(d.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aQS = context.getString(d.j.pull_to_refresh_pull_label);
                this.aQT = context.getString(d.j.pull_to_refresh_refreshing_label);
                this.aQU = context.getString(d.j.pull_to_refresh_release_label);
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
        switch (this.aQR) {
            case HORIZONTAL:
                return this.aQL.getWidth();
            default:
                return this.aQL.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aQO) {
            H(f);
        }
    }

    public final void IF() {
        if (this.aQP != null) {
            this.aQP.setText(this.aQS);
        }
        IB();
    }

    public final void kZ() {
        if (this.aQP != null) {
            this.aQP.setText(this.aQT);
        }
        if (this.aQO) {
            ((AnimationDrawable) this.aQM.getDrawable()).start();
        } else {
            IC();
        }
        if (this.aQQ != null) {
            this.aQQ.setVisibility(8);
        }
    }

    public final void kY() {
        if (this.aQP != null) {
            this.aQP.setText(this.aQU);
        }
        ID();
    }

    public final void reset() {
        if (this.aQP != null) {
            this.aQP.setText(this.aQS);
        }
        this.aQM.setVisibility(0);
        if (this.aQO) {
            ((AnimationDrawable) this.aQM.getDrawable()).stop();
        } else {
            IE();
        }
        if (this.aQQ != null) {
            if (TextUtils.isEmpty(this.aQQ.getText())) {
                this.aQQ.setVisibility(8);
            } else {
                this.aQQ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aQM.setImageDrawable(drawable);
        this.aQO = drawable instanceof AnimationDrawable;
        c(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aQS = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aQT = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aQU = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aQP.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aQQ != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aQQ.setVisibility(8);
                return;
            }
            this.aQQ.setText(charSequence);
            if (8 == this.aQQ.getVisibility()) {
                this.aQQ.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aQQ != null) {
            this.aQQ.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aQQ != null) {
            this.aQQ.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aQP != null) {
            this.aQP.setTextAppearance(getContext(), i);
        }
        if (this.aQQ != null) {
            this.aQQ.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aQP != null) {
            this.aQP.setTextColor(colorStateList);
        }
        if (this.aQQ != null) {
            this.aQQ.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aQP != null) {
            this.aQP.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aQP != null) {
            this.aQP.setTextSize(0, i);
        }
    }
}
