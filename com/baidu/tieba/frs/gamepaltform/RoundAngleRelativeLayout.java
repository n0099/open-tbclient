package com.baidu.tieba.frs.gamepaltform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f51256e;

    /* renamed from: f  reason: collision with root package name */
    public float f51257f;

    /* renamed from: g  reason: collision with root package name */
    public float f51258g;

    /* renamed from: h  reason: collision with root package name */
    public float f51259h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f51260i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f51261j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAngleRelativeLayout(Context context) {
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.f51258g <= 0.0f) {
            return;
        }
        int height = getHeight();
        Path path = new Path();
        float f2 = height;
        path.moveTo(0.0f, f2 - this.f51258g);
        path.lineTo(0.0f, f2);
        path.lineTo(this.f51258g, f2);
        float f3 = this.f51258g;
        path.arcTo(new RectF(0.0f, f2 - (f3 * 2.0f), f3 * 2.0f, f2), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f51260i);
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f51259h <= 0.0f) {
            return;
        }
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f2 = width;
        float f3 = height;
        path.moveTo(f2 - this.f51259h, f3);
        path.lineTo(f2, f3);
        path.lineTo(f2, f3 - this.f51259h);
        float f4 = this.f51259h;
        path.arcTo(new RectF(f2 - (f4 * 2.0f), f3 - (f4 * 2.0f), f2, f3), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f51260i);
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || this.f51256e <= 0.0f) {
            return;
        }
        Path path = new Path();
        path.moveTo(0.0f, this.f51256e);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f51256e, 0.0f);
        float f2 = this.f51256e;
        path.arcTo(new RectF(0.0f, 0.0f, f2 * 2.0f, f2 * 2.0f), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f51260i);
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) || this.f51257f <= 0.0f) {
            return;
        }
        int width = getWidth();
        Path path = new Path();
        float f2 = width;
        path.moveTo(f2 - this.f51257f, 0.0f);
        path.lineTo(f2, 0.0f);
        path.lineTo(f2, this.f51257f);
        float f3 = this.f51257f;
        path.arcTo(new RectF(f2 - (f3 * 2.0f), 0.0f, f2, f3 * 2.0f), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f51260i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.f51261j, 31);
            super.dispatchDraw(canvas);
            c(canvas);
            d(canvas);
            a(canvas);
            b(canvas);
            canvas.restore();
        }
    }

    public void setBottomLeftRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.f51258g = f2;
        }
    }

    public void setBottomRightRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.f51259h = f2;
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.f51256e = f2;
            this.f51258g = f2;
            this.f51257f = f2;
            this.f51259h = f2;
            invalidate();
        }
    }

    public void setTopLeftRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.f51256e = f2;
        }
    }

    public void setTopRightRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f51257f = f2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
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
    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
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
        Paint paint = new Paint();
        this.f51260i = paint;
        paint.setColor(-1);
        this.f51260i.setAntiAlias(true);
        this.f51260i.setStyle(Paint.Style.FILL);
        this.f51260i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f51261j = paint2;
        paint2.setXfermode(null);
    }
}
