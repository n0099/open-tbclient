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
public class f1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PicDecoration picDecoration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, picDecoration)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "location", picDecoration.location);
            qoc.a(jSONObject, "name", picDecoration.name);
            if (picDecoration.decoration_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : picDecoration.decoration_info) {
                    jSONArray.put(usc.b(feedKV));
                }
                qoc.a(jSONObject, "decoration_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
