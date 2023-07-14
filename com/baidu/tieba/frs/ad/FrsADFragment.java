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
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.gi7;
import com.baidu.tieba.gj7;
import com.baidu.tieba.gk7;
import com.baidu.tieba.ij7;
import com.baidu.tieba.ik7;
import com.baidu.tieba.io;
import com.baidu.tieba.kk7;
import com.baidu.tieba.nx4;
import com.baidu.tieba.wg;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
import com.baidu.tieba.yn5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsADFragment extends BaseFragment implements gj7, BdListView.p, ij7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kk7 a;
    public ADRequestModel.b b;
    public ADRequestModel c;
    public TbPageContext d;
    public long e;
    public int f;
    public int g;
    public gk7 h;
    public boolean i;
    public List<ik7> j;
    public ArrayList<yn> k;
    public yn5 l;
    public int m;
    public int n;
    public CustomMessageListener o;
    public final RecyclerView.OnScrollListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public io s;

    @Override // com.baidu.tieba.ij7
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.tieba.gj7
    public void q0(boolean z) {
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
                    this.a.c2();
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
                this.a.B();
            }
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDHttpResponseMessage) == null) && aDHttpResponseMessage != null && this.a.a != null) {
                if (aDHttpResponseMessage.getError() != 0) {
                    this.a.c2();
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
                this.a.B();
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
                this.a.n += i2;
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
                if (this.a.U1() != null) {
                    this.a.U1().setSelection(0);
                }
                if (this.a.l == null || !this.a.l.isViewAttached()) {
                    kk7 kk7Var = this.a.a;
                    if (kk7Var != null) {
                        kk7Var.p();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.X1(0);
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
                if (this.a.U1() != null) {
                    this.a.U1().setSelection(0);
                }
                if (this.a.l == null || !this.a.l.isViewAttached()) {
                    kk7 kk7Var = this.a.a;
                    if (kk7Var != null) {
                        kk7Var.p();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.X1(0);
                this.a.b2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements io {
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

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            ik7 ik7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && ynVar != null && (ynVar instanceof ik7) && (ik7Var = (ik7) ynVar) != null && ik7Var.f() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
                UrlManager.getInstance().dealOneLink(this.a.d, new String[]{nx4.e(ik7Var.f(), arrayList)});
                if (!xi.isEmpty(ik7Var.d())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", ik7Var.d()).param("fid", this.a.e));
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
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            super.onChangeSkinType(i);
            kk7 kk7Var = this.a;
            if (kk7Var != null) {
                kk7Var.g(i);
            }
            yn5 yn5Var = this.l;
            if (yn5Var != null && yn5Var.isViewAttached()) {
                this.l.onChangeSkinType();
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a == null) {
            return;
        }
        hideLoadingView();
        this.a.i();
        int i = this.g;
        if (i == 0) {
            if (!ListUtils.isEmpty(this.j)) {
                Z1(true, false);
                this.a.o();
                return;
            }
            Y1();
        } else if (i == 2) {
            this.a.j(false);
            if (!ListUtils.isEmpty(this.j)) {
                Z1(true, false);
                this.a.o();
                return;
            }
            Y1();
        } else if (i == 1) {
            if (!ListUtils.isEmpty(this.j)) {
                Z1(false, true);
            } else {
                this.a.o();
            }
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.k(false);
            this.a.m(false);
            this.a.d();
            this.a.a().getData().clear();
            this.a.f();
            if (this.l == null) {
                yn5 yn5Var = new yn5(getPageContext().getContext(), getNetRefreshListener());
                this.l = yn5Var;
                yn5Var.e(null);
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

    @Override // com.baidu.tieba.gj7
    public void D1() {
        kk7 kk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (kk7Var = this.a) != null && kk7Var.a() != null) {
            this.a.a().scrollToPosition(0);
        }
    }

    public BdTypeRecyclerView U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            kk7 kk7Var = this.a;
            if (kk7Var == null) {
                return null;
            }
            return kk7Var.a();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.k(true);
            this.a.m(true);
            yn5 yn5Var = this.l;
            if (yn5Var != null && yn5Var.isViewAttached()) {
                this.l.dettachView(this.a.b());
            }
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.k(false);
            showLoadingView(this.a.b(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
        }
    }

    @Override // com.baidu.tieba.gj7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.a != null) {
            D1();
            this.a.p();
        }
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

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.k(true);
            hideLoadingView(this.a.b());
        }
    }

    @Override // com.baidu.tieba.ij7
    public void k1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.a == null) {
            return;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            X1(2);
            if (ListUtils.isEmpty(this.k)) {
                b2();
                return;
            }
            return;
        }
        this.a.j(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
            kk7 kk7Var = this.a;
            if (kk7Var != null) {
                kk7Var.h();
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
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLazyLoad();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                X1(0);
                b2();
                return;
            }
            c2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            X1(0);
            b2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
        }
    }

    public final void W1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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

    public final void X1(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.c == null) {
            return;
        }
        V1();
        this.g = i;
        if (i != 0 && i != 2) {
            if (i == 1) {
                this.c.W(this.e, this.f, 20);
                return;
            }
            return;
        }
        this.c.W(this.e, 0, 20);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            this.d = getPageContext();
            W1(bundle);
            registerListener(this.q);
            registerListener(this.r);
            registerListener(this.o);
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.m = UtilHelper.getScreenHeight(getActivity());
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.k != null && this.a != null) {
            this.k.add(new gi7());
            this.a.c().d(this.k);
            this.a.c().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.e).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        kk7 kk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || (kk7Var = this.a) == null) {
            return;
        }
        if (kk7Var != null && kk7Var.a() != null) {
            this.a.a().stopScroll();
        }
        a2();
        if (yi.G() && this.i) {
            X1(1);
        }
    }

    public final void Z1(boolean z, boolean z2) {
        ArrayList<yn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || (arrayList = this.k) == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i = 0; i < this.k.size(); i++) {
                yn ynVar = (yn) ListUtils.getItem(this.k, i);
                if (ynVar instanceof ik7) {
                    ((ik7) ynVar).m(false);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d033d, (ViewGroup) null);
            kk7 kk7Var = new kk7(this, inflate);
            this.a = kk7Var;
            kk7Var.l(this.p);
            gk7 gk7Var = new gk7(this, this.a.a());
            this.h = gk7Var;
            gk7Var.f(this.s);
            if (this.b == null) {
                this.b = new b(this);
            }
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.c.X(this.b);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                c2();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
