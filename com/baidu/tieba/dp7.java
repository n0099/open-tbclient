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
public class dp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<vm> b;
    public on c;
    public bp7 d;
    public gp7 e;
    public wo7 f;
    public yo7 g;
    public xo7 h;
    public zo7 i;
    public ap7 j;
    public cp7 k;

    public dp7(TbPageContext tbPageContext, on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onVar};
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
        this.c = onVar;
        b();
    }

    public List<in> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        on onVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (onVar = this.c) != null) {
            onVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new fp7(this.a));
            this.b.add(new ep7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            bp7 bp7Var = new bp7(this.a);
            this.d = bp7Var;
            bp7Var.x(this.c);
            this.b.add(this.d);
            gp7 gp7Var = new gp7(this.a);
            this.e = gp7Var;
            gp7Var.x(this.c);
            this.b.add(this.e);
            wo7 wo7Var = new wo7(this.a);
            this.f = wo7Var;
            wo7Var.x(this.c);
            this.b.add(this.f);
            yo7 yo7Var = new yo7(this.a);
            this.g = yo7Var;
            yo7Var.x(this.c);
            this.b.add(this.g);
            xo7 xo7Var = new xo7(this.a);
            this.h = xo7Var;
            xo7Var.x(this.c);
            this.b.add(this.h);
            zo7 zo7Var = new zo7(this.a);
            this.i = zo7Var;
            zo7Var.x(this.c);
            this.b.add(this.i);
            ap7 ap7Var = new ap7(this.a);
            this.j = ap7Var;
            ap7Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            cp7 cp7Var = new cp7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = cp7Var;
            cp7Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(av4 av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, av4Var) == null) {
            for (vm vmVar : this.b) {
                if (vmVar instanceof vo7) {
                    ((vo7) vmVar).u(av4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (vm vmVar : this.b) {
                vmVar.setPageId(bdUniqueId);
            }
        }
    }
}
