package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<cn> c;
    public i47 d;
    public d47 e;
    public g47 f;
    public h47 g;
    public f47 h;
    public e47 i;

    public c47(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.a = tbPageContext;
        this.b = bdTypeRecyclerView;
        this.c = new LinkedList<>();
        b();
    }

    public List<pn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = new i47(this.a, v06.z0);
            this.e = new d47(this.a, w06.U);
            this.f = new g47(this.a, v06.I0);
            this.g = new h47(this.a, v06.G0);
            this.h = new f47(this.a, v06.A0);
            this.i = new e47(this.a, v06.H0);
            this.d.x(this.b);
            this.e.D(this.b);
            this.f.w(this.b);
            this.g.x(this.b);
            this.h.y(this.b);
            this.i.A(this.b);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.f);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.b.a(this.c);
        }
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void e() {
        d47 d47Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (d47Var = this.e) == null) {
            return;
        }
        d47Var.onPause();
    }

    public void f(List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            h47 h47Var = this.g;
            if (h47Var != null) {
                h47Var.v(bVar);
            }
            i47 i47Var = this.d;
            if (i47Var != null) {
                i47Var.v(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            i47 i47Var = this.d;
            if (i47Var != null) {
                i47Var.w(bdUniqueId);
            }
            d47 d47Var = this.e;
            if (d47Var != null) {
                d47Var.B(bdUniqueId);
            }
            g47 g47Var = this.f;
            if (g47Var != null) {
                g47Var.v(bdUniqueId);
            }
            h47 h47Var = this.g;
            if (h47Var != null) {
                h47Var.w(bdUniqueId);
            }
            f47 f47Var = this.h;
            if (f47Var != null) {
                f47Var.x(bdUniqueId);
            }
            e47 e47Var = this.i;
            if (e47Var != null) {
                e47Var.y(bdUniqueId);
            }
        }
    }

    public void i(c17 c17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c17Var) == null) {
            d47 d47Var = this.e;
            if (d47Var != null) {
                d47Var.C(c17Var);
            }
            e47 e47Var = this.i;
            if (e47Var != null) {
                e47Var.z(c17Var);
            }
        }
    }
}
