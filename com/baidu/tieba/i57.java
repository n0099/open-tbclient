package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, xn xnVar) {
        InterceptResult invokeLL;
        t46 t46Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, xnVar)) == null) {
            if ((xnVar instanceof t46) && (threadData = (t46Var = (t46) xnVar).a) != null && threadData.getVoiceRoomData() != null && !StringUtils.isNull(t46Var.a.getVoiceRoomData().room_name) && t46Var.a.getVoiceRoomData().room_id.longValue() > 0) {
                ((db5) ServiceManager.getService(db5.a.a())).a(tbPageContext, t46Var.a.getVoiceRoomData().room_id.longValue());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
