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
public class byc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedPostExpose feedPostExpose) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedPostExpose)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "schema", feedPostExpose.schema);
            ltc.a(jSONObject, "stamp_url", feedPostExpose.stamp_url);
            if (feedPostExpose.floor != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedContentResource feedContentResource : feedPostExpose.floor) {
                    jSONArray.put(exc.b(feedContentResource));
                }
                ltc.a(jSONObject, "floor", jSONArray);
            }
            PostExposeHead postExposeHead = feedPostExpose.head_img;
            if (postExposeHead != null) {
                ltc.a(jSONObject, "head_img", s6d.b(postExposeHead));
            }
            if (feedPostExpose.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : feedPostExpose.business_info) {
                    jSONArray2.put(sxc.b(feedKV));
                }
                ltc.a(jSONObject, "business_info", jSONArray2);
            }
            ltc.a(jSONObject, "head_text", feedPostExpose.head_text);
            Agree agree = feedPostExpose.head_agree;
            if (agree != null) {
                ltc.a(jSONObject, "head_agree", cuc.b(agree));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
