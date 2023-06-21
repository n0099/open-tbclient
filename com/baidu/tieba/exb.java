package com.baidu.tieba;

import com.baidu.tieba.txb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.payui.view.IYYPayAmountView;
/* loaded from: classes5.dex */
public class exb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static txb.b a(cwb cwbVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, cwbVar, list, str, viewParams)) == null) {
            txb.b bVar = new txb.b();
            bVar.c = cwbVar;
            bVar.a = list;
            bVar.b = str;
            if (viewParams != null) {
                bVar.d = viewParams.appCustomExpand;
                bVar.f = viewParams.viewEventListener;
                bVar.e = viewParams.clientInfoExpand;
                bVar.h = viewParams.windowParams;
                bVar.i = viewParams.showFaqPage;
                bVar.j = viewParams.splitOrderPayScene;
            }
            return bVar;
        }
        return (txb.b) invokeLLLL.objValue;
    }
}
