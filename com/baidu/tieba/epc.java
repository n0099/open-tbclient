package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AddPostList;
import tbclient.SubPostList;
/* loaded from: classes5.dex */
public class epc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AddPostList addPostList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, addPostList)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "pid", addPostList.pid);
            poc.a(jSONObject, "total_num", addPostList.total_num);
            poc.a(jSONObject, "total_count", addPostList.total_count);
            if (addPostList.add_post_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (SubPostList subPostList : addPostList.add_post_list) {
                    jSONArray.put(y3d.b(subPostList));
                }
                poc.a(jSONObject, "add_post_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
