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
/* loaded from: classes3.dex */
public class ep4 implements Comparable<ep4> {
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

    public ep4(int i, int i2) {
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

    public static ep4 b(TbLinkSpanGroup tbLinkSpanGroup, cu6 cu6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, cu6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ep4 ep4Var = new ep4(tbLinkSpanGroup.e(), 2);
            if (cu6Var == null) {
                return ep4Var;
            }
            if (TextUtils.isEmpty(cu6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1599);
            } else {
                str = cu6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0414);
            }
            ep4Var.d = str;
            ep4Var.c = cu6Var.c();
            ep4Var.m = cu6Var.a();
            if (!ListUtils.isEmpty(cu6Var.b()) && cu6Var.b().get(0) != null) {
                ep4Var.e = cu6Var.b().get(0).a();
            }
            ep4Var.l = cu6Var.f();
            ep4Var.f = cu6Var.d();
            if (cu6Var.e() != null) {
                ep4Var.j = cu6Var.e().a();
                ep4Var.k = cu6Var.e().b();
            }
            tbLinkSpanGroup.A(ep4Var);
            return ep4Var;
        }
        return (ep4) invokeLL.objValue;
    }

    public static ep4 c(TbLinkSpanGroup tbLinkSpanGroup, tw4 tw4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, tw4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ep4 ep4Var = new ep4(tbLinkSpanGroup.e(), 1);
            if (tw4Var == null) {
                return ep4Var;
            }
            int i = tw4Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = tw4Var.j;
                if (cardLinkInfoData != null) {
                    ep4Var.p = cardLinkInfoData;
                    ep4Var.c = cardLinkInfoData.title;
                    ep4Var.e = cardLinkInfoData.imageUrl;
                    ep4Var.l = cardLinkInfoData.tagText;
                    ep4Var.g = cardLinkInfoData.url;
                    ep4Var.i = false;
                    ep4Var.o = i;
                }
            } else {
                ep4Var.c = tw4Var.e;
                ep4Var.e = tw4Var.d;
                ep4Var.l = tw4Var.f;
                ep4Var.f = tw4Var.g;
                ep4Var.g = tw4Var.c;
                ep4Var.n = tw4Var.h;
                String str = tw4Var.i;
                ep4Var.i = i == 1;
                ep4Var.o = tw4Var.b;
            }
            tbLinkSpanGroup.A(ep4Var);
            return ep4Var;
        }
        return (ep4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull ep4 ep4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ep4Var)) == null) ? this.q - ep4Var.q : invokeL.intValue;
    }
}
