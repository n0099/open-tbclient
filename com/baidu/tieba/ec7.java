package com.baidu.tieba;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes3.dex */
public class ec7 {
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

    public ec7() {
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

    public static ec7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ec7 ec7Var = new ec7();
            ec7Var.a = item.itemId;
            ec7Var.b = item.itemName;
            ec7Var.c = item.iconSize;
            ec7Var.d = item.iconUrl;
            ec7Var.e = item.tags;
            ec7Var.f = item.score;
            ec7Var.g = item.star;
            ec7Var.h = item.buttonName;
            ec7Var.i = item.buttonLink;
            ec7Var.j = item.itemAppid;
            ec7Var.k = item.categoryId;
            ec7Var.l = item.buttonLinkType;
            ec7Var.m = item.apkName;
            ec7Var.n = item.forumName;
            ec7Var.o = ApkDetailPojo.z(item.apkDetail);
            return ec7Var;
        }
        return (ec7) invokeL.objValue;
    }

    public static ec7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ec7 ec7Var = new ec7();
            ec7Var.a = item.item_id;
            ec7Var.b = item.item_name;
            ec7Var.c = item.icon_size;
            ec7Var.d = item.icon_url;
            ec7Var.e = item.tags;
            ec7Var.f = item.score;
            ec7Var.g = item.star;
            ec7Var.h = item.button_name;
            ec7Var.i = item.button_link;
            ec7Var.j = item.item_appid;
            ec7Var.k = item.category_id;
            ec7Var.l = item.button_link_type;
            ec7Var.m = item.apk_name;
            ec7Var.n = item.forum_name;
            ec7Var.o = ApkDetailPojo.A(item.apk_detail);
            return ec7Var;
        }
        return (ec7) invokeL.objValue;
    }
}
