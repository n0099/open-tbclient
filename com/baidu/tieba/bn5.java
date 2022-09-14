package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static vm5 a(wm5 wm5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wm5Var)) == null) {
            if (wm5Var != null && (wm5Var.a() instanceof TbPageContext) && (((TbPageContext) wm5Var.a()).getPageActivity() instanceof vm5)) {
                return (vm5) ((TbPageContext) wm5Var.a()).getPageActivity();
            }
            return null;
        }
        return (vm5) invokeL.objValue;
    }
}
