package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.wallet.YYPayManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h48 implements ThirdPartWxRechargeService {
    public static /* synthetic */ Interceptable $ic;
    public static BroadcastReceiver b;
    public transient /* synthetic */ FieldHolder $fh;
    public IWXAPI a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947773853, "Lcom/baidu/tieba/h48;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947773853, "Lcom/baidu/tieba/h48;");
        }
    }

    /* loaded from: classes4.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h48 this$0;
        public final /* synthetic */ ThirdPartWxRechargeService.WxPayType val$wxPayType;

        public a(h48 h48Var, ThirdPartWxRechargeService.WxPayType wxPayType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h48Var, wxPayType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = h48Var;
            this.val$wxPayType = wxPayType;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                intent.getExtras();
                if (this.val$wxPayType instanceof ThirdPartWxRechargeService.WxPayType.WxPayYYLive) {
                    str = "wx_pay_result";
                } else {
                    str = "yy_wx_pay_result";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_CODE, Integer.valueOf(intent.getExtras().getInt("errorCode", -1)));
                hashMap.put(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_STR, intent.getExtras().getString("errorMsg"));
                LiveNPSPluginManager.getInstance().dispatchHostEvent(TbadkCoreApplication.getInst().getContext(), str, hashMap);
            }
        }
    }

    public h48() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService
    public void initWx() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a == null) {
            this.a = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService
    public boolean isWxInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a == null) {
                this.a = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
            }
            return this.a.isWXAppInstalled();
        }
        return invokeV.booleanValue;
    }

    public final PayReq a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            PayReq payReq = new PayReq();
            payReq.appId = jSONObject.optString("appid");
            payReq.partnerId = jSONObject.optString("partnerid");
            payReq.prepayId = jSONObject.optString("prepayid");
            payReq.packageValue = jSONObject.optString("package");
            payReq.nonceStr = jSONObject.optString("noncestr");
            payReq.timeStamp = jSONObject.optString("timestamp");
            payReq.sign = jSONObject.optString("sign");
            payReq.extData = "YY";
            return payReq;
        }
        return (PayReq) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService
    public void wxRecharge(String str, ThirdPartWxRechargeService.WxPayType wxPayType) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wxPayType) == null) {
            try {
                if (this.a == null) {
                    this.a = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
                }
                PayReq a2 = a(new JSONObject(str));
                this.a.registerApp(a2.appId);
                if (!this.a.sendReq(a2)) {
                    if (wxPayType instanceof ThirdPartWxRechargeService.WxPayType.WxPayYYLive) {
                        str2 = "wx_pay_result";
                    } else {
                        str2 = "yy_wx_pay_result";
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_CODE, 6);
                    hashMap.put(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_STR, "wx_start_failed");
                    LiveNPSPluginManager.getInstance().dispatchHostEvent(TbadkCoreApplication.getInst().getContext(), str2, hashMap);
                }
                if (b != null) {
                    TbadkCoreApplication.getInst().unregisterReceiver(b);
                }
                b = new a(this, wxPayType);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("WXPayResult");
                TbadkCoreApplication.getInst().registerReceiver(b, intentFilter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
