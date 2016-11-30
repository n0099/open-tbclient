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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    private static /* synthetic */ int[] aHB;
    private static /* synthetic */ int[] aHV;
    static final Interpolator aIl = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aHD;
    private FrameLayout aIm;
    protected final ImageView aIn;
    protected final ProgressBar aIo;
    private boolean aIp;
    private final TextView aIq;
    private final TextView aIr;
    protected final PullToRefreshBase.Orientation aIs;
    private CharSequence aIt;
    private CharSequence aIu;
    private CharSequence aIv;

    protected abstract void HW();

    protected abstract void HX();

    protected abstract void HY();

    protected abstract void HZ();

    protected abstract void P(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] HQ() {
        int[] iArr = aHB;
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
            aHB = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] HT() {
        int[] iArr = aHV;
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
            aHV = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aHD = mode;
        this.aIs = orientation;
        switch (HQ()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(r.h.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(r.h.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aIm = (FrameLayout) findViewById(r.g.fl_inner);
        this.aIq = (TextView) this.aIm.findViewById(r.g.pull_to_refresh_text);
        this.aIo = (ProgressBar) this.aIm.findViewById(r.g.pull_to_refresh_progress);
        this.aIr = (TextView) this.aIm.findViewById(r.g.pull_to_refresh_sub_text);
        this.aIn = (ImageView) this.aIm.findViewById(r.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aIm.getLayoutParams();
        switch (HT()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aIt = context.getString(r.j.pull_to_refresh_pull_label);
                this.aIu = context.getString(r.j.pull_to_refresh_refreshing_label);
                this.aIv = context.getString(r.j.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aIt = context.getString(r.j.pull_to_refresh_pull_label);
                this.aIu = context.getString(r.j.pull_to_refresh_refreshing_label);
                this.aIv = context.getString(r.j.pull_to_refresh_release_label);
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
        switch (HT()[mode.ordinal()]) {
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
        switch (HQ()[this.aIs.ordinal()]) {
            case 2:
                return this.aIm.getWidth();
            default:
                return this.aIm.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aIp) {
            P(f);
        }
    }

    public final void kE() {
        if (this.aIq != null) {
            this.aIq.setText(this.aIt);
        }
        HW();
    }

    public final void km() {
        if (this.aIq != null) {
            this.aIq.setText(this.aIu);
        }
        if (this.aIp) {
            ((AnimationDrawable) this.aIn.getDrawable()).start();
        } else {
            HX();
        }
        if (this.aIr != null) {
            this.aIr.setVisibility(8);
        }
    }

    public final void kl() {
        if (this.aIq != null) {
            this.aIq.setText(this.aIv);
        }
        HY();
    }

    public final void reset() {
        if (this.aIq != null) {
            this.aIq.setText(this.aIt);
        }
        this.aIn.setVisibility(0);
        if (this.aIp) {
            ((AnimationDrawable) this.aIn.getDrawable()).stop();
        } else {
            HZ();
        }
        if (this.aIr != null) {
            if (TextUtils.isEmpty(this.aIr.getText())) {
                this.aIr.setVisibility(8);
            } else {
                this.aIr.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aIn.setImageDrawable(drawable);
        this.aIp = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aIt = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aIu = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aIv = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aIq.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aIr != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aIr.setVisibility(8);
                return;
            }
            this.aIr.setText(charSequence);
            if (8 == this.aIr.getVisibility()) {
                this.aIr.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aIr != null) {
            this.aIr.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aIr != null) {
            this.aIr.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aIq != null) {
            this.aIq.setTextAppearance(getContext(), i);
        }
        if (this.aIr != null) {
            this.aIr.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aIq != null) {
            this.aIq.setTextColor(colorStateList);
        }
        if (this.aIr != null) {
            this.aIr.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aIq != null) {
            this.aIq.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aIq != null) {
            this.aIq.setTextSize(0, i);
        }
    }
}
