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
public class bq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<yh> b;
    public List<lh> c;
    public xp8 d;
    public xp8 e;
    public xp8 f;
    public zp8 g;
    public zp8 h;
    public zp8 i;

    public bq8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iiVar) == null) {
            for (lh lhVar : this.c) {
                if (lhVar != null) {
                    lhVar.setOnAdapterItemClickListener(iiVar);
                }
            }
        }
    }

    public void f(ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(ji jiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jiVar) == null) {
            for (lh lhVar : this.c) {
                if (lhVar != null) {
                    lhVar.setOnAdapterItemLongClickListener(jiVar);
                }
            }
        }
    }

    public void h(bk6 bk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bk6Var) == null) {
            this.i.x(bk6Var);
            this.h.x(bk6Var);
            this.g.x(bk6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            xp8 xp8Var = new xp8(tbPageContext, vp8.D);
            this.d = xp8Var;
            xp8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            xp8 xp8Var2 = new xp8(tbPageContext, vp8.E);
            this.e = xp8Var2;
            xp8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            xp8 xp8Var3 = new xp8(tbPageContext, vp8.F);
            this.f = xp8Var3;
            xp8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            zp8 zp8Var = new zp8(tbPageContext, vp8.I);
            this.g = zp8Var;
            zp8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            zp8 zp8Var2 = new zp8(tbPageContext, vp8.H);
            this.h = zp8Var2;
            zp8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            zp8 zp8Var3 = new zp8(tbPageContext, vp8.G);
            this.i = zp8Var3;
            zp8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (lh lhVar : this.c) {
            }
        }
    }
}
