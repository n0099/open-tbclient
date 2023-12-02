package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedContentIcon;
/* loaded from: classes5.dex */
public class cxc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentIcon feedContentIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "day_url", feedContentIcon.day_url);
            ktc.a(jSONObject, "night_url", feedContentIcon.night_url);
            ktc.a(jSONObject, "width", feedContentIcon.width);
            ktc.a(jSONObject, "height", feedContentIcon.height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
