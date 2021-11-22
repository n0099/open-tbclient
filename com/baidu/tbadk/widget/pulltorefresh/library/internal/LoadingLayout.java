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
import b.a.q0.e1.m.a.d.b;
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
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public abstract class LoadingLayout extends FrameLayout implements b.a.q0.e1.m.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f47212e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47213f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f47214g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f47215h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f47216i;
    public CharSequence j;
    public CharSequence k;
    public final ImageView mHeaderImage;
    public final ProgressBar mHeaderProgress;
    public final PullToRefreshBase.Mode mMode;
    public final PullToRefreshBase.Orientation mScrollDirection;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47217a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f47218b;
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
            f47218b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47218b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PullToRefreshBase.Orientation.values().length];
            f47217a = iArr2;
            try {
                iArr2[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47217a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMode = mode;
        this.mScrollDirection = orientation;
        if (a.f47217a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_inner);
        this.f47212e = frameLayout;
        this.f47214g = (TextView) frameLayout.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.f47212e.findViewById(R.id.pull_to_refresh_progress);
        this.f47215h = (TextView) this.f47212e.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.f47212e.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f47212e.getLayoutParams();
        if (a.f47218b[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
            this.f47216i = context.getString(R.string.pull_to_refresh_pull_label);
            this.j = context.getString(R.string.pull_to_refresh_refreshing_label);
            this.k = context.getString(R.string.pull_to_refresh_release_label);
        } else {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
            this.f47216i = context.getString(R.string.pull_to_refresh_pull_label);
            this.j = context.getString(R.string.pull_to_refresh_refreshing_label);
            this.k = context.getString(R.string.pull_to_refresh_release_label);
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
        if (a.f47218b[mode.ordinal()] != 1) {
            if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableStart)) {
                drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableStart);
            } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableTop)) {
                b.a.q0.e1.m.a.d.a.a("ptrDrawableTop", "ptrDrawableStart");
                drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableTop);
            }
        } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableEnd)) {
            drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableEnd);
        } else if (typedArray.hasValue(R$styleable.PullToRefresh_tb_ptrDrawableBottom)) {
            b.a.q0.e1.m.a.d.a.a("ptrDrawableBottom", "ptrDrawableEnd");
            drawable2 = typedArray.getDrawable(R$styleable.PullToRefresh_tb_ptrDrawableBottom);
        }
        setLoadingDrawable(drawable2 == null ? SkinManager.getDrawable(getDefaultDrawableResId()) : drawable2);
        reset();
    }

    private void setSubHeaderText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, charSequence) == null) || this.f47215h == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f47215h.setVisibility(8);
            return;
        }
        this.f47215h.setText(charSequence);
        if (8 == this.f47215h.getVisibility()) {
            this.f47215h.setVisibility(0);
        }
    }

    private void setSubTextAppearance(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, this, i2) == null) || (textView = this.f47215h) == null) {
            return;
        }
        textView.setTextAppearance(getContext(), i2);
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, colorStateList) == null) || (textView = this.f47215h) == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    private void setTextAppearance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) {
            TextView textView = this.f47214g;
            if (textView != null) {
                textView.setTextAppearance(getContext(), i2);
            }
            TextView textView2 = this.f47215h;
            if (textView2 != null) {
                textView2.setTextAppearance(getContext(), i2);
            }
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, colorStateList) == null) {
            TextView textView = this.f47214g;
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            TextView textView2 = this.f47215h;
            if (textView2 != null) {
                textView2.setTextColor(colorStateList);
            }
        }
    }

    public final int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (a.f47217a[this.mScrollDirection.ordinal()] != 1) {
                return this.f47212e.getHeight();
            }
            return this.f47212e.getWidth();
        }
        return invokeV.intValue;
    }

    public abstract int getDefaultDrawableResId();

    public final void hideAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f47214g.getVisibility() == 0) {
                this.f47214g.setVisibility(4);
            }
            if (this.mHeaderProgress.getVisibility() == 0) {
                this.mHeaderProgress.setVisibility(4);
            }
            if (this.mHeaderImage.getVisibility() == 0) {
                this.mHeaderImage.setVisibility(4);
            }
            if (this.f47215h.getVisibility() == 0) {
                this.f47215h.setVisibility(4);
            }
        }
    }

    public abstract void onLoadingDrawableSet(Drawable drawable);

    public final void onPull(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || this.f47213f) {
            return;
        }
        onPullImpl(f2);
    }

    public abstract void onPullImpl(float f2);

    public final void pullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TextView textView = this.f47214g;
            if (textView != null) {
                textView.setText(this.f47216i);
            }
            pullToRefreshImpl();
        }
    }

    public abstract void pullToRefreshImpl();

    public final void refreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TextView textView = this.f47214g;
            if (textView != null) {
                textView.setText(this.j);
            }
            if (this.f47213f) {
                ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
            } else {
                refreshingImpl();
            }
            TextView textView2 = this.f47215h;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
    }

    public abstract void refreshingImpl();

    public final void releaseToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TextView textView = this.f47214g;
            if (textView != null) {
                textView.setText(this.k);
            }
            releaseToRefreshImpl();
        }
    }

    public abstract void releaseToRefreshImpl();

    public final void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TextView textView = this.f47214g;
            if (textView != null) {
                textView.setText(this.f47216i);
            }
            this.mHeaderImage.setVisibility(0);
            if (this.f47213f) {
                ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
            } else {
                resetImpl();
            }
            TextView textView2 = this.f47215h;
            if (textView2 != null) {
                if (TextUtils.isEmpty(textView2.getText())) {
                    this.f47215h.setVisibility(8);
                } else {
                    this.f47215h.setVisibility(0);
                }
            }
        }
    }

    public abstract void resetImpl();

    public final void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            getLayoutParams().height = i2;
            requestLayout();
        }
    }

    @Override // b.a.q0.e1.m.a.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, charSequence) == null) {
            setSubHeaderText(charSequence);
        }
    }

    @Override // b.a.q0.e1.m.a.a
    public final void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, drawable) == null) {
            this.mHeaderImage.setImageDrawable(drawable);
            this.f47213f = drawable instanceof AnimationDrawable;
            onLoadingDrawableSet(drawable);
        }
    }

    @Override // b.a.q0.e1.m.a.a
    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, charSequence) == null) {
            this.f47216i = charSequence;
        }
    }

    @Override // b.a.q0.e1.m.a.a
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, charSequence) == null) {
            this.j = charSequence;
        }
    }

    @Override // b.a.q0.e1.m.a.a
    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, charSequence) == null) {
            this.k = charSequence;
        }
    }

    public void setTextSize(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (textView = this.f47214g) == null) {
            return;
        }
        textView.setTextSize(0, i2);
    }

    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, typeface) == null) {
            this.f47214g.setTypeface(typeface);
        }
    }

    public final void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            getLayoutParams().width = i2;
            requestLayout();
        }
    }

    public final void showInvisibleViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (4 == this.f47214g.getVisibility()) {
                this.f47214g.setVisibility(0);
            }
            if (4 == this.mHeaderProgress.getVisibility()) {
                this.mHeaderProgress.setVisibility(0);
            }
            if (4 == this.mHeaderImage.getVisibility()) {
                this.mHeaderImage.setVisibility(0);
            }
            if (4 == this.f47215h.getVisibility()) {
                this.f47215h.setVisibility(0);
            }
        }
    }

    public void setTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (textView = this.f47214g) == null) {
            return;
        }
        textView.setTextColor(i2);
    }
}
