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
/* loaded from: classes5.dex */
public class bb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<en> c;
    public List<rn> d;
    public dc6 e;
    public hb6 f;

    public bb6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, dc6 dc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, dc6Var};
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
        this.e = dc6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ab6 ab6Var = new ab6(this.a);
            eb6 eb6Var = new eb6(this.a);
            fb6 fb6Var = new fb6(this.a);
            ya6 ya6Var = new ya6(this.a);
            db6 db6Var = new db6(this.a);
            gb6 gb6Var = new gb6(this.a);
            cb6 cb6Var = new cb6(this.a);
            za6 za6Var = new za6(this.a);
            this.f = new hb6(this.a);
            jb6 jb6Var = new jb6(this.a, this.e);
            ib6 ib6Var = new ib6(this.a);
            this.c.add(ab6Var);
            this.c.add(this.f);
            this.c.add(eb6Var);
            this.c.add(fb6Var);
            this.c.add(ya6Var);
            this.c.add(db6Var);
            this.c.add(gb6Var);
            this.c.add(cb6Var);
            this.c.add(za6Var);
            this.c.add(jb6Var);
            this.c.add(ib6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<rn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        hb6 hb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (hb6Var = this.f) != null) {
            hb6Var.F(str);
        }
    }

    public void d(String str) {
        hb6 hb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (hb6Var = this.f) != null) {
            hb6Var.a(str);
        }
    }

    public void e(String str) {
        hb6 hb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (hb6Var = this.f) != null) {
            hb6Var.G(str);
        }
    }

    public void f(boolean z) {
        hb6 hb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (hb6Var = this.f) != null) {
            hb6Var.H(z);
        }
    }
}
