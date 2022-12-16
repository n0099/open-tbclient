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
public class ed7 {
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

    public ed7() {
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

    public static ed7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ed7 ed7Var = new ed7();
            ed7Var.a = item.itemId;
            ed7Var.b = item.itemName;
            ed7Var.c = item.iconSize;
            ed7Var.d = item.iconUrl;
            ed7Var.e = item.tags;
            ed7Var.f = item.score;
            ed7Var.g = item.star;
            ed7Var.h = item.buttonName;
            ed7Var.i = item.buttonLink;
            ed7Var.j = item.itemAppid;
            ed7Var.k = item.categoryId;
            ed7Var.l = item.buttonLinkType;
            ed7Var.m = item.apkName;
            ed7Var.n = item.forumName;
            ed7Var.o = ApkDetailPojo.G(item.apkDetail);
            return ed7Var;
        }
        return (ed7) invokeL.objValue;
    }

    public static ed7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ed7 ed7Var = new ed7();
            ed7Var.a = item.item_id;
            ed7Var.b = item.item_name;
            ed7Var.c = item.icon_size;
            ed7Var.d = item.icon_url;
            ed7Var.e = item.tags;
            ed7Var.f = item.score;
            ed7Var.g = item.star;
            ed7Var.h = item.button_name;
            ed7Var.i = item.button_link;
            ed7Var.j = item.item_appid;
            ed7Var.k = item.category_id;
            ed7Var.l = item.button_link_type;
            ed7Var.m = item.apk_name;
            ed7Var.n = item.forum_name;
            ed7Var.o = ApkDetailPojo.H(item.apk_detail);
            return ed7Var;
        }
        return (ed7) invokeL.objValue;
    }
}
