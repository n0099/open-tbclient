package com.baidu.tieba.frs.ad;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.BrowserHelper;
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
import com.baidu.tieba.cn;
import com.baidu.tieba.ei;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.mn;
import com.baidu.tieba.ni7;
import com.baidu.tieba.nj7;
import com.baidu.tieba.nk7;
import com.baidu.tieba.pj7;
import com.baidu.tieba.pk7;
import com.baidu.tieba.rk7;
import com.baidu.tieba.sn5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsADFragment extends BaseFragment implements nj7, BdListView.p, pj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rk7 a;
    public ADRequestModel.b b;
    public ADRequestModel c;
    public TbPageContext d;
    public long e;
    public int f;
    public int g;
    public nk7 h;
    public boolean i;
    public List<pk7> j;
    public ArrayList<cn> k;
    public sn5 l;
    public int m;
    public int n;
    public CustomMessageListener o;
    public final RecyclerView.OnScrollListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public mn s;

    @Override // com.baidu.tieba.pj7
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.tieba.nj7
    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsADFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsADFragment frsADFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && this.a.l != null && this.a.l.isViewAttached()) {
                this.a.l.a(num.intValue());
            }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, aDSocketResponseMessage) == null) && aDSocketResponseMessage != null && this.a.a != null) {
                if (aDSocketResponseMessage.getError() != 0) {
                    this.a.r2();
                    return;
                }
                this.a.f = (int) aDSocketResponseMessage.getOffset();
                this.a.j = aDSocketResponseMessage.getList();
                FrsADFragment frsADFragment = this.a;
                boolean z = true;
                if (aDSocketResponseMessage.getHas_more() != 1) {
                    z = false;
                }
                frsADFragment.i = z;
                this.a.F();
            }
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDHttpResponseMessage) == null) && aDHttpResponseMessage != null && this.a.a != null) {
                if (aDHttpResponseMessage.getError() != 0) {
                    this.a.r2();
                    return;
                }
                this.a.f = (int) aDHttpResponseMessage.getOffset();
                this.a.j = aDHttpResponseMessage.getList();
                FrsADFragment frsADFragment = this.a;
                boolean z = true;
                if (aDHttpResponseMessage.getHas_more() != 1) {
                    z = false;
                }
                frsADFragment.i = z;
                this.a.F();
            }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsADFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                FrsADFragment.f2(this.a, i2);
                if (i2 < 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    if (this.a.n >= this.a.m * 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.valueOf(z)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsADFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsADFragment frsADFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment, Integer.valueOf(i)};
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
            this.a = frsADFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (this.a.j2() != null) {
                    this.a.j2().setSelection(0);
                }
                if (this.a.l == null || !this.a.l.isViewAttached()) {
                    rk7 rk7Var = this.a.a;
                    if (rk7Var != null) {
                        rk7Var.p();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.m2(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsADFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsADFragment frsADFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment, Integer.valueOf(i)};
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
            this.a = frsADFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (this.a.j2() != null) {
                    this.a.j2().setSelection(0);
                }
                if (this.a.l == null || !this.a.l.isViewAttached()) {
                    rk7 rk7Var = this.a.a;
                    if (rk7Var != null) {
                        rk7Var.p();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.m2(0);
                this.a.q2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsADFragment a;

        public f(FrsADFragment frsADFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsADFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsADFragment;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            pk7 pk7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && cnVar != null && (cnVar instanceof pk7) && (pk7Var = (pk7) cnVar) != null && pk7Var.f() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
                UrlManager.getInstance().dealOneLink(this.a.d, new String[]{BrowserHelper.appendParams(pk7Var.f(), arrayList)});
                if (!ei.isEmpty(pk7Var.d())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", pk7Var.d()).param("fid", this.a.e));
                }
            }
        }
    }

    public FrsADFragment() {
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
        this.a = null;
        this.f = 0;
        this.g = 0;
        this.k = new ArrayList<>();
        this.m = 0;
        this.n = 0;
        this.o = new a(this, 2921397, true);
        this.p = new c(this);
        this.q = new d(this, 2001625);
        this.r = new e(this, 2001624);
        this.s = new f(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.onChangeSkinType(i);
            rk7 rk7Var = this.a;
            if (rk7Var != null) {
                rk7Var.g(i);
            }
            sn5 sn5Var = this.l;
            if (sn5Var != null && sn5Var.isViewAttached()) {
                this.l.onChangeSkinType();
            }
        }
    }

    public static /* synthetic */ int f2(FrsADFragment frsADFragment, int i) {
        int i2 = frsADFragment.n + i;
        frsADFragment.n = i2;
        return i2;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a == null) {
            return;
        }
        hideLoadingView();
        this.a.i();
        int i = this.g;
        if (i == 0) {
            if (!ListUtils.isEmpty(this.j)) {
                o2(true, false);
                this.a.o();
                return;
            }
            n2();
        } else if (i == 2) {
            this.a.j(false);
            if (!ListUtils.isEmpty(this.j)) {
                o2(true, false);
                this.a.o();
                return;
            }
            n2();
        } else if (i == 1) {
            if (!ListUtils.isEmpty(this.j)) {
                o2(false, true);
            } else {
                this.a.o();
            }
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.a.k(false);
            this.a.m(false);
            this.a.d();
            this.a.a().getData().clear();
            this.a.f();
            if (this.l == null) {
                sn5 sn5Var = new sn5(getPageContext().getContext(), getNetRefreshListener());
                this.l = sn5Var;
                sn5Var.d(null);
                this.l.c(null);
                this.l.b(null);
                this.l.e();
                this.l.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.l.onChangeSkinType();
            this.l.attachView(this.a.b(), true);
            this.l.a(0);
        }
    }

    @Override // com.baidu.tieba.nj7
    public void S1() {
        rk7 rk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (rk7Var = this.a) != null && rk7Var.a() != null) {
            this.a.a().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = 90;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nj7
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a != null) {
            S1();
            this.a.p();
        }
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.k(true);
            hideLoadingView(this.a.b());
        }
    }

    public BdTypeRecyclerView j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            rk7 rk7Var = this.a;
            if (rk7Var == null) {
                return null;
            }
            return rk7Var.a();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.k(true);
            this.a.m(true);
            sn5 sn5Var = this.l;
            if (sn5Var != null && sn5Var.isViewAttached()) {
                this.l.dettachView(this.a.b());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
            rk7 rk7Var = this.a;
            if (rk7Var != null) {
                rk7Var.h();
            }
            ADRequestModel aDRequestModel = this.c;
            if (aDRequestModel != null) {
                aDRequestModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onLazyLoad();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                m2(0);
                q2();
                return;
            }
            r2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            m2(0);
            q2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!this.i) {
                if (ListUtils.isEmpty(this.j)) {
                    this.a.d();
                    return;
                } else {
                    this.a.o();
                    return;
                }
            }
            this.a.n();
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.a.k(false);
            showLoadingView(this.a.b(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703aa));
        }
    }

    @Override // com.baidu.tieba.pj7
    public void w1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || this.a == null) {
            return;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            m2(2);
            if (ListUtils.isEmpty(this.k)) {
                q2();
                return;
            }
            return;
        }
        this.a.j(false);
    }

    public final void l2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            if (bundle != null) {
                bundle.getString("name");
                bundle.getString("from");
                this.e = JavaTypesHelper.toLong(bundle.getString("forum_id"), 0L);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("name");
                arguments.getString("from");
                this.e = JavaTypesHelper.toLong(arguments.getString("forum_id"), 0L);
            }
        }
    }

    public final void m2(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || this.c == null) {
            return;
        }
        k2();
        this.g = i;
        if (i != 0 && i != 2) {
            if (i == 1) {
                this.c.N(this.e, this.f, 20);
                return;
            }
            return;
        }
        this.c.N(this.e, 0, 20);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            this.d = getPageContext();
            l2(bundle);
            registerListener(this.q);
            registerListener(this.r);
            registerListener(this.o);
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.m = UtilHelper.getScreenHeight(getActivity());
        }
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.k != null && this.a != null) {
            this.k.add(new ni7());
            this.a.c().d(this.k);
            this.a.c().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.e).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        rk7 rk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (rk7Var = this.a) == null) {
            return;
        }
        if (rk7Var != null && rk7Var.a() != null) {
            this.a.a().stopScroll();
        }
        p2();
        if (BdUtilHelper.isNetOk() && this.i) {
            m2(1);
        }
    }

    public final void o2(boolean z, boolean z2) {
        ArrayList<cn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || (arrayList = this.k) == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i = 0; i < this.k.size(); i++) {
                cn cnVar = (cn) ListUtils.getItem(this.k, i);
                if (cnVar instanceof pk7) {
                    ((pk7) cnVar).m(false);
                }
            }
        }
        this.k.addAll(this.j);
        AbsGroupUbsABTest.setCardInfoUbsABTest(this.k);
        this.a.c().d(this.k);
        this.a.c().b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d034a, (ViewGroup) null);
            rk7 rk7Var = new rk7(this, inflate);
            this.a = rk7Var;
            rk7Var.l(this.p);
            nk7 nk7Var = new nk7(this, this.a.a());
            this.h = nk7Var;
            nk7Var.f(this.s);
            if (this.b == null) {
                this.b = new b(this);
            }
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.c.O(this.b);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                r2();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
