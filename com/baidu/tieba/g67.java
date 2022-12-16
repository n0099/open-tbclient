package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, xn xnVar) {
        InterceptResult invokeLL;
        o56 o56Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, xnVar)) == null) {
            if ((xnVar instanceof o56) && (threadData = (o56Var = (o56) xnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(o56Var.a.getVoiceRoomData().room_name) && o56Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((ob5) ServiceManager.getService(ob5.a.a())).a(tbPageContext, o56Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
