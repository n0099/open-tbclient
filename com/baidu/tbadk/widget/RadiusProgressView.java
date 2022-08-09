package com.baidu.tbadk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gj8;
/* loaded from: classes3.dex */
public class RadiusProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final RectF i;
    public final RectF j;
    public final PointF k;
    public final PointF l;
    public final int[] m;
    public final float[] n;
    public LinearGradient o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusProgressView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Paint(1);
        this.b = 90;
        this.c = 50;
        this.d = 100;
        this.e = Color.parseColor("#FFFFFFFF");
        this.f = Color.parseColor("#FFFFFFFF");
        this.g = gj8.a(SkinManager.getColor(R.color.CAM_X0336), 0.4f);
        this.h = SkinManager.getColor(R.color.CAM_X0336);
        this.i = new RectF();
        this.j = new RectF();
        this.k = new PointF();
        this.l = new PointF();
        this.m = new int[]{this.g, this.h};
        this.n = new float[]{0.0f, 1.0f};
        PointF pointF = this.k;
        float f = pointF.x;
        float f2 = pointF.y;
        PointF pointF2 = this.l;
        this.o = new LinearGradient(f, f2, pointF2.x, pointF2.y, this.m, this.n, Shader.TileMode.CLAMP);
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843062, 16843063, 16843176, R.attr.obfuscated_res_0x7f0405a2, R.attr.obfuscated_res_0x7f040638});
        this.b = obtainStyledAttributes.getDimensionPixelSize(2, this.b);
        this.c = obtainStyledAttributes.getInt(1, this.c);
        this.e = obtainStyledAttributes.getColor(4, this.e);
        this.f = obtainStyledAttributes.getColor(3, this.f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            int color = SkinManager.getColor(R.color.CAM_X0201);
            this.e = color;
            this.a.setColor(color);
            canvas.save();
            RectF rectF = this.i;
            int i = this.b;
            canvas.drawRoundRect(rectF, i, i, this.a);
            canvas.restore();
            this.g = gj8.a(SkinManager.getColor(R.color.CAM_X0336), 0.4f);
            this.h = SkinManager.getColor(R.color.CAM_X0336);
            this.f = SkinManager.getColor(R.color.CAM_X0336);
            PointF pointF = this.k;
            float f = pointF.x;
            float f2 = pointF.y;
            PointF pointF2 = this.l;
            this.o = new LinearGradient(f, f2, pointF2.x, pointF2.y, this.m, this.n, Shader.TileMode.CLAMP);
            this.j.right = (getWidth() * this.c) / this.d;
            this.a.setShader(this.o);
            RectF rectF2 = this.j;
            int i2 = this.b;
            canvas.drawRoundRect(rectF2, i2, i2, this.a);
            this.a.setShader(null);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            float f = i3 - i;
            float f2 = i4 - i2;
            RectF rectF = this.i;
            rectF.right = f;
            rectF.bottom = f2;
            RectF rectF2 = this.j;
            rectF2.right = (f * this.c) / this.d;
            rectF2.bottom = f2;
            PointF pointF = this.k;
            pointF.x = rectF2.left;
            pointF.y = rectF2.height() / 2.0f;
            PointF pointF2 = this.l;
            RectF rectF3 = this.j;
            pointF2.x = rectF3.right;
            pointF2.y = rectF3.height() / 2.0f;
        }
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d = i;
            invalidate();
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.c = i;
            invalidate();
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
            invalidate();
        }
    }

    public void setSolidColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.e = i;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Paint(1);
        this.b = 90;
        this.c = 50;
        this.d = 100;
        this.e = Color.parseColor("#FFFFFFFF");
        this.f = Color.parseColor("#FFFFFFFF");
        this.g = gj8.a(SkinManager.getColor(R.color.CAM_X0336), 0.4f);
        this.h = SkinManager.getColor(R.color.CAM_X0336);
        this.i = new RectF();
        this.j = new RectF();
        this.k = new PointF();
        this.l = new PointF();
        this.m = new int[]{this.g, this.h};
        this.n = new float[]{0.0f, 1.0f};
        PointF pointF = this.k;
        float f = pointF.x;
        float f2 = pointF.y;
        PointF pointF2 = this.l;
        this.o = new LinearGradient(f, f2, pointF2.x, pointF2.y, this.m, this.n, Shader.TileMode.CLAMP);
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusProgressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new Paint(1);
        this.b = 90;
        this.c = 50;
        this.d = 100;
        this.e = Color.parseColor("#FFFFFFFF");
        this.f = Color.parseColor("#FFFFFFFF");
        this.g = gj8.a(SkinManager.getColor(R.color.CAM_X0336), 0.4f);
        this.h = SkinManager.getColor(R.color.CAM_X0336);
        this.i = new RectF();
        this.j = new RectF();
        this.k = new PointF();
        this.l = new PointF();
        this.m = new int[]{this.g, this.h};
        this.n = new float[]{0.0f, 1.0f};
        PointF pointF = this.k;
        float f = pointF.x;
        float f2 = pointF.y;
        PointF pointF2 = this.l;
        this.o = new LinearGradient(f, f2, pointF2.x, pointF2.y, this.m, this.n, Shader.TileMode.CLAMP);
        a(context, attributeSet);
    }
}
