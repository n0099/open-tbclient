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
    private static /* synthetic */ int[] aLT;
    private static /* synthetic */ int[] aLz;
    static final Interpolator aMj = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aLB;
    private FrameLayout aMk;
    protected final ImageView aMl;
    protected final ProgressBar aMm;
    private boolean aMn;
    private final TextView aMo;
    private final TextView aMp;
    protected final PullToRefreshBase.Orientation aMq;
    private CharSequence aMr;
    private CharSequence aMs;
    private CharSequence aMt;

    protected abstract void Ii();

    protected abstract void Ij();

    protected abstract void Ik();

    protected abstract void Il();

    protected abstract void R(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] Ic() {
        int[] iArr = aLz;
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
            aLz = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] If() {
        int[] iArr = aLT;
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
            aLT = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aLB = mode;
        this.aMq = orientation;
        switch (Ic()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aMk = (FrameLayout) findViewById(w.h.fl_inner);
        this.aMo = (TextView) this.aMk.findViewById(w.h.pull_to_refresh_text);
        this.aMm = (ProgressBar) this.aMk.findViewById(w.h.pull_to_refresh_progress);
        this.aMp = (TextView) this.aMk.findViewById(w.h.pull_to_refresh_sub_text);
        this.aMl = (ImageView) this.aMk.findViewById(w.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aMk.getLayoutParams();
        switch (If()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aMr = context.getString(w.l.pull_to_refresh_pull_label);
                this.aMs = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aMt = context.getString(w.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aMr = context.getString(w.l.pull_to_refresh_pull_label);
                this.aMs = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aMt = context.getString(w.l.pull_to_refresh_release_label);
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
        switch (If()[mode.ordinal()]) {
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
        switch (Ic()[this.aMq.ordinal()]) {
            case 2:
                return this.aMk.getWidth();
            default:
                return this.aMk.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aMn) {
            R(f);
        }
    }

    public final void lv() {
        if (this.aMo != null) {
            this.aMo.setText(this.aMr);
        }
        Ii();
    }

    public final void lh() {
        if (this.aMo != null) {
            this.aMo.setText(this.aMs);
        }
        if (this.aMn) {
            ((AnimationDrawable) this.aMl.getDrawable()).start();
        } else {
            Ij();
        }
        if (this.aMp != null) {
            this.aMp.setVisibility(8);
        }
    }

    public final void lg() {
        if (this.aMo != null) {
            this.aMo.setText(this.aMt);
        }
        Ik();
    }

    public final void reset() {
        if (this.aMo != null) {
            this.aMo.setText(this.aMr);
        }
        this.aMl.setVisibility(0);
        if (this.aMn) {
            ((AnimationDrawable) this.aMl.getDrawable()).stop();
        } else {
            Il();
        }
        if (this.aMp != null) {
            if (TextUtils.isEmpty(this.aMp.getText())) {
                this.aMp.setVisibility(8);
            } else {
                this.aMp.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aMl.setImageDrawable(drawable);
        this.aMn = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aMr = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aMs = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aMt = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aMo.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aMp != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aMp.setVisibility(8);
                return;
            }
            this.aMp.setText(charSequence);
            if (8 == this.aMp.getVisibility()) {
                this.aMp.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aMp != null) {
            this.aMp.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aMp != null) {
            this.aMp.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aMo != null) {
            this.aMo.setTextAppearance(getContext(), i);
        }
        if (this.aMp != null) {
            this.aMp.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aMo != null) {
            this.aMo.setTextColor(colorStateList);
        }
        if (this.aMp != null) {
            this.aMp.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aMo != null) {
            this.aMo.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aMo != null) {
            this.aMo.setTextSize(0, i);
        }
    }
}
