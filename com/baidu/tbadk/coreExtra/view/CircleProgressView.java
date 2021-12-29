package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class CircleProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f42269e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f42270f;

    /* renamed from: g  reason: collision with root package name */
    public float f42271g;

    /* renamed from: h  reason: collision with root package name */
    public int f42272h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f42273i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context) {
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
        this.f42271g = 5.0f;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f42273i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            Paint paint = new Paint();
            this.f42269e = paint;
            paint.setAntiAlias(true);
            this.f42269e.setDither(true);
            this.f42269e.setStyle(Paint.Style.STROKE);
            this.f42269e.setStrokeCap(Paint.Cap.ROUND);
            this.f42269e.setStrokeWidth(this.f42271g);
            Paint paint2 = new Paint();
            this.f42270f = paint2;
            paint2.setAntiAlias(true);
            this.f42270f.setDither(true);
            this.f42270f.setStyle(Paint.Style.STROKE);
            this.f42270f.setStrokeCap(Paint.Cap.ROUND);
            this.f42270f.setStrokeWidth(this.f42271g);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f42272h < 0) {
            return;
        }
        RectF rectF = this.f42273i;
        float f2 = this.f42271g;
        rectF.left = f2;
        rectF.top = f2;
        rectF.right = getWidth() - this.f42271g;
        this.f42273i.bottom = getHeight() - this.f42271g;
        canvas.drawArc(this.f42273i, 0.0f, 360.0f, false, this.f42270f);
        canvas.drawArc(this.f42273i, -90.0f, (this.f42272h / 100) * 360.0f, false, this.f42269e);
    }

    public void setCircleBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f42270f.setColor(i2);
            postInvalidate();
        }
    }

    public void setCircleForegroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f42269e.setColor(i2);
            postInvalidate();
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f42272h = i2;
            postInvalidate();
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            float f2 = i2;
            this.f42271g = f2;
            this.f42270f.setStrokeWidth(f2);
            this.f42269e.setStrokeWidth(f2);
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet) {
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
        this.f42271g = 5.0f;
        a();
    }
}
