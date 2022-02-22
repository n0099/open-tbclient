package com.baidu.tbadk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes12.dex */
public class ProgressButton extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILL_COLOR = 1;
    public static final int STORKE_COLOR = 0;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f41436e;

    /* renamed from: f  reason: collision with root package name */
    public int f41437f;

    /* renamed from: g  reason: collision with root package name */
    public int f41438g;

    /* renamed from: h  reason: collision with root package name */
    public float f41439h;

    /* renamed from: i  reason: collision with root package name */
    public int f41440i;

    /* renamed from: j  reason: collision with root package name */
    public int f41441j;
    public int k;
    public int l;
    public Paint m;
    public TextPaint n;
    public float o;
    public String p;
    public int q;
    public float r;
    public boolean s;
    public boolean t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1819398476, "Lcom/baidu/tbadk/widget/ProgressButton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1819398476, "Lcom/baidu/tbadk/widget/ProgressButton;");
                return;
            }
        }
        u = UtilHelper.getDimenPixelSize(e.tbds177);
        v = UtilHelper.getDimenPixelSize(e.M_W_X006);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f41437f = SkinManager.getColor(this.f41438g);
            this.f41440i = SkinManager.getColor(this.f41441j);
            this.k = SkinManager.getColor(this.l);
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.m.setColor(this.f41437f);
            this.m.setAlpha((int) (this.s ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.m.setStyle(this.f41436e == 0 ? Paint.Style.STROKE : Paint.Style.FILL_AND_STROKE);
            this.m.setStrokeWidth(this.r);
            float f2 = this.r;
            canvas.drawRoundRect(f2 / 2.0f, f2 / 2.0f, getWidth() - (this.r / 2.0f), getHeight() - (this.r / 2.0f), getHeight(), getHeight(), this.m);
            this.n.setColor(this.f41440i);
            this.n.setAlpha(this.s ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.n.setStyle(Paint.Style.FILL);
            this.n.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.n.getFontMetrics();
            int height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            String str = this.p;
            if (str != null) {
                canvas.drawText(str, getWidth() >> 1, height, this.n);
            }
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            int width = (int) (getWidth() * (this.q / 100.0f));
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.m.setColor(this.f41437f);
            this.m.setAlpha((int) (this.f41439h * (this.s ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f)));
            this.m.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.m);
            this.n.setColor(this.f41437f);
            this.n.setAlpha(this.s ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.n.setStyle(Paint.Style.FILL);
            this.n.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.n.getFontMetrics();
            int height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            String str = this.p;
            if (str != null) {
                canvas.drawText(str, getWidth() >> 1, height, this.n);
            }
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.m.setColor(this.f41437f);
            this.m.setAlpha((int) (this.s ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.m.setStyle(Paint.Style.FILL_AND_STROKE);
            float f2 = this.r;
            canvas.drawRoundRect(f2 / 2.0f, f2 / 2.0f, getWidth() - (this.r / 2.0f), getHeight() - (this.r / 2.0f), getHeight(), getHeight(), this.m);
            this.n.setColor(this.k);
            this.n.setAlpha(this.s ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.n.setStyle(Paint.Style.FILL);
            this.n.setTextAlign(Paint.Align.CENTER);
            String str2 = this.p;
            if (str2 != null) {
                canvas.drawText(str2, getWidth() >> 1, height, this.n);
            }
            canvas.restore();
        }
    }

    public void disableText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f41438g = d.CAM_X0112;
            this.f41441j = d.CAM_X0110;
            a();
        }
    }

    public void enableText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = d.CAM_X0302;
            this.f41438g = i2;
            if (this.f41436e != 0) {
                i2 = d.CAM_X0101;
            }
            this.f41441j = i2;
            a();
        }
    }

    public int getBtnWidthSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.n.setTextSize(this.o);
            int measureText = ((int) this.n.measureText(str)) + (v * 2);
            if (measureText > u) {
                return measureText;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public int getColorStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41436e : invokeV.intValue;
    }

    @SuppressLint({"CustomViewStyleable"})
    public void initView(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.TBProgressButton);
            this.o = obtainStyledAttributes.getDimensionPixelSize(l.TBProgressButton_btnTextSize, e.T_X08);
            this.p = obtainStyledAttributes.getString(l.TBProgressButton_btnText);
            int i2 = obtainStyledAttributes.getInt(l.TBProgressButton_btnColorStyle, 0);
            this.f41436e = i2;
            this.f41438g = d.CAM_X0302;
            int i3 = d.CAM_X0101;
            this.l = i3;
            if (i2 == 0) {
                i3 = d.CAM_X0302;
            }
            this.f41441j = i3;
            this.f41437f = obtainStyledAttributes.getColor(l.TBProgressButton_btnBackgroundColor, SkinManager.getColor(this.f41438g));
            this.f41440i = obtainStyledAttributes.getColor(l.TBProgressButton_textColorInit, SkinManager.getColor(this.f41441j));
            this.k = obtainStyledAttributes.getColor(l.TBProgressButton_textColorProgress, SkinManager.getColor(this.l));
            this.f41439h = obtainStyledAttributes.getFloat(l.TBProgressButton_btnBackgroundAlpha, 0.2f);
            obtainStyledAttributes.recycle();
            this.r = n.f(getContext(), e.L_X02);
            Paint paint = new Paint(1);
            this.m = paint;
            paint.setColor(this.f41437f);
            this.m.setStrokeWidth(this.r);
            TextPaint textPaint = new TextPaint();
            this.n = textPaint;
            textPaint.setAntiAlias(true);
            this.n.setTextSize(this.o);
        }
    }

    public boolean isUseLongText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.t : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            if (this.q < 0) {
                b(canvas);
            } else {
                c(canvas);
            }
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a();
            postInvalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.s = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.s = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setCurProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (i2 < 0) {
                this.q = -1;
            } else {
                this.q = Math.min(i2, 100);
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.p = str;
            postInvalidate();
        }
    }

    public void setUseLongText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.t = z;
        }
    }

    public void updateProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 < 0) {
                this.q = -1;
            } else {
                this.q = Math.min(i2, 100);
            }
            this.p = String.format(Locale.CHINA, "%d%%", Integer.valueOf(Math.max(this.q, 0)));
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.q = -1;
        this.r = 0.0f;
        initView(context, attributeSet);
    }
}
