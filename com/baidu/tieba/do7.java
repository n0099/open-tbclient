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
/* loaded from: classes4.dex */
public class do7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<yn> b;
    public List<ln> c;
    public zn7 d;
    public zn7 e;
    public zn7 f;
    public bo7 g;
    public bo7 h;
    public bo7 i;

    public do7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            bdTypeRecyclerView.G(i);
        }
    }

    public void e(io ioVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ioVar) == null) {
            for (ln lnVar : this.c) {
                if (lnVar != null) {
                    lnVar.setOnAdapterItemClickListener(ioVar);
                }
            }
        }
    }

    public void f(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, joVar) == null) {
            for (ln lnVar : this.c) {
                if (lnVar != null) {
                    lnVar.setOnAdapterItemLongClickListener(joVar);
                }
            }
        }
    }

    public void h(z86 z86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, z86Var) == null) {
            this.i.v(z86Var);
            this.h.v(z86Var);
            this.g.v(z86Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            zn7 zn7Var = new zn7(tbPageContext, xn7.A);
            this.d = zn7Var;
            zn7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            zn7 zn7Var2 = new zn7(tbPageContext, xn7.B);
            this.e = zn7Var2;
            zn7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            zn7 zn7Var3 = new zn7(tbPageContext, xn7.C);
            this.f = zn7Var3;
            zn7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            bo7 bo7Var = new bo7(tbPageContext, xn7.F);
            this.g = bo7Var;
            bo7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            bo7 bo7Var2 = new bo7(tbPageContext, xn7.E);
            this.h = bo7Var2;
            bo7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            bo7 bo7Var3 = new bo7(tbPageContext, xn7.D);
            this.i = bo7Var3;
            bo7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.c.add(this.f);
            this.a.a(this.c);
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
            for (ln lnVar : this.c) {
            }
        }
    }
}
