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
/* loaded from: classes4.dex */
public class h57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeRecyclerView b;
    public LinkedList<qn> c;
    public n57 d;
    public i57 e;
    public l57 f;
    public m57 g;
    public k57 h;
    public j57 i;

    public h57(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<Cdo> a() {
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
            this.d = new n57(this.a, k26.z0);
            this.e = new i57(this.a, l26.U);
            this.f = new l57(this.a, k26.I0);
            this.g = new m57(this.a, k26.G0);
            this.h = new k57(this.a, k26.A0);
            this.i = new j57(this.a, k26.H0);
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
        i57 i57Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (i57Var = this.e) == null) {
            return;
        }
        i57Var.onPause();
    }

    public void f(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b.setData(list);
        }
    }

    public void g(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            m57 m57Var = this.g;
            if (m57Var != null) {
                m57Var.v(bVar);
            }
            n57 n57Var = this.d;
            if (n57Var != null) {
                n57Var.v(bVar);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            n57 n57Var = this.d;
            if (n57Var != null) {
                n57Var.w(bdUniqueId);
            }
            i57 i57Var = this.e;
            if (i57Var != null) {
                i57Var.B(bdUniqueId);
            }
            l57 l57Var = this.f;
            if (l57Var != null) {
                l57Var.v(bdUniqueId);
            }
            m57 m57Var = this.g;
            if (m57Var != null) {
                m57Var.w(bdUniqueId);
            }
            k57 k57Var = this.h;
            if (k57Var != null) {
                k57Var.x(bdUniqueId);
            }
            j57 j57Var = this.i;
            if (j57Var != null) {
                j57Var.y(bdUniqueId);
            }
        }
    }

    public void i(k27 k27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k27Var) == null) {
            i57 i57Var = this.e;
            if (i57Var != null) {
                i57Var.C(k27Var);
            }
            j57 j57Var = this.i;
            if (j57Var != null) {
                j57Var.z(k27Var);
            }
        }
    }
}
