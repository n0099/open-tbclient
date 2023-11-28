package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cc1 {
    public static /* synthetic */ Interceptable $ic;
    public static cc1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public dc1 a;

    public cc1(dc1 dc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dc1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dc1Var;
    }

    public static void c(dc1 dc1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, dc1Var) == null) && b == null) {
            synchronized (cc1.class) {
                if (b == null) {
                    b = new cc1(dc1Var);
                }
            }
        }
    }

    public static cc1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (cc1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        dc1 dc1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (dc1Var = this.a) != null) {
            dc1Var.a(imageView, str);
        }
    }
}
