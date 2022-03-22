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
import c.a.o0.e1.m.a.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public abstract class LoadingLayout extends FrameLayout implements c.a.o0.e1.m.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator l;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f30904b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f30905c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30906d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f30907e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f30908f;

    /* renamed from: g  reason: collision with root package name */
    public final PullToRefreshBase.Mode f30909g;

    /* renamed from: h  reason: collision with root package name */
    public final PullToRefreshBase.Orientation f30910h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f30911b;
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
            f30911b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30911b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PullToRefreshBase.Orientation.values().length];
            a = iArr2;
            try {
                iArr2[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
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
        l = new LinearInterpolator();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30909g = mode;
        this.f30910h = orientation;
        if (a.a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0819, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0818, this);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0909bb);
        this.a = frameLayout;
        this.f30907e = (TextView) frameLayout.findViewById(R.id.obfuscated_res_0x7f09197a);
        this.f30905c = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091978);
        this.f30908f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091979);
        this.f30904b = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091975);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        if (a.f30911b[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
            this.i = context.getString(R.string.obfuscated_res_0x7f0f0f00);
            this.j = context.getString(R.string.obfuscated_res_0x7f0f0f01);
            this.k = context.getString(R.string.obfuscated_res_0x7f0f0f02);
        } else {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
            this.i = context.getString(R.string.obfuscated_res_0x7f0f0f00);
            this.j = context.getString(R.string.obfuscated_res_0x7f0f0f01);
            this.k = context.getString(R.string.obfuscated_res_0x7f0f0f02);
        }
        if (typedArray.hasValue(7) && (drawable = typedArray.getDrawable(7)) != null) {
            b.b(this, drawable);
        }
        if (typedArray.hasValue(9)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(9, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(18)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(18, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(10) && (colorStateList2 = typedArray.getColorStateList(10)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(8) && (colorStateList = typedArray.getColorStateList(8)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(2) ? typedArray.getDrawable(2) : null;
        if (a.f30911b[mode.ordinal()] != 1) {
            if (typedArray.hasValue(5)) {
                drawable2 = typedArray.getDrawable(5);
            } else if (typedArray.hasValue(6)) {
                c.a.o0.e1.m.a.c.a.a("ptrDrawableTop", "ptrDrawableStart");
                drawable2 = typedArray.getDrawable(6);
            }
        } else if (typedArray.hasValue(4)) {
            drawable2 = typedArray.getDrawable(4);
        } else if (typedArray.hasValue(3)) {
            c.a.o0.e1.m.a.c.a.a("ptrDrawableBottom", "ptrDrawableEnd");
            drawable2 = typedArray.getDrawable(3);
        }
        setLoadingDrawable(drawable2 == null ? SkinManager.getDrawable(getDefaultDrawableResId()) : drawable2);
        j();
    }

    private void setSubHeaderText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, charSequence) == null) || this.f30908f == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f30908f.setVisibility(8);
            return;
        }
        this.f30908f.setText(charSequence);
        if (8 == this.f30908f.getVisibility()) {
            this.f30908f.setVisibility(0);
        }
    }

    private void setSubTextAppearance(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, this, i) == null) || (textView = this.f30908f) == null) {
            return;
        }
        textView.setTextAppearance(getContext(), i);
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, colorStateList) == null) || (textView = this.f30908f) == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    private void setTextAppearance(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            TextView textView = this.f30907e;
            if (textView != null) {
                textView.setTextAppearance(getContext(), i);
            }
            TextView textView2 = this.f30908f;
            if (textView2 != null) {
                textView2.setTextAppearance(getContext(), i);
            }
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, colorStateList) == null) {
            TextView textView = this.f30907e;
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            TextView textView2 = this.f30908f;
            if (textView2 != null) {
                textView2.setTextColor(colorStateList);
            }
        }
    }

    public abstract void a(Drawable drawable);

    public final void b(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.f30906d) {
            return;
        }
        c(f2);
    }

    public abstract void c(float f2);

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f30907e;
            if (textView != null) {
                textView.setText(this.i);
            }
            e();
        }
    }

    public abstract void e();

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TextView textView = this.f30907e;
            if (textView != null) {
                textView.setText(this.j);
            }
            if (this.f30906d) {
                ((AnimationDrawable) this.f30904b.getDrawable()).start();
            } else {
                g();
            }
            TextView textView2 = this.f30908f;
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
            if (a.a[this.f30910h.ordinal()] != 1) {
                return this.a.getHeight();
            }
            return this.a.getWidth();
        }
        return invokeV.intValue;
    }

    public abstract int getDefaultDrawableResId();

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TextView textView = this.f30907e;
            if (textView != null) {
                textView.setText(this.k);
            }
            i();
        }
    }

    public abstract void i();

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = this.f30907e;
            if (textView != null) {
                textView.setText(this.i);
            }
            this.f30904b.setVisibility(0);
            if (this.f30906d) {
                ((AnimationDrawable) this.f30904b.getDrawable()).stop();
            } else {
                k();
            }
            TextView textView2 = this.f30908f;
            if (textView2 != null) {
                if (TextUtils.isEmpty(textView2.getText())) {
                    this.f30908f.setVisibility(8);
                } else {
                    this.f30908f.setVisibility(0);
                }
            }
        }
    }

    public abstract void k();

    public final void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            getLayoutParams().height = i;
            requestLayout();
        }
    }

    @Override // c.a.o0.e1.m.a.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, charSequence) == null) {
            setSubHeaderText(charSequence);
        }
    }

    @Override // c.a.o0.e1.m.a.a
    public final void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, drawable) == null) {
            this.f30904b.setImageDrawable(drawable);
            this.f30906d = drawable instanceof AnimationDrawable;
            a(drawable);
        }
    }

    @Override // c.a.o0.e1.m.a.a
    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, charSequence) == null) {
            this.i = charSequence;
        }
    }

    @Override // c.a.o0.e1.m.a.a
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, charSequence) == null) {
            this.j = charSequence;
        }
    }

    @Override // c.a.o0.e1.m.a.a
    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, charSequence) == null) {
            this.k = charSequence;
        }
    }

    public void setTextSize(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || (textView = this.f30907e) == null) {
            return;
        }
        textView.setTextSize(0, i);
    }

    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, typeface) == null) {
            this.f30907e.setTypeface(typeface);
        }
    }

    public final void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            getLayoutParams().width = i;
            requestLayout();
        }
    }

    public void setTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (textView = this.f30907e) == null) {
            return;
        }
        textView.setTextColor(i);
    }
}
