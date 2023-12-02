package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TagsInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class i9d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TagsInfo tagsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tagsInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ThemeColorInfo themeColorInfo = tagsInfo.img_info;
            if (themeColorInfo != null) {
                ktc.a(jSONObject, "img_info", s9d.b(themeColorInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
