package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.kbc;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes5.dex */
public interface d8c {
    void a(Activity activity, t9c t9cVar, x9c x9cVar, Dialog dialog, dbc dbcVar, AppCustomExpand appCustomExpand, kbc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
