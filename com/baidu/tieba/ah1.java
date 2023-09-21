package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ah1 {
    public static /* synthetic */ Interceptable $ic;
    public static ah1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public bh1 a;

    public ah1(bh1 bh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bh1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bh1Var;
    }

    public static void c(bh1 bh1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, bh1Var) == null) && b == null) {
            synchronized (ah1.class) {
                if (b == null) {
                    b = new ah1(bh1Var);
                }
            }
        }
    }

    public static ah1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (ah1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        bh1 bh1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (bh1Var = this.a) != null) {
            bh1Var.a(imageView, str);
        }
    }
}
