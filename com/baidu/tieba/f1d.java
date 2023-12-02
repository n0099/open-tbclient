package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.NovelExt;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public class f1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelExt novelExt) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelExt)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "chapter_time", novelExt.chapter_time);
            ktc.a(jSONObject, "abstract", novelExt._abstract);
            ThemeColorInfo themeColorInfo = novelExt.new_labels;
            if (themeColorInfo != null) {
                ktc.a(jSONObject, "new_labels", s9d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = novelExt.chapter_bg_color;
            if (themeColorInfo2 != null) {
                ktc.a(jSONObject, "chapter_bg_color", s9d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = novelExt.chapter_name_color;
            if (themeColorInfo3 != null) {
                ktc.a(jSONObject, "chapter_name_color", s9d.b(themeColorInfo3));
            }
            ThemeColorInfo themeColorInfo4 = novelExt.chapter_time_color;
            if (themeColorInfo4 != null) {
                ktc.a(jSONObject, "chapter_time_color", s9d.b(themeColorInfo4));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
