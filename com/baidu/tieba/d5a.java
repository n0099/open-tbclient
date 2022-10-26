package com.baidu.tieba;

import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.Map;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes3.dex */
public interface d5a {
    GetBannerConfigReqParams a();

    w2a b(PayFlowType payFlowType, Map map);

    QueryCurrencyReqParams c();

    QueryCurrencyReqParams d(Map map);
}
