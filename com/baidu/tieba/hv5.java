package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bv5 a(cv5 cv5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cv5Var)) == null) {
            if (cv5Var != null && (cv5Var.a() instanceof TbPageContext) && (((TbPageContext) cv5Var.a()).getPageActivity() instanceof bv5)) {
                return (bv5) ((TbPageContext) cv5Var.a()).getPageActivity();
            }
            return null;
        }
        return (bv5) invokeL.objValue;
    }
}
