package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.nac;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes6.dex */
public interface g7c {
    void a(Activity activity, w8c w8cVar, a9c a9cVar, Dialog dialog, gac gacVar, AppCustomExpand appCustomExpand, nac.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
