package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes5.dex */
public class cpc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "show_rule", adInfo.show_rule);
            qoc.a(jSONObject, TiebaStatic.Params.AD_TYPE, adInfo.ad_type);
            qoc.a(jSONObject, TiebaStatic.Params.AD_DESC, adInfo.ad_desc);
            qoc.a(jSONObject, "ad_pic", adInfo.ad_pic);
            qoc.a(jSONObject, SignAllForumAdvertActivityConfig.AD_URL, adInfo.ad_url);
            qoc.a(jSONObject, "ad_name", adInfo.ad_name);
            qoc.a(jSONObject, "portrait", adInfo.portrait);
            if (adInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : adInfo.media) {
                    jSONArray.put(zzc.b(media));
                }
                qoc.a(jSONObject, "media", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
