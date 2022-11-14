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
public class dc7 {
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

    public dc7() {
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

    public static dc7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            dc7 dc7Var = new dc7();
            dc7Var.a = item.itemId;
            dc7Var.b = item.itemName;
            dc7Var.c = item.iconSize;
            dc7Var.d = item.iconUrl;
            dc7Var.e = item.tags;
            dc7Var.f = item.score;
            dc7Var.g = item.star;
            dc7Var.h = item.buttonName;
            dc7Var.i = item.buttonLink;
            dc7Var.j = item.itemAppid;
            dc7Var.k = item.categoryId;
            dc7Var.l = item.buttonLinkType;
            dc7Var.m = item.apkName;
            dc7Var.n = item.forumName;
            dc7Var.o = ApkDetailPojo.z(item.apkDetail);
            return dc7Var;
        }
        return (dc7) invokeL.objValue;
    }

    public static dc7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            dc7 dc7Var = new dc7();
            dc7Var.a = item.item_id;
            dc7Var.b = item.item_name;
            dc7Var.c = item.icon_size;
            dc7Var.d = item.icon_url;
            dc7Var.e = item.tags;
            dc7Var.f = item.score;
            dc7Var.g = item.star;
            dc7Var.h = item.button_name;
            dc7Var.i = item.button_link;
            dc7Var.j = item.item_appid;
            dc7Var.k = item.category_id;
            dc7Var.l = item.button_link_type;
            dc7Var.m = item.apk_name;
            dc7Var.n = item.forum_name;
            dc7Var.o = ApkDetailPojo.A(item.apk_detail);
            return dc7Var;
        }
        return (dc7) invokeL.objValue;
    }
}
