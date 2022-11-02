package com.baidu.tieba;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes3.dex */
public interface d5a {
    void a(Activity activity, PayFlowType payFlowType, q6a q6aVar, n6a n6aVar, AppCustomExpand appCustomExpand, Map<String, String> map, IPayCallback iPayCallback, String str);
}
