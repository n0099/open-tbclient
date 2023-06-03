package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.jw9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class OvalImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Path b;
    public Paint c;
    public Paint d;
    public float[] e;
    public float[] f;
    public boolean g;
    public LinearGradient h;
    public int i;
    public int j;
    public int k;
    public PorterDuffXfermode l;
    public PorterDuffXfermode m;
    public Drawable n;
    public int o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1612839462, "Lcom/baidu/tbadk/widget/viewpager/OvalImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1612839462, "Lcom/baidu/tbadk/widget/viewpager/OvalImageView;");
                return;
            }
        }
        p = SkinManager.getColor(R.color.CAM_X0306);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OvalImageView(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OvalImageView(Context context, AttributeSet attributeSet) {
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
    public OvalImageView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = true;
        this.e = new float[4];
        this.f = new float[4];
        this.g = true;
        this.k = p;
        this.l = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.m = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.o = 3;
        b();
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.c.setXfermode(this.l);
            canvas.drawPaint(this.c);
            this.c.setXfermode(this.m);
        }
    }

    public void setColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.k = i;
        }
    }

    public void setIconFade(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i > 0) {
                Drawable drawable = SkinManager.getDrawable(i);
                this.n = drawable;
                if (drawable != null) {
                    drawable.setAlpha(255);
                }
                this.d.setAlpha(0);
            } else {
                this.n = null;
                this.d.setAlpha(255);
            }
            postInvalidate();
        }
    }

    public void setNeedShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    @Override // android.view.View
    public void setRotation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            super.setRotation(f);
            invalidate();
        }
    }

    public void setStringColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.k = jw9.f(str);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
            Paint paint = new Paint();
            this.c = paint;
            paint.setAntiAlias(true);
            this.c.setColor(this.k);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.d = paint2;
            paint2.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.d.setStrokeCap(Paint.Cap.ROUND);
            this.d.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.o = skinType;
            if (skinType == 0) {
                this.i = jw9.f("#2bb8ff");
                this.j = jw9.f("#2b80ff");
            } else if (skinType == 4) {
                this.i = jw9.f("#249BD6");
                this.j = jw9.f("#246CD6");
            }
        }
    }

    public final void d(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            Drawable drawable = this.n;
            if (drawable == null) {
                this.d.setAlpha(255);
                return;
            }
            if (Build.VERSION.SDK_INT >= 19 && drawable.getAlpha() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                canvas.save();
                canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
                int width = (getWidth() / 2) - (this.n.getIntrinsicWidth() / 2);
                int height = (getHeight() / 2) - (this.n.getIntrinsicHeight() / 2);
                int height2 = (getHeight() / 2) + (this.n.getIntrinsicHeight() / 2);
                this.n.setBounds(width, height, (getWidth() / 2) + (this.n.getIntrinsicWidth() / 2), height2);
                this.n.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        char c;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (getDrawable() != null) {
                if (getLayerType() != 2) {
                    setLayerType(2, null);
                }
                int saveCount = canvas.getSaveCount();
                canvas.save();
                canvas.scale(0.7f, 0.7f, canvas.getWidth() / 2, canvas.getHeight() / 2);
                super.onDraw(canvas);
                if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveCount);
                    return;
                }
                return;
            }
            if (getLayerType() != 1) {
                setLayerType(1, null);
            }
            int saveCount2 = canvas.getSaveCount();
            canvas.save();
            a(canvas);
            canvas.rotate(45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            Path path = this.b;
            if (path != null) {
                path.reset();
                float width = canvas.getWidth() * 0.15f;
                float width2 = canvas.getWidth() * 0.85f;
                float f = (width + width2) / 2.0f;
                float height = 0.15f * canvas.getHeight();
                float height2 = canvas.getHeight() * 0.85f;
                float f2 = (height + height2) / 2.0f;
                float f3 = (((width2 - width) / 2.0f) * 51.0f) / 65.0f;
                float f4 = (((height2 - height) / 2.0f) * 51.0f) / 65.0f;
                this.b.moveTo(f, height);
                float f5 = f + f3;
                float f6 = f2 - f4;
                this.b.cubicTo(f5, height, width2, f6, width2, f2);
                float f7 = f2 + f4;
                this.b.cubicTo(width2, f7, f5, height2, f, height2);
                float f8 = f - f3;
                this.b.cubicTo(f8, height2, width, f7, width, f2);
                this.b.cubicTo(width, f6, f8, height, f, height);
                this.b.close();
                if (this.a) {
                    c = 0;
                    this.h = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.i, this.j}, (float[]) null, Shader.TileMode.CLAMP);
                    this.a = false;
                } else {
                    c = 0;
                }
                if (this.g) {
                    float width3 = canvas.getWidth() * 0.054f;
                    double radians = Math.toRadians(getRotation() - 45.0f);
                    Paint paint = this.c;
                    double width4 = canvas.getWidth() * 0.0226f;
                    float cos = (float) (Math.cos(radians) * width4);
                    float sin = ((float) (width4 * Math.sin(radians))) * (-1.0f);
                    if (this.h == null) {
                        i = this.k;
                    } else {
                        i = this.j;
                    }
                    paint.setShadowLayer(width3, cos, sin, jw9.a(i, 0.83f));
                }
                LinearGradient linearGradient = this.h;
                if (linearGradient != null) {
                    this.c.setShader(linearGradient);
                } else {
                    this.c.setColor(this.k);
                }
                canvas.drawPath(this.b, this.c);
                float[] fArr = this.e;
                float f9 = f * 3.0f;
                float f10 = (width + f9) / 4.0f;
                fArr[c] = f10;
                float f11 = f2 * 3.0f;
                float f12 = (height + f11) / 4.0f;
                fArr[1] = f12;
                float f13 = (width2 + f9) / 4.0f;
                fArr[2] = f13;
                float f14 = (height2 + f11) / 4.0f;
                fArr[3] = f14;
                float[] fArr2 = this.f;
                fArr2[c] = f13;
                fArr2[1] = f12;
                fArr2[2] = f10;
                fArr2[3] = f14;
                d(canvas);
                this.d.setStrokeWidth(canvas.getWidth() * 0.032f);
                canvas.drawLines(this.e, this.d);
                canvas.drawLines(this.f, this.d);
            }
            if (saveCount2 >= 1 && saveCount2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveCount2);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z && this.b == null) {
                this.b = new Path();
            }
        }
    }

    public void setCrossFade(float f) {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048583, this, f) != null) || this.n == null) {
            return;
        }
        if (f > 1.0f) {
            f2 = -0.5f;
        } else {
            f2 = 0.5f - f;
        }
        int i = (int) (255.0f * f2 * 2.0f);
        if (f2 > 0.0f) {
            this.n.setAlpha(i);
            this.d.setAlpha(0);
        } else {
            this.d.setAlpha(-i);
            this.n.setAlpha(0);
        }
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            this.i = i;
            this.j = i2;
            this.a = true;
            invalidate();
        }
    }

    public void setStartAndEndColor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.i = jw9.f(str);
            this.j = jw9.f(str2);
            this.a = true;
            invalidate();
        }
    }
}
