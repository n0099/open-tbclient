package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedContentEmoji;
/* loaded from: classes5.dex */
public class esc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentEmoji feedContentEmoji) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentEmoji)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "name", feedContentEmoji.name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
