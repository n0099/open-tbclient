package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.Adkiller;
import tbclient.FrsPage.AdkillerAd;
/* loaded from: classes5.dex */
public class cuc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Adkiller adkiller) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adkiller)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "show_hint", adkiller.show_hint);
            qoc.a(jSONObject, "show_ad", adkiller.show_ad);
            qoc.a(jSONObject, "hint_url", adkiller.hint_url);
            qoc.a(jSONObject, "ad_left_num", adkiller.ad_left_num);
            if (adkiller.ad_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (AdkillerAd adkillerAd : adkiller.ad_list) {
                    jSONArray.put(buc.b(adkillerAd));
                }
                qoc.a(jSONObject, "ad_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
