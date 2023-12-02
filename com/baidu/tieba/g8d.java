package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SignatureContent;
/* loaded from: classes6.dex */
public class g8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignatureContent signatureContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signatureContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", signatureContent.type);
            ktc.a(jSONObject, "text", signatureContent.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
