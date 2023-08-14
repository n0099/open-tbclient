package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.oac;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes6.dex */
public interface h7c {
    void a(Activity activity, x8c x8cVar, b9c b9cVar, Dialog dialog, hac hacVar, AppCustomExpand appCustomExpand, oac.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
