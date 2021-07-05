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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.c;
/* loaded from: classes4.dex */
public class OvalImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13570e;

    /* renamed from: f  reason: collision with root package name */
    public Path f13571f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f13572g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f13573h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f13574i;
    public float[] j;
    public boolean k;
    public LinearGradient l;
    public int m;
    public int n;
    public int o;
    public PorterDuffXfermode p;
    public PorterDuffXfermode q;
    public Drawable r;
    public int s;

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
        t = SkinManager.getColor(R.color.CAM_X0306);
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

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f13572g.setXfermode(this.p);
            canvas.drawPaint(this.f13572g);
            this.f13572g.setXfermode(this.q);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
            Paint paint = new Paint();
            this.f13572g = paint;
            paint.setAntiAlias(true);
            this.f13572g.setColor(this.o);
            this.f13572g.setStyle(Paint.Style.FILL);
            this.f13572g.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f13573h = paint2;
            paint2.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f13573h.setStrokeCap(Paint.Cap.ROUND);
            this.f13573h.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.s = skinType;
            if (skinType == 0) {
                this.m = c.c("#2bb8ff");
                this.n = c.c("#2b80ff");
            } else if (skinType == 1 || skinType == 4) {
                this.m = c.c("#249BD6");
                this.n = c.c("#246CD6");
            }
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            Drawable drawable = this.r;
            if (drawable == null) {
                this.f13573h.setAlpha(255);
                return;
            }
            if (Build.VERSION.SDK_INT < 19 || drawable.getAlpha() > 0) {
                canvas.save();
                canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
                this.r.setBounds((getWidth() / 2) - (this.r.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.r.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.r.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.r.getIntrinsicHeight() / 2));
                this.r.draw(canvas);
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
            Path path = this.f13571f;
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
                this.f13571f.moveTo(f2, height);
                float f6 = f2 + f4;
                float f7 = f3 - f5;
                this.f13571f.cubicTo(f6, height, width2, f7, width2, f3);
                float f8 = f3 + f5;
                this.f13571f.cubicTo(width2, f8, f6, height2, f2, height2);
                float f9 = f2 - f4;
                this.f13571f.cubicTo(f9, height2, width, f8, width, f3);
                this.f13571f.cubicTo(width, f7, f9, height, f2, height);
                this.f13571f.close();
                if (this.f13570e) {
                    c2 = 0;
                    this.l = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.m, this.n}, (float[]) null, Shader.TileMode.CLAMP);
                    this.f13570e = false;
                } else {
                    c2 = 0;
                }
                if (this.k) {
                    float width3 = canvas.getWidth() * 0.054f;
                    double radians = Math.toRadians(getRotation() - 45.0f);
                    double width4 = canvas.getWidth() * 0.0226f;
                    this.f13572g.setShadowLayer(width3, (float) (Math.cos(radians) * width4), ((float) (width4 * Math.sin(radians))) * (-1.0f), c.a(this.l == null ? this.o : this.n, 0.83f));
                }
                LinearGradient linearGradient = this.l;
                if (linearGradient != null) {
                    this.f13572g.setShader(linearGradient);
                } else {
                    this.f13572g.setColor(this.o);
                }
                canvas.drawPath(this.f13571f, this.f13572g);
                float[] fArr = this.f13574i;
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
                float[] fArr2 = this.j;
                fArr2[c2] = f14;
                fArr2[1] = f13;
                fArr2[2] = f11;
                fArr2[3] = f15;
                d(canvas);
                this.f13573h.setStrokeWidth(canvas.getWidth() * 0.032f);
                canvas.drawLines(this.f13574i, this.f13573h);
                canvas.drawLines(this.j, this.f13573h);
            }
            if (saveCount2 < 1 || saveCount2 > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(saveCount2);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z && this.f13571f == null) {
                this.f13571f = new Path();
            }
        }
    }

    public void setColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setCrossFade(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048583, this, f2) == null) || this.r == null) {
            return;
        }
        float f3 = f2 > 1.0f ? -0.5f : 0.5f - f2;
        int i2 = (int) (255.0f * f3 * 2.0f);
        if (f3 > 0.0f) {
            this.r.setAlpha(i2);
            this.f13573h.setAlpha(0);
        } else {
            this.f13573h.setAlpha(-i2);
            this.r.setAlpha(0);
        }
        invalidate();
    }

    public void setIconFade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 > 0) {
                Drawable drawable = SkinManager.getDrawable(i2);
                this.r = drawable;
                if (drawable != null) {
                    drawable.setAlpha(255);
                }
                this.f13573h.setAlpha(0);
            } else {
                this.r = null;
                this.f13573h.setAlpha(255);
            }
            postInvalidate();
        }
    }

    public void setNeedShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
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
            this.m = c.c(str);
            this.n = c.c(str2);
            this.f13570e = true;
            invalidate();
        }
    }

    public void setStringColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.o = c.c(str);
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
    public OvalImageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f13570e = true;
        this.f13574i = new float[4];
        this.j = new float[4];
        this.k = true;
        this.o = t;
        this.p = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.q = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.s = 3;
        b();
    }

    public void setStartAndEndColor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            this.m = i2;
            this.n = i3;
            this.f13570e = true;
            invalidate();
        }
    }
}
