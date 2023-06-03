package com.baidu.tieba.funad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FunAdButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Paint j;
    public TextPaint k;
    public float l;
    public int m;
    public String n;
    public int o;
    public int p;
    public RectF q;
    public Shader r;
    public int s;

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAdButton(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.g > 0) {
                a(canvas);
            }
            if (TextUtils.isEmpty(this.n)) {
                return;
            }
            d();
            Paint.FontMetrics fontMetrics = this.k.getFontMetrics();
            float f = fontMetrics.descent;
            canvas.drawText(this.n, (getMeasuredWidth() - this.k.measureText(this.n)) / 2.0f, ((getHeight() / 2) - f) + ((f - fontMetrics.ascent) / 2.0f), this.k);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAdButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdButton(Context context, AttributeSet attributeSet, int i) {
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
        this.a = R.color.CAM_X0101;
        this.b = R.color.CAM_X0304;
        this.c = R.color.CAM_X0302;
        this.d = R.drawable.obfuscated_res_0x7f0800d9;
        this.e = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.f = getResources().getDimensionPixelSize(R.dimen.tbds198);
        this.g = 0;
        this.h = SkinManager.getColor(this.a);
        this.i = SkinManager.getColor(this.b);
        this.l = 10.0f;
        this.m = SkinManager.getColor(this.c);
        this.o = 100;
        this.p = 0;
        this.s = 0;
        b();
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.q == null) {
                this.q = new RectF();
            }
            RectF rectF = this.q;
            int i = this.s;
            rectF.left = i;
            rectF.top = i;
            rectF.right = getMeasuredWidth() - this.s;
            this.q.bottom = getMeasuredHeight() - this.s;
            float f = this.g / (this.o + 0.0f);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.m, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
            this.r = linearGradient;
            this.j.setShader(linearGradient);
            RectF rectF2 = this.q;
            int i2 = this.p;
            canvas.drawRoundRect(rectF2, i2, i2, this.j);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.s = getResources().getDimensionPixelSize(R.dimen.tbds1);
            this.m = getResources().getColor(R.color.CAM_X0302);
            this.h = getResources().getColor(R.color.CAM_X0101);
            this.i = getResources().getColor(R.color.CAM_X0302);
            this.o = 100;
            this.g = 0;
            this.n = getResources().getString(R.string.obfuscated_res_0x7f0f00d8);
            this.l = getResources().getDimension(R.dimen.T_X08);
            this.p = getResources().getDimensionPixelSize(R.dimen.tbds42);
            this.q = new RectF();
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Paint paint = new Paint();
            this.j = paint;
            paint.setAntiAlias(true);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setColor(this.m);
            d();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundResource(this, this.d);
            this.h = SkinManager.getColor(this.a);
            this.i = SkinManager.getColor(this.b);
            this.m = SkinManager.getColor(this.c);
        }
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final void d() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.k == null) {
                TextPaint textPaint = new TextPaint();
                this.k = textPaint;
                textPaint.setAntiAlias(true);
                this.k.setTextSize(this.l);
            }
            if (this.g > 0) {
                i = this.h;
            } else {
                i = this.i;
            }
            if (i != this.k.getColor()) {
                this.k.setColor(i);
            }
        }
    }

    public final int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            View.MeasureSpec.getMode(i);
            return View.MeasureSpec.getSize(i);
        }
        return invokeI.intValue;
    }

    public final int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == Integer.MIN_VALUE) {
                return Math.max((this.e * 2) + ((int) this.k.measureText(this.n)), this.f);
            }
            return size;
        }
        return invokeI.intValue;
    }

    public void setBackgroundSkin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.d = i;
        }
    }

    public void setButtonTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.i = i;
            this.h = i;
            postInvalidate();
        }
    }

    public void setButtonTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.l = vi.d(getContext(), i);
            postInvalidate();
        }
    }

    public void setForeground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.m = i;
            postInvalidate();
        }
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.o = i;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048593, this, i) != null) || i > this.o) {
            return;
        }
        this.g = i;
        this.n = this.g + "%";
        postInvalidate();
    }

    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.n = getContext().getString(i);
            this.g = 0;
            postInvalidate();
        }
    }

    public void setTextColorInitSkin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.b = i;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
            setMeasuredDimension(f(i), e(i2));
        }
    }

    public void setText(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, str, i) == null) {
            this.n = str;
            this.g = i;
            postInvalidate();
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.n = str;
            this.g = 0;
            postInvalidate();
        }
    }
}
