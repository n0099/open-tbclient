package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedContentIcon;
/* loaded from: classes6.dex */
public class fsc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentIcon feedContentIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "day_url", feedContentIcon.day_url);
            qoc.a(jSONObject, "night_url", feedContentIcon.night_url);
            qoc.a(jSONObject, "width", feedContentIcon.width);
            qoc.a(jSONObject, "height", feedContentIcon.height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
