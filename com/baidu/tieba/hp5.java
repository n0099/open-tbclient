package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bp5 a(cp5 cp5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cp5Var)) == null) {
            if (cp5Var != null && (cp5Var.a() instanceof TbPageContext) && (((TbPageContext) cp5Var.a()).getPageActivity() instanceof bp5)) {
                return (bp5) ((TbPageContext) cp5Var.a()).getPageActivity();
            }
            return null;
        }
        return (bp5) invokeL.objValue;
    }
}
