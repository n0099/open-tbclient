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
import com.repackage.an;
import com.repackage.es5;
import com.repackage.fu4;
import com.repackage.gr5;
import com.repackage.gu4;
import com.repackage.hr5;
import com.repackage.k55;
import com.repackage.ls5;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.pi;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View d;
    public BdTypeListView e;
    public PbListView f;
    public gu4 g;
    public k55 h;
    public d i;
    public SpecialRecommendTabModel j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public String o;
    public SpecialRecommendTabModel.b p;
    public BdListView.p q;
    public final fu4.g r;

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
                this.a.L1();
                this.a.R1();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void b(List<nn> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.a.k = z;
                this.a.m = true;
                if (!ListUtils.isEmpty(list)) {
                    this.a.e.setData(list);
                }
                if (!this.a.k) {
                    this.a.S1();
                } else {
                    this.a.Q1();
                }
                this.a.P1(false);
                RecommendTabFragment recommendTabFragment = this.a;
                recommendTabFragment.hideLoadingView(recommendTabFragment.d);
                this.a.M1();
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
                if (!pi.D()) {
                    this.a.L1();
                } else if (this.a.k) {
                    this.a.j.L();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements fu4.g {
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

        @Override // com.repackage.fu4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (ni.z()) {
                    this.a.j.M();
                } else {
                    this.a.P1(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hr5 a;
        public gr5 b;
        public List<an> c;
        public final /* synthetic */ RecommendTabFragment d;

        /* loaded from: classes3.dex */
        public class a implements ls5 {
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

            @Override // com.repackage.ls5
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

            @Override // com.repackage.ls5
            public void b(es5 es5Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, es5Var) == null) {
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
            this.b = new gr5(recommendTabFragment.getPageContext());
            hr5 hr5Var = new hr5(recommendTabFragment.getPageContext());
            this.a = hr5Var;
            hr5Var.c0(2);
            this.a.b0(ng.g(recommendTabFragment.n, 0L));
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

    public static RecommendTabFragment N1(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65548, null, i, str, str2)) == null) {
            RecommendTabFragment recommendTabFragment = new RecommendTabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("forum_id", str);
            bundle.putString("forum_name", str2);
            recommendTabFragment.setArguments(bundle);
            return recommendTabFragment;
        }
        return (RecommendTabFragment) invokeILL.objValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.setNextPage(this.f);
            this.f.t(pi.f(getContext(), R.dimen.tbds182));
            this.f.l(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final void M1() {
        k55 k55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdTypeListView bdTypeListView = this.e;
            if (bdTypeListView != null && (k55Var = this.h) != null) {
                bdTypeListView.removeHeaderView(k55Var.b());
            }
            this.l = false;
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m = false;
            this.j.M();
            showLoadingView(this.d, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070280));
        }
    }

    public void P1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || z) {
            return;
        }
        this.e.z();
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.setNextPage(this.f);
            this.f.t(pi.f(getContext(), R.dimen.tbds182));
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.Q();
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.h == null) {
                k55 k55Var = new k55(getPageContext().getContext(), getNetRefreshListener());
                this.h = k55Var;
                k55Var.n(null);
                this.h.g(null);
                this.h.p();
                this.h.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.h.m(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f11ed));
            this.h.onChangeSkinType();
            if (!this.l) {
                this.e.x(this.h.b(), 0);
            }
            this.l = true;
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.setNextPage(this.f);
            this.f.t(pi.f(getContext(), R.dimen.tbds182));
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.C(getResources().getString(R.string.obfuscated_res_0x7f0f0a09));
            this.f.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            gu4 gu4Var = this.g;
            if (gu4Var != null) {
                gu4Var.H(i);
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.n = arguments.getString("forum_id");
                this.o = arguments.getString("forum_name");
            }
            if (this.j == null) {
                SpecialRecommendTabModel specialRecommendTabModel = new SpecialRecommendTabModel(getPageContext());
                this.j = specialRecommendTabModel;
                specialRecommendTabModel.N(this.p);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.d == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d078d, viewGroup, false);
                this.d = inflate;
                BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.obfuscated_res_0x7f0906be);
                this.e = bdTypeListView;
                bdTypeListView.setFadingEdgeLength(0);
                this.e.setOverScrollMode(2);
                this.e.setScrollable(this);
                this.e.setOnSrollToBottomListener(this.q);
                gu4 gu4Var = new gu4(getPageContext());
                this.g = gu4Var;
                gu4Var.f(this.r);
                this.e.setPullRefresh(this.g);
                PbListView pbListView = new PbListView(getContext());
                this.f = pbListView;
                pbListView.a();
                this.f.p(R.color.CAM_X0201);
                this.f.t(pi.f(getContext(), R.dimen.tbds182));
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
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onNetRefreshButtonClicked();
            O1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.m) {
                O1();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void u1() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bdTypeListView = this.e) == null) {
            return;
        }
        bdTypeListView.getAdapter2().notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            BdTypeListView bdTypeListView = this.e;
            if (bdTypeListView != null) {
                bdTypeListView.smoothScrollToPosition(0);
                this.e.F();
            }
        }
    }
}
