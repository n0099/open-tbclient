package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Zhibo;
/* loaded from: classes6.dex */
public class g3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Zhibo zhibo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zhibo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "forum", zhibo.forum);
            ltc.a(jSONObject, "tid", zhibo.tid);
            ltc.a(jSONObject, "status", zhibo.status);
            ltc.a(jSONObject, "type", zhibo.type);
            ltc.a(jSONObject, IconCompat.EXTRA_INT1, zhibo.int1);
            ltc.a(jSONObject, "has_lpost", zhibo.has_lpost);
            ltc.a(jSONObject, "lpost_type", zhibo.lpost_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
