package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemThemeColorElement;
/* loaded from: classes6.dex */
public class fzc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemThemeColorElement itemThemeColorElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemThemeColorElement)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "top_color", itemThemeColorElement.top_color);
            poc.a(jSONObject, "bottom_color", itemThemeColorElement.bottom_color);
            poc.a(jSONObject, "edit_button_color", itemThemeColorElement.edit_button_color);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
