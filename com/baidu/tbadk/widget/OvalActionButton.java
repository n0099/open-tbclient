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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.vca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class OvalActionButton extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public Path f;
    public Paint g;
    public Paint h;
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
        this.c = true;
        this.i = new float[4];
        this.j = new float[4];
        this.n = SkinManager.getColor(R.color.CAM_X0306);
        this.o = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.p = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.t = 3;
        b();
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.g.setXfermode(this.o);
            canvas.drawPaint(this.g);
            this.g.setXfermode(this.p);
        }
    }

    public void setColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.n = i;
        }
    }

    public void setHasShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.c = z;
        }
    }

    public void setIconFade(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (i > 0) {
                Drawable drawable = SkinManager.getDrawable(i);
                this.q = drawable;
                if (drawable != null) {
                    drawable.setAlpha(255);
                }
                this.h.setAlpha(0);
            } else {
                this.q = null;
                this.h.setAlpha(255);
            }
            postInvalidate();
        }
    }

    public void setIsCircle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.b = z;
        }
    }

    @Override // android.view.View
    public void setRotation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            super.setRotation(f);
            invalidate();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
            Paint paint = new Paint();
            this.g = paint;
            paint.setAntiAlias(true);
            this.g.setColor(this.n);
            this.g.setStyle(Paint.Style.FILL);
            this.g.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.h = paint2;
            paint2.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.h.setStrokeCap(Paint.Cap.ROUND);
            this.h.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.t = skinType;
            if (skinType == 0) {
                this.l = vca.f("#00E1FF");
                this.m = vca.f("#00A2FF");
            } else if (skinType == 4) {
                this.l = vca.f("#2BE6FF");
                this.m = vca.f("#2BB1FF");
            }
        }
    }

    public final void d(Canvas canvas) {
        Drawable drawable;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, canvas) != null) || (drawable = this.r) == null) {
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
            this.r.setBounds(((getWidth() / 2) - (this.r.getIntrinsicWidth() / 2)) + this.s, ((getHeight() / 2) - (this.r.getIntrinsicHeight() / 2)) + this.s, ((getWidth() / 2) + (this.r.getIntrinsicWidth() / 2)) - this.s, ((getHeight() / 2) + (this.r.getIntrinsicHeight() / 2)) - this.s);
            this.r.draw(canvas);
            canvas.restore();
        }
    }

    public final void e(Canvas canvas) {
        Drawable drawable;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, canvas) != null) || (drawable = this.q) == null) {
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
            this.q.setBounds((getWidth() / 2) - (this.q.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.q.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.q.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.q.getIntrinsicHeight() / 2));
            this.q.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        char c;
        int i;
        float f;
        float f2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) && this.d > 0 && this.e > 0) {
            if (getDrawable() != null) {
                if (getLayerType() != 2) {
                    setLayerType(2, null);
                }
                int saveCount = canvas.getSaveCount();
                canvas.save();
                canvas.scale(0.7f, 0.7f, this.d / 2, this.e / 2);
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
            canvas.rotate(45.0f, this.d / 2, this.e / 2);
            Path path = this.f;
            if (path != null) {
                path.reset();
                int i4 = this.d;
                float f3 = i4 * 0.15f;
                float f4 = i4 * 0.85f;
                float f5 = (f3 + f4) / 2.0f;
                int i5 = this.e;
                float f6 = 0.15f * i5;
                float f7 = i5 * 0.85f;
                float f8 = (f6 + f7) / 2.0f;
                float f9 = (((f4 - f3) / 2.0f) * 51.0f) / 65.0f;
                float f10 = (((f7 - f6) / 2.0f) * 51.0f) / 65.0f;
                this.f.moveTo(f5, f6);
                float f11 = f5 + f9;
                float f12 = f8 - f10;
                this.f.cubicTo(f11, f6, f4, f12, f4, f8);
                float f13 = f8 + f10;
                this.f.cubicTo(f4, f13, f11, f7, f5, f7);
                float f14 = f5 - f9;
                this.f.cubicTo(f14, f7, f3, f13, f3, f8);
                this.f.cubicTo(f3, f12, f14, f6, f5, f6);
                this.f.close();
                if (this.a) {
                    c = 0;
                    this.k = new LinearGradient(f3, 0.0f, f4, 0.0f, new int[]{this.l, this.m}, (float[]) null, Shader.TileMode.CLAMP);
                    this.a = false;
                } else {
                    c = 0;
                }
                if (this.c) {
                    if (this.b) {
                        Paint paint = this.g;
                        if (this.k == null) {
                            i3 = this.n;
                        } else {
                            i3 = this.m;
                        }
                        paint.setShadowLayer(16.0f, 5.0f, 5.0f, vca.a(i3, 0.5f));
                    } else {
                        int i6 = this.d;
                        float f15 = i6 * 0.054f;
                        double radians = Math.toRadians(getRotation() - 45.0f);
                        Paint paint2 = this.g;
                        double d = i6 * 0.0226f;
                        float cos = (float) (Math.cos(radians) * d);
                        float sin = ((float) (d * Math.sin(radians))) * (-1.0f);
                        if (this.k == null) {
                            i2 = this.n;
                        } else {
                            i2 = this.m;
                        }
                        paint2.setShadowLayer(f15, cos, sin, vca.a(i2, 0.83f));
                    }
                }
                LinearGradient linearGradient = this.k;
                if (linearGradient != null) {
                    this.g.setShader(linearGradient);
                } else {
                    this.g.setColor(this.n);
                }
                float f16 = this.d * 0.032f;
                if (this.b) {
                    f = f8;
                    f2 = f5;
                    canvas.drawCircle(f2, f, (i / 2) - 20, this.g);
                } else {
                    f = f8;
                    f2 = f5;
                    canvas.drawPath(this.f, this.g);
                }
                float[] fArr = this.i;
                float f17 = f2 * 3.0f;
                float f18 = (f3 + f17) / 4.0f;
                fArr[c] = f18;
                float f19 = 3.0f * f;
                float f20 = (f6 + f19) / 4.0f;
                fArr[1] = f20;
                float f21 = (f4 + f17) / 4.0f;
                fArr[2] = f21;
                float f22 = (f7 + f19) / 4.0f;
                fArr[3] = f22;
                float[] fArr2 = this.j;
                fArr2[c] = f21;
                fArr2[1] = f20;
                fArr2[2] = f18;
                fArr2[3] = f22;
                e(canvas);
                d(canvas);
                this.h.setStrokeWidth(f16);
                canvas.drawLines(this.i, this.h);
                canvas.drawLines(this.j, this.h);
            }
            if (saveCount2 >= 1 && saveCount2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveCount2);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z && this.f == null) {
                this.f = new Path();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.d = getMeasuredWidth();
            this.e = getMeasuredHeight();
        }
    }

    public void setStartAndEndColor(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            this.l = i;
            this.m = i2;
            this.a = true;
            invalidate();
        }
    }

    public void setCrossFade(float f, boolean z) {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z)}) != null) || this.r == null) {
            return;
        }
        float f3 = 1.0f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        if ((!z && f > 0.3d) || (z && f > 0.5d)) {
            if (z) {
                f2 = f * 2.0f;
            } else {
                f2 = (f * 10.0f) / 7.0f;
                f3 = 0.42857143f;
            }
            int i = (int) ((f2 - f3) * 255.0f);
            if (z) {
                i = 255 - i;
            }
            this.r.setAlpha(i);
            int i2 = 255 - i;
            this.g.setAlpha(i2);
            Drawable drawable = this.q;
            if (drawable != null) {
                drawable.setAlpha(i2);
                this.h.setAlpha(0);
            } else {
                this.h.setAlpha(i2);
            }
        }
        invalidate();
    }

    public void setEndIcon(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, str) == null) {
            if (i > 0) {
                if (WebpUtils.TYPE_IMG_WEBP.equals(str)) {
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

    public void setStartAndEndColor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.l = vca.f(str);
            this.m = vca.f(str2);
            this.a = true;
            invalidate();
        }
    }
}
