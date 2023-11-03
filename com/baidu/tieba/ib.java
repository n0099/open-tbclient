package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public String c;
    public boolean d;
    public boolean e;

    public ib() {
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

    public void a() {
        JSONObject b;
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || new Random().nextInt(100) > 20 || (b = b()) == null || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent("94", b.toString());
    }

    public JSONObject b() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        JSONException e;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", this.a);
                    jSONObject.put("resultCode", this.b);
                    jSONObject.put(GameAssistConstKt.RESULT_MODIFY_PWD_MSG, this.c);
                    int i2 = 1;
                    if (this.d) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    jSONObject.put("isHttps", i);
                    if (!this.e) {
                        i2 = 0;
                    }
                    jSONObject.put("isIpv6", i2);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    return jSONObject;
                }
            } catch (JSONException e3) {
                jSONObject = null;
                e = e3;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
