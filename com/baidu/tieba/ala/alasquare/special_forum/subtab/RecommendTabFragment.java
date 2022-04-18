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
import com.repackage.cu4;
import com.repackage.du4;
import com.repackage.h45;
import com.repackage.ho;
import com.repackage.mg;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.or5;
import com.repackage.qq5;
import com.repackage.rq5;
import com.repackage.uo;
import com.repackage.vr5;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View d;
    public BdTypeListView e;
    public PbListView f;
    public du4 g;
    public h45 h;
    public d i;
    public SpecialRecommendTabModel j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public String o;
    public SpecialRecommendTabModel.b p;
    public BdListView.p q;
    public final cu4.g r;

    /* loaded from: classes3.dex */
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
                recommendTabFragment.hideLoadingView(recommendTabFragment.d);
                this.a.T0();
                this.a.Z0();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void b(List<uo> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.a.k = z;
                this.a.m = true;
                if (!ListUtils.isEmpty(list)) {
                    this.a.e.setData(list);
                }
                if (!this.a.k) {
                    this.a.a1();
                } else {
                    this.a.Y0();
                }
                this.a.X0(false);
                RecommendTabFragment recommendTabFragment = this.a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.d);
                this.a.U0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (!oi.C()) {
                    this.a.T0();
                } else if (this.a.k) {
                    this.a.j.J();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements cu4.g {
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

        @Override // com.repackage.cu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (mi.z()) {
                    this.a.j.K();
                } else {
                    this.a.X0(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public rq5 a;
        public qq5 b;
        public List<ho> c;
        public final /* synthetic */ RecommendTabFragment d;

        /* loaded from: classes3.dex */
        public class a implements vr5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecommendTabFragment a;
            public final /* synthetic */ d b;

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
                this.b = dVar;
                this.a = recommendTabFragment;
            }

            @Override // com.repackage.vr5
            public void a(int i, String str, ThreadData threadData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, threadData) == null) {
                    String str2 = "";
                    if (threadData != null && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().isLegalYYLiveData()) {
                        AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                        TbPageContext<BaseFragmentActivity> pageContext = this.b.d.getPageContext();
                        YyExtData yyExtData = threadAlaInfo.mYyExtData;
                        String str3 = yyExtData.mSid;
                        String str4 = yyExtData.mSsid;
                        String str5 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str3, str4, str5, "" + threadAlaInfo.roomId, "baidu_live_zhibo_block_1");
                    }
                    if (threadData != null) {
                        StatisticItem param = new StatisticItem("c12900").param("tid", threadData.getTid());
                        param.param("fid", this.b.d.n);
                        param.param("fname", this.b.d.o);
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

            @Override // com.repackage.vr5
            public void b(or5 or5Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, or5Var) == null) {
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
            this.d = recommendTabFragment;
            this.c = new LinkedList();
            this.b = new qq5(recommendTabFragment.getPageContext());
            rq5 rq5Var = new rq5(recommendTabFragment.getPageContext());
            this.a = rq5Var;
            rq5Var.c0(2);
            this.a.b0(mg.g(recommendTabFragment.n, 0L));
            this.a.a(recommendTabFragment.o);
            this.c.add(this.b);
            this.c.add(this.a);
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

    public static RecommendTabFragment V0(int i, String str, String str2) {
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
    public void D0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdTypeListView = this.e) == null) {
            return;
        }
        bdTypeListView.getAdapter2().notifyDataSetChanged();
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.setNextPage(this.f);
            this.f.t(oi.f(getContext(), R.dimen.tbds182));
            this.f.l(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final void U0() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdTypeListView bdTypeListView = this.e;
            if (bdTypeListView != null && (h45Var = this.h) != null) {
                bdTypeListView.removeHeaderView(h45Var.b());
            }
            this.l = false;
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m = false;
            this.j.K();
            showLoadingView(this.d, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070283));
        }
    }

    public void X0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || z) {
            return;
        }
        this.e.z();
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.setNextPage(this.f);
            this.f.t(oi.f(getContext(), R.dimen.tbds182));
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.Q();
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.h == null) {
                h45 h45Var = new h45(getPageContext().getContext(), getNetRefreshListener());
                this.h = h45Var;
                h45Var.n(null);
                this.h.g(null);
                this.h.p();
                this.h.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.h.m(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f11b8));
            this.h.onChangeSkinType();
            if (!this.l) {
                this.e.x(this.h.b(), 0);
            }
            this.l = true;
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.setNextPage(this.f);
            this.f.t(oi.f(getContext(), R.dimen.tbds182));
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.C(getResources().getString(R.string.obfuscated_res_0x7f0f0a0b));
            this.f.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            du4 du4Var = this.g;
            if (du4Var != null) {
                du4Var.H(i);
            }
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.f.d(i);
            }
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
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
            if (this.d == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0785, viewGroup, false);
                this.d = inflate;
                BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.obfuscated_res_0x7f0906f0);
                this.e = bdTypeListView;
                bdTypeListView.setFadingEdgeLength(0);
                this.e.setOverScrollMode(2);
                this.e.setScrollable(this);
                this.e.setOnSrollToBottomListener(this.q);
                du4 du4Var = new du4(getPageContext());
                this.g = du4Var;
                du4Var.f(this.r);
                this.e.setPullRefresh(this.g);
                PbListView pbListView = new PbListView(getContext());
                this.f = pbListView;
                pbListView.a();
                this.f.p(R.color.CAM_X0201);
                this.f.t(oi.f(getContext(), R.dimen.tbds182));
                this.f.x();
                this.f.G(R.dimen.tbfontsize33);
                this.f.E(SkinManager.getColor(R.color.CAM_X0107));
                this.f.A(R.color.CAM_X0110);
                this.f.b().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                d dVar = new d(this);
                this.i = dVar;
                this.e.a(dVar.c);
            }
            if (this.d.getParent() != null) {
                ((ViewGroup) this.d.getParent()).removeView(this.d);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            this.e.setOnSrollToBottomListener(null);
            this.e.setScrollable(null);
            this.j.onDestroy();
            hideLoadingView(this.d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onNetRefreshButtonClicked();
            W0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.m) {
                W0();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.p();
            BdTypeListView bdTypeListView = this.e;
            if (bdTypeListView != null) {
                bdTypeListView.smoothScrollToPosition(0);
                this.e.F();
            }
        }
    }
}
