package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes3.dex */
public class cw2 implements aw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947689099, "Lcom/baidu/tieba/cw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947689099, "Lcom/baidu/tieba/cw2;");
                return;
            }
        }
        a = do1.a;
    }

    public cw2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.aw2
    @SuppressLint({"BDThrowableCheck"})
    public Bitmap decode(Context context, Uri uri) throws Exception {
        InterceptResult invokeLL;
        Bitmap bitmap;
        Resources resourcesForApplication;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, uri)) == null) {
            String uri2 = uri.toString();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            if (uri2.startsWith("android.resource://")) {
                String authority = uri.getAuthority();
                if (context.getPackageName().equals(authority)) {
                    resourcesForApplication = context.getResources();
                } else {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
                }
                List<String> pathSegments = uri.getPathSegments();
                int size = pathSegments.size();
                int i = 0;
                if (size == 2 && pathSegments.get(0).equals(ResourceManager.DRAWABLE)) {
                    i = resourcesForApplication.getIdentifier(pathSegments.get(1), ResourceManager.DRAWABLE, authority);
                } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                bitmap = BitmapFactory.decodeResource(context.getResources(), i, options);
            } else {
                InputStream inputStream = null;
                if (uri2.startsWith("file:///android_asset/")) {
                    bitmap = BitmapFactory.decodeStream(context.getAssets().open(uri2.substring(22)), null, options);
                } else if (uri2.startsWith("file://")) {
                    bitmap = BitmapFactory.decodeFile(uri2.substring(7), options);
                } else {
                    try {
                        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                        try {
                            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                            xn4.d(openInputStream);
                            bitmap = decodeStream;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = openInputStream;
                            xn4.d(inputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            if (bitmap == null) {
                if (!a) {
                    t42.k("SkiaImageDecoder", "bitmap is null");
                } else {
                    throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }
}
