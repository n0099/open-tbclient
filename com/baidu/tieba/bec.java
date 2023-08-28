package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ghc;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes5.dex */
public interface bec {
    void f(Activity activity, Dialog dialog, zgc zgcVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, zgc zgcVar, ghc.b bVar, pfc pfcVar, tfc tfcVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, tfc tfcVar, Dialog dialog, zgc zgcVar);
}
