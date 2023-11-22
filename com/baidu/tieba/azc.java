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
public class azc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemInfo itemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", itemInfo.id);
            qoc.a(jSONObject, "name", itemInfo.name);
            qoc.a(jSONObject, "icon_url", itemInfo.icon_url);
            qoc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, itemInfo.brief);
            if (itemInfo.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : itemInfo.tags) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "tags", jSONArray);
            }
            qoc.a(jSONObject, "icon_size", itemInfo.icon_size);
            if (itemInfo.item_options != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (ItemOptions itemOptions : itemInfo.item_options) {
                    jSONArray2.put(bzc.b(itemOptions));
                }
                qoc.a(jSONObject, "item_options", jSONArray2);
            }
            ItemTable itemTable = itemInfo.score;
            if (itemTable != null) {
                qoc.a(jSONObject, "score", fzc.b(itemTable));
            }
            qoc.a(jSONObject, "is_school", itemInfo.is_school);
            ItemThemeColor itemThemeColor = itemInfo.theme_color;
            if (itemThemeColor != null) {
                qoc.a(jSONObject, "theme_color", hzc.b(itemThemeColor));
            }
            qoc.a(jSONObject, "template_name", itemInfo.template_name);
            qoc.a(jSONObject, "forum_name", itemInfo.forum_name);
            if (itemInfo.tag_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TagInfo tagInfo : itemInfo.tag_info) {
                    jSONArray3.put(e4d.b(tagInfo));
                }
                qoc.a(jSONObject, "tag_info", jSONArray3);
            }
            qoc.a(jSONObject, "category1", itemInfo.category1);
            qoc.a(jSONObject, "category2", itemInfo.category2);
            ItemDetail itemDetail = itemInfo.detail;
            if (itemDetail != null) {
                qoc.a(jSONObject, "detail", yyc.b(itemDetail));
            }
            Ranking ranking = itemInfo.ranking;
            if (ranking != null) {
                qoc.a(jSONObject, "ranking", f2d.b(ranking));
            }
            ItemService itemService = itemInfo.service;
            if (itemService != null) {
                qoc.a(jSONObject, "service", ezc.b(itemService));
            }
            qoc.a(jSONObject, "button_name", itemInfo.button_name);
            qoc.a(jSONObject, "button_link", itemInfo.button_link);
            qoc.a(jSONObject, "item_appid", itemInfo.item_appid);
            qoc.a(jSONObject, "button_link_type", itemInfo.button_link_type);
            qoc.a(jSONObject, "apk_name", itemInfo.apk_name);
            ApkDetail apkDetail = itemInfo.apk_detail;
            if (apkDetail != null) {
                qoc.a(jSONObject, "apk_detail", tpc.b(apkDetail));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
