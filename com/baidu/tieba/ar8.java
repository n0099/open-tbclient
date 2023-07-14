package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class ar8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<yn> b;
    public List<ln> c;
    public cr8 d;
    public cr8 e;
    public cr8 f;

    public ar8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.a = bdTypeRecyclerView;
            b(tbPageContext);
        }
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (bdTypeRecyclerView = this.a) != null) {
            bdTypeRecyclerView.removeItem(i);
        }
    }

    public void d(io ioVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ioVar) == null) {
            for (ln lnVar : this.c) {
                if (lnVar != null) {
                    lnVar.setOnAdapterItemClickListener(ioVar);
                }
            }
        }
    }

    public void e(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void f(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, joVar) == null) {
            for (ln lnVar : this.c) {
                if (lnVar != null) {
                    lnVar.setOnAdapterItemLongClickListener(joVar);
                }
            }
        }
    }

    public void g(up6 up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, up6Var) == null) {
            this.f.x(up6Var);
            this.e.x(up6Var);
            this.d.x(up6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            cr8 cr8Var = new cr8(tbPageContext, br8.I);
            this.d = cr8Var;
            cr8Var.u(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            cr8 cr8Var2 = new cr8(tbPageContext, br8.H);
            this.e = cr8Var2;
            cr8Var2.u(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            cr8 cr8Var3 = new cr8(tbPageContext, br8.G);
            this.f = cr8Var3;
            cr8Var3.u(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            this.c.add(this.f);
            this.c.add(this.e);
            this.c.add(this.d);
            this.a.addAdapters(this.c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getAdapter().notifyDataSetChanged();
        }
    }
}
