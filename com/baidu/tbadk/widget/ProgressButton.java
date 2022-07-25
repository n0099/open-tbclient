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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ProgressButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public float d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Paint i;
    public TextPaint j;
    public float k;
    public String l;
    public int m;
    public float n;
    public boolean o;
    public boolean p;

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
        q = UtilHelper.getDimenPixelSize(R.dimen.tbds177);
        r = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.b = SkinManager.getColor(this.c);
            this.e = SkinManager.getColor(this.f);
            this.g = SkinManager.getColor(this.h);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = R.color.CAM_X0112;
            this.f = R.color.CAM_X0110;
            a();
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.i.setColor(this.b);
            this.i.setAlpha((int) (this.o ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.i.setStyle(this.a == 0 ? Paint.Style.STROKE : Paint.Style.FILL_AND_STROKE);
            this.i.setStrokeWidth(this.n);
            float f = this.n;
            canvas.drawRoundRect(f / 2.0f, f / 2.0f, getWidth() - (this.n / 2.0f), getHeight() - (this.n / 2.0f), getHeight(), getHeight(), this.i);
            this.j.setColor(this.e);
            this.j.setAlpha(this.o ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.j.getFontMetrics();
            int height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            String str = this.l;
            if (str != null) {
                canvas.drawText(str, getWidth() >> 1, height, this.j);
            }
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            int width = (int) (getWidth() * (this.m / 100.0f));
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.i.setColor(this.b);
            this.i.setAlpha((int) (this.d * (this.o ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f)));
            this.i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.i);
            this.j.setColor(this.b);
            this.j.setAlpha(this.o ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.j.getFontMetrics();
            int height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            String str = this.l;
            if (str != null) {
                canvas.drawText(str, getWidth() >> 1, height, this.j);
            }
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.i.setColor(this.b);
            this.i.setAlpha((int) (this.o ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.i.setStyle(Paint.Style.FILL_AND_STROKE);
            float f = this.n;
            canvas.drawRoundRect(f / 2.0f, f / 2.0f, getWidth() - (this.n / 2.0f), getHeight() - (this.n / 2.0f), getHeight(), getHeight(), this.i);
            this.j.setColor(this.g);
            this.j.setAlpha(this.o ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setTextAlign(Paint.Align.CENTER);
            String str2 = this.l;
            if (str2 != null) {
                canvas.drawText(str2, getWidth() >> 1, height, this.j);
            }
            canvas.restore();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i = R.color.CAM_X0302;
            this.c = R.color.CAM_X0302;
            if (this.a != 0) {
                i = R.color.CAM_X0101;
            }
            this.f = i;
            a();
        }
    }

    public int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.j.setTextSize(this.k);
            int measureText = ((int) this.j.measureText(str)) + (r * 2);
            if (measureText > q) {
                return measureText;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @SuppressLint({"CustomViewStyleable"})
    public void g(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400ff, R.attr.obfuscated_res_0x7f040100, R.attr.obfuscated_res_0x7f040103, R.attr.obfuscated_res_0x7f040105, R.attr.obfuscated_res_0x7f040106, R.attr.obfuscated_res_0x7f04065c, R.attr.obfuscated_res_0x7f04065d});
            this.k = obtainStyledAttributes.getDimensionPixelSize(4, R.dimen.T_X08);
            this.l = obtainStyledAttributes.getString(3);
            int i = obtainStyledAttributes.getInt(2, 0);
            this.a = i;
            int i2 = R.color.CAM_X0302;
            this.c = R.color.CAM_X0302;
            this.h = R.color.CAM_X0101;
            if (i != 0) {
                i2 = R.color.CAM_X0101;
            }
            this.f = i2;
            this.b = obtainStyledAttributes.getColor(1, SkinManager.getColor(this.c));
            this.e = obtainStyledAttributes.getColor(5, SkinManager.getColor(this.f));
            this.g = obtainStyledAttributes.getColor(6, SkinManager.getColor(this.h));
            this.d = obtainStyledAttributes.getFloat(0, 0.2f);
            obtainStyledAttributes.recycle();
            this.n = pi.f(getContext(), R.dimen.L_X02);
            Paint paint = new Paint(1);
            this.i = paint;
            paint.setColor(this.b);
            this.i.setStrokeWidth(this.n);
            TextPaint textPaint = new TextPaint();
            this.j = textPaint;
            textPaint.setAntiAlias(true);
            this.j.setTextSize(this.k);
        }
    }

    public int getColorStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a();
            postInvalidate();
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i < 0) {
                this.m = -1;
            } else {
                this.m = Math.min(i, 100);
            }
            this.l = String.format(Locale.CHINA, "%d%%", Integer.valueOf(Math.max(this.m, 0)));
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            if (this.m < 0) {
                c(canvas);
            } else {
                d(canvas);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.o = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.o = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setCurProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i < 0) {
                this.m = -1;
            } else {
                this.m = Math.min(i, 100);
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.l = str;
            postInvalidate();
        }
    }

    public void setUseLongText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.p = z;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.m = -1;
        this.n = 0.0f;
        g(context, attributeSet);
    }
}
