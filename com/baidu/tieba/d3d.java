package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SignatureContent;
/* loaded from: classes5.dex */
public class d3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignatureContent signatureContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signatureContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", signatureContent.type);
            poc.a(jSONObject, "text", signatureContent.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
