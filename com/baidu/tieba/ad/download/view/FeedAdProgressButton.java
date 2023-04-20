package com.baidu.tieba.ad.download.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ey5;
import com.baidu.tieba.ii;
import com.baidu.tieba.oz5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View implements oz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public Paint h;
    public TextPaint i;
    public float j;
    public int k;
    public String l;
    public int m;
    public int n;
    public RectF o;
    public Shader p;
    public String q;
    public int r;
    public int s;
    public int t;
    public Rect u;
    public Paint v;

    public void setButtonTextNightColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = R.color.CAM_X0901;
        this.b = R.color.CAM_X0304;
        this.c = R.color.CAM_X0302;
        this.d = R.drawable.obfuscated_res_0x7f0800c1;
        this.e = 0;
        this.f = SkinManager.getColor(R.color.CAM_X0901);
        this.g = SkinManager.getColor(this.b);
        this.j = 10.0f;
        this.k = SkinManager.getColor(this.c);
        this.m = 100;
        this.n = 0;
        this.q = getResources().getString(R.string.install_app);
        this.t = 0;
        e(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = R.color.CAM_X0901;
        this.b = R.color.CAM_X0304;
        this.c = R.color.CAM_X0302;
        this.d = R.drawable.obfuscated_res_0x7f0800c1;
        this.e = 0;
        this.f = SkinManager.getColor(R.color.CAM_X0901);
        this.g = SkinManager.getColor(this.b);
        this.j = 10.0f;
        this.k = SkinManager.getColor(this.c);
        this.m = 100;
        this.n = 0;
        this.q = getResources().getString(R.string.install_app);
        this.t = 0;
        e(context, attributeSet);
    }

    @Override // com.baidu.tieba.oz5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this, this.d);
            this.f = SkinManager.getColor(this.a);
            this.g = SkinManager.getColor(this.b);
            this.k = SkinManager.getColor(this.c);
        }
    }

    @Override // com.baidu.tieba.oz5
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, this.d);
            this.f = SkinManager.getColor(this.a);
            this.g = SkinManager.getColor(this.b);
            this.k = SkinManager.getColor(this.c);
            postInvalidate();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Paint paint = new Paint();
            this.h = paint;
            paint.setAntiAlias(true);
            this.h.setStyle(Paint.Style.FILL);
            this.h.setColor(this.k);
            g();
        }
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.o == null) {
                this.o = new RectF();
            }
            RectF rectF = this.o;
            int i = this.t;
            rectF.left = i;
            rectF.top = i;
            rectF.right = getMeasuredWidth() - this.t;
            this.o.bottom = getMeasuredHeight() - this.t;
            float f = this.e / (this.m + 0.0f);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.k, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
            this.p = linearGradient;
            this.h.setShader(linearGradient);
            RectF rectF2 = this.o;
            int i2 = this.n;
            canvas.drawRoundRect(rectF2, i2, i2, this.h);
        }
    }

    public final float d(int i, float f, boolean z) {
        InterceptResult invokeCommon;
        int suggestedMinimumHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z)})) == null) {
            if (View.MeasureSpec.getMode(i) != Integer.MIN_VALUE && i != 0) {
                if (z) {
                    suggestedMinimumHeight = getSuggestedMinimumWidth();
                } else {
                    suggestedMinimumHeight = getSuggestedMinimumHeight();
                }
                return View.getDefaultSize(suggestedMinimumHeight, i);
            }
            return f;
        }
        return invokeCommon.floatValue;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ey5.feed_ad_progress);
            int color = getResources().getColor(R.color.CAM_X0302);
            int color2 = getResources().getColor(R.color.CAM_X0302);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds10);
            this.t = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
            this.r = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            this.s = getResources().getDimensionPixelSize(R.dimen.M_H_X003);
            this.k = obtainStyledAttributes.getInteger(0, color2);
            this.f = obtainStyledAttributes.getColor(5, color);
            this.g = obtainStyledAttributes.getColor(6, color);
            this.m = obtainStyledAttributes.getInteger(1, this.m);
            this.e = obtainStyledAttributes.getInteger(2, 0);
            this.l = obtainStyledAttributes.getString(4);
            this.j = obtainStyledAttributes.getDimension(7, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b3));
            this.n = obtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
            obtainStyledAttributes.recycle();
            this.o = new RectF();
            f();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        float f;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            if (this.u == null) {
                this.u = new Rect();
            }
            if (this.v == null) {
                this.v = new Paint();
            }
            this.v.setAntiAlias(true);
            this.v.setStyle(Paint.Style.FILL);
            this.v.setTextSize(this.j);
            this.v.setTextAlign(Paint.Align.CENTER);
            float f2 = 0.0f;
            if (!TextUtils.isEmpty(this.q)) {
                if (this.q.length() >= 4) {
                    string = this.q;
                } else {
                    string = getResources().getString(R.string.install_app);
                }
                this.v.getTextBounds(string, 0, string.length(), this.u);
                float height = this.u.height() + (this.s * 2);
                f2 = this.u.width() + (this.r * 2);
                f = height;
            } else {
                f = 0.0f;
            }
            setMeasuredDimension((int) d(i, f2, true), (int) d(i2, f, false));
        }
    }

    public final void g() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.i == null) {
                TextPaint textPaint = new TextPaint();
                this.i = textPaint;
                textPaint.setAntiAlias(true);
                this.i.setTextSize(this.j);
            }
            if (this.e > 0) {
                i = this.f;
            } else {
                i = this.g;
            }
            if (i != this.i.getColor()) {
                this.i.setColor(i);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.e > 0) {
                c(canvas);
            }
            if (TextUtils.isEmpty(this.l)) {
                return;
            }
            g();
            Paint.FontMetrics fontMetrics = this.i.getFontMetrics();
            float f = fontMetrics.descent;
            canvas.drawText(this.l, (getMeasuredWidth() - this.i.measureText(this.l)) / 2.0f, ((getHeight() / 2) - f) + ((f - fontMetrics.ascent) / 2.0f), this.i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.d = i;
        }
    }

    public void setButtonText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.l = str;
            postInvalidate();
        }
    }

    @Override // com.baidu.tieba.oz5
    public void setButtonTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.g = i;
            this.f = i;
            postInvalidate();
        }
    }

    @Override // com.baidu.tieba.oz5
    public void setButtonTextSize(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            float g = ii.g(getContext(), i);
            this.j = g;
            TextPaint textPaint = this.i;
            if (textPaint != null) {
                textPaint.setTextSize(g);
            }
            postInvalidate();
        }
    }

    public void setForeground(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.c = i;
            this.k = SkinManager.getColor(i);
            postInvalidate();
        }
    }

    @Override // com.baidu.tieba.oz5
    public void setInitText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.q = str;
        }
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.m = i;
        }
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.b = i;
        }
    }

    public void setTextColorSkin(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.a = i;
        }
    }

    @Override // com.baidu.tieba.oz5
    public void setButtonText(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i) == null) {
            this.l = str;
            this.e = i;
            postInvalidate();
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && i <= this.m && i >= this.e) {
            this.e = i;
            this.l = this.e + "%";
            postInvalidate();
        }
    }
}
