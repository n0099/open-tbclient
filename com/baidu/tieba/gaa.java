package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.aca;
import com.baidu.tieba.b9a;
import com.baidu.tieba.bca;
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
/* loaded from: classes4.dex */
public class gaa implements b9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d9a a;
    public PayFlowType b;
    public saa c;
    public saa d;

    /* loaded from: classes4.dex */
    public class a implements aca.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;

        public a(gaa gaaVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gaaVar, dialog};
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

        @Override // com.baidu.tieba.aca.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kba.a(this.a, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements bca.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b9a.b a;
        public final /* synthetic */ Dialog b;

        public b(gaa gaaVar, b9a.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gaaVar, bVar, dialog};
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

        @Override // com.baidu.tieba.bca.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b9a.b bVar = this.a;
                if (bVar != null) {
                    bVar.b();
                }
                kba.a(this.b, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            }
        }
    }

    public gaa(PayFlowType payFlowType, d9a d9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payFlowType, d9aVar};
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
        this.a = d9aVar;
    }

    @Override // com.baidu.tieba.b9a
    public GiftBagsInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            saa saaVar = this.c;
            if (saaVar != null) {
                return saaVar.a();
            }
            return null;
        }
        return (GiftBagsInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b9a
    public boolean b(Activity activity, b9a.b bVar, c9a c9aVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, c9aVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showPayGiftDialog mGiftPackageData:" + this.d + " mPayFlowType:" + this.b);
            if (this.b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (saa.b(this.d)) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but giftbag empty");
                return false;
            } else if (this.d.c()) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but hasShow");
                return false;
            } else {
                d9a d9aVar = this.a;
                if (d9aVar == null) {
                    RLog.error("PayCampaignManager", "showPayGiftDialog error mPayView null", new Object[0]);
                    return false;
                }
                bca d = d9aVar.d(activity);
                d.setGiftBagsInfo(this.d.a());
                d.refreshView();
                this.d.d(true);
                d.setCallback(new b(this, bVar, h(activity, "", d, bVar, c9aVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.b9a
    public boolean e(Activity activity, b9a.a aVar, c9a c9aVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, aVar, c9aVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showConfirmLeaveDialog mConfirmLeaveData:" + this.c + " mPayFlowType:" + this.b);
            if (this.b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (saa.b(this.c)) {
                RLog.info("PayCampaignManager", "showConfirmLeaveDialog but giftbag empty");
                return false;
            } else if (this.c.c()) {
                RLog.info("PayCampaignManager", "showConfirmFinishDialog but hasShow");
                return false;
            } else {
                d9a d9aVar = this.a;
                if (d9aVar == null) {
                    RLog.error("PayCampaignManager", "showConfirmFinishDialog error mPayView null", new Object[0]);
                    return false;
                }
                aca b2 = d9aVar.b(activity);
                b2.setGiftBagsInfo(this.c.a());
                b2.refreshView();
                this.c.d(true);
                b2.setCallback(new a(this, g(activity, "", b2, aVar, c9aVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.b9a
    public void c(ViewGroup viewGroup, Activity activity) {
        zba c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, activity) != null) || viewGroup == null) {
            return;
        }
        if (saa.b(this.c)) {
            viewGroup.removeAllViews();
            return;
        }
        d9a d9aVar = this.a;
        if (d9aVar != null && (c = d9aVar.c(activity)) != null) {
            viewGroup.removeAllViews();
            c.setGiftBagsInfo(this.c.a());
            viewGroup.addView(c.getContentView());
            c.refreshView();
        }
    }

    @Override // com.baidu.tieba.b9a
    public void d(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData- confirmLeaveData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.c = new saa(giftBagsInfo, false);
        }
    }

    @Override // com.baidu.tieba.b9a
    public void f(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateGiftPackageData packageData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.d = new saa(giftBagsInfo, false);
        }
    }

    public final Dialog g(Activity activity, String str, aca acaVar, b9a.a aVar, c9a c9aVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{activity, str, acaVar, aVar, c9aVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createConfirmFinishDialog");
            c9aVar.k(absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            return lca.b.e(activity, str, acaVar.getContentView(), new t9a(aVar), absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog h(Activity activity, String str, bca bcaVar, b9a.b bVar, c9a c9aVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{activity, str, bcaVar, bVar, c9aVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createPayGiftDialog");
            c9aVar.k(absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            return lca.b.e(activity, str, bcaVar.getContentView(), new v9a(bVar), absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }
}
