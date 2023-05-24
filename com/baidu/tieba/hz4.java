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
public class hz4 implements Comparable<hz4> {
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

    public hz4(int i, int i2) {
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

    public static hz4 b(TbLinkSpanGroup tbLinkSpanGroup, qo7 qo7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, qo7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            hz4 hz4Var = new hz4(tbLinkSpanGroup.e(), 2);
            if (qo7Var == null) {
                return hz4Var;
            }
            if (TextUtils.isEmpty(qo7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = qo7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            hz4Var.d = str;
            hz4Var.c = qo7Var.c();
            hz4Var.m = qo7Var.a();
            if (!ListUtils.isEmpty(qo7Var.b()) && qo7Var.b().get(0) != null) {
                hz4Var.e = qo7Var.b().get(0).a();
            }
            hz4Var.l = qo7Var.f();
            hz4Var.f = qo7Var.d();
            if (qo7Var.e() != null) {
                hz4Var.j = qo7Var.e().a();
                hz4Var.k = qo7Var.e().b();
            }
            tbLinkSpanGroup.B(hz4Var);
            return hz4Var;
        }
        return (hz4) invokeLL.objValue;
    }

    public static hz4 c(TbLinkSpanGroup tbLinkSpanGroup, n85 n85Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, n85Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            hz4 hz4Var = new hz4(tbLinkSpanGroup.e(), 1);
            if (n85Var == null) {
                return hz4Var;
            }
            int i = n85Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = n85Var.j;
                if (cardLinkInfoData != null) {
                    hz4Var.p = cardLinkInfoData;
                    hz4Var.c = cardLinkInfoData.title;
                    hz4Var.e = cardLinkInfoData.imageUrl;
                    hz4Var.l = cardLinkInfoData.tagText;
                    hz4Var.g = cardLinkInfoData.url;
                    hz4Var.i = false;
                    hz4Var.o = i;
                }
            } else {
                hz4Var.p = n85Var.j;
                hz4Var.c = n85Var.e;
                hz4Var.e = n85Var.d;
                hz4Var.l = n85Var.f;
                hz4Var.f = n85Var.g;
                hz4Var.g = n85Var.c;
                hz4Var.n = n85Var.h;
                String str = n85Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                hz4Var.i = z;
                hz4Var.o = n85Var.b;
            }
            tbLinkSpanGroup.B(hz4Var);
            return hz4Var;
        }
        return (hz4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull hz4 hz4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hz4Var)) == null) {
            return this.q - hz4Var.q;
        }
        return invokeL.intValue;
    }
}
