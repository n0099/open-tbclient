package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ea7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, yn ynVar) {
        InterceptResult invokeLL;
        g96 g96Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, ynVar)) == null) {
            if ((ynVar instanceof g96) && (threadData = (g96Var = (g96) ynVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(g96Var.a.getVoiceRoomData().room_name) && g96Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((cc5) ServiceManager.getService(cc5.a.a())).a(tbPageContext, g96Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
