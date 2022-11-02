package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static cj7 a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof rh7)) {
                return ((rh7) tbPageContext.getPageActivity()).W();
            }
            return null;
        }
        return (cj7) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof rh7)) {
                return ((rh7) tbPageContext.getPageActivity()).c0();
            }
            return null;
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static hj7 c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof rh7)) {
                return ((rh7) tbPageContext.getPageActivity()).B0();
            }
            return null;
        }
        return (hj7) invokeL.objValue;
    }
}
