package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fb1 {
    public static /* synthetic */ Interceptable $ic;
    public static fb1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public gb1 a;

    public fb1(gb1 gb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gb1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gb1Var;
    }

    public static fb1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b : (fb1) invokeV.objValue;
    }

    public static void c(gb1 gb1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, gb1Var) == null) && b == null) {
            synchronized (fb1.class) {
                if (b == null) {
                    b = new fb1(gb1Var);
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        gb1 gb1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || (gb1Var = this.a) == null) {
            return;
        }
        gb1Var.a(imageView, str);
    }
}
