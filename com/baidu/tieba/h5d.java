package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MultipleForum;
/* loaded from: classes6.dex */
public class h5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MultipleForum multipleForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, multipleForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "forum_id", multipleForum.forum_id);
            ltc.a(jSONObject, "forum_name", multipleForum.forum_name);
            ltc.a(jSONObject, "is_bawu", multipleForum.is_bawu);
            ltc.a(jSONObject, "bawu_type", multipleForum.bawu_type);
            ltc.a(jSONObject, "is_deleted", multipleForum.is_deleted);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
