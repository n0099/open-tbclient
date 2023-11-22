package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
import tbclient.FrsPage.YuleActivity;
/* loaded from: classes5.dex */
public class cyc extends qoc {
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
                qoc.a(jSONObject, "yule_activity", byc.b(yuleActivity));
            }
            qoc.a(jSONObject, "activity_show", yule.activity_show);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
