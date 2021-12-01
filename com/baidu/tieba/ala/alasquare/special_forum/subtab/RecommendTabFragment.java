package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.q0.g0.h;
import c.a.q0.s.g0.f;
import c.a.q0.s.g0.g;
import c.a.q0.s.q.d2;
import c.a.r0.a0.f.g.b.e;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RECOMMEND_TAB_ID = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f42898h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f42899i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f42900j;

    /* renamed from: k  reason: collision with root package name */
    public g f42901k;
    public h l;
    public d m;
    public SpecialRecommendTabModel n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public String s;
    public SpecialRecommendTabModel.b t;
    public BdListView.p u;
    public final f.g v;

    /* loaded from: classes10.dex */
    public class a implements SpecialRecommendTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendTabFragment a;

        public a(RecommendTabFragment recommendTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                RecommendTabFragment recommendTabFragment = this.a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.f42898h);
                this.a.v();
                this.a.showNetRefreshView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void b(List<n> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.a.o = z;
                this.a.q = true;
                if (!ListUtils.isEmpty(list)) {
                    this.a.f42899i.setData(list);
                }
                if (!this.a.o) {
                    this.a.y();
                } else {
                    this.a.x();
                }
                this.a.setIsRefresh(false);
                RecommendTabFragment recommendTabFragment = this.a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.f42898h);
                this.a.hideNetRefreshView();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f42902e;

        public b(RecommendTabFragment recommendTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42902e = recommendTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.C()) {
                    this.f42902e.v();
                } else if (this.f42902e.o) {
                    this.f42902e.n.H();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f42903e;

        public c(RecommendTabFragment recommendTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42903e = recommendTabFragment;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f42903e.n.I();
                } else {
                    this.f42903e.setIsRefresh(false);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.r0.a0.f.g.b.d f42904b;

        /* renamed from: c  reason: collision with root package name */
        public List<c.a.d.m.e.a> f42905c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f42906d;

        /* loaded from: classes10.dex */
        public class a implements c.a.r0.a0.f.h.d.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecommendTabFragment a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f42907b;

            public a(d dVar, RecommendTabFragment recommendTabFragment) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, recommendTabFragment};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42907b = dVar;
                this.a = recommendTabFragment;
            }

            @Override // c.a.r0.a0.f.h.d.f
            public void a(int i2, String str, d2 d2Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, d2Var) == null) {
                    String str2 = "";
                    if (d2Var != null && d2Var.o1() != null && d2Var.o1().isLegalYYLiveData()) {
                        AlaInfoData o1 = d2Var.o1();
                        TbPageContext<BaseFragmentActivity> pageContext = this.f42907b.f42906d.getPageContext();
                        YyExtData yyExtData = o1.mYyExtData;
                        String str3 = yyExtData.mSid;
                        String str4 = yyExtData.mSsid;
                        String str5 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str3, str4, str5, "" + o1.roomId, "baidu_live_zhibo_block_1");
                    }
                    if (d2Var != null) {
                        StatisticItem param = new StatisticItem("c12900").param("tid", d2Var.v1());
                        param.param("fid", this.f42907b.f42906d.r);
                        param.param("fname", this.f42907b.f42906d.s);
                        int calculateLiveType = YYLiveUtil.calculateLiveType(d2Var.o1());
                        if (d2Var.o1() != null && d2Var.o1().isLegalYYLiveData()) {
                            TiebaStaticHelper.addYYParam(param, d2Var.o1().mYyExtData);
                            str2 = TiebaStatic.YYValues.YY_LIVE;
                        }
                        param.param("obj_param1", calculateLiveType);
                        param.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                        TiebaStatic.log(param);
                    }
                }
            }

            @Override // c.a.r0.a0.f.h.d.f
            public void b(c.a.r0.a0.f.h.b.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                }
            }
        }

        public d(RecommendTabFragment recommendTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42906d = recommendTabFragment;
            this.f42905c = new LinkedList();
            this.f42904b = new c.a.r0.a0.f.g.b.d(recommendTabFragment.getPageContext());
            e eVar = new e(recommendTabFragment.getPageContext());
            this.a = eVar;
            eVar.j0(2);
            this.a.i0(c.a.d.f.m.b.g(recommendTabFragment.r, 0L));
            this.a.a(recommendTabFragment.s);
            this.f42905c.add(this.f42904b);
            this.f42905c.add(this.a);
            this.a.k0(new a(this, recommendTabFragment));
        }
    }

    public RecommendTabFragment() {
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
        this.o = true;
        this.p = false;
        this.q = false;
        this.r = "";
        this.s = "";
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this);
    }

    public static RecommendTabFragment newInstance(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65545, null, i2, str, str2)) == null) {
            RecommendTabFragment recommendTabFragment = new RecommendTabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("forum_id", str);
            bundle.putString("forum_name", str2);
            recommendTabFragment.setArguments(bundle);
            return recommendTabFragment;
        }
        return (RecommendTabFragment) invokeILL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.forceRefresh();
            BdTypeListView bdTypeListView = this.f42899i;
            if (bdTypeListView != null) {
                bdTypeListView.smoothScrollToPosition(0);
                this.f42899i.startPullRefresh();
            }
        }
    }

    public final void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdTypeListView bdTypeListView = this.f42899i;
            if (bdTypeListView != null && (hVar = this.l) != null) {
                bdTypeListView.removeHeaderView(hVar.b());
            }
            this.p = false;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void notifyDataSetChanged() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f42899i) == null) {
            return;
        }
        bdTypeListView.getAdapter2().notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.f42901k;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f42900j;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.f42900j.d(i2);
            }
            SkinManager.setBackgroundColor(this.f42899i, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.r = arguments.getString("forum_id");
                this.s = arguments.getString("forum_name");
            }
            if (this.n == null) {
                SpecialRecommendTabModel specialRecommendTabModel = new SpecialRecommendTabModel(getPageContext());
                this.n = specialRecommendTabModel;
                specialRecommendTabModel.J(this.t);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f42898h == null) {
                View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
                this.f42898h = inflate;
                BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
                this.f42899i = bdTypeListView;
                bdTypeListView.setFadingEdgeLength(0);
                this.f42899i.setOverScrollMode(2);
                this.f42899i.setScrollable(this);
                this.f42899i.setOnSrollToBottomListener(this.u);
                g gVar = new g(getPageContext());
                this.f42901k = gVar;
                gVar.a(this.v);
                this.f42899i.setPullRefresh(this.f42901k);
                PbListView pbListView = new PbListView(getContext());
                this.f42900j = pbListView;
                pbListView.a();
                this.f42900j.p(R.color.CAM_X0201);
                this.f42900j.s(l.f(getContext(), R.dimen.tbds182));
                this.f42900j.x();
                this.f42900j.G(R.dimen.tbfontsize33);
                this.f42900j.E(SkinManager.getColor(R.color.CAM_X0107));
                this.f42900j.A(R.color.CAM_X0110);
                this.f42900j.b().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                d dVar = new d(this);
                this.m = dVar;
                this.f42899i.addAdapters(dVar.f42905c);
            }
            if (this.f42898h.getParent() != null) {
                ((ViewGroup) this.f42898h.getParent()).removeView(this.f42898h);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f42898h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.f42899i.setOnSrollToBottomListener(null);
            this.f42899i.setScrollable(null);
            this.n.onDestroy();
            hideLoadingView(this.f42898h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onNetRefreshButtonClicked();
            w();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.q) {
                w();
            }
        }
    }

    public void setIsRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || z) {
            return;
        }
        this.f42899i.completePullRefresh();
    }

    public final void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.l == null) {
                h hVar = new h(getPageContext().getContext(), getNetRefreshListener());
                this.l = hVar;
                hVar.m(null);
                this.l.g(null);
                this.l.o();
                this.l.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.l.l(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
            this.l.onChangeSkinType();
            if (!this.p) {
                this.f42899i.addHeaderView(this.l.b(), 0);
            }
            this.p = true;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f42899i.setNextPage(this.f42900j);
            this.f42900j.s(l.f(getContext(), R.dimen.tbds182));
            this.f42900j.l(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.q = false;
            this.n.I();
            showLoadingView(this.f42898h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f42899i.setNextPage(this.f42900j);
            this.f42900j.s(l.f(getContext(), R.dimen.tbds182));
            this.f42900j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f42900j.Q();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f42899i.setNextPage(this.f42900j);
            this.f42900j.s(l.f(getContext(), R.dimen.tbds182));
            this.f42900j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f42900j.C(getResources().getString(R.string.live_sub_tab_no_more_data));
            this.f42900j.f();
        }
    }
}
