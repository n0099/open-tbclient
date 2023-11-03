package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CustomFigure;
/* loaded from: classes6.dex */
public class grc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CustomFigure customFigure) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, customFigure)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "figure_url", customFigure.figure_url);
            poc.a(jSONObject, "background_type", customFigure.background_type);
            poc.a(jSONObject, "background_value", customFigure.background_value);
            poc.a(jSONObject, "dynamic_figure_url", customFigure.dynamic_figure_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
