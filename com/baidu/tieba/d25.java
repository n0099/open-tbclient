package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d25 implements Comparable<d25> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public CardLinkInfoData p;
    public int q;

    public d25(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
    }

    public static d25 b(TbLinkSpanGroup tbLinkSpanGroup, cu7 cu7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, cu7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            d25 d25Var = new d25(tbLinkSpanGroup.e(), 2);
            if (cu7Var == null) {
                return d25Var;
            }
            if (TextUtils.isEmpty(cu7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = cu7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            d25Var.d = str;
            d25Var.c = cu7Var.c();
            d25Var.m = cu7Var.a();
            if (!ListUtils.isEmpty(cu7Var.b()) && cu7Var.b().get(0) != null) {
                d25Var.e = cu7Var.b().get(0).a();
            }
            d25Var.l = cu7Var.f();
            d25Var.f = cu7Var.d();
            if (cu7Var.e() != null) {
                d25Var.j = cu7Var.e().a();
                d25Var.k = cu7Var.e().b();
            }
            tbLinkSpanGroup.B(d25Var);
            return d25Var;
        }
        return (d25) invokeLL.objValue;
    }

    public static d25 c(TbLinkSpanGroup tbLinkSpanGroup, jb5 jb5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, jb5Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            d25 d25Var = new d25(tbLinkSpanGroup.e(), 1);
            if (jb5Var == null) {
                return d25Var;
            }
            int i = jb5Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = jb5Var.j;
                if (cardLinkInfoData != null) {
                    d25Var.p = cardLinkInfoData;
                    d25Var.c = cardLinkInfoData.title;
                    d25Var.e = cardLinkInfoData.imageUrl;
                    d25Var.l = cardLinkInfoData.tagText;
                    d25Var.g = cardLinkInfoData.url;
                    d25Var.i = false;
                    d25Var.o = i;
                }
            } else {
                d25Var.p = jb5Var.j;
                d25Var.c = jb5Var.e;
                d25Var.e = jb5Var.d;
                d25Var.l = jb5Var.f;
                d25Var.f = jb5Var.g;
                d25Var.g = jb5Var.c;
                d25Var.n = jb5Var.h;
                String str = jb5Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                d25Var.i = z;
                d25Var.o = jb5Var.b;
            }
            tbLinkSpanGroup.B(d25Var);
            return d25Var;
        }
        return (d25) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull d25 d25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d25Var)) == null) {
            return this.q - d25Var.q;
        }
        return invokeL.intValue;
    }
}
