package com.baidu.tieba;

import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class g20 {
    public static /* synthetic */ Interceptable $ic;
    public static g20 b;
    public transient /* synthetic */ FieldHolder $fh;
    public u8 a;

    public g20() {
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
        this.a = u8.n(AppRuntime.getAppContext());
    }

    public static g20 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (AbTestManager.class) {
                    if (b == null) {
                        b = new g20();
                    }
                }
            }
            return b;
        }
        return (g20) invokeV.objValue;
    }

    public void b(List<c9> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) {
            this.a.G(list, z);
        }
    }
}
