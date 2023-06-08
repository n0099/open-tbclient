package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static u36 a(v36 v36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, v36Var)) == null) {
            if (v36Var != null && (v36Var.a() instanceof TbPageContext) && (((TbPageContext) v36Var.a()).getPageActivity() instanceof u36)) {
                return (u36) ((TbPageContext) v36Var.a()).getPageActivity();
            }
            return null;
        }
        return (u36) invokeL.objValue;
    }
}
