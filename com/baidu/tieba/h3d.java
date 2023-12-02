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
public class h3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsTabInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "tab_id", frsTabInfo.tab_id);
            ktc.a(jSONObject, "tab_type", frsTabInfo.tab_type);
            ktc.a(jSONObject, "tab_name", frsTabInfo.tab_name);
            ktc.a(jSONObject, "tab_url", frsTabInfo.tab_url);
            ktc.a(jSONObject, "tab_gid", frsTabInfo.tab_gid);
            ktc.a(jSONObject, "tab_title", frsTabInfo.tab_title);
            ktc.a(jSONObject, "is_general_tab", frsTabInfo.is_general_tab);
            ktc.a(jSONObject, "tab_code", frsTabInfo.tab_code);
            ktc.a(jSONObject, "tab_version", frsTabInfo.tab_version);
            ktc.a(jSONObject, AddressField.KEY_IS_DEFAULT, frsTabInfo.is_default);
            ktc.a(jSONObject, "need_page", frsTabInfo.need_page);
            TabPic tabPic = frsTabInfo.head_pics;
            if (tabPic != null) {
                ktc.a(jSONObject, "head_pics", f9d.b(tabPic));
            }
            ktc.a(jSONObject, "exposure_monitor_url", frsTabInfo.exposure_monitor_url);
            ktc.a(jSONObject, "click_monitor_url", frsTabInfo.click_monitor_url);
            ktc.a(jSONObject, "demote_url", frsTabInfo.demote_url);
            ktc.a(jSONObject, "is_no_show_publisher", frsTabInfo.is_no_show_publisher);
            ktc.a(jSONObject, "is_no_show_in_publisher", frsTabInfo.is_no_show_in_publisher);
            ktc.a(jSONObject, "net_tab_type", frsTabInfo.net_tab_type);
            if (frsTabInfo.sort_menu != null) {
                JSONArray jSONArray = new JSONArray();
                for (SortButton sortButton : frsTabInfo.sort_menu) {
                    jSONArray.put(n8d.b(sortButton));
                }
                ktc.a(jSONObject, "sort_menu", jSONArray);
            }
            if (frsTabInfo.sub_tab_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (TabMenu tabMenu : frsTabInfo.sub_tab_list) {
                    jSONArray2.put(d9d.b(tabMenu));
                }
                ktc.a(jSONObject, "sub_tab_list", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
