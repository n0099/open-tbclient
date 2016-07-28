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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator aEM = new LinearInterpolator();
    private static /* synthetic */ int[] aEc;
    private static /* synthetic */ int[] aEw;
    private FrameLayout aEN;
    protected final ImageView aEO;
    protected final ProgressBar aEP;
    private boolean aEQ;
    private final TextView aER;
    private final TextView aES;
    protected final PullToRefreshBase.Orientation aET;
    private CharSequence aEU;
    private CharSequence aEV;
    private CharSequence aEW;
    protected final PullToRefreshBase.Mode aEe;

    protected abstract void D(float f);

    protected abstract void GA();

    protected abstract void Gx();

    protected abstract void Gy();

    protected abstract void Gz();

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] Gr() {
        int[] iArr = aEc;
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
            aEc = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Gu() {
        int[] iArr = aEw;
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
            aEw = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aEe = mode;
        this.aET = orientation;
        switch (Gr()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(u.h.pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(u.h.pull_to_refresh_header_vertical, this);
                break;
        }
        this.aEN = (FrameLayout) findViewById(u.g.fl_inner);
        this.aER = (TextView) this.aEN.findViewById(u.g.pull_to_refresh_text);
        this.aEP = (ProgressBar) this.aEN.findViewById(u.g.pull_to_refresh_progress);
        this.aES = (TextView) this.aEN.findViewById(u.g.pull_to_refresh_sub_text);
        this.aEO = (ImageView) this.aEN.findViewById(u.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aEN.getLayoutParams();
        switch (Gu()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aEU = context.getString(u.j.pull_to_refresh_from_bottom_pull_label);
                this.aEV = context.getString(u.j.pull_to_refresh_from_bottom_refreshing_label);
                this.aEW = context.getString(u.j.pull_to_refresh_from_bottom_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aEU = context.getString(u.j.pull_to_refresh_pull_label);
                this.aEV = context.getString(u.j.pull_to_refresh_refreshing_label);
                this.aEW = context.getString(u.j.pull_to_refresh_release_label);
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
        switch (Gu()[mode.ordinal()]) {
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
        switch (Gr()[this.aET.ordinal()]) {
            case 2:
                return this.aEN.getWidth();
            default:
                return this.aEN.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aEQ) {
            D(f);
        }
    }

    public final void jJ() {
        if (this.aER != null) {
            this.aER.setText(this.aEU);
        }
        Gx();
    }

    public final void jr() {
        if (this.aER != null) {
            this.aER.setText(this.aEV);
        }
        if (this.aEQ) {
            ((AnimationDrawable) this.aEO.getDrawable()).start();
        } else {
            Gy();
        }
        if (this.aES != null) {
            this.aES.setVisibility(8);
        }
    }

    public final void jq() {
        if (this.aER != null) {
            this.aER.setText(this.aEW);
        }
        Gz();
    }

    public final void reset() {
        if (this.aER != null) {
            this.aER.setText(this.aEU);
        }
        this.aEO.setVisibility(0);
        if (this.aEQ) {
            ((AnimationDrawable) this.aEO.getDrawable()).stop();
        } else {
            GA();
        }
        if (this.aES != null) {
            if (TextUtils.isEmpty(this.aES.getText())) {
                this.aES.setVisibility(8);
            } else {
                this.aES.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aEO.setImageDrawable(drawable);
        this.aEQ = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aEU = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aEV = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aEW = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aER.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aES != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aES.setVisibility(8);
                return;
            }
            this.aES.setText(charSequence);
            if (8 == this.aES.getVisibility()) {
                this.aES.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aES != null) {
            this.aES.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aES != null) {
            this.aES.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aER != null) {
            this.aER.setTextAppearance(getContext(), i);
        }
        if (this.aES != null) {
            this.aES.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aER != null) {
            this.aER.setTextColor(colorStateList);
        }
        if (this.aES != null) {
            this.aES.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aER != null) {
            this.aER.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aER != null) {
            this.aER.setTextSize(0, i);
        }
    }
}
