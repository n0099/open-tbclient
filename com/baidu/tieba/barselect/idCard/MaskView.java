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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MaskView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MASK_TYPE_ID_CARD_BACK = 2;
    public static final int MASK_TYPE_ID_CARD_FRONT = 1;
    public static final int MASK_TYPE_NONE = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49729e;

    /* renamed from: f  reason: collision with root package name */
    public int f49730f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f49731g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f49732h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f49733i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f49734j;
    public Path k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49729e = 1;
        this.f49730f = Color.argb(100, 0, 0, 0);
        this.f49731g = new Paint(1);
        this.f49732h = new Paint(1);
        this.f49733i = new Rect();
        this.k = new Path();
        setLayerType(1, null);
        this.f49732h.setColor(-1);
        this.f49732h.setStyle(Paint.Style.STROKE);
        this.f49732h.setStrokeWidth(6.0f);
        this.f49731g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }

    public final Path a(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Boolean.valueOf(z)})) == null) {
            this.k.reset();
            if (f6 < 0.0f) {
                f6 = 0.0f;
            }
            if (f7 < 0.0f) {
                f7 = 0.0f;
            }
            float f8 = f4 - f2;
            float f9 = f5 - f3;
            float f10 = f8 / 2.0f;
            if (f6 > f10) {
                f6 = f10;
            }
            float f11 = f9 / 2.0f;
            if (f7 > f11) {
                f7 = f11;
            }
            float f12 = f8 - (f6 * 2.0f);
            float f13 = f9 - (2.0f * f7);
            this.k.moveTo(f4, f3 + f7);
            float f14 = -f7;
            float f15 = -f6;
            this.k.rQuadTo(0.0f, f14, f15, f14);
            this.k.rLineTo(-f12, 0.0f);
            this.k.rQuadTo(f15, 0.0f, f15, f7);
            this.k.rLineTo(0.0f, f13);
            if (z) {
                this.k.rLineTo(0.0f, f7);
                this.k.rLineTo(f8, 0.0f);
                this.k.rLineTo(0.0f, f14);
            } else {
                this.k.rQuadTo(0.0f, f7, f6, f7);
                this.k.rLineTo(f12, 0.0f);
                this.k.rQuadTo(f6, 0.0f, f6, f14);
            }
            this.k.rLineTo(0.0f, -f13);
            this.k.close();
            return this.k;
        }
        return (Path) invokeCommon.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49734j = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_front, null);
        }
    }

    public Rect getFrameRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f49729e == 0) {
                return new Rect(0, 0, getWidth(), getHeight());
            }
            return new Rect(this.f49733i);
        }
        return (Rect) invokeV.objValue;
    }

    public Rect getFrameRectExtend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Rect rect = new Rect(this.f49733i);
            Rect rect2 = this.f49733i;
            int i2 = (int) ((rect2.right - rect2.left) * 0.02f);
            int i3 = (int) ((rect2.bottom - rect2.top) * 0.02f);
            rect.left -= i2;
            rect.right += i2;
            rect.top -= i3;
            rect.bottom += i3;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public int getMaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49729e : invokeV.intValue;
    }

    @Override // android.view.View
    @RequiresApi(api = 21)
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            Rect rect = this.f49733i;
            int width = rect.width();
            int height = rect.height();
            int i2 = rect.left;
            int i3 = rect.top;
            int i4 = rect.right;
            int i5 = rect.bottom;
            canvas.drawColor(this.f49730f);
            float f2 = i2;
            float f3 = i3;
            a(f2, f3, i4, i5, 30.0f, 30.0f, false);
            canvas.drawPath(this.k, this.f49732h);
            canvas.drawPath(this.k, this.f49731g);
            int i6 = this.f49729e;
            if (i6 == 1) {
                float f4 = width;
                float f5 = height;
                this.f49734j.setBounds((int) ((0.5974155f * f4) + f2), (int) ((0.17405063f * f5) + f3), (int) (f2 + (f4 * 0.95725644f)), (int) (f3 + (f5 * 0.7531645f)));
            } else if (i6 == 2) {
                float f6 = width;
                float f7 = height;
                this.f49734j.setBounds((int) ((0.050695825f * f6) + f2), (int) ((0.07594936f * f7) + f3), (int) (f2 + (f6 * 0.24850895f)), (int) (f3 + (f7 * 0.41455695f)));
            }
            Drawable drawable = this.f49734j;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            int i6 = (int) (i2 * (i3 > i2 ? 0.9f : 0.72f));
            int i7 = (i6 * 400) / 620;
            int i8 = (i2 - i6) / 2;
            int i9 = (i3 - i7) / 2;
            Rect rect = this.f49733i;
            rect.left = i8;
            rect.top = i9;
            rect.right = i6 + i8;
            rect.bottom = i7 + i9;
        }
    }

    public void setLineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
        }
    }

    public void setMaskColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f49730f = i2;
        }
    }

    public void setMaskType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f49729e = i2;
            if (i2 == 1) {
                this.f49734j = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_front, null);
            } else if (i2 == 2) {
                this.f49734j = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_back, null);
            }
            invalidate();
        }
    }

    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49729e = 1;
        this.f49730f = Color.argb(100, 0, 0, 0);
        this.f49731g = new Paint(1);
        this.f49732h = new Paint(1);
        this.f49733i = new Rect();
        this.k = new Path();
        setLayerType(1, null);
        this.f49732h.setColor(-1);
        this.f49732h.setStyle(Paint.Style.STROKE);
        this.f49732h.setStrokeWidth(6.0f);
        this.f49731g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f49729e = 1;
        this.f49730f = Color.argb(100, 0, 0, 0);
        this.f49731g = new Paint(1);
        this.f49732h = new Paint(1);
        this.f49733i = new Rect();
        this.k = new Path();
        setLayerType(1, null);
        this.f49732h.setColor(-1);
        this.f49732h.setStyle(Paint.Style.STROKE);
        this.f49732h.setStrokeWidth(6.0f);
        this.f49731g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        b();
    }
}
