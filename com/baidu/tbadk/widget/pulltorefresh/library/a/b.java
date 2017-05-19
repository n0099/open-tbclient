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
    private static /* synthetic */ int[] aLP;
    private static /* synthetic */ int[] aMj;
    static final Interpolator aMz = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aLR;
    private FrameLayout aMA;
    protected final ImageView aMB;
    protected final ProgressBar aMC;
    private boolean aMD;
    private final TextView aME;
    private final TextView aMF;
    protected final PullToRefreshBase.Orientation aMG;
    private CharSequence aMH;
    private CharSequence aMI;
    private CharSequence aMJ;

    protected abstract void Hv();

    protected abstract void Hw();

    protected abstract void Hx();

    protected abstract void Hy();

    protected abstract void R(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] Hn() {
        int[] iArr = aLP;
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
            aLP = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Hs() {
        int[] iArr = aMj;
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
            aMj = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aLR = mode;
        this.aMG = orientation;
        switch (Hn()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aMA = (FrameLayout) findViewById(w.h.fl_inner);
        this.aME = (TextView) this.aMA.findViewById(w.h.pull_to_refresh_text);
        this.aMC = (ProgressBar) this.aMA.findViewById(w.h.pull_to_refresh_progress);
        this.aMF = (TextView) this.aMA.findViewById(w.h.pull_to_refresh_sub_text);
        this.aMB = (ImageView) this.aMA.findViewById(w.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aMA.getLayoutParams();
        switch (Hs()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aMH = context.getString(w.l.pull_to_refresh_pull_label);
                this.aMI = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aMJ = context.getString(w.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aMH = context.getString(w.l.pull_to_refresh_pull_label);
                this.aMI = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aMJ = context.getString(w.l.pull_to_refresh_release_label);
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
        switch (Hs()[mode.ordinal()]) {
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
        switch (Hn()[this.aMG.ordinal()]) {
            case 2:
                return this.aMA.getWidth();
            default:
                return this.aMA.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aMD) {
            R(f);
        }
    }

    public final void Hz() {
        if (this.aME != null) {
            this.aME.setText(this.aMH);
        }
        Hv();
    }

    public final void lg() {
        if (this.aME != null) {
            this.aME.setText(this.aMI);
        }
        if (this.aMD) {
            ((AnimationDrawable) this.aMB.getDrawable()).start();
        } else {
            Hw();
        }
        if (this.aMF != null) {
            this.aMF.setVisibility(8);
        }
    }

    public final void lf() {
        if (this.aME != null) {
            this.aME.setText(this.aMJ);
        }
        Hx();
    }

    public final void reset() {
        if (this.aME != null) {
            this.aME.setText(this.aMH);
        }
        this.aMB.setVisibility(0);
        if (this.aMD) {
            ((AnimationDrawable) this.aMB.getDrawable()).stop();
        } else {
            Hy();
        }
        if (this.aMF != null) {
            if (TextUtils.isEmpty(this.aMF.getText())) {
                this.aMF.setVisibility(8);
            } else {
                this.aMF.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aMB.setImageDrawable(drawable);
        this.aMD = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aMH = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aMI = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aMJ = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aME.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aMF != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aMF.setVisibility(8);
                return;
            }
            this.aMF.setText(charSequence);
            if (8 == this.aMF.getVisibility()) {
                this.aMF.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aMF != null) {
            this.aMF.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aMF != null) {
            this.aMF.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aME != null) {
            this.aME.setTextAppearance(getContext(), i);
        }
        if (this.aMF != null) {
            this.aMF.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aME != null) {
            this.aME.setTextColor(colorStateList);
        }
        if (this.aMF != null) {
            this.aMF.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aME != null) {
            this.aME.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aME != null) {
            this.aME.setTextSize(0, i);
        }
    }
}
