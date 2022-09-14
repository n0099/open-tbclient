package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class cz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<qn> b;
    public jo c;
    public az6 d;
    public fz6 e;
    public vy6 f;
    public xy6 g;
    public wy6 h;
    public yy6 i;
    public zy6 j;
    public bz6 k;

    public cz6(TbPageContext tbPageContext, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, joVar};
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
        this.c = joVar;
        b();
    }

    public List<Cdo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new ez6(this.a));
            this.b.add(new dz6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            az6 az6Var = new az6(this.a);
            this.d = az6Var;
            az6Var.v(this.c);
            this.b.add(this.d);
            fz6 fz6Var = new fz6(this.a);
            this.e = fz6Var;
            fz6Var.v(this.c);
            this.b.add(this.e);
            vy6 vy6Var = new vy6(this.a);
            this.f = vy6Var;
            vy6Var.v(this.c);
            this.b.add(this.f);
            xy6 xy6Var = new xy6(this.a);
            this.g = xy6Var;
            xy6Var.v(this.c);
            this.b.add(this.g);
            wy6 wy6Var = new wy6(this.a);
            this.h = wy6Var;
            wy6Var.v(this.c);
            this.b.add(this.h);
            yy6 yy6Var = new yy6(this.a);
            this.i = yy6Var;
            yy6Var.v(this.c);
            this.b.add(this.i);
            zy6 zy6Var = new zy6(this.a);
            this.j = zy6Var;
            zy6Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            bz6 bz6Var = new bz6(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = bz6Var;
            bz6Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void c() {
        jo joVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (joVar = this.c) == null) {
            return;
        }
        joVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dp4Var) == null) {
            for (qn qnVar : this.b) {
                if (qnVar instanceof uy6) {
                    ((uy6) qnVar).u(dp4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (qn qnVar : this.b) {
                qnVar.setPageId(bdUniqueId);
            }
        }
    }
}
