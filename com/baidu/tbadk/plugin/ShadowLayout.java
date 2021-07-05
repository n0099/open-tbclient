package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ShadowLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f13142e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f13143f;

    /* renamed from: g  reason: collision with root package name */
    public int f13144g;

    /* renamed from: h  reason: collision with root package name */
    public int f13145h;

    /* renamed from: i  reason: collision with root package name */
    public int f13146i;
    public int j;
    public int k;
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
            this.f13144g = dimensionPixelSize;
            setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            this.l = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
            this.f13145h = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
            this.f13146i = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
            this.j = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
            this.k = SkinManager.getColor(R.color.plugin_button_shadow_blue);
            Paint paint = new Paint();
            this.f13142e = paint;
            paint.setColor(0);
            this.f13142e.setShadowLayer(this.f13145h, this.f13146i, this.j, this.k);
            this.f13143f = new RectF();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f13142e.setShadowLayer(this.f13145h, this.f13146i, this.j, this.k);
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            this.f13143f.left = getPaddingLeft();
            this.f13143f.right = getWidth() - getPaddingRight();
            this.f13143f.bottom = getHeight() - getPaddingBottom();
            this.f13143f.top = getPaddingTop();
            RectF rectF = this.f13143f;
            int i2 = this.l;
            canvas.drawRoundRect(rectF, i2, i2, this.f13142e);
        }
    }

    public void setShadowColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.k = SkinManager.getColor(i2);
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
