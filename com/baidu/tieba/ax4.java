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
public class ax4 implements Comparable<ax4> {
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

    public ax4(int i, int i2) {
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

    public static ax4 b(TbLinkSpanGroup tbLinkSpanGroup, d78 d78Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, d78Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ax4 ax4Var = new ax4(tbLinkSpanGroup.e(), 2);
            if (d78Var == null) {
                return ax4Var;
            }
            if (TextUtils.isEmpty(d78Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = d78Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            ax4Var.d = str;
            ax4Var.c = d78Var.c();
            ax4Var.m = d78Var.a();
            if (!ListUtils.isEmpty(d78Var.b()) && d78Var.b().get(0) != null) {
                ax4Var.e = d78Var.b().get(0).a();
            }
            ax4Var.l = d78Var.f();
            ax4Var.f = d78Var.d();
            if (d78Var.e() != null) {
                ax4Var.j = d78Var.e().a();
                ax4Var.k = d78Var.e().b();
            }
            tbLinkSpanGroup.B(ax4Var);
            return ax4Var;
        }
        return (ax4) invokeLL.objValue;
    }

    public static ax4 c(TbLinkSpanGroup tbLinkSpanGroup, t65 t65Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, t65Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            ax4 ax4Var = new ax4(tbLinkSpanGroup.e(), 1);
            if (t65Var == null) {
                return ax4Var;
            }
            int i = t65Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = t65Var.j;
                if (cardLinkInfoData != null) {
                    ax4Var.p = cardLinkInfoData;
                    ax4Var.c = cardLinkInfoData.title;
                    ax4Var.e = cardLinkInfoData.imageUrl;
                    ax4Var.l = cardLinkInfoData.tagText;
                    ax4Var.g = cardLinkInfoData.url;
                    ax4Var.i = false;
                    ax4Var.o = i;
                }
            } else {
                ax4Var.p = t65Var.j;
                ax4Var.c = t65Var.e;
                ax4Var.e = t65Var.d;
                ax4Var.l = t65Var.f;
                ax4Var.f = t65Var.g;
                ax4Var.g = t65Var.c;
                ax4Var.n = t65Var.h;
                String str = t65Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                ax4Var.i = z;
                ax4Var.o = t65Var.b;
            }
            tbLinkSpanGroup.B(ax4Var);
            return ax4Var;
        }
        return (ax4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull ax4 ax4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ax4Var)) == null) {
            return this.q - ax4Var.q;
        }
        return invokeL.intValue;
    }
}
