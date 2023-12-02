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
/* loaded from: classes6.dex */
public class hz2 extends vy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "PaymentPanelApi" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947840937, "Lcom/baidu/tieba/hz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947840937, "Lcom/baidu/tieba/hz2;");
                return;
            }
        }
        f = vm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz2(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public ly1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#setPaymentInfo", false);
            if (k63.c0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new ly1(1001, "swan app is null");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new ly1(202, "cb is empty");
            }
            String optString2 = jSONObject.optString("componentId");
            if (TextUtils.isEmpty(optString2)) {
                return new ly1(202, "empty componentId");
            }
            String optString3 = jSONObject.optString("chosenChannel");
            if (TextUtils.isEmpty(optString3)) {
                return new ly1(202, "empty chosenChannel");
            }
            PaymentPanelManager.z().J(this, optString2, optString3, optString);
            return ly1.f();
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#chooseCoupon", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new ly1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan activity is null");
                }
                return new ly1(1001, "swan activity is null");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new ly1(202, "cb is empty");
            }
            String optString2 = jSONObject.optString("componentId");
            if (TextUtils.isEmpty(optString2)) {
                return new ly1(202, "empty componentId");
            }
            String optString3 = jSONObject.optString("appKey");
            if (TextUtils.isEmpty(optString3)) {
                return new ly1(202, "empty appKey");
            }
            String optString4 = jSONObject.optString("totalAmount");
            if (TextUtils.isEmpty(optString4)) {
                return new ly1(202, "empty totalAmount");
            }
            PaymentPanelManager.z().s(this, w, optString2, optString3, optString4, optString);
            return ly1.f();
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r("#getPaymentInfo", false);
            if (k63.c0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: null swan runtime");
                }
                return new ly1(1001, "swan app is null");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new ly1(202, "cb is empty");
            }
            String optString2 = jSONObject.optString("componentId");
            if (TextUtils.isEmpty(optString2)) {
                return new ly1(202, "empty componentId");
            }
            String optString3 = jSONObject.optString("dealId");
            if (TextUtils.isEmpty(optString3)) {
                return new ly1(202, "empty dealId");
            }
            String optString4 = jSONObject.optString("appKey");
            if (TextUtils.isEmpty(optString4)) {
                return new ly1(202, "empty appKey");
            }
            String optString5 = jSONObject.optString("totalAmount");
            if (TextUtils.isEmpty(optString5)) {
                return new ly1(202, "empty totalAmount");
            }
            PaymentPanelManager.z().C(this, optString2, optString3, optString4, optString5, optString);
            return ly1.f();
        }
        return (ly1) invokeL.objValue;
    }
}
