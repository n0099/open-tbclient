package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.NovelExt;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public class ewc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelExt novelExt) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelExt)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "chapter_time", novelExt.chapter_time);
            poc.a(jSONObject, "abstract", novelExt._abstract);
            ThemeColorInfo themeColorInfo = novelExt.new_labels;
            if (themeColorInfo != null) {
                poc.a(jSONObject, "new_labels", p4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = novelExt.chapter_bg_color;
            if (themeColorInfo2 != null) {
                poc.a(jSONObject, "chapter_bg_color", p4d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = novelExt.chapter_name_color;
            if (themeColorInfo3 != null) {
                poc.a(jSONObject, "chapter_name_color", p4d.b(themeColorInfo3));
            }
            ThemeColorInfo themeColorInfo4 = novelExt.chapter_time_color;
            if (themeColorInfo4 != null) {
                poc.a(jSONObject, "chapter_time_color", p4d.b(themeColorInfo4));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
