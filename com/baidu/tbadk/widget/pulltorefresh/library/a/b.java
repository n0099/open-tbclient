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
    static final Interpolator aQG = new LinearInterpolator();
    private FrameLayout aQH;
    protected final ImageView aQI;
    protected final ProgressBar aQJ;
    private boolean aQK;
    private final TextView aQL;
    private final TextView aQM;
    protected final PullToRefreshBase.Orientation aQN;
    private CharSequence aQO;
    private CharSequence aQP;
    private CharSequence aQQ;
    protected final PullToRefreshBase.Mode aQa;

    protected abstract void I(float f);

    protected abstract void Ir();

    protected abstract void Is();

    protected abstract void It();

    protected abstract void Iu();

    protected abstract void e(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aQa = mode;
        this.aQN = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(d.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aQH = (FrameLayout) findViewById(d.h.fl_inner);
        this.aQL = (TextView) this.aQH.findViewById(d.h.pull_to_refresh_text);
        this.aQJ = (ProgressBar) this.aQH.findViewById(d.h.pull_to_refresh_progress);
        this.aQM = (TextView) this.aQH.findViewById(d.h.pull_to_refresh_sub_text);
        this.aQI = (ImageView) this.aQH.findViewById(d.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aQH.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aQO = context.getString(d.l.pull_to_refresh_pull_label);
                this.aQP = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQQ = context.getString(d.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aQO = context.getString(d.l.pull_to_refresh_pull_label);
                this.aQP = context.getString(d.l.pull_to_refresh_refreshing_label);
                this.aQQ = context.getString(d.l.pull_to_refresh_release_label);
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
                    d.au("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableBottom);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableStart)) {
                    drawable2 = typedArray.getDrawable(d.n.PullToRefresh_tb_ptrDrawableStart);
                    break;
                } else if (typedArray.hasValue(d.n.PullToRefresh_tb_ptrDrawableTop)) {
                    d.au("ptrDrawableTop", "ptrDrawableStart");
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
        switch (this.aQN) {
            case HORIZONTAL:
                return this.aQH.getWidth();
            default:
                return this.aQH.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aQK) {
            I(f);
        }
    }

    public final void Iv() {
        if (this.aQL != null) {
            this.aQL.setText(this.aQO);
        }
        Ir();
    }

    public final void lf() {
        if (this.aQL != null) {
            this.aQL.setText(this.aQP);
        }
        if (this.aQK) {
            ((AnimationDrawable) this.aQI.getDrawable()).start();
        } else {
            Is();
        }
        if (this.aQM != null) {
            this.aQM.setVisibility(8);
        }
    }

    public final void le() {
        if (this.aQL != null) {
            this.aQL.setText(this.aQQ);
        }
        It();
    }

    public final void reset() {
        if (this.aQL != null) {
            this.aQL.setText(this.aQO);
        }
        this.aQI.setVisibility(0);
        if (this.aQK) {
            ((AnimationDrawable) this.aQI.getDrawable()).stop();
        } else {
            Iu();
        }
        if (this.aQM != null) {
            if (TextUtils.isEmpty(this.aQM.getText())) {
                this.aQM.setVisibility(8);
            } else {
                this.aQM.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aQI.setImageDrawable(drawable);
        this.aQK = drawable instanceof AnimationDrawable;
        e(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aQO = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aQP = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aQQ = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aQL.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aQM != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aQM.setVisibility(8);
                return;
            }
            this.aQM.setText(charSequence);
            if (8 == this.aQM.getVisibility()) {
                this.aQM.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aQM != null) {
            this.aQM.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aQM != null) {
            this.aQM.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aQL != null) {
            this.aQL.setTextAppearance(getContext(), i);
        }
        if (this.aQM != null) {
            this.aQM.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aQL != null) {
            this.aQL.setTextColor(colorStateList);
        }
        if (this.aQM != null) {
            this.aQM.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aQL != null) {
            this.aQL.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aQL != null) {
            this.aQL.setTextSize(0, i);
        }
    }
}
