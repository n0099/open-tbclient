package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.t46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public float c;
    public int d;
    public int e;
    public String f;
    public int g;
    public int h;
    public int i;
    public final Paint j;
    public final Paint k;
    public final Paint l;
    public final RectF m;
    public final RectF n;
    public Shader o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet) {
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
        this.a = 0;
        this.b = -1;
        this.c = 10.0f;
        this.g = 100;
        this.h = 0;
        this.i = 0;
        this.j = new Paint();
        this.k = new Paint();
        this.l = new Paint();
        this.m = new RectF();
        this.n = new RectF();
        e(context, attributeSet);
    }

    public final void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t46.ad_progress);
            int parseColor = Color.parseColor("#666666");
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070770);
            int parseColor2 = Color.parseColor("#2BBCFF");
            int parseColor3 = Color.parseColor("#2B87FF");
            this.i = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07076f);
            this.d = obtainStyledAttributes.getColor(1, parseColor2);
            this.e = obtainStyledAttributes.getColor(0, parseColor3);
            this.b = obtainStyledAttributes.getColor(7, parseColor);
            this.g = obtainStyledAttributes.getInteger(2, this.g);
            this.a = obtainStyledAttributes.getInteger(3, 0);
            this.f = obtainStyledAttributes.getString(5);
            this.c = obtainStyledAttributes.getDimension(8, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07076e));
            this.h = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
            obtainStyledAttributes.recycle();
            h();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 0;
        this.b = -1;
        this.c = 10.0f;
        this.g = 100;
        this.h = 0;
        this.i = 0;
        this.j = new Paint();
        this.k = new Paint();
        this.l = new Paint();
        this.m = new RectF();
        this.n = new RectF();
        e(context, attributeSet);
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.h = getMeasuredHeight() / 2;
            RectF rectF = this.n;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = getMeasuredWidth();
            this.n.bottom = getMeasuredHeight();
            this.k.setStrokeWidth(this.i);
            this.k.setColor(Color.parseColor("#E5E5E5"));
            RectF rectF2 = this.n;
            int i = this.h;
            canvas.drawRoundRect(rectF2, i, i, this.k);
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || i < 0 || i > this.g || i == this.a) {
            return;
        }
        this.a = i;
        this.f = getResources().getString(R.string.obfuscated_res_0x7f0f00c7) + this.a + "%";
        if (this.a == this.g) {
            this.f = "";
        }
        postInvalidate();
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.h = getMeasuredHeight() / 2;
            float f = this.a / (this.g + 0.0f);
            RectF rectF = this.m;
            int i = this.i;
            rectF.left = i;
            rectF.top = i;
            rectF.bottom = getMeasuredHeight() - this.i;
            this.m.right = getMeasuredWidth() * f;
            RectF rectF2 = this.m;
            float f2 = rectF2.right;
            int i2 = this.h;
            if (f2 < i2 * 2) {
                rectF2.right = i2 * 2;
            }
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.m.right, 0.0f, new int[]{this.d, this.e}, (float[]) null, Shader.TileMode.CLAMP);
            this.o = linearGradient;
            this.j.setShader(linearGradient);
            RectF rectF3 = this.m;
            int i3 = this.h;
            canvas.drawRoundRect(rectF3, i3, i3, this.j);
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
            float f = fontMetrics.descent;
            float measuredWidth = (getMeasuredWidth() - this.l.measureText(this.f)) / 2.0f;
            canvas.drawText(this.f, measuredWidth, (float) (((getHeight() / 2) - f) + ((f - fontMetrics.ascent) / 2.0f) + 0.5d), this.l);
        }
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l.setAntiAlias(true);
            this.l.setTextSize(this.c);
            this.l.setColor(this.b);
            this.j.setAntiAlias(true);
            this.j.setStyle(Paint.Style.FILL);
            this.k.setAntiAlias(true);
            this.k.setStyle(Paint.Style.STROKE);
            setGravity(17);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.a > 0) {
                c(canvas);
            }
            a(canvas);
            if (TextUtils.isEmpty(this.f)) {
                return;
            }
            d(canvas);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || str == null || str.equals(this.f)) {
            return;
        }
        this.f = str;
        this.a = 0;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048586, this, i) != null) || i == this.b) {
            return;
        }
        this.b = i;
        h();
        postInvalidate();
    }

    public void setTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            float f = i;
            if (f == this.c) {
                return;
            }
            this.c = f;
            postInvalidate();
        }
    }

    public void setForeground(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            if (i == this.d && i2 == this.e) {
                return;
            }
            this.d = i;
            this.e = i2;
            h();
            postInvalidate();
        }
    }
}
