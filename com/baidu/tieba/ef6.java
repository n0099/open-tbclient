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
public class ef6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<om> c;
    public List<bn> d;
    public gg6 e;
    public kf6 f;

    public ef6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, gg6 gg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, gg6Var};
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
        this.e = gg6Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            df6 df6Var = new df6(this.a);
            hf6 hf6Var = new hf6(this.a);
            if6 if6Var = new if6(this.a);
            bf6 bf6Var = new bf6(this.a);
            gf6 gf6Var = new gf6(this.a);
            jf6 jf6Var = new jf6(this.a);
            ff6 ff6Var = new ff6(this.a);
            cf6 cf6Var = new cf6(this.a);
            this.f = new kf6(this.a);
            mf6 mf6Var = new mf6(this.a, this.e);
            lf6 lf6Var = new lf6(this.a);
            this.c.add(df6Var);
            this.c.add(this.f);
            this.c.add(hf6Var);
            this.c.add(if6Var);
            this.c.add(bf6Var);
            this.c.add(gf6Var);
            this.c.add(jf6Var);
            this.c.add(ff6Var);
            this.c.add(cf6Var);
            this.c.add(mf6Var);
            this.c.add(lf6Var);
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
        kf6 kf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (kf6Var = this.f) != null) {
            kf6Var.B(str);
        }
    }

    public void d(String str) {
        kf6 kf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (kf6Var = this.f) != null) {
            kf6Var.a(str);
        }
    }

    public void e(String str) {
        kf6 kf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (kf6Var = this.f) != null) {
            kf6Var.C(str);
        }
    }

    public void f(boolean z) {
        kf6 kf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (kf6Var = this.f) != null) {
            kf6Var.D(z);
        }
    }
}
