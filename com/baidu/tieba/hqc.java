package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BaseTextColor;
/* loaded from: classes6.dex */
public class hqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BaseTextColor baseTextColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baseTextColor)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", baseTextColor.type);
            qoc.a(jSONObject, "day", baseTextColor.day);
            qoc.a(jSONObject, "night", baseTextColor.night);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
