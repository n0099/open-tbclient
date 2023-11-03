package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedContentEmoji;
import tbclient.FeedContentIcon;
import tbclient.FeedContentResource;
import tbclient.FeedContentText;
import tbclient.FeedKV;
/* loaded from: classes6.dex */
public class fsc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentResource feedContentResource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentResource)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", feedContentResource.type);
            poc.a(jSONObject, "schema", feedContentResource.schema);
            FeedContentText feedContentText = feedContentResource.text_info;
            if (feedContentText != null) {
                poc.a(jSONObject, "text_info", gsc.b(feedContentText));
            }
            FeedContentIcon feedContentIcon = feedContentResource.icon_info;
            if (feedContentIcon != null) {
                poc.a(jSONObject, "icon_info", esc.b(feedContentIcon));
            }
            FeedContentEmoji feedContentEmoji = feedContentResource.emoji_info;
            if (feedContentEmoji != null) {
                poc.a(jSONObject, "emoji_info", dsc.b(feedContentEmoji));
            }
            if (feedContentResource.business_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : feedContentResource.business_info) {
                    jSONArray.put(tsc.b(feedKV));
                }
                poc.a(jSONObject, "business_info", jSONArray);
            }
            if (feedContentResource.log_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV2 : feedContentResource.log_info) {
                    jSONArray2.put(tsc.b(feedKV2));
                }
                poc.a(jSONObject, "log_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
