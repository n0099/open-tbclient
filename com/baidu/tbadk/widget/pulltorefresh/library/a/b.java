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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    private static /* synthetic */ int[] aGV;
    static final Interpolator aHF = new LinearInterpolator();
    private static /* synthetic */ int[] aHp;
    protected final PullToRefreshBase.Mode aGX;
    private FrameLayout aHG;
    protected final ImageView aHH;
    protected final ProgressBar aHI;
    private boolean aHJ;
    private final TextView aHK;
    private final TextView aHL;
    protected final PullToRefreshBase.Orientation aHM;
    private CharSequence aHN;
    private CharSequence aHO;
    private CharSequence aHP;

    protected abstract void Hs();

    protected abstract void Ht();

    protected abstract void Hu();

    protected abstract void Hv();

    protected abstract void Q(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] Hm() {
        int[] iArr = aGV;
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
            aGV = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Hp() {
        int[] iArr = aHp;
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
            aHp = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aGX = mode;
        this.aHM = orientation;
        switch (Hm()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(r.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(r.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aHG = (FrameLayout) findViewById(r.g.fl_inner);
        this.aHK = (TextView) this.aHG.findViewById(r.g.pull_to_refresh_text);
        this.aHI = (ProgressBar) this.aHG.findViewById(r.g.pull_to_refresh_progress);
        this.aHL = (TextView) this.aHG.findViewById(r.g.pull_to_refresh_sub_text);
        this.aHH = (ImageView) this.aHG.findViewById(r.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHG.getLayoutParams();
        switch (Hp()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aHN = context.getString(r.j.pull_to_refresh_pull_label);
                this.aHO = context.getString(r.j.pull_to_refresh_refreshing_label);
                this.aHP = context.getString(r.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aHN = context.getString(r.j.pull_to_refresh_pull_label);
                this.aHO = context.getString(r.j.pull_to_refresh_refreshing_label);
                this.aHP = context.getString(r.j.pull_to_refresh_release_label);
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
        switch (Hp()[mode.ordinal()]) {
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
        setLoadingDrawable(drawable2 == null ? ar.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (Hm()[this.aHM.ordinal()]) {
            case 2:
                return this.aHG.getWidth();
            default:
                return this.aHG.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aHJ) {
            Q(f);
        }
    }

    public final void kE() {
        if (this.aHK != null) {
            this.aHK.setText(this.aHN);
        }
        Hs();
    }

    public final void km() {
        if (this.aHK != null) {
            this.aHK.setText(this.aHO);
        }
        if (this.aHJ) {
            ((AnimationDrawable) this.aHH.getDrawable()).start();
        } else {
            Ht();
        }
        if (this.aHL != null) {
            this.aHL.setVisibility(8);
        }
    }

    public final void kl() {
        if (this.aHK != null) {
            this.aHK.setText(this.aHP);
        }
        Hu();
    }

    public final void reset() {
        if (this.aHK != null) {
            this.aHK.setText(this.aHN);
        }
        this.aHH.setVisibility(0);
        if (this.aHJ) {
            ((AnimationDrawable) this.aHH.getDrawable()).stop();
        } else {
            Hv();
        }
        if (this.aHL != null) {
            if (TextUtils.isEmpty(this.aHL.getText())) {
                this.aHL.setVisibility(8);
            } else {
                this.aHL.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aHH.setImageDrawable(drawable);
        this.aHJ = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aHN = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aHO = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aHP = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aHK.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aHL != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aHL.setVisibility(8);
                return;
            }
            this.aHL.setText(charSequence);
            if (8 == this.aHL.getVisibility()) {
                this.aHL.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aHL != null) {
            this.aHL.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aHL != null) {
            this.aHL.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aHK != null) {
            this.aHK.setTextAppearance(getContext(), i);
        }
        if (this.aHL != null) {
            this.aHL.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aHK != null) {
            this.aHK.setTextColor(colorStateList);
        }
        if (this.aHL != null) {
            this.aHL.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aHK != null) {
            this.aHK.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aHK != null) {
            this.aHK.setTextSize(0, i);
        }
    }
}
