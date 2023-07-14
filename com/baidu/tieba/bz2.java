package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public CallbackHandler a;
    public JSONObject b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947662191, "Lcom/baidu/tieba/bz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947662191, "Lcom/baidu/tieba/bz2;");
                return;
            }
        }
        c = fs1.a;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return UnitedSchemeUtility.isInvokedFromSwanGame(this.a);
        }
        return invokeV.booleanValue;
    }

    public bz2(CallbackHandler callbackHandler, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callbackHandler, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = callbackHandler;
        this.b = jSONObject;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            b(str, null);
        }
    }

    public void b(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) != null) || this.b == null) {
            return;
        }
        JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
        this.a.handleSchemeDispatchCallback(this.b.optString(str), wrapCallbackParamsWithEncode.toString());
        if (c) {
            Log.d("AudioStatusCallback", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                if (c) {
                    Log.d("AudioStatusCallback", "Audio Callback is Null");
                    return;
                }
                return;
            }
            try {
                this.b = new JSONObject(str);
            } catch (JSONException e) {
                bj3.b("audio", 2009, "update json exception", -1, "");
                yy2.c("AudioStatusCallback", "#setCallbacks error", e);
            }
        }
    }
}
