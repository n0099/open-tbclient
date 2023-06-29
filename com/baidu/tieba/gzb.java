package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.n2c;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes6.dex */
public interface gzb {
    void a(Activity activity, w0c w0cVar, a1c a1cVar, Dialog dialog, g2c g2cVar, AppCustomExpand appCustomExpand, n2c.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
