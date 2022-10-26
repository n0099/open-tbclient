package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
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
/* loaded from: classes4.dex */
public class h43 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "BDWallet" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class getSubDispatcher(String str) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947773698, "Lcom/baidu/tieba/h43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947773698, "Lcom/baidu/tieba/h43;");
                return;
            }
        }
        boolean z = wj1.a;
    }

    public h43() {
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
            m02.b("SwanWalletDispatcher", "entity uri = ", unitedSchemeEntity.getUri());
            m02.i("SwanWalletDispatcher", "start UnitedSchemeWalletDispatcher");
            String path = unitedSchemeEntity.getPath(false);
            if (TextUtils.isEmpty(path)) {
                if (!unitedSchemeEntity.isOnlyVerify()) {
                    UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
                }
                m02.k("SwanWalletDispatcher", "Error: uri action is null.");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                return false;
            } else if (unitedSchemeEntity.isOnlyVerify()) {
                m02.k("SwanWalletDispatcher", "Error: is only verify.");
                return true;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    m02.k("SwanWalletDispatcher", "Error: params is null.");
                    return false;
                }
                String optString = optParamsAsJo.optString("orderInfo");
                String optString2 = optParamsAsJo.optString("version");
                String optString3 = optParamsAsJo.optString("cb");
                m33 M = m33.M();
                if (M == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    m02.k("SwanWalletDispatcher", "Error: swan app is null.");
                    return false;
                } else if (M.w() == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    m02.k("SwanWalletDispatcher", "Error: swan activity is null.");
                    return false;
                } else {
                    String optString4 = optParamsAsJo.optString("from");
                    if (TextUtils.isEmpty(optString4)) {
                        optString4 = "api";
                    }
                    String str = optString4;
                    bw2 bw2Var = new bw2(M, unitedSchemeEntity, callbackHandler, optString2, M.O(), optString3);
                    if ("requestPayment".equals(path)) {
                        m02.i("SwanWalletDispatcher", "start PAYMENT");
                        fa3.K("baiduqianbao", "create", 0);
                        return bw2Var.C("mapp_request_duxiaoman", optString, str);
                    } else if ("requestAliPayment".equals(path)) {
                        m02.i("SwanWalletDispatcher", "start ALI PAYMENT");
                        fa3.K("alipay", "create", 0);
                        return bw2Var.C("mapp_request_alipayment", optString, str);
                    } else if ("requestPolymerPayment".equals(path)) {
                        m02.i("SwanWalletDispatcher", "start POLYMER PAYMENT");
                        fa3.K("nuomi", "create", 0);
                        return bw2Var.K(optString, optParamsAsJo);
                    } else if (TextUtils.equals("requestWeChatPayment", path)) {
                        m02.i("SwanWalletDispatcher", "start WECHAT HTML5 PAYMENT");
                        fa3.K("wechatH5Action", "create", 0);
                        return bw2Var.C("mapp_request_wechatpayment", optString, str);
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
