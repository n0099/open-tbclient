package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.cca;
import com.baidu.tieba.dca;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes4.dex */
public interface d9a {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, b9a b9aVar);

    aca b(Activity activity);

    zba c(Activity activity);

    bca d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, b9a b9aVar);

    cca f(Activity activity, cca.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, f9a f9aVar);

    dca h(Activity activity, PayUIKitConfig payUIKitConfig, dca.b bVar, f9a f9aVar);
}
