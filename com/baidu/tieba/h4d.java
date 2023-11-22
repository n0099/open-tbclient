package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TailInfo;
/* loaded from: classes6.dex */
public class h4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TailInfo tailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tailInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "tail_type", tailInfo.tail_type);
            qoc.a(jSONObject, "icon_url", tailInfo.icon_url);
            qoc.a(jSONObject, "icon_link", tailInfo.icon_link);
            qoc.a(jSONObject, "content", tailInfo.content);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
