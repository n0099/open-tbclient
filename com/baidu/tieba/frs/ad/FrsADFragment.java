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
import com.baidu.tieba.as7;
import com.baidu.tieba.cs7;
import com.baidu.tieba.es7;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.oi;
import com.baidu.tieba.qd;
import com.baidu.tieba.rj5;
import com.baidu.tieba.xp7;
import com.baidu.tieba.xq7;
import com.baidu.tieba.yi;
import com.baidu.tieba.zq7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FrsADFragment extends BaseFragment implements xq7, BdListView.p, zq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public es7 a;
    public ADRequestModel.b b;
    public ADRequestModel c;
    public TbPageContext d;
    public long e;
    public int f;
    public int g;
    public as7 h;
    public boolean i;
    public List<cs7> j;
    public ArrayList<oi> k;
    public rj5 l;
    public int m;
    public int n;
    public CustomMessageListener o;
    public final RecyclerView.OnScrollListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public yi s;

    @Override // com.baidu.tieba.zq7
    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.xq7
    public void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                    this.a.P2();
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
                this.a.R();
            }
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDHttpResponseMessage) == null) && aDHttpResponseMessage != null && this.a.a != null) {
                if (aDHttpResponseMessage.getError() != 0) {
                    this.a.P2();
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
                this.a.R();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                FrsADFragment.D2(this.a, i2);
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

    /* loaded from: classes6.dex */
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
                if (this.a.H2() != null) {
                    this.a.H2().setSelection(0);
                }
                if (this.a.l == null || !this.a.l.isViewAttached()) {
                    es7 es7Var = this.a.a;
                    if (es7Var != null) {
                        es7Var.p();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.K2(0);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.a.H2() != null) {
                    this.a.H2().setSelection(0);
                }
                if (this.a.l == null || !this.a.l.isViewAttached()) {
                    es7 es7Var = this.a.a;
                    if (es7Var != null) {
                        es7Var.p();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.K2(0);
                this.a.O2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements yi {
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

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            cs7 cs7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && oiVar != null && (oiVar instanceof cs7) && (cs7Var = (cs7) oiVar) != null && cs7Var.f() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
                UrlManager.getInstance().dealOneLink(this.a.d, new String[]{BrowserHelper.appendParams(cs7Var.f(), arrayList)});
                if (!qd.isEmpty(cs7Var.d())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", cs7Var.d()).param("fid", this.a.e));
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
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            super.onChangeSkinType(i);
            es7 es7Var = this.a;
            if (es7Var != null) {
                es7Var.g(i);
            }
            rj5 rj5Var = this.l;
            if (rj5Var != null && rj5Var.isViewAttached()) {
                this.l.onChangeSkinType();
            }
        }
    }

    public static /* synthetic */ int D2(FrsADFragment frsADFragment, int i) {
        int i2 = frsADFragment.n + i;
        frsADFragment.n = i2;
        return i2;
    }

    @Override // com.baidu.tieba.xq7
    public void F() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (es7Var = this.a) != null && es7Var.a() != null) {
            this.a.a().scrollToPosition(0);
        }
    }

    public BdTypeRecyclerView H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            es7 es7Var = this.a;
            if (es7Var == null) {
                return null;
            }
            return es7Var.a();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.k(true);
            this.a.m(true);
            rj5 rj5Var = this.l;
            if (rj5Var != null && rj5Var.isViewAttached()) {
                this.l.dettachView(this.a.b());
            }
        }
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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

    @Override // com.baidu.tieba.zq7
    public void O1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.a == null) {
            return;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            K2(2);
            if (ListUtils.isEmpty(this.k)) {
                O2();
                return;
            }
            return;
        }
        this.a.j(false);
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.k(false);
            showLoadingView(this.a.b(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = 90;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.k(true);
            hideLoadingView(this.a.b());
        }
    }

    @Override // com.baidu.tieba.xq7
    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.a != null) {
            F();
            this.a.p();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
            es7 es7Var = this.a;
            if (es7Var != null) {
                es7Var.h();
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
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onLazyLoad();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                K2(0);
                O2();
                return;
            }
            P2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            K2(0);
            O2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPrimary();
        }
    }

    public final void J2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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

    public final void K2(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.c == null) {
            return;
        }
        I2();
        this.g = i;
        if (i != 0 && i != 2) {
            if (i == 1) {
                this.c.P(this.e, this.f, 20);
                return;
            }
            return;
        }
        this.c.P(this.e, 0, 20);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            this.d = getPageContext();
            J2(bundle);
            registerListener(this.q);
            registerListener(this.r);
            registerListener(this.o);
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.m = UtilHelper.getScreenHeight(getActivity());
        }
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.k != null && this.a != null) {
            this.k.add(new xp7());
            this.a.c().d(this.k);
            this.a.c().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.e).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (es7Var = this.a) == null) {
            return;
        }
        if (es7Var != null && es7Var.a() != null) {
            this.a.a().stopScroll();
        }
        N2();
        if (BdUtilHelper.isNetOk() && this.i) {
            K2(1);
        }
    }

    public final void M2(boolean z, boolean z2) {
        ArrayList<oi> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || (arrayList = this.k) == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i = 0; i < this.k.size(); i++) {
                oi oiVar = (oi) ListUtils.getItem(this.k, i);
                if (oiVar instanceof cs7) {
                    ((cs7) oiVar).n(false);
                }
            }
        }
        this.k.addAll(this.j);
        AbsGroupUbsABTest.setCardInfoUbsABTest(this.k);
        this.a.c().d(this.k);
        this.a.c().b();
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.k(false);
            this.a.m(false);
            this.a.d();
            this.a.a().getData().clear();
            this.a.f();
            if (this.l == null) {
                rj5 rj5Var = new rj5(getPageContext().getContext(), getNetRefreshListener());
                this.l = rj5Var;
                rj5Var.d(null);
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

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.a == null) {
            return;
        }
        hideLoadingView();
        this.a.i();
        int i = this.g;
        if (i == 0) {
            if (!ListUtils.isEmpty(this.j)) {
                M2(true, false);
                this.a.o();
                return;
            }
            L2();
        } else if (i == 2) {
            this.a.j(false);
            if (!ListUtils.isEmpty(this.j)) {
                M2(true, false);
                this.a.o();
                return;
            }
            L2();
        } else if (i == 1) {
            if (!ListUtils.isEmpty(this.j)) {
                M2(false, true);
            } else {
                this.a.o();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0359, (ViewGroup) null);
            es7 es7Var = new es7(this, inflate);
            this.a = es7Var;
            es7Var.l(this.p);
            as7 as7Var = new as7(this, this.a.a());
            this.h = as7Var;
            as7Var.f(this.s);
            if (this.b == null) {
                this.b = new b(this);
            }
            if (this.c == null) {
                this.c = new ADRequestModel(this.d);
            }
            this.c.Q(this.b);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                P2();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
