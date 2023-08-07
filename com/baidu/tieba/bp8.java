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
public class bp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<ym> b;
    public List<lm> c;
    public xo8 d;
    public xo8 e;
    public xo8 f;
    public zo8 g;
    public zo8 h;
    public zo8 i;

    public bp8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, inVar) == null) {
            for (lm lmVar : this.c) {
                if (lmVar != null) {
                    lmVar.setOnAdapterItemClickListener(inVar);
                }
            }
        }
    }

    public void f(ArrayList<ym> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(jn jnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jnVar) == null) {
            for (lm lmVar : this.c) {
                if (lmVar != null) {
                    lmVar.setOnAdapterItemLongClickListener(jnVar);
                }
            }
        }
    }

    public void h(bn6 bn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bn6Var) == null) {
            this.i.x(bn6Var);
            this.h.x(bn6Var);
            this.g.x(bn6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            xo8 xo8Var = new xo8(tbPageContext, vo8.D);
            this.d = xo8Var;
            xo8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            xo8 xo8Var2 = new xo8(tbPageContext, vo8.E);
            this.e = xo8Var2;
            xo8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            xo8 xo8Var3 = new xo8(tbPageContext, vo8.F);
            this.f = xo8Var3;
            xo8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            zo8 zo8Var = new zo8(tbPageContext, vo8.I);
            this.g = zo8Var;
            zo8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            zo8 zo8Var2 = new zo8(tbPageContext, vo8.H);
            this.h = zo8Var2;
            zo8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            zo8 zo8Var3 = new zo8(tbPageContext, vo8.G);
            this.i = zo8Var3;
            zo8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (lm lmVar : this.c) {
            }
        }
    }
}
