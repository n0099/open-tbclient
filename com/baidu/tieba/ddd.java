package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.igd;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes5.dex */
public interface ddd {
    void f(Activity activity, Dialog dialog, bgd bgdVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, bgd bgdVar, igd.b bVar, red redVar, ved vedVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, ved vedVar, Dialog dialog, bgd bgdVar);
}
