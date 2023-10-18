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
public class ce8 {
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

    public ce8() {
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

    public static ce8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ce8 ce8Var = new ce8();
            ce8Var.a = item.itemId;
            ce8Var.b = item.itemName;
            ce8Var.c = item.iconSize;
            ce8Var.d = item.iconUrl;
            ce8Var.e = item.tags;
            ce8Var.f = item.score;
            ce8Var.g = item.star;
            ce8Var.h = item.buttonName;
            ce8Var.i = item.buttonLink;
            ce8Var.j = item.itemAppid;
            ce8Var.k = item.categoryId;
            ce8Var.l = item.buttonLinkType;
            ce8Var.m = item.apkName;
            ce8Var.n = item.forumName;
            ce8Var.o = ApkDetailPojo.N(item.apkDetail);
            return ce8Var;
        }
        return (ce8) invokeL.objValue;
    }

    public static ce8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ce8 ce8Var = new ce8();
            ce8Var.a = item.item_id;
            ce8Var.b = item.item_name;
            ce8Var.c = item.icon_size;
            ce8Var.d = item.icon_url;
            ce8Var.e = item.tags;
            ce8Var.f = item.score;
            ce8Var.g = item.star;
            ce8Var.h = item.button_name;
            ce8Var.i = item.button_link;
            ce8Var.j = item.item_appid;
            ce8Var.k = item.category_id;
            ce8Var.l = item.button_link_type;
            ce8Var.m = item.apk_name;
            ce8Var.n = item.forum_name;
            ce8Var.o = ApkDetailPojo.O(item.apk_detail);
            return ce8Var;
        }
        return (ce8) invokeL.objValue;
    }
}
