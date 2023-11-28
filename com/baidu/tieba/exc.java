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
/* loaded from: classes5.dex */
public class exc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentResource feedContentResource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentResource)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", feedContentResource.type);
            ltc.a(jSONObject, "schema", feedContentResource.schema);
            FeedContentText feedContentText = feedContentResource.text_info;
            if (feedContentText != null) {
                ltc.a(jSONObject, "text_info", fxc.b(feedContentText));
            }
            FeedContentIcon feedContentIcon = feedContentResource.icon_info;
            if (feedContentIcon != null) {
                ltc.a(jSONObject, "icon_info", dxc.b(feedContentIcon));
            }
            FeedContentEmoji feedContentEmoji = feedContentResource.emoji_info;
            if (feedContentEmoji != null) {
                ltc.a(jSONObject, "emoji_info", cxc.b(feedContentEmoji));
            }
            if (feedContentResource.business_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : feedContentResource.business_info) {
                    jSONArray.put(sxc.b(feedKV));
                }
                ltc.a(jSONObject, "business_info", jSONArray);
            }
            if (feedContentResource.log_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV2 : feedContentResource.log_info) {
                    jSONArray2.put(sxc.b(feedKV2));
                }
                ltc.a(jSONObject, "log_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
