package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.lac;
import com.baidu.tieba.mac;
import com.baidu.tieba.nac;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes5.dex */
public interface f7c {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, c7c c7cVar);

    jac b(Activity activity);

    iac c(Activity activity);

    kac d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, c7c c7cVar);

    lac f(Activity activity, lac.b bVar, PayUIKitConfig payUIKitConfig);

    nac g(Activity activity, nac.b bVar, h7c h7cVar);

    mac h(Activity activity, PayUIKitConfig payUIKitConfig, mac.b bVar, h7c h7cVar);
}
