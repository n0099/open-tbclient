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
public class bh7 {
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

    public bh7() {
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

    public static bh7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            bh7 bh7Var = new bh7();
            bh7Var.a = item.itemId;
            bh7Var.b = item.itemName;
            bh7Var.c = item.iconSize;
            bh7Var.d = item.iconUrl;
            bh7Var.e = item.tags;
            bh7Var.f = item.score;
            bh7Var.g = item.star;
            bh7Var.h = item.buttonName;
            bh7Var.i = item.buttonLink;
            bh7Var.j = item.itemAppid;
            bh7Var.k = item.categoryId;
            bh7Var.l = item.buttonLinkType;
            bh7Var.m = item.apkName;
            bh7Var.n = item.forumName;
            bh7Var.o = ApkDetailPojo.G(item.apkDetail);
            return bh7Var;
        }
        return (bh7) invokeL.objValue;
    }

    public static bh7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            bh7 bh7Var = new bh7();
            bh7Var.a = item.item_id;
            bh7Var.b = item.item_name;
            bh7Var.c = item.icon_size;
            bh7Var.d = item.icon_url;
            bh7Var.e = item.tags;
            bh7Var.f = item.score;
            bh7Var.g = item.star;
            bh7Var.h = item.button_name;
            bh7Var.i = item.button_link;
            bh7Var.j = item.item_appid;
            bh7Var.k = item.category_id;
            bh7Var.l = item.button_link_type;
            bh7Var.m = item.apk_name;
            bh7Var.n = item.forum_name;
            bh7Var.o = ApkDetailPojo.H(item.apk_detail);
            return bh7Var;
        }
        return (bh7) invokeL.objValue;
    }
}
