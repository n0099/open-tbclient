package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedKV;
import tbclient.PicDecoration;
/* loaded from: classes6.dex */
public class h6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PicDecoration picDecoration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, picDecoration)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "location", picDecoration.location);
            ktc.a(jSONObject, "name", picDecoration.name);
            if (picDecoration.decoration_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : picDecoration.decoration_info) {
                    jSONArray.put(rxc.b(feedKV));
                }
                ktc.a(jSONObject, "decoration_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
