package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Size;
/* loaded from: classes5.dex */
public class b2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static Size b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            Size.Builder builder = new Size.Builder();
            if (jSONObject.has("width")) {
                builder.width = Integer.valueOf(jSONObject.optInt("width"));
            }
            if (jSONObject.has("height")) {
                builder.height = Integer.valueOf(jSONObject.optInt("height"));
            }
            return builder.build(true);
        }
        return (Size) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(@NonNull Size size) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, size)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "width", size.width);
            ktc.a(jSONObject, "height", size.height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
