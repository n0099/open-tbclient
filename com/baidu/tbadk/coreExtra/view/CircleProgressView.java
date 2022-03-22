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
/* loaded from: classes5.dex */
public class CircleProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f30388b;

    /* renamed from: c  reason: collision with root package name */
    public float f30389c;

    /* renamed from: d  reason: collision with root package name */
    public int f30390d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f30391e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context) {
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
        this.f30389c = 5.0f;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30391e = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            Paint paint = new Paint();
            this.a = paint;
            paint.setAntiAlias(true);
            this.a.setDither(true);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeCap(Paint.Cap.ROUND);
            this.a.setStrokeWidth(this.f30389c);
            Paint paint2 = new Paint();
            this.f30388b = paint2;
            paint2.setAntiAlias(true);
            this.f30388b.setDither(true);
            this.f30388b.setStyle(Paint.Style.STROKE);
            this.f30388b.setStrokeCap(Paint.Cap.ROUND);
            this.f30388b.setStrokeWidth(this.f30389c);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f30390d < 0) {
            return;
        }
        RectF rectF = this.f30391e;
        float f2 = this.f30389c;
        rectF.left = f2;
        rectF.top = f2;
        rectF.right = getWidth() - this.f30389c;
        this.f30391e.bottom = getHeight() - this.f30389c;
        canvas.drawArc(this.f30391e, 0.0f, 360.0f, false, this.f30388b);
        canvas.drawArc(this.f30391e, -90.0f, (this.f30390d / 100) * 360.0f, false, this.a);
    }

    public void setCircleBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f30388b.setColor(i);
            postInvalidate();
        }
    }

    public void setCircleForegroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.setColor(i);
            postInvalidate();
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f30390d = i;
            postInvalidate();
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            float f2 = i;
            this.f30389c = f2;
            this.f30388b.setStrokeWidth(f2);
            this.a.setStrokeWidth(f2);
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
        this.f30389c = 5.0f;
        a();
    }
}
