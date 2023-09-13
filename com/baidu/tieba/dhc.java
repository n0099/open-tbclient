package com.baidu.tieba;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
/* loaded from: classes5.dex */
public interface dhc {
    void a(Activity activity, sic sicVar, List<PayWayInfo> list, String str, PaySplitOrderViewSource paySplitOrderViewSource, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    vic b();

    void c(vic vicVar);

    void release();
}
