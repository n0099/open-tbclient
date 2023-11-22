package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Forum;
/* loaded from: classes5.dex */
public class evc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Forum forum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forum)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "forum_id", forum.forum_id);
            qoc.a(jSONObject, "level1_dir_name", forum.level1_dir_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
