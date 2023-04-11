package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.gab;
import com.baidu.tieba.hab;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes4.dex */
public interface h7b {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, f7b f7bVar);

    eab b(Activity activity);

    dab c(Activity activity);

    fab d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, f7b f7bVar);

    gab f(Activity activity, gab.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, j7b j7bVar);

    hab h(Activity activity, PayUIKitConfig payUIKitConfig, hab.b bVar, j7b j7bVar);
}
