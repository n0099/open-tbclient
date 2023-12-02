package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Zhibo;
/* loaded from: classes5.dex */
public class f3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Zhibo zhibo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zhibo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "forum", zhibo.forum);
            ktc.a(jSONObject, "tid", zhibo.tid);
            ktc.a(jSONObject, "status", zhibo.status);
            ktc.a(jSONObject, "type", zhibo.type);
            ktc.a(jSONObject, IconCompat.EXTRA_INT1, zhibo.int1);
            ktc.a(jSONObject, "has_lpost", zhibo.has_lpost);
            ktc.a(jSONObject, "lpost_type", zhibo.lpost_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
