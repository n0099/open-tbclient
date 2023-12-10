package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class ah9 implements zg9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<zg9> a;
    public static final zg9 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947615319, "Lcom/baidu/tieba/ah9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947615319, "Lcom/baidu/tieba/ah9;");
                return;
            }
        }
        a = new AtomicReference<>(null);
        b = new ah9();
    }

    public ah9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static zg9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            zg9 zg9Var = a.get();
            if (zg9Var == null) {
                return b;
            }
            return zg9Var;
        }
        return (zg9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zg9
    public rg9 a(vg9 vg9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vg9Var)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (rg9) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zg9
    public wf9 b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, bdUniqueId, i)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (wf9) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.zg9
    public bh9 c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, bdUniqueId)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (bh9) invokeLL.objValue;
    }
}
