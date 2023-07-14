package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.kbc;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes5.dex */
public interface f8c {
    void f(Activity activity, Dialog dialog, dbc dbcVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, dbc dbcVar, kbc.b bVar, t9c t9cVar, x9c x9cVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, x9c x9cVar, Dialog dialog, dbc dbcVar);
}
