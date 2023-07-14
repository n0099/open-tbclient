package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.bx5;
import com.baidu.tieba.dw5;
import com.baidu.tieba.ew5;
import com.baidu.tieba.sw5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class dv5<Q extends dw5, P extends ew5> implements hw5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public final View b;
    public final ww5 c;
    public final mw5 d;
    public final fw5<Q, P> e;
    public final kw5<Q, P> f;
    public iw5<P> g;
    public final View.OnClickListener h;
    public final j05 i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;

        public a(dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tw5.b(" ----NetRefreshView----");
                this.a.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends j05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;

        public b(dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv5Var;
        }

        @Override // com.baidu.tieba.j05, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                tw5.b(" ----onActivityDestroyed---- ");
                this.a.i();
            }
        }

        @Override // com.baidu.tieba.j05, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                tw5.b(" ----onActivityPaused---- ");
                this.a.j();
            }
        }

        @Override // com.baidu.tieba.j05, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                tw5.b(" ----onActivityResumed---- ");
                this.a.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c<Q extends dw5, P extends ew5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup A;
        public TbPageContext a;
        public Q b;
        public P c;
        public int d;
        public int e;
        public String f;
        public sw5.d g;
        public sw5.b h;
        public sw5.a i;
        public ow5 j;
        public ow5 k;
        public ow5 l;
        public String m;
        public boolean n;
        public boolean o;
        public boolean p;
        public yw5 q;
        public xw5 r;
        public sw5.c s;
        public List<ln> t;
        public List<ln> u;
        public i05<t15> v;
        public uv5 w;
        public int x;
        public ww5 y;
        public View z;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.p = false;
        }

        public final void a() {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b != null && (tbPageContext = this.a) != null && tbPageContext.getPageActivity() != null) {
                this.b.a(this.a.getPageActivity().getIntent());
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.o) {
                NavigationBar navigationBar = new NavigationBar(this.a.getPageActivity());
                if (this.n) {
                    navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                }
                navigationBar.setCenterTextTitle(this.m);
                this.z = navigationBar;
            }
        }

        public c b(List<ln> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                this.p = true;
                this.t = list;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c c(yw5 yw5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yw5Var)) == null) {
                this.p = true;
                this.q = yw5Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c d(i05<t15> i05Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, i05Var)) == null) {
                this.p = true;
                this.v = i05Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public dv5 e(ViewGroup viewGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
                this.A = viewGroup;
                this.a = (TbPageContext) r9.a(viewGroup.getContext());
                a();
                g();
                f();
                return new dv5(this, null);
            }
            return (dv5) invokeL.objValue;
        }

        public final void h(bx5 bx5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, bx5Var) == null) && !ListUtils.isEmpty(this.u)) {
                bx5Var.z(this.u);
            }
        }

        public c i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public c j(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c k(@NonNull Q q) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, q)) == null) {
                this.b = q;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c l(@NonNull P p) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, p)) == null) {
                this.c = p;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.p && this.q != null && this.r != null) {
                    bx5.f fVar = new bx5.f();
                    fVar.i(this.q);
                    fVar.f(this.r);
                    fVar.b(this.s);
                    fVar.a(this.t);
                    fVar.g(this.v);
                    fVar.e(this.x);
                    fVar.h(this.w);
                    bx5 c = fVar.c(this.a);
                    h(c);
                    this.y = c;
                } else if (this.p && this.q != null) {
                    bx5.f fVar2 = new bx5.f();
                    fVar2.i(this.q);
                    fVar2.b(this.s);
                    fVar2.a(this.t);
                    fVar2.g(this.v);
                    fVar2.e(this.x);
                    fVar2.h(this.w);
                    bx5 c2 = fVar2.c(this.a);
                    h(c2);
                    this.y = c2;
                } else if (this.p) {
                    bx5.f fVar3 = new bx5.f();
                    fVar3.b(this.s);
                    fVar3.a(this.t);
                    fVar3.g(this.v);
                    fVar3.e(this.x);
                    fVar3.h(this.w);
                    bx5 c3 = fVar3.c(this.a);
                    h(c3);
                    this.y = c3;
                }
            }
        }
    }

    public dv5(c<Q, P> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.i = new b(this);
        this.a = cVar.a;
        gw5 gw5Var = new gw5(cVar.d, cVar.e, cVar.f, cVar.b, cVar.c);
        this.e = gw5Var;
        this.f = new kw5<>(cVar.a, gw5Var, this);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getPageActivity());
        View view2 = cVar.z;
        this.b = view2;
        if (view2 != null) {
            view2.setId(2184);
            this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            relativeLayout.addView(this.b);
        }
        ww5 ww5Var = cVar.y;
        this.c = ww5Var;
        if (ww5Var != null) {
            ww5Var.j(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, 2184);
            this.c.getView().setLayoutParams(layoutParams);
            this.c.a(relativeLayout);
        }
        cVar.A.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        sw5.d dVar = cVar.g;
        dVar = dVar == null ? new sw5.d() : dVar;
        sw5.b bVar = cVar.h;
        bVar = bVar == null ? new sw5.b() : bVar;
        sw5.a aVar = cVar.i;
        aVar = aVar == null ? new sw5.a() : aVar;
        View.OnClickListener onClickListener = this.h;
        bVar.h = onClickListener;
        aVar.h = onClickListener;
        sw5 sw5Var = new sw5();
        sw5Var.b = aVar;
        sw5Var.c = bVar;
        sw5Var.a = dVar;
        this.d = new nw5(this.c, relativeLayout, sw5Var);
        ow5 ow5Var = cVar.j;
        ow5Var = ow5Var == null ? new rw5(this.a) : ow5Var;
        ow5 ow5Var2 = cVar.k;
        ow5Var2 = ow5Var2 == null ? new qw5(this.a) : ow5Var2;
        ow5 ow5Var3 = cVar.l;
        ow5Var3 = ow5Var3 == null ? new pw5(this.a) : ow5Var3;
        this.d.c(ViewType.LOADING, ow5Var);
        this.d.c(ViewType.ERROR, ow5Var2);
        this.d.c(ViewType.EMPTY, ow5Var3);
        m();
    }

    public /* synthetic */ dv5(c cVar, a aVar) {
        this(cVar);
    }

    @Override // com.baidu.tieba.hw5
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            tw5.b(" ----onError---- ");
            iw5<P> iw5Var = this.g;
            if (iw5Var != null) {
                iw5Var.onError(i, str);
            }
            ww5 ww5Var = this.c;
            if (ww5Var != null) {
                ww5Var.b(d());
            } else {
                q(str);
            }
        }
    }

    public void b(cv5 cv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cv5Var) == null) {
            this.f.b(cv5Var);
        }
    }

    public boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            return this.f.i(z);
        }
        return invokeZ.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            mw5 mw5Var = this.d;
            if (mw5Var != null) {
                mw5Var.onChangeSkinType(i);
            }
            ww5 ww5Var = this.c;
            if (ww5Var != null) {
                ww5Var.onChangeSkinType(i);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            kw5<Q, P> kw5Var = this.f;
            if (kw5Var != null) {
                kw5Var.s(bdUniqueId);
            }
            ww5 ww5Var = this.c;
            if (ww5Var != null) {
                ww5Var.i(bdUniqueId);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            tw5.b(" ----showEmpty---- ");
            this.d.a(ViewType.EMPTY, str);
            t(ViewType.EMPTY);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            tw5.b(" ----showError---- ");
            this.d.a(ViewType.ERROR, str);
            t(ViewType.ERROR);
        }
    }

    public final void t(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, viewType) == null) {
            this.d.b(viewType);
        }
    }

    public Q c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f.f();
        }
        return (Q) invokeV.objValue;
    }

    public P d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f.g();
        }
        return (P) invokeV.objValue;
    }

    public LoadType e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            xv5 c2 = c().c();
            if (c2 != null) {
                return c2.b;
            }
            return LoadType.REFRESH;
        }
        return (LoadType) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f.j();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            mw5 mw5Var = this.d;
            if (mw5Var != null) {
                mw5Var.onDestroy();
            }
            kw5<Q, P> kw5Var = this.f;
            if (kw5Var != null) {
                kw5Var.k();
            }
            ww5 ww5Var = this.c;
            if (ww5Var != null) {
                ww5Var.e();
            }
            u();
        }
    }

    public void j() {
        ww5 ww5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (ww5Var = this.c) != null) {
            ww5Var.f();
        }
    }

    public void k() {
        ww5 ww5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (ww5Var = this.c) != null) {
            ww5Var.g();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ww5 ww5Var = this.c;
            if (ww5Var != null) {
                ww5Var.h();
                return;
            }
            r();
            f(true);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            tw5.b(" ----showLoading---- ");
            t(ViewType.LOADING);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            tw5.b(" ----showContent---- ");
            t(ViewType.CONTENT);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hw5
    /* renamed from: l */
    public void onSuccess(P p) {
        zv5 zv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, p) == null) {
            tw5.b(" ----onSuccess---- ");
            iw5<P> iw5Var = this.g;
            if (iw5Var != null) {
                iw5Var.onSuccess(p);
            }
            ww5 ww5Var = this.c;
            if (ww5Var != null) {
                zv5Var = ww5Var.b(p);
            } else {
                s();
                zv5Var = new zv5();
            }
            iw5<P> iw5Var2 = this.g;
            if (iw5Var2 != null) {
                iw5Var2.a(zv5Var);
            }
        }
    }
}
