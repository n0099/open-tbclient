package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SignatureContent;
import tbclient.SignatureData;
/* loaded from: classes6.dex */
public class h8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignatureData signatureData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signatureData)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "signature_id", signatureData.signature_id);
            ktc.a(jSONObject, "fontKeyName", signatureData.fontKeyName);
            ktc.a(jSONObject, "fontColor", signatureData.fontColor);
            if (signatureData.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (SignatureContent signatureContent : signatureData.content) {
                    jSONArray.put(g8d.b(signatureContent));
                }
                ktc.a(jSONObject, "content", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
