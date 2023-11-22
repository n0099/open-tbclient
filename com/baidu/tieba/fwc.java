package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.NovelExt;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class fwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelExt novelExt) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelExt)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "chapter_time", novelExt.chapter_time);
            qoc.a(jSONObject, "abstract", novelExt._abstract);
            ThemeColorInfo themeColorInfo = novelExt.new_labels;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, "new_labels", q4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = novelExt.chapter_bg_color;
            if (themeColorInfo2 != null) {
                qoc.a(jSONObject, "chapter_bg_color", q4d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = novelExt.chapter_name_color;
            if (themeColorInfo3 != null) {
                qoc.a(jSONObject, "chapter_name_color", q4d.b(themeColorInfo3));
            }
            ThemeColorInfo themeColorInfo4 = novelExt.chapter_time_color;
            if (themeColorInfo4 != null) {
                qoc.a(jSONObject, "chapter_time_color", q4d.b(themeColorInfo4));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
