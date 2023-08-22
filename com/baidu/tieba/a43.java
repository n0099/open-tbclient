package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a43 extends o33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PaymentPanelApi" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947565161, "Lcom/baidu/tieba/a43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947565161, "Lcom/baidu/tieba/a43;");
                return;
            }
        }
        f = nr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a43(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public d32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#chooseCoupon", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new d32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan activity is null");
                }
                return new d32(1001, "swan activity is null");
            }
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d32(202, "cb is empty");
            }
            String optString2 = jSONObject.optString("componentId");
            if (TextUtils.isEmpty(optString2)) {
                return new d32(202, "empty componentId");
            }
            String optString3 = jSONObject.optString("appKey");
            if (TextUtils.isEmpty(optString3)) {
                return new d32(202, "empty appKey");
            }
            String optString4 = jSONObject.optString("totalAmount");
            if (TextUtils.isEmpty(optString4)) {
                return new d32(202, "empty totalAmount");
            }
            PaymentPanelManager.z().s(this, w, optString2, optString3, optString4, optString);
            return d32.f();
        }
        return (d32) invokeL.objValue;
    }

    public d32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getPaymentInfo", false);
            if (db3.b0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: null swan runtime");
                }
                return new d32(1001, "swan app is null");
            }
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d32(202, "cb is empty");
            }
            String optString2 = jSONObject.optString("componentId");
            if (TextUtils.isEmpty(optString2)) {
                return new d32(202, "empty componentId");
            }
            String optString3 = jSONObject.optString("dealId");
            if (TextUtils.isEmpty(optString3)) {
                return new d32(202, "empty dealId");
            }
            String optString4 = jSONObject.optString("appKey");
            if (TextUtils.isEmpty(optString4)) {
                return new d32(202, "empty appKey");
            }
            String optString5 = jSONObject.optString("totalAmount");
            if (TextUtils.isEmpty(optString5)) {
                return new d32(202, "empty totalAmount");
            }
            PaymentPanelManager.z().C(this, optString2, optString3, optString4, optString5, optString);
            return d32.f();
        }
        return (d32) invokeL.objValue;
    }

    public d32 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#setPaymentInfo", false);
            if (db3.b0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new d32(1001, "swan app is null");
            }
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d32(202, "cb is empty");
            }
            String optString2 = jSONObject.optString("componentId");
            if (TextUtils.isEmpty(optString2)) {
                return new d32(202, "empty componentId");
            }
            String optString3 = jSONObject.optString("chosenChannel");
            if (TextUtils.isEmpty(optString3)) {
                return new d32(202, "empty chosenChannel");
            }
            PaymentPanelManager.z().J(this, optString2, optString3, optString);
            return d32.f();
        }
        return (d32) invokeL.objValue;
    }
}
