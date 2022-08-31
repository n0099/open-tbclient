package com.baidu.tieba;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes4.dex */
public class f87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;
    public String b;
    public Double c;
    public String d;
    public List<String> e;
    public Double f;
    public Integer g;
    public String h;
    public String i;
    public String j;
    public Integer k;
    public Integer l;
    public String m;
    public String n;
    public ApkDetailPojo o;

    public f87() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static f87 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            f87 f87Var = new f87();
            f87Var.a = item.itemId;
            f87Var.b = item.itemName;
            f87Var.c = item.iconSize;
            f87Var.d = item.iconUrl;
            f87Var.e = item.tags;
            f87Var.f = item.score;
            f87Var.g = item.star;
            f87Var.h = item.buttonName;
            f87Var.i = item.buttonLink;
            f87Var.j = item.itemAppid;
            f87Var.k = item.categoryId;
            f87Var.l = item.buttonLinkType;
            f87Var.m = item.apkName;
            f87Var.n = item.forumName;
            f87Var.o = ApkDetailPojo.z(item.apkDetail);
            return f87Var;
        }
        return (f87) invokeL.objValue;
    }

    public static f87 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            f87 f87Var = new f87();
            f87Var.a = item.item_id;
            f87Var.b = item.item_name;
            f87Var.c = item.icon_size;
            f87Var.d = item.icon_url;
            f87Var.e = item.tags;
            f87Var.f = item.score;
            f87Var.g = item.star;
            f87Var.h = item.button_name;
            f87Var.i = item.button_link;
            f87Var.j = item.item_appid;
            f87Var.k = item.category_id;
            f87Var.l = item.button_link_type;
            f87Var.m = item.apk_name;
            f87Var.n = item.forum_name;
            f87Var.o = ApkDetailPojo.A(item.apk_detail);
            return f87Var;
        }
        return (f87) invokeL.objValue;
    }
}
