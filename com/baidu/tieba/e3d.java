package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
import tbclient.FrsPage.YuleActivity;
/* loaded from: classes5.dex */
public class e3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Yule yule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, yule)) == null) {
            JSONObject jSONObject = new JSONObject();
            YuleActivity yuleActivity = yule.yule_activity;
            if (yuleActivity != null) {
                ktc.a(jSONObject, "yule_activity", d3d.b(yuleActivity));
            }
            ktc.a(jSONObject, "activity_show", yule.activity_show);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
