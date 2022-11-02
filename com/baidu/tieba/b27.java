package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<jn> b;
    public co c;
    public a27 d;
    public f27 e;
    public z17 f;
    public d27 g;
    public c27 h;
    public e27 i;
    public g27 j;

    public b27(TbPageContext tbPageContext, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, coVar};
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
        this.c = coVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            a27 a27Var = new a27(this.a);
            this.d = a27Var;
            a27Var.v(this.c);
            this.b.add(this.d);
            f27 f27Var = new f27(this.a);
            this.e = f27Var;
            f27Var.v(this.c);
            this.b.add(this.e);
            z17 z17Var = new z17(this.a);
            this.f = z17Var;
            z17Var.v(this.c);
            this.b.add(this.f);
            d27 d27Var = new d27(this.a);
            this.g = d27Var;
            d27Var.v(this.c);
            this.b.add(this.g);
            c27 c27Var = new c27(this.a);
            this.h = c27Var;
            c27Var.v(this.c);
            this.b.add(this.h);
            e27 e27Var = new e27(this.a);
            this.i = e27Var;
            e27Var.v(this.c);
            this.b.add(this.i);
            g27 g27Var = new g27(this.a);
            this.j = g27Var;
            g27Var.v(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (coVar = this.c) != null) {
            coVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<wn> list) {
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (coVar = this.c) != null) {
            coVar.setData(list);
            b();
        }
    }

    public void d(iq4 iq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iq4Var) == null) {
            for (jn jnVar : this.b) {
                if (jnVar instanceof y17) {
                    ((y17) jnVar).u(iq4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (jn jnVar : this.b) {
                jnVar.setPageId(bdUniqueId);
            }
        }
    }
}
