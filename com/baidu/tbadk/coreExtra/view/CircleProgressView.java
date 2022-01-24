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
    public Paint f40822e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f40823f;

    /* renamed from: g  reason: collision with root package name */
    public float f40824g;

    /* renamed from: h  reason: collision with root package name */
    public int f40825h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f40826i;

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
        this.f40824g = 5.0f;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f40826i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            Paint paint = new Paint();
            this.f40822e = paint;
            paint.setAntiAlias(true);
            this.f40822e.setDither(true);
            this.f40822e.setStyle(Paint.Style.STROKE);
            this.f40822e.setStrokeCap(Paint.Cap.ROUND);
            this.f40822e.setStrokeWidth(this.f40824g);
            Paint paint2 = new Paint();
            this.f40823f = paint2;
            paint2.setAntiAlias(true);
            this.f40823f.setDither(true);
            this.f40823f.setStyle(Paint.Style.STROKE);
            this.f40823f.setStrokeCap(Paint.Cap.ROUND);
            this.f40823f.setStrokeWidth(this.f40824g);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f40825h < 0) {
            return;
        }
        RectF rectF = this.f40826i;
        float f2 = this.f40824g;
        rectF.left = f2;
        rectF.top = f2;
        rectF.right = getWidth() - this.f40824g;
        this.f40826i.bottom = getHeight() - this.f40824g;
        canvas.drawArc(this.f40826i, 0.0f, 360.0f, false, this.f40823f);
        canvas.drawArc(this.f40826i, -90.0f, (this.f40825h / 100) * 360.0f, false, this.f40822e);
    }

    public void setCircleBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f40823f.setColor(i2);
            postInvalidate();
        }
    }

    public void setCircleForegroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f40822e.setColor(i2);
            postInvalidate();
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f40825h = i2;
            postInvalidate();
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            float f2 = i2;
            this.f40824g = f2;
            this.f40823f.setStrokeWidth(f2);
            this.f40822e.setStrokeWidth(f2);
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
        this.f40824g = 5.0f;
        a();
    }
}
