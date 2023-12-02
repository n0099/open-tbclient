package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCupNews;
/* loaded from: classes5.dex */
public class a3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupNews worldCupNews) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupNews)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title", worldCupNews.title);
            ktc.a(jSONObject, "url", worldCupNews.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
