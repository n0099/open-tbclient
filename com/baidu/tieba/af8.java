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
public class af8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ci> b;
    public vi c;
    public ze8 d;
    public ef8 e;
    public ye8 f;
    public cf8 g;
    public bf8 h;
    public df8 i;
    public ff8 j;

    public af8(TbPageContext tbPageContext, vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viVar};
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
        this.c = viVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            ze8 ze8Var = new ze8(this.a);
            this.d = ze8Var;
            ze8Var.y(this.c);
            this.b.add(this.d);
            ef8 ef8Var = new ef8(this.a);
            this.e = ef8Var;
            ef8Var.y(this.c);
            this.b.add(this.e);
            ye8 ye8Var = new ye8(this.a);
            this.f = ye8Var;
            ye8Var.y(this.c);
            this.b.add(this.f);
            cf8 cf8Var = new cf8(this.a);
            this.g = cf8Var;
            cf8Var.y(this.c);
            this.b.add(this.g);
            bf8 bf8Var = new bf8(this.a);
            this.h = bf8Var;
            bf8Var.y(this.c);
            this.b.add(this.h);
            df8 df8Var = new df8(this.a);
            this.i = df8Var;
            df8Var.y(this.c);
            this.b.add(this.i);
            ff8 ff8Var = new ff8(this.a);
            this.j = ff8Var;
            ff8Var.y(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        vi viVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (viVar = this.c) != null) {
            viVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<pi> list) {
        vi viVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (viVar = this.c) != null) {
            viVar.setData(list);
            b();
        }
    }

    public void d(xu4 xu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xu4Var) == null) {
            for (ci ciVar : this.b) {
                if (ciVar instanceof xe8) {
                    ((xe8) ciVar).x(xu4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (ci ciVar : this.b) {
                ciVar.setPageId(bdUniqueId);
            }
        }
    }
}
