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
import d.a.d.e.p.j;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.q0.u0.p0;
import d.a.q0.u0.r0;
import d.a.q0.u0.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsADFragment extends BaseFragment implements p0, BdListView.p, r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.u0.g1.e f15520e;

    /* renamed from: f  reason: collision with root package name */
    public ADRequestModel.b f15521f;

    /* renamed from: g  reason: collision with root package name */
    public ADRequestModel f15522g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f15523h;

    /* renamed from: i  reason: collision with root package name */
    public long f15524i;
    public int j;
    public int k;
    public d.a.q0.u0.g1.a l;
    public boolean m;
    public List<d.a.q0.u0.g1.c> n;
    public ArrayList<n> o;
    public d.a.p0.f0.c p;
    public int q;
    public int r;
    public CustomMessageListener s;
    public final RecyclerView.OnScrollListener t;
    public CustomMessageListener u;
    public CustomMessageListener v;
    public w w;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f15525a;

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
            this.f15525a = frsADFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f15525a.p == null || !this.f15525a.p.isViewAttached()) {
                return;
            }
            this.f15525a.p.a(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ADRequestModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f15526a;

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
            this.f15526a = frsADFragment;
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void a(ADSocketResponseMessage aDSocketResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDSocketResponseMessage) == null) || aDSocketResponseMessage == null || this.f15526a.f15520e == null) {
                return;
            }
            if (aDSocketResponseMessage.getError() == 0) {
                this.f15526a.j = (int) aDSocketResponseMessage.getOffset();
                this.f15526a.n = aDSocketResponseMessage.getList();
                this.f15526a.m = aDSocketResponseMessage.getHas_more() == 1;
                this.f15526a.o();
                return;
            }
            this.f15526a.h1();
        }

        @Override // com.baidu.tieba.frs.adModel.ADRequestModel.b
        public void b(ADHttpResponseMessage aDHttpResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDHttpResponseMessage) == null) || aDHttpResponseMessage == null || this.f15526a.f15520e == null) {
                return;
            }
            if (aDHttpResponseMessage.getError() == 0) {
                this.f15526a.j = (int) aDHttpResponseMessage.getOffset();
                this.f15526a.n = aDHttpResponseMessage.getList();
                this.f15526a.m = aDHttpResponseMessage.getHas_more() == 1;
                this.f15526a.o();
                return;
            }
            this.f15526a.h1();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f15527a;

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
            this.f15527a = frsADFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                this.f15527a.r += i3;
                if (this.f15527a.r < this.f15527a.q * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f15528a;

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
            this.f15528a = frsADFragment;
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
                if (this.f15528a.Z0() != null) {
                    this.f15528a.Z0().setSelection(0);
                }
                if (this.f15528a.p != null && this.f15528a.p.isViewAttached()) {
                    this.f15528a.c1(0);
                    return;
                }
                d.a.q0.u0.g1.e eVar = this.f15528a.f15520e;
                if (eVar != null) {
                    eVar.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f15529a;

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
            this.f15529a = frsADFragment;
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
                if (this.f15529a.Z0() != null) {
                    this.f15529a.Z0().setSelection(0);
                }
                if (this.f15529a.p != null && this.f15529a.p.isViewAttached()) {
                    this.f15529a.c1(0);
                    this.f15529a.g1();
                    return;
                }
                d.a.q0.u0.g1.e eVar = this.f15529a.f15520e;
                if (eVar != null) {
                    eVar.p();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsADFragment f15530e;

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
            this.f15530e = frsADFragment;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d.a.q0.u0.g1.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || nVar == null || !(nVar instanceof d.a.q0.u0.g1.c) || (cVar = (d.a.q0.u0.g1.c) nVar) == null || cVar.h() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(BaseWebViewActivity.KEY_SHOW_FRS_TAB_AD, "1"));
            UrlManager.getInstance().dealOneLink(this.f15530e.f15523h, new String[]{d.a.p0.m.a.c(cVar.h(), arrayList)});
            if (k.isEmpty(cVar.d())) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FRS_AD_LIST_ITEM_CLICK).param("obj_type", cVar.d()).param("fid", this.f15530e.f15524i));
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
        this.f15520e = null;
        this.j = 0;
        this.k = 0;
        this.o = new ArrayList<>();
        this.q = 0;
        this.r = 0;
        this.s = new a(this, 2921397, true);
        this.t = new c(this);
        this.u = new d(this, 2001625);
        this.v = new e(this, 2001624);
        this.w = new f(this);
    }

    @Override // d.a.q0.u0.r0
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // d.a.q0.u0.p0
    public void J0() {
        d.a.q0.u0.g1.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.f15520e) == null || eVar.a() == null) {
            return;
        }
        this.f15520e.a().scrollToPosition(0);
    }

    @Override // d.a.q0.u0.p0
    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
        }
    }

    public BdTypeRecyclerView Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.q0.u0.g1.e eVar = this.f15520e;
            if (eVar == null) {
                return null;
            }
            return eVar.a();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f15520e.k(true);
            this.f15520e.m(true);
            d.a.p0.f0.c cVar = this.p;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.p.dettachView(this.f15520e.b());
        }
    }

    public final void b1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (bundle != null) {
                bundle.getString("name");
                bundle.getString("from");
                this.f15524i = d.a.d.e.m.b.f(bundle.getString("forum_id"), 0L);
                return;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("name");
                arguments.getString("from");
                this.f15524i = d.a.d.e.m.b.f(arguments.getString("forum_id"), 0L);
            }
        }
    }

    public final void c1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f15522g == null) {
            return;
        }
        a1();
        this.k = i2;
        if (i2 == 0 || i2 == 2) {
            this.f15522g.x(this.f15524i, 0, 20);
        } else if (i2 == 1) {
            this.f15522g.x(this.f15524i, this.j, 20);
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.o == null || this.f15520e == null) {
            return;
        }
        this.o.add(new s());
        this.f15520e.c().d(this.o);
        this.f15520e.c().b();
    }

    public final void e1(boolean z, boolean z2) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (arrayList = this.o) == null) {
            return;
        }
        if (z) {
            arrayList.clear();
        }
        if (z2) {
            for (int i2 = 0; i2 < this.o.size(); i2++) {
                n nVar = (n) ListUtils.getItem(this.o, i2);
                if (nVar instanceof d.a.q0.u0.g1.c) {
                    ((d.a.q0.u0.g1.c) nVar).t(false);
                }
            }
        }
        this.o.addAll(this.n);
        d.a.p0.b.f.a.d(this.o);
        this.f15520e.c().d(this.o);
        this.f15520e.c().b();
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!this.m) {
                if (ListUtils.isEmpty(this.n)) {
                    this.f15520e.d();
                    return;
                } else {
                    this.f15520e.o();
                    return;
                }
            }
            this.f15520e.n();
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f15520e.k(false);
            showLoadingView(this.f15520e.b(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
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

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f15520e.k(false);
            this.f15520e.m(false);
            this.f15520e.d();
            this.f15520e.a().getData().clear();
            this.f15520e.f();
            if (this.p == null) {
                d.a.p0.f0.c cVar = new d.a.p0.f0.c(getPageContext().getContext(), getNetRefreshListener());
                this.p = cVar;
                cVar.e(null);
                this.p.d(null);
                this.p.c(null);
                this.p.f();
                this.p.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.p.onChangeSkinType();
            this.p.attachView(this.f15520e.b(), true);
            this.p.a(0);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f15520e.k(true);
            hideLoadingView(this.f15520e.b());
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f15520e == null) {
            return;
        }
        l();
        this.f15520e.i();
        int i2 = this.k;
        if (i2 == 0) {
            if (!ListUtils.isEmpty(this.n)) {
                e1(true, false);
                this.f15520e.o();
                return;
            }
            d1();
        } else if (i2 == 2) {
            this.f15520e.j(false);
            if (!ListUtils.isEmpty(this.n)) {
                e1(true, false);
                this.f15520e.o();
                return;
            }
            d1();
        } else if (i2 == 1) {
            if (!ListUtils.isEmpty(this.n)) {
                e1(false, true);
            } else {
                this.f15520e.o();
            }
        }
    }

    @Override // d.a.q0.u0.r0
    public void o0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f15520e == null) {
            return;
        }
        if (j.z()) {
            c1(2);
            if (ListUtils.isEmpty(this.o)) {
                g1();
                return;
            }
            return;
        }
        this.f15520e.j(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.u0.g1.e eVar = this.f15520e;
            if (eVar != null) {
                eVar.g(i2);
            }
            d.a.p0.f0.c cVar = this.p;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.p.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            this.f15523h = getPageContext();
            b1(bundle);
            registerListener(this.u);
            registerListener(this.v);
            registerListener(this.s);
            if (this.f15522g == null) {
                this.f15522g = new ADRequestModel(this.f15523h);
            }
            this.q = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
            d.a.q0.u0.g1.e eVar = new d.a.q0.u0.g1.e(this, inflate);
            this.f15520e = eVar;
            eVar.l(this.t);
            d.a.q0.u0.g1.a aVar = new d.a.q0.u0.g1.a(this, this.f15520e.a());
            this.l = aVar;
            aVar.f(this.w);
            if (this.f15521f == null) {
                this.f15521f = new b(this);
            }
            if (this.f15522g == null) {
                this.f15522g = new ADRequestModel(this.f15523h);
            }
            this.f15522g.y(this.f15521f);
            if (!j.z()) {
                h1();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.s);
            d.a.q0.u0.g1.e eVar = this.f15520e;
            if (eVar != null) {
                eVar.h();
            }
            ADRequestModel aDRequestModel = this.f15522g;
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
            if (j.z()) {
                c1(0);
                g1();
                return;
            }
            h1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f15524i).param("obj_type", 9).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && j.z()) {
            c1(0);
            g1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        d.a.q0.u0.g1.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (eVar = this.f15520e) == null) {
            return;
        }
        if (eVar != null && eVar.a() != null) {
            this.f15520e.a().stopScroll();
        }
        f1();
        if (l.D() && this.m) {
            c1(1);
        }
    }

    @Override // d.a.q0.u0.p0
    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.f15520e == null) {
            return;
        }
        J0();
        this.f15520e.p();
    }
}
