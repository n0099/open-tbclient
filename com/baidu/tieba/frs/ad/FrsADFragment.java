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
import com.repackage.ag6;
import com.repackage.c65;
import com.repackage.cf6;
import com.repackage.cg6;
import com.repackage.jm4;
import com.repackage.mh6;
import com.repackage.og;
import com.repackage.oh6;
import com.repackage.oi;
import com.repackage.on;
import com.repackage.pi;
import com.repackage.qh6;
import com.repackage.qi;
import com.repackage.yn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsADFragment extends BaseFragment implements ag6, BdListView.p, cg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qh6 a;
    public ADRequestModel.b b;
    public ADRequestModel c;
    public TbPageContext d;
    public long e;
    public int f;
    public int g;
    public mh6 h;
    public boolean i;
    public List<oh6> j;
    public ArrayList<on> k;
    public c65 l;
    public int m;
    public int n;
    public CustomMessageListener o;
    public final RecyclerView.OnScrollListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public yn s;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.a.l == null || !this.a.l.isViewAttached()) {
                return;
            }
            this.a.l.a(num.intValue());
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDSocketResponseMessage) == null) || aDSocketResponseMessage == null || this.a.a == null) {
                return;
            }
            if (aDSocketResponseMessage.getError() == 0) {
                this.a.f = (int) aDSocketResponseMessage.getOffset();
                this.a.j = aDSocketResponseMessage.getList();
                this.a.i = aDSocketResponseMessage.getHas_more() == 1;
                this.a.t();
                return;
            }
            this.a.N1();
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDHttpResponseMessage) == null) || aDHttpResponseMessage == null || this.a.a == null) {
                return;
            }
            if (aDHttpResponseMessage.getError() == 0) {
                this.a.f = (int) aDHttpResponseMessage.getOffset();
                this.a.j = aDHttpResponseMessage.getList();
                this.a.i = aDHttpResponseMessage.getHas_more() == 1;
                this.a.t();
                return;
            }
            this.a.N1();
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.a.n < this.a.m * 2 || i2 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (this.a.F1() != null) {
                    this.a.F1().setSelection(0);
                }
                if (this.a.l != null && this.a.l.isViewAttached()) {
                    this.a.I1(0);
                    return;
                }
                qh6 qh6Var = this.a.a;
                if (qh6Var != null) {
                    qh6Var.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                if (this.a.F1() != null) {
                    this.a.F1().setSelection(0);
                }
                if (this.a.l != null && this.a.l.isViewAttached()) {
                    this.a.I1(0);
                    this.a.M1();
                    return;
                }
                qh6 qh6Var = this.a.a;
                if (qh6Var != null) {
                    qh6Var.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements yn {
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

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            oh6 oh6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || onVar == null || !(onVar instanceof oh6) || (oh6Var = (oh6) onVar) == null || oh6Var.j() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
            UrlManager.getInstance().dealOneLink(this.a.d, new String[]{jm4.d(oh6Var.j(), arrayList)});
            if (pi.isEmpty(oh6Var.f())) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", oh6Var.f()).param("fid", this.a.e));
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

    public BdTypeRecyclerView F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            qh6 qh6Var = this.a;
            if (qh6Var == null) {
                return null;
            }
            return qh6Var.a();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.k(true);
            this.a.m(true);
            c65 c65Var = this.l;
            if (c65Var == null || !c65Var.isViewAttached()) {
                return;
            }
            this.l.dettachView(this.a.b());
        }
    }

    public final void H1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            if (bundle != null) {
                bundle.getString("name");
                bundle.getString("from");
                this.e = og.g(bundle.getString("forum_id"), 0L);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("name");
                arguments.getString("from");
                this.e = og.g(arguments.getString("forum_id"), 0L);
            }
        }
    }

    public final void I1(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.c == null) {
            return;
        }
        G1();
        this.g = i;
        if (i == 0 || i == 2) {
            this.c.A(this.e, 0, 20);
        } else if (i == 1) {
            this.c.A(this.e, this.f, 20);
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.k == null || this.a == null) {
            return;
        }
        this.k.add(new cf6());
        this.a.c().d(this.k);
        this.a.c().b();
    }

    public final void K1(boolean z, boolean z2) {
        ArrayList<on> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (arrayList = this.k) == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i = 0; i < this.k.size(); i++) {
                on onVar = (on) ListUtils.getItem(this.k, i);
                if (onVar instanceof oh6) {
                    ((oh6) onVar).t(false);
                }
            }
        }
        this.k.addAll(this.j);
        AbsGroupUbsABTest.setCardInfoUbsABTest(this.k);
        this.a.c().d(this.k);
        this.a.c().b();
    }

    public final void L1() {
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

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.k(false);
            showLoadingView(this.a.b(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.k(false);
            this.a.m(false);
            this.a.d();
            this.a.a().getData().clear();
            this.a.f();
            if (this.l == null) {
                c65 c65Var = new c65(getPageContext().getContext(), getNetRefreshListener());
                this.l = c65Var;
                c65Var.e(null);
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

    @Override // com.repackage.cg6
    public void V0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a == null) {
            return;
        }
        if (oi.z()) {
            I1(2);
            if (ListUtils.isEmpty(this.k)) {
                M1();
                return;
            }
            return;
        }
        this.a.j(false);
    }

    @Override // com.repackage.cg6
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = 90;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.repackage.ag6
    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.k(true);
            hideLoadingView(this.a.b());
        }
    }

    @Override // com.repackage.ag6
    public void o1() {
        qh6 qh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (qh6Var = this.a) == null || qh6Var.a() == null) {
            return;
        }
        this.a.a().scrollToPosition(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.onChangeSkinType(i);
            qh6 qh6Var = this.a;
            if (qh6Var != null) {
                qh6Var.g(i);
            }
            c65 c65Var = this.l;
            if (c65Var == null || !c65Var.isViewAttached()) {
                return;
            }
            this.l.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            this.d = getPageContext();
            H1(bundle);
            registerListener(this.q);
            registerListener(this.r);
            registerListener(this.o);
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.m = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02ed, (ViewGroup) null);
            qh6 qh6Var = new qh6(this, inflate);
            this.a = qh6Var;
            qh6Var.l(this.p);
            mh6 mh6Var = new mh6(this, this.a.a());
            this.h = mh6Var;
            mh6Var.f(this.s);
            if (this.b == null) {
                this.b = new b(this);
            }
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.c.B(this.b);
            if (!oi.z()) {
                N1();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
            qh6 qh6Var = this.a;
            if (qh6Var != null) {
                qh6Var.h();
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
            if (oi.z()) {
                I1(0);
                M1();
                return;
            }
            N1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.e).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && oi.z()) {
            I1(0);
            M1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPrimary();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        qh6 qh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (qh6Var = this.a) == null) {
            return;
        }
        if (qh6Var != null && qh6Var.a() != null) {
            this.a.a().stopScroll();
        }
        L1();
        if (qi.D() && this.i) {
            I1(1);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.a == null) {
            return;
        }
        m();
        this.a.i();
        int i = this.g;
        if (i == 0) {
            if (!ListUtils.isEmpty(this.j)) {
                K1(true, false);
                this.a.o();
                return;
            }
            J1();
        } else if (i == 2) {
            this.a.j(false);
            if (!ListUtils.isEmpty(this.j)) {
                K1(true, false);
                this.a.o();
                return;
            }
            J1();
        } else if (i == 1) {
            if (!ListUtils.isEmpty(this.j)) {
                K1(false, true);
            } else {
                this.a.o();
            }
        }
    }

    @Override // com.repackage.ag6
    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.a == null) {
            return;
        }
        o1();
        this.a.p();
    }
}
