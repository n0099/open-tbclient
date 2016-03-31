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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    private static /* synthetic */ int[] aGN;
    private static /* synthetic */ int[] aHh;
    static final Interpolator aHx = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aGP;
    protected final ProgressBar aHA;
    private boolean aHB;
    private final TextView aHC;
    private final TextView aHD;
    protected final PullToRefreshBase.Orientation aHE;
    private CharSequence aHF;
    private CharSequence aHG;
    private CharSequence aHH;
    private FrameLayout aHy;
    protected final ImageView aHz;

    protected abstract void Ig();

    protected abstract void Ih();

    protected abstract void Ii();

    protected abstract void Ij();

    protected abstract void d(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    protected abstract void v(float f);

    static /* synthetic */ int[] HV() {
        int[] iArr = aGN;
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
            aGN = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Id() {
        int[] iArr = aHh;
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
            aHh = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aGP = mode;
        this.aHE = orientation;
        switch (HV()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(t.h.pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(t.h.pull_to_refresh_header_vertical, this);
                break;
        }
        this.aHy = (FrameLayout) findViewById(t.g.fl_inner);
        this.aHC = (TextView) this.aHy.findViewById(t.g.pull_to_refresh_text);
        this.aHA = (ProgressBar) this.aHy.findViewById(t.g.pull_to_refresh_progress);
        this.aHD = (TextView) this.aHy.findViewById(t.g.pull_to_refresh_sub_text);
        this.aHz = (ImageView) this.aHy.findViewById(t.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHy.getLayoutParams();
        switch (Id()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aHF = context.getString(t.j.pull_to_refresh_from_bottom_pull_label);
                this.aHG = context.getString(t.j.pull_to_refresh_from_bottom_refreshing_label);
                this.aHH = context.getString(t.j.pull_to_refresh_from_bottom_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aHF = context.getString(t.j.pull_to_refresh_pull_label);
                this.aHG = context.getString(t.j.pull_to_refresh_refreshing_label);
                this.aHH = context.getString(t.j.pull_to_refresh_release_label);
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
        switch (Id()[mode.ordinal()]) {
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
        setLoadingDrawable(drawable2 == null ? at.getDrawable(getDefaultDrawableResId()) : drawable2);
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
        switch (HV()[this.aHE.ordinal()]) {
            case 2:
                return this.aHy.getWidth();
            default:
                return this.aHy.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aHB) {
            v(f);
        }
    }

    public final void nt() {
        if (this.aHC != null) {
            this.aHC.setText(this.aHF);
        }
        Ig();
    }

    public final void nb() {
        if (this.aHC != null) {
            this.aHC.setText(this.aHG);
        }
        if (this.aHB) {
            ((AnimationDrawable) this.aHz.getDrawable()).start();
        } else {
            Ih();
        }
        if (this.aHD != null) {
            this.aHD.setVisibility(8);
        }
    }

    public final void na() {
        if (this.aHC != null) {
            this.aHC.setText(this.aHH);
        }
        Ii();
    }

    public final void reset() {
        if (this.aHC != null) {
            this.aHC.setText(this.aHF);
        }
        this.aHz.setVisibility(0);
        if (this.aHB) {
            ((AnimationDrawable) this.aHz.getDrawable()).stop();
        } else {
            Ij();
        }
        if (this.aHD != null) {
            if (TextUtils.isEmpty(this.aHD.getText())) {
                this.aHD.setVisibility(8);
            } else {
                this.aHD.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aHz.setImageDrawable(drawable);
        this.aHB = drawable instanceof AnimationDrawable;
        d(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aHF = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aHG = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aHH = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aHC.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aHD != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aHD.setVisibility(8);
                return;
            }
            this.aHD.setText(charSequence);
            if (8 == this.aHD.getVisibility()) {
                this.aHD.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aHD != null) {
            this.aHD.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aHD != null) {
            this.aHD.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aHC != null) {
            this.aHC.setTextAppearance(getContext(), i);
        }
        if (this.aHD != null) {
            this.aHD.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aHC != null) {
            this.aHC.setTextColor(colorStateList);
        }
        if (this.aHD != null) {
            this.aHD.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aHC != null) {
            this.aHC.setTextColor(i);
        }
    }
}
