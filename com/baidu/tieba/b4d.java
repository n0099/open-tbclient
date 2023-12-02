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
public class b4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, item)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "item_id", item.item_id);
            ktc.a(jSONObject, "item_name", item.item_name);
            ktc.a(jSONObject, "icon_size", item.icon_size);
            ktc.a(jSONObject, "icon_url", item.icon_url);
            if (item.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : item.tags) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, "tags", jSONArray);
            }
            ktc.a(jSONObject, "score", item.score);
            ktc.a(jSONObject, "star", item.star);
            ktc.a(jSONObject, "button_name", item.button_name);
            ktc.a(jSONObject, "button_link", item.button_link);
            ktc.a(jSONObject, "item_appid", item.item_appid);
            ktc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_ID, item.category_id);
            ktc.a(jSONObject, "button_link_type", item.button_link_type);
            ktc.a(jSONObject, "apk_name", item.apk_name);
            ktc.a(jSONObject, "forum_name", item.forum_name);
            ApkDetail apkDetail = item.apk_detail;
            if (apkDetail != null) {
                ktc.a(jSONObject, "apk_detail", puc.b(apkDetail));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
