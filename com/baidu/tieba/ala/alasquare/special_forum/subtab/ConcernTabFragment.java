package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.e.l.e.w;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
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
/* loaded from: classes9.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f47029h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f47030i;
    public BdSwipeRefreshLayout j;
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

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f47031a;

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
            this.f47031a = concernTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f47031a.o == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.f47031a.t();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements SpecialConcernTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f47032a;

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
            this.f47032a = concernTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                ConcernTabFragment concernTabFragment = this.f47032a;
                concernTabFragment.hideLoadingView(concernTabFragment.f47029h);
                this.f47032a.s();
                this.f47032a.showNetRefreshView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void b(List<n> list, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f47032a.p = z;
                this.f47032a.r = true;
                this.f47032a.setIsRefresh(false);
                ConcernTabFragment concernTabFragment = this.f47032a;
                concernTabFragment.hideLoadingView(concernTabFragment.f47029h);
                if (ListUtils.getCount(list) == 0) {
                    this.f47032a.showNetRefreshView();
                } else {
                    this.f47032a.f47030i.setData(list);
                    if (!this.f47032a.p) {
                        this.f47032a.v();
                    } else {
                        this.f47032a.u();
                    }
                    this.f47032a.hideNetRefreshView();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i2 > 0)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f47033e;

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
            this.f47033e = concernTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f47033e.s();
                } else if (this.f47033e.p) {
                    this.f47033e.o.B();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f47034e;

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
            this.f47034e = concernTabFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f47034e.o.C();
                } else {
                    this.f47034e.setIsRefresh(false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.r0.w.f.g.b.a f47035a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.r0.w.f.g.b.b f47036b;

        /* renamed from: c  reason: collision with root package name */
        public b.a.r0.w.f.g.b.c f47037c;

        /* renamed from: d  reason: collision with root package name */
        public List<b.a.e.l.e.a> f47038d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f47039e;

        /* loaded from: classes9.dex */
        public class a implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f47040e;

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
                this.f47040e = eVar;
            }

            @Override // b.a.e.l.e.w
            public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && nVar != null && (nVar instanceof b.a.r0.w.f.g.c.f)) {
                    b.a.r0.w.f.g.c.f fVar = (b.a.r0.w.f.g.c.f) nVar;
                    if (fVar.f24831f == null) {
                        return;
                    }
                    if (!l.D()) {
                        this.f47040e.f47039e.getPageContext().showToast(R.string.neterror);
                        return;
                    }
                    if (fVar.f24832g) {
                        TiebaStatic.log(new StatisticItem("c12896"));
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12894");
                        statisticItem.addParam("fid", this.f47040e.f47039e.s);
                        statisticItem.addParam("fname", this.f47040e.f47039e.t);
                        if (fVar.f24831f.isLegalYYLiveData()) {
                            AlaInfoData alaInfoData = fVar.f24831f;
                            int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData);
                            String str = StringUtils.isNull(alaInfoData.appId) ? null : alaInfoData.appId;
                            if (alaInfoData.mYyExtData != null) {
                                str = TiebaStatic.YYValues.YY_LIVE;
                            }
                            statisticItem.addParam("obj_param1", calculateLiveType);
                            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
                            YYLiveUtil.calculateLiveType(fVar.f24831f);
                            TiebaStaticHelper.addYYParam(statisticItem, fVar.f24831f.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                    }
                    if (fVar.f24831f.isLegalYYLiveData()) {
                        TbPageContext<BaseFragmentActivity> pageContext = this.f47040e.f47039e.getPageContext();
                        YyExtData yyExtData = fVar.f24831f.mYyExtData;
                        String str2 = yyExtData.mSid;
                        String str3 = yyExtData.mSsid;
                        String str4 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str2, str3, str4, "" + fVar.f24831f.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_FOLLOW_HEAD);
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
            this.f47039e = concernTabFragment;
            this.f47038d = new LinkedList();
            this.f47035a = new b.a.r0.w.f.g.b.a(concernTabFragment.getPageContext());
            b.a.r0.w.f.g.b.b bVar = new b.a.r0.w.f.g.b.b(concernTabFragment.getPageContext());
            this.f47036b = bVar;
            bVar.i0(concernTabFragment.s);
            this.f47036b.a(concernTabFragment.t);
            this.f47037c = new b.a.r0.w.f.g.b.c(concernTabFragment.getPageContext());
            this.f47036b.c0(new a(this, concernTabFragment));
            this.f47038d.add(this.f47035a);
            this.f47038d.add(this.f47036b);
            this.f47038d.add(this.f47037c);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f47030i;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.j;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(true);
            }
        }
    }

    public final void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f47030i;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f47030i) == null) {
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
                gVar.C(i2);
            }
            PbListView pbListView = this.k;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.k.d(i2);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f47030i;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f47030i, R.color.CAM_X0201);
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
            if (this.f47029h == null) {
                View inflate = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
                this.f47029h = inflate;
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.content_thread);
                this.f47030i = bdTypeRecyclerView;
                bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                this.f47030i.setFadingEdgeLength(0);
                this.f47030i.setOverScrollMode(2);
                this.f47030i.setOnSrollToBottomListener(this.w);
                g gVar = new g(getPageContext());
                this.l = gVar;
                gVar.a(this.x);
                PbListView pbListView = new PbListView(getContext());
                this.k = pbListView;
                pbListView.a();
                this.k.p(R.color.CAM_X0201);
                this.k.s(l.g(getContext(), R.dimen.tbds182));
                this.k.x();
                this.k.G(R.dimen.tbfontsize33);
                this.k.E(SkinManager.getColor(R.color.CAM_X0107));
                this.k.A(R.color.CAM_X0110);
                this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f47029h.findViewById(R.id.pull_refresh_layout);
                this.j = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.l);
                e eVar = new e(this);
                this.n = eVar;
                this.f47030i.addAdapters(eVar.f47038d);
            }
            if (this.f47029h.getParent() != null) {
                ((ViewGroup) this.f47029h.getParent()).removeView(this.f47029h);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (TbadkCoreApplication.isLogin()) {
                t();
            }
            return this.f47029h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.f47030i.setOnSrollToBottomListener(null);
            this.f47030i.setScrollable(null);
            this.o.onDestroy();
            hideLoadingView(this.f47029h);
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
            this.f47030i.setNextPage(null);
        }
    }

    public void setIsRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || z) {
            return;
        }
        this.j.setRefreshing(false);
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
                this.f47030i.addHeaderView(this.m.b(), 0);
            }
            this.q = true;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.C();
            showLoadingView(this.f47029h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f47030i.setNextPage(this.k);
            this.k.Q();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f47030i.setNextPage(this.k);
            this.k.C(getResources().getString(R.string.live_sub_tab_no_more_data));
            this.k.f();
        }
    }
}
