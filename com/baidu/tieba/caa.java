package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dca;
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
/* loaded from: classes3.dex */
public class caa implements dca.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public IPayCallback<CurrencyChargeMessage> c;
    public c9a d;
    public dca.b e;

    public caa(Activity activity, Dialog dialog, dca.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, c9a c9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dialog, bVar, iPayCallback, c9aVar};
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
        this.d = c9aVar;
        this.e = bVar;
    }

    @Override // com.baidu.tieba.dca.a
    public void a(uaa uaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uaaVar) == null) {
            RLog.info("PaySplitOrderViewCallback", "toPayWayDialog amount:" + uaaVar);
            kba.a(this.b, PayDialogType.PAY_SPLIT_ORDER_DIALOG);
            dca.b bVar = this.e;
            IYYPayAmountView.ViewParams viewParams = bVar.f;
            viewParams.splitOrderPayScene = "1";
            this.d.t(this.a, uaaVar, bVar.d, bVar.e, viewParams, this.c);
        }
    }

    @Override // com.baidu.tieba.dca.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PaySplitOrderViewCallback", "toInputNumberDialog");
            kba.a(this.b, PayDialogType.PAY_SPLIT_ORDER_DIALOG);
            c9a c9aVar = this.d;
            Activity activity = this.a;
            dca.b bVar = this.e;
            c9aVar.l(activity, bVar.d, bVar.e, bVar.f, this.c);
        }
    }

    @Override // com.baidu.tieba.dca.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            PaySplitOrderViewSource paySplitOrderViewSource = this.e.h;
            if (paySplitOrderViewSource == PaySplitOrderViewSource.SOURCE_FROM_INPUAT_DIALOG) {
                RLog.info("PaySplitOrderViewCallback", "onRefreshViewFail code:" + i + " failReason:" + str + " source:" + paySplitOrderViewSource + " prepareShowPayWayDialog");
                kba.a(this.b, PayDialogType.PAY_SPLIT_ORDER_DIALOG);
                c9a c9aVar = this.d;
                Activity activity = this.a;
                dca.b bVar = this.e;
                c9aVar.t(activity, bVar.a, bVar.d, bVar.e, bVar.f, this.c);
                return;
            }
            RLog.info("PaySplitOrderViewCallback", "onRefreshViewFail code:" + i + " failReason:" + str + " source:" + paySplitOrderViewSource + " interruptePayFlow");
            kba.b(this.b, PayDialogType.PAY_SPLIT_ORDER_DIALOG);
        }
    }
}
