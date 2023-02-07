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
/* loaded from: classes4.dex */
public class cb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<qn> b;
    public jo c;
    public ab7 d;
    public fb7 e;
    public va7 f;
    public xa7 g;
    public wa7 h;
    public ya7 i;
    public za7 j;
    public bb7 k;

    public cb7(TbPageContext tbPageContext, jo joVar) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        jo joVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (joVar = this.c) != null) {
            joVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new eb7(this.a));
            this.b.add(new db7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            ab7 ab7Var = new ab7(this.a);
            this.d = ab7Var;
            ab7Var.v(this.c);
            this.b.add(this.d);
            fb7 fb7Var = new fb7(this.a);
            this.e = fb7Var;
            fb7Var.v(this.c);
            this.b.add(this.e);
            va7 va7Var = new va7(this.a);
            this.f = va7Var;
            va7Var.v(this.c);
            this.b.add(this.f);
            xa7 xa7Var = new xa7(this.a);
            this.g = xa7Var;
            xa7Var.v(this.c);
            this.b.add(this.g);
            wa7 wa7Var = new wa7(this.a);
            this.h = wa7Var;
            wa7Var.v(this.c);
            this.b.add(this.h);
            ya7 ya7Var = new ya7(this.a);
            this.i = ya7Var;
            ya7Var.v(this.c);
            this.b.add(this.i);
            za7 za7Var = new za7(this.a);
            this.j = za7Var;
            za7Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            bb7 bb7Var = new bb7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = bb7Var;
            bb7Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void d(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(iv4 iv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iv4Var) == null) {
            for (qn qnVar : this.b) {
                if (qnVar instanceof ua7) {
                    ((ua7) qnVar).u(iv4Var);
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
