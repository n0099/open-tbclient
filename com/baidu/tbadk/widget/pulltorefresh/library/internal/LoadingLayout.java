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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
import com.baidu.tieba.g06;
import com.baidu.tieba.i06;
import com.baidu.tieba.j06;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public abstract class LoadingLayout extends FrameLayout implements g06 {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator l;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public final ImageView b;
    public final ProgressBar c;
    public boolean d;
    public final TextView e;
    public final TextView f;
    public final PullToRefreshBase.Mode g;
    public final PullToRefreshBase.Orientation h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;

    public abstract void a(Drawable drawable);

    public abstract void c(float f);

    public abstract void e();

    public abstract void g();

    public abstract int getDefaultDrawableResId();

    public abstract void i();

    public abstract void k();

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
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
            b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
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

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(this.i);
            }
            e();
        }
    }

    public final int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (a.a[this.h.ordinal()] != 1) {
                return this.a.getHeight();
            }
            return this.a.getWidth();
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(this.k);
            }
            i();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        int i;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mode, orientation, typedArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = mode;
        this.h = orientation;
        if (a.a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_inner);
        this.a = frameLayout;
        this.e = (TextView) frameLayout.findViewById(R.id.pull_to_refresh_text);
        this.c = (ProgressBar) this.a.findViewById(R.id.pull_to_refresh_progress);
        this.f = (TextView) this.a.findViewById(R.id.pull_to_refresh_sub_text);
        this.b = (ImageView) this.a.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        if (a.b[mode.ordinal()] != 1) {
            if (orientation == PullToRefreshBase.Orientation.VERTICAL) {
                i2 = 80;
            } else {
                i2 = 5;
            }
            layoutParams.gravity = i2;
            this.i = context.getString(R.string.pull_to_refresh_pull_label);
            this.j = context.getString(R.string.pull_to_refresh_refreshing_label);
            this.k = context.getString(R.string.pull_to_refresh_release_label);
        } else {
            if (orientation == PullToRefreshBase.Orientation.VERTICAL) {
                i = 48;
            } else {
                i = 3;
            }
            layoutParams.gravity = i;
            this.i = context.getString(R.string.pull_to_refresh_pull_label);
            this.j = context.getString(R.string.pull_to_refresh_refreshing_label);
            this.k = context.getString(R.string.pull_to_refresh_release_label);
        }
        if (typedArray.hasValue(7) && (drawable = typedArray.getDrawable(7)) != null) {
            j06.b(this, drawable);
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
        if (a.b[mode.ordinal()] != 1) {
            if (typedArray.hasValue(5)) {
                drawable2 = typedArray.getDrawable(5);
            } else if (typedArray.hasValue(6)) {
                i06.a("ptrDrawableTop", "ptrDrawableStart");
                drawable2 = typedArray.getDrawable(6);
            }
        } else if (typedArray.hasValue(4)) {
            drawable2 = typedArray.getDrawable(4);
        } else if (typedArray.hasValue(3)) {
            i06.a("ptrDrawableBottom", "ptrDrawableEnd");
            drawable2 = typedArray.getDrawable(3);
        }
        setLoadingDrawable(drawable2 == null ? SkinManager.getDrawable(getDefaultDrawableResId()) : drawable2);
        j();
    }

    private void setSubHeaderText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, charSequence) == null) && this.f != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f.setVisibility(8);
                return;
            }
            this.f.setText(charSequence);
            if (8 == this.f.getVisibility()) {
                this.f.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65539, this, i) == null) && (textView = this.f) != null) {
            textView.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, colorStateList) == null) && (textView = this.f) != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setTextAppearance(getContext(), i);
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setTextAppearance(getContext(), i);
            }
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, colorStateList) == null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setTextColor(colorStateList);
            }
        }
    }

    public final void b(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) && !this.d) {
            c(f);
        }
    }

    public final void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            getLayoutParams().height = i;
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.g06
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, charSequence) == null) {
            setSubHeaderText(charSequence);
        }
    }

    @Override // com.baidu.tieba.g06
    public final void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, drawable) == null) {
            this.b.setImageDrawable(drawable);
            this.d = drawable instanceof AnimationDrawable;
            a(drawable);
        }
    }

    @Override // com.baidu.tieba.g06
    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, charSequence) == null) {
            this.i = charSequence;
        }
    }

    @Override // com.baidu.tieba.g06
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, charSequence) == null) {
            this.j = charSequence;
        }
    }

    @Override // com.baidu.tieba.g06
    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, charSequence) == null) {
            this.k = charSequence;
        }
    }

    public void setTextSize(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && (textView = this.e) != null) {
            textView.setTextSize(0, i);
        }
    }

    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, typeface) == null) {
            this.e.setTypeface(typeface);
        }
    }

    public final void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            getLayoutParams().width = i;
            requestLayout();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(this.j);
            }
            if (this.d) {
                ((AnimationDrawable) this.b.getDrawable()).start();
            } else {
                g();
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(this.i);
            }
            this.b.setVisibility(0);
            if (this.d) {
                ((AnimationDrawable) this.b.getDrawable()).stop();
            } else {
                k();
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                if (TextUtils.isEmpty(textView2.getText())) {
                    this.f.setVisibility(8);
                } else {
                    this.f.setVisibility(0);
                }
            }
        }
    }

    public void setTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && (textView = this.e) != null) {
            textView.setTextColor(i);
        }
    }
}
