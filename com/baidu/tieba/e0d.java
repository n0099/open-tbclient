package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MultipleForum;
/* loaded from: classes5.dex */
public class e0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MultipleForum multipleForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, multipleForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "forum_id", multipleForum.forum_id);
            qoc.a(jSONObject, "forum_name", multipleForum.forum_name);
            qoc.a(jSONObject, "is_bawu", multipleForum.is_bawu);
            qoc.a(jSONObject, "bawu_type", multipleForum.bawu_type);
            qoc.a(jSONObject, "is_deleted", multipleForum.is_deleted);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
