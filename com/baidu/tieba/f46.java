package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static z36 a(a46 a46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, a46Var)) == null) {
            if (a46Var != null && (a46Var.a() instanceof TbPageContext) && (((TbPageContext) a46Var.a()).getPageActivity() instanceof z36)) {
                return (z36) ((TbPageContext) a46Var.a()).getPageActivity();
            }
            return null;
        }
        return (z36) invokeL.objValue;
    }
}
