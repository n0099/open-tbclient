package com.baidu.tieba;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes6.dex */
public class he8 {
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

    public he8() {
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

    public static he8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            he8 he8Var = new he8();
            he8Var.a = item.itemId;
            he8Var.b = item.itemName;
            he8Var.c = item.iconSize;
            he8Var.d = item.iconUrl;
            he8Var.e = item.tags;
            he8Var.f = item.score;
            he8Var.g = item.star;
            he8Var.h = item.buttonName;
            he8Var.i = item.buttonLink;
            he8Var.j = item.itemAppid;
            he8Var.k = item.categoryId;
            he8Var.l = item.buttonLinkType;
            he8Var.m = item.apkName;
            he8Var.n = item.forumName;
            he8Var.o = ApkDetailPojo.V(item.apkDetail);
            return he8Var;
        }
        return (he8) invokeL.objValue;
    }

    public static he8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            he8 he8Var = new he8();
            he8Var.a = item.item_id;
            he8Var.b = item.item_name;
            he8Var.c = item.icon_size;
            he8Var.d = item.icon_url;
            he8Var.e = item.tags;
            he8Var.f = item.score;
            he8Var.g = item.star;
            he8Var.h = item.button_name;
            he8Var.i = item.button_link;
            he8Var.j = item.item_appid;
            he8Var.k = item.category_id;
            he8Var.l = item.button_link_type;
            he8Var.m = item.apk_name;
            he8Var.n = item.forum_name;
            he8Var.o = ApkDetailPojo.W(item.apk_detail);
            return he8Var;
        }
        return (he8) invokeL.objValue;
    }
}
