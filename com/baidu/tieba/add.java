package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.ggd;
import com.baidu.tieba.hgd;
import com.baidu.tieba.igd;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes5.dex */
public interface add {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, xcd xcdVar);

    egd b(Activity activity);

    dgd c(Activity activity);

    fgd d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, xcd xcdVar);

    ggd f(Activity activity, ggd.b bVar, PayUIKitConfig payUIKitConfig);

    igd g(Activity activity, igd.b bVar, cdd cddVar);

    hgd h(Activity activity, PayUIKitConfig payUIKitConfig, hgd.b bVar, cdd cddVar);
}
