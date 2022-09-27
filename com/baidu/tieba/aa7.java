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
public class aa7 {
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

    public aa7() {
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

    public static aa7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            aa7 aa7Var = new aa7();
            aa7Var.a = item.itemId;
            aa7Var.b = item.itemName;
            aa7Var.c = item.iconSize;
            aa7Var.d = item.iconUrl;
            aa7Var.e = item.tags;
            aa7Var.f = item.score;
            aa7Var.g = item.star;
            aa7Var.h = item.buttonName;
            aa7Var.i = item.buttonLink;
            aa7Var.j = item.itemAppid;
            aa7Var.k = item.categoryId;
            aa7Var.l = item.buttonLinkType;
            aa7Var.m = item.apkName;
            aa7Var.n = item.forumName;
            aa7Var.o = ApkDetailPojo.z(item.apkDetail);
            return aa7Var;
        }
        return (aa7) invokeL.objValue;
    }

    public static aa7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            aa7 aa7Var = new aa7();
            aa7Var.a = item.item_id;
            aa7Var.b = item.item_name;
            aa7Var.c = item.icon_size;
            aa7Var.d = item.icon_url;
            aa7Var.e = item.tags;
            aa7Var.f = item.score;
            aa7Var.g = item.star;
            aa7Var.h = item.button_name;
            aa7Var.i = item.button_link;
            aa7Var.j = item.item_appid;
            aa7Var.k = item.category_id;
            aa7Var.l = item.button_link_type;
            aa7Var.m = item.apk_name;
            aa7Var.n = item.forum_name;
            aa7Var.o = ApkDetailPojo.A(item.apk_detail);
            return aa7Var;
        }
        return (aa7) invokeL.objValue;
    }
}
