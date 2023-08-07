package com.baidu.tieba;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes5.dex */
public class ac8 {
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

    public ac8() {
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

    public static ac8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ac8 ac8Var = new ac8();
            ac8Var.a = item.itemId;
            ac8Var.b = item.itemName;
            ac8Var.c = item.iconSize;
            ac8Var.d = item.iconUrl;
            ac8Var.e = item.tags;
            ac8Var.f = item.score;
            ac8Var.g = item.star;
            ac8Var.h = item.buttonName;
            ac8Var.i = item.buttonLink;
            ac8Var.j = item.itemAppid;
            ac8Var.k = item.categoryId;
            ac8Var.l = item.buttonLinkType;
            ac8Var.m = item.apkName;
            ac8Var.n = item.forumName;
            ac8Var.o = ApkDetailPojo.N(item.apkDetail);
            return ac8Var;
        }
        return (ac8) invokeL.objValue;
    }

    public static ac8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ac8 ac8Var = new ac8();
            ac8Var.a = item.item_id;
            ac8Var.b = item.item_name;
            ac8Var.c = item.icon_size;
            ac8Var.d = item.icon_url;
            ac8Var.e = item.tags;
            ac8Var.f = item.score;
            ac8Var.g = item.star;
            ac8Var.h = item.button_name;
            ac8Var.i = item.button_link;
            ac8Var.j = item.item_appid;
            ac8Var.k = item.category_id;
            ac8Var.l = item.button_link_type;
            ac8Var.m = item.apk_name;
            ac8Var.n = item.forum_name;
            ac8Var.o = ApkDetailPojo.O(item.apk_detail);
            return ac8Var;
        }
        return (ac8) invokeL.objValue;
    }
}
