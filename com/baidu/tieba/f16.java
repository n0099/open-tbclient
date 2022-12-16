package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<kn> c;
    public List<xn> d;
    public h26 e;
    public l16 f;

    public f16(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, h26 h26Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, h26Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = bdTypeListView;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = h26Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e16 e16Var = new e16(this.a);
            i16 i16Var = new i16(this.a);
            j16 j16Var = new j16(this.a);
            c16 c16Var = new c16(this.a);
            h16 h16Var = new h16(this.a);
            k16 k16Var = new k16(this.a);
            g16 g16Var = new g16(this.a);
            d16 d16Var = new d16(this.a);
            this.f = new l16(this.a);
            n16 n16Var = new n16(this.a, this.e);
            m16 m16Var = new m16(this.a);
            this.c.add(e16Var);
            this.c.add(this.f);
            this.c.add(i16Var);
            this.c.add(j16Var);
            this.c.add(c16Var);
            this.c.add(h16Var);
            this.c.add(k16Var);
            this.c.add(g16Var);
            this.c.add(d16Var);
            this.c.add(n16Var);
            this.c.add(m16Var);
            this.b.a(this.c);
        }
    }

    public void b(List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        l16 l16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (l16Var = this.f) != null) {
            l16Var.D(str);
        }
    }

    public void d(String str) {
        l16 l16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (l16Var = this.f) != null) {
            l16Var.a(str);
        }
    }

    public void e(String str) {
        l16 l16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (l16Var = this.f) != null) {
            l16Var.E(str);
        }
    }

    public void f(boolean z) {
        l16 l16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (l16Var = this.f) != null) {
            l16Var.F(z);
        }
    }
}
