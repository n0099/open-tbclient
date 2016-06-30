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
    private static /* synthetic */ int[] aDF;
    static final Interpolator aDV = new LinearInterpolator();
    private static /* synthetic */ int[] aDl;
    private FrameLayout aDW;
    protected final ImageView aDX;
    protected final ProgressBar aDY;
    private boolean aDZ;
    protected final PullToRefreshBase.Mode aDn;
    private final TextView aEa;
    private final TextView aEb;
    protected final PullToRefreshBase.Orientation aEc;
    private CharSequence aEd;
    private CharSequence aEe;
    private CharSequence aEf;

    protected abstract void GA();

    protected abstract void GB();

    protected abstract void GC();

    protected abstract void Gz();

    protected abstract void d(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    protected abstract void t(float f);

    static /* synthetic */ int[] Go() {
        int[] iArr = aDl;
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
            aDl = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Gw() {
        int[] iArr = aDF;
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
            aDF = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aDn = mode;
        this.aEc = orientation;
        switch (Go()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(u.h.pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(u.h.pull_to_refresh_header_vertical, this);
                break;
        }
        this.aDW = (FrameLayout) findViewById(u.g.fl_inner);
        this.aEa = (TextView) this.aDW.findViewById(u.g.pull_to_refresh_text);
        this.aDY = (ProgressBar) this.aDW.findViewById(u.g.pull_to_refresh_progress);
        this.aEb = (TextView) this.aDW.findViewById(u.g.pull_to_refresh_sub_text);
        this.aDX = (ImageView) this.aDW.findViewById(u.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aDW.getLayoutParams();
        switch (Gw()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aEd = context.getString(u.j.pull_to_refresh_from_bottom_pull_label);
                this.aEe = context.getString(u.j.pull_to_refresh_from_bottom_refreshing_label);
                this.aEf = context.getString(u.j.pull_to_refresh_from_bottom_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aEd = context.getString(u.j.pull_to_refresh_pull_label);
                this.aEe = context.getString(u.j.pull_to_refresh_refreshing_label);
                this.aEf = context.getString(u.j.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(1) && (drawable = typedArray.getDrawable(1)) != null) {
            e.a(this, drawable);
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
        switch (Gw()[mode.ordinal()]) {
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
        switch (Go()[this.aEc.ordinal()]) {
            case 2:
                return this.aDW.getWidth();
            default:
                return this.aDW.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aDZ) {
            t(f);
        }
    }

    public final void jK() {
        if (this.aEa != null) {
            this.aEa.setText(this.aEd);
        }
        Gz();
    }

    public final void js() {
        if (this.aEa != null) {
            this.aEa.setText(this.aEe);
        }
        if (this.aDZ) {
            ((AnimationDrawable) this.aDX.getDrawable()).start();
        } else {
            GA();
        }
        if (this.aEb != null) {
            this.aEb.setVisibility(8);
        }
    }

    public final void jr() {
        if (this.aEa != null) {
            this.aEa.setText(this.aEf);
        }
        GB();
    }

    public final void reset() {
        if (this.aEa != null) {
            this.aEa.setText(this.aEd);
        }
        this.aDX.setVisibility(0);
        if (this.aDZ) {
            ((AnimationDrawable) this.aDX.getDrawable()).stop();
        } else {
            GC();
        }
        if (this.aEb != null) {
            if (TextUtils.isEmpty(this.aEb.getText())) {
                this.aEb.setVisibility(8);
            } else {
                this.aEb.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aDX.setImageDrawable(drawable);
        this.aDZ = drawable instanceof AnimationDrawable;
        d(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aEd = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aEe = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aEf = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aEa.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aEb != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aEb.setVisibility(8);
                return;
            }
            this.aEb.setText(charSequence);
            if (8 == this.aEb.getVisibility()) {
                this.aEb.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aEb != null) {
            this.aEb.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aEb != null) {
            this.aEb.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aEa != null) {
            this.aEa.setTextAppearance(getContext(), i);
        }
        if (this.aEb != null) {
            this.aEb.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aEa != null) {
            this.aEa.setTextColor(colorStateList);
        }
        if (this.aEb != null) {
            this.aEb.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aEa != null) {
            this.aEa.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aEa != null) {
            this.aEa.setTextSize(0, i);
        }
    }
}
