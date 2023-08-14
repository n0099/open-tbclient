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
public class bc8 {
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

    public bc8() {
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

    public static bc8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            bc8 bc8Var = new bc8();
            bc8Var.a = item.itemId;
            bc8Var.b = item.itemName;
            bc8Var.c = item.iconSize;
            bc8Var.d = item.iconUrl;
            bc8Var.e = item.tags;
            bc8Var.f = item.score;
            bc8Var.g = item.star;
            bc8Var.h = item.buttonName;
            bc8Var.i = item.buttonLink;
            bc8Var.j = item.itemAppid;
            bc8Var.k = item.categoryId;
            bc8Var.l = item.buttonLinkType;
            bc8Var.m = item.apkName;
            bc8Var.n = item.forumName;
            bc8Var.o = ApkDetailPojo.N(item.apkDetail);
            return bc8Var;
        }
        return (bc8) invokeL.objValue;
    }

    public static bc8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            bc8 bc8Var = new bc8();
            bc8Var.a = item.item_id;
            bc8Var.b = item.item_name;
            bc8Var.c = item.icon_size;
            bc8Var.d = item.icon_url;
            bc8Var.e = item.tags;
            bc8Var.f = item.score;
            bc8Var.g = item.star;
            bc8Var.h = item.button_name;
            bc8Var.i = item.button_link;
            bc8Var.j = item.item_appid;
            bc8Var.k = item.category_id;
            bc8Var.l = item.button_link_type;
            bc8Var.m = item.apk_name;
            bc8Var.n = item.forum_name;
            bc8Var.o = ApkDetailPojo.O(item.apk_detail);
            return bc8Var;
        }
        return (bc8) invokeL.objValue;
    }
}
