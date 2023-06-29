package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, xn xnVar) {
        InterceptResult invokeLL;
        yo6 yo6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, xnVar)) == null) {
            if ((xnVar instanceof yo6) && (threadData = (yo6Var = (yo6) xnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(yo6Var.a.getVoiceRoomData().room_name) && yo6Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((oo5) ServiceManager.getService(oo5.a.a())).b(tbPageContext, yo6Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
