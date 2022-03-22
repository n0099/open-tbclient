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
import c.a.p0.a4.c;
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
/* loaded from: classes5.dex */
public class OvalActionButton extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30691b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30692c;

    /* renamed from: d  reason: collision with root package name */
    public int f30693d;

    /* renamed from: e  reason: collision with root package name */
    public int f30694e;

    /* renamed from: f  reason: collision with root package name */
    public Path f30695f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f30696g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f30697h;
    public float[] i;
    public float[] j;
    public LinearGradient k;
    public int l;
    public int m;
    public int n;
    public PorterDuffXfermode o;
    public PorterDuffXfermode p;
    public Drawable q;
    public Drawable r;
    public int s;
    public int t;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OvalActionButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.f30696g.setXfermode(this.o);
            canvas.drawPaint(this.f30696g);
            this.f30696g.setXfermode(this.p);
        }
    }

    public void b(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ovalActionButton) == null) || ovalActionButton == null) {
            return;
        }
        ovalActionButton.setStartAndEndColor(this.l, this.m);
        ovalActionButton.setColor(this.n);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            Paint paint = new Paint();
            this.f30696g = paint;
            paint.setAntiAlias(true);
            this.f30696g.setColor(this.n);
            this.f30696g.setStyle(Paint.Style.FILL);
            this.f30696g.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f30697h = paint2;
            paint2.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f30697h.setStrokeCap(Paint.Cap.ROUND);
            this.f30697h.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.t = skinType;
            if (skinType == 0) {
                this.l = c.e("#00E1FF");
                this.m = c.e("#00A2FF");
            } else if (skinType == 1) {
                this.l = c.e("#00BBD4");
                this.m = c.e("#0086D4");
            } else if (skinType == 4) {
                this.l = c.e("#2BE6FF");
                this.m = c.e("#2BB1FF");
            }
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || this.t == i) {
            return;
        }
        d();
        this.n = SkinManager.getColor(this.t, (int) R.color.CAM_X0306);
        this.f30697h.setColor(SkinManager.getColor(R.color.CAM_X0101));
        this.a = true;
        invalidate();
    }

    public final void f(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) || (drawable = this.r) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || drawable.getAlpha() > 0) {
            canvas.save();
            canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            this.r.setBounds(((getWidth() / 2) - (this.r.getIntrinsicWidth() / 2)) + this.s, ((getHeight() / 2) - (this.r.getIntrinsicHeight() / 2)) + this.s, ((getWidth() / 2) + (this.r.getIntrinsicWidth() / 2)) - this.s, ((getHeight() / 2) + (this.r.getIntrinsicHeight() / 2)) - this.s);
            this.r.draw(canvas);
            canvas.restore();
        }
    }

    public final void g(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) || (drawable = this.q) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || drawable.getAlpha() > 0) {
            canvas.save();
            canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            this.q.setBounds((getWidth() / 2) - (this.q.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.q.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.q.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.q.getIntrinsicHeight() / 2));
            this.q.draw(canvas);
            canvas.restore();
        }
    }

    public void h() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (drawable = this.q) == null) {
            return;
        }
        drawable.setAlpha(255);
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        char c2;
        int i;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) || this.f30693d <= 0 || this.f30694e <= 0) {
            return;
        }
        if (getDrawable() != null) {
            if (getLayerType() != 2) {
                setLayerType(2, null);
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.scale(0.7f, 0.7f, this.f30693d / 2, this.f30694e / 2);
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
        canvas.rotate(45.0f, this.f30693d / 2, this.f30694e / 2);
        Path path = this.f30695f;
        if (path != null) {
            path.reset();
            int i2 = this.f30693d;
            float f4 = i2 * 0.15f;
            float f5 = i2 * 0.85f;
            float f6 = (f4 + f5) / 2.0f;
            int i3 = this.f30694e;
            float f7 = 0.15f * i3;
            float f8 = i3 * 0.85f;
            float f9 = (f7 + f8) / 2.0f;
            float f10 = (((f5 - f4) / 2.0f) * 51.0f) / 65.0f;
            float f11 = (((f8 - f7) / 2.0f) * 51.0f) / 65.0f;
            this.f30695f.moveTo(f6, f7);
            float f12 = f6 + f10;
            float f13 = f9 - f11;
            this.f30695f.cubicTo(f12, f7, f5, f13, f5, f9);
            float f14 = f9 + f11;
            this.f30695f.cubicTo(f5, f14, f12, f8, f6, f8);
            float f15 = f6 - f10;
            this.f30695f.cubicTo(f15, f8, f4, f14, f4, f9);
            this.f30695f.cubicTo(f4, f13, f15, f7, f6, f7);
            this.f30695f.close();
            if (this.a) {
                c2 = 0;
                this.k = new LinearGradient(f4, 0.0f, f5, 0.0f, new int[]{this.l, this.m}, (float[]) null, Shader.TileMode.CLAMP);
                this.a = false;
            } else {
                c2 = 0;
            }
            if (this.f30692c) {
                if (this.f30691b) {
                    this.f30696g.setShadowLayer(16.0f, 5.0f, 5.0f, c.a(this.k == null ? this.n : this.m, 0.5f));
                } else {
                    int i4 = this.f30693d;
                    float f16 = i4 * 0.054f;
                    double radians = Math.toRadians(getRotation() - 45.0f);
                    double d2 = i4 * 0.0226f;
                    this.f30696g.setShadowLayer(f16, (float) (Math.cos(radians) * d2), ((float) (d2 * Math.sin(radians))) * (-1.0f), c.a(this.k == null ? this.n : this.m, 0.83f));
                }
            }
            LinearGradient linearGradient = this.k;
            if (linearGradient != null) {
                this.f30696g.setShader(linearGradient);
            } else {
                this.f30696g.setColor(this.n);
            }
            float f17 = this.f30693d * 0.032f;
            if (this.f30691b) {
                f2 = f9;
                f3 = f6;
                canvas.drawCircle(f3, f2, (i / 2) - 20, this.f30696g);
            } else {
                f2 = f9;
                f3 = f6;
                canvas.drawPath(this.f30695f, this.f30696g);
            }
            float[] fArr = this.i;
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
            float[] fArr2 = this.j;
            fArr2[c2] = f22;
            fArr2[1] = f21;
            fArr2[2] = f19;
            fArr2[3] = f23;
            g(canvas);
            f(canvas);
            this.f30697h.setStrokeWidth(f17);
            canvas.drawLines(this.i, this.f30697h);
            canvas.drawLines(this.j, this.f30697h);
        }
        if (saveCount2 < 1 || saveCount2 > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount2);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z && this.f30695f == null) {
                this.f30695f = new Path();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.f30693d = getMeasuredWidth();
            this.f30694e = getMeasuredHeight();
        }
    }

    public void setColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.n = i;
        }
    }

    public void setCrossFade(float f2, boolean z) {
        float f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) || this.r == null) {
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
            int i = (int) ((f3 - f4) * 255.0f);
            if (z) {
                i = 255 - i;
            }
            this.r.setAlpha(i);
            int i2 = 255 - i;
            this.f30696g.setAlpha(i2);
            Drawable drawable = this.q;
            if (drawable != null) {
                drawable.setAlpha(i2);
                this.f30697h.setAlpha(0);
            } else {
                this.f30697h.setAlpha(i2);
            }
        }
        invalidate();
    }

    public void setEndIcon(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, str) == null) {
            if (i > 0) {
                if ("webp".equals(str)) {
                    this.r = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), null);
                } else {
                    this.r = SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
                }
            } else {
                this.r = null;
            }
            this.s = i2;
        }
    }

    public void setHasShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f30692c = z;
        }
    }

    public void setIconFade(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            if (i > 0) {
                Drawable drawable = SkinManager.getDrawable(i);
                this.q = drawable;
                if (drawable != null) {
                    drawable.setAlpha(255);
                }
                this.f30697h.setAlpha(0);
            } else {
                this.q = null;
                this.f30697h.setAlpha(255);
            }
            postInvalidate();
        }
    }

    public void setIsCircle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f30691b = z;
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
            this.l = c.e(str);
            this.m = c.e(str2);
            this.a = true;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OvalActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = true;
        this.f30692c = true;
        this.i = new float[4];
        this.j = new float[4];
        this.n = SkinManager.getColor(R.color.CAM_X0306);
        this.o = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.p = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.t = 3;
        c();
    }

    public void setStartAndEndColor(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
            this.l = i;
            this.m = i2;
            this.a = true;
            invalidate();
        }
    }
}
