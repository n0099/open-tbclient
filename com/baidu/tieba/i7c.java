package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.nac;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes6.dex */
public interface i7c {
    void f(Activity activity, Dialog dialog, gac gacVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, gac gacVar, nac.b bVar, w8c w8cVar, a9c a9cVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, a9c a9cVar, Dialog dialog, gac gacVar);
}
