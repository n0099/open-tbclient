package com.baidu.tieba.frs.ad;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.j;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.e.m.e.w;
import b.a.r0.x0.d1;
import b.a.r0.x0.g1;
import b.a.r0.x0.q0;
import b.a.r0.x0.s;
import b.a.r0.x0.s0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
/* loaded from: classes9.dex */
public class FrsADFragment extends BaseFragment implements q0, BdListView.p, s0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRS_TAB_AD_RN = 20;
    public static final int FRS_TAB_DEFAULT_REFRESH = 0;
    public static final int FRS_TAB_DOWN_REFRESH = 2;
    public static final int FRS_TAB_UP_REFRESH = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.x0.r1.e adView;

    /* renamed from: e  reason: collision with root package name */
    public ADRequestModel.b f49226e;

    /* renamed from: f  reason: collision with root package name */
    public ADRequestModel f49227f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f49228g;

    /* renamed from: h  reason: collision with root package name */
    public String f49229h;

    /* renamed from: i  reason: collision with root package name */
    public long f49230i;
    public int j;
    public b.a.r0.x0.r1.a k;
    public boolean l;
    public List<b.a.r0.x0.r1.c> m;
    public ArrayList<n> n;
    public b.a.q0.g0.c o;
    public int p;
    public int q;
    public CustomMessageListener r;
    public int refreshType;
    public final RecyclerView.OnScrollListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public w v;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f49231a;

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
            this.f49231a = frsADFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f49231a.o == null || !this.f49231a.o.isViewAttached()) {
                return;
            }
            this.f49231a.o.a(num.intValue());
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ADRequestModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f49232a;

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
            this.f49232a = frsADFragment;
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void a(ADSocketResponseMessage aDSocketResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDSocketResponseMessage) == null) || aDSocketResponseMessage == null || this.f49232a.adView == null) {
                return;
            }
            if (aDSocketResponseMessage.getError() == 0) {
                this.f49232a.j = (int) aDSocketResponseMessage.getOffset();
                this.f49232a.m = aDSocketResponseMessage.getList();
                this.f49232a.l = aDSocketResponseMessage.getHas_more() == 1;
                this.f49232a.refreshPage();
                return;
            }
            this.f49232a.showNetRefreshView();
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDHttpResponseMessage) == null) || aDHttpResponseMessage == null || this.f49232a.adView == null) {
                return;
            }
            if (aDHttpResponseMessage.getError() == 0) {
                this.f49232a.j = (int) aDHttpResponseMessage.getOffset();
                this.f49232a.m = aDHttpResponseMessage.getList();
                this.f49232a.l = aDHttpResponseMessage.getHas_more() == 1;
                this.f49232a.refreshPage();
                return;
            }
            this.f49232a.showNetRefreshView();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f49233a;

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
            this.f49233a = frsADFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                this.f49233a.q += i3;
                if (this.f49233a.q < this.f49233a.p * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f49234a;

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
            this.f49234a = frsADFragment;
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
                if (this.f49234a.getListView() != null) {
                    this.f49234a.getListView().setSelection(0);
                }
                if (this.f49234a.o != null && this.f49234a.o.isViewAttached()) {
                    this.f49234a.o(0);
                    return;
                }
                b.a.r0.x0.r1.e eVar = this.f49234a.adView;
                if (eVar != null) {
                    eVar.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f49235a;

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
            this.f49235a = frsADFragment;
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
                if (this.f49235a.getListView() != null) {
                    this.f49235a.getListView().setSelection(0);
                }
                if (this.f49235a.o != null && this.f49235a.o.isViewAttached()) {
                    this.f49235a.o(0);
                    this.f49235a.showLoadingView();
                    return;
                }
                b.a.r0.x0.r1.e eVar = this.f49235a.adView;
                if (eVar != null) {
                    eVar.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f49236e;

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
            this.f49236e = frsADFragment;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            b.a.r0.x0.r1.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || nVar == null || !(nVar instanceof b.a.r0.x0.r1.c) || (cVar = (b.a.r0.x0.r1.c) nVar) == null || cVar.o() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
            UrlManager.getInstance().dealOneLink(this.f49236e.f49228g, new String[]{b.a.q0.m.a.c(cVar.o(), arrayList)});
            if (k.isEmpty(cVar.i())) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", cVar.i()).param("fid", this.f49236e.f49230i));
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
        this.j = 0;
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

    @Override // b.a.r0.x0.q0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    @Override // b.a.r0.x0.q0
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49229h : (String) invokeV.objValue;
    }

    public BdTypeRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.r0.x0.r1.e eVar = this.adView;
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
            b.a.q0.g0.c cVar = this.o;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.o.dettachView(this.adView.b());
        }
    }

    public final void n(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            if (bundle != null) {
                bundle.getString("name");
                this.f49229h = bundle.getString("from");
                this.f49230i = b.a.e.f.m.b.g(bundle.getString("forum_id"), 0L);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("name");
                this.f49229h = arguments.getString("from");
                this.f49230i = b.a.e.f.m.b.g(arguments.getString("forum_id"), 0L);
            }
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f49227f == null) {
            return;
        }
        hideNetRefreshView();
        this.refreshType = i2;
        if (i2 == 0 || i2 == 2) {
            this.f49227f.x(this.f49230i, 0, 20);
        } else if (i2 == 1) {
            this.f49227f.x(this.f49230i, this.j, 20);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.r0.x0.r1.e eVar = this.adView;
            if (eVar != null) {
                eVar.g(i2);
            }
            b.a.q0.g0.c cVar = this.o;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.o.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            this.f49228g = getPageContext();
            n(bundle);
            registerListener(this.t);
            registerListener(this.u);
            registerListener(this.r);
            if (this.f49227f == null) {
                this.f49227f = new ADRequestModel(this.f49228g);
            }
            this.p = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(g1.frs_ad_fragment, (ViewGroup) null);
            b.a.r0.x0.r1.e eVar = new b.a.r0.x0.r1.e(this, inflate);
            this.adView = eVar;
            eVar.l(this.s);
            b.a.r0.x0.r1.a aVar = new b.a.r0.x0.r1.a(this, this.adView.a());
            this.k = aVar;
            aVar.f(this.v);
            if (this.f49226e == null) {
                this.f49226e = new b(this);
            }
            if (this.f49227f == null) {
                this.f49227f = new ADRequestModel(this.f49228g);
            }
            this.f49227f.y(this.f49226e);
            if (!j.z()) {
                showNetRefreshView();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            b.a.r0.x0.r1.e eVar = this.adView;
            if (eVar != null) {
                eVar.h();
            }
            ADRequestModel aDRequestModel = this.f49227f;
            if (aDRequestModel != null) {
                aDRequestModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onLazyLoad();
            if (j.z()) {
                o(0);
                showLoadingView();
                return;
            }
            showNetRefreshView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f49230i).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // b.a.r0.x0.s0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && j.z()) {
            o(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
        }
    }

    @Override // b.a.r0.x0.s0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.adView == null) {
            return;
        }
        if (j.z()) {
            o(2);
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
        b.a.r0.x0.r1.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (eVar = this.adView) == null) {
            return;
        }
        if (eVar != null && eVar.a() != null) {
            this.adView.a().stopScroll();
        }
        q();
        if (l.D() && this.l) {
            o(1);
        }
    }

    public final void p(boolean z, boolean z2) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (arrayList = this.n) == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                n nVar = (n) ListUtils.getItem(this.n, i2);
                if (nVar instanceof b.a.r0.x0.r1.c) {
                    ((b.a.r0.x0.r1.c) nVar).x(false);
                }
            }
        }
        this.n.addAll(this.m);
        b.a.q0.b.f.a.d(this.n);
        this.adView.c().d(this.n);
        this.adView.c().b();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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

    public final void refreshPage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.adView == null) {
            return;
        }
        hideLoadingView();
        this.adView.i();
        int i2 = this.refreshType;
        if (i2 == 0) {
            if (!ListUtils.isEmpty(this.m)) {
                p(true, false);
                this.adView.o();
                return;
            }
            showEmptyView();
        } else if (i2 == 2) {
            this.adView.j(false);
            if (!ListUtils.isEmpty(this.m)) {
                p(true, false);
                this.adView.o();
                return;
            }
            showEmptyView();
        } else if (i2 == 1) {
            if (!ListUtils.isEmpty(this.m)) {
                p(false, true);
            } else {
                this.adView.o();
            }
        }
    }

    @Override // b.a.r0.x0.q0
    public void scrollToTop() {
        b.a.r0.x0.r1.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (eVar = this.adView) == null || eVar.a() == null) {
            return;
        }
        this.adView.a().scrollToPosition(0);
    }

    public final void showEmptyView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.n == null || this.adView == null) {
            return;
        }
        this.n.add(new s());
        this.adView.c().d(this.n);
        this.adView.c().b();
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.adView.k(false);
            showLoadingView(this.adView.b(), true, getResources().getDimensionPixelSize(d1.ds250));
        }
    }

    public final void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.adView.k(false);
            this.adView.m(false);
            this.adView.d();
            this.adView.a().getData().clear();
            this.adView.f();
            if (this.o == null) {
                b.a.q0.g0.c cVar = new b.a.q0.g0.c(getPageContext().getContext(), getNetRefreshListener());
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
}
