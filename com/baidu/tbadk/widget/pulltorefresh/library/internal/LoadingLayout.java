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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.b1.l.a.c.b;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public abstract class LoadingLayout extends FrameLayout implements d.a.o0.b1.l.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f13484e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f13485f;

    /* renamed from: g  reason: collision with root package name */
    public final ProgressBar f13486g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13487h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13488i;
    public final TextView j;
    public final PullToRefreshBase.Mode k;
    public final PullToRefreshBase.Orientation l;
    public CharSequence m;
    public CharSequence n;
    public CharSequence o;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13489a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f13490b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(891679610, "Lcom/baidu/tbadk/widget/pulltorefresh/library/internal/LoadingLayout$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(891679610, "Lcom/baidu/tbadk/widget/pulltorefresh/library/internal/LoadingLayout$a;");
                    return;
                }
            }
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            f13490b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13490b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PullToRefreshBase.Orientation.values().length];
            f13489a = iArr2;
            try {
                iArr2[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13489a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1819920279, "Lcom/baidu/tbadk/widget/pulltorefresh/library/internal/LoadingLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1819920279, "Lcom/baidu/tbadk/widget/pulltorefresh/library/internal/LoadingLayout;");
                return;
            }
        }
        p = new LinearInterpolator();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mode, orientation, typedArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = mode;
        this.l = orientation;
        if (a.f13489a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_inner);
        this.f13484e = frameLayout;
        this.f13488i = (TextView) frameLayout.findViewById(R.id.pull_to_refresh_text);
        this.f13486g = (ProgressBar) this.f13484e.findViewById(R.id.pull_to_refresh_progress);
        this.j = (TextView) this.f13484e.findViewById(R.id.pull_to_refresh_sub_text);
        this.f13485f = (ImageView) this.f13484e.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13484e.getLayoutParams();
        if (a.f13490b[mode.ordinal()] != 1) {
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
        if (a.f13490b[mode.ordinal()] != 1) {
            if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableStart)) {
                drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableStart);
            } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableTop)) {
                d.a.o0.b1.l.a.c.a.a("ptrDrawableTop", "ptrDrawableStart");
                drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableTop);
            }
        } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableEnd)) {
            drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableEnd);
        } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableBottom)) {
            d.a.o0.b1.l.a.c.a.a("ptrDrawableBottom", "ptrDrawableEnd");
            drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableBottom);
        }
        setLoadingDrawable(drawable2 == null ? SkinManager.getDrawable(getDefaultDrawableResId()) : drawable2);
        j();
    }

    private void setSubHeaderText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, charSequence) == null) || this.j == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.j.setVisibility(8);
            return;
        }
        this.j.setText(charSequence);
        if (8 == this.j.getVisibility()) {
            this.j.setVisibility(0);
        }
    }

    private void setSubTextAppearance(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, this, i2) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setTextAppearance(getContext(), i2);
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, colorStateList) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    private void setTextAppearance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) {
            TextView textView = this.f13488i;
            if (textView != null) {
                textView.setTextAppearance(getContext(), i2);
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setTextAppearance(getContext(), i2);
            }
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, colorStateList) == null) {
            TextView textView = this.f13488i;
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setTextColor(colorStateList);
            }
        }
    }

    public abstract void a(Drawable drawable);

    public final void b(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.f13487h) {
            return;
        }
        c(f2);
    }

    public abstract void c(float f2);

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f13488i;
            if (textView != null) {
                textView.setText(this.m);
            }
            e();
        }
    }

    public abstract void e();

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TextView textView = this.f13488i;
            if (textView != null) {
                textView.setText(this.n);
            }
            if (this.f13487h) {
                ((AnimationDrawable) this.f13485f.getDrawable()).start();
            } else {
                g();
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
    }

    public abstract void g();

    public final int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (a.f13489a[this.l.ordinal()] != 1) {
                return this.f13484e.getHeight();
            }
            return this.f13484e.getWidth();
        }
        return invokeV.intValue;
    }

    public abstract int getDefaultDrawableResId();

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TextView textView = this.f13488i;
            if (textView != null) {
                textView.setText(this.o);
            }
            i();
        }
    }

    public abstract void i();

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = this.f13488i;
            if (textView != null) {
                textView.setText(this.m);
            }
            this.f13485f.setVisibility(0);
            if (this.f13487h) {
                ((AnimationDrawable) this.f13485f.getDrawable()).stop();
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
    }

    public abstract void k();

    public final void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            getLayoutParams().height = i2;
            requestLayout();
        }
    }

    @Override // d.a.o0.b1.l.a.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, charSequence) == null) {
            setSubHeaderText(charSequence);
        }
    }

    @Override // d.a.o0.b1.l.a.a
    public final void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, drawable) == null) {
            this.f13485f.setImageDrawable(drawable);
            this.f13487h = drawable instanceof AnimationDrawable;
            a(drawable);
        }
    }

    @Override // d.a.o0.b1.l.a.a
    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, charSequence) == null) {
            this.m = charSequence;
        }
    }

    @Override // d.a.o0.b1.l.a.a
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, charSequence) == null) {
            this.n = charSequence;
        }
    }

    @Override // d.a.o0.b1.l.a.a
    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, charSequence) == null) {
            this.o = charSequence;
        }
    }

    public void setTextSize(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (textView = this.f13488i) == null) {
            return;
        }
        textView.setTextSize(0, i2);
    }

    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, typeface) == null) {
            this.f13488i.setTypeface(typeface);
        }
    }

    public final void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            getLayoutParams().width = i2;
            requestLayout();
        }
    }

    public void setTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (textView = this.f13488i) == null) {
            return;
        }
        textView.setTextColor(i2);
    }
}
