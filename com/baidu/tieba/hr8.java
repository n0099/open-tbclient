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
/* loaded from: classes6.dex */
public class hr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<yn> b;
    public List<ln> c;
    public dr8 d;
    public dr8 e;
    public dr8 f;
    public fr8 g;
    public fr8 h;
    public fr8 i;

    public hr8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void h(up6 up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, up6Var) == null) {
            this.i.x(up6Var);
            this.h.x(up6Var);
            this.g.x(up6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            dr8 dr8Var = new dr8(tbPageContext, br8.D);
            this.d = dr8Var;
            dr8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            dr8 dr8Var2 = new dr8(tbPageContext, br8.E);
            this.e = dr8Var2;
            dr8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            dr8 dr8Var3 = new dr8(tbPageContext, br8.F);
            this.f = dr8Var3;
            dr8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            fr8 fr8Var = new fr8(tbPageContext, br8.I);
            this.g = fr8Var;
            fr8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            fr8 fr8Var2 = new fr8(tbPageContext, br8.H);
            this.h = fr8Var2;
            fr8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            fr8 fr8Var3 = new fr8(tbPageContext, br8.G);
            this.i = fr8Var3;
            fr8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (ln lnVar : this.c) {
            }
        }
    }
}
