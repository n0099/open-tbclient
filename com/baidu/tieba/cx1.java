package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class cx1 extends sw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public Rect d;
    public Rect e;
    public Bitmap f;
    public int g;
    public Uri h;
    public String i;

    /* loaded from: classes3.dex */
    public class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataSource a;
        public final /* synthetic */ tw1 b;
        public final /* synthetic */ cx1 c;

        public a(cx1 cx1Var, DataSource dataSource, tw1 tw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cx1Var, dataSource, tw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cx1Var;
            this.a = dataSource;
            this.b = tw1Var;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                this.c.g = 3;
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (this.a.isFinished() && bitmap != null) {
                    this.c.f = Bitmap.createBitmap(bitmap);
                    this.a.close();
                    CanvasView canvasView = this.b.h;
                    if (canvasView != null) {
                        canvasView.postInvalidate();
                    }
                }
                this.c.g = 2;
            }
        }
    }

    public cx1() {
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
        this.g = 0;
    }

    public final int i(JSONArray jSONArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, jSONArray, i)) == null) {
            return dh3.g((float) jSONArray.optDouble(i));
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.sw1
    public void a(tw1 tw1Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, tw1Var, canvas) == null) {
            if (h(tw1Var)) {
                int alpha = tw1Var.d.getAlpha();
                tw1Var.c(tw1Var.d);
                Rect rect = this.e;
                if (rect != null) {
                    canvas.drawBitmap(this.f, this.d, rect, tw1Var.d);
                } else {
                    canvas.drawBitmap(this.f, this.b, this.c, tw1Var.d);
                }
                tw1Var.d.setAlpha(alpha);
                return;
            }
            try {
                j(tw1Var);
            } catch (Exception e) {
                if (wj1.a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final String g(String str, m33 m33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, m33Var)) == null) {
            if (!TextUtils.isEmpty(str) && m33Var != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        str = ua3.M(str, m33Var.b);
                    }
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        return file.getAbsolutePath();
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sw1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            m33 b0 = m33.b0();
            try {
                int length = jSONArray.length();
                if (length > 0) {
                    this.i = this.a;
                    String optString = jSONArray.optString(0);
                    this.a = optString;
                    this.a = f(b0, optString);
                }
                if (length > 2) {
                    this.b = i(jSONArray, 1);
                    this.c = i(jSONArray, 2);
                }
                if (length > 4) {
                    int i = this.b;
                    int i2 = this.c;
                    int i3 = i(jSONArray, 3);
                    int i4 = i(jSONArray, 4);
                    if (i3 > 0 && i4 > 0) {
                        this.e = new Rect(i, i2, i3 + i, i4 + i2);
                    }
                }
                if (length > 8) {
                    int optInt = jSONArray.optInt(5);
                    int optInt2 = jSONArray.optInt(6);
                    int optInt3 = jSONArray.optInt(7);
                    int optInt4 = jSONArray.optInt(8);
                    if (optInt3 > 0 && optInt4 > 0) {
                        this.d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                    }
                }
                if (b0 != null) {
                    String g = g(this.a, b0);
                    if (!TextUtils.isEmpty(g)) {
                        this.f = BitmapFactory.decodeFile(g);
                    } else if (!TextUtils.isEmpty(this.a)) {
                        if (this.h == null || !TextUtils.equals(this.a, this.i)) {
                            this.h = Uri.parse(this.a);
                        }
                    }
                }
            } catch (Exception e) {
                if (wj1.a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void e(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) && hashMap != null && !TextUtils.isEmpty(this.a) && this.f != null && !hashMap.containsKey(this.a)) {
            hashMap.put(this.a, this.f);
        }
    }

    public final String f(m33 m33Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, m33Var, str)) == null) {
            if (!TextUtils.isEmpty(str) && m33Var != null) {
                try {
                    if (!"bdfile".equalsIgnoreCase(URI.create(str).getScheme()) && !str.startsWith(gh3.x(m33Var).getPath())) {
                        return gh3.w(m33Var, str);
                    }
                    return str;
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final boolean h(tw1 tw1Var) {
        InterceptResult invokeL;
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tw1Var)) == null) {
            if (this.f != null) {
                return true;
            }
            if (this.h == null || tw1Var == null || (canvasView = tw1Var.h) == null) {
                return false;
            }
            Bitmap e = canvasView.e(this.a);
            this.f = e;
            if (e != null) {
                return true;
            }
            Bitmap c = jg3.c(this.h, tw1Var.h.getContext());
            this.f = c;
            if (c != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(tw1 tw1Var) {
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, tw1Var) == null) && this.g == 0 && (canvasView = tw1Var.h) != null && canvasView.getContext() != null && !TextUtils.isEmpty(this.a)) {
            this.g = 1;
            DataSource fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.a)).build(), tw1Var.h.getContext());
            fetchDecodedImage.subscribe(new a(this, fetchDecodedImage, tw1Var), UiThreadImmediateExecutorService.getInstance());
        }
    }
}
