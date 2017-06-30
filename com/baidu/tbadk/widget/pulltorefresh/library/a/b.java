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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator aNM = new LinearInterpolator();
    private static /* synthetic */ int[] aNc;
    private static /* synthetic */ int[] aNw;
    private FrameLayout aNN;
    protected final ImageView aNO;
    protected final ProgressBar aNP;
    private boolean aNQ;
    private final TextView aNR;
    private final TextView aNS;
    protected final PullToRefreshBase.Orientation aNT;
    private CharSequence aNU;
    private CharSequence aNV;
    private CharSequence aNW;
    protected final PullToRefreshBase.Mode aNe;

    protected abstract void HN();

    protected abstract void HO();

    protected abstract void HP();

    protected abstract void HQ();

    protected abstract void Q(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] HF() {
        int[] iArr = aNc;
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
            aNc = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] HK() {
        int[] iArr = aNw;
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
            aNw = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aNe = mode;
        this.aNT = orientation;
        switch (HF()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aNN = (FrameLayout) findViewById(w.h.fl_inner);
        this.aNR = (TextView) this.aNN.findViewById(w.h.pull_to_refresh_text);
        this.aNP = (ProgressBar) this.aNN.findViewById(w.h.pull_to_refresh_progress);
        this.aNS = (TextView) this.aNN.findViewById(w.h.pull_to_refresh_sub_text);
        this.aNO = (ImageView) this.aNN.findViewById(w.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aNN.getLayoutParams();
        switch (HK()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aNU = context.getString(w.l.pull_to_refresh_pull_label);
                this.aNV = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aNW = context.getString(w.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aNU = context.getString(w.l.pull_to_refresh_pull_label);
                this.aNV = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aNW = context.getString(w.l.pull_to_refresh_release_label);
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
        switch (HK()[mode.ordinal()]) {
            case 3:
                if (typedArray.hasValue(8)) {
                    drawable2 = typedArray.getDrawable(8);
                    break;
                } else if (typedArray.hasValue(18)) {
                    d.as("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(18);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(7)) {
                    drawable2 = typedArray.getDrawable(7);
                    break;
                } else if (typedArray.hasValue(17)) {
                    d.as("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(17);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? as.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (HF()[this.aNT.ordinal()]) {
            case 2:
                return this.aNN.getWidth();
            default:
                return this.aNN.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aNQ) {
            Q(f);
        }
    }

    public final void HR() {
        if (this.aNR != null) {
            this.aNR.setText(this.aNU);
        }
        HN();
    }

    public final void le() {
        if (this.aNR != null) {
            this.aNR.setText(this.aNV);
        }
        if (this.aNQ) {
            ((AnimationDrawable) this.aNO.getDrawable()).start();
        } else {
            HO();
        }
        if (this.aNS != null) {
            this.aNS.setVisibility(8);
        }
    }

    public final void ld() {
        if (this.aNR != null) {
            this.aNR.setText(this.aNW);
        }
        HP();
    }

    public final void reset() {
        if (this.aNR != null) {
            this.aNR.setText(this.aNU);
        }
        this.aNO.setVisibility(0);
        if (this.aNQ) {
            ((AnimationDrawable) this.aNO.getDrawable()).stop();
        } else {
            HQ();
        }
        if (this.aNS != null) {
            if (TextUtils.isEmpty(this.aNS.getText())) {
                this.aNS.setVisibility(8);
            } else {
                this.aNS.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aNO.setImageDrawable(drawable);
        this.aNQ = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aNU = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aNV = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aNW = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aNR.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aNS != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aNS.setVisibility(8);
                return;
            }
            this.aNS.setText(charSequence);
            if (8 == this.aNS.getVisibility()) {
                this.aNS.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aNS != null) {
            this.aNS.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aNS != null) {
            this.aNS.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aNR != null) {
            this.aNR.setTextAppearance(getContext(), i);
        }
        if (this.aNS != null) {
            this.aNS.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aNR != null) {
            this.aNR.setTextColor(colorStateList);
        }
        if (this.aNS != null) {
            this.aNS.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aNR != null) {
            this.aNR.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aNR != null) {
            this.aNR.setTextSize(0, i);
        }
    }
}
