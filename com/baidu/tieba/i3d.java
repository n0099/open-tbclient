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
public class i3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsTabInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "tab_id", frsTabInfo.tab_id);
            ltc.a(jSONObject, "tab_type", frsTabInfo.tab_type);
            ltc.a(jSONObject, "tab_name", frsTabInfo.tab_name);
            ltc.a(jSONObject, "tab_url", frsTabInfo.tab_url);
            ltc.a(jSONObject, "tab_gid", frsTabInfo.tab_gid);
            ltc.a(jSONObject, "tab_title", frsTabInfo.tab_title);
            ltc.a(jSONObject, "is_general_tab", frsTabInfo.is_general_tab);
            ltc.a(jSONObject, "tab_code", frsTabInfo.tab_code);
            ltc.a(jSONObject, "tab_version", frsTabInfo.tab_version);
            ltc.a(jSONObject, AddressField.KEY_IS_DEFAULT, frsTabInfo.is_default);
            ltc.a(jSONObject, "need_page", frsTabInfo.need_page);
            TabPic tabPic = frsTabInfo.head_pics;
            if (tabPic != null) {
                ltc.a(jSONObject, "head_pics", g9d.b(tabPic));
            }
            ltc.a(jSONObject, "exposure_monitor_url", frsTabInfo.exposure_monitor_url);
            ltc.a(jSONObject, "click_monitor_url", frsTabInfo.click_monitor_url);
            ltc.a(jSONObject, "demote_url", frsTabInfo.demote_url);
            ltc.a(jSONObject, "is_no_show_publisher", frsTabInfo.is_no_show_publisher);
            ltc.a(jSONObject, "is_no_show_in_publisher", frsTabInfo.is_no_show_in_publisher);
            ltc.a(jSONObject, "net_tab_type", frsTabInfo.net_tab_type);
            if (frsTabInfo.sort_menu != null) {
                JSONArray jSONArray = new JSONArray();
                for (SortButton sortButton : frsTabInfo.sort_menu) {
                    jSONArray.put(o8d.b(sortButton));
                }
                ltc.a(jSONObject, "sort_menu", jSONArray);
            }
            if (frsTabInfo.sub_tab_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (TabMenu tabMenu : frsTabInfo.sub_tab_list) {
                    jSONArray2.put(e9d.b(tabMenu));
                }
                ltc.a(jSONObject, "sub_tab_list", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
