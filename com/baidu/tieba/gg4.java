package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.eo3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements eo3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx2 a;
        public final /* synthetic */ rg4 b;
        public final /* synthetic */ ng4 c;

        public a(zx2 zx2Var, rg4 rg4Var, ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx2Var, rg4Var, ng4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx2Var;
            this.b = rg4Var;
            this.c = ng4Var;
        }

        @Override // com.baidu.tieba.eo3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    h82.o("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i = this.a.d.c;
                    if (i == -1) {
                        i = bitmap.getWidth();
                    }
                    int i2 = this.a.d.d;
                    if (i2 == -1) {
                        i2 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i);
                    builder.height(i2);
                    builder.align(1, 8);
                    ey2 ey2Var = this.a.d;
                    builder.point(new Point(ey2Var.a, ey2Var.b));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.c);
                    imageView.setClickable(this.a.c);
                    pg4 pg4Var = new pg4();
                    pg4Var.a = this.a;
                    pg4Var.b = imageView;
                    this.b.o.add(pg4Var);
                }
            }
        }
    }

    public static void a(rg4 rg4Var, zx2 zx2Var, ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, rg4Var, zx2Var, ng4Var) == null) {
            h82.i("map", "createControl start");
            if (zx2Var != null && zx2Var.isValid()) {
                eo3.e(zx2Var.b, new a(zx2Var, rg4Var, ng4Var));
            }
            h82.i("map", "createControl end");
        }
    }
}
