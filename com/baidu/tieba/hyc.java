package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FestivalTipData;
import tbclient.IconUrlInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class hyc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FestivalTipData festivalTipData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, festivalTipData)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "text", festivalTipData.text);
            ktc.a(jSONObject, BigdayActivityConfig.JUMP_URL, festivalTipData.jump_url);
            ThemeColorInfo themeColorInfo = festivalTipData.background_color;
            if (themeColorInfo != null) {
                ktc.a(jSONObject, "background_color", s9d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = festivalTipData.font_color;
            if (themeColorInfo2 != null) {
                ktc.a(jSONObject, "font_color", s9d.b(themeColorInfo2));
            }
            IconUrlInfo iconUrlInfo = festivalTipData.icon_url;
            if (iconUrlInfo != null) {
                ktc.a(jSONObject, "icon_url", z3d.b(iconUrlInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
