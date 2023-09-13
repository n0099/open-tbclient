package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.jkc;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes5.dex */
public interface chc {
    void a(Activity activity, sic sicVar, wic wicVar, Dialog dialog, ckc ckcVar, AppCustomExpand appCustomExpand, jkc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
