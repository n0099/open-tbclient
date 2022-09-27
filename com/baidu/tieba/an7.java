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
/* loaded from: classes3.dex */
public class an7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public nm7 b;
    public LinkedHashMap<String, qm7> c;

    public an7(DataRes dataRes) {
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
        new zm7(dataRes);
        new bn7(dataRes.special_list);
        new sm7(dataRes.cooperate_list);
        new wm7(dataRes.theme_list);
        new om7(dataRes.banner_list);
        new en7(dataRes.task_list);
        new dn7(dataRes.rank, dataRes.user);
        new um7(dataRes.daily_list);
        nm7 nm7Var = new nm7();
        this.b = nm7Var;
        nm7Var.a(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    qm7 qm7Var = new qm7(vipBasicList);
                    if (qm7Var.c != 3 || qm7Var.a().size() >= 2) {
                        this.c.put(qm7Var.d, qm7Var);
                    }
                }
            }
        }
        List<String> list3 = dataRes.card_order;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        this.a = new ArrayList<>();
        for (String str3 : dataRes.card_order) {
            if (!StringUtils.isNull(str3)) {
                this.a.add(str3);
            }
        }
    }
}
