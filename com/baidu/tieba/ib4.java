package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.et2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ib4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub4 a;
        public final /* synthetic */ et2 b;

        public a(ub4 ub4Var, et2 et2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub4Var, et2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub4Var;
            this.b = et2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                pb4.a(this.a, this.b);
            }
        }
    }

    public static View a(ub4 ub4Var, et2 et2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ub4Var, et2Var)) == null) {
            k32.i("map", "creatCallout start");
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(et2Var.i.b);
            paint.setTextSize(et2Var.i.c);
            et2.b bVar = et2Var.i;
            float f = bVar.e;
            float f2 = bVar.f;
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(et2Var.i.h);
            String str = et2Var.i.a;
            int g = bk3.g(6.0f);
            float f3 = f * 2.0f;
            float measureText = paint.measureText(str) + f3;
            float f4 = paint.getFontMetrics().bottom - paint.getFontMetrics().top;
            float f5 = g + f4 + f3;
            if (f5 > 0.0f && measureText > 0.0f) {
                Bitmap createBitmap = Bitmap.createBitmap((int) measureText, (int) f5, Bitmap.Config.ARGB_8888);
                createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                RectF rectF = new RectF();
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                float f6 = f4 + f3;
                rectF.bottom = f6;
                rectF.right = measureText;
                canvas.drawRoundRect(rectF, f2, f2, paint2);
                Path path = new Path();
                float f7 = measureText / 2.0f;
                float f8 = g / 2;
                path.moveTo(f7 - f8, f6);
                path.lineTo(f7, f5);
                path.lineTo(f7 + f8, f6);
                path.close();
                canvas.drawPath(path, paint2);
                canvas.drawText(str, f, (-paint.getFontMetrics().top) + f, paint);
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
                imageView.setImageBitmap(createBitmap);
                imageView.setOnClickListener(new a(ub4Var, et2Var));
                k32.i("map", "creatCallout end");
                return imageView;
            }
            k32.o("map", "callout height or wodth is 0");
            return new ImageView(AppRuntime.getAppContext());
        }
        return (View) invokeLL.objValue;
    }
}
