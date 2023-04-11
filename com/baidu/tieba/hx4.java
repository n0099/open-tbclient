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
/* loaded from: classes4.dex */
public class hx4 implements Comparable<hx4> {
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

    public hx4(int i, int i2) {
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

    public static hx4 b(TbLinkSpanGroup tbLinkSpanGroup, gl7 gl7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, gl7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            hx4 hx4Var = new hx4(tbLinkSpanGroup.e(), 2);
            if (gl7Var == null) {
                return hx4Var;
            }
            if (TextUtils.isEmpty(gl7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = gl7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            hx4Var.d = str;
            hx4Var.c = gl7Var.c();
            hx4Var.m = gl7Var.a();
            if (!ListUtils.isEmpty(gl7Var.b()) && gl7Var.b().get(0) != null) {
                hx4Var.e = gl7Var.b().get(0).a();
            }
            hx4Var.l = gl7Var.f();
            hx4Var.f = gl7Var.d();
            if (gl7Var.e() != null) {
                hx4Var.j = gl7Var.e().a();
                hx4Var.k = gl7Var.e().b();
            }
            tbLinkSpanGroup.B(hx4Var);
            return hx4Var;
        }
        return (hx4) invokeLL.objValue;
    }

    public static hx4 c(TbLinkSpanGroup tbLinkSpanGroup, n65 n65Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, n65Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            hx4 hx4Var = new hx4(tbLinkSpanGroup.e(), 1);
            if (n65Var == null) {
                return hx4Var;
            }
            int i = n65Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = n65Var.j;
                if (cardLinkInfoData != null) {
                    hx4Var.p = cardLinkInfoData;
                    hx4Var.c = cardLinkInfoData.title;
                    hx4Var.e = cardLinkInfoData.imageUrl;
                    hx4Var.l = cardLinkInfoData.tagText;
                    hx4Var.g = cardLinkInfoData.url;
                    hx4Var.i = false;
                    hx4Var.o = i;
                }
            } else {
                hx4Var.p = n65Var.j;
                hx4Var.c = n65Var.e;
                hx4Var.e = n65Var.d;
                hx4Var.l = n65Var.f;
                hx4Var.f = n65Var.g;
                hx4Var.g = n65Var.c;
                hx4Var.n = n65Var.h;
                String str = n65Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                hx4Var.i = z;
                hx4Var.o = n65Var.b;
            }
            tbLinkSpanGroup.B(hx4Var);
            return hx4Var;
        }
        return (hx4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull hx4 hx4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hx4Var)) == null) {
            return this.q - hx4Var.q;
        }
        return invokeL.intValue;
    }
}
