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
    private static /* synthetic */ int[] aCL;
    private static /* synthetic */ int[] aDf;
    static final Interpolator aDv = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aCN;
    private final TextView aDA;
    private final TextView aDB;
    protected final PullToRefreshBase.Orientation aDC;
    private CharSequence aDD;
    private CharSequence aDE;
    private CharSequence aDF;
    private FrameLayout aDw;
    protected final ImageView aDx;
    protected final ProgressBar aDy;
    private boolean aDz;

    protected abstract void GA();

    protected abstract void GB();

    protected abstract void Gy();

    protected abstract void Gz();

    protected abstract void d(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    protected abstract void t(float f);

    static /* synthetic */ int[] Gn() {
        int[] iArr = aCL;
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
            aCL = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Gv() {
        int[] iArr = aDf;
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
            aDf = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aCN = mode;
        this.aDC = orientation;
        switch (Gn()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(t.h.pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(t.h.pull_to_refresh_header_vertical, this);
                break;
        }
        this.aDw = (FrameLayout) findViewById(t.g.fl_inner);
        this.aDA = (TextView) this.aDw.findViewById(t.g.pull_to_refresh_text);
        this.aDy = (ProgressBar) this.aDw.findViewById(t.g.pull_to_refresh_progress);
        this.aDB = (TextView) this.aDw.findViewById(t.g.pull_to_refresh_sub_text);
        this.aDx = (ImageView) this.aDw.findViewById(t.g.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aDw.getLayoutParams();
        switch (Gv()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aDD = context.getString(t.j.pull_to_refresh_from_bottom_pull_label);
                this.aDE = context.getString(t.j.pull_to_refresh_from_bottom_refreshing_label);
                this.aDF = context.getString(t.j.pull_to_refresh_from_bottom_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aDD = context.getString(t.j.pull_to_refresh_pull_label);
                this.aDE = context.getString(t.j.pull_to_refresh_refreshing_label);
                this.aDF = context.getString(t.j.pull_to_refresh_release_label);
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
        switch (Gv()[mode.ordinal()]) {
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
        switch (Gn()[this.aDC.ordinal()]) {
            case 2:
                return this.aDw.getWidth();
            default:
                return this.aDw.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aDz) {
            t(f);
        }
    }

    public final void jH() {
        if (this.aDA != null) {
            this.aDA.setText(this.aDD);
        }
        Gy();
    }

    public final void jp() {
        if (this.aDA != null) {
            this.aDA.setText(this.aDE);
        }
        if (this.aDz) {
            ((AnimationDrawable) this.aDx.getDrawable()).start();
        } else {
            Gz();
        }
        if (this.aDB != null) {
            this.aDB.setVisibility(8);
        }
    }

    public final void jo() {
        if (this.aDA != null) {
            this.aDA.setText(this.aDF);
        }
        GA();
    }

    public final void reset() {
        if (this.aDA != null) {
            this.aDA.setText(this.aDD);
        }
        this.aDx.setVisibility(0);
        if (this.aDz) {
            ((AnimationDrawable) this.aDx.getDrawable()).stop();
        } else {
            GB();
        }
        if (this.aDB != null) {
            if (TextUtils.isEmpty(this.aDB.getText())) {
                this.aDB.setVisibility(8);
            } else {
                this.aDB.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aDx.setImageDrawable(drawable);
        this.aDz = drawable instanceof AnimationDrawable;
        d(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aDD = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aDE = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aDF = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aDA.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aDB != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aDB.setVisibility(8);
                return;
            }
            this.aDB.setText(charSequence);
            if (8 == this.aDB.getVisibility()) {
                this.aDB.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aDB != null) {
            this.aDB.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aDB != null) {
            this.aDB.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aDA != null) {
            this.aDA.setTextAppearance(getContext(), i);
        }
        if (this.aDB != null) {
            this.aDB.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aDA != null) {
            this.aDA.setTextColor(colorStateList);
        }
        if (this.aDB != null) {
            this.aDB.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aDA != null) {
            this.aDA.setTextColor(i);
        }
    }
}
