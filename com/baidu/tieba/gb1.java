package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gb1 {
    public static /* synthetic */ Interceptable $ic;
    public static gb1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public hb1 a;

    public gb1(hb1 hb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hb1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hb1Var;
    }

    public static void c(hb1 hb1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, hb1Var) == null) && b == null) {
            synchronized (gb1.class) {
                if (b == null) {
                    b = new gb1(hb1Var);
                }
            }
        }
    }

    public static gb1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (gb1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        hb1 hb1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (hb1Var = this.a) != null) {
            hb1Var.a(imageView, str);
        }
    }
}
