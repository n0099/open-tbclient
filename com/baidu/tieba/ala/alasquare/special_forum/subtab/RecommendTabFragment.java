package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.o0.f0.h;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
import c.a.p0.c0.f.g.b.e;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes5.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public View f31370d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f31371e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f31372f;

    /* renamed from: g  reason: collision with root package name */
    public g f31373g;

    /* renamed from: h  reason: collision with root package name */
    public h f31374h;
    public d i;
    public SpecialRecommendTabModel j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public String o;
    public SpecialRecommendTabModel.b p;
    public BdListView.p q;
    public final f.g r;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                RecommendTabFragment recommendTabFragment = this.a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.f31370d);
                this.a.U0();
                this.a.a1();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void b(List<n> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.a.k = z;
                this.a.m = true;
                if (!ListUtils.isEmpty(list)) {
                    this.a.f31371e.setData(list);
                }
                if (!this.a.k) {
                    this.a.b1();
                } else {
                    this.a.Z0();
                }
                this.a.Y0(false);
                RecommendTabFragment recommendTabFragment = this.a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.f31370d);
                this.a.V0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendTabFragment a;

        public b(RecommendTabFragment recommendTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.n.C()) {
                    this.a.U0();
                } else if (this.a.k) {
                    this.a.j.J();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendTabFragment a;

        public c(RecommendTabFragment recommendTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendTabFragment;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    this.a.j.K();
                } else {
                    this.a.Y0(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.p0.c0.f.g.b.d f31375b;

        /* renamed from: c  reason: collision with root package name */
        public List<c.a.d.o.e.a> f31376c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RecommendTabFragment f31377d;

        /* loaded from: classes5.dex */
        public class a implements c.a.p0.c0.f.h.d.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecommendTabFragment a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f31378b;

            public a(d dVar, RecommendTabFragment recommendTabFragment) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, recommendTabFragment};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31378b = dVar;
                this.a = recommendTabFragment;
            }

            @Override // c.a.p0.c0.f.h.d.f
            public void a(int i, String str, ThreadData threadData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, threadData) == null) {
                    String str2 = "";
                    if (threadData != null && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().isLegalYYLiveData()) {
                        AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                        TbPageContext<BaseFragmentActivity> pageContext = this.f31378b.f31377d.getPageContext();
                        YyExtData yyExtData = threadAlaInfo.mYyExtData;
                        String str3 = yyExtData.mSid;
                        String str4 = yyExtData.mSsid;
                        String str5 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str3, str4, str5, "" + threadAlaInfo.roomId, "baidu_live_zhibo_block_1");
                    }
                    if (threadData != null) {
                        StatisticItem param = new StatisticItem("c12900").param("tid", threadData.getTid());
                        param.param("fid", this.f31378b.f31377d.n);
                        param.param("fname", this.f31378b.f31377d.o);
                        int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.getThreadAlaInfo());
                        if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().isLegalYYLiveData()) {
                            TiebaStaticHelper.addYYParam(param, threadData.getThreadAlaInfo().mYyExtData);
                            str2 = TiebaStatic.YYValues.YY_LIVE;
                        }
                        param.param("obj_param1", calculateLiveType);
                        param.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                        TiebaStatic.log(param);
                    }
                }
            }

            @Override // c.a.p0.c0.f.h.d.f
            public void b(c.a.p0.c0.f.h.b.c cVar) {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31377d = recommendTabFragment;
            this.f31376c = new LinkedList();
            this.f31375b = new c.a.p0.c0.f.g.b.d(recommendTabFragment.getPageContext());
            e eVar = new e(recommendTabFragment.getPageContext());
            this.a = eVar;
            eVar.c0(2);
            this.a.b0(c.a.d.f.m.b.g(recommendTabFragment.n, 0L));
            this.a.a(recommendTabFragment.o);
            this.f31376c.add(this.f31375b);
            this.f31376c.add(this.a);
            this.a.d0(new a(this, recommendTabFragment));
        }
    }

    public RecommendTabFragment() {
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
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = "";
        this.o = "";
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
    }

    public static RecommendTabFragment W0(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65552, null, i, str, str2)) == null) {
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
    public void E0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdTypeListView = this.f31371e) == null) {
            return;
        }
        bdTypeListView.getAdapter2().notifyDataSetChanged();
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31371e.setNextPage(this.f31372f);
            this.f31372f.t(c.a.d.f.p.n.f(getContext(), R.dimen.tbds182));
            this.f31372f.l(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final void V0() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdTypeListView bdTypeListView = this.f31371e;
            if (bdTypeListView != null && (hVar = this.f31374h) != null) {
                bdTypeListView.removeHeaderView(hVar.b());
            }
            this.l = false;
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m = false;
            this.j.K();
            showLoadingView(this.f31370d, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070276));
        }
    }

    public void Y0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || z) {
            return;
        }
        this.f31371e.z();
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f31371e.setNextPage(this.f31372f);
            this.f31372f.t(c.a.d.f.p.n.f(getContext(), R.dimen.tbds182));
            this.f31372f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f31372f.R();
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f31374h == null) {
                h hVar = new h(getPageContext().getContext(), getNetRefreshListener());
                this.f31374h = hVar;
                hVar.n(null);
                this.f31374h.g(null);
                this.f31374h.p();
                this.f31374h.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.f31374h.m(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f11b1));
            this.f31374h.onChangeSkinType();
            if (!this.l) {
                this.f31371e.x(this.f31374h.b(), 0);
            }
            this.l = true;
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f31371e.setNextPage(this.f31372f);
            this.f31372f.t(c.a.d.f.p.n.f(getContext(), R.dimen.tbds182));
            this.f31372f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f31372f.D(getResources().getString(R.string.obfuscated_res_0x7f0f0a0b));
            this.f31372f.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            g gVar = this.f31373g;
            if (gVar != null) {
                gVar.H(i);
            }
            PbListView pbListView = this.f31372f;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f31372f.d(i);
            }
            SkinManager.setBackgroundColor(this.f31371e, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.n = arguments.getString("forum_id");
                this.o = arguments.getString("forum_name");
            }
            if (this.j == null) {
                SpecialRecommendTabModel specialRecommendTabModel = new SpecialRecommendTabModel(getPageContext());
                this.j = specialRecommendTabModel;
                specialRecommendTabModel.L(this.p);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f31370d == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d078e, viewGroup, false);
                this.f31370d = inflate;
                BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.obfuscated_res_0x7f0906e7);
                this.f31371e = bdTypeListView;
                bdTypeListView.setFadingEdgeLength(0);
                this.f31371e.setOverScrollMode(2);
                this.f31371e.setScrollable(this);
                this.f31371e.setOnSrollToBottomListener(this.q);
                g gVar = new g(getPageContext());
                this.f31373g = gVar;
                gVar.f(this.r);
                this.f31371e.setPullRefresh(this.f31373g);
                PbListView pbListView = new PbListView(getContext());
                this.f31372f = pbListView;
                pbListView.a();
                this.f31372f.p(R.color.CAM_X0201);
                this.f31372f.t(c.a.d.f.p.n.f(getContext(), R.dimen.tbds182));
                this.f31372f.y();
                this.f31372f.H(R.dimen.tbfontsize33);
                this.f31372f.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f31372f.B(R.color.CAM_X0110);
                this.f31372f.b().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                d dVar = new d(this);
                this.i = dVar;
                this.f31371e.a(dVar.f31376c);
            }
            if (this.f31370d.getParent() != null) {
                ((ViewGroup) this.f31370d.getParent()).removeView(this.f31370d);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f31370d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            this.f31371e.setOnSrollToBottomListener(null);
            this.f31371e.setScrollable(null);
            this.j.onDestroy();
            hideLoadingView(this.f31370d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onNetRefreshButtonClicked();
            X0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.m) {
                X0();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.q();
            BdTypeListView bdTypeListView = this.f31371e;
            if (bdTypeListView != null) {
                bdTypeListView.smoothScrollToPosition(0);
                this.f31371e.F();
            }
        }
    }
}
