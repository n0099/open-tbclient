package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SignatureContent;
import tbclient.SignatureData;
/* loaded from: classes5.dex */
public class e3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignatureData signatureData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signatureData)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "signature_id", signatureData.signature_id);
            poc.a(jSONObject, "fontKeyName", signatureData.fontKeyName);
            poc.a(jSONObject, "fontColor", signatureData.fontColor);
            if (signatureData.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (SignatureContent signatureContent : signatureData.content) {
                    jSONArray.put(d3d.b(signatureContent));
                }
                poc.a(jSONObject, "content", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
