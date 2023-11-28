package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.TabSkin;
import tbclient.FrsPage.WorldcupSkin;
/* loaded from: classes5.dex */
public class d3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldcupSkin worldcupSkin) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldcupSkin)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "worldcup_icon_height", worldcupSkin.worldcup_icon_height);
            ltc.a(jSONObject, "worldcup_bottom", worldcupSkin.worldcup_bottom);
            ltc.a(jSONObject, "worldcup_bottom_night", worldcupSkin.worldcup_bottom_night);
            ltc.a(jSONObject, "worldcup_top", worldcupSkin.worldcup_top);
            ltc.a(jSONObject, "worldcup_top_night", worldcupSkin.worldcup_top_night);
            if (worldcupSkin.tab_skin != null) {
                JSONArray jSONArray = new JSONArray();
                for (TabSkin tabSkin : worldcupSkin.tab_skin) {
                    jSONArray.put(j2d.b(tabSkin));
                }
                ltc.a(jSONObject, "tab_skin", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
