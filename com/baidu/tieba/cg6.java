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
public class cg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<pm> c;
    public List<cn> d;
    public eh6 e;
    public ig6 f;

    public cg6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, eh6 eh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, eh6Var};
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
        this.e = eh6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bg6 bg6Var = new bg6(this.a);
            fg6 fg6Var = new fg6(this.a);
            gg6 gg6Var = new gg6(this.a);
            zf6 zf6Var = new zf6(this.a);
            eg6 eg6Var = new eg6(this.a);
            hg6 hg6Var = new hg6(this.a);
            dg6 dg6Var = new dg6(this.a);
            ag6 ag6Var = new ag6(this.a);
            this.f = new ig6(this.a);
            kg6 kg6Var = new kg6(this.a, this.e);
            jg6 jg6Var = new jg6(this.a);
            this.c.add(bg6Var);
            this.c.add(this.f);
            this.c.add(fg6Var);
            this.c.add(gg6Var);
            this.c.add(zf6Var);
            this.c.add(eg6Var);
            this.c.add(hg6Var);
            this.c.add(dg6Var);
            this.c.add(ag6Var);
            this.c.add(kg6Var);
            this.c.add(jg6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<cn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        ig6 ig6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (ig6Var = this.f) != null) {
            ig6Var.B(str);
        }
    }

    public void d(String str) {
        ig6 ig6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (ig6Var = this.f) != null) {
            ig6Var.a(str);
        }
    }

    public void e(String str) {
        ig6 ig6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (ig6Var = this.f) != null) {
            ig6Var.C(str);
        }
    }

    public void f(boolean z) {
        ig6 ig6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (ig6Var = this.f) != null) {
            ig6Var.D(z);
        }
    }
}
