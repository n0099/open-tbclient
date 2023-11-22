package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Zhibo;
/* loaded from: classes5.dex */
public class dyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Zhibo zhibo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zhibo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "forum", zhibo.forum);
            qoc.a(jSONObject, "tid", zhibo.tid);
            qoc.a(jSONObject, "status", zhibo.status);
            qoc.a(jSONObject, "type", zhibo.type);
            qoc.a(jSONObject, IconCompat.EXTRA_INT1, zhibo.int1);
            qoc.a(jSONObject, "has_lpost", zhibo.has_lpost);
            qoc.a(jSONObject, "lpost_type", zhibo.lpost_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
