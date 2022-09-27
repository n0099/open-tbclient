package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, Cdo cdo) {
        InterceptResult invokeLL;
        p26 p26Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, cdo)) == null) {
            if (!(cdo instanceof p26) || (threadData = (p26Var = (p26) cdo).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(p26Var.a.getVoiceRoomData().room_name) || p26Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((w95) ServiceManager.getService(w95.a.a())).a(tbPageContext, p26Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
