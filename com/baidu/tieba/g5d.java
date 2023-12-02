package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MultipleForum;
/* loaded from: classes6.dex */
public class g5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MultipleForum multipleForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, multipleForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "forum_id", multipleForum.forum_id);
            ktc.a(jSONObject, "forum_name", multipleForum.forum_name);
            ktc.a(jSONObject, "is_bawu", multipleForum.is_bawu);
            ktc.a(jSONObject, "bawu_type", multipleForum.bawu_type);
            ktc.a(jSONObject, "is_deleted", multipleForum.is_deleted);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
