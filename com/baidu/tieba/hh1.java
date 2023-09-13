package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tieba.jh1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public class hh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jh1 a;

    public hh1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        File b = b(context, "bitmap");
        if (!b.exists()) {
            b.mkdirs();
        }
        try {
            this.a = jh1.r(b, 1, 1, Config.FULL_TRACE_LOG_LIMIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.a == null) {
            return;
        }
        try {
            jh1.c n = this.a.n(nh1.b(str));
            if (n == null) {
                return;
            }
            if (dh1.b(str, n.f(0))) {
                n.e();
            } else {
                n.a();
            }
            this.a.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File b(Context context, String str) {
        InterceptResult invokeLL;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
                path = context.getExternalCacheDir().getPath();
            } else {
                path = context.getCacheDir().getPath();
            }
            return new File(path + File.separator + str);
        }
        return (File) invokeLL.objValue;
    }

    public Bitmap c(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, str, i, i2)) == null) {
            if (this.a == null) {
                return null;
            }
            jh1.e p = this.a.p(nh1.b(str));
            if (p == null) {
                return null;
            }
            FileInputStream fileInputStream = (FileInputStream) p.a(0);
            if (i > 0 && i2 > 0) {
                return mh1.b(fileInputStream.getFD(), i, i2);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return (Bitmap) invokeLII.objValue;
    }
}
