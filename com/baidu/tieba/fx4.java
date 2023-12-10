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
/* loaded from: classes6.dex */
public class fx4 implements Comparable<fx4> {
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

    public fx4(int i, int i2) {
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

    public static fx4 b(TbLinkSpanGroup tbLinkSpanGroup, da8 da8Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, da8Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            fx4 fx4Var = new fx4(tbLinkSpanGroup.e(), 2);
            if (da8Var == null) {
                return fx4Var;
            }
            if (TextUtils.isEmpty(da8Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = da8Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            fx4Var.d = str;
            fx4Var.c = da8Var.c();
            fx4Var.m = da8Var.a();
            if (!ListUtils.isEmpty(da8Var.b()) && da8Var.b().get(0) != null) {
                fx4Var.e = da8Var.b().get(0).a();
            }
            fx4Var.l = da8Var.f();
            fx4Var.f = da8Var.d();
            if (da8Var.e() != null) {
                fx4Var.j = da8Var.e().a();
                fx4Var.k = da8Var.e().b();
            }
            tbLinkSpanGroup.B(fx4Var);
            return fx4Var;
        }
        return (fx4) invokeLL.objValue;
    }

    public static fx4 c(TbLinkSpanGroup tbLinkSpanGroup, d75 d75Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, d75Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            fx4 fx4Var = new fx4(tbLinkSpanGroup.e(), 1);
            if (d75Var == null) {
                return fx4Var;
            }
            int i = d75Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = d75Var.j;
                if (cardLinkInfoData != null) {
                    fx4Var.p = cardLinkInfoData;
                    fx4Var.c = cardLinkInfoData.title;
                    fx4Var.e = cardLinkInfoData.imageUrl;
                    fx4Var.l = cardLinkInfoData.tagText;
                    fx4Var.g = cardLinkInfoData.url;
                    fx4Var.i = false;
                    fx4Var.o = i;
                }
            } else {
                fx4Var.p = d75Var.j;
                fx4Var.c = d75Var.e;
                fx4Var.e = d75Var.d;
                fx4Var.l = d75Var.f;
                fx4Var.f = d75Var.g;
                fx4Var.g = d75Var.c;
                fx4Var.n = d75Var.h;
                String str = d75Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                fx4Var.i = z;
                fx4Var.o = d75Var.b;
            }
            tbLinkSpanGroup.B(fx4Var);
            return fx4Var;
        }
        return (fx4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull fx4 fx4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fx4Var)) == null) {
            return this.q - fx4Var.q;
        }
        return invokeL.intValue;
    }
}
