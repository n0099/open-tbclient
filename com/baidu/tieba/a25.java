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
public class a25 implements Comparable<a25> {
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

    public a25(int i, int i2) {
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

    public static a25 b(TbLinkSpanGroup tbLinkSpanGroup, vz7 vz7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, vz7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            a25 a25Var = new a25(tbLinkSpanGroup.e(), 2);
            if (vz7Var == null) {
                return a25Var;
            }
            if (TextUtils.isEmpty(vz7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = vz7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            a25Var.d = str;
            a25Var.c = vz7Var.c();
            a25Var.m = vz7Var.a();
            if (!ListUtils.isEmpty(vz7Var.b()) && vz7Var.b().get(0) != null) {
                a25Var.e = vz7Var.b().get(0).a();
            }
            a25Var.l = vz7Var.f();
            a25Var.f = vz7Var.d();
            if (vz7Var.e() != null) {
                a25Var.j = vz7Var.e().a();
                a25Var.k = vz7Var.e().b();
            }
            tbLinkSpanGroup.B(a25Var);
            return a25Var;
        }
        return (a25) invokeLL.objValue;
    }

    public static a25 c(TbLinkSpanGroup tbLinkSpanGroup, nb5 nb5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, nb5Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            a25 a25Var = new a25(tbLinkSpanGroup.e(), 1);
            if (nb5Var == null) {
                return a25Var;
            }
            int i = nb5Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = nb5Var.j;
                if (cardLinkInfoData != null) {
                    a25Var.p = cardLinkInfoData;
                    a25Var.c = cardLinkInfoData.title;
                    a25Var.e = cardLinkInfoData.imageUrl;
                    a25Var.l = cardLinkInfoData.tagText;
                    a25Var.g = cardLinkInfoData.url;
                    a25Var.i = false;
                    a25Var.o = i;
                }
            } else {
                a25Var.p = nb5Var.j;
                a25Var.c = nb5Var.e;
                a25Var.e = nb5Var.d;
                a25Var.l = nb5Var.f;
                a25Var.f = nb5Var.g;
                a25Var.g = nb5Var.c;
                a25Var.n = nb5Var.h;
                String str = nb5Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                a25Var.i = z;
                a25Var.o = nb5Var.b;
            }
            tbLinkSpanGroup.B(a25Var);
            return a25Var;
        }
        return (a25) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull a25 a25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a25Var)) == null) {
            return this.q - a25Var.q;
        }
        return invokeL.intValue;
    }
}
