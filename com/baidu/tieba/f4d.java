package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.TagLabelInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public class f4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TagLabelInfo tagLabelInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tagLabelInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (tagLabelInfo.labels != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThemeColorInfo themeColorInfo : tagLabelInfo.labels) {
                    jSONArray.put(q4d.b(themeColorInfo));
                }
                qoc.a(jSONObject, "labels", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
