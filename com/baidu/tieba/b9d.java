package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes5.dex */
public class b9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SubPost subPost) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, subPost)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "pid", subPost.pid);
            if (subPost.sub_post_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (SubPostList subPostList : subPost.sub_post_list) {
                    jSONArray.put(c9d.b(subPostList));
                }
                ltc.a(jSONObject, "sub_post_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
