package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.ao3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ao3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx2 a;
        public final /* synthetic */ ng4 b;
        public final /* synthetic */ jg4 c;

        public a(vx2 vx2Var, ng4 ng4Var, jg4 jg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vx2Var, ng4Var, jg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vx2Var;
            this.b = ng4Var;
            this.c = jg4Var;
        }

        @Override // com.baidu.tieba.ao3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    d82.o("map", " icon is null ");
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
                    ay2 ay2Var = this.a.d;
                    builder.point(new Point(ay2Var.a, ay2Var.b));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.c);
                    imageView.setClickable(this.a.c);
                    lg4 lg4Var = new lg4();
                    lg4Var.a = this.a;
                    lg4Var.b = imageView;
                    this.b.o.add(lg4Var);
                }
            }
        }
    }

    public static void a(ng4 ng4Var, vx2 vx2Var, jg4 jg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, ng4Var, vx2Var, jg4Var) == null) {
            d82.i("map", "createControl start");
            if (vx2Var != null && vx2Var.isValid()) {
                ao3.e(vx2Var.b, new a(vx2Var, ng4Var, jg4Var));
            }
            d82.i("map", "createControl end");
        }
    }
}
