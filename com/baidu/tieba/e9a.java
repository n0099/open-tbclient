package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.dca;
import com.baidu.tieba.eca;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes4.dex */
public interface e9a {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, c9a c9aVar);

    bca b(Activity activity);

    aca c(Activity activity);

    cca d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, c9a c9aVar);

    dca f(Activity activity, dca.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, g9a g9aVar);

    eca h(Activity activity, PayUIKitConfig payUIKitConfig, eca.b bVar, g9a g9aVar);
}
