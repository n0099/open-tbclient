package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bh1 {
    public static /* synthetic */ Interceptable $ic;
    public static bh1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ch1 a;

    public bh1(ch1 ch1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ch1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ch1Var;
    }

    public static void c(ch1 ch1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, ch1Var) == null) && b == null) {
            synchronized (bh1.class) {
                if (b == null) {
                    b = new bh1(ch1Var);
                }
            }
        }
    }

    public static bh1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (bh1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        ch1 ch1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (ch1Var = this.a) != null) {
            ch1Var.a(imageView, str);
        }
    }
}
