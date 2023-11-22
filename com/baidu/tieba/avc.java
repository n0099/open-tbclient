package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Focus;
/* loaded from: classes5.dex */
public class avc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Focus focus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, focus)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "time", focus.time);
            qoc.a(jSONObject, "title", focus.title);
            qoc.a(jSONObject, "link", focus.link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
