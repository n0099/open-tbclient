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
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FunAdButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51850e;

    /* renamed from: f  reason: collision with root package name */
    public int f51851f;

    /* renamed from: g  reason: collision with root package name */
    public int f51852g;

    /* renamed from: h  reason: collision with root package name */
    public int f51853h;

    /* renamed from: i  reason: collision with root package name */
    public final int f51854i;

    /* renamed from: j  reason: collision with root package name */
    public int f51855j;
    public int k;
    public int l;
    public int m;
    public Paint n;
    public TextPaint o;
    public float p;
    public int q;
    public String r;
    public int s;
    public int t;
    public RectF u;
    public Shader v;
    public int w;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAdButton(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.u == null) {
                this.u = new RectF();
            }
            RectF rectF = this.u;
            int i2 = this.w;
            rectF.left = i2;
            rectF.top = i2;
            rectF.right = getMeasuredWidth() - this.w;
            this.u.bottom = getMeasuredHeight() - this.w;
            float f2 = this.k / (this.s + 0.0f);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.q, 0}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP);
            this.v = linearGradient;
            this.n.setShader(linearGradient);
            RectF rectF2 = this.u;
            int i3 = this.t;
            canvas.drawRoundRect(rectF2, i3, i3, this.n);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.w = getResources().getDimensionPixelSize(R.dimen.tbds1);
            this.q = getResources().getColor(R.color.CAM_X0302);
            this.l = getResources().getColor(R.color.CAM_X0101);
            this.m = getResources().getColor(R.color.CAM_X0302);
            this.s = 100;
            this.k = 0;
            this.r = getResources().getString(R.string.ad_interaction_type_download);
            this.p = getResources().getDimension(R.dimen.T_X08);
            this.t = getResources().getDimensionPixelSize(R.dimen.tbds42);
            this.u = new RectF();
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Paint paint = new Paint();
            this.n = paint;
            paint.setAntiAlias(true);
            this.n.setStyle(Paint.Style.FILL);
            this.n.setColor(this.q);
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.o == null) {
                TextPaint textPaint = new TextPaint();
                this.o = textPaint;
                textPaint.setAntiAlias(true);
                this.o.setTextSize(this.p);
            }
            int i2 = this.k > 0 ? this.l : this.m;
            if (i2 != this.o.getColor()) {
                this.o.setColor(i2);
            }
        }
    }

    public final int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            View.MeasureSpec.getMode(i2);
            return View.MeasureSpec.getSize(i2);
        }
        return invokeI.intValue;
    }

    public final int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE ? Math.max((this.f51854i * 2) + ((int) this.o.measureText(this.r)), this.f51855j) : View.MeasureSpec.getSize(i2);
        }
        return invokeI.intValue;
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.s : invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.intValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundResource(this, this.f51853h);
            this.l = SkinManager.getColor(this.f51850e);
            this.m = SkinManager.getColor(this.f51851f);
            this.q = SkinManager.getColor(this.f51852g);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.k > 0) {
                a(canvas);
            }
            if (TextUtils.isEmpty(this.r)) {
                return;
            }
            d();
            Paint.FontMetrics fontMetrics = this.o.getFontMetrics();
            float f2 = fontMetrics.descent;
            canvas.drawText(this.r, (getMeasuredWidth() - this.o.measureText(this.r)) / 2.0f, ((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f), this.o);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(f(i2), e(i3));
        }
    }

    public void setBackgroundSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f51853h = i2;
        }
    }

    public void setButtonTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.m = i2;
            this.l = i2;
            postInvalidate();
        }
    }

    public void setButtonTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.p = l.e(getContext(), i2);
            postInvalidate();
        }
    }

    public void setForeground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.q = i2;
            postInvalidate();
        }
    }

    public void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 > this.s) {
            return;
        }
        this.k = i2;
        this.r = this.k + "%";
        postInvalidate();
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.r = str;
            this.k = 0;
            postInvalidate();
        }
    }

    public void setTextColorInitSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f51851f = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdButton(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51850e = R.color.CAM_X0101;
        this.f51851f = R.color.CAM_X0304;
        this.f51852g = R.color.CAM_X0302;
        this.f51853h = R.drawable.ad_download_progress_button_bg;
        this.f51854i = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.f51855j = getResources().getDimensionPixelSize(R.dimen.tbds198);
        this.k = 0;
        this.l = SkinManager.getColor(this.f51850e);
        this.m = SkinManager.getColor(this.f51851f);
        this.p = 10.0f;
        this.q = SkinManager.getColor(this.f51852g);
        this.s = 100;
        this.t = 0;
        this.w = 0;
        b();
    }

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.r = getContext().getString(i2);
            this.k = 0;
            postInvalidate();
        }
    }

    public void setText(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, str, i2) == null) {
            this.r = str;
            this.k = i2;
            postInvalidate();
        }
    }
}
