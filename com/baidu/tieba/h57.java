package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, xn xnVar) {
        InterceptResult invokeLL;
        s46 s46Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, xnVar)) == null) {
            if ((xnVar instanceof s46) && (threadData = (s46Var = (s46) xnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(s46Var.a.getVoiceRoomData().room_name) && s46Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((cb5) ServiceManager.getService(cb5.a.a())).a(tbPageContext, s46Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
