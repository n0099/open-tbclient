package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ew6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static dw6 a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, tbPageContext, bdUniqueId, i)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            if (i == 1) {
                return new iw6(tbPageContext, bdUniqueId, i);
            }
            if (i == 2) {
                return new hw6(tbPageContext, bdUniqueId, i);
            }
            if (i != 3) {
                return null;
            }
            return new fw6(tbPageContext, bdUniqueId, i);
        }
        return (dw6) invokeLLI.objValue;
    }
}
