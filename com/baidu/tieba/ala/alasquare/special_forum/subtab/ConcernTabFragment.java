package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.p0.f0.h;
import c.a.p0.s.f0.f;
import c.a.p0.s.f0.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
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
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f49409h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f49410i;

    /* renamed from: j  reason: collision with root package name */
    public BdSwipeRefreshLayout f49411j;
    public PbListView k;
    public g l;
    public h m;
    public e n;
    public SpecialConcernTabModel o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public CustomMessageListener u;
    public SpecialConcernTabModel.b v;
    public BdListView.p w;
    public final f.g x;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f49412a;

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
            this.f49412a = concernTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f49412a.o == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.f49412a.t();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SpecialConcernTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f49413a;

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
            this.f49413a = concernTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                ConcernTabFragment concernTabFragment = this.f49413a;
                concernTabFragment.hideLoadingView(concernTabFragment.f49409h);
                this.f49413a.s();
                this.f49413a.showNetRefreshView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void b(List<n> list, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f49413a.p = z;
                this.f49413a.r = true;
                this.f49413a.setIsRefresh(false);
                ConcernTabFragment concernTabFragment = this.f49413a;
                concernTabFragment.hideLoadingView(concernTabFragment.f49409h);
                if (ListUtils.getCount(list) == 0) {
                    this.f49413a.showNetRefreshView();
                } else {
                    this.f49413a.f49410i.setData(list);
                    if (!this.f49413a.p) {
                        this.f49413a.v();
                    } else {
                        this.f49413a.u();
                    }
                    this.f49413a.hideNetRefreshView();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i2 > 0)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f49414e;

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
            this.f49414e = concernTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f49414e.s();
                } else if (this.f49414e.p) {
                    this.f49414e.o.B();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f49415e;

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
            this.f49415e = concernTabFragment;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f49415e.o.C();
                } else {
                    this.f49415e.setIsRefresh(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.q0.v.d.g.b.a f49416a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.q0.v.d.g.b.b f49417b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.q0.v.d.g.b.c f49418c;

        /* renamed from: d  reason: collision with root package name */
        public List<c.a.e.l.e.a> f49419d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f49420e;

        /* loaded from: classes7.dex */
        public class a implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ConcernTabFragment f49421e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f49422f;

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
                this.f49422f = eVar;
                this.f49421e = concernTabFragment;
            }

            @Override // c.a.e.l.e.w
            public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && nVar != null && (nVar instanceof c.a.q0.v.d.g.c.f)) {
                    c.a.q0.v.d.g.c.f fVar = (c.a.q0.v.d.g.c.f) nVar;
                    if (fVar.f25319f == null) {
                        return;
                    }
                    if (!l.D()) {
                        this.f49422f.f49420e.getPageContext().showToast(R.string.neterror);
                        return;
                    }
                    if (fVar.f25320g) {
                        TiebaStatic.log(new StatisticItem("c12896"));
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12894");
                        statisticItem.addParam("fid", this.f49422f.f49420e.s);
                        statisticItem.addParam("fname", this.f49422f.f49420e.t);
                        if (fVar.f25319f.isLegalYYLiveData()) {
                            AlaInfoData alaInfoData = fVar.f25319f;
                            int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData);
                            String str = StringUtils.isNull(alaInfoData.appId) ? null : alaInfoData.appId;
                            if (alaInfoData.mYyExtData != null) {
                                str = TiebaStatic.YYValues.YY_LIVE;
                            }
                            statisticItem.addParam("obj_param1", calculateLiveType);
                            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
                            YYLiveUtil.calculateLiveType(fVar.f25319f);
                            TiebaStaticHelper.addYYParam(statisticItem, fVar.f25319f.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                    }
                    if (fVar.f25319f.isLegalYYLiveData()) {
                        TbPageContext<BaseFragmentActivity> pageContext = this.f49422f.f49420e.getPageContext();
                        YyExtData yyExtData = fVar.f25319f.mYyExtData;
                        String str2 = yyExtData.mSid;
                        String str3 = yyExtData.mSsid;
                        String str4 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str2, str3, str4, "" + fVar.f25319f.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_FOLLOW_HEAD);
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
            this.f49420e = concernTabFragment;
            this.f49419d = new LinkedList();
            this.f49416a = new c.a.q0.v.d.g.b.a(concernTabFragment.getPageContext());
            c.a.q0.v.d.g.b.b bVar = new c.a.q0.v.d.g.b.b(concernTabFragment.getPageContext());
            this.f49417b = bVar;
            bVar.j0(concernTabFragment.s);
            this.f49417b.a(concernTabFragment.t);
            this.f49418c = new c.a.q0.v.d.g.b.c(concernTabFragment.getPageContext());
            this.f49417b.d0(new a(this, concernTabFragment));
            this.f49419d.add(this.f49416a);
            this.f49419d.add(this.f49417b);
            this.f49419d.add(this.f49418c);
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
        this.s = "";
        this.t = "";
        this.u = new a(this, 2005016);
        this.v = new b(this);
        this.w = new c(this);
        this.x = new d(this);
    }

    public static ConcernTabFragment newInstance(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65549, null, i2, str, str2)) == null) {
            ConcernTabFragment concernTabFragment = new ConcernTabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("forum_id", str);
            bundle.putString("forum_name", str2);
            concernTabFragment.setArguments(bundle);
            return concernTabFragment;
        }
        return (ConcernTabFragment) invokeILL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.forceRefresh();
            BdTypeRecyclerView bdTypeRecyclerView = this.f49410i;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f49411j;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(true);
            }
        }
    }

    public final void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f49410i;
            if (bdTypeRecyclerView != null && (hVar = this.m) != null) {
                bdTypeRecyclerView.removeHeaderView(hVar.b());
            }
            this.q = false;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void notifyDataSetChanged() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f49410i) == null) {
            return;
        }
        bdTypeRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.l;
            if (gVar != null) {
                gVar.D(i2);
            }
            PbListView pbListView = this.k;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.k.d(i2);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f49410i;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.f49411j, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f49410i, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.s = arguments.getString("forum_id");
                this.t = arguments.getString("forum_name");
            }
            if (this.o == null) {
                SpecialConcernTabModel specialConcernTabModel = new SpecialConcernTabModel(getPageContext());
                this.o = specialConcernTabModel;
                specialConcernTabModel.D(this.v);
            }
            MessageManager.getInstance().registerListener(this.u);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f49409h == null) {
                View inflate = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
                this.f49409h = inflate;
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.content_thread);
                this.f49410i = bdTypeRecyclerView;
                bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                this.f49410i.setFadingEdgeLength(0);
                this.f49410i.setOverScrollMode(2);
                this.f49410i.setOnSrollToBottomListener(this.w);
                g gVar = new g(getPageContext());
                this.l = gVar;
                gVar.a(this.x);
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
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f49409h.findViewById(R.id.pull_refresh_layout);
                this.f49411j = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.l);
                e eVar = new e(this);
                this.n = eVar;
                this.f49410i.addAdapters(eVar.f49419d);
            }
            if (this.f49409h.getParent() != null) {
                ((ViewGroup) this.f49409h.getParent()).removeView(this.f49409h);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (TbadkCoreApplication.isLogin()) {
                t();
            }
            return this.f49409h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.f49410i.setOnSrollToBottomListener(null);
            this.f49410i.setScrollable(null);
            this.o.onDestroy();
            hideLoadingView(this.f49409h);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onNetRefreshButtonClicked();
            t();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f49410i.setNextPage(null);
        }
    }

    public void setIsRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || z) {
            return;
        }
        this.f49411j.setRefreshing(false);
    }

    public final void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
                this.f49410i.addHeaderView(this.m.b(), 0);
            }
            this.q = true;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.C();
            showLoadingView(this.f49409h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f49410i.setNextPage(this.k);
            this.k.O();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f49410i.setNextPage(this.k);
            this.k.A(getResources().getString(R.string.live_sub_tab_no_more_data));
            this.k.f();
        }
    }
}
