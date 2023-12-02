package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ConsumeInfo;
/* loaded from: classes5.dex */
public class cwc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ConsumeInfo consumeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, consumeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "icon", consumeInfo.icon);
            ktc.a(jSONObject, "title", consumeInfo.title);
            ktc.a(jSONObject, "content", consumeInfo.content);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
