package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.p0.f0.h;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f14151h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f14152i;
    public BdSwipeRefreshLayout j;
    public PbListView k;
    public g l;
    public h m;
    public e n;
    public SpecialConcernTabModel o;
    public boolean p;
    public boolean q;
    public boolean r;
    public CustomMessageListener s;
    public SpecialConcernTabModel.b t;
    public BdListView.p u;
    public final f.g v;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f14153a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernTabFragment concernTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14153a = concernTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f14153a.o == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.f14153a.g1();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SpecialConcernTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f14154a;

        public b(ConcernTabFragment concernTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14154a = concernTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                ConcernTabFragment concernTabFragment = this.f14154a;
                concernTabFragment.hideLoadingView(concernTabFragment.f14151h);
                this.f14154a.d1();
                this.f14154a.j1();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void b(List<n> list, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f14154a.p = z;
                this.f14154a.r = true;
                this.f14154a.h1(false);
                ConcernTabFragment concernTabFragment = this.f14154a;
                concernTabFragment.hideLoadingView(concernTabFragment.f14151h);
                if (ListUtils.getCount(list) == 0) {
                    this.f14154a.j1();
                } else {
                    this.f14154a.f14152i.setData(list);
                    if (!this.f14154a.p) {
                        this.f14154a.k1();
                    } else {
                        this.f14154a.i1();
                    }
                    this.f14154a.e1();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i2 > 0)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f14155e;

        public c(ConcernTabFragment concernTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14155e = concernTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f14155e.d1();
                } else if (this.f14155e.p) {
                    this.f14155e.o.B();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f14156e;

        public d(ConcernTabFragment concernTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14156e = concernTabFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f14156e.o.C();
                } else {
                    this.f14156e.h1(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.q0.v.d.f.b.a f14157a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q0.v.d.f.b.b f14158b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q0.v.d.f.b.c f14159c;

        /* renamed from: d  reason: collision with root package name */
        public List<d.a.d.k.e.a> f14160d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f14161e;

        /* loaded from: classes4.dex */
        public class a implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ConcernTabFragment f14162e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f14163f;

            public a(e eVar, ConcernTabFragment concernTabFragment) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, concernTabFragment};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14163f = eVar;
                this.f14162e = concernTabFragment;
            }

            @Override // d.a.d.k.e.w
            public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && nVar != null && (nVar instanceof d.a.q0.v.d.f.c.f)) {
                    d.a.q0.v.d.f.c.f fVar = (d.a.q0.v.d.f.c.f) nVar;
                    if (fVar.f65171f == null) {
                        return;
                    }
                    if (!l.D()) {
                        this.f14163f.f14161e.getPageContext().showToast(R.string.neterror);
                        return;
                    }
                    if (fVar.f65172g) {
                        TiebaStatic.log(new StatisticItem("c12896"));
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12894");
                        if (fVar.f65171f.isLegalYYLiveData()) {
                            TiebaStaticHelper.addYYParam(statisticItem, fVar.f65171f.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                    }
                    if (fVar.f65171f.isLegalYYLiveData()) {
                        TbPageContext<BaseFragmentActivity> pageContext = this.f14163f.f14161e.getPageContext();
                        YyExtData yyExtData = fVar.f65171f.mYyExtData;
                        String str = yyExtData.mSid;
                        String str2 = yyExtData.mSsid;
                        String str3 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str, str2, str3, "" + fVar.f65171f.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_FOLLOW_HEAD);
                    }
                }
            }
        }

        public e(ConcernTabFragment concernTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14161e = concernTabFragment;
            this.f14160d = new LinkedList();
            this.f14157a = new d.a.q0.v.d.f.b.a(concernTabFragment.getPageContext());
            this.f14158b = new d.a.q0.v.d.f.b.b(concernTabFragment.getPageContext());
            this.f14159c = new d.a.q0.v.d.f.b.c(concernTabFragment.getPageContext());
            this.f14158b.a0(new a(this, concernTabFragment));
            this.f14160d.add(this.f14157a);
            this.f14160d.add(this.f14158b);
            this.f14160d.add(this.f14159c);
        }
    }

    public ConcernTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = true;
        this.q = false;
        this.s = new a(this, 2005016);
        this.t = new b(this);
        this.u = new c(this);
        this.v = new d(this);
    }

    public static ConcernTabFragment f1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) ? new ConcernTabFragment() : (ConcernTabFragment) invokeI.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void O0() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdTypeRecyclerView = this.f14152i) == null) {
            return;
        }
        bdTypeRecyclerView.getAdapter().notifyDataSetChanged();
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14152i.setNextPage(null);
        }
    }

    public final void e1() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f14152i;
            if (bdTypeRecyclerView != null && (hVar = this.m) != null) {
                bdTypeRecyclerView.removeHeaderView(hVar.b());
            }
            this.q = false;
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o.C();
            showLoadingView(this.f14151h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
        }
    }

    public void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || z) {
            return;
        }
        this.j.setRefreshing(false);
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14152i.setNextPage(this.k);
            this.k.O();
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.m == null) {
                h hVar = new h(getPageContext().getContext(), getNetRefreshListener());
                this.m = hVar;
                hVar.m(null);
                this.m.g(null);
                this.m.o();
                this.m.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.m.l(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
            this.m.onChangeSkinType();
            if (!this.q) {
                this.f14152i.t(this.m.b(), 0);
            }
            this.q = true;
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f14152i.setNextPage(this.k);
            this.k.A(getResources().getString(R.string.live_sub_tab_no_more_data));
            this.k.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.l;
            if (gVar != null) {
                gVar.I(i2);
            }
            PbListView pbListView = this.k;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.k.d(i2);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f14152i;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f14152i, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.o == null) {
                SpecialConcernTabModel specialConcernTabModel = new SpecialConcernTabModel(getPageContext());
                this.o = specialConcernTabModel;
                specialConcernTabModel.D(this.t);
            }
            MessageManager.getInstance().registerListener(this.s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f14151h == null) {
                View inflate = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
                this.f14151h = inflate;
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.content_thread);
                this.f14152i = bdTypeRecyclerView;
                bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                this.f14152i.setFadingEdgeLength(0);
                this.f14152i.setOverScrollMode(2);
                this.f14152i.setOnSrollToBottomListener(this.u);
                g gVar = new g(getPageContext());
                this.l = gVar;
                gVar.a(this.v);
                PbListView pbListView = new PbListView(getContext());
                this.k = pbListView;
                pbListView.a();
                this.k.o(R.color.CAM_X0201);
                this.k.r(l.g(getContext(), R.dimen.tbds182));
                this.k.v();
                this.k.E(R.dimen.tbfontsize33);
                this.k.C(SkinManager.getColor(R.color.CAM_X0107));
                this.k.y(R.color.CAM_X0110);
                this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f14151h.findViewById(R.id.pull_refresh_layout);
                this.j = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.l);
                e eVar = new e(this);
                this.n = eVar;
                this.f14152i.a(eVar.f14160d);
            }
            if (this.f14151h.getParent() != null) {
                ((ViewGroup) this.f14151h.getParent()).removeView(this.f14151h);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (TbadkCoreApplication.isLogin()) {
                g1();
            }
            return this.f14151h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            this.f14152i.setOnSrollToBottomListener(null);
            this.f14152i.setScrollable(null);
            this.o.onDestroy();
            hideLoadingView(this.f14151h);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onNetRefreshButtonClicked();
            g1();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.s();
            BdTypeRecyclerView bdTypeRecyclerView = this.f14152i;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.j;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(true);
            }
        }
    }
}
