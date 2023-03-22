package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ew5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static yv5 a(zv5 zv5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zv5Var)) == null) {
            if (zv5Var != null && (zv5Var.a() instanceof TbPageContext) && (((TbPageContext) zv5Var.a()).getPageActivity() instanceof yv5)) {
                return (yv5) ((TbPageContext) zv5Var.a()).getPageActivity();
            }
            return null;
        }
        return (yv5) invokeL.objValue;
    }
}
