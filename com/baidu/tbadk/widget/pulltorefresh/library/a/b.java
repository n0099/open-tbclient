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
    private static /* synthetic */ int[] aLM;
    private static /* synthetic */ int[] aMg;
    static final Interpolator aMw = new LinearInterpolator();
    protected final PullToRefreshBase.Mode aLO;
    private boolean aMA;
    private final TextView aMB;
    private final TextView aMC;
    protected final PullToRefreshBase.Orientation aMD;
    private CharSequence aME;
    private CharSequence aMF;
    private CharSequence aMG;
    private FrameLayout aMx;
    protected final ImageView aMy;
    protected final ProgressBar aMz;

    protected abstract void Hq();

    protected abstract void Hr();

    protected abstract void Hs();

    protected abstract void Ht();

    protected abstract void Q(float f);

    protected abstract void f(Drawable drawable);

    protected abstract int getDefaultDrawableResId();

    static /* synthetic */ int[] Hi() {
        int[] iArr = aLM;
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
            aLM = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] Hn() {
        int[] iArr = aMg;
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
            aMg = iArr;
        }
        return iArr;
    }

    public b(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.aLO = mode;
        this.aMD = orientation;
        switch (Hi()[orientation.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(w.j.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.aMx = (FrameLayout) findViewById(w.h.fl_inner);
        this.aMB = (TextView) this.aMx.findViewById(w.h.pull_to_refresh_text);
        this.aMz = (ProgressBar) this.aMx.findViewById(w.h.pull_to_refresh_progress);
        this.aMC = (TextView) this.aMx.findViewById(w.h.pull_to_refresh_sub_text);
        this.aMy = (ImageView) this.aMx.findViewById(w.h.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aMx.getLayoutParams();
        switch (Hn()[mode.ordinal()]) {
            case 3:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.aME = context.getString(w.l.pull_to_refresh_pull_label);
                this.aMF = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aMG = context.getString(w.l.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.aME = context.getString(w.l.pull_to_refresh_pull_label);
                this.aMF = context.getString(w.l.pull_to_refresh_refreshing_label);
                this.aMG = context.getString(w.l.pull_to_refresh_release_label);
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
        switch (Hn()[mode.ordinal()]) {
            case 3:
                if (typedArray.hasValue(8)) {
                    drawable2 = typedArray.getDrawable(8);
                    break;
                } else if (typedArray.hasValue(18)) {
                    d.ar("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(18);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(7)) {
                    drawable2 = typedArray.getDrawable(7);
                    break;
                } else if (typedArray.hasValue(17)) {
                    d.ar("ptrDrawableTop", "ptrDrawableStart");
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
        switch (Hi()[this.aMD.ordinal()]) {
            case 2:
                return this.aMx.getWidth();
            default:
                return this.aMx.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.aMA) {
            Q(f);
        }
    }

    public final void Hu() {
        if (this.aMB != null) {
            this.aMB.setText(this.aME);
        }
        Hq();
    }

    public final void lg() {
        if (this.aMB != null) {
            this.aMB.setText(this.aMF);
        }
        if (this.aMA) {
            ((AnimationDrawable) this.aMy.getDrawable()).start();
        } else {
            Hr();
        }
        if (this.aMC != null) {
            this.aMC.setVisibility(8);
        }
    }

    public final void lf() {
        if (this.aMB != null) {
            this.aMB.setText(this.aMG);
        }
        Hs();
    }

    public final void reset() {
        if (this.aMB != null) {
            this.aMB.setText(this.aME);
        }
        this.aMy.setVisibility(0);
        if (this.aMA) {
            ((AnimationDrawable) this.aMy.getDrawable()).stop();
        } else {
            Ht();
        }
        if (this.aMC != null) {
            if (TextUtils.isEmpty(this.aMC.getText())) {
                this.aMC.setVisibility(8);
            } else {
                this.aMC.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.aMy.setImageDrawable(drawable);
        this.aMA = drawable instanceof AnimationDrawable;
        f(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.aME = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.aMF = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.aMG = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.aMB.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.aMC != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aMC.setVisibility(8);
                return;
            }
            this.aMC.setText(charSequence);
            if (8 == this.aMC.getVisibility()) {
                this.aMC.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.aMC != null) {
            this.aMC.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.aMC != null) {
            this.aMC.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.aMB != null) {
            this.aMB.setTextAppearance(getContext(), i);
        }
        if (this.aMC != null) {
            this.aMC.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.aMB != null) {
            this.aMB.setTextColor(colorStateList);
        }
        if (this.aMC != null) {
            this.aMC.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.aMB != null) {
            this.aMB.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.aMB != null) {
            this.aMB.setTextSize(0, i);
        }
    }
}
