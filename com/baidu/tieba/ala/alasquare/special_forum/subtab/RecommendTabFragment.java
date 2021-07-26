package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.f0.h;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import d.a.p0.s.q.b2;
import d.a.q0.v.d.f.b.e;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f14170h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f14171i;
    public PbListView j;
    public g k;
    public h l;
    public d m;
    public SpecialRecommendTabModel n;
    public boolean o;
    public boolean p;
    public boolean q;
    public SpecialRecommendTabModel.b r;
    public BdListView.p s;
    public final f.g t;

    /* loaded from: classes4.dex */
    public class a implements SpecialRecommendTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f14172a;

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
            this.f14172a = recommendTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                RecommendTabFragment recommendTabFragment = this.f14172a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.f14170h);
                this.f14172a.c1();
                this.f14172a.i1();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void b(List<n> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.f14172a.o = z;
                this.f14172a.q = true;
                if (!ListUtils.isEmpty(list)) {
                    this.f14172a.f14171i.setData(list);
                }
                if (!this.f14172a.o) {
                    this.f14172a.j1();
                } else {
                    this.f14172a.h1();
                }
                this.f14172a.g1(false);
                RecommendTabFragment recommendTabFragment = this.f14172a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.f14170h);
                this.f14172a.d1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f14173e;

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
            this.f14173e = recommendTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f14173e.c1();
                } else if (this.f14173e.o) {
                    this.f14173e.n.H();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f14174e;

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
            this.f14174e = recommendTabFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f14174e.n.I();
                } else {
                    this.f14174e.g1(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public e f14175a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q0.v.d.f.b.d f14176b;

        /* renamed from: c  reason: collision with root package name */
        public List<d.a.d.k.e.a> f14177c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f14178d;

        /* loaded from: classes4.dex */
        public class a implements d.a.q0.v.d.g.d.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RecommendTabFragment f14179a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f14180b;

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
                this.f14180b = dVar;
                this.f14179a = recommendTabFragment;
            }

            @Override // d.a.q0.v.d.g.d.f
            public void a(int i2, String str, b2 b2Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, b2Var) == null) {
                    if (b2Var != null && b2Var.h1() != null && b2Var.h1().isLegalYYLiveData()) {
                        AlaInfoData h1 = b2Var.h1();
                        TbPageContext<BaseFragmentActivity> pageContext = this.f14180b.f14178d.getPageContext();
                        YyExtData yyExtData = h1.mYyExtData;
                        String str2 = yyExtData.mSid;
                        String str3 = yyExtData.mSsid;
                        String str4 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str2, str3, str4, "" + h1.roomId, "baidu_live_zhibo_block_1");
                    }
                    if (b2Var != null) {
                        StatisticItem param = new StatisticItem("c12900").param("tid", b2Var.o1());
                        TiebaStaticHelper.addYYParam(param);
                        TiebaStatic.log(param);
                    }
                }
            }

            @Override // d.a.q0.v.d.g.d.f
            public void b(d.a.q0.v.d.g.b.c cVar) {
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
            this.f14178d = recommendTabFragment;
            this.f14177c = new LinkedList();
            this.f14176b = new d.a.q0.v.d.f.b.d(recommendTabFragment.getPageContext());
            e eVar = new e(recommendTabFragment.getPageContext());
            this.f14175a = eVar;
            eVar.g0(2);
            this.f14177c.add(this.f14176b);
            this.f14177c.add(this.f14175a);
            this.f14175a.i0(new a(this, recommendTabFragment));
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
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
    }

    public static RecommendTabFragment e1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) ? new RecommendTabFragment() : (RecommendTabFragment) invokeI.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void O0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdTypeListView = this.f14171i) == null) {
            return;
        }
        bdTypeListView.getAdapter2().notifyDataSetChanged();
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14171i.setNextPage(this.j);
            this.j.r(l.g(getContext(), R.dimen.tbds182));
            this.j.k(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final void d1() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdTypeListView bdTypeListView = this.f14171i;
            if (bdTypeListView != null && (hVar = this.l) != null) {
                bdTypeListView.removeHeaderView(hVar.b());
            }
            this.p = false;
        }
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.q = false;
            this.n.I();
            showLoadingView(this.f14170h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
        }
    }

    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || z) {
            return;
        }
        this.f14171i.z();
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14171i.setNextPage(this.j);
            this.j.r(l.g(getContext(), R.dimen.tbds182));
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.j.O();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
                this.f14171i.x(this.l.b(), 0);
            }
            this.p = true;
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f14171i.setNextPage(this.j);
            this.j.r(l.g(getContext(), R.dimen.tbds182));
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.j.A(getResources().getString(R.string.live_sub_tab_no_more_data));
            this.j.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.k;
            if (gVar != null) {
                gVar.I(i2);
            }
            PbListView pbListView = this.j;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.j.d(i2);
            }
            SkinManager.setBackgroundColor(this.f14171i, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.n == null) {
                SpecialRecommendTabModel specialRecommendTabModel = new SpecialRecommendTabModel(getPageContext());
                this.n = specialRecommendTabModel;
                specialRecommendTabModel.J(this.r);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f14170h == null) {
                View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
                this.f14170h = inflate;
                BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
                this.f14171i = bdTypeListView;
                bdTypeListView.setFadingEdgeLength(0);
                this.f14171i.setOverScrollMode(2);
                this.f14171i.setScrollable(this);
                this.f14171i.setOnSrollToBottomListener(this.s);
                g gVar = new g(getPageContext());
                this.k = gVar;
                gVar.a(this.t);
                this.f14171i.setPullRefresh(this.k);
                PbListView pbListView = new PbListView(getContext());
                this.j = pbListView;
                pbListView.a();
                this.j.o(R.color.CAM_X0201);
                this.j.r(l.g(getContext(), R.dimen.tbds182));
                this.j.v();
                this.j.E(R.dimen.tbfontsize33);
                this.j.C(SkinManager.getColor(R.color.CAM_X0107));
                this.j.y(R.color.CAM_X0110);
                this.j.b().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                d dVar = new d(this);
                this.m = dVar;
                this.f14171i.a(dVar.f14177c);
            }
            if (this.f14170h.getParent() != null) {
                ((ViewGroup) this.f14170h.getParent()).removeView(this.f14170h);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f14170h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            this.f14171i.setOnSrollToBottomListener(null);
            this.f14171i.setScrollable(null);
            this.n.onDestroy();
            hideLoadingView(this.f14170h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onNetRefreshButtonClicked();
            f1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.q) {
                f1();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.s();
            BdTypeListView bdTypeListView = this.f14171i;
            if (bdTypeListView != null) {
                bdTypeListView.smoothScrollToPosition(0);
                this.f14171i.F();
            }
        }
    }
}
