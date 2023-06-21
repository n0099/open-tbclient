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
public class dz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<jn> b;
    public co c;
    public cz7 d;
    public hz7 e;
    public bz7 f;
    public fz7 g;
    public ez7 h;
    public gz7 i;
    public iz7 j;

    public dz7(TbPageContext tbPageContext, co coVar) {
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
            cz7 cz7Var = new cz7(this.a);
            this.d = cz7Var;
            cz7Var.x(this.c);
            this.b.add(this.d);
            hz7 hz7Var = new hz7(this.a);
            this.e = hz7Var;
            hz7Var.x(this.c);
            this.b.add(this.e);
            bz7 bz7Var = new bz7(this.a);
            this.f = bz7Var;
            bz7Var.x(this.c);
            this.b.add(this.f);
            fz7 fz7Var = new fz7(this.a);
            this.g = fz7Var;
            fz7Var.x(this.c);
            this.b.add(this.g);
            ez7 ez7Var = new ez7(this.a);
            this.h = ez7Var;
            ez7Var.x(this.c);
            this.b.add(this.h);
            gz7 gz7Var = new gz7(this.a);
            this.i = gz7Var;
            gz7Var.x(this.c);
            this.b.add(this.i);
            iz7 iz7Var = new iz7(this.a);
            this.j = iz7Var;
            iz7Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
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

    public void d(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wz4Var) == null) {
            for (jn jnVar : this.b) {
                if (jnVar instanceof az7) {
                    ((az7) jnVar).u(wz4Var);
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
