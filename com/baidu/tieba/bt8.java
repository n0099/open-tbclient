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
public class bt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<bn> b;
    public List<om> c;
    public xs8 d;
    public xs8 e;
    public xs8 f;
    public zs8 g;
    public zs8 h;
    public zs8 i;

    public bt8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ln lnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lnVar) == null) {
            for (om omVar : this.c) {
                if (omVar != null) {
                    omVar.setOnAdapterItemClickListener(lnVar);
                }
            }
        }
    }

    public void f(ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mnVar) == null) {
            for (om omVar : this.c) {
                if (omVar != null) {
                    omVar.setOnAdapterItemLongClickListener(mnVar);
                }
            }
        }
    }

    public void h(jo6 jo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jo6Var) == null) {
            this.i.x(jo6Var);
            this.h.x(jo6Var);
            this.g.x(jo6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            xs8 xs8Var = new xs8(tbPageContext, vs8.D);
            this.d = xs8Var;
            xs8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            xs8 xs8Var2 = new xs8(tbPageContext, vs8.E);
            this.e = xs8Var2;
            xs8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            xs8 xs8Var3 = new xs8(tbPageContext, vs8.F);
            this.f = xs8Var3;
            xs8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            zs8 zs8Var = new zs8(tbPageContext, vs8.I);
            this.g = zs8Var;
            zs8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            zs8 zs8Var2 = new zs8(tbPageContext, vs8.H);
            this.h = zs8Var2;
            zs8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            zs8 zs8Var3 = new zs8(tbPageContext, vs8.G);
            this.i = zs8Var3;
            zs8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.c.add(this.f);
            this.a.addAdapters(this.c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (om omVar : this.c) {
            }
        }
    }
}
