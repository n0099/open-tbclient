package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.jkc;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes5.dex */
public interface ehc {
    void f(Activity activity, Dialog dialog, ckc ckcVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, ckc ckcVar, jkc.b bVar, sic sicVar, wic wicVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, wic wicVar, Dialog dialog, ckc ckcVar);
}
