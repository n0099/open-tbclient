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
public class gy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<qn> c;
    public List<Cdo> d;
    public iz5 e;
    public my5 f;

    public gy5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, iz5 iz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, iz5Var};
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
        this.e = iz5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            fy5 fy5Var = new fy5(this.a);
            jy5 jy5Var = new jy5(this.a);
            ky5 ky5Var = new ky5(this.a);
            dy5 dy5Var = new dy5(this.a);
            iy5 iy5Var = new iy5(this.a);
            ly5 ly5Var = new ly5(this.a);
            hy5 hy5Var = new hy5(this.a);
            ey5 ey5Var = new ey5(this.a);
            this.f = new my5(this.a);
            oy5 oy5Var = new oy5(this.a, this.e);
            ny5 ny5Var = new ny5(this.a);
            this.c.add(fy5Var);
            this.c.add(this.f);
            this.c.add(jy5Var);
            this.c.add(ky5Var);
            this.c.add(dy5Var);
            this.c.add(iy5Var);
            this.c.add(ly5Var);
            this.c.add(hy5Var);
            this.c.add(ey5Var);
            this.c.add(oy5Var);
            this.c.add(ny5Var);
            this.b.a(this.c);
        }
    }

    public void b(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.d.clear();
        this.d.addAll(list);
        this.b.setData(this.d);
    }

    public void c(String str) {
        my5 my5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (my5Var = this.f) == null) {
            return;
        }
        my5Var.D(str);
    }

    public void d(String str) {
        my5 my5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (my5Var = this.f) == null) {
            return;
        }
        my5Var.a(str);
    }

    public void e(String str) {
        my5 my5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (my5Var = this.f) == null) {
            return;
        }
        my5Var.E(str);
    }

    public void f(boolean z) {
        my5 my5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (my5Var = this.f) == null) {
            return;
        }
        my5Var.F(z);
    }
}
