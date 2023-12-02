package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ShakeAdSwitch;
/* loaded from: classes5.dex */
public class b8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ShakeAdSwitch shakeAdSwitch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, shakeAdSwitch)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "is_show", shakeAdSwitch.is_show);
            ktc.a(jSONObject, "title", shakeAdSwitch.title);
            ktc.a(jSONObject, "desc", shakeAdSwitch.desc);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
