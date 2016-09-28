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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    private static /* synthetic */ int[] aGL;
    private static /* synthetic */ int[] aHf;
    static final Interpolator aHv = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aGN;
    private final TextView aHA;
    private final TextView aHB;
    protected final PullToRefreshBase.Orientation aHC;
    private CharSequence aHD;
    private CharSequence aHE;
    private CharSequence aHF;
    private FrameLayout aHw;
    protected final ImageView aHx;
    protected final ProgressBar aHy;
    private boolean aHz;

    protected abstract void HT();

    protected abstract void HU();

    protected abstract void HV();

    protected abstract void HW();

    protected abstract void P(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] HN() {
        int[] iArr = aGL;
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
            aGL = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] HQ() {
        int[] iArr = aHf;
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
            aHf = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aGN = mode;
        this.aHC = orientation;
        switch (HN()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(r.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(r.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aHw = (FrameLayout) findViewById(r.g.fl_inner);
        this.aHA = (TextView) this.aHw.findViewById(r.g.pull_to_refresh_text);
        this.aHy = (ProgressBar) this.aHw.findViewById(r.g.pull_to_refresh_progress);
        this.aHB = (TextView) this.aHw.findViewById(r.g.pull_to_refresh_sub_text);
        this.aHx = (ImageView) this.aHw.findViewById(r.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHw.getLayoutParams();
        switch (HQ()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aHD = context.getString(r.j.pull_to_refresh_pull_label);
                this.aHE = context.getString(r.j.pull_to_refresh_refreshing_label);
                this.aHF = context.getString(r.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aHD = context.getString(r.j.pull_to_refresh_pull_label);
                this.aHE = context.getString(r.j.pull_to_refresh_refreshing_label);
                this.aHF = context.getString(r.j.pull_to_refresh_release_label);
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
        switch (HQ()[mode.ordinal()]) {
            case 3:
                if (typedArray.hasValue(8)) {
                    drawable2 = typedArray.getDrawable(8);
                    break;
                } else if (typedArray.hasValue(18)) {
                    d.at("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(18);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(7)) {
                    drawable2 = typedArray.getDrawable(7);
                    break;
                } else if (typedArray.hasValue(17)) {
                    d.at("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(17);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? av.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (HN()[this.aHC.ordinal()]) {
            case 2:
                return this.aHw.getWidth();
            default:
                return this.aHw.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aHz) {
            P(f);
        }
    }

    public final void kE() {
        if (this.aHA != null) {
            this.aHA.setText(this.aHD);
        }
        HT();
    }

    public final void km() {
        if (this.aHA != null) {
            this.aHA.setText(this.aHE);
        }
        if (this.aHz) {
            ((AnimationDrawable) this.aHx.getDrawable()).start();
        } else {
            HU();
        }
        if (this.aHB != null) {
            this.aHB.setVisibility(8);
        }
    }

    public final void kl() {
        if (this.aHA != null) {
            this.aHA.setText(this.aHF);
        }
        HV();
    }

    public final void reset() {
        if (this.aHA != null) {
            this.aHA.setText(this.aHD);
        }
        this.aHx.setVisibility(0);
        if (this.aHz) {
            ((AnimationDrawable) this.aHx.getDrawable()).stop();
        } else {
            HW();
        }
        if (this.aHB != null) {
            if (TextUtils.isEmpty(this.aHB.getText())) {
                this.aHB.setVisibility(8);
            } else {
                this.aHB.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aHx.setImageDrawable(drawable);
        this.aHz = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aHD = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aHE = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aHF = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aHA.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aHB != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aHB.setVisibility(8);
                return;
            }
            this.aHB.setText(charSequence);
            if (8 == this.aHB.getVisibility()) {
                this.aHB.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aHB != null) {
            this.aHB.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aHB != null) {
            this.aHB.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aHA != null) {
            this.aHA.setTextAppearance(getContext(), i);
        }
        if (this.aHB != null) {
            this.aHB.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aHA != null) {
            this.aHA.setTextColor(colorStateList);
        }
        if (this.aHB != null) {
            this.aHB.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aHA != null) {
            this.aHA.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aHA != null) {
            this.aHA.setTextSize(0, i);
        }
    }
}
