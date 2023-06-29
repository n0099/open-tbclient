package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.l2c;
import com.baidu.tieba.m2c;
import com.baidu.tieba.n2c;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes5.dex */
public interface fzb {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, czb czbVar);

    j2c b(Activity activity);

    i2c c(Activity activity);

    k2c d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, czb czbVar);

    l2c f(Activity activity, l2c.b bVar, PayUIKitConfig payUIKitConfig);

    n2c g(Activity activity, n2c.b bVar, hzb hzbVar);

    m2c h(Activity activity, PayUIKitConfig payUIKitConfig, m2c.b bVar, hzb hzbVar);
}
