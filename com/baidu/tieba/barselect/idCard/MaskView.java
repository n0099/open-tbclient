package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MaskView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Paint c;
    public Paint d;
    public Rect e;
    public Drawable f;
    public Path g;

    public void setLineColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.b = Color.argb(100, 0, 0, 0);
        this.c = new Paint(1);
        this.d = new Paint(1);
        this.e = new Rect();
        this.g = new Path();
        setLayerType(1, null);
        this.d.setColor(-1);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(6.0f);
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.b = Color.argb(100, 0, 0, 0);
        this.c = new Paint(1);
        this.d = new Paint(1);
        this.e = new Rect();
        this.g = new Path();
        setLayerType(1, null);
        this.d.setColor(-1);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(6.0f);
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 1;
        this.b = Color.argb(100, 0, 0, 0);
        this.c = new Paint(1);
        this.d = new Paint(1);
        this.e = new Rect();
        this.g = new Path();
        setLayerType(1, null);
        this.d.setColor(-1);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(6.0f);
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }

    public final Path a(float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Boolean.valueOf(z)})) == null) {
            this.g.reset();
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            if (f6 < 0.0f) {
                f6 = 0.0f;
            }
            float f7 = f3 - f;
            float f8 = f4 - f2;
            float f9 = f7 / 2.0f;
            if (f5 > f9) {
                f5 = f9;
            }
            float f10 = f8 / 2.0f;
            if (f6 > f10) {
                f6 = f10;
            }
            float f11 = f7 - (f5 * 2.0f);
            float f12 = f8 - (2.0f * f6);
            this.g.moveTo(f3, f2 + f6);
            float f13 = -f6;
            float f14 = -f5;
            this.g.rQuadTo(0.0f, f13, f14, f13);
            this.g.rLineTo(-f11, 0.0f);
            this.g.rQuadTo(f14, 0.0f, f14, f6);
            this.g.rLineTo(0.0f, f12);
            if (z) {
                this.g.rLineTo(0.0f, f6);
                this.g.rLineTo(f7, 0.0f);
                this.g.rLineTo(0.0f, f13);
            } else {
                this.g.rQuadTo(0.0f, f6, f5, f6);
                this.g.rLineTo(f11, 0.0f);
                this.g.rQuadTo(f5, 0.0f, f5, f13);
            }
            this.g.rLineTo(0.0f, -f12);
            this.g.close();
            return this.g;
        }
        return (Path) invokeCommon.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f = ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080205, null);
        }
    }

    public Rect getFrameRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a == 0) {
                return new Rect(0, 0, getWidth(), getHeight());
            }
            return new Rect(this.e);
        }
        return (Rect) invokeV.objValue;
    }

    public int getMaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public Rect getFrameRectExtend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Rect rect = new Rect(this.e);
            Rect rect2 = this.e;
            int i = (int) ((rect2.right - rect2.left) * 0.02f);
            int i2 = (int) ((rect2.bottom - rect2.top) * 0.02f);
            rect.left -= i;
            rect.right += i;
            rect.top -= i2;
            rect.bottom += i2;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    @Override // android.view.View
    @RequiresApi(api = 21)
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            Rect rect = this.e;
            int width = rect.width();
            int height = rect.height();
            int i = rect.left;
            int i2 = rect.top;
            int i3 = rect.right;
            int i4 = rect.bottom;
            canvas.drawColor(this.b);
            float f = i;
            float f2 = i2;
            a(f, f2, i3, i4, 30.0f, 30.0f, false);
            canvas.drawPath(this.g, this.d);
            canvas.drawPath(this.g, this.c);
            int i5 = this.a;
            if (i5 == 1) {
                float f3 = width;
                float f4 = height;
                this.f.setBounds((int) ((0.5974155f * f3) + f), (int) ((0.17405063f * f4) + f2), (int) (f + (f3 * 0.95725644f)), (int) (f2 + (f4 * 0.7531645f)));
            } else if (i5 == 2) {
                float f5 = width;
                float f6 = height;
                this.f.setBounds((int) ((0.050695825f * f5) + f), (int) ((0.07594936f * f6) + f2), (int) (f + (f5 * 0.24850895f)), (int) (f2 + (f6 * 0.41455695f)));
            }
            Drawable drawable = this.f;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i > 0 && i2 > 0) {
                if (i2 > i) {
                    f = 0.9f;
                } else {
                    f = 0.72f;
                }
                int i5 = (int) (i * f);
                int i6 = (i5 * 400) / PassBiometricUtil.f;
                int i7 = (i - i5) / 2;
                int i8 = (i2 - i6) / 2;
                Rect rect = this.e;
                rect.left = i7;
                rect.top = i8;
                rect.right = i5 + i7;
                rect.bottom = i6 + i8;
            }
        }
    }

    public void setMaskColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = i;
        }
    }

    public void setMaskType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.a = i;
            if (i != 1) {
                if (i == 2) {
                    this.f = ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080204, null);
                }
            } else {
                this.f = ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080205, null);
            }
            invalidate();
        }
    }
}
