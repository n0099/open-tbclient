package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes4.dex */
public interface g7b {
    void a(Activity activity, y8b y8bVar, List<PayWayInfo> list, String str, PaySplitOrderViewSource paySplitOrderViewSource, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void b(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void c(int i, String str, PayCallBackBean payCallBackBean);

    void d(CancelType cancelType, AbsViewEventHandler absViewEventHandler);

    j7b e();

    void f(Activity activity, b9b b9bVar, y8b y8bVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void g(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams);

    void j(PayFinishInfo payFinishInfo);

    void k(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType);

    void l(Activity activity, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void m(Activity activity, y8b y8bVar, b9b b9bVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void n();

    void o(Activity activity, String str);

    boolean p(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler);

    void q(cab cabVar, Dialog dialog);

    void refreshWindow(WindowParams windowParams);

    void release();

    boolean s(Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler);

    void t(Activity activity, y8b y8bVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void u(Activity activity);

    PayDialogType v();
}
