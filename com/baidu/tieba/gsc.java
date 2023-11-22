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
public class gsc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentResource feedContentResource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentResource)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", feedContentResource.type);
            qoc.a(jSONObject, "schema", feedContentResource.schema);
            FeedContentText feedContentText = feedContentResource.text_info;
            if (feedContentText != null) {
                qoc.a(jSONObject, "text_info", hsc.b(feedContentText));
            }
            FeedContentIcon feedContentIcon = feedContentResource.icon_info;
            if (feedContentIcon != null) {
                qoc.a(jSONObject, "icon_info", fsc.b(feedContentIcon));
            }
            FeedContentEmoji feedContentEmoji = feedContentResource.emoji_info;
            if (feedContentEmoji != null) {
                qoc.a(jSONObject, "emoji_info", esc.b(feedContentEmoji));
            }
            if (feedContentResource.business_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : feedContentResource.business_info) {
                    jSONArray.put(usc.b(feedKV));
                }
                qoc.a(jSONObject, "business_info", jSONArray);
            }
            if (feedContentResource.log_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV2 : feedContentResource.log_info) {
                    jSONArray2.put(usc.b(feedKV2));
                }
                qoc.a(jSONObject, "log_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
