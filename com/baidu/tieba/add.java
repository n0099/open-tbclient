package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.hgd;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes5.dex */
public interface add {
    void a(Activity activity, qed qedVar, ued uedVar, Dialog dialog, agd agdVar, AppCustomExpand appCustomExpand, hgd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
