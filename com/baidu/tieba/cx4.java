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
public class cx4 implements Comparable<cx4> {
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

    public cx4(int i, int i2) {
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

    public static cx4 b(TbLinkSpanGroup tbLinkSpanGroup, y98 y98Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, y98Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            cx4 cx4Var = new cx4(tbLinkSpanGroup.e(), 2);
            if (y98Var == null) {
                return cx4Var;
            }
            if (TextUtils.isEmpty(y98Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = y98Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            cx4Var.d = str;
            cx4Var.c = y98Var.c();
            cx4Var.m = y98Var.a();
            if (!ListUtils.isEmpty(y98Var.b()) && y98Var.b().get(0) != null) {
                cx4Var.e = y98Var.b().get(0).a();
            }
            cx4Var.l = y98Var.f();
            cx4Var.f = y98Var.d();
            if (y98Var.e() != null) {
                cx4Var.j = y98Var.e().a();
                cx4Var.k = y98Var.e().b();
            }
            tbLinkSpanGroup.B(cx4Var);
            return cx4Var;
        }
        return (cx4) invokeLL.objValue;
    }

    public static cx4 c(TbLinkSpanGroup tbLinkSpanGroup, a75 a75Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, a75Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            cx4 cx4Var = new cx4(tbLinkSpanGroup.e(), 1);
            if (a75Var == null) {
                return cx4Var;
            }
            int i = a75Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = a75Var.j;
                if (cardLinkInfoData != null) {
                    cx4Var.p = cardLinkInfoData;
                    cx4Var.c = cardLinkInfoData.title;
                    cx4Var.e = cardLinkInfoData.imageUrl;
                    cx4Var.l = cardLinkInfoData.tagText;
                    cx4Var.g = cardLinkInfoData.url;
                    cx4Var.i = false;
                    cx4Var.o = i;
                }
            } else {
                cx4Var.p = a75Var.j;
                cx4Var.c = a75Var.e;
                cx4Var.e = a75Var.d;
                cx4Var.l = a75Var.f;
                cx4Var.f = a75Var.g;
                cx4Var.g = a75Var.c;
                cx4Var.n = a75Var.h;
                String str = a75Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                cx4Var.i = z;
                cx4Var.o = a75Var.b;
            }
            tbLinkSpanGroup.B(cx4Var);
            return cx4Var;
        }
        return (cx4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull cx4 cx4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cx4Var)) == null) {
            return this.q - cx4Var.q;
        }
        return invokeL.intValue;
    }
}
