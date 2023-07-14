package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jbc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class b9c implements jbc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public IPayCallback<CurrencyChargeMessage> c;
    public b8c d;
    public jbc.b e;

    public b9c(Activity activity, Dialog dialog, jbc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, b8c b8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dialog, bVar, iPayCallback, b8cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = dialog;
        this.c = iPayCallback;
        this.d = b8cVar;
        this.e = bVar;
    }

    @Override // com.baidu.tieba.jbc.a
    public void a(t9c t9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t9cVar) == null) {
            RLog.info("PaySplitOrderViewCallback", "toPayWayDialog amount:" + t9cVar);
            mac.a(this.b, PayDialogType.PAY_SPLIT_ORDER_DIALOG);
            jbc.b bVar = this.e;
            IYYPayAmountView.ViewParams viewParams = bVar.f;
            viewParams.splitOrderPayScene = "1";
            this.d.t(this.a, t9cVar, bVar.d, bVar.e, viewParams, this.c);
        }
    }

    @Override // com.baidu.tieba.jbc.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PaySplitOrderViewCallback", "toInputNumberDialog");
            mac.a(this.b, PayDialogType.PAY_SPLIT_ORDER_DIALOG);
            b8c b8cVar = this.d;
            Activity activity = this.a;
            jbc.b bVar = this.e;
            b8cVar.n(activity, bVar.d, bVar.e, bVar.f, this.c);
        }
    }

    @Override // com.baidu.tieba.jbc.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            PaySplitOrderViewSource paySplitOrderViewSource = this.e.h;
            if (paySplitOrderViewSource == PaySplitOrderViewSource.SOURCE_FROM_INPUAT_DIALOG) {
                RLog.info("PaySplitOrderViewCallback", "onRefreshViewFail code:" + i + " failReason:" + str + " source:" + paySplitOrderViewSource + " prepareShowPayWayDialog");
                mac.a(this.b, PayDialogType.PAY_SPLIT_ORDER_DIALOG);
                b8c b8cVar = this.d;
                Activity activity = this.a;
                jbc.b bVar = this.e;
                b8cVar.t(activity, bVar.a, bVar.d, bVar.e, bVar.f, this.c);
                return;
            }
            RLog.info("PaySplitOrderViewCallback", "onRefreshViewFail code:" + i + " failReason:" + str + " source:" + paySplitOrderViewSource + " interruptePayFlow");
            mac.b(this.b, PayDialogType.PAY_SPLIT_ORDER_DIALOG);
        }
    }
}
