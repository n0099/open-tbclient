package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nac;
import com.baidu.tieba.oac;
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
/* loaded from: classes6.dex */
public class h8c implements oac.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public oac c;
    public oac.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public f7c f;
    public boolean g;

    public h8c(Activity activity, boolean z, Dialog dialog, oac oacVar, oac.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, f7c f7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, oacVar, bVar, iPayCallback, f7cVar};
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
        this.c = oacVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = f7cVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.oac.a
    public void a(b9c b9cVar, x8c x8cVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, b9cVar, x8cVar, appCustomExpand) == null) {
            b9c b9cVar2 = new b9c(PayType.ALI_PAY_SIGN, b9cVar.b, b9cVar.c, b9cVar.d, b9cVar.e, b9cVar.f, b9cVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + b9cVar2.a + ", payAmount=" + x8cVar + ", alwaysConfirm=" + b9cVar.g);
            this.f.p(this.a, x8cVar, b9cVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.oac.a
    public void b(b9c b9cVar, x8c x8cVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b9cVar, x8cVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + b9cVar.a + ", payAmount=" + x8cVar);
            this.f.k(this.a, b9cVar, x8cVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.oac.a
    public void c(a9c a9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a9cVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + a9cVar);
            q9c.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            f7c f7cVar = this.f;
            Activity activity = this.a;
            nac.b bVar = a9cVar.b;
            f7cVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.oac.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = r9c.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            q9c.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.oac.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
