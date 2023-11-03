package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.App;
import tbclient.FrsPage.AdkillerAd;
/* loaded from: classes5.dex */
public class auc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AdkillerAd adkillerAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adkillerAd)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "tag", adkillerAd.tag);
            poc.a(jSONObject, "game_url", adkillerAd.game_url);
            App app = adkillerAd.app;
            if (app != null) {
                poc.a(jSONObject, "app", upc.b(app));
            }
            poc.a(jSONObject, "can_close", adkillerAd.can_close);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
