package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThreadRecommendTag;
/* loaded from: classes5.dex */
public class bad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadRecommendTag threadRecommendTag) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadRecommendTag)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "text", threadRecommendTag.text);
            ThemeColorInfo themeColorInfo = threadRecommendTag.text_color;
            if (themeColorInfo != null) {
                ltc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, t9d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = threadRecommendTag.background_color;
            if (themeColorInfo2 != null) {
                ltc.a(jSONObject, "background_color", t9d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = threadRecommendTag.boundary_color;
            if (themeColorInfo3 != null) {
                ltc.a(jSONObject, "boundary_color", t9d.b(themeColorInfo3));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
