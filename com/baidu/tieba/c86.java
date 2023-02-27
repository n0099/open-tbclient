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
/* loaded from: classes3.dex */
public class c86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<qn> c;
    public List<Cdo> d;
    public e96 e;
    public i86 f;

    public c86(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, e96 e96Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, e96Var};
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
        this.e = e96Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b86 b86Var = new b86(this.a);
            f86 f86Var = new f86(this.a);
            g86 g86Var = new g86(this.a);
            z76 z76Var = new z76(this.a);
            e86 e86Var = new e86(this.a);
            h86 h86Var = new h86(this.a);
            d86 d86Var = new d86(this.a);
            a86 a86Var = new a86(this.a);
            this.f = new i86(this.a);
            k86 k86Var = new k86(this.a, this.e);
            j86 j86Var = new j86(this.a);
            this.c.add(b86Var);
            this.c.add(this.f);
            this.c.add(f86Var);
            this.c.add(g86Var);
            this.c.add(z76Var);
            this.c.add(e86Var);
            this.c.add(h86Var);
            this.c.add(d86Var);
            this.c.add(a86Var);
            this.c.add(k86Var);
            this.c.add(j86Var);
            this.b.a(this.c);
        }
    }

    public void b(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        i86 i86Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (i86Var = this.f) != null) {
            i86Var.D(str);
        }
    }

    public void d(String str) {
        i86 i86Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (i86Var = this.f) != null) {
            i86Var.a(str);
        }
    }

    public void e(String str) {
        i86 i86Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (i86Var = this.f) != null) {
            i86Var.E(str);
        }
    }

    public void f(boolean z) {
        i86 i86Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (i86Var = this.f) != null) {
            i86Var.F(z);
        }
    }
}
