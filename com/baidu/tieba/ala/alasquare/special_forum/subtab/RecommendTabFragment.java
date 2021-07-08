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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.o0.d0.h;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import d.a.o0.r.q.b2;
import d.a.p0.v.d.f.b.e;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f14122h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f14123i;
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
        public final /* synthetic */ RecommendTabFragment f14124a;

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
            this.f14124a = recommendTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                RecommendTabFragment recommendTabFragment = this.f14124a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.f14122h);
                this.f14124a.X0();
                this.f14124a.d1();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void b(List<n> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.f14124a.o = z;
                this.f14124a.q = true;
                if (!ListUtils.isEmpty(list)) {
                    this.f14124a.f14123i.setData(list);
                }
                if (!this.f14124a.o) {
                    this.f14124a.e1();
                } else {
                    this.f14124a.c1();
                }
                this.f14124a.b1(false);
                RecommendTabFragment recommendTabFragment = this.f14124a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.f14122h);
                this.f14124a.Y0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f14125e;

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
            this.f14125e = recommendTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f14125e.X0();
                } else if (this.f14125e.o) {
                    this.f14125e.n.H();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f14126e;

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
            this.f14126e = recommendTabFragment;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f14126e.n.I();
                } else {
                    this.f14126e.b1(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public e f14127a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.p0.v.d.f.b.d f14128b;

        /* renamed from: c  reason: collision with root package name */
        public List<d.a.c.k.e.a> f14129c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f14130d;

        /* loaded from: classes4.dex */
        public class a implements d.a.p0.v.d.g.d.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RecommendTabFragment f14131a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f14132b;

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
                this.f14132b = dVar;
                this.f14131a = recommendTabFragment;
            }

            @Override // d.a.p0.v.d.g.d.f
            public void a(int i2, String str, b2 b2Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, b2Var) == null) {
                    if (b2Var != null && b2Var.g1() != null && b2Var.g1().isLegalYYLiveData()) {
                        AlaInfoData g1 = b2Var.g1();
                        TbPageContext<BaseFragmentActivity> pageContext = this.f14132b.f14130d.getPageContext();
                        YyExtData yyExtData = g1.mYyExtData;
                        String str2 = yyExtData.mSid;
                        String str3 = yyExtData.mSsid;
                        String str4 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str2, str3, str4, "" + g1.roomId, "baidu_live_zhibo_block_1");
                    }
                    if (b2Var != null) {
                        StatisticItem param = new StatisticItem("c12900").param("tid", b2Var.n1());
                        TiebaStaticHelper.addYYParam(param);
                        TiebaStatic.log(param);
                    }
                }
            }

            @Override // d.a.p0.v.d.g.d.f
            public void b(d.a.p0.v.d.g.b.c cVar) {
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
            this.f14130d = recommendTabFragment;
            this.f14129c = new LinkedList();
            this.f14128b = new d.a.p0.v.d.f.b.d(recommendTabFragment.getPageContext());
            e eVar = new e(recommendTabFragment.getPageContext());
            this.f14127a = eVar;
            eVar.h0(2);
            this.f14129c.add(this.f14128b);
            this.f14129c.add(this.f14127a);
            this.f14127a.i0(new a(this, recommendTabFragment));
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

    public static RecommendTabFragment Z0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) ? new RecommendTabFragment() : (RecommendTabFragment) invokeI.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void J0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdTypeListView = this.f14123i) == null) {
            return;
        }
        bdTypeListView.getAdapter2().notifyDataSetChanged();
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14123i.setNextPage(this.j);
            this.j.r(l.g(getContext(), R.dimen.tbds182));
            this.j.k(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final void Y0() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdTypeListView bdTypeListView = this.f14123i;
            if (bdTypeListView != null && (hVar = this.l) != null) {
                bdTypeListView.removeHeaderView(hVar.b());
            }
            this.p = false;
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.q = false;
            this.n.I();
            showLoadingView(this.f14122h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
        }
    }

    public void b1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || z) {
            return;
        }
        this.f14123i.z();
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14123i.setNextPage(this.j);
            this.j.r(l.g(getContext(), R.dimen.tbds182));
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.j.O();
        }
    }

    public final void d1() {
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
                this.f14123i.x(this.l.b(), 0);
            }
            this.p = true;
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f14123i.setNextPage(this.j);
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
            SkinManager.setBackgroundColor(this.f14123i, R.color.CAM_X0201);
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
            if (this.f14122h == null) {
                View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
                this.f14122h = inflate;
                BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
                this.f14123i = bdTypeListView;
                bdTypeListView.setFadingEdgeLength(0);
                this.f14123i.setOverScrollMode(2);
                this.f14123i.setScrollable(this);
                this.f14123i.setOnSrollToBottomListener(this.s);
                g gVar = new g(getPageContext());
                this.k = gVar;
                gVar.a(this.t);
                this.f14123i.setPullRefresh(this.k);
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
                this.f14123i.a(dVar.f14129c);
            }
            if (this.f14122h.getParent() != null) {
                ((ViewGroup) this.f14122h.getParent()).removeView(this.f14122h);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f14122h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            this.f14123i.setOnSrollToBottomListener(null);
            this.f14123i.setScrollable(null);
            this.n.onDestroy();
            hideLoadingView(this.f14122h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onNetRefreshButtonClicked();
            a1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.q) {
                a1();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.s();
            BdTypeListView bdTypeListView = this.f14123i;
            if (bdTypeListView != null) {
                bdTypeListView.smoothScrollToPosition(0);
                this.f14123i.F();
            }
        }
    }
}
