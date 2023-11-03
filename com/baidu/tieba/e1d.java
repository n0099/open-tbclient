package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedKV;
import tbclient.PicDecoration;
/* loaded from: classes5.dex */
public class e1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PicDecoration picDecoration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, picDecoration)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "location", picDecoration.location);
            poc.a(jSONObject, "name", picDecoration.name);
            if (picDecoration.decoration_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : picDecoration.decoration_info) {
                    jSONArray.put(tsc.b(feedKV));
                }
                poc.a(jSONObject, "decoration_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
