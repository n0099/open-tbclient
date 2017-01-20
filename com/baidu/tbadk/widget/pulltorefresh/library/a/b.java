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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    private static /* synthetic */ int[] aFK;
    private static /* synthetic */ int[] aGe;
    static final Interpolator aGu = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aFM;
    private final TextView aGA;
    protected final PullToRefreshBase.Orientation aGB;
    private CharSequence aGC;
    private CharSequence aGD;
    private CharSequence aGE;
    private FrameLayout aGv;
    protected final ImageView aGw;
    protected final ProgressBar aGx;
    private boolean aGy;
    private final TextView aGz;

    protected abstract void Hk();

    protected abstract void Hl();

    protected abstract void Hm();

    protected abstract void Hn();

    protected abstract void R(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] He() {
        int[] iArr = aFK;
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
            aFK = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Hh() {
        int[] iArr = aGe;
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
            aGe = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aFM = mode;
        this.aGB = orientation;
        switch (He()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(r.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(r.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aGv = (FrameLayout) findViewById(r.h.fl_inner);
        this.aGz = (TextView) this.aGv.findViewById(r.h.pull_to_refresh_text);
        this.aGx = (ProgressBar) this.aGv.findViewById(r.h.pull_to_refresh_progress);
        this.aGA = (TextView) this.aGv.findViewById(r.h.pull_to_refresh_sub_text);
        this.aGw = (ImageView) this.aGv.findViewById(r.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGv.getLayoutParams();
        switch (Hh()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aGC = context.getString(r.l.pull_to_refresh_pull_label);
                this.aGD = context.getString(r.l.pull_to_refresh_refreshing_label);
                this.aGE = context.getString(r.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aGC = context.getString(r.l.pull_to_refresh_pull_label);
                this.aGD = context.getString(r.l.pull_to_refresh_refreshing_label);
                this.aGE = context.getString(r.l.pull_to_refresh_release_label);
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
        switch (Hh()[mode.ordinal()]) {
            case 3:
                if (typedArray.hasValue(8)) {
                    drawable2 = typedArray.getDrawable(8);
                    break;
                } else if (typedArray.hasValue(18)) {
                    d.au("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(18);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(7)) {
                    drawable2 = typedArray.getDrawable(7);
                    break;
                } else if (typedArray.hasValue(17)) {
                    d.au("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(17);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? ap.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (He()[this.aGB.ordinal()]) {
            case 2:
                return this.aGv.getWidth();
            default:
                return this.aGv.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aGy) {
            R(f);
        }
    }

    public final void kw() {
        if (this.aGz != null) {
            this.aGz.setText(this.aGC);
        }
        Hk();
    }

    public final void ki() {
        if (this.aGz != null) {
            this.aGz.setText(this.aGD);
        }
        if (this.aGy) {
            ((AnimationDrawable) this.aGw.getDrawable()).start();
        } else {
            Hl();
        }
        if (this.aGA != null) {
            this.aGA.setVisibility(8);
        }
    }

    public final void kh() {
        if (this.aGz != null) {
            this.aGz.setText(this.aGE);
        }
        Hm();
    }

    public final void reset() {
        if (this.aGz != null) {
            this.aGz.setText(this.aGC);
        }
        this.aGw.setVisibility(0);
        if (this.aGy) {
            ((AnimationDrawable) this.aGw.getDrawable()).stop();
        } else {
            Hn();
        }
        if (this.aGA != null) {
            if (TextUtils.isEmpty(this.aGA.getText())) {
                this.aGA.setVisibility(8);
            } else {
                this.aGA.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aGw.setImageDrawable(drawable);
        this.aGy = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aGC = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aGD = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aGE = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aGz.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aGA != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aGA.setVisibility(8);
                return;
            }
            this.aGA.setText(charSequence);
            if (8 == this.aGA.getVisibility()) {
                this.aGA.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aGA != null) {
            this.aGA.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aGA != null) {
            this.aGA.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aGz != null) {
            this.aGz.setTextAppearance(getContext(), i);
        }
        if (this.aGA != null) {
            this.aGA.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aGz != null) {
            this.aGz.setTextColor(colorStateList);
        }
        if (this.aGA != null) {
            this.aGA.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aGz != null) {
            this.aGz.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aGz != null) {
            this.aGz.setTextSize(0, i);
        }
    }
}
