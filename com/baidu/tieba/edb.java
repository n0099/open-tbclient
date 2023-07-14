package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ubcprocessor.UBCCloudConfigObserver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes5.dex */
public class edb implements UBCCloudConfigObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731910, "Lcom/baidu/tieba/edb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731910, "Lcom/baidu/tieba/edb;");
                return;
            }
        }
        a = AppConfig.isDebug();
    }

    public edb() {
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

    @Override // com.baidu.searchbox.ubcprocessor.UBCCloudConfigObserver
    public void onReceiveUbcCloudConfig(String str, JSONObject jSONObject) {
        String optString;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            if (a) {
                Log.d("YaLogConfigObserver", "receive YaLog ID config data: " + str);
            }
            if (TextUtils.isEmpty(str)) {
                if (a) {
                    Log.d("YaLogConfigObserver", "YaLog ID config data is null");
                    return;
                }
                return;
            }
            if (jSONObject == null) {
                optString = "0";
            } else {
                try {
                    optString = jSONObject.optString("version_asc");
                } catch (JSONException e) {
                    if (a) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            if (!"0".equals(optString)) {
                z = true;
            } else {
                z = false;
            }
            ((cdb) ServiceManager.getService(cdb.a)).b(new JSONObject(str), z);
        }
    }
}
