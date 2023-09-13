package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.hkc;
import com.baidu.tieba.ikc;
import com.baidu.tieba.jkc;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes5.dex */
public interface bhc {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, ygc ygcVar);

    fkc b(Activity activity);

    ekc c(Activity activity);

    gkc d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, ygc ygcVar);

    hkc f(Activity activity, hkc.b bVar, PayUIKitConfig payUIKitConfig);

    jkc g(Activity activity, jkc.b bVar, dhc dhcVar);

    ikc h(Activity activity, PayUIKitConfig payUIKitConfig, ikc.b bVar, dhc dhcVar);
}
