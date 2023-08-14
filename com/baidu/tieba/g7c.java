package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.mac;
import com.baidu.tieba.nac;
import com.baidu.tieba.oac;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes6.dex */
public interface g7c {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, d7c d7cVar);

    kac b(Activity activity);

    jac c(Activity activity);

    lac d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, d7c d7cVar);

    mac f(Activity activity, mac.b bVar, PayUIKitConfig payUIKitConfig);

    oac g(Activity activity, oac.b bVar, i7c i7cVar);

    nac h(Activity activity, PayUIKitConfig payUIKitConfig, nac.b bVar, i7c i7cVar);
}
