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
public class d19 implements c19 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<c19> a;
    public static final c19 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947651837, "Lcom/baidu/tieba/d19;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947651837, "Lcom/baidu/tieba/d19;");
                return;
            }
        }
        a = new AtomicReference<>(null);
        b = new d19();
    }

    public d19() {
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

    public static c19 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c19 c19Var = a.get();
            if (c19Var == null) {
                return b;
            }
            return c19Var;
        }
        return (c19) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c19
    public u09 a(y09 y09Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, y09Var)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (u09) invokeL.objValue;
    }

    @Override // com.baidu.tieba.c19
    public yz8 b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, bdUniqueId, i)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (yz8) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.c19
    public e19 c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, bdUniqueId)) == null) {
            BdLog.e("Card project loaded failed.");
            return null;
        }
        return (e19) invokeLL.objValue;
    }
}
