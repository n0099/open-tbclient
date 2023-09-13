package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.jkc;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public interface ahc {
    void a(Activity activity, sic sicVar, List<PayWayInfo> list, String str, PaySplitOrderViewSource paySplitOrderViewSource, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void b(boolean z);

    boolean c(Activity activity, AbsViewEventHandler absViewEventHandler);

    void d(Activity activity, jkc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void e(int i, String str, PayCallBackBean payCallBackBean);

    void g(CancelType cancelType, AbsViewEventHandler absViewEventHandler);

    dhc h();

    void j(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams);

    void k(Activity activity, wic wicVar, sic sicVar, Dialog dialog, ckc ckcVar, AppCustomExpand appCustomExpand, jkc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void l(PayFinishInfo payFinishInfo);

    void m(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType);

    void n(Activity activity, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void p(Activity activity, sic sicVar, wic wicVar, Dialog dialog, ckc ckcVar, AppCustomExpand appCustomExpand, jkc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void q(Activity activity, String str);

    void r(dkc dkcVar, Dialog dialog);

    void refreshWindow(WindowParams windowParams);

    boolean s(Activity activity, jkc jkcVar, AbsViewEventHandler absViewEventHandler);

    void t(Activity activity, sic sicVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void u(Activity activity);

    PayDialogType v();
}
