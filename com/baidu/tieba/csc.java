package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedContentColor;
/* loaded from: classes5.dex */
public class csc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentColor feedContentColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentColor)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", feedContentColor.type);
            qoc.a(jSONObject, "day", feedContentColor.day);
            qoc.a(jSONObject, "night", feedContentColor.night);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
