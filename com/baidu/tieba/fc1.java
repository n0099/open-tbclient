package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fc1 {
    public static /* synthetic */ Interceptable $ic;
    public static fc1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public gc1 a;

    public fc1(gc1 gc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gc1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gc1Var;
    }

    public static void c(gc1 gc1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, gc1Var) == null) && b == null) {
            synchronized (fc1.class) {
                if (b == null) {
                    b = new fc1(gc1Var);
                }
            }
        }
    }

    public static fc1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (fc1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        gc1 gc1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (gc1Var = this.a) != null) {
            gc1Var.a(imageView, str);
        }
    }
}
