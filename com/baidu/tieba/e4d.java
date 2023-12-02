package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemPlot;
/* loaded from: classes5.dex */
public class e4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemPlot itemPlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemPlot)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "level", itemPlot.level);
            ktc.a(jSONObject, "num", itemPlot.num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
