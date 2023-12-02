package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedLayout;
import tbclient.FrsPage.PageData;
import tbclient.LayoutFactory;
/* loaded from: classes6.dex */
public class h1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PageData pageData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pageData)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (pageData.test_drop != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedLayout feedLayout : pageData.test_drop) {
                    jSONArray.put(sxc.b(feedLayout));
                }
                ktc.a(jSONObject, "test_drop", jSONArray);
            }
            if (pageData.feed_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (LayoutFactory layoutFactory : pageData.feed_list) {
                    jSONArray2.put(m4d.b(layoutFactory));
                }
                ktc.a(jSONObject, "feed_list", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
