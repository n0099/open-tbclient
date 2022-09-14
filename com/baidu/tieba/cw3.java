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
public class cw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cw3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ew3> a;

    public cw3() {
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

    public static cw3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (cw3.class) {
                    if (b == null) {
                        b = new cw3();
                    }
                }
            }
            return b;
        }
        return (cw3) invokeV.objValue;
    }

    public void a(ew3 ew3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ew3Var) == null) || ew3Var == null || this.a.contains(ew3Var)) {
            return;
        }
        this.a.add(ew3Var);
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (ew3 ew3Var : this.a) {
                if (i == 16) {
                    ew3Var.c();
                } else if (i == 17) {
                    ew3Var.b(str);
                }
                d(ew3Var);
            }
        }
    }

    public void d(ew3 ew3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ew3Var) == null) && this.a.contains(ew3Var)) {
            this.a.remove(ew3Var);
        }
    }
}
