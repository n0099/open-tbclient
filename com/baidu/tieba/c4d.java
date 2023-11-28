package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes5.dex */
public class c4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, item)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "item_id", item.item_id);
            ltc.a(jSONObject, "item_name", item.item_name);
            ltc.a(jSONObject, "icon_size", item.icon_size);
            ltc.a(jSONObject, "icon_url", item.icon_url);
            if (item.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : item.tags) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "tags", jSONArray);
            }
            ltc.a(jSONObject, "score", item.score);
            ltc.a(jSONObject, "star", item.star);
            ltc.a(jSONObject, "button_name", item.button_name);
            ltc.a(jSONObject, "button_link", item.button_link);
            ltc.a(jSONObject, "item_appid", item.item_appid);
            ltc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_ID, item.category_id);
            ltc.a(jSONObject, "button_link_type", item.button_link_type);
            ltc.a(jSONObject, "apk_name", item.apk_name);
            ltc.a(jSONObject, "forum_name", item.forum_name);
            ApkDetail apkDetail = item.apk_detail;
            if (apkDetail != null) {
                ltc.a(jSONObject, "apk_detail", quc.b(apkDetail));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
