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
public class c4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemInfo itemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", itemInfo.id);
            ktc.a(jSONObject, "name", itemInfo.name);
            ktc.a(jSONObject, "icon_url", itemInfo.icon_url);
            ktc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, itemInfo.brief);
            if (itemInfo.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : itemInfo.tags) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, "tags", jSONArray);
            }
            ktc.a(jSONObject, "icon_size", itemInfo.icon_size);
            if (itemInfo.item_options != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (ItemOptions itemOptions : itemInfo.item_options) {
                    jSONArray2.put(d4d.b(itemOptions));
                }
                ktc.a(jSONObject, "item_options", jSONArray2);
            }
            ItemTable itemTable = itemInfo.score;
            if (itemTable != null) {
                ktc.a(jSONObject, "score", h4d.b(itemTable));
            }
            ktc.a(jSONObject, "is_school", itemInfo.is_school);
            ItemThemeColor itemThemeColor = itemInfo.theme_color;
            if (itemThemeColor != null) {
                ktc.a(jSONObject, "theme_color", j4d.b(itemThemeColor));
            }
            ktc.a(jSONObject, "template_name", itemInfo.template_name);
            ktc.a(jSONObject, "forum_name", itemInfo.forum_name);
            if (itemInfo.tag_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TagInfo tagInfo : itemInfo.tag_info) {
                    jSONArray3.put(g9d.b(tagInfo));
                }
                ktc.a(jSONObject, "tag_info", jSONArray3);
            }
            ktc.a(jSONObject, "category1", itemInfo.category1);
            ktc.a(jSONObject, "category2", itemInfo.category2);
            ItemDetail itemDetail = itemInfo.detail;
            if (itemDetail != null) {
                ktc.a(jSONObject, "detail", a4d.b(itemDetail));
            }
            Ranking ranking = itemInfo.ranking;
            if (ranking != null) {
                ktc.a(jSONObject, "ranking", h7d.b(ranking));
            }
            ItemService itemService = itemInfo.service;
            if (itemService != null) {
                ktc.a(jSONObject, "service", g4d.b(itemService));
            }
            ktc.a(jSONObject, "button_name", itemInfo.button_name);
            ktc.a(jSONObject, "button_link", itemInfo.button_link);
            ktc.a(jSONObject, "item_appid", itemInfo.item_appid);
            ktc.a(jSONObject, "button_link_type", itemInfo.button_link_type);
            ktc.a(jSONObject, "apk_name", itemInfo.apk_name);
            ApkDetail apkDetail = itemInfo.apk_detail;
            if (apkDetail != null) {
                ktc.a(jSONObject, "apk_detail", puc.b(apkDetail));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
