package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static wp5 a(xp5 xp5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, xp5Var)) == null) {
            if (xp5Var != null && (xp5Var.a() instanceof TbPageContext) && (((TbPageContext) xp5Var.a()).getPageActivity() instanceof wp5)) {
                return (wp5) ((TbPageContext) xp5Var.a()).getPageActivity();
            }
            return null;
        }
        return (wp5) invokeL.objValue;
    }
}
