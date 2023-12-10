package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SignatureContent;
/* loaded from: classes6.dex */
public class h8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignatureContent signatureContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signatureContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", signatureContent.type);
            ltc.a(jSONObject, "text", signatureContent.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
