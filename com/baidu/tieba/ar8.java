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
public class ar8 {
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

    public ar8() {
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

    public static ar8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ar8 ar8Var = new ar8();
            ar8Var.a = item.itemId;
            ar8Var.b = item.itemName;
            ar8Var.c = item.iconSize;
            ar8Var.d = item.iconUrl;
            ar8Var.e = item.tags;
            ar8Var.f = item.score;
            ar8Var.g = item.star;
            ar8Var.h = item.buttonName;
            ar8Var.i = item.buttonLink;
            ar8Var.j = item.itemAppid;
            ar8Var.k = item.categoryId;
            ar8Var.l = item.buttonLinkType;
            ar8Var.m = item.apkName;
            ar8Var.n = item.forumName;
            ar8Var.o = ApkDetailPojo.O(item.apkDetail);
            return ar8Var;
        }
        return (ar8) invokeL.objValue;
    }

    public static ar8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ar8 ar8Var = new ar8();
            ar8Var.a = item.item_id;
            ar8Var.b = item.item_name;
            ar8Var.c = item.icon_size;
            ar8Var.d = item.icon_url;
            ar8Var.e = item.tags;
            ar8Var.f = item.score;
            ar8Var.g = item.star;
            ar8Var.h = item.button_name;
            ar8Var.i = item.button_link;
            ar8Var.j = item.item_appid;
            ar8Var.k = item.category_id;
            ar8Var.l = item.button_link_type;
            ar8Var.m = item.apk_name;
            ar8Var.n = item.forum_name;
            ar8Var.o = ApkDetailPojo.P(item.apk_detail);
            return ar8Var;
        }
        return (ar8) invokeL.objValue;
    }
}
