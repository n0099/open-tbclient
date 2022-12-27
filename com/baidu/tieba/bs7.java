package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes3.dex */
public class bs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bs7(VipThemeItem vipThemeItem) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipThemeItem};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = vipThemeItem.img_url;
        String str2 = vipThemeItem.title;
        vipThemeItem.props_id.intValue();
        vipThemeItem.props_category.intValue();
        String str3 = vipThemeItem.props_category_name;
        String str4 = vipThemeItem.desc;
        String str5 = vipThemeItem.link;
        String str6 = vipThemeItem.tag_img_url;
        String str7 = vipThemeItem.update_time;
        vipThemeItem.id.intValue();
        vipThemeItem.type.intValue();
    }
}
