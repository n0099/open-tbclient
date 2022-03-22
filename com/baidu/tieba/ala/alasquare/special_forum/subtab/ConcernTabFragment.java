package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
import c.a.o0.f0.h;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
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
/* loaded from: classes5.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public View f31355d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f31356e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f31357f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f31358g;

    /* renamed from: h  reason: collision with root package name */
    public g f31359h;
    public h i;
    public e j;
    public SpecialConcernTabModel k;
    public boolean l;
    public boolean m;
    public boolean n;
    public String o;
    public String p;
    public CustomMessageListener q;
    public SpecialConcernTabModel.b r;
    public BdListView.p s;
    public final f.g t;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernTabFragment concernTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.k == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.a.Y0();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SpecialConcernTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernTabFragment a;

        public b(ConcernTabFragment concernTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                ConcernTabFragment concernTabFragment = this.a;
                concernTabFragment.hideLoadingView(concernTabFragment.f31355d);
                this.a.V0();
                this.a.b1();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void b(List<n> list, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.l = z;
                this.a.n = true;
                this.a.Z0(false);
                ConcernTabFragment concernTabFragment = this.a;
                concernTabFragment.hideLoadingView(concernTabFragment.f31355d);
                if (ListUtils.getCount(list) == 0) {
                    this.a.b1();
                } else {
                    this.a.f31356e.setData(list);
                    if (!this.a.l) {
                        this.a.c1();
                    } else {
                        this.a.a1();
                    }
                    this.a.W0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernTabFragment a;

        public c(ConcernTabFragment concernTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.n.C()) {
                    this.a.V0();
                } else if (this.a.l) {
                    this.a.k.D();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernTabFragment a;

        public d(ConcernTabFragment concernTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernTabFragment;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    this.a.k.E();
                } else {
                    this.a.Z0(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.c0.f.g.b.a a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.p0.c0.f.g.b.b f31360b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.p0.c0.f.g.b.c f31361c;

        /* renamed from: d  reason: collision with root package name */
        public List<c.a.d.o.e.a> f31362d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernTabFragment f31363e;

        /* loaded from: classes5.dex */
        public class a implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ConcernTabFragment a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f31364b;

            public a(e eVar, ConcernTabFragment concernTabFragment) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, concernTabFragment};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31364b = eVar;
                this.a = concernTabFragment;
            }

            @Override // c.a.d.o.e.w
            public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && nVar != null && (nVar instanceof c.a.p0.c0.f.g.c.f)) {
                    c.a.p0.c0.f.g.c.f fVar = (c.a.p0.c0.f.g.c.f) nVar;
                    if (fVar.f13078b == null) {
                        return;
                    }
                    if (!c.a.d.f.p.n.C()) {
                        this.f31364b.f31363e.getPageContext().showToast((int) R.string.obfuscated_res_0x7f0f0c15);
                        return;
                    }
                    if (fVar.f13079c) {
                        TiebaStatic.log(new StatisticItem("c12896"));
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12894");
                        statisticItem.addParam("fid", this.f31364b.f31363e.o);
                        statisticItem.addParam("fname", this.f31364b.f31363e.p);
                        if (fVar.f13078b.isLegalYYLiveData()) {
                            AlaInfoData alaInfoData = fVar.f13078b;
                            int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData);
                            String str = StringUtils.isNull(alaInfoData.appId) ? null : alaInfoData.appId;
                            if (alaInfoData.mYyExtData != null) {
                                str = TiebaStatic.YYValues.YY_LIVE;
                            }
                            statisticItem.addParam("obj_param1", calculateLiveType);
                            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
                            YYLiveUtil.calculateLiveType(fVar.f13078b);
                            TiebaStaticHelper.addYYParam(statisticItem, fVar.f13078b.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                    }
                    if (fVar.f13078b.isLegalYYLiveData()) {
                        TbPageContext<BaseFragmentActivity> pageContext = this.f31364b.f31363e.getPageContext();
                        YyExtData yyExtData = fVar.f13078b.mYyExtData;
                        String str2 = yyExtData.mSid;
                        String str3 = yyExtData.mSsid;
                        String str4 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str2, str3, str4, "" + fVar.f13078b.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_FOLLOW_HEAD);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31363e = concernTabFragment;
            this.f31362d = new LinkedList();
            this.a = new c.a.p0.c0.f.g.b.a(concernTabFragment.getPageContext());
            c.a.p0.c0.f.g.b.b bVar = new c.a.p0.c0.f.g.b.b(concernTabFragment.getPageContext());
            this.f31360b = bVar;
            bVar.b0(concernTabFragment.o);
            this.f31360b.a(concernTabFragment.p);
            this.f31361c = new c.a.p0.c0.f.g.b.c(concernTabFragment.getPageContext());
            this.f31360b.V(new a(this, concernTabFragment));
            this.f31362d.add(this.a);
            this.f31362d.add(this.f31360b);
            this.f31362d.add(this.f31361c);
        }
    }

    public ConcernTabFragment() {
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
        this.l = true;
        this.m = false;
        this.o = "";
        this.p = "";
        this.q = new a(this, 2005016);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
    }

    public static ConcernTabFragment X0(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65553, null, i, str, str2)) == null) {
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
    public void E0() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdTypeRecyclerView = this.f31356e) == null) {
            return;
        }
        bdTypeRecyclerView.getAdapter().notifyDataSetChanged();
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31356e.setNextPage(null);
        }
    }

    public final void W0() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f31356e;
            if (bdTypeRecyclerView != null && (hVar = this.i) != null) {
                bdTypeRecyclerView.removeHeaderView(hVar.b());
            }
            this.m = false;
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.E();
            showLoadingView(this.f31355d, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070276));
        }
    }

    public void Z0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || z) {
            return;
        }
        this.f31357f.setRefreshing(false);
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f31356e.setNextPage(this.f31358g);
            this.f31358g.R();
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.i == null) {
                h hVar = new h(getPageContext().getContext(), getNetRefreshListener());
                this.i = hVar;
                hVar.n(null);
                this.i.g(null);
                this.i.p();
                this.i.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.i.m(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f11b1));
            this.i.onChangeSkinType();
            if (!this.m) {
                this.f31356e.t(this.i.b(), 0);
            }
            this.m = true;
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f31356e.setNextPage(this.f31358g);
            this.f31358g.D(getResources().getString(R.string.obfuscated_res_0x7f0f0a0b));
            this.f31358g.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            g gVar = this.f31359h;
            if (gVar != null) {
                gVar.H(i);
            }
            PbListView pbListView = this.f31358g;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f31358g.d(i);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f31356e;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.f31357f, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f31356e, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.o = arguments.getString("forum_id");
                this.p = arguments.getString("forum_name");
            }
            if (this.k == null) {
                SpecialConcernTabModel specialConcernTabModel = new SpecialConcernTabModel(getPageContext());
                this.k = specialConcernTabModel;
                specialConcernTabModel.F(this.r);
            }
            MessageManager.getInstance().registerListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f31355d == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d078b, viewGroup, false);
                this.f31355d = inflate;
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f0906e7);
                this.f31356e = bdTypeRecyclerView;
                bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                this.f31356e.setFadingEdgeLength(0);
                this.f31356e.setOverScrollMode(2);
                this.f31356e.setOnSrollToBottomListener(this.s);
                g gVar = new g(getPageContext());
                this.f31359h = gVar;
                gVar.f(this.t);
                PbListView pbListView = new PbListView(getContext());
                this.f31358g = pbListView;
                pbListView.a();
                this.f31358g.p(R.color.CAM_X0201);
                this.f31358g.t(c.a.d.f.p.n.f(getContext(), R.dimen.tbds182));
                this.f31358g.y();
                this.f31358g.H(R.dimen.tbfontsize33);
                this.f31358g.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f31358g.B(R.color.CAM_X0110);
                this.f31358g.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f31355d.findViewById(R.id.obfuscated_res_0x7f091964);
                this.f31357f = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f31359h);
                e eVar = new e(this);
                this.j = eVar;
                this.f31356e.a(eVar.f31362d);
            }
            if (this.f31355d.getParent() != null) {
                ((ViewGroup) this.f31355d.getParent()).removeView(this.f31355d);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (TbadkCoreApplication.isLogin()) {
                Y0();
            }
            return this.f31355d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            this.f31356e.setOnSrollToBottomListener(null);
            this.f31356e.setScrollable(null);
            this.k.onDestroy();
            hideLoadingView(this.f31355d);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onNetRefreshButtonClicked();
            Y0();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.q();
            BdTypeRecyclerView bdTypeRecyclerView = this.f31356e;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f31357f;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(true);
            }
        }
    }
}
