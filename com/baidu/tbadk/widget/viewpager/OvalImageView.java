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
import c.a.p0.a4.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class OvalImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Path f31035b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f31036c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f31037d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f31038e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f31039f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31040g;

    /* renamed from: h  reason: collision with root package name */
    public LinearGradient f31041h;
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

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f31036c.setXfermode(this.l);
            canvas.drawPaint(this.f31036c);
            this.f31036c.setXfermode(this.m);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
            Paint paint = new Paint();
            this.f31036c = paint;
            paint.setAntiAlias(true);
            this.f31036c.setColor(this.k);
            this.f31036c.setStyle(Paint.Style.FILL);
            this.f31036c.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f31037d = paint2;
            paint2.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f31037d.setStrokeCap(Paint.Cap.ROUND);
            this.f31037d.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.o = skinType;
            if (skinType == 0) {
                this.i = c.e("#2bb8ff");
                this.j = c.e("#2b80ff");
            } else if (skinType == 1 || skinType == 4) {
                this.i = c.e("#249BD6");
                this.j = c.e("#246CD6");
            }
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            Drawable drawable = this.n;
            if (drawable == null) {
                this.f31037d.setAlpha(255);
                return;
            }
            if (Build.VERSION.SDK_INT < 19 || drawable.getAlpha() > 0) {
                canvas.save();
                canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
                this.n.setBounds((getWidth() / 2) - (this.n.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.n.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.n.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.n.getIntrinsicHeight() / 2));
                this.n.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        char c2;
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
                if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
                    return;
                }
                canvas.restoreToCount(saveCount);
                return;
            }
            if (getLayerType() != 1) {
                setLayerType(1, null);
            }
            int saveCount2 = canvas.getSaveCount();
            canvas.save();
            a(canvas);
            canvas.rotate(45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            Path path = this.f31035b;
            if (path != null) {
                path.reset();
                float width = canvas.getWidth() * 0.15f;
                float width2 = canvas.getWidth() * 0.85f;
                float f2 = (width + width2) / 2.0f;
                float height = 0.15f * canvas.getHeight();
                float height2 = canvas.getHeight() * 0.85f;
                float f3 = (height + height2) / 2.0f;
                float f4 = (((width2 - width) / 2.0f) * 51.0f) / 65.0f;
                float f5 = (((height2 - height) / 2.0f) * 51.0f) / 65.0f;
                this.f31035b.moveTo(f2, height);
                float f6 = f2 + f4;
                float f7 = f3 - f5;
                this.f31035b.cubicTo(f6, height, width2, f7, width2, f3);
                float f8 = f3 + f5;
                this.f31035b.cubicTo(width2, f8, f6, height2, f2, height2);
                float f9 = f2 - f4;
                this.f31035b.cubicTo(f9, height2, width, f8, width, f3);
                this.f31035b.cubicTo(width, f7, f9, height, f2, height);
                this.f31035b.close();
                if (this.a) {
                    c2 = 0;
                    this.f31041h = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.i, this.j}, (float[]) null, Shader.TileMode.CLAMP);
                    this.a = false;
                } else {
                    c2 = 0;
                }
                if (this.f31040g) {
                    float width3 = canvas.getWidth() * 0.054f;
                    double radians = Math.toRadians(getRotation() - 45.0f);
                    double width4 = canvas.getWidth() * 0.0226f;
                    this.f31036c.setShadowLayer(width3, (float) (Math.cos(radians) * width4), ((float) (width4 * Math.sin(radians))) * (-1.0f), c.a(this.f31041h == null ? this.k : this.j, 0.83f));
                }
                LinearGradient linearGradient = this.f31041h;
                if (linearGradient != null) {
                    this.f31036c.setShader(linearGradient);
                } else {
                    this.f31036c.setColor(this.k);
                }
                canvas.drawPath(this.f31035b, this.f31036c);
                float[] fArr = this.f31038e;
                float f10 = f2 * 3.0f;
                float f11 = (width + f10) / 4.0f;
                fArr[c2] = f11;
                float f12 = f3 * 3.0f;
                float f13 = (height + f12) / 4.0f;
                fArr[1] = f13;
                float f14 = (width2 + f10) / 4.0f;
                fArr[2] = f14;
                float f15 = (height2 + f12) / 4.0f;
                fArr[3] = f15;
                float[] fArr2 = this.f31039f;
                fArr2[c2] = f14;
                fArr2[1] = f13;
                fArr2[2] = f11;
                fArr2[3] = f15;
                d(canvas);
                this.f31037d.setStrokeWidth(canvas.getWidth() * 0.032f);
                canvas.drawLines(this.f31038e, this.f31037d);
                canvas.drawLines(this.f31039f, this.f31037d);
            }
            if (saveCount2 < 1 || saveCount2 > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(saveCount2);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z && this.f31035b == null) {
                this.f31035b = new Path();
            }
        }
    }

    public void setColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.k = i;
        }
    }

    public void setCrossFade(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048583, this, f2) == null) || this.n == null) {
            return;
        }
        float f3 = f2 > 1.0f ? -0.5f : 0.5f - f2;
        int i = (int) (255.0f * f3 * 2.0f);
        if (f3 > 0.0f) {
            this.n.setAlpha(i);
            this.f31037d.setAlpha(0);
        } else {
            this.f31037d.setAlpha(-i);
            this.n.setAlpha(0);
        }
        invalidate();
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
                this.f31037d.setAlpha(0);
            } else {
                this.n = null;
                this.f31037d.setAlpha(255);
            }
            postInvalidate();
        }
    }

    public void setNeedShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f31040g = z;
        }
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            super.setRotation(f2);
            invalidate();
        }
    }

    public void setStartAndEndColor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.i = c.e(str);
            this.j = c.e(str2);
            this.a = true;
            invalidate();
        }
    }

    public void setStringColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.k = c.e(str);
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
        this.f31038e = new float[4];
        this.f31039f = new float[4];
        this.f31040g = true;
        this.k = p;
        this.l = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.m = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.o = 3;
        b();
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
}
