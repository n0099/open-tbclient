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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    private static /* synthetic */ int[] aHG;
    static final Interpolator aHW = new LinearInterpolator();
    private static /* synthetic */ int[] aHm;
    private FrameLayout aHX;
    protected final ImageView aHY;
    protected final ProgressBar aHZ;
    protected final PullToRefreshBase.Mode aHo;
    private boolean aIa;
    private final TextView aIb;
    private final TextView aIc;
    protected final PullToRefreshBase.Orientation aId;
    private CharSequence aIe;
    private CharSequence aIf;
    private CharSequence aIg;

    protected abstract void HU();

    protected abstract void HV();

    protected abstract void HW();

    protected abstract void HX();

    protected abstract void P(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] HO() {
        int[] iArr = aHm;
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
            aHm = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] HR() {
        int[] iArr = aHG;
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
            aHG = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aHo = mode;
        this.aId = orientation;
        switch (HO()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(t.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(t.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aHX = (FrameLayout) findViewById(t.g.fl_inner);
        this.aIb = (TextView) this.aHX.findViewById(t.g.pull_to_refresh_text);
        this.aHZ = (ProgressBar) this.aHX.findViewById(t.g.pull_to_refresh_progress);
        this.aIc = (TextView) this.aHX.findViewById(t.g.pull_to_refresh_sub_text);
        this.aHY = (ImageView) this.aHX.findViewById(t.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHX.getLayoutParams();
        switch (HR()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aIe = context.getString(t.j.pull_to_refresh_pull_label);
                this.aIf = context.getString(t.j.pull_to_refresh_refreshing_label);
                this.aIg = context.getString(t.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aIe = context.getString(t.j.pull_to_refresh_pull_label);
                this.aIf = context.getString(t.j.pull_to_refresh_refreshing_label);
                this.aIg = context.getString(t.j.pull_to_refresh_release_label);
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
        switch (HR()[mode.ordinal()]) {
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
        switch (HO()[this.aId.ordinal()]) {
            case 2:
                return this.aHX.getWidth();
            default:
                return this.aHX.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aIa) {
            P(f);
        }
    }

    public final void kE() {
        if (this.aIb != null) {
            this.aIb.setText(this.aIe);
        }
        HU();
    }

    public final void km() {
        if (this.aIb != null) {
            this.aIb.setText(this.aIf);
        }
        if (this.aIa) {
            ((AnimationDrawable) this.aHY.getDrawable()).start();
        } else {
            HV();
        }
        if (this.aIc != null) {
            this.aIc.setVisibility(8);
        }
    }

    public final void kl() {
        if (this.aIb != null) {
            this.aIb.setText(this.aIg);
        }
        HW();
    }

    public final void reset() {
        if (this.aIb != null) {
            this.aIb.setText(this.aIe);
        }
        this.aHY.setVisibility(0);
        if (this.aIa) {
            ((AnimationDrawable) this.aHY.getDrawable()).stop();
        } else {
            HX();
        }
        if (this.aIc != null) {
            if (TextUtils.isEmpty(this.aIc.getText())) {
                this.aIc.setVisibility(8);
            } else {
                this.aIc.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aHY.setImageDrawable(drawable);
        this.aIa = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aIe = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aIf = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aIg = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aIb.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aIc != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aIc.setVisibility(8);
                return;
            }
            this.aIc.setText(charSequence);
            if (8 == this.aIc.getVisibility()) {
                this.aIc.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aIc != null) {
            this.aIc.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aIc != null) {
            this.aIc.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aIb != null) {
            this.aIb.setTextAppearance(getContext(), i);
        }
        if (this.aIc != null) {
            this.aIc.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aIb != null) {
            this.aIb.setTextColor(colorStateList);
        }
        if (this.aIc != null) {
            this.aIc.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aIb != null) {
            this.aIb.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aIb != null) {
            this.aIb.setTextSize(0, i);
        }
    }
}
