package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.kbc;
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
public interface b8c {
    void a(Activity activity, t9c t9cVar, List<PayWayInfo> list, String str, PaySplitOrderViewSource paySplitOrderViewSource, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void b(boolean z);

    boolean c(Activity activity, AbsViewEventHandler absViewEventHandler);

    void d(Activity activity, kbc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void e(int i, String str, PayCallBackBean payCallBackBean);

    void g(CancelType cancelType, AbsViewEventHandler absViewEventHandler);

    e8c h();

    void j(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams);

    void k(Activity activity, x9c x9cVar, t9c t9cVar, Dialog dialog, dbc dbcVar, AppCustomExpand appCustomExpand, kbc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void l(PayFinishInfo payFinishInfo);

    void m(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType);

    void n(Activity activity, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void p(Activity activity, t9c t9cVar, x9c x9cVar, Dialog dialog, dbc dbcVar, AppCustomExpand appCustomExpand, kbc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void q(Activity activity, String str);

    void r(ebc ebcVar, Dialog dialog);

    void refreshWindow(WindowParams windowParams);

    boolean s(Activity activity, kbc kbcVar, AbsViewEventHandler absViewEventHandler);

    void t(Activity activity, t9c t9cVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void u(Activity activity);

    PayDialogType v();
}
