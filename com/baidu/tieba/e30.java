package com.baidu.tieba;

import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class e30 {
    public static /* synthetic */ Interceptable $ic;
    public static e30 b;
    public transient /* synthetic */ FieldHolder $fh;
    public t8 a;

    public e30() {
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
        this.a = t8.n(AppRuntime.getAppContext());
    }

    public static e30 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (AbTestManager.class) {
                    if (b == null) {
                        b = new e30();
                    }
                }
            }
            return b;
        }
        return (e30) invokeV.objValue;
    }

    public void b(List<b9> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
            this.a.G(list, z);
        }
    }
}
