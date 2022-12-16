package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes4.dex */
public class fs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public sr7 b;
    public LinkedHashMap<String, vr7> c;

    public fs7(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataRes};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (dataRes == null) {
            return;
        }
        String str = dataRes.grade_intro_title;
        String str2 = dataRes.grade_intro_link;
        new es7(dataRes);
        new gs7(dataRes.special_list);
        new xr7(dataRes.cooperate_list);
        new bs7(dataRes.theme_list);
        new tr7(dataRes.banner_list);
        new js7(dataRes.task_list);
        new is7(dataRes.rank, dataRes.user);
        new zr7(dataRes.daily_list);
        sr7 sr7Var = new sr7();
        this.b = sr7Var;
        sr7Var.a(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    vr7 vr7Var = new vr7(vipBasicList);
                    if (vr7Var.c != 3 || vr7Var.a().size() >= 2) {
                        this.c.put(vr7Var.d, vr7Var);
                    }
                }
            }
        }
        List<String> list3 = dataRes.card_order;
        if (list3 != null && list3.size() > 0) {
            this.a = new ArrayList<>();
            for (String str3 : dataRes.card_order) {
                if (!StringUtils.isNull(str3)) {
                    this.a.add(str3);
                }
            }
        }
    }
}
