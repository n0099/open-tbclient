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
/* loaded from: classes6.dex */
public abstract class hl extends al {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path t;
    public Paint u;
    public a v;
    public boolean w;

    /* loaded from: classes6.dex */
    public interface a {
        Path a(RectF rectF);

        void b(Canvas canvas);
    }

    public hl() {
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

    @Override // com.baidu.tieba.yk
    public void c(bl blVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, blVar, imageView, scaleType) == null) {
            super.c(blVar, imageView, scaleType);
            a aVar = this.v;
            if (aVar == null || (a2 = aVar.a(j())) == null) {
                return;
            }
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
        }
    }

    @Override // com.baidu.tieba.yk
    public void g(Canvas canvas, bl blVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, blVar, imageView) == null) {
            super.g(canvas, blVar, imageView);
            if (!this.w) {
                return;
            }
            canvas.drawPath(this.t, this.u);
            a aVar = this.v;
            if (aVar != null) {
                aVar.b(canvas);
            }
        }
    }

    public void t(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.v = aVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.w = z;
        }
    }
}
