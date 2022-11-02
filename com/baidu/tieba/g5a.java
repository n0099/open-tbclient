package com.baidu.tieba;

import android.app.Activity;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes4.dex */
public interface g5a {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, c5a c5aVar);

    q7a b(Activity activity);

    p7a c(Activity activity);

    r7a d(Activity activity);

    IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, c5a c5aVar);

    IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, c5a c5aVar);
}
