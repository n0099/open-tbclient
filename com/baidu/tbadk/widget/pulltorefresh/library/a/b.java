package com.baidu.tbadk.widget.pulltorefresh.library.a;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    private static /* synthetic */ int[] aLB;
    static final Interpolator aLR = new LinearInterpolator();
    private static /* synthetic */ int[] aLh;
    private FrameLayout aLS;
    protected final ImageView aLT;
    protected final ProgressBar aLU;
    private boolean aLV;
    private final TextView aLW;
    private final TextView aLX;
    protected final PullToRefreshBase.Orientation aLY;
    private CharSequence aLZ;
    protected final PullToRefreshBase.Mode aLj;
    private CharSequence aMa;
    private CharSequence aMb;

    protected abstract void HJ();

    protected abstract void HK();

    protected abstract void HL();

    protected abstract void HM();

    protected abstract void R(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] HD() {
        int[] iArr = aLh;
        if (iArr == null) {
            iArr = new int[PullToRefreshBase.Orientation.valuesCustom().length];
            try {
                iArr[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            aLh = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] HG() {
        int[] iArr = aLB;
        if (iArr == null) {
            iArr = new int[PullToRefreshBase.Mode.valuesCustom().length];
            try {
                iArr[PullToRefreshBase.Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PullToRefreshBase.Mode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            aLB = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aLj = mode;
        this.aLY = orientation;
        switch (HD()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aLS = (FrameLayout) findViewById(w.h.fl_inner);
        this.aLW = (TextView) this.aLS.findViewById(w.h.pull_to_refresh_text);
        this.aLU = (ProgressBar) this.aLS.findViewById(w.h.pull_to_refresh_progress);
        this.aLX = (TextView) this.aLS.findViewById(w.h.pull_to_refresh_sub_text);
        this.aLT = (ImageView) this.aLS.findViewById(w.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aLS.getLayoutParams();
        switch (HG()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aLZ = context.getString(w.l.pull_to_refresh_pull_label);
                this.aMa = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aMb = context.getString(w.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aLZ = context.getString(w.l.pull_to_refresh_pull_label);
                this.aMa = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aMb = context.getString(w.l.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(1) && (drawable = typedArray.getDrawable(1)) != null) {
            e.b(this, drawable);
        }
        if (typedArray.hasValue(10)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(10, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(11)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(11, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(2) && (colorStateList2 = typedArray.getColorStateList(2)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(3) && (colorStateList = typedArray.getColorStateList(3)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(6) ? typedArray.getDrawable(6) : null;
        switch (HG()[mode.ordinal()]) {
            case 3:
                if (typedArray.hasValue(8)) {
                    drawable2 = typedArray.getDrawable(8);
                    break;
                } else if (typedArray.hasValue(18)) {
                    d.ar("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(18);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(7)) {
                    drawable2 = typedArray.getDrawable(7);
                    break;
                } else if (typedArray.hasValue(17)) {
                    d.ar("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(17);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? aq.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (HD()[this.aLY.ordinal()]) {
            case 2:
                return this.aLS.getWidth();
            default:
                return this.aLS.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aLV) {
            R(f);
        }
    }

    public final void lq() {
        if (this.aLW != null) {
            this.aLW.setText(this.aLZ);
        }
        HJ();
    }

    public final void lc() {
        if (this.aLW != null) {
            this.aLW.setText(this.aMa);
        }
        if (this.aLV) {
            ((AnimationDrawable) this.aLT.getDrawable()).start();
        } else {
            HK();
        }
        if (this.aLX != null) {
            this.aLX.setVisibility(8);
        }
    }

    public final void lb() {
        if (this.aLW != null) {
            this.aLW.setText(this.aMb);
        }
        HL();
    }

    public final void reset() {
        if (this.aLW != null) {
            this.aLW.setText(this.aLZ);
        }
        this.aLT.setVisibility(0);
        if (this.aLV) {
            ((AnimationDrawable) this.aLT.getDrawable()).stop();
        } else {
            HM();
        }
        if (this.aLX != null) {
            if (TextUtils.isEmpty(this.aLX.getText())) {
                this.aLX.setVisibility(8);
            } else {
                this.aLX.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aLT.setImageDrawable(drawable);
        this.aLV = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aLZ = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aMa = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aMb = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aLW.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aLX != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aLX.setVisibility(8);
                return;
            }
            this.aLX.setText(charSequence);
            if (8 == this.aLX.getVisibility()) {
                this.aLX.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aLX != null) {
            this.aLX.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aLX != null) {
            this.aLX.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aLW != null) {
            this.aLW.setTextAppearance(getContext(), i);
        }
        if (this.aLX != null) {
            this.aLX.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aLW != null) {
            this.aLW.setTextColor(colorStateList);
        }
        if (this.aLX != null) {
            this.aLX.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aLW != null) {
            this.aLW.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aLW != null) {
            this.aLW.setTextSize(0, i);
        }
    }
}
