package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ShadowLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f42579e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f42580f;

    /* renamed from: g  reason: collision with root package name */
    public int f42581g;

    /* renamed from: h  reason: collision with root package name */
    public int f42582h;

    /* renamed from: i  reason: collision with root package name */
    public int f42583i;

    /* renamed from: j  reason: collision with root package name */
    public int f42584j;

    /* renamed from: k  reason: collision with root package name */
    public int f42585k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowLayout(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setWillNotDraw(false);
            setLayerType(1, null);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.f42581g = dimensionPixelSize;
            setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            this.l = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
            this.f42582h = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
            this.f42583i = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
            this.f42584j = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
            this.f42585k = SkinManager.getColor(R.color.plugin_button_shadow_blue);
            Paint paint = new Paint();
            this.f42579e = paint;
            paint.setColor(0);
            this.f42579e.setShadowLayer(this.f42582h, this.f42583i, this.f42584j, this.f42585k);
            this.f42580f = new RectF();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f42579e.setShadowLayer(this.f42582h, this.f42583i, this.f42584j, this.f42585k);
            postInvalidate();
        }
    }

    public void buildShadow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f42581g;
            setPadding(i2, i2, i2, i2);
            b();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            this.f42580f.left = getPaddingLeft();
            this.f42580f.right = getWidth() - getPaddingRight();
            this.f42580f.bottom = getHeight() - getPaddingBottom();
            this.f42580f.top = getPaddingTop();
            RectF rectF = this.f42580f;
            int i2 = this.l;
            canvas.drawRoundRect(rectF, i2, i2, this.f42579e);
        }
    }

    @NonNull
    public ShadowLayout setColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f42585k = i2;
            return this;
        }
        return (ShadowLayout) invokeI.objValue;
    }

    @NonNull
    public ShadowLayout setOffset(@DimenRes int i2, @DimenRes int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            this.f42583i = getResources().getDimensionPixelSize(i2);
            this.f42584j = getResources().getDimensionPixelSize(i3);
            return this;
        }
        return (ShadowLayout) invokeII.objValue;
    }

    @NonNull
    public ShadowLayout setPadding(@DimenRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.f42581g = getResources().getDimensionPixelSize(i2);
            return this;
        }
        return (ShadowLayout) invokeI.objValue;
    }

    @NonNull
    public ShadowLayout setRadius(@DimenRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.l = getResources().getDimensionPixelSize(i2);
            return this;
        }
        return (ShadowLayout) invokeI.objValue;
    }

    public void setShadowColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f42585k = SkinManager.getColor(i2);
            b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }
}
