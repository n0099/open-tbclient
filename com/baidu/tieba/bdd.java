package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.igd;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes5.dex */
public interface bdd {
    void a(Activity activity, red redVar, ved vedVar, Dialog dialog, bgd bgdVar, AppCustomExpand appCustomExpand, igd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
