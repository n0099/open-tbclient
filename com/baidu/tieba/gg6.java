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
public class gg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<om> c;
    public List<bn> d;
    public ih6 e;
    public mg6 f;

    public gg6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ih6 ih6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, ih6Var};
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
        this.e = ih6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            fg6 fg6Var = new fg6(this.a);
            jg6 jg6Var = new jg6(this.a);
            kg6 kg6Var = new kg6(this.a);
            dg6 dg6Var = new dg6(this.a);
            ig6 ig6Var = new ig6(this.a);
            lg6 lg6Var = new lg6(this.a);
            hg6 hg6Var = new hg6(this.a);
            eg6 eg6Var = new eg6(this.a);
            this.f = new mg6(this.a);
            og6 og6Var = new og6(this.a, this.e);
            ng6 ng6Var = new ng6(this.a);
            this.c.add(fg6Var);
            this.c.add(this.f);
            this.c.add(jg6Var);
            this.c.add(kg6Var);
            this.c.add(dg6Var);
            this.c.add(ig6Var);
            this.c.add(lg6Var);
            this.c.add(hg6Var);
            this.c.add(eg6Var);
            this.c.add(og6Var);
            this.c.add(ng6Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        mg6 mg6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (mg6Var = this.f) != null) {
            mg6Var.B(str);
        }
    }

    public void d(String str) {
        mg6 mg6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (mg6Var = this.f) != null) {
            mg6Var.a(str);
        }
    }

    public void e(String str) {
        mg6 mg6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (mg6Var = this.f) != null) {
            mg6Var.C(str);
        }
    }

    public void f(boolean z) {
        mg6 mg6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (mg6Var = this.f) != null) {
            mg6Var.D(z);
        }
    }
}
