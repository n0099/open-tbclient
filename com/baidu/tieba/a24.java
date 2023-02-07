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
public class a24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a24 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c24> a;

    public a24() {
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

    public static a24 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (a24.class) {
                    if (b == null) {
                        b = new a24();
                    }
                }
            }
            return b;
        }
        return (a24) invokeV.objValue;
    }

    public void a(c24 c24Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, c24Var) == null) && c24Var != null && !this.a.contains(c24Var)) {
            this.a.add(c24Var);
        }
    }

    public void d(c24 c24Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c24Var) == null) && this.a.contains(c24Var)) {
            this.a.remove(c24Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (c24 c24Var : this.a) {
                if (i == 16) {
                    c24Var.c();
                } else if (i == 17) {
                    c24Var.b(str);
                }
                d(c24Var);
            }
        }
    }
}
