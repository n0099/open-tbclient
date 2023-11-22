package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.YuleActivity;
/* loaded from: classes5.dex */
public class byc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull YuleActivity yuleActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, yuleActivity)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "activity_id", yuleActivity.activity_id);
            qoc.a(jSONObject, "activity_type", yuleActivity.activity_type);
            qoc.a(jSONObject, "activity_url", yuleActivity.activity_url);
            qoc.a(jSONObject, "activity_all_icon", yuleActivity.activity_all_icon);
            qoc.a(jSONObject, "activity_half_icon", yuleActivity.activity_half_icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
