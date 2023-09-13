package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.by2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static OverlayOptions a(rg4 rg4Var, qg4 qg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, rg4Var, qg4Var)) == null) {
            h82.i("map", "createLabel start");
            if (qg4Var == null) {
                return null;
            }
            by2 by2Var = qg4Var.a;
            if (by2Var != null && by2Var.j != null && by2Var.b != null) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setColor(by2Var.j.b);
                paint.setTextSize(by2Var.j.c);
                by2.c cVar = by2Var.j;
                float f = cVar.e;
                float f2 = cVar.j;
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                paint2.setStyle(Paint.Style.FILL_AND_STROKE);
                paint2.setColor(by2Var.j.d);
                String str = by2Var.j.a;
                float f3 = f * 2.0f;
                float measureText = paint.measureText(str) + f3;
                float f4 = (paint.getFontMetrics().bottom - paint.getFontMetrics().top) + f3;
                if (f4 > 0.0f && measureText > 0.0f) {
                    float f5 = by2Var.j.h;
                    Bitmap createBitmap = Bitmap.createBitmap((int) (measureText + f5 + 0.5d), (int) (f4 + f5 + 0.5d), Bitmap.Config.ARGB_8888);
                    createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    RectF rectF = new RectF();
                    float f6 = f5 / 2.0f;
                    rectF.left = f6;
                    rectF.top = f6;
                    rectF.bottom = f4 + f6;
                    rectF.right = measureText + f6;
                    canvas.drawRoundRect(rectF, f2, f2, paint2);
                    if (f5 > 0.0f) {
                        paint2.setStyle(Paint.Style.STROKE);
                        paint2.setColor(by2Var.j.i);
                        paint2.setStrokeWidth(f5);
                        canvas.drawRoundRect(rectF, f2, f2, paint2);
                    }
                    canvas.drawText(str, f + f6, (-paint.getFontMetrics().top) + f + f6, paint);
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
                    by2.c cVar2 = by2Var.j;
                    imageView.setPadding((int) cVar2.f, (int) cVar2.g, 0, 0);
                    imageView.setImageBitmap(createBitmap);
                    BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(imageView);
                    MarkerOptions markerOptions = new MarkerOptions();
                    ay2 ay2Var = by2Var.b;
                    MarkerOptions zIndex = markerOptions.position(new LatLng(ay2Var.a, ay2Var.b)).icon(fromView).anchor(0.0f, 0.0f).zIndex(66);
                    h82.i("map", "createLabel end");
                    return zIndex;
                }
                h82.c("map", "label heigth or width is 0");
                return null;
            }
            h82.c("map", "marker data error");
            return null;
        }
        return (OverlayOptions) invokeLL.objValue;
    }
}
