package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes4.dex */
public class h28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final e28 a(TbPageContext<?> tbPageContext, ExcContent excContent) {
        InterceptResult invokeLL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, excContent)) == null) {
            if (excContent == null || (l = excContent.type) == null) {
                return null;
            }
            if (l.longValue() == 2) {
                return new c28(excContent);
            }
            if (excContent.type.longValue() == 0) {
                return new i28(tbPageContext.getPageActivity(), excContent);
            }
            if (excContent.type.longValue() == 1) {
                return new d28(tbPageContext, excContent);
            }
            return null;
        }
        return (e28) invokeLL.objValue;
    }

    public static final f28 b(ExcContent excContent) {
        InterceptResult invokeL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, excContent)) == null) {
            if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
                return null;
            }
            return new g28(excContent);
        }
        return (f28) invokeL.objValue;
    }
}
