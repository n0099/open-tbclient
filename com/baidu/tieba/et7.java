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
public class et7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<en> b;
    public xn c;
    public dt7 d;
    public it7 e;
    public ct7 f;
    public gt7 g;
    public ft7 h;
    public ht7 i;
    public jt7 j;

    public et7(TbPageContext tbPageContext, xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xnVar};
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
        this.c = xnVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            dt7 dt7Var = new dt7(this.a);
            this.d = dt7Var;
            dt7Var.x(this.c);
            this.b.add(this.d);
            it7 it7Var = new it7(this.a);
            this.e = it7Var;
            it7Var.x(this.c);
            this.b.add(this.e);
            ct7 ct7Var = new ct7(this.a);
            this.f = ct7Var;
            ct7Var.x(this.c);
            this.b.add(this.f);
            gt7 gt7Var = new gt7(this.a);
            this.g = gt7Var;
            gt7Var.x(this.c);
            this.b.add(this.g);
            ft7 ft7Var = new ft7(this.a);
            this.h = ft7Var;
            ft7Var.x(this.c);
            this.b.add(this.h);
            ht7 ht7Var = new ht7(this.a);
            this.i = ht7Var;
            ht7Var.x(this.c);
            this.b.add(this.i);
            jt7 jt7Var = new jt7(this.a);
            this.j = jt7Var;
            jt7Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        xn xnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (xnVar = this.c) != null) {
            xnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<rn> list) {
        xn xnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (xnVar = this.c) != null) {
            xnVar.setData(list);
            b();
        }
    }

    public void d(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zw4Var) == null) {
            for (en enVar : this.b) {
                if (enVar instanceof bt7) {
                    ((bt7) enVar).u(zw4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (en enVar : this.b) {
                enVar.setPageId(bdUniqueId);
            }
        }
    }
}
