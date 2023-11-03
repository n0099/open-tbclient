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
public class buc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Adkiller adkiller) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adkiller)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "show_hint", adkiller.show_hint);
            poc.a(jSONObject, "show_ad", adkiller.show_ad);
            poc.a(jSONObject, "hint_url", adkiller.hint_url);
            poc.a(jSONObject, "ad_left_num", adkiller.ad_left_num);
            if (adkiller.ad_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (AdkillerAd adkillerAd : adkiller.ad_list) {
                    jSONArray.put(auc.b(adkillerAd));
                }
                poc.a(jSONObject, "ad_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
