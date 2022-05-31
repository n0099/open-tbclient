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
import com.repackage.ft4;
import com.repackage.gt4;
import com.repackage.hp5;
import com.repackage.ip5;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.jp5;
import com.repackage.li;
import com.repackage.rp5;
import com.repackage.t35;
import com.repackage.tn;
import com.repackage.wm;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View d;
    public BdTypeRecyclerView e;
    public BdSwipeRefreshLayout f;
    public PbListView g;
    public gt4 h;
    public t35 i;
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
    public final ft4.g t;

    /* loaded from: classes3.dex */
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
            this.a.a1();
        }
    }

    /* loaded from: classes3.dex */
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
                concernTabFragment.hideLoadingView(concernTabFragment.d);
                this.a.X0();
                this.a.d1();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void b(List<jn> list, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.l = z;
                this.a.n = true;
                this.a.b1(false);
                ConcernTabFragment concernTabFragment = this.a;
                concernTabFragment.hideLoadingView(concernTabFragment.d);
                if (ListUtils.getCount(list) == 0) {
                    this.a.d1();
                } else {
                    this.a.e.setData(list);
                    if (!this.a.l) {
                        this.a.e1();
                    } else {
                        this.a.c1();
                    }
                    this.a.Y0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (!li.D()) {
                    this.a.X0();
                } else if (this.a.l) {
                    this.a.k.D();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ft4.g {
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

        @Override // com.repackage.ft4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (ji.z()) {
                    this.a.k.E();
                } else {
                    this.a.b1(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hp5 a;
        public ip5 b;
        public jp5 c;
        public List<wm> d;
        public final /* synthetic */ ConcernTabFragment e;

        /* loaded from: classes3.dex */
        public class a implements tn {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ConcernTabFragment a;
            public final /* synthetic */ e b;

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
                this.b = eVar;
                this.a = concernTabFragment;
            }

            @Override // com.repackage.tn
            public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && jnVar != null && (jnVar instanceof rp5)) {
                    rp5 rp5Var = (rp5) jnVar;
                    if (rp5Var.b == null) {
                        return;
                    }
                    if (!li.D()) {
                        this.b.e.getPageContext().showToast((int) R.string.obfuscated_res_0x7f0f0c33);
                        return;
                    }
                    if (rp5Var.c) {
                        TiebaStatic.log(new StatisticItem("c12896"));
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12894");
                        statisticItem.addParam("fid", this.b.e.o);
                        statisticItem.addParam("fname", this.b.e.p);
                        if (rp5Var.b.isLegalYYLiveData()) {
                            AlaInfoData alaInfoData = rp5Var.b;
                            int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData);
                            String str = StringUtils.isNull(alaInfoData.appId) ? null : alaInfoData.appId;
                            if (alaInfoData.mYyExtData != null) {
                                str = TiebaStatic.YYValues.YY_LIVE;
                            }
                            statisticItem.addParam("obj_param1", calculateLiveType);
                            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
                            YYLiveUtil.calculateLiveType(rp5Var.b);
                            TiebaStaticHelper.addYYParam(statisticItem, rp5Var.b.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                    }
                    if (rp5Var.b.isLegalYYLiveData()) {
                        TbPageContext<BaseFragmentActivity> pageContext = this.b.e.getPageContext();
                        YyExtData yyExtData = rp5Var.b.mYyExtData;
                        String str2 = yyExtData.mSid;
                        String str3 = yyExtData.mSsid;
                        String str4 = yyExtData.mTemplateId;
                        YYLiveUtil.jumpToYYLiveRoom(pageContext, str2, str3, str4, "" + rp5Var.b.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_FOLLOW_HEAD);
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
            this.e = concernTabFragment;
            this.d = new LinkedList();
            this.a = new hp5(concernTabFragment.getPageContext());
            ip5 ip5Var = new ip5(concernTabFragment.getPageContext());
            this.b = ip5Var;
            ip5Var.b0(concernTabFragment.o);
            this.b.a(concernTabFragment.p);
            this.c = new jp5(concernTabFragment.getPageContext());
            this.b.V(new a(this, concernTabFragment));
            this.d.add(this.a);
            this.d.add(this.b);
            this.d.add(this.c);
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

    public static ConcernTabFragment Z0(int i, String str, String str2) {
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
    public void G0() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdTypeRecyclerView = this.e) == null) {
            return;
        }
        bdTypeRecyclerView.getAdapter().notifyDataSetChanged();
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.setNextPage(null);
        }
    }

    public final void Y0() {
        t35 t35Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView != null && (t35Var = this.i) != null) {
                bdTypeRecyclerView.removeHeaderView(t35Var.b());
            }
            this.m = false;
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.E();
            showLoadingView(this.d, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070283));
        }
    }

    public void b1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || z) {
            return;
        }
        this.f.setRefreshing(false);
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.setNextPage(this.g);
            this.g.Q();
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.i == null) {
                t35 t35Var = new t35(getPageContext().getContext(), getNetRefreshListener());
                this.i = t35Var;
                t35Var.n(null);
                this.i.g(null);
                this.i.p();
                this.i.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.i.m(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f11e7));
            this.i.onChangeSkinType();
            if (!this.m) {
                this.e.t(this.i.b(), 0);
            }
            this.m = true;
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.setNextPage(this.g);
            this.g.C(getResources().getString(R.string.obfuscated_res_0x7f0f0a18));
            this.g.f();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.o();
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.scrollToPosition(0);
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            gt4 gt4Var = this.h;
            if (gt4Var != null) {
                gt4Var.H(i);
            }
            PbListView pbListView = this.g;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.g.d(i);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.d == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d076d, viewGroup, false);
                this.d = inflate;
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f0906ce);
                this.e = bdTypeRecyclerView;
                bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                this.e.setFadingEdgeLength(0);
                this.e.setOverScrollMode(2);
                this.e.setOnSrollToBottomListener(this.s);
                gt4 gt4Var = new gt4(getPageContext());
                this.h = gt4Var;
                gt4Var.e(this.t);
                PbListView pbListView = new PbListView(getContext());
                this.g = pbListView;
                pbListView.a();
                this.g.p(R.color.CAM_X0201);
                this.g.t(li.f(getContext(), R.dimen.tbds182));
                this.g.x();
                this.g.G(R.dimen.tbfontsize33);
                this.g.E(SkinManager.getColor(R.color.CAM_X0107));
                this.g.A(R.color.CAM_X0110);
                this.g.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09195f);
                this.f = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.h);
                e eVar = new e(this);
                this.j = eVar;
                this.e.a(eVar.d);
            }
            if (this.d.getParent() != null) {
                ((ViewGroup) this.d.getParent()).removeView(this.d);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (TbadkCoreApplication.isLogin()) {
                a1();
            }
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.e.setOnSrollToBottomListener(null);
            this.e.setScrollable(null);
            this.k.onDestroy();
            hideLoadingView(this.d);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onNetRefreshButtonClicked();
            a1();
        }
    }
}
