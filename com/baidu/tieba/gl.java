package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class gl extends zk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path t;
    public Paint u;
    public a v;
    public boolean w;

    /* loaded from: classes4.dex */
    public interface a {
        Path a(RectF rectF);

        void b(Canvas canvas);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public gl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new Path();
        this.u = null;
        this.w = false;
    }

    @Override // com.baidu.tieba.xk
    public void c(al alVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, alVar, imageView, scaleType) == null) {
            super.c(alVar, imageView, scaleType);
            a aVar = this.v;
            if (aVar != null && (a2 = aVar.a(j())) != null) {
                this.t.set(a2);
                if (this.u == null) {
                    Paint paint = new Paint();
                    this.u = paint;
                    paint.setStyle(Paint.Style.STROKE);
                    this.u.setAntiAlias(true);
                    this.u.setColor(637534208);
                    this.u.setDither(true);
                    this.u.setStrokeWidth(2.0f);
                }
                t();
            }
        }
    }

    @Override // com.baidu.tieba.xk
    public void g(Canvas canvas, al alVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, alVar, imageView) == null) {
            super.g(canvas, alVar, imageView);
            if (this.w) {
                canvas.drawPath(this.t, this.u);
                a aVar = this.v;
                if (aVar != null) {
                    aVar.b(canvas);
                }
            }
        }
    }

    public void v(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.v = aVar;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.w = z;
        }
    }
}
