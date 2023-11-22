package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Agree;
import tbclient.FeedContentResource;
import tbclient.FeedKV;
import tbclient.FeedPostExpose;
import tbclient.PostExposeHead;
/* loaded from: classes5.dex */
public class dtc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedPostExpose feedPostExpose) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedPostExpose)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "schema", feedPostExpose.schema);
            qoc.a(jSONObject, "stamp_url", feedPostExpose.stamp_url);
            if (feedPostExpose.floor != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedContentResource feedContentResource : feedPostExpose.floor) {
                    jSONArray.put(gsc.b(feedContentResource));
                }
                qoc.a(jSONObject, "floor", jSONArray);
            }
            PostExposeHead postExposeHead = feedPostExpose.head_img;
            if (postExposeHead != null) {
                qoc.a(jSONObject, "head_img", p1d.b(postExposeHead));
            }
            if (feedPostExpose.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : feedPostExpose.business_info) {
                    jSONArray2.put(usc.b(feedKV));
                }
                qoc.a(jSONObject, "business_info", jSONArray2);
            }
            qoc.a(jSONObject, "head_text", feedPostExpose.head_text);
            Agree agree = feedPostExpose.head_agree;
            if (agree != null) {
                qoc.a(jSONObject, "head_agree", hpc.b(agree));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
