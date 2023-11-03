package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bc1 {
    public static /* synthetic */ Interceptable $ic;
    public static bc1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public cc1 a;

    public bc1(cc1 cc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cc1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cc1Var;
    }

    public static void c(cc1 cc1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, cc1Var) == null) && b == null) {
            synchronized (bc1.class) {
                if (b == null) {
                    b = new bc1(cc1Var);
                }
            }
        }
    }

    public static bc1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (bc1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        cc1 cc1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (cc1Var = this.a) != null) {
            cc1Var.a(imageView, str);
        }
    }
}
