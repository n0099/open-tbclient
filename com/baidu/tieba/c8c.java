package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.ibc;
import com.baidu.tieba.jbc;
import com.baidu.tieba.kbc;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes5.dex */
public interface c8c {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, z7c z7cVar);

    gbc b(Activity activity);

    fbc c(Activity activity);

    hbc d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, z7c z7cVar);

    ibc f(Activity activity, ibc.b bVar, PayUIKitConfig payUIKitConfig);

    kbc g(Activity activity, kbc.b bVar, e8c e8cVar);

    jbc h(Activity activity, PayUIKitConfig payUIKitConfig, jbc.b bVar, e8c e8cVar);
}
