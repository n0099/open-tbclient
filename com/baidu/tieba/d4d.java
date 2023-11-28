package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ApkDetail;
import tbclient.ItemDetail;
import tbclient.ItemInfo;
import tbclient.ItemOptions;
import tbclient.ItemService;
import tbclient.ItemTable;
import tbclient.ItemThemeColor;
import tbclient.Ranking;
import tbclient.TagInfo;
/* loaded from: classes5.dex */
public class d4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemInfo itemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", itemInfo.id);
            ltc.a(jSONObject, "name", itemInfo.name);
            ltc.a(jSONObject, "icon_url", itemInfo.icon_url);
            ltc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, itemInfo.brief);
            if (itemInfo.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : itemInfo.tags) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "tags", jSONArray);
            }
            ltc.a(jSONObject, "icon_size", itemInfo.icon_size);
            if (itemInfo.item_options != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (ItemOptions itemOptions : itemInfo.item_options) {
                    jSONArray2.put(e4d.b(itemOptions));
                }
                ltc.a(jSONObject, "item_options", jSONArray2);
            }
            ItemTable itemTable = itemInfo.score;
            if (itemTable != null) {
                ltc.a(jSONObject, "score", i4d.b(itemTable));
            }
            ltc.a(jSONObject, "is_school", itemInfo.is_school);
            ItemThemeColor itemThemeColor = itemInfo.theme_color;
            if (itemThemeColor != null) {
                ltc.a(jSONObject, "theme_color", k4d.b(itemThemeColor));
            }
            ltc.a(jSONObject, "template_name", itemInfo.template_name);
            ltc.a(jSONObject, "forum_name", itemInfo.forum_name);
            if (itemInfo.tag_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TagInfo tagInfo : itemInfo.tag_info) {
                    jSONArray3.put(h9d.b(tagInfo));
                }
                ltc.a(jSONObject, "tag_info", jSONArray3);
            }
            ltc.a(jSONObject, "category1", itemInfo.category1);
            ltc.a(jSONObject, "category2", itemInfo.category2);
            ItemDetail itemDetail = itemInfo.detail;
            if (itemDetail != null) {
                ltc.a(jSONObject, "detail", b4d.b(itemDetail));
            }
            Ranking ranking = itemInfo.ranking;
            if (ranking != null) {
                ltc.a(jSONObject, "ranking", i7d.b(ranking));
            }
            ItemService itemService = itemInfo.service;
            if (itemService != null) {
                ltc.a(jSONObject, "service", h4d.b(itemService));
            }
            ltc.a(jSONObject, "button_name", itemInfo.button_name);
            ltc.a(jSONObject, "button_link", itemInfo.button_link);
            ltc.a(jSONObject, "item_appid", itemInfo.item_appid);
            ltc.a(jSONObject, "button_link_type", itemInfo.button_link_type);
            ltc.a(jSONObject, "apk_name", itemInfo.apk_name);
            ApkDetail apkDetail = itemInfo.apk_detail;
            if (apkDetail != null) {
                ltc.a(jSONObject, "apk_detail", quc.b(apkDetail));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
