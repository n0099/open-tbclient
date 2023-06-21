package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dl extends gl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Rect A;
    public final Paint x;
    public final Paint y;
    public final Rect z;

    public dl() {
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
        this.x = new Paint();
        this.y = new Paint();
        this.z = new Rect(0, 0, 0, 0);
        this.A = new Rect(0, 0, 0, 0);
        this.x.setColor(-16777216);
        this.x.setStyle(Paint.Style.FILL);
        this.x.setAntiAlias(true);
        this.y.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.tieba.zk, com.baidu.tieba.xk
    public void h(Canvas canvas, al alVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, canvas, alVar, imageView) == null) {
            Matrix matrix = this.f;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            if (alVar.e()) {
                Bitmap bitmap = alVar.a.getBitmap();
                if (this.w) {
                    v(canvas, bitmap);
                    return;
                }
                this.A.set(0, 0, alVar.b(), alVar.a());
                alVar.b.g(canvas, this.A, this.g, this.c);
            } else if (alVar.d()) {
                if (this.w) {
                    v(canvas, alVar.b.p());
                    return;
                }
                this.A.set(0, 0, alVar.b(), alVar.a());
                alVar.b.g(canvas, this.A, this.g, this.c);
            } else {
                this.A.set(0, 0, alVar.b(), alVar.a());
                alVar.b.g(canvas, this.A, this.g, this.c);
            }
        }
    }

    public void v(Canvas canvas, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, bitmap) == null) {
            this.A.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.z.set(0, 0, (int) this.g.width(), (int) this.g.height());
            canvas.save();
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawPath(this.t, this.x);
            canvas.drawBitmap(bitmap, this.A, this.g, this.y);
            canvas.restore();
        }
    }
}
