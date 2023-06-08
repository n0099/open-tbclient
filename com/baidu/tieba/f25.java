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
public class f25 implements Comparable<f25> {
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

    public f25(int i, int i2) {
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

    public static f25 b(TbLinkSpanGroup tbLinkSpanGroup, eu7 eu7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, eu7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            f25 f25Var = new f25(tbLinkSpanGroup.e(), 2);
            if (eu7Var == null) {
                return f25Var;
            }
            if (TextUtils.isEmpty(eu7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = eu7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            f25Var.d = str;
            f25Var.c = eu7Var.c();
            f25Var.m = eu7Var.a();
            if (!ListUtils.isEmpty(eu7Var.b()) && eu7Var.b().get(0) != null) {
                f25Var.e = eu7Var.b().get(0).a();
            }
            f25Var.l = eu7Var.f();
            f25Var.f = eu7Var.d();
            if (eu7Var.e() != null) {
                f25Var.j = eu7Var.e().a();
                f25Var.k = eu7Var.e().b();
            }
            tbLinkSpanGroup.B(f25Var);
            return f25Var;
        }
        return (f25) invokeLL.objValue;
    }

    public static f25 c(TbLinkSpanGroup tbLinkSpanGroup, lb5 lb5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, lb5Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            f25 f25Var = new f25(tbLinkSpanGroup.e(), 1);
            if (lb5Var == null) {
                return f25Var;
            }
            int i = lb5Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = lb5Var.j;
                if (cardLinkInfoData != null) {
                    f25Var.p = cardLinkInfoData;
                    f25Var.c = cardLinkInfoData.title;
                    f25Var.e = cardLinkInfoData.imageUrl;
                    f25Var.l = cardLinkInfoData.tagText;
                    f25Var.g = cardLinkInfoData.url;
                    f25Var.i = false;
                    f25Var.o = i;
                }
            } else {
                f25Var.p = lb5Var.j;
                f25Var.c = lb5Var.e;
                f25Var.e = lb5Var.d;
                f25Var.l = lb5Var.f;
                f25Var.f = lb5Var.g;
                f25Var.g = lb5Var.c;
                f25Var.n = lb5Var.h;
                String str = lb5Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                f25Var.i = z;
                f25Var.o = lb5Var.b;
            }
            tbLinkSpanGroup.B(f25Var);
            return f25Var;
        }
        return (f25) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull f25 f25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f25Var)) == null) {
            return this.q - f25Var.q;
        }
        return invokeL.intValue;
    }
}
