package com.baidu.tbadk.widget;

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
import c.a.s0.v3.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class OvalActionButton extends ImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SVG = "svg";
    public static final String WEBP = "webp";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42489e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42490f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42491g;

    /* renamed from: h  reason: collision with root package name */
    public int f42492h;

    /* renamed from: i  reason: collision with root package name */
    public int f42493i;

    /* renamed from: j  reason: collision with root package name */
    public Path f42494j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f42495k;
    public Paint l;
    public float[] m;
    public float[] n;
    public LinearGradient o;
    public int p;
    public int q;
    public int r;
    public PorterDuffXfermode s;
    public PorterDuffXfermode t;
    public Drawable u;
    public Drawable v;
    public int w;
    public int x;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OvalActionButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f42495k.setXfermode(this.s);
            canvas.drawPaint(this.f42495k);
            this.f42495k.setXfermode(this.t);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
            Paint paint = new Paint();
            this.f42495k = paint;
            paint.setAntiAlias(true);
            this.f42495k.setColor(this.r);
            this.f42495k.setStyle(Paint.Style.FILL);
            this.f42495k.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.l = paint2;
            paint2.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.l.setStrokeCap(Paint.Cap.ROUND);
            this.l.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.x = skinType;
            if (skinType == 0) {
                this.p = c.d("#00E1FF");
                this.q = c.d("#00A2FF");
            } else if (skinType == 1) {
                this.p = c.d("#00BBD4");
                this.q = c.d("#0086D4");
            } else if (skinType == 4) {
                this.p = c.d("#2BE6FF");
                this.q = c.d("#2BB1FF");
            }
        }
    }

    public void cloneColor(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ovalActionButton) == null) || ovalActionButton == null) {
            return;
        }
        ovalActionButton.setStartAndEndColor(this.p, this.q);
        ovalActionButton.setColor(this.r);
    }

    public final void d(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) || (drawable = this.v) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || drawable.getAlpha() > 0) {
            canvas.save();
            canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            this.v.setBounds(((getWidth() / 2) - (this.v.getIntrinsicWidth() / 2)) + this.w, ((getHeight() / 2) - (this.v.getIntrinsicHeight() / 2)) + this.w, ((getWidth() / 2) + (this.v.getIntrinsicWidth() / 2)) - this.w, ((getHeight() / 2) + (this.v.getIntrinsicHeight() / 2)) - this.w);
            this.v.draw(canvas);
            canvas.restore();
        }
    }

    public final void e(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) || (drawable = this.u) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || drawable.getAlpha() > 0) {
            canvas.save();
            canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            this.u.setBounds((getWidth() / 2) - (this.u.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.u.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.u.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.u.getIntrinsicHeight() / 2));
            this.u.draw(canvas);
            canvas.restore();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.x == i2) {
            return;
        }
        c();
        this.r = SkinManager.getColor(this.x, R.color.CAM_X0306);
        this.l.setColor(SkinManager.getColor(R.color.CAM_X0101));
        this.f42489e = true;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        char c2;
        int i2;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) || this.f42492h <= 0 || this.f42493i <= 0) {
            return;
        }
        if (getDrawable() != null) {
            if (getLayerType() != 2) {
                setLayerType(2, null);
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.scale(0.7f, 0.7f, this.f42492h / 2, this.f42493i / 2);
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
        canvas.rotate(45.0f, this.f42492h / 2, this.f42493i / 2);
        Path path = this.f42494j;
        if (path != null) {
            path.reset();
            int i3 = this.f42492h;
            float f4 = i3 * 0.15f;
            float f5 = i3 * 0.85f;
            float f6 = (f4 + f5) / 2.0f;
            int i4 = this.f42493i;
            float f7 = 0.15f * i4;
            float f8 = i4 * 0.85f;
            float f9 = (f7 + f8) / 2.0f;
            float f10 = (((f5 - f4) / 2.0f) * 51.0f) / 65.0f;
            float f11 = (((f8 - f7) / 2.0f) * 51.0f) / 65.0f;
            this.f42494j.moveTo(f6, f7);
            float f12 = f6 + f10;
            float f13 = f9 - f11;
            this.f42494j.cubicTo(f12, f7, f5, f13, f5, f9);
            float f14 = f9 + f11;
            this.f42494j.cubicTo(f5, f14, f12, f8, f6, f8);
            float f15 = f6 - f10;
            this.f42494j.cubicTo(f15, f8, f4, f14, f4, f9);
            this.f42494j.cubicTo(f4, f13, f15, f7, f6, f7);
            this.f42494j.close();
            if (this.f42489e) {
                c2 = 0;
                this.o = new LinearGradient(f4, 0.0f, f5, 0.0f, new int[]{this.p, this.q}, (float[]) null, Shader.TileMode.CLAMP);
                this.f42489e = false;
            } else {
                c2 = 0;
            }
            if (this.f42491g) {
                if (this.f42490f) {
                    this.f42495k.setShadowLayer(16.0f, 5.0f, 5.0f, c.a(this.o == null ? this.r : this.q, 0.5f));
                } else {
                    int i5 = this.f42492h;
                    float f16 = i5 * 0.054f;
                    double radians = Math.toRadians(getRotation() - 45.0f);
                    double d2 = i5 * 0.0226f;
                    this.f42495k.setShadowLayer(f16, (float) (Math.cos(radians) * d2), ((float) (d2 * Math.sin(radians))) * (-1.0f), c.a(this.o == null ? this.r : this.q, 0.83f));
                }
            }
            LinearGradient linearGradient = this.o;
            if (linearGradient != null) {
                this.f42495k.setShader(linearGradient);
            } else {
                this.f42495k.setColor(this.r);
            }
            float f17 = this.f42492h * 0.032f;
            if (this.f42490f) {
                f2 = f9;
                f3 = f6;
                canvas.drawCircle(f3, f2, (i2 / 2) - 20, this.f42495k);
            } else {
                f2 = f9;
                f3 = f6;
                canvas.drawPath(this.f42494j, this.f42495k);
            }
            float[] fArr = this.m;
            float f18 = f3 * 3.0f;
            float f19 = (f4 + f18) / 4.0f;
            fArr[c2] = f19;
            float f20 = 3.0f * f2;
            float f21 = (f7 + f20) / 4.0f;
            fArr[1] = f21;
            float f22 = (f5 + f18) / 4.0f;
            fArr[2] = f22;
            float f23 = (f8 + f20) / 4.0f;
            fArr[3] = f23;
            float[] fArr2 = this.n;
            fArr2[c2] = f22;
            fArr2[1] = f21;
            fArr2[2] = f19;
            fArr2[3] = f23;
            e(canvas);
            d(canvas);
            this.l.setStrokeWidth(f17);
            canvas.drawLines(this.m, this.l);
            canvas.drawLines(this.n, this.l);
        }
        if (saveCount2 < 1 || saveCount2 > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount2);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z && this.f42494j == null) {
                this.f42494j = new Path();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f42492h = getMeasuredWidth();
            this.f42493i = getMeasuredHeight();
        }
    }

    public void refreshIcon() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (drawable = this.u) == null) {
            return;
        }
        drawable.setAlpha(255);
        postInvalidate();
    }

    public void setColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setCrossFade(float f2, boolean z) {
        float f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) || this.v == null) {
            return;
        }
        float f4 = 1.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if ((!z && f2 > 0.3d) || (z && f2 > 0.5d)) {
            if (z) {
                f3 = f2 * 2.0f;
            } else {
                f3 = (f2 * 10.0f) / 7.0f;
                f4 = 0.42857143f;
            }
            int i2 = (int) ((f3 - f4) * 255.0f);
            if (z) {
                i2 = 255 - i2;
            }
            this.v.setAlpha(i2);
            int i3 = 255 - i2;
            this.f42495k.setAlpha(i3);
            Drawable drawable = this.u;
            if (drawable != null) {
                drawable.setAlpha(i3);
                this.l.setAlpha(0);
            } else {
                this.l.setAlpha(i3);
            }
        }
        invalidate();
    }

    public void setEndIcon(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, str) == null) {
            if (i2 > 0) {
                if (WEBP.equals(str)) {
                    this.v = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), null);
                } else {
                    this.v = SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
                }
            } else {
                this.v = null;
            }
            this.w = i3;
        }
    }

    public void setHasShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f42491g = z;
        }
    }

    public void setIconFade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 > 0) {
                Drawable drawable = SkinManager.getDrawable(i2);
                this.u = drawable;
                if (drawable != null) {
                    drawable.setAlpha(255);
                }
                this.l.setAlpha(0);
            } else {
                this.u = null;
                this.l.setAlpha(255);
            }
            postInvalidate();
        }
    }

    public void setIsCircle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f42490f = z;
        }
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            super.setRotation(f2);
            invalidate();
        }
    }

    public void setStartAndEndColor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            this.p = c.d(str);
            this.q = c.d(str2);
            this.f42489e = true;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OvalActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OvalActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42489e = true;
        this.f42491g = true;
        this.m = new float[4];
        this.n = new float[4];
        this.r = SkinManager.getColor(R.color.CAM_X0306);
        this.s = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.t = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.x = 3;
        b();
    }

    public void setStartAndEndColor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
            this.p = i2;
            this.q = i3;
            this.f42489e = true;
            invalidate();
        }
    }
}
