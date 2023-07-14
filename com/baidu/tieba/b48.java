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
/* loaded from: classes5.dex */
public class b48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ln> b;
    public eo c;
    public a48 d;
    public f48 e;
    public z38 f;
    public d48 g;
    public c48 h;
    public e48 i;
    public g48 j;

    public b48(TbPageContext tbPageContext, eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eoVar};
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
        this.c = eoVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            a48 a48Var = new a48(this.a);
            this.d = a48Var;
            a48Var.x(this.c);
            this.b.add(this.d);
            f48 f48Var = new f48(this.a);
            this.e = f48Var;
            f48Var.x(this.c);
            this.b.add(this.e);
            z38 z38Var = new z38(this.a);
            this.f = z38Var;
            z38Var.x(this.c);
            this.b.add(this.f);
            d48 d48Var = new d48(this.a);
            this.g = d48Var;
            d48Var.x(this.c);
            this.b.add(this.g);
            c48 c48Var = new c48(this.a);
            this.h = c48Var;
            c48Var.x(this.c);
            this.b.add(this.h);
            e48 e48Var = new e48(this.a);
            this.i = e48Var;
            e48Var.x(this.c);
            this.b.add(this.i);
            g48 g48Var = new g48(this.a);
            this.j = g48Var;
            g48Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (eoVar = this.c) != null) {
            eoVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<yn> list) {
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (eoVar = this.c) != null) {
            eoVar.setData(list);
            b();
        }
    }

    public void d(i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, i05Var) == null) {
            for (ln lnVar : this.b) {
                if (lnVar instanceof y38) {
                    ((y38) lnVar).u(i05Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (ln lnVar : this.b) {
                lnVar.setPageId(bdUniqueId);
            }
        }
    }
}
