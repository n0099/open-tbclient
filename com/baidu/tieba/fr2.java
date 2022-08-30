package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fr2 extends cr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final fr2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-795266075, "Lcom/baidu/tieba/fr2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-795266075, "Lcom/baidu/tieba/fr2$b;");
                    return;
                }
            }
            a = new fr2(null);
        }
    }

    public /* synthetic */ fr2(a aVar) {
        this();
    }

    public static fr2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (fr2) invokeV.objValue;
    }

    public boolean h(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pMSAppInfo)) == null) {
            JSONObject d = d(pMSAppInfo);
            if (d == null || d.length() <= 0) {
                return false;
            }
            boolean optBoolean = d.optBoolean("is_opti");
            if (cr2.c) {
                Log.d("SwanAppExtInfo", "is opt pkg  - " + optBoolean);
            }
            return optBoolean;
        }
        return invokeL.booleanValue;
    }

    public boolean i(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo)) == null) {
            JSONObject b2 = b(pMSAppInfo);
            if (b2 != null && b2.has(PrefetchEvent.MODULE)) {
                z = b2.optBoolean(PrefetchEvent.MODULE);
            } else {
                JSONObject a2 = a(pMSAppInfo);
                z = a2 != null && a2.optBoolean(PrefetchEvent.MODULE);
            }
            if (cr2.c) {
                Log.d("SwanAppExtInfo", "is prefetch on - " + z);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean j(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pMSAppInfo)) == null) ? TextUtils.equals(c(pMSAppInfo), "1") : invokeL.booleanValue;
    }

    public JSONObject k(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pMSAppInfo)) == null) {
            JSONObject b2 = b(pMSAppInfo);
            if (b2 == null || b2.length() <= 0) {
                return null;
            }
            return b2.optJSONObject("topPages");
        }
        return (JSONObject) invokeL.objValue;
    }

    public fr2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
