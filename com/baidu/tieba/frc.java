package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ConsumeInfo;
/* loaded from: classes6.dex */
public class frc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ConsumeInfo consumeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, consumeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon", consumeInfo.icon);
            qoc.a(jSONObject, "title", consumeInfo.title);
            qoc.a(jSONObject, "content", consumeInfo.content);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
