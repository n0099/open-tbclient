package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrequentlyForumInfo;
import tbclient.VitalityInfo;
/* loaded from: classes5.dex */
public class e6d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VitalityInfo vitalityInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vitalityInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            FrequentlyForumInfo frequentlyForumInfo = vitalityInfo.frequently_forum_info;
            if (frequentlyForumInfo != null) {
                qoc.a(jSONObject, "frequently_forum_info", stc.b(frequentlyForumInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
