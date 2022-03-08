package com.baidu.tieba.frs.ad;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.o.e.n;
import c.a.d.o.e.v;
import c.a.r0.d1.q0;
import c.a.r0.d1.s;
import c.a.r0.d1.s0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsADFragment extends BaseFragment implements q0, BdListView.p, s0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRS_TAB_AD_RN = 20;
    public static final int FRS_TAB_DEFAULT_REFRESH = 0;
    public static final int FRS_TAB_DOWN_REFRESH = 2;
    public static final int FRS_TAB_UP_REFRESH = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.d1.i1.e adView;

    /* renamed from: e  reason: collision with root package name */
    public ADRequestModel.b f41853e;

    /* renamed from: f  reason: collision with root package name */
    public ADRequestModel f41854f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f41855g;

    /* renamed from: h  reason: collision with root package name */
    public String f41856h;

    /* renamed from: i  reason: collision with root package name */
    public long f41857i;

    /* renamed from: j  reason: collision with root package name */
    public int f41858j;
    public c.a.r0.d1.i1.a k;
    public boolean l;
    public List<c.a.r0.d1.i1.c> m;
    public ArrayList<n> n;
    public c.a.q0.f0.c o;
    public int p;
    public int q;
    public CustomMessageListener r;
    public int refreshType;
    public final RecyclerView.OnScrollListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public v v;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsADFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsADFragment frsADFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsADFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.a.o == null || !this.a.o.isViewAttached()) {
                return;
            }
            this.a.o.a(num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ADRequestModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsADFragment a;

        public b(FrsADFragment frsADFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsADFragment;
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void a(ADSocketResponseMessage aDSocketResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDSocketResponseMessage) == null) || aDSocketResponseMessage == null || this.a.adView == null) {
                return;
            }
            if (aDSocketResponseMessage.getError() == 0) {
                this.a.f41858j = (int) aDSocketResponseMessage.getOffset();
                this.a.m = aDSocketResponseMessage.getList();
                this.a.l = aDSocketResponseMessage.getHas_more() == 1;
                this.a.refreshPage();
                return;
            }
            this.a.showNetRefreshView();
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDHttpResponseMessage) == null) || aDHttpResponseMessage == null || this.a.adView == null) {
                return;
            }
            if (aDHttpResponseMessage.getError() == 0) {
                this.a.f41858j = (int) aDHttpResponseMessage.getOffset();
                this.a.m = aDHttpResponseMessage.getList();
                this.a.l = aDHttpResponseMessage.getHas_more() == 1;
                this.a.refreshPage();
                return;
            }
            this.a.showNetRefreshView();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsADFragment a;

        public c(FrsADFragment frsADFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsADFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                this.a.q += i3;
                if (this.a.q < this.a.p * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsADFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsADFragment frsADFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment, Integer.valueOf(i2)};
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
            this.a = frsADFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (this.a.getListView() != null) {
                    this.a.getListView().setSelection(0);
                }
                if (this.a.o != null && this.a.o.isViewAttached()) {
                    this.a.t(0);
                    return;
                }
                c.a.r0.d1.i1.e eVar = this.a.adView;
                if (eVar != null) {
                    eVar.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsADFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsADFragment frsADFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment, Integer.valueOf(i2)};
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
            this.a = frsADFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (this.a.getListView() != null) {
                    this.a.getListView().setSelection(0);
                }
                if (this.a.o != null && this.a.o.isViewAttached()) {
                    this.a.t(0);
                    this.a.showLoadingView();
                    return;
                }
                c.a.r0.d1.i1.e eVar = this.a.adView;
                if (eVar != null) {
                    eVar.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f41859e;

        public f(FrsADFragment frsADFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41859e = frsADFragment;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            c.a.r0.d1.i1.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || nVar == null || !(nVar instanceof c.a.r0.d1.i1.c) || (cVar = (c.a.r0.d1.i1.c) nVar) == null || cVar.o() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
            UrlManager.getInstance().dealOneLink(this.f41859e.f41855g, new String[]{c.a.q0.l.a.c(cVar.o(), arrayList)});
            if (m.isEmpty(cVar.i())) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", cVar.i()).param("fid", this.f41859e.f41857i));
        }
    }

    public FrsADFragment() {
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
        this.adView = null;
        this.f41858j = 0;
        this.refreshType = 0;
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = 0;
        this.r = new a(this, 2921397, true);
        this.s = new c(this);
        this.t = new d(this, 2001625);
        this.u = new e(this, 2001624);
        this.v = new f(this);
    }

    @Override // c.a.r0.d1.q0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    @Override // c.a.r0.d1.q0
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.adView == null) {
            return;
        }
        scrollToTop();
        this.adView.p();
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41856h : (String) invokeV.objValue;
    }

    public BdTypeRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.d1.i1.e eVar = this.adView;
            if (eVar == null) {
                return null;
            }
            return eVar.a();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = 90;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.adView.k(true);
            hideLoadingView(this.adView.b());
        }
    }

    public final void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.adView.k(true);
            this.adView.m(true);
            c.a.q0.f0.c cVar = this.o;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.o.dettachView(this.adView.b());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.d1.i1.e eVar = this.adView;
            if (eVar != null) {
                eVar.g(i2);
            }
            c.a.q0.f0.c cVar = this.o;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.o.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            this.f41855g = getPageContext();
            s(bundle);
            registerListener(this.t);
            registerListener(this.u);
            registerListener(this.r);
            if (this.f41854f == null) {
                this.f41854f = new ADRequestModel(this.f41855g);
            }
            this.p = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
            c.a.r0.d1.i1.e eVar = new c.a.r0.d1.i1.e(this, inflate);
            this.adView = eVar;
            eVar.l(this.s);
            c.a.r0.d1.i1.a aVar = new c.a.r0.d1.i1.a(this, this.adView.a());
            this.k = aVar;
            aVar.f(this.v);
            if (this.f41853e == null) {
                this.f41853e = new b(this);
            }
            if (this.f41854f == null) {
                this.f41854f = new ADRequestModel(this.f41855g);
            }
            this.f41854f.y(this.f41853e);
            if (!l.z()) {
                showNetRefreshView();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            c.a.r0.d1.i1.e eVar = this.adView;
            if (eVar != null) {
                eVar.h();
            }
            ADRequestModel aDRequestModel = this.f41854f;
            if (aDRequestModel != null) {
                aDRequestModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLazyLoad();
            if (l.z()) {
                t(0);
                showLoadingView();
                return;
            }
            showNetRefreshView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f41857i).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // c.a.r0.d1.s0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && l.z()) {
            t(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPrimary();
        }
    }

    @Override // c.a.r0.d1.s0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.adView == null) {
            return;
        }
        if (l.z()) {
            t(2);
            if (ListUtils.isEmpty(this.n)) {
                showLoadingView();
                return;
            }
            return;
        }
        this.adView.j(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        c.a.r0.d1.i1.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (eVar = this.adView) == null) {
            return;
        }
        if (eVar != null && eVar.a() != null) {
            this.adView.a().stopScroll();
        }
        v();
        if (c.a.d.f.p.n.C() && this.l) {
            t(1);
        }
    }

    public final void refreshPage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.adView == null) {
            return;
        }
        hideLoadingView();
        this.adView.i();
        int i2 = this.refreshType;
        if (i2 == 0) {
            if (!ListUtils.isEmpty(this.m)) {
                u(true, false);
                this.adView.o();
                return;
            }
            showEmptyView();
        } else if (i2 == 2) {
            this.adView.j(false);
            if (!ListUtils.isEmpty(this.m)) {
                u(true, false);
                this.adView.o();
                return;
            }
            showEmptyView();
        } else if (i2 == 1) {
            if (!ListUtils.isEmpty(this.m)) {
                u(false, true);
            } else {
                this.adView.o();
            }
        }
    }

    public final void s(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            if (bundle != null) {
                bundle.getString("name");
                this.f41856h = bundle.getString("from");
                this.f41857i = c.a.d.f.m.b.g(bundle.getString("forum_id"), 0L);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("name");
                this.f41856h = arguments.getString("from");
                this.f41857i = c.a.d.f.m.b.g(arguments.getString("forum_id"), 0L);
            }
        }
    }

    @Override // c.a.r0.d1.q0
    public void scrollToTop() {
        c.a.r0.d1.i1.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (eVar = this.adView) == null || eVar.a() == null) {
            return;
        }
        this.adView.a().scrollToPosition(0);
    }

    public final void showEmptyView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.n == null || this.adView == null) {
            return;
        }
        this.n.add(new s());
        this.adView.c().d(this.n);
        this.adView.c().b();
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.adView.k(false);
            showLoadingView(this.adView.b(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
        }
    }

    public final void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.adView.k(false);
            this.adView.m(false);
            this.adView.d();
            this.adView.a().getData().clear();
            this.adView.f();
            if (this.o == null) {
                c.a.q0.f0.c cVar = new c.a.q0.f0.c(getPageContext().getContext(), getNetRefreshListener());
                this.o = cVar;
                cVar.e(null);
                this.o.d(null);
                this.o.c(null);
                this.o.f();
                this.o.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.o.onChangeSkinType();
            this.o.attachView(this.adView.b(), true);
            this.o.a(0);
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || this.f41854f == null) {
            return;
        }
        hideNetRefreshView();
        this.refreshType = i2;
        if (i2 == 0 || i2 == 2) {
            this.f41854f.x(this.f41857i, 0, 20);
        } else if (i2 == 1) {
            this.f41854f.x(this.f41857i, this.f41858j, 20);
        }
    }

    public final void u(boolean z, boolean z2) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (arrayList = this.n) == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                n nVar = (n) ListUtils.getItem(this.n, i2);
                if (nVar instanceof c.a.r0.d1.i1.c) {
                    ((c.a.r0.d1.i1.c) nVar).x(false);
                }
            }
        }
        this.n.addAll(this.m);
        AbsGroupUbsABTest.setCardInfoUbsABTest(this.n);
        this.adView.c().d(this.n);
        this.adView.c().b();
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!this.l) {
                if (ListUtils.isEmpty(this.m)) {
                    this.adView.d();
                    return;
                } else {
                    this.adView.o();
                    return;
                }
            }
            this.adView.n();
        }
    }
}
