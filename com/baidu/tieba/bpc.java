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
public class bpc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "show_rule", adInfo.show_rule);
            poc.a(jSONObject, TiebaStatic.Params.AD_TYPE, adInfo.ad_type);
            poc.a(jSONObject, TiebaStatic.Params.AD_DESC, adInfo.ad_desc);
            poc.a(jSONObject, "ad_pic", adInfo.ad_pic);
            poc.a(jSONObject, SignAllForumAdvertActivityConfig.AD_URL, adInfo.ad_url);
            poc.a(jSONObject, "ad_name", adInfo.ad_name);
            poc.a(jSONObject, "portrait", adInfo.portrait);
            if (adInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : adInfo.media) {
                    jSONArray.put(yzc.b(media));
                }
                poc.a(jSONObject, "media", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
