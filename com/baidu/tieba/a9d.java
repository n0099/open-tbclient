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
public class a9d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SubPost subPost) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, subPost)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "pid", subPost.pid);
            if (subPost.sub_post_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (SubPostList subPostList : subPost.sub_post_list) {
                    jSONArray.put(b9d.b(subPostList));
                }
                ktc.a(jSONObject, "sub_post_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
