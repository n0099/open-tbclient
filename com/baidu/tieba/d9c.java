package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jbc;
import com.baidu.tieba.kbc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class d9c implements kbc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public kbc c;
    public kbc.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public b8c f;
    public boolean g;

    public d9c(Activity activity, boolean z, Dialog dialog, kbc kbcVar, kbc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, b8c b8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, kbcVar, bVar, iPayCallback, b8cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayWayViewCallback", "create PayWayViewCallback");
        this.a = activity;
        this.b = dialog;
        this.c = kbcVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = b8cVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.kbc.a
    public void a(x9c x9cVar, t9c t9cVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, x9cVar, t9cVar, appCustomExpand) == null) {
            x9c x9cVar2 = new x9c(PayType.ALI_PAY_SIGN, x9cVar.b, x9cVar.c, x9cVar.d, x9cVar.e, x9cVar.f, x9cVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + x9cVar2.a + ", payAmount=" + t9cVar + ", alwaysConfirm=" + x9cVar.g);
            this.f.p(this.a, t9cVar, x9cVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.kbc.a
    public void b(x9c x9cVar, t9c t9cVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x9cVar, t9cVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + x9cVar.a + ", payAmount=" + t9cVar);
            this.f.k(this.a, x9cVar, t9cVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.kbc.a
    public void c(w9c w9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w9cVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + w9cVar);
            mac.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            b8c b8cVar = this.f;
            Activity activity = this.a;
            jbc.b bVar = w9cVar.b;
            b8cVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.kbc.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = nac.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            mac.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.kbc.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
