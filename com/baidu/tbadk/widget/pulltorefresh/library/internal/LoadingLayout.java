package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.h0.b1.l.a.c.b;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public abstract class LoadingLayout extends FrameLayout implements d.b.h0.b1.l.a.a {
    public static final Interpolator p = new LinearInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f14274e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f14275f;

    /* renamed from: g  reason: collision with root package name */
    public final ProgressBar f14276g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14277h;
    public final TextView i;
    public final TextView j;
    public final PullToRefreshBase.Mode k;
    public final PullToRefreshBase.Orientation l;
    public CharSequence m;
    public CharSequence n;
    public CharSequence o;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14278a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f14279b;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            f14279b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14279b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PullToRefreshBase.Orientation.values().length];
            f14278a = iArr2;
            try {
                iArr2[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14278a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.k = mode;
        this.l = orientation;
        if (a.f14278a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_inner);
        this.f14274e = frameLayout;
        this.i = (TextView) frameLayout.findViewById(R.id.pull_to_refresh_text);
        this.f14276g = (ProgressBar) this.f14274e.findViewById(R.id.pull_to_refresh_progress);
        this.j = (TextView) this.f14274e.findViewById(R.id.pull_to_refresh_sub_text);
        this.f14275f = (ImageView) this.f14274e.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14274e.getLayoutParams();
        if (a.f14279b[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
            this.m = context.getString(R.string.pull_to_refresh_pull_label);
            this.n = context.getString(R.string.pull_to_refresh_refreshing_label);
            this.o = context.getString(R.string.pull_to_refresh_release_label);
        } else {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
            this.m = context.getString(R.string.pull_to_refresh_pull_label);
            this.n = context.getString(R.string.pull_to_refresh_refreshing_label);
            this.o = context.getString(R.string.pull_to_refresh_release_label);
        }
        if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrHeaderBackground) && (drawable = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrHeaderBackground)) != null) {
            b.b(this, drawable);
        }
        if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(R$styleable.PullToRefresh_tb_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrSubHeaderTextAppearance)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(R$styleable.PullToRefresh_tb_ptrSubHeaderTextAppearance, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrHeaderTextColor) && (colorStateList2 = typedArray.getColorStateList(R$styleable.PullToRefresh_tb_ptrHeaderTextColor)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrHeaderSubTextColor) && (colorStateList = typedArray.getColorStateList(R$styleable.PullToRefresh_tb_ptrHeaderSubTextColor)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawable) ? typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawable) : null;
        if (a.f14279b[mode.ordinal()] != 1) {
            if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableStart)) {
                drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableStart);
            } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableTop)) {
                d.b.h0.b1.l.a.c.a.a("ptrDrawableTop", "ptrDrawableStart");
                drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableTop);
            }
        } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableEnd)) {
            drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableEnd);
        } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableBottom)) {
            d.b.h0.b1.l.a.c.a.a("ptrDrawableBottom", "ptrDrawableEnd");
            drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableBottom);
        }
        setLoadingDrawable(drawable2 == null ? SkinManager.getDrawable(getDefaultDrawableResId()) : drawable2);
        j();
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.j != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.j.setVisibility(8);
                return;
            }
            this.j.setText(charSequence);
            if (8 == this.j.getVisibility()) {
                this.j.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    public abstract void a(Drawable drawable);

    public final void b(float f2) {
        if (this.f14277h) {
            return;
        }
        c(f2);
    }

    public abstract void c(float f2);

    public final void d() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(this.m);
        }
        e();
    }

    public abstract void e();

    public final void f() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(this.n);
        }
        if (this.f14277h) {
            ((AnimationDrawable) this.f14275f.getDrawable()).start();
        } else {
            g();
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    public abstract void g();

    public final int getContentSize() {
        if (a.f14278a[this.l.ordinal()] != 1) {
            return this.f14274e.getHeight();
        }
        return this.f14274e.getWidth();
    }

    public abstract int getDefaultDrawableResId();

    public final void h() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(this.o);
        }
        i();
    }

    public abstract void i();

    public final void j() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(this.m);
        }
        this.f14275f.setVisibility(0);
        if (this.f14277h) {
            ((AnimationDrawable) this.f14275f.getDrawable()).stop();
        } else {
            k();
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            if (TextUtils.isEmpty(textView2.getText())) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
        }
    }

    public abstract void k();

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    @Override // d.b.h0.b1.l.a.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // d.b.h0.b1.l.a.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.f14275f.setImageDrawable(drawable);
        this.f14277h = drawable instanceof AnimationDrawable;
        a(drawable);
    }

    @Override // d.b.h0.b1.l.a.a
    public void setPullLabel(CharSequence charSequence) {
        this.m = charSequence;
    }

    @Override // d.b.h0.b1.l.a.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.n = charSequence;
    }

    @Override // d.b.h0.b1.l.a.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.o = charSequence;
    }

    public void setTextSize(int i) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setTextSize(0, i);
        }
    }

    public void setTextTypeface(Typeface typeface) {
        this.i.setTypeface(typeface);
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }

    public void setTextColor(int i) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }
}
