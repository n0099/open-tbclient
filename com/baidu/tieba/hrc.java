package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CustomFigure;
/* loaded from: classes6.dex */
public class hrc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CustomFigure customFigure) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, customFigure)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "figure_url", customFigure.figure_url);
            qoc.a(jSONObject, "background_type", customFigure.background_type);
            qoc.a(jSONObject, "background_value", customFigure.background_value);
            qoc.a(jSONObject, "dynamic_figure_url", customFigure.dynamic_figure_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
