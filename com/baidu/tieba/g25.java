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
public class g25 implements Comparable<g25> {
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

    public g25(int i, int i2) {
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

    public static g25 b(TbLinkSpanGroup tbLinkSpanGroup, mu7 mu7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, mu7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            g25 g25Var = new g25(tbLinkSpanGroup.e(), 2);
            if (mu7Var == null) {
                return g25Var;
            }
            if (TextUtils.isEmpty(mu7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = mu7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            g25Var.d = str;
            g25Var.c = mu7Var.c();
            g25Var.m = mu7Var.a();
            if (!ListUtils.isEmpty(mu7Var.b()) && mu7Var.b().get(0) != null) {
                g25Var.e = mu7Var.b().get(0).a();
            }
            g25Var.l = mu7Var.f();
            g25Var.f = mu7Var.d();
            if (mu7Var.e() != null) {
                g25Var.j = mu7Var.e().a();
                g25Var.k = mu7Var.e().b();
            }
            tbLinkSpanGroup.B(g25Var);
            return g25Var;
        }
        return (g25) invokeLL.objValue;
    }

    public static g25 c(TbLinkSpanGroup tbLinkSpanGroup, mb5 mb5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, mb5Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            g25 g25Var = new g25(tbLinkSpanGroup.e(), 1);
            if (mb5Var == null) {
                return g25Var;
            }
            int i = mb5Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = mb5Var.j;
                if (cardLinkInfoData != null) {
                    g25Var.p = cardLinkInfoData;
                    g25Var.c = cardLinkInfoData.title;
                    g25Var.e = cardLinkInfoData.imageUrl;
                    g25Var.l = cardLinkInfoData.tagText;
                    g25Var.g = cardLinkInfoData.url;
                    g25Var.i = false;
                    g25Var.o = i;
                }
            } else {
                g25Var.p = mb5Var.j;
                g25Var.c = mb5Var.e;
                g25Var.e = mb5Var.d;
                g25Var.l = mb5Var.f;
                g25Var.f = mb5Var.g;
                g25Var.g = mb5Var.c;
                g25Var.n = mb5Var.h;
                String str = mb5Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                g25Var.i = z;
                g25Var.o = mb5Var.b;
            }
            tbLinkSpanGroup.B(g25Var);
            return g25Var;
        }
        return (g25) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull g25 g25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, g25Var)) == null) {
            return this.q - g25Var.q;
        }
        return invokeL.intValue;
    }
}
