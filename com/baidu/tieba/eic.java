package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fkc;
import com.baidu.tieba.gkc;
import com.baidu.tieba.ygc;
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
public class eic implements ygc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bhc a;
    public PayFlowType b;
    public qic c;
    public qic d;

    /* loaded from: classes5.dex */
    public class a implements fkc.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;

        public a(eic eicVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eicVar, dialog};
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

        @Override // com.baidu.tieba.fkc.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ljc.a(this.a, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gkc.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ygc.b a;
        public final /* synthetic */ Dialog b;

        public b(eic eicVar, ygc.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eicVar, bVar, dialog};
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

        @Override // com.baidu.tieba.gkc.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ygc.b bVar = this.a;
                if (bVar != null) {
                    bVar.b();
                }
                ljc.a(this.b, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            }
        }
    }

    public eic(PayFlowType payFlowType, bhc bhcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payFlowType, bhcVar};
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
        this.a = bhcVar;
    }

    @Override // com.baidu.tieba.ygc
    public GiftBagsInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            qic qicVar = this.c;
            if (qicVar != null) {
                return qicVar.a();
            }
            return null;
        }
        return (GiftBagsInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ygc
    public boolean b(Activity activity, ygc.b bVar, ahc ahcVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, ahcVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showPayGiftDialog mGiftPackageData:" + this.d + " mPayFlowType:" + this.b);
            if (qic.b(this.d)) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but giftbag empty");
                return false;
            } else if (this.d.c()) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but hasShow");
                return false;
            } else {
                bhc bhcVar = this.a;
                if (bhcVar == null) {
                    RLog.error("PayCampaignManager", "showPayGiftDialog error mPayView null", new Object[0]);
                    return false;
                }
                gkc d = bhcVar.d(activity);
                d.setGiftBagsInfo(this.d.a());
                d.refreshView();
                this.d.d(true);
                d.setCallback(new b(this, bVar, h(activity, "", d, bVar, ahcVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ygc
    public boolean e(Activity activity, ygc.a aVar, ahc ahcVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, aVar, ahcVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showConfirmLeaveDialog mConfirmLeaveData:" + this.c + " mPayFlowType:" + this.b);
            if (qic.b(this.c)) {
                RLog.info("PayCampaignManager", "showConfirmLeaveDialog but giftbag empty");
                return false;
            } else if (this.c.c()) {
                RLog.info("PayCampaignManager", "showConfirmFinishDialog but hasShow");
                return false;
            } else {
                bhc bhcVar = this.a;
                if (bhcVar == null) {
                    RLog.error("PayCampaignManager", "showConfirmFinishDialog error mPayView null", new Object[0]);
                    return false;
                }
                fkc b2 = bhcVar.b(activity);
                b2.setGiftBagsInfo(this.c.a());
                b2.refreshView();
                this.c.d(true);
                b2.setCallback(new a(this, g(activity, "", b2, aVar, ahcVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ygc
    public void c(ViewGroup viewGroup, Activity activity) {
        ekc c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, activity) != null) || viewGroup == null) {
            return;
        }
        if (qic.b(this.c)) {
            viewGroup.removeAllViews();
            return;
        }
        bhc bhcVar = this.a;
        if (bhcVar != null && (c = bhcVar.c(activity)) != null) {
            viewGroup.removeAllViews();
            c.setGiftBagsInfo(this.c.a());
            viewGroup.addView(c.getContentView());
            c.refreshView();
        }
    }

    @Override // com.baidu.tieba.ygc
    public void d(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData- confirmLeaveData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.c = new qic(giftBagsInfo, false);
        }
    }

    @Override // com.baidu.tieba.ygc
    public void f(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateGiftPackageData packageData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.d = new qic(giftBagsInfo, false);
        }
    }

    public final Dialog g(Activity activity, String str, fkc fkcVar, ygc.a aVar, ahc ahcVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{activity, str, fkcVar, aVar, ahcVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createConfirmFinishDialog");
            ahcVar.m(absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            return skc.b.e(activity, str, fkcVar.getContentView(), new rhc(aVar), absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog h(Activity activity, String str, gkc gkcVar, ygc.b bVar, ahc ahcVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{activity, str, gkcVar, bVar, ahcVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createPayGiftDialog");
            ahcVar.m(absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            return skc.b.e(activity, str, gkcVar.getContentView(), new thc(bVar), absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }
}
