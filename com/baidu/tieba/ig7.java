package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.tieba.zy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ig7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public NavigationBar c;
    public NoNetworkView d;
    public RelativeLayout e;
    public BdSwipeRefreshLayout f;
    public BdTypeRecyclerView g;
    public az4 h;
    public PbListView i;
    public NoDataView j;
    public boolean k;
    public rg7 l;
    public e m;
    public View.OnClickListener n;
    public final zy4.g o;

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig7 a;

        public a(ig7 ig7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null && this.a.m != null) {
                this.a.i.N(0);
                this.a.i.D(null);
                this.a.i.S();
                this.a.m.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements zy4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig7 a;

        public b(ig7 ig7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig7Var;
        }

        @Override // com.baidu.tieba.zy4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.m != null) {
                        this.a.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a.f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ig7 ig7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig7 a;

        public d(ig7 ig7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null && this.a.m != null) {
                this.a.i.N(0);
                this.a.i.D(null);
                this.a.i.P();
                this.a.m.b();
            }
        }
    }

    public ig7(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.o = new b(this);
        this.a = tbPageContext;
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f09015f);
        g(tbPageContext);
        this.l = new rg7(tbPageContext, this.g);
    }

    public void i(ho hoVar) {
        rg7 rg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, hoVar) == null) && (rg7Var = this.l) != null) {
            rg7Var.e(hoVar);
        }
    }

    public void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (bdSwipeRefreshLayout = this.f) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            az4 az4Var = this.h;
            if (az4Var != null) {
                az4Var.H(i);
            }
            NoNetworkView noNetworkView = this.d;
            if (noNetworkView != null) {
                noNetworkView.d(this.a, i);
            }
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.G(SkinManager.getColor(R.color.CAM_X0109));
                this.i.d(i);
            }
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.f(this.a, i);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i);
            }
            rg7 rg7Var = this.l;
            if (rg7Var != null) {
                rg7Var.c();
            }
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public List<xn> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.g;
            if (bdTypeRecyclerView == null) {
                return null;
            }
            return bdTypeRecyclerView.getData();
        }
        return (List) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            rg7 rg7Var = this.l;
            if (rg7Var != null) {
                rg7Var.d();
            }
            az4 az4Var = this.h;
            if (az4Var != null) {
                az4Var.Z();
            }
        }
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tbPageContext) != null) || this.b == null) {
            return;
        }
        if (this.h == null) {
            az4 az4Var = new az4(tbPageContext);
            this.h = az4Var;
            az4Var.f(this.o);
        }
        this.h.b0(tbPageContext.getUniqueId());
        if (this.i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.i = pbListView;
            pbListView.b();
        }
        this.i.q(R.color.CAM_X0205);
        this.i.u(yi.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.i.z();
        this.i.I(R.dimen.tbfontsize33);
        this.i.G(SkinManager.getColor(R.color.CAM_X0109));
        this.i.C(R.color.CAM_X0110);
        this.i.D(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f091717);
        this.d = noNetworkView;
        noNetworkView.d(this.a, TbadkCoreApplication.getInst().getSkinType());
        this.e = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0906eb);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f092613);
        this.c = navigationBar;
        navigationBar.showBottomLine();
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f00e2));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090161);
        this.f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.b.findViewById(R.id.obfuscated_res_0x7f090162);
        this.g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.g.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.g.setFadingEdgeLength(0);
        this.g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.g.setOverScrollMode(2);
        this.g.addItemDecoration(new DeviderLineDecoration());
        this.g.setRecyclerListener(new c(this));
        this.g.setOnSrollToBottomListener(new d(this));
    }

    public void k(boolean z, ArrayList<xn> arrayList) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) && (bdSwipeRefreshLayout = this.f) != null && this.i != null && this.g != null && this.l != null) {
            bdSwipeRefreshLayout.setRefreshing(false);
            if (z) {
                this.i.N(0);
                this.i.f();
                this.i.D(this.n);
            } else {
                this.i.N(0);
                this.i.f();
                this.i.E(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1c));
                this.i.D(null);
            }
            if (ListUtils.isEmpty(arrayList)) {
                if (this.j == null) {
                    NoDataView a2 = NoDataViewFactory.a(this.a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f00e3)), null);
                    this.j = a2;
                    a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
                }
                if (this.j.getParent() == null && !this.k) {
                    this.k = true;
                    this.g.t(this.j, 0);
                    this.j.setVisibility(0);
                    this.j.f(this.a, TbadkCoreApplication.getInst().getSkinType());
                }
                this.g.setNextPage(null);
                return;
            }
            this.g.removeHeaderView(this.j);
            this.k = false;
            this.g.setNextPage(this.i);
            this.l.f(arrayList);
            this.l.c();
        }
    }
}
