package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedContentIcon;
/* loaded from: classes5.dex */
public class dxc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentIcon feedContentIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "day_url", feedContentIcon.day_url);
            ltc.a(jSONObject, "night_url", feedContentIcon.night_url);
            ltc.a(jSONObject, "width", feedContentIcon.width);
            ltc.a(jSONObject, "height", feedContentIcon.height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
