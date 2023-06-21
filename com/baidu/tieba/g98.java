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
public class g98 {
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

    public g98() {
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

    public static g98 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            g98 g98Var = new g98();
            g98Var.a = item.itemId;
            g98Var.b = item.itemName;
            g98Var.c = item.iconSize;
            g98Var.d = item.iconUrl;
            g98Var.e = item.tags;
            g98Var.f = item.score;
            g98Var.g = item.star;
            g98Var.h = item.buttonName;
            g98Var.i = item.buttonLink;
            g98Var.j = item.itemAppid;
            g98Var.k = item.categoryId;
            g98Var.l = item.buttonLinkType;
            g98Var.m = item.apkName;
            g98Var.n = item.forumName;
            g98Var.o = ApkDetailPojo.U(item.apkDetail);
            return g98Var;
        }
        return (g98) invokeL.objValue;
    }

    public static g98 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            g98 g98Var = new g98();
            g98Var.a = item.item_id;
            g98Var.b = item.item_name;
            g98Var.c = item.icon_size;
            g98Var.d = item.icon_url;
            g98Var.e = item.tags;
            g98Var.f = item.score;
            g98Var.g = item.star;
            g98Var.h = item.button_name;
            g98Var.i = item.button_link;
            g98Var.j = item.item_appid;
            g98Var.k = item.category_id;
            g98Var.l = item.button_link_type;
            g98Var.m = item.apk_name;
            g98Var.n = item.forum_name;
            g98Var.o = ApkDetailPojo.V(item.apk_detail);
            return g98Var;
        }
        return (g98) invokeL.objValue;
    }
}
