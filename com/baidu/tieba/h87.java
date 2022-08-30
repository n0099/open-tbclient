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
public class h87 {
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

    public h87() {
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

    public static h87 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            h87 h87Var = new h87();
            h87Var.a = item.itemId;
            h87Var.b = item.itemName;
            h87Var.c = item.iconSize;
            h87Var.d = item.iconUrl;
            h87Var.e = item.tags;
            h87Var.f = item.score;
            h87Var.g = item.star;
            h87Var.h = item.buttonName;
            h87Var.i = item.buttonLink;
            h87Var.j = item.itemAppid;
            h87Var.k = item.categoryId;
            h87Var.l = item.buttonLinkType;
            h87Var.m = item.apkName;
            h87Var.n = item.forumName;
            h87Var.o = ApkDetailPojo.z(item.apkDetail);
            return h87Var;
        }
        return (h87) invokeL.objValue;
    }

    public static h87 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            h87 h87Var = new h87();
            h87Var.a = item.item_id;
            h87Var.b = item.item_name;
            h87Var.c = item.icon_size;
            h87Var.d = item.icon_url;
            h87Var.e = item.tags;
            h87Var.f = item.score;
            h87Var.g = item.star;
            h87Var.h = item.button_name;
            h87Var.i = item.button_link;
            h87Var.j = item.item_appid;
            h87Var.k = item.category_id;
            h87Var.l = item.button_link_type;
            h87Var.m = item.apk_name;
            h87Var.n = item.forum_name;
            h87Var.o = ApkDetailPojo.A(item.apk_detail);
            return h87Var;
        }
        return (h87) invokeL.objValue;
    }
}
