package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class dc1 {
    public static /* synthetic */ Interceptable $ic;
    public static dc1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ec1 a;

    public dc1(ec1 ec1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ec1Var;
    }

    public static void c(ec1 ec1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, ec1Var) == null) && b == null) {
            synchronized (dc1.class) {
                if (b == null) {
                    b = new dc1(ec1Var);
                }
            }
        }
    }

    public static dc1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (dc1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        ec1 ec1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (ec1Var = this.a) != null) {
            ec1Var.a(imageView, str);
        }
    }
}
