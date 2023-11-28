package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MaskLayerText;
/* loaded from: classes5.dex */
public class a5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MaskLayerText maskLayerText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, maskLayerText)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "text", maskLayerText.text);
            ltc.a(jSONObject, "schema", maskLayerText.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
