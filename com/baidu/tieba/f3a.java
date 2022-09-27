package com.baidu.tieba;

import android.app.Activity;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes4.dex */
public interface f3a {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, b3a b3aVar);

    p5a b(Activity activity);

    o5a c(Activity activity);

    q5a d(Activity activity);

    IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, b3a b3aVar);

    IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, b3a b3aVar);
}
