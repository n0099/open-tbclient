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
public class ce6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<lm> c;
    public List<ym> d;
    public ef6 e;
    public ie6 f;

    public ce6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ef6 ef6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, ef6Var};
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
        this.e = ef6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            be6 be6Var = new be6(this.a);
            fe6 fe6Var = new fe6(this.a);
            ge6 ge6Var = new ge6(this.a);
            zd6 zd6Var = new zd6(this.a);
            ee6 ee6Var = new ee6(this.a);
            he6 he6Var = new he6(this.a);
            de6 de6Var = new de6(this.a);
            ae6 ae6Var = new ae6(this.a);
            this.f = new ie6(this.a);
            ke6 ke6Var = new ke6(this.a, this.e);
            je6 je6Var = new je6(this.a);
            this.c.add(be6Var);
            this.c.add(this.f);
            this.c.add(fe6Var);
            this.c.add(ge6Var);
            this.c.add(zd6Var);
            this.c.add(ee6Var);
            this.c.add(he6Var);
            this.c.add(de6Var);
            this.c.add(ae6Var);
            this.c.add(ke6Var);
            this.c.add(je6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<ym> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        ie6 ie6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (ie6Var = this.f) != null) {
            ie6Var.B(str);
        }
    }

    public void d(String str) {
        ie6 ie6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (ie6Var = this.f) != null) {
            ie6Var.a(str);
        }
    }

    public void e(String str) {
        ie6 ie6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (ie6Var = this.f) != null) {
            ie6Var.C(str);
        }
    }

    public void f(boolean z) {
        ie6 ie6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (ie6Var = this.f) != null) {
            ie6Var.D(z);
        }
    }
}
