package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;

    public fm3() {
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

    @NonNull
    public static fm3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            fm3 fm3Var = new fm3();
            if (jSONObject == null) {
                return fm3Var;
            }
            fm3Var.a = jSONObject.optString("SSID");
            fm3Var.b = jSONObject.optString("BSSID");
            fm3Var.e = jSONObject.optBoolean("maunal");
            fm3Var.d = jSONObject.optString(com.baidu.sapi2.views.logindialog.view.a.m);
            fm3Var.c = jSONObject.optString("identity");
            return fm3Var;
        }
        return (fm3) invokeL.objValue;
    }
}
