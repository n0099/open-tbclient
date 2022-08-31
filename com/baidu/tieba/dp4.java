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
public class dp4 implements Comparable<dp4> {
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

    public dp4(int i, int i2) {
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

    public static dp4 b(TbLinkSpanGroup tbLinkSpanGroup, au6 au6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, au6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            dp4 dp4Var = new dp4(tbLinkSpanGroup.e(), 2);
            if (au6Var == null) {
                return dp4Var;
            }
            if (TextUtils.isEmpty(au6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1599);
            } else {
                str = au6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0414);
            }
            dp4Var.d = str;
            dp4Var.c = au6Var.c();
            dp4Var.m = au6Var.a();
            if (!ListUtils.isEmpty(au6Var.b()) && au6Var.b().get(0) != null) {
                dp4Var.e = au6Var.b().get(0).a();
            }
            dp4Var.l = au6Var.f();
            dp4Var.f = au6Var.d();
            if (au6Var.e() != null) {
                dp4Var.j = au6Var.e().a();
                dp4Var.k = au6Var.e().b();
            }
            tbLinkSpanGroup.A(dp4Var);
            return dp4Var;
        }
        return (dp4) invokeLL.objValue;
    }

    public static dp4 c(TbLinkSpanGroup tbLinkSpanGroup, rw4 rw4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, rw4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            dp4 dp4Var = new dp4(tbLinkSpanGroup.e(), 1);
            if (rw4Var == null) {
                return dp4Var;
            }
            int i = rw4Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = rw4Var.j;
                if (cardLinkInfoData != null) {
                    dp4Var.p = cardLinkInfoData;
                    dp4Var.c = cardLinkInfoData.title;
                    dp4Var.e = cardLinkInfoData.imageUrl;
                    dp4Var.l = cardLinkInfoData.tagText;
                    dp4Var.g = cardLinkInfoData.url;
                    dp4Var.i = false;
                    dp4Var.o = i;
                }
            } else {
                dp4Var.c = rw4Var.e;
                dp4Var.e = rw4Var.d;
                dp4Var.l = rw4Var.f;
                dp4Var.f = rw4Var.g;
                dp4Var.g = rw4Var.c;
                dp4Var.n = rw4Var.h;
                String str = rw4Var.i;
                dp4Var.i = i == 1;
                dp4Var.o = rw4Var.b;
            }
            tbLinkSpanGroup.A(dp4Var);
            return dp4Var;
        }
        return (dp4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull dp4 dp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dp4Var)) == null) ? this.q - dp4Var.q : invokeL.intValue;
    }
}
