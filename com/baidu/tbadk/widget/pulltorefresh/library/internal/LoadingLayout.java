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
import d.a.m0.b1.l.a.c.b;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public abstract class LoadingLayout extends FrameLayout implements d.a.m0.b1.l.a.a {
    public static final Interpolator p = new LinearInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f13300e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f13301f;

    /* renamed from: g  reason: collision with root package name */
    public final ProgressBar f13302g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13303h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13304i;
    public final TextView j;
    public final PullToRefreshBase.Mode k;
    public final PullToRefreshBase.Orientation l;
    public CharSequence m;
    public CharSequence n;
    public CharSequence o;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13305a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f13306b;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            f13306b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13306b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PullToRefreshBase.Orientation.values().length];
            f13305a = iArr2;
            try {
                iArr2[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13305a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
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
        if (a.f13305a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_inner);
        this.f13300e = frameLayout;
        this.f13304i = (TextView) frameLayout.findViewById(R.id.pull_to_refresh_text);
        this.f13302g = (ProgressBar) this.f13300e.findViewById(R.id.pull_to_refresh_progress);
        this.j = (TextView) this.f13300e.findViewById(R.id.pull_to_refresh_sub_text);
        this.f13301f = (ImageView) this.f13300e.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13300e.getLayoutParams();
        if (a.f13306b[mode.ordinal()] != 1) {
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
        if (a.f13306b[mode.ordinal()] != 1) {
            if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableStart)) {
                drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableStart);
            } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableTop)) {
                d.a.m0.b1.l.a.c.a.a("ptrDrawableTop", "ptrDrawableStart");
                drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableTop);
            }
        } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableEnd)) {
            drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableEnd);
        } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableBottom)) {
            d.a.m0.b1.l.a.c.a.a("ptrDrawableBottom", "ptrDrawableEnd");
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

    private void setSubTextAppearance(int i2) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i2);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i2) {
        TextView textView = this.f13304i;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i2);
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setTextAppearance(getContext(), i2);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.f13304i;
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
        if (this.f13303h) {
            return;
        }
        c(f2);
    }

    public abstract void c(float f2);

    public final void d() {
        TextView textView = this.f13304i;
        if (textView != null) {
            textView.setText(this.m);
        }
        e();
    }

    public abstract void e();

    public final void f() {
        TextView textView = this.f13304i;
        if (textView != null) {
            textView.setText(this.n);
        }
        if (this.f13303h) {
            ((AnimationDrawable) this.f13301f.getDrawable()).start();
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
        if (a.f13305a[this.l.ordinal()] != 1) {
            return this.f13300e.getHeight();
        }
        return this.f13300e.getWidth();
    }

    public abstract int getDefaultDrawableResId();

    public final void h() {
        TextView textView = this.f13304i;
        if (textView != null) {
            textView.setText(this.o);
        }
        i();
    }

    public abstract void i();

    public final void j() {
        TextView textView = this.f13304i;
        if (textView != null) {
            textView.setText(this.m);
        }
        this.f13301f.setVisibility(0);
        if (this.f13303h) {
            ((AnimationDrawable) this.f13301f.getDrawable()).stop();
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

    public final void setHeight(int i2) {
        getLayoutParams().height = i2;
        requestLayout();
    }

    @Override // d.a.m0.b1.l.a.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // d.a.m0.b1.l.a.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.f13301f.setImageDrawable(drawable);
        this.f13303h = drawable instanceof AnimationDrawable;
        a(drawable);
    }

    @Override // d.a.m0.b1.l.a.a
    public void setPullLabel(CharSequence charSequence) {
        this.m = charSequence;
    }

    @Override // d.a.m0.b1.l.a.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.n = charSequence;
    }

    @Override // d.a.m0.b1.l.a.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.o = charSequence;
    }

    public void setTextSize(int i2) {
        TextView textView = this.f13304i;
        if (textView != null) {
            textView.setTextSize(0, i2);
        }
    }

    public void setTextTypeface(Typeface typeface) {
        this.f13304i.setTypeface(typeface);
    }

    public final void setWidth(int i2) {
        getLayoutParams().width = i2;
        requestLayout();
    }

    public void setTextColor(int i2) {
        TextView textView = this.f13304i;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }
}
