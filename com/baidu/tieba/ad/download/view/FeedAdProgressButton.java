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
import c.a.e.e.p.l;
import c.a.r0.q.e.k.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes7.dex */
public class FeedAdProgressButton extends View implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49302e;

    /* renamed from: f  reason: collision with root package name */
    public int f49303f;

    /* renamed from: g  reason: collision with root package name */
    public int f49304g;

    /* renamed from: h  reason: collision with root package name */
    public int f49305h;

    /* renamed from: i  reason: collision with root package name */
    public int f49306i;

    /* renamed from: j  reason: collision with root package name */
    public int f49307j;
    public int k;
    public Paint l;
    public TextPaint m;
    public float n;
    public int o;
    public String p;
    public int q;
    public int r;
    public RectF s;
    public Shader t;
    public String u;
    public int v;
    public int w;
    public int x;
    public Rect y;
    public Paint z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
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
        int i4 = R.color.CAM_X0901;
        this.f49302e = i4;
        this.f49303f = R.color.CAM_X0304;
        this.f49304g = R.color.CAM_X0302;
        this.f49305h = R.drawable.ad_download_progress_button_bg;
        this.f49306i = 0;
        this.f49307j = SkinManager.getColor(i4);
        this.k = SkinManager.getColor(this.f49303f);
        this.n = 10.0f;
        this.o = SkinManager.getColor(this.f49304g);
        this.q = 100;
        this.r = 0;
        this.u = getResources().getString(R.string.install_app);
        this.x = 0;
        c(context, attributeSet);
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.s == null) {
                this.s = new RectF();
            }
            RectF rectF = this.s;
            int i2 = this.x;
            rectF.left = i2;
            rectF.top = i2;
            rectF.right = getMeasuredWidth() - this.x;
            this.s.bottom = getMeasuredHeight() - this.x;
            float f2 = this.f49306i / (this.q + 0.0f);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.o, 0}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP);
            this.t = linearGradient;
            this.l.setShader(linearGradient);
            RectF rectF2 = this.s;
            int i3 = this.r;
            canvas.drawRoundRect(rectF2, i3, i3, this.l);
        }
    }

    public final float b(int i2, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE || i2 == 0) {
                return f2;
            }
            return View.getDefaultSize(z ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight(), i2);
        }
        return invokeCommon.floatValue;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.feed_ad_progress);
            int color = getResources().getColor(R.color.CAM_X0302);
            int color2 = getResources().getColor(R.color.CAM_X0302);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds10);
            this.x = getResources().getDimensionPixelSize(R.dimen.ds1);
            this.v = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            this.w = getResources().getDimensionPixelSize(R.dimen.M_H_X003);
            this.o = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_foreground, color2);
            this.f49307j = obtainStyledAttributes.getColor(R$styleable.feed_ad_progress_btn_textColor, color);
            this.k = obtainStyledAttributes.getColor(R$styleable.feed_ad_progress_btn_textColorInit, color);
            this.q = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_max, this.q);
            this.f49306i = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_progress, 0);
            this.p = obtainStyledAttributes.getString(R$styleable.feed_ad_progress_btn_text);
            this.n = obtainStyledAttributes.getDimension(R$styleable.feed_ad_progress_btn_textSize, (int) getResources().getDimension(R.dimen.fontsize24));
            this.r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.feed_ad_progress_btn_radius, dimensionPixelSize);
            obtainStyledAttributes.recycle();
            this.s = new RectF();
            d();
        }
    }

    @Override // c.a.r0.q.e.k.a
    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundResource(this, this.f49305h);
            this.f49307j = SkinManager.getColor(this.f49302e);
            this.k = SkinManager.getColor(this.f49303f);
            this.o = SkinManager.getColor(this.f49304g);
            postInvalidate();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Paint paint = new Paint();
            this.l = paint;
            paint.setAntiAlias(true);
            this.l.setStyle(Paint.Style.FILL);
            this.l.setColor(this.o);
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.m == null) {
                TextPaint textPaint = new TextPaint();
                this.m = textPaint;
                textPaint.setAntiAlias(true);
                this.m.setTextSize(this.n);
            }
            int i2 = this.f49306i > 0 ? this.f49307j : this.k;
            if (i2 != this.m.getColor()) {
                this.m.setColor(i2);
            }
        }
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f49306i : invokeV.intValue;
    }

    @Override // c.a.r0.q.e.k.a
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundResource(this, this.f49305h);
            this.f49307j = SkinManager.getColor(this.f49302e);
            this.k = SkinManager.getColor(this.f49303f);
            this.o = SkinManager.getColor(this.f49304g);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f49306i > 0) {
                a(canvas);
            }
            if (TextUtils.isEmpty(this.p)) {
                return;
            }
            e();
            Paint.FontMetrics fontMetrics = this.m.getFontMetrics();
            float f2 = fontMetrics.descent;
            canvas.drawText(this.p, (getMeasuredWidth() - this.m.measureText(this.p)) / 2.0f, ((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f), this.m);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            if (this.y == null) {
                this.y = new Rect();
            }
            if (this.z == null) {
                this.z = new Paint();
            }
            this.z.setAntiAlias(true);
            this.z.setStyle(Paint.Style.FILL);
            this.z.setTextSize(this.n);
            this.z.setTextAlign(Paint.Align.CENTER);
            float f3 = 0.0f;
            if (TextUtils.isEmpty(this.u)) {
                f2 = 0.0f;
            } else {
                String string = this.u.length() >= 4 ? this.u : getResources().getString(R.string.install_app);
                this.z.getTextBounds(string, 0, string.length(), this.y);
                float height = this.y.height() + (this.w * 2);
                f3 = this.y.width() + (this.v * 2);
                f2 = height;
            }
            setMeasuredDimension((int) b(i2, f3, true), (int) b(i3, f2, false));
        }
    }

    public void setBackgroundSkin(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f49305h = i2;
        }
    }

    @Override // c.a.r0.q.e.k.a
    public void setButtonText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.p = str;
            postInvalidate();
        }
    }

    @Override // c.a.r0.q.e.k.a
    public void setButtonTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.k = i2;
            this.f49307j = i2;
            postInvalidate();
        }
    }

    @Override // c.a.r0.q.e.k.a
    public void setButtonTextNightColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
        }
    }

    @Override // c.a.r0.q.e.k.a
    public void setButtonTextSize(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            float g2 = l.g(getContext(), i2);
            this.n = g2;
            TextPaint textPaint = this.m;
            if (textPaint != null) {
                textPaint.setTextSize(g2);
            }
            postInvalidate();
        }
    }

    public void setForeground(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f49304g = i2;
            this.o = SkinManager.getColor(i2);
            postInvalidate();
        }
    }

    @Override // c.a.r0.q.e.k.a
    public void setInitText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.u = str;
        }
    }

    public void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.q = i2;
        }
    }

    @Override // c.a.r0.q.e.k.a
    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || i2 > this.q || i2 < this.f49306i) {
            return;
        }
        this.f49306i = i2;
        this.p = this.f49306i + "%";
        postInvalidate();
    }

    public void setStrokeWidth(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.x = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setTextColorInitSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f49303f = i2;
        }
    }

    public void setTextColorSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f49302e = i2;
        }
    }

    @Override // c.a.r0.q.e.k.a
    public void setButtonText(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
            this.p = str;
            this.f49306i = i2;
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i2) {
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
        int i5 = R.color.CAM_X0901;
        this.f49302e = i5;
        this.f49303f = R.color.CAM_X0304;
        this.f49304g = R.color.CAM_X0302;
        this.f49305h = R.drawable.ad_download_progress_button_bg;
        this.f49306i = 0;
        this.f49307j = SkinManager.getColor(i5);
        this.k = SkinManager.getColor(this.f49303f);
        this.n = 10.0f;
        this.o = SkinManager.getColor(this.f49304g);
        this.q = 100;
        this.r = 0;
        this.u = getResources().getString(R.string.install_app);
        this.x = 0;
        c(context, attributeSet);
    }
}
