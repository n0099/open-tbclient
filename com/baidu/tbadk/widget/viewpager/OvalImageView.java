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
import c.a.r0.t3.c;
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
/* loaded from: classes9.dex */
public class OvalImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42432e;

    /* renamed from: f  reason: collision with root package name */
    public Path f42433f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f42434g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f42435h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f42436i;

    /* renamed from: j  reason: collision with root package name */
    public float[] f42437j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f42438k;
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
            this.f42434g.setXfermode(this.p);
            canvas.drawPaint(this.f42434g);
            this.f42434g.setXfermode(this.q);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
            Paint paint = new Paint();
            this.f42434g = paint;
            paint.setAntiAlias(true);
            this.f42434g.setColor(this.o);
            this.f42434g.setStyle(Paint.Style.FILL);
            this.f42434g.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f42435h = paint2;
            paint2.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f42435h.setStrokeCap(Paint.Cap.ROUND);
            this.f42435h.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.s = skinType;
            if (skinType == 0) {
                this.m = c.d("#2bb8ff");
                this.n = c.d("#2b80ff");
            } else if (skinType == 1 || skinType == 4) {
                this.m = c.d("#249BD6");
                this.n = c.d("#246CD6");
            }
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            Drawable drawable = this.r;
            if (drawable == null) {
                this.f42435h.setAlpha(255);
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

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.s == i2) {
            return;
        }
        c();
        this.o = SkinManager.getColor(this.s, R.color.CAM_X0306);
        this.f42435h.setColor(SkinManager.getColor(R.color.CAM_X0101));
        this.f42432e = true;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
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
            Path path = this.f42433f;
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
                this.f42433f.moveTo(f2, height);
                float f6 = f2 + f4;
                float f7 = f3 - f5;
                this.f42433f.cubicTo(f6, height, width2, f7, width2, f3);
                float f8 = f3 + f5;
                this.f42433f.cubicTo(width2, f8, f6, height2, f2, height2);
                float f9 = f2 - f4;
                this.f42433f.cubicTo(f9, height2, width, f8, width, f3);
                this.f42433f.cubicTo(width, f7, f9, height, f2, height);
                this.f42433f.close();
                if (this.f42432e) {
                    c2 = 0;
                    this.l = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.m, this.n}, (float[]) null, Shader.TileMode.CLAMP);
                    this.f42432e = false;
                } else {
                    c2 = 0;
                }
                if (this.f42438k) {
                    float width3 = canvas.getWidth() * 0.054f;
                    double radians = Math.toRadians(getRotation() - 45.0f);
                    double width4 = canvas.getWidth() * 0.0226f;
                    this.f42434g.setShadowLayer(width3, (float) (Math.cos(radians) * width4), ((float) (width4 * Math.sin(radians))) * (-1.0f), c.a(this.l == null ? this.o : this.n, 0.83f));
                }
                LinearGradient linearGradient = this.l;
                if (linearGradient != null) {
                    this.f42434g.setShader(linearGradient);
                } else {
                    this.f42434g.setColor(this.o);
                }
                canvas.drawPath(this.f42433f, this.f42434g);
                float[] fArr = this.f42436i;
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
                float[] fArr2 = this.f42437j;
                fArr2[c2] = f14;
                fArr2[1] = f13;
                fArr2[2] = f11;
                fArr2[3] = f15;
                d(canvas);
                this.f42435h.setStrokeWidth(canvas.getWidth() * 0.032f);
                canvas.drawLines(this.f42436i, this.f42435h);
                canvas.drawLines(this.f42437j, this.f42435h);
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
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z && this.f42433f == null) {
                this.f42433f = new Path();
            }
        }
    }

    public void refreshIcon() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (drawable = this.r) == null) {
            return;
        }
        drawable.setAlpha(255);
        postInvalidate();
    }

    public void setColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setCrossFade(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048585, this, f2) == null) || this.r == null) {
            return;
        }
        float f3 = f2 > 1.0f ? -0.5f : 0.5f - f2;
        int i2 = (int) (255.0f * f3 * 2.0f);
        if (f3 > 0.0f) {
            this.r.setAlpha(i2);
            this.f42435h.setAlpha(0);
        } else {
            this.f42435h.setAlpha(-i2);
            this.r.setAlpha(0);
        }
        invalidate();
    }

    public void setIconFade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 > 0) {
                Drawable drawable = SkinManager.getDrawable(i2);
                this.r = drawable;
                if (drawable != null) {
                    drawable.setAlpha(255);
                }
                this.f42435h.setAlpha(0);
            } else {
                this.r = null;
                this.f42435h.setAlpha(255);
            }
            postInvalidate();
        }
    }

    public void setNeedShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f42438k = z;
        }
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            super.setRotation(f2);
            invalidate();
        }
    }

    public void setStartAndEndColor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.m = c.d(str);
            this.n = c.d(str2);
            this.f42432e = true;
            invalidate();
        }
    }

    public void setStringColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.o = c.d(str);
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
        this.f42432e = true;
        this.f42436i = new float[4];
        this.f42437j = new float[4];
        this.f42438k = true;
        this.o = t;
        this.p = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.q = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.s = 3;
        b();
    }

    public void setStartAndEndColor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.m = i2;
            this.n = i3;
            this.f42432e = true;
            invalidate();
        }
    }
}
