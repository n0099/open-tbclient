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
public class br8 {
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

    public br8() {
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

    public static br8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            br8 br8Var = new br8();
            br8Var.a = item.itemId;
            br8Var.b = item.itemName;
            br8Var.c = item.iconSize;
            br8Var.d = item.iconUrl;
            br8Var.e = item.tags;
            br8Var.f = item.score;
            br8Var.g = item.star;
            br8Var.h = item.buttonName;
            br8Var.i = item.buttonLink;
            br8Var.j = item.itemAppid;
            br8Var.k = item.categoryId;
            br8Var.l = item.buttonLinkType;
            br8Var.m = item.apkName;
            br8Var.n = item.forumName;
            br8Var.o = ApkDetailPojo.O(item.apkDetail);
            return br8Var;
        }
        return (br8) invokeL.objValue;
    }

    public static br8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            br8 br8Var = new br8();
            br8Var.a = item.item_id;
            br8Var.b = item.item_name;
            br8Var.c = item.icon_size;
            br8Var.d = item.icon_url;
            br8Var.e = item.tags;
            br8Var.f = item.score;
            br8Var.g = item.star;
            br8Var.h = item.button_name;
            br8Var.i = item.button_link;
            br8Var.j = item.item_appid;
            br8Var.k = item.category_id;
            br8Var.l = item.button_link_type;
            br8Var.m = item.apk_name;
            br8Var.n = item.forum_name;
            br8Var.o = ApkDetailPojo.P(item.apk_detail);
            return br8Var;
        }
        return (br8) invokeL.objValue;
    }
}
