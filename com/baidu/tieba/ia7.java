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
public class ia7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;
    public String b;
    public Double c;
    public String d;
    public List e;
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

    public ia7() {
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

    public static ia7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ia7 ia7Var = new ia7();
            ia7Var.a = item.itemId;
            ia7Var.b = item.itemName;
            ia7Var.c = item.iconSize;
            ia7Var.d = item.iconUrl;
            ia7Var.e = item.tags;
            ia7Var.f = item.score;
            ia7Var.g = item.star;
            ia7Var.h = item.buttonName;
            ia7Var.i = item.buttonLink;
            ia7Var.j = item.itemAppid;
            ia7Var.k = item.categoryId;
            ia7Var.l = item.buttonLinkType;
            ia7Var.m = item.apkName;
            ia7Var.n = item.forumName;
            ia7Var.o = ApkDetailPojo.z(item.apkDetail);
            return ia7Var;
        }
        return (ia7) invokeL.objValue;
    }

    public static ia7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ia7 ia7Var = new ia7();
            ia7Var.a = item.item_id;
            ia7Var.b = item.item_name;
            ia7Var.c = item.icon_size;
            ia7Var.d = item.icon_url;
            ia7Var.e = item.tags;
            ia7Var.f = item.score;
            ia7Var.g = item.star;
            ia7Var.h = item.button_name;
            ia7Var.i = item.button_link;
            ia7Var.j = item.item_appid;
            ia7Var.k = item.category_id;
            ia7Var.l = item.button_link_type;
            ia7Var.m = item.apk_name;
            ia7Var.n = item.forum_name;
            ia7Var.o = ApkDetailPojo.A(item.apk_detail);
            return ia7Var;
        }
        return (ia7) invokeL.objValue;
    }
}
