package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hl extends fl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect s;

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
        this.s = new Rect();
    }

    @Override // com.baidu.tieba.fl
    public void a(il ilVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ilVar, imageView) == null) {
            DrawerArgs drawerArgs = this.l;
            if (!drawerArgs.c) {
                return;
            }
            float f = drawerArgs.d / 2.0f;
            if (!drawerArgs.g) {
                this.h.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            RectF rectF = this.g;
            PointF b = b(rectF.left, rectF.top, this.f);
            RectF rectF2 = this.g;
            PointF b2 = b(rectF2.right, rectF2.bottom, this.f);
            this.h.set(Math.max((int) b.x, 0) + f, Math.max((int) b.y, 0) + f, Math.min((int) b2.x, width) - f, Math.min((int) b2.y, height) - f);
        }
    }

    @Override // com.baidu.tieba.fl
    public void f(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, imageView) != null) || !this.l.c) {
            return;
        }
        canvas.drawRect(this.h, this.d);
    }

    @Override // com.baidu.tieba.fl
    public void h(Canvas canvas, il ilVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, canvas, ilVar, imageView) == null) {
            Matrix matrix = this.f;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            if (ilVar.e()) {
                Bitmap bitmap = ilVar.a.getBitmap();
                this.s.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                canvas.drawBitmap(bitmap, this.s, this.g, this.c);
            } else if (ilVar.d()) {
                this.s.set(0, 0, ilVar.b(), ilVar.a());
                ilVar.b.g(canvas, this.s, this.g, this.c);
            }
        }
    }

    @Override // com.baidu.tieba.fl
    public void i(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, canvas, imageView) != null) || this.l.m == 0) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        canvas.translate(scrollX, scrollY);
        this.o.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
        this.e.setColor(this.l.m);
        canvas.drawRect(this.o, this.e);
        canvas.translate(-scrollX, -scrollY);
    }
}
