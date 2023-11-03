package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TailInfo;
/* loaded from: classes6.dex */
public class g4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TailInfo tailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tailInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "tail_type", tailInfo.tail_type);
            poc.a(jSONObject, "icon_url", tailInfo.icon_url);
            poc.a(jSONObject, "icon_link", tailInfo.icon_link);
            poc.a(jSONObject, "content", tailInfo.content);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
