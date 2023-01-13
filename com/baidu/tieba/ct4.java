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
public class ct4 implements Comparable<ct4> {
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

    public ct4(int i, int i2) {
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

    public static ct4 b(TbLinkSpanGroup tbLinkSpanGroup, w27 w27Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, w27Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ct4 ct4Var = new ct4(tbLinkSpanGroup.e(), 2);
            if (w27Var == null) {
                return ct4Var;
            }
            if (TextUtils.isEmpty(w27Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = w27Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            ct4Var.d = str;
            ct4Var.c = w27Var.c();
            ct4Var.m = w27Var.a();
            if (!ListUtils.isEmpty(w27Var.b()) && w27Var.b().get(0) != null) {
                ct4Var.e = w27Var.b().get(0).a();
            }
            ct4Var.l = w27Var.f();
            ct4Var.f = w27Var.d();
            if (w27Var.e() != null) {
                ct4Var.j = w27Var.e().a();
                ct4Var.k = w27Var.e().b();
            }
            tbLinkSpanGroup.z(ct4Var);
            return ct4Var;
        }
        return (ct4) invokeLL.objValue;
    }

    public static ct4 c(TbLinkSpanGroup tbLinkSpanGroup, a15 a15Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, a15Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            ct4 ct4Var = new ct4(tbLinkSpanGroup.e(), 1);
            if (a15Var == null) {
                return ct4Var;
            }
            int i = a15Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = a15Var.j;
                if (cardLinkInfoData != null) {
                    ct4Var.p = cardLinkInfoData;
                    ct4Var.c = cardLinkInfoData.title;
                    ct4Var.e = cardLinkInfoData.imageUrl;
                    ct4Var.l = cardLinkInfoData.tagText;
                    ct4Var.g = cardLinkInfoData.url;
                    ct4Var.i = false;
                    ct4Var.o = i;
                }
            } else {
                ct4Var.p = a15Var.j;
                ct4Var.c = a15Var.e;
                ct4Var.e = a15Var.d;
                ct4Var.l = a15Var.f;
                ct4Var.f = a15Var.g;
                ct4Var.g = a15Var.c;
                ct4Var.n = a15Var.h;
                String str = a15Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                ct4Var.i = z;
                ct4Var.o = a15Var.b;
            }
            tbLinkSpanGroup.z(ct4Var);
            return ct4Var;
        }
        return (ct4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull ct4 ct4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ct4Var)) == null) {
            return this.q - ct4Var.q;
        }
        return invokeL.intValue;
    }
}
