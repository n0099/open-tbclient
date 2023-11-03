package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedKV;
import tbclient.FeedToutiao;
/* loaded from: classes6.dex */
public class ftc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedToutiao feedToutiao) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedToutiao)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (feedToutiao.business_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : feedToutiao.business_info) {
                    jSONArray.put(tsc.b(feedKV));
                }
                poc.a(jSONObject, "business_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
