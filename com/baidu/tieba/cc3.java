package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Service
/* loaded from: classes5.dex */
public class cc3 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "BDWallet" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return null;
        }
        return (Class) invokeL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947669910, "Lcom/baidu/tieba/cc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947669910, "Lcom/baidu/tieba/cc3;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public cc3() {
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

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            h82.b("SwanWalletDispatcher", "entity uri = ", unitedSchemeEntity.getUri());
            h82.i("SwanWalletDispatcher", "start UnitedSchemeWalletDispatcher");
            String path = unitedSchemeEntity.getPath(false);
            if (TextUtils.isEmpty(path)) {
                if (!unitedSchemeEntity.isOnlyVerify()) {
                    UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
                }
                h82.k("SwanWalletDispatcher", "Error: uri action is null.");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                return false;
            } else if (unitedSchemeEntity.isOnlyVerify()) {
                h82.k("SwanWalletDispatcher", "Error: is only verify.");
                return true;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    h82.k("SwanWalletDispatcher", "Error: params is null.");
                    return false;
                }
                String optString = optParamsAsJo.optString("orderInfo");
                String optString2 = optParamsAsJo.optString("version");
                String optString3 = optParamsAsJo.optString("cb");
                hb3 M = hb3.M();
                if (M == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    h82.k("SwanWalletDispatcher", "Error: swan app is null.");
                    return false;
                } else if (M.w() == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    h82.k("SwanWalletDispatcher", "Error: swan activity is null.");
                    return false;
                } else {
                    String optString4 = optParamsAsJo.optString("from");
                    if (TextUtils.isEmpty(optString4)) {
                        optString4 = "api";
                    }
                    String str = optString4;
                    w33 w33Var = new w33(M, unitedSchemeEntity, callbackHandler, optString2, M.O(), optString3);
                    if ("requestPayment".equals(path)) {
                        h82.i("SwanWalletDispatcher", "start PAYMENT");
                        ai3.K("baiduqianbao", "create", 0);
                        return w33Var.B("mapp_request_duxiaoman", optString, str);
                    } else if ("requestAliPayment".equals(path)) {
                        h82.i("SwanWalletDispatcher", "start ALI PAYMENT");
                        ai3.K("alipay", "create", 0);
                        return w33Var.B("mapp_request_alipayment", optString, str);
                    } else if ("requestPolymerPayment".equals(path)) {
                        h82.i("SwanWalletDispatcher", "start POLYMER PAYMENT");
                        ai3.K("nuomi", "create", 0);
                        return w33Var.J(optString, optParamsAsJo);
                    } else if (TextUtils.equals("requestWeChatPayment", path)) {
                        h82.i("SwanWalletDispatcher", "start WECHAT HTML5 PAYMENT");
                        ai3.K("wechatH5Action", "create", 0);
                        return w33Var.B("mapp_request_wechatpayment", optString, str);
                    } else {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        return false;
                    }
                }
            }
        }
        return invokeLLL.booleanValue;
    }
}
