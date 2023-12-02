package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.hgd;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes5.dex */
public interface cdd {
    void f(Activity activity, Dialog dialog, agd agdVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, agd agdVar, hgd.b bVar, qed qedVar, ued uedVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, ued uedVar, Dialog dialog, agd agdVar);
}
