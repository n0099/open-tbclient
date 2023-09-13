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
public class du8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<cn> b;
    public List<pm> c;
    public zt8 d;
    public zt8 e;
    public zt8 f;
    public bu8 g;
    public bu8 h;
    public bu8 i;

    public du8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mnVar) == null) {
            for (pm pmVar : this.c) {
                if (pmVar != null) {
                    pmVar.setOnAdapterItemClickListener(mnVar);
                }
            }
        }
    }

    public void f(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nnVar) == null) {
            for (pm pmVar : this.c) {
                if (pmVar != null) {
                    pmVar.setOnAdapterItemLongClickListener(nnVar);
                }
            }
        }
    }

    public void h(mp6 mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mp6Var) == null) {
            this.i.x(mp6Var);
            this.h.x(mp6Var);
            this.g.x(mp6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            zt8 zt8Var = new zt8(tbPageContext, xt8.D);
            this.d = zt8Var;
            zt8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            zt8 zt8Var2 = new zt8(tbPageContext, xt8.E);
            this.e = zt8Var2;
            zt8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            zt8 zt8Var3 = new zt8(tbPageContext, xt8.F);
            this.f = zt8Var3;
            zt8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            bu8 bu8Var = new bu8(tbPageContext, xt8.I);
            this.g = bu8Var;
            bu8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            bu8 bu8Var2 = new bu8(tbPageContext, xt8.H);
            this.h = bu8Var2;
            bu8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            bu8 bu8Var3 = new bu8(tbPageContext, xt8.G);
            this.i = bu8Var3;
            bu8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (pm pmVar : this.c) {
            }
        }
    }
}
