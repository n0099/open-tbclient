package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class du3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile du3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<fu3> a;

    public du3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new CopyOnWriteArrayList();
    }

    public static du3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (du3.class) {
                    if (b == null) {
                        b = new du3();
                    }
                }
            }
            return b;
        }
        return (du3) invokeV.objValue;
    }

    public void a(fu3 fu3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fu3Var) == null) || fu3Var == null || this.a.contains(fu3Var)) {
            return;
        }
        this.a.add(fu3Var);
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (fu3 fu3Var : this.a) {
                if (i == 16) {
                    fu3Var.c();
                } else if (i == 17) {
                    fu3Var.b(str);
                }
                d(fu3Var);
            }
        }
    }

    public void d(fu3 fu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fu3Var) == null) && this.a.contains(fu3Var)) {
            this.a.remove(fu3Var);
        }
    }
}
