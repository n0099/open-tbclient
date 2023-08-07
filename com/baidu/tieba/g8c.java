package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mac;
import com.baidu.tieba.nac;
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
public class g8c implements nac.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public nac c;
    public nac.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public e7c f;
    public boolean g;

    public g8c(Activity activity, boolean z, Dialog dialog, nac nacVar, nac.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, e7c e7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, nacVar, bVar, iPayCallback, e7cVar};
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
        this.c = nacVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = e7cVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.nac.a
    public void a(a9c a9cVar, w8c w8cVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, a9cVar, w8cVar, appCustomExpand) == null) {
            a9c a9cVar2 = new a9c(PayType.ALI_PAY_SIGN, a9cVar.b, a9cVar.c, a9cVar.d, a9cVar.e, a9cVar.f, a9cVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + a9cVar2.a + ", payAmount=" + w8cVar + ", alwaysConfirm=" + a9cVar.g);
            this.f.p(this.a, w8cVar, a9cVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.nac.a
    public void b(a9c a9cVar, w8c w8cVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a9cVar, w8cVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + a9cVar.a + ", payAmount=" + w8cVar);
            this.f.k(this.a, a9cVar, w8cVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.nac.a
    public void c(z8c z8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z8cVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + z8cVar);
            p9c.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            e7c e7cVar = this.f;
            Activity activity = this.a;
            mac.b bVar = z8cVar.b;
            e7cVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.nac.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = q9c.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            p9c.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.nac.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
