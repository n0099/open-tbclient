package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class cc1 implements ec1 {
    public static /* synthetic */ Interceptable $ic;
    public static cc1 b;
    public static gc1 c;
    public static kc1 d;
    public static jc1 e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public cc1(Context context) {
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
        this.a = context.getApplicationContext();
        d = new kc1();
        e = new jc1(context);
        c = new gc1();
    }

    public static jc1 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (e == null) {
                e = new jc1(context);
            }
            return e;
        }
        return (jc1) invokeL.objValue;
    }

    public static cc1 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (b == null) {
                synchronized (cc1.class) {
                    if (b == null) {
                        b = new cc1(context);
                    }
                }
            }
            return b;
        }
        return (cc1) invokeL.objValue;
    }

    public static kc1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                d = new kc1();
            }
            return d;
        }
        return (kc1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec1
    public void a(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) {
            e(imageView, str, 0, 0);
        }
    }

    public void e(ImageView imageView, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, str, i, i2) == null) {
            imageView.setTag(str);
            Bitmap c2 = d.c(str);
            if (c2 != null) {
                imageView.setImageBitmap(c2);
            } else {
                ad1.a(new ic1(this.a, c, str, imageView, i, i2));
            }
        }
    }
}
