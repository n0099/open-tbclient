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
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BannerDownloadProgressBar extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47537e;

    /* renamed from: f  reason: collision with root package name */
    public int f47538f;

    /* renamed from: g  reason: collision with root package name */
    public float f47539g;

    /* renamed from: h  reason: collision with root package name */
    public int f47540h;

    /* renamed from: i  reason: collision with root package name */
    public int f47541i;
    public String j;
    public int k;
    public int l;
    public int m;
    public final Paint n;
    public final Paint o;
    public final Paint p;
    public final RectF q;
    public final RectF r;
    public Shader s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47537e = 0;
        this.f47538f = -1;
        this.f47539g = 10.0f;
        this.k = 100;
        this.l = 0;
        this.m = 0;
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.q = new RectF();
        this.r = new RectF();
        d(context, attributeSet);
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.l = getMeasuredHeight() / 2;
            RectF rectF = this.r;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = getMeasuredWidth();
            this.r.bottom = getMeasuredHeight();
            this.o.setStrokeWidth(this.m);
            this.o.setColor(Color.parseColor("#E5E5E5"));
            RectF rectF2 = this.r;
            int i2 = this.l;
            canvas.drawRoundRect(rectF2, i2, i2, this.o);
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.l = getMeasuredHeight() / 2;
            float f2 = this.f47537e / (this.k + 0.0f);
            RectF rectF = this.q;
            int i2 = this.m;
            rectF.left = i2;
            rectF.top = i2;
            rectF.bottom = getMeasuredHeight() - this.m;
            this.q.right = getMeasuredWidth() * f2;
            RectF rectF2 = this.q;
            float f3 = rectF2.right;
            int i3 = this.l;
            if (f3 < i3 * 2) {
                rectF2.right = i3 * 2;
            }
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.q.right, 0.0f, new int[]{this.f47540h, this.f47541i}, (float[]) null, Shader.TileMode.CLAMP);
            this.s = linearGradient;
            this.n.setShader(linearGradient);
            RectF rectF3 = this.q;
            int i4 = this.l;
            canvas.drawRoundRect(rectF3, i4, i4, this.n);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetrics fontMetrics = this.p.getFontMetrics();
            float f2 = fontMetrics.descent;
            float measuredWidth = (getMeasuredWidth() - this.p.measureText(this.j)) / 2.0f;
            canvas.drawText(this.j, measuredWidth, (float) (((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f) + 0.5d), this.p);
        }
    }

    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ad_progress);
            int parseColor = Color.parseColor("#666666");
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_button_radian);
            int parseColor2 = Color.parseColor("#2BBCFF");
            int parseColor3 = Color.parseColor("#2B87FF");
            this.m = getResources().getDimensionPixelSize(R.dimen.progress_button_frame);
            this.f47540h = obtainStyledAttributes.getColor(R$styleable.ad_progress_ad_btn_foreground_start, parseColor2);
            this.f47541i = obtainStyledAttributes.getColor(R$styleable.ad_progress_ad_btn_foreground_end, parseColor3);
            this.f47538f = obtainStyledAttributes.getColor(R$styleable.ad_progress_ad_btn_textColor, parseColor);
            this.k = obtainStyledAttributes.getInteger(R$styleable.ad_progress_ad_btn_max, this.k);
            this.f47537e = obtainStyledAttributes.getInteger(R$styleable.ad_progress_ad_btn_progress, 0);
            this.j = obtainStyledAttributes.getString(R$styleable.ad_progress_ad_btn_text);
            this.f47539g = obtainStyledAttributes.getDimension(R$styleable.ad_progress_ad_btn_textSize, (int) getResources().getDimension(R.dimen.progress_button_font_size));
            this.l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ad_progress_ad_btn_radius, dimensionPixelSize);
            obtainStyledAttributes.recycle();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p.setAntiAlias(true);
            this.p.setTextSize(this.f47539g);
            this.p.setColor(this.f47538f);
            this.n.setAntiAlias(true);
            this.n.setStyle(Paint.Style.FILL);
            this.o.setAntiAlias(true);
            this.o.setStyle(Paint.Style.STROKE);
            setGravity(17);
        }
    }

    public int getMaxProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f47537e : invokeV.intValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f47537e > 0) {
                b(canvas);
            }
            a(canvas);
            if (TextUtils.isEmpty(this.j)) {
                return;
            }
            c(canvas);
        }
    }

    public void setForeground(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            if (i2 == this.f47540h && i3 == this.f47541i) {
                return;
            }
            this.f47540h = i2;
            this.f47541i = i3;
            e();
            postInvalidate();
        }
    }

    public void setMaxProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 < 0 || i2 > this.k || i2 == this.f47537e) {
            return;
        }
        this.f47537e = i2;
        this.j = getResources().getString(R.string.ad_button_already_download) + this.f47537e + "%";
        if (this.f47537e == this.k) {
            this.j = "";
        }
        postInvalidate();
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || str == null || str.equals(this.j)) {
            return;
        }
        this.j = str;
        this.f47537e = 0;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 == this.f47538f) {
            return;
        }
        this.f47538f = i2;
        e();
        postInvalidate();
    }

    public void setTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            float f2 = i2;
            if (f2 == this.f47539g) {
                return;
            }
            this.f47539g = f2;
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerDownloadProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47537e = 0;
        this.f47538f = -1;
        this.f47539g = 10.0f;
        this.k = 100;
        this.l = 0;
        this.m = 0;
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.q = new RectF();
        this.r = new RectF();
        d(context, attributeSet);
    }
}
