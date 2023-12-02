package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedContentCustom;
/* loaded from: classes5.dex */
public class axc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentCustom feedContentCustom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentCustom)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "style", feedContentCustom.style);
            ktc.a(jSONObject, "data", feedContentCustom.data);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
