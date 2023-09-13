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
import com.baidu.tieba.bw5;
import com.baidu.tieba.dv5;
import com.baidu.tieba.ev5;
import com.baidu.tieba.sv5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class du5<Q extends dv5, P extends ev5> implements hv5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public final View b;
    public final wv5 c;
    public final mv5 d;
    public final fv5<Q, P> e;
    public final kv5<Q, P> f;
    public iv5<P> g;
    public final View.OnClickListener h;
    public final xz4 i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du5 a;

        public a(du5 du5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tv5.b(" ----NetRefreshView----");
                this.a.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends xz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du5 a;

        public b(du5 du5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du5Var;
        }

        @Override // com.baidu.tieba.xz4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                tv5.b(" ----onActivityDestroyed---- ");
                this.a.i();
            }
        }

        @Override // com.baidu.tieba.xz4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                tv5.b(" ----onActivityPaused---- ");
                this.a.j();
            }
        }

        @Override // com.baidu.tieba.xz4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                tv5.b(" ----onActivityResumed---- ");
                this.a.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c<Q extends dv5, P extends ev5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup A;
        public TbPageContext a;
        public Q b;
        public P c;
        public int d;
        public int e;
        public String f;
        public sv5.d g;
        public sv5.b h;
        public sv5.a i;
        public ov5 j;
        public ov5 k;
        public ov5 l;
        public String m;
        public boolean n;
        public boolean o;
        public boolean p;
        public yv5 q;
        public xv5 r;
        public sv5.c s;
        public List<pm> t;
        public List<pm> u;
        public wz4<b15> v;
        public uu5 w;
        public int x;
        public wv5 y;
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

        public c b(List<pm> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                this.p = true;
                this.t = list;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c c(yv5 yv5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yv5Var)) == null) {
                this.p = true;
                this.q = yv5Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c d(wz4<b15> wz4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, wz4Var)) == null) {
                this.p = true;
                this.v = wz4Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public du5 e(ViewGroup viewGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
                this.A = viewGroup;
                this.a = (TbPageContext) m9.a(viewGroup.getContext());
                a();
                g();
                f();
                return new du5(this, null);
            }
            return (du5) invokeL.objValue;
        }

        public final void h(bw5 bw5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, bw5Var) == null) && !ListUtils.isEmpty(this.u)) {
                bw5Var.y(this.u);
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
                    bw5.f fVar = new bw5.f();
                    fVar.i(this.q);
                    fVar.f(this.r);
                    fVar.b(this.s);
                    fVar.a(this.t);
                    fVar.g(this.v);
                    fVar.e(this.x);
                    fVar.h(this.w);
                    bw5 c = fVar.c(this.a);
                    h(c);
                    this.y = c;
                } else if (this.p && this.q != null) {
                    bw5.f fVar2 = new bw5.f();
                    fVar2.i(this.q);
                    fVar2.b(this.s);
                    fVar2.a(this.t);
                    fVar2.g(this.v);
                    fVar2.e(this.x);
                    fVar2.h(this.w);
                    bw5 c2 = fVar2.c(this.a);
                    h(c2);
                    this.y = c2;
                } else if (this.p) {
                    bw5.f fVar3 = new bw5.f();
                    fVar3.b(this.s);
                    fVar3.a(this.t);
                    fVar3.g(this.v);
                    fVar3.e(this.x);
                    fVar3.h(this.w);
                    bw5 c3 = fVar3.c(this.a);
                    h(c3);
                    this.y = c3;
                }
            }
        }
    }

    public du5(c<Q, P> cVar) {
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
        gv5 gv5Var = new gv5(cVar.d, cVar.e, cVar.f, cVar.b, cVar.c);
        this.e = gv5Var;
        this.f = new kv5<>(cVar.a, gv5Var, this);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getPageActivity());
        View view2 = cVar.z;
        this.b = view2;
        if (view2 != null) {
            view2.setId(2184);
            this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            relativeLayout.addView(this.b);
        }
        wv5 wv5Var = cVar.y;
        this.c = wv5Var;
        if (wv5Var != null) {
            wv5Var.i(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, 2184);
            this.c.getView().setLayoutParams(layoutParams);
            this.c.a(relativeLayout);
        }
        cVar.A.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        sv5.d dVar = cVar.g;
        dVar = dVar == null ? new sv5.d() : dVar;
        sv5.b bVar = cVar.h;
        bVar = bVar == null ? new sv5.b() : bVar;
        sv5.a aVar = cVar.i;
        aVar = aVar == null ? new sv5.a() : aVar;
        View.OnClickListener onClickListener = this.h;
        bVar.h = onClickListener;
        aVar.h = onClickListener;
        sv5 sv5Var = new sv5();
        sv5Var.b = aVar;
        sv5Var.c = bVar;
        sv5Var.a = dVar;
        this.d = new nv5(this.c, relativeLayout, sv5Var);
        ov5 ov5Var = cVar.j;
        ov5Var = ov5Var == null ? new rv5(this.a) : ov5Var;
        ov5 ov5Var2 = cVar.k;
        ov5Var2 = ov5Var2 == null ? new qv5(this.a) : ov5Var2;
        ov5 ov5Var3 = cVar.l;
        ov5Var3 = ov5Var3 == null ? new pv5(this.a) : ov5Var3;
        this.d.c(ViewType.LOADING, ov5Var);
        this.d.c(ViewType.ERROR, ov5Var2);
        this.d.c(ViewType.EMPTY, ov5Var3);
        m();
    }

    public /* synthetic */ du5(c cVar, a aVar) {
        this(cVar);
    }

    @Override // com.baidu.tieba.hv5
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            tv5.b(" ----onError---- ");
            iv5<P> iv5Var = this.g;
            if (iv5Var != null) {
                iv5Var.onError(i, str);
            }
            wv5 wv5Var = this.c;
            if (wv5Var != null) {
                wv5Var.onBindDataToView(d());
            } else {
                q(str);
            }
        }
    }

    public void b(cu5 cu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cu5Var) == null) {
            this.f.b(cu5Var);
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
            mv5 mv5Var = this.d;
            if (mv5Var != null) {
                mv5Var.onChangeSkinType(i);
            }
            wv5 wv5Var = this.c;
            if (wv5Var != null) {
                wv5Var.onChangeSkinType(i);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            kv5<Q, P> kv5Var = this.f;
            if (kv5Var != null) {
                kv5Var.s(bdUniqueId);
            }
            wv5 wv5Var = this.c;
            if (wv5Var != null) {
                wv5Var.h(bdUniqueId);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            tv5.b(" ----showEmpty---- ");
            this.d.a(ViewType.EMPTY, str);
            t(ViewType.EMPTY);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            tv5.b(" ----showError---- ");
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
            xu5 c2 = c().c();
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
            mv5 mv5Var = this.d;
            if (mv5Var != null) {
                mv5Var.onDestroy();
            }
            kv5<Q, P> kv5Var = this.f;
            if (kv5Var != null) {
                kv5Var.k();
            }
            wv5 wv5Var = this.c;
            if (wv5Var != null) {
                wv5Var.d();
            }
            u();
        }
    }

    public void j() {
        wv5 wv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (wv5Var = this.c) != null) {
            wv5Var.e();
        }
    }

    public void k() {
        wv5 wv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (wv5Var = this.c) != null) {
            wv5Var.f();
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
            wv5 wv5Var = this.c;
            if (wv5Var != null) {
                wv5Var.g();
                return;
            }
            r();
            f(true);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            tv5.b(" ----showLoading---- ");
            t(ViewType.LOADING);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            tv5.b(" ----showContent---- ");
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
    @Override // com.baidu.tieba.hv5
    /* renamed from: l */
    public void onSuccess(P p) {
        zu5 zu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, p) == null) {
            tv5.b(" ----onSuccess---- ");
            iv5<P> iv5Var = this.g;
            if (iv5Var != null) {
                iv5Var.onSuccess(p);
            }
            wv5 wv5Var = this.c;
            if (wv5Var != null) {
                zu5Var = wv5Var.onBindDataToView(p);
            } else {
                s();
                zu5Var = new zu5();
            }
            iv5<P> iv5Var2 = this.g;
            if (iv5Var2 != null) {
                iv5Var2.a(zu5Var);
            }
        }
    }
}
