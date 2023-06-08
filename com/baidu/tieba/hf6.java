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
/* loaded from: classes6.dex */
public class hf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<in> c;
    public List<vn> d;
    public jg6 e;
    public nf6 f;

    public hf6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, jg6 jg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, jg6Var};
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
        this.e = jg6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            gf6 gf6Var = new gf6(this.a);
            kf6 kf6Var = new kf6(this.a);
            lf6 lf6Var = new lf6(this.a);
            ef6 ef6Var = new ef6(this.a);
            jf6 jf6Var = new jf6(this.a);
            mf6 mf6Var = new mf6(this.a);
            if6 if6Var = new if6(this.a);
            ff6 ff6Var = new ff6(this.a);
            this.f = new nf6(this.a);
            pf6 pf6Var = new pf6(this.a, this.e);
            of6 of6Var = new of6(this.a);
            this.c.add(gf6Var);
            this.c.add(this.f);
            this.c.add(kf6Var);
            this.c.add(lf6Var);
            this.c.add(ef6Var);
            this.c.add(jf6Var);
            this.c.add(mf6Var);
            this.c.add(if6Var);
            this.c.add(ff6Var);
            this.c.add(pf6Var);
            this.c.add(of6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<vn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        nf6 nf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (nf6Var = this.f) != null) {
            nf6Var.B(str);
        }
    }

    public void d(String str) {
        nf6 nf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (nf6Var = this.f) != null) {
            nf6Var.a(str);
        }
    }

    public void e(String str) {
        nf6 nf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (nf6Var = this.f) != null) {
            nf6Var.C(str);
        }
    }

    public void f(boolean z) {
        nf6 nf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (nf6Var = this.f) != null) {
            nf6Var.D(z);
        }
    }
}
