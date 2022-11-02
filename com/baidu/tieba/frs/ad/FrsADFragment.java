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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.bk6;
import com.baidu.tieba.bl6;
import com.baidu.tieba.cj6;
import com.baidu.tieba.dk6;
import com.baidu.tieba.dl6;
import com.baidu.tieba.fl6;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.go;
import com.baidu.tieba.rp4;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.wn;
import com.baidu.tieba.xi;
import com.baidu.tieba.y95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsADFragment extends BaseFragment implements bk6, BdListView.p, dk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fl6 a;
    public ADRequestModel.b b;
    public ADRequestModel c;
    public TbPageContext d;
    public long e;
    public int f;
    public int g;
    public bl6 h;
    public boolean i;
    public List<dl6> j;
    public ArrayList<wn> k;
    public y95 l;
    public int m;
    public int n;
    public CustomMessageListener o;
    public final RecyclerView.OnScrollListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public go s;

    @Override // com.baidu.tieba.dk6
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.tieba.bk6
    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                if (aDSocketResponseMessage.getError() == 0) {
                    this.a.f = (int) aDSocketResponseMessage.getOffset();
                    this.a.j = aDSocketResponseMessage.getList();
                    FrsADFragment frsADFragment = this.a;
                    boolean z = true;
                    if (aDSocketResponseMessage.getHas_more() != 1) {
                        z = false;
                    }
                    frsADFragment.i = z;
                    this.a.t();
                    return;
                }
                this.a.M1();
            }
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDHttpResponseMessage) == null) && aDHttpResponseMessage != null && this.a.a != null) {
                if (aDHttpResponseMessage.getError() == 0) {
                    this.a.f = (int) aDHttpResponseMessage.getOffset();
                    this.a.j = aDHttpResponseMessage.getList();
                    FrsADFragment frsADFragment = this.a;
                    boolean z = true;
                    if (aDHttpResponseMessage.getHas_more() != 1) {
                        z = false;
                    }
                    frsADFragment.i = z;
                    this.a.t();
                    return;
                }
                this.a.M1();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                this.a.n += i2;
                if (this.a.n >= this.a.m * 2 && i2 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.E1() != null) {
                    this.a.E1().setSelection(0);
                }
                if (this.a.l != null && this.a.l.isViewAttached()) {
                    this.a.H1(0);
                    return;
                }
                fl6 fl6Var = this.a.a;
                if (fl6Var != null) {
                    fl6Var.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.E1() != null) {
                    this.a.E1().setSelection(0);
                }
                if (this.a.l != null && this.a.l.isViewAttached()) {
                    this.a.H1(0);
                    this.a.L1();
                    return;
                }
                fl6 fl6Var = this.a.a;
                if (fl6Var != null) {
                    fl6Var.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements go {
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

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            dl6 dl6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && wnVar != null && (wnVar instanceof dl6) && (dl6Var = (dl6) wnVar) != null && dl6Var.j() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
                UrlManager.getInstance().dealOneLink(this.a.d, new String[]{rp4.d(dl6Var.j(), arrayList)});
                if (!wi.isEmpty(dl6Var.f())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", dl6Var.f()).param("fid", this.a.e));
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
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.onChangeSkinType(i);
            fl6 fl6Var = this.a;
            if (fl6Var != null) {
                fl6Var.g(i);
            }
            y95 y95Var = this.l;
            if (y95Var != null && y95Var.isViewAttached()) {
                this.l.onChangeSkinType();
            }
        }
    }

    public BdTypeRecyclerView E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fl6 fl6Var = this.a;
            if (fl6Var == null) {
                return null;
            }
            return fl6Var.a();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.k(true);
            this.a.m(true);
            y95 y95Var = this.l;
            if (y95Var != null && y95Var.isViewAttached()) {
                this.l.dettachView(this.a.b());
            }
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.k(false);
            showLoadingView(this.a.b(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
        }
    }

    @Override // com.baidu.tieba.dk6
    public void U0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.a == null) {
            return;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            H1(2);
            if (ListUtils.isEmpty(this.k)) {
                L1();
                return;
            }
            return;
        }
        this.a.j(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = 90;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.k(true);
            hideLoadingView(this.a.b());
        }
    }

    @Override // com.baidu.tieba.bk6
    public void n1() {
        fl6 fl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (fl6Var = this.a) != null && fl6Var.a() != null) {
            this.a.a().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
            fl6 fl6Var = this.a;
            if (fl6Var != null) {
                fl6Var.h();
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
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onLazyLoad();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                H1(0);
                L1();
                return;
            }
            M1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            H1(0);
            L1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPrimary();
        }
    }

    @Override // com.baidu.tieba.bk6
    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.a != null) {
            n1();
            this.a.p();
        }
    }

    public final void G1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            if (bundle != null) {
                bundle.getString("name");
                bundle.getString("from");
                this.e = wg.g(bundle.getString("forum_id"), 0L);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("name");
                arguments.getString("from");
                this.e = wg.g(arguments.getString("forum_id"), 0L);
            }
        }
    }

    public final void H1(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.c == null) {
            return;
        }
        F1();
        this.g = i;
        if (i != 0 && i != 2) {
            if (i == 1) {
                this.c.A(this.e, this.f, 20);
                return;
            }
            return;
        }
        this.c.A(this.e, 0, 20);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            this.d = getPageContext();
            G1(bundle);
            registerListener(this.q);
            registerListener(this.r);
            registerListener(this.o);
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.m = UtilHelper.getScreenHeight(getActivity());
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.k != null && this.a != null) {
            this.k.add(new cj6());
            this.a.c().d(this.k);
            this.a.c().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.e).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        fl6 fl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (fl6Var = this.a) == null) {
            return;
        }
        if (fl6Var != null && fl6Var.a() != null) {
            this.a.a().stopScroll();
        }
        K1();
        if (xi.F() && this.i) {
            H1(1);
        }
    }

    public final void J1(boolean z, boolean z2) {
        ArrayList<wn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || (arrayList = this.k) == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i = 0; i < this.k.size(); i++) {
                wn wnVar = (wn) ListUtils.getItem(this.k, i);
                if (wnVar instanceof dl6) {
                    ((dl6) wnVar).t(false);
                }
            }
        }
        this.k.addAll(this.j);
        AbsGroupUbsABTest.setCardInfoUbsABTest(this.k);
        this.a.c().d(this.k);
        this.a.c().b();
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.k(false);
            this.a.m(false);
            this.a.d();
            this.a.a().getData().clear();
            this.a.f();
            if (this.l == null) {
                y95 y95Var = new y95(getPageContext().getContext(), getNetRefreshListener());
                this.l = y95Var;
                y95Var.e(null);
                this.l.d(null);
                this.l.c(null);
                this.l.f();
                this.l.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.l.onChangeSkinType();
            this.l.attachView(this.a.b(), true);
            this.l.a(0);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || this.a == null) {
            return;
        }
        m();
        this.a.i();
        int i = this.g;
        if (i == 0) {
            if (!ListUtils.isEmpty(this.j)) {
                J1(true, false);
                this.a.o();
                return;
            }
            I1();
        } else if (i == 2) {
            this.a.j(false);
            if (!ListUtils.isEmpty(this.j)) {
                J1(true, false);
                this.a.o();
                return;
            }
            I1();
        } else if (i == 1) {
            if (!ListUtils.isEmpty(this.j)) {
                J1(false, true);
            } else {
                this.a.o();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02f4, (ViewGroup) null);
            fl6 fl6Var = new fl6(this, inflate);
            this.a = fl6Var;
            fl6Var.l(this.p);
            bl6 bl6Var = new bl6(this, this.a.a());
            this.h = bl6Var;
            bl6Var.f(this.s);
            if (this.b == null) {
                this.b = new b(this);
            }
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.c.B(this.b);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                M1();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
