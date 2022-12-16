package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.bh3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements bh3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq2 a;
        public final /* synthetic */ o94 b;
        public final /* synthetic */ k94 c;

        public a(wq2 wq2Var, o94 o94Var, k94 k94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq2Var, o94Var, k94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wq2Var;
            this.b = o94Var;
            this.c = k94Var;
        }

        @Override // com.baidu.tieba.bh3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    e12.o("map", " icon is null ");
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
                    br2 br2Var = this.a.d;
                    builder.point(new Point(br2Var.a, br2Var.b));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.c);
                    imageView.setClickable(this.a.c);
                    m94 m94Var = new m94();
                    m94Var.a = this.a;
                    m94Var.b = imageView;
                    this.b.o.add(m94Var);
                }
            }
        }
    }

    public static void a(o94 o94Var, wq2 wq2Var, k94 k94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, o94Var, wq2Var, k94Var) == null) {
            e12.i("map", "createControl start");
            if (wq2Var != null && wq2Var.isValid()) {
                bh3.e(wq2Var.b, new a(wq2Var, o94Var, k94Var));
            }
            e12.i("map", "createControl end");
        }
    }
}
