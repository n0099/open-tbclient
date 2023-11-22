package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
import tbclient.SortButton;
import tbclient.TabMenu;
import tbclient.TabPic;
/* loaded from: classes6.dex */
public class fyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsTabInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "tab_id", frsTabInfo.tab_id);
            qoc.a(jSONObject, "tab_type", frsTabInfo.tab_type);
            qoc.a(jSONObject, "tab_name", frsTabInfo.tab_name);
            qoc.a(jSONObject, "tab_url", frsTabInfo.tab_url);
            qoc.a(jSONObject, "tab_gid", frsTabInfo.tab_gid);
            qoc.a(jSONObject, "tab_title", frsTabInfo.tab_title);
            qoc.a(jSONObject, "is_general_tab", frsTabInfo.is_general_tab);
            qoc.a(jSONObject, "tab_code", frsTabInfo.tab_code);
            qoc.a(jSONObject, "tab_version", frsTabInfo.tab_version);
            qoc.a(jSONObject, AddressField.KEY_IS_DEFAULT, frsTabInfo.is_default);
            qoc.a(jSONObject, "need_page", frsTabInfo.need_page);
            TabPic tabPic = frsTabInfo.head_pics;
            if (tabPic != null) {
                qoc.a(jSONObject, "head_pics", d4d.b(tabPic));
            }
            qoc.a(jSONObject, "exposure_monitor_url", frsTabInfo.exposure_monitor_url);
            qoc.a(jSONObject, "click_monitor_url", frsTabInfo.click_monitor_url);
            qoc.a(jSONObject, "demote_url", frsTabInfo.demote_url);
            qoc.a(jSONObject, "is_no_show_publisher", frsTabInfo.is_no_show_publisher);
            qoc.a(jSONObject, "is_no_show_in_publisher", frsTabInfo.is_no_show_in_publisher);
            qoc.a(jSONObject, "net_tab_type", frsTabInfo.net_tab_type);
            if (frsTabInfo.sort_menu != null) {
                JSONArray jSONArray = new JSONArray();
                for (SortButton sortButton : frsTabInfo.sort_menu) {
                    jSONArray.put(l3d.b(sortButton));
                }
                qoc.a(jSONObject, "sort_menu", jSONArray);
            }
            if (frsTabInfo.sub_tab_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (TabMenu tabMenu : frsTabInfo.sub_tab_list) {
                    jSONArray2.put(b4d.b(tabMenu));
                }
                qoc.a(jSONObject, "sub_tab_list", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
