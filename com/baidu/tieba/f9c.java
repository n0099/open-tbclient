package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gbc;
import com.baidu.tieba.hbc;
import com.baidu.tieba.z7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class f9c implements z7c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c8c a;
    public PayFlowType b;
    public r9c c;
    public r9c d;

    /* loaded from: classes5.dex */
    public class a implements gbc.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;

        public a(f9c f9cVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f9cVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dialog;
        }

        @Override // com.baidu.tieba.gbc.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mac.a(this.a, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements hbc.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z7c.b a;
        public final /* synthetic */ Dialog b;

        public b(f9c f9cVar, z7c.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f9cVar, bVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.b = dialog;
        }

        @Override // com.baidu.tieba.hbc.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z7c.b bVar = this.a;
                if (bVar != null) {
                    bVar.b();
                }
                mac.a(this.b, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            }
        }
    }

    public f9c(PayFlowType payFlowType, c8c c8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payFlowType, c8cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayCampaignManager", "create PayCampaignManager:" + this);
        this.b = payFlowType;
        this.a = c8cVar;
    }

    @Override // com.baidu.tieba.z7c
    public GiftBagsInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            r9c r9cVar = this.c;
            if (r9cVar != null) {
                return r9cVar.a();
            }
            return null;
        }
        return (GiftBagsInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z7c
    public boolean b(Activity activity, z7c.b bVar, b8c b8cVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, b8cVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showPayGiftDialog mGiftPackageData:" + this.d + " mPayFlowType:" + this.b);
            if (r9c.b(this.d)) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but giftbag empty");
                return false;
            } else if (this.d.c()) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but hasShow");
                return false;
            } else {
                c8c c8cVar = this.a;
                if (c8cVar == null) {
                    RLog.error("PayCampaignManager", "showPayGiftDialog error mPayView null", new Object[0]);
                    return false;
                }
                hbc d = c8cVar.d(activity);
                d.setGiftBagsInfo(this.d.a());
                d.refreshView();
                this.d.d(true);
                d.setCallback(new b(this, bVar, h(activity, "", d, bVar, b8cVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.z7c
    public boolean e(Activity activity, z7c.a aVar, b8c b8cVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, aVar, b8cVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showConfirmLeaveDialog mConfirmLeaveData:" + this.c + " mPayFlowType:" + this.b);
            if (r9c.b(this.c)) {
                RLog.info("PayCampaignManager", "showConfirmLeaveDialog but giftbag empty");
                return false;
            } else if (this.c.c()) {
                RLog.info("PayCampaignManager", "showConfirmFinishDialog but hasShow");
                return false;
            } else {
                c8c c8cVar = this.a;
                if (c8cVar == null) {
                    RLog.error("PayCampaignManager", "showConfirmFinishDialog error mPayView null", new Object[0]);
                    return false;
                }
                gbc b2 = c8cVar.b(activity);
                b2.setGiftBagsInfo(this.c.a());
                b2.refreshView();
                this.c.d(true);
                b2.setCallback(new a(this, g(activity, "", b2, aVar, b8cVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.z7c
    public void c(ViewGroup viewGroup, Activity activity) {
        fbc c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, activity) != null) || viewGroup == null) {
            return;
        }
        if (r9c.b(this.c)) {
            viewGroup.removeAllViews();
            return;
        }
        c8c c8cVar = this.a;
        if (c8cVar != null && (c = c8cVar.c(activity)) != null) {
            viewGroup.removeAllViews();
            c.setGiftBagsInfo(this.c.a());
            viewGroup.addView(c.getContentView());
            c.refreshView();
        }
    }

    @Override // com.baidu.tieba.z7c
    public void d(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData- confirmLeaveData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.c = new r9c(giftBagsInfo, false);
        }
    }

    @Override // com.baidu.tieba.z7c
    public void f(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateGiftPackageData packageData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.d = new r9c(giftBagsInfo, false);
        }
    }

    public final Dialog g(Activity activity, String str, gbc gbcVar, z7c.a aVar, b8c b8cVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{activity, str, gbcVar, aVar, b8cVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createConfirmFinishDialog");
            b8cVar.m(absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            return tbc.b.e(activity, str, gbcVar.getContentView(), new s8c(aVar), absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog h(Activity activity, String str, hbc hbcVar, z7c.b bVar, b8c b8cVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{activity, str, hbcVar, bVar, b8cVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createPayGiftDialog");
            b8cVar.m(absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            return tbc.b.e(activity, str, hbcVar.getContentView(), new u8c(bVar), absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }
}
