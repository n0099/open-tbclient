package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ap5 a(bp5 bp5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bp5Var)) == null) {
            if (bp5Var != null && (bp5Var.a() instanceof TbPageContext) && (((TbPageContext) bp5Var.a()).getPageActivity() instanceof ap5)) {
                return (ap5) ((TbPageContext) bp5Var.a()).getPageActivity();
            }
            return null;
        }
        return (ap5) invokeL.objValue;
    }
}
