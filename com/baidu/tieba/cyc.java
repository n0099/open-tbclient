package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Zhibo;
/* loaded from: classes5.dex */
public class cyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Zhibo zhibo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zhibo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "forum", zhibo.forum);
            poc.a(jSONObject, "tid", zhibo.tid);
            poc.a(jSONObject, "status", zhibo.status);
            poc.a(jSONObject, "type", zhibo.type);
            poc.a(jSONObject, IconCompat.EXTRA_INT1, zhibo.int1);
            poc.a(jSONObject, "has_lpost", zhibo.has_lpost);
            poc.a(jSONObject, "lpost_type", zhibo.lpost_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
