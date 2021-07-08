package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.f0.f;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.j1;
import d.a.o0.z0.b0;
import d.a.p0.e1.c.d;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernPageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final CustomMessageListener B;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.e1.h.i.a f16461e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f16462f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f16463g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.e1.c.a f16464h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f16465i;
    public l j;
    public d.a.p0.e1.c.d k;
    public ConcernNotLoginLayout l;
    public d.a.o0.d0.g m;
    public d.a.o0.d0.h n;
    public NoDataView o;
    public PublishProgressView p;
    public boolean q;
    public int r;
    public ScrollFragmentTabHost s;
    public int t;
    public RecyclerView.OnScrollListener u;
    public ScrollFragmentTabHost.s v;
    public BigdaySwipeRefreshLayout w;
    public d.o x;
    public View.OnClickListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16466a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernPageView concernPageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView, Integer.valueOf(i2)};
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
            this.f16466a = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            j1 j1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof j1) || (j1Var = (j1) customResponsedMessage.getData()) == null || j1Var.e() || this.f16466a.p == null) {
                return;
            }
            this.f16466a.p.c(j1Var);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16467e;

        public b(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16467e = concernPageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16467e.f16464h == null) {
                return;
            }
            this.f16467e.f16464h.d();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16468a;

        public c(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16468a = concernPageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f16468a.t == i2 || this.f16468a.s == null) {
                return;
            }
            this.f16468a.t = i2;
            if (this.f16468a.t == 1) {
                this.f16468a.s.V();
            } else if (this.f16468a.I(recyclerView)) {
                this.f16468a.s.y();
            } else {
                this.f16468a.s.V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16469a;

        public d(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16469a = concernPageView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16469a.s == null) {
                return;
            }
            this.f16469a.t = -1;
            ConcernPageView concernPageView = this.f16469a;
            if (concernPageView.I(concernPageView.f16463g)) {
                this.f16469a.s.y();
            } else {
                this.f16469a.s.V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16470a;

        public e(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16470a = concernPageView;
        }

        @Override // d.a.p0.e1.c.d.o
        public void a(d.a.o0.z0.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f16470a.u();
                this.f16470a.v();
                this.f16470a.f16463g.setSelection(0);
                if (this.f16470a.f16463g.getCount() > 0) {
                    this.f16470a.t();
                    this.f16470a.L();
                } else {
                    this.f16470a.N(true);
                }
                if (this.f16470a.j != null) {
                    this.f16470a.j.b(cVar);
                }
            }
        }

        @Override // d.a.p0.e1.c.d.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f16470a.j != null) {
                    this.f16470a.j.a(true, false);
                }
                this.f16470a.t();
                this.f16470a.u();
                this.f16470a.f16463g.setVisibility(8);
                this.f16470a.P();
            }
        }

        @Override // d.a.p0.e1.c.d.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.f16470a.j != null) {
                    this.f16470a.j.a(z, z2);
                }
                this.f16470a.t();
                this.f16470a.u();
                this.f16470a.v();
                if (this.f16470a.k.E()) {
                    this.f16470a.L();
                } else {
                    this.f16470a.M();
                }
            }
        }

        @Override // d.a.p0.e1.c.d.o
        public void d(String str, d.a.o0.z0.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
                this.f16470a.u();
                this.f16470a.v();
                this.f16470a.t();
                this.f16470a.M();
                if (this.f16470a.j != null) {
                    this.f16470a.j.c(str, cVar);
                }
            }
        }

        @Override // d.a.p0.e1.c.d.o
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                if (this.f16470a.j != null) {
                    this.f16470a.j.a(false, false);
                }
                this.f16470a.t();
                this.f16470a.v();
                if (i2 != 1) {
                    this.f16470a.f16463g.setVisibility(8);
                    this.f16470a.O(true);
                } else if (d.a.c.e.p.j.z()) {
                    this.f16470a.f16465i.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16471e;

        public f(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16471e = concernPageView;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                d.a.p0.o.d.c().f("page_concern");
                this.f16471e.k.d0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16472e;

        public g(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16472e = concernPageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16472e.B();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16473e;

        public h(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16473e = concernPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f16473e.k != null && d.a.c.e.p.j.A() && TbadkCoreApplication.isLogin()) {
                this.f16473e.k.d0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16474e;

        public i(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16474e = concernPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16474e.B();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16475a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ConcernPageView concernPageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView, Integer.valueOf(i2)};
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
            this.f16475a = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f16475a.q = true;
            this.f16475a.K();
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f16476a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ConcernPageView concernPageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView, Integer.valueOf(i2)};
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
            this.f16476a = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                this.f16476a.k.r();
            } else {
                this.f16476a.k.S();
            }
            if (this.f16476a.o == null) {
                return;
            }
            if (intValue == 1) {
                this.f16476a.o.setTextOption(NoDataViewFactory.e.d(null, this.f16476a.getContext().getString(R.string.concern_person_no_data_title)));
            } else {
                this.f16476a.o.setTextOption(NoDataViewFactory.e.d(null, this.f16476a.getContext().getString(R.string.concern_no_data_title)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface l {
        void a(boolean z, boolean z2);

        void b(d.a.o0.z0.c cVar);

        void c(String str, d.a.o0.z0.c cVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernPageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = 3;
        this.t = -1;
        this.u = new c(this);
        this.v = new d(this);
        this.x = new e(this);
        this.y = new i(this);
        this.z = new j(this, 2921058);
        this.A = new k(this, 2921502);
        this.B = new a(this, 2921526);
        w(context);
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.o0.d0.h hVar = this.n;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B() {
        d.a.p0.e1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.H();
    }

    public void C() {
        d.a.p0.e1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f16464h) == null) {
            return;
        }
        aVar.d();
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.r != i2) {
                ConcernNotLoginLayout concernNotLoginLayout = this.l;
                if (concernNotLoginLayout != null) {
                    concernNotLoginLayout.b(i2);
                }
                d.a.o0.d0.g gVar = this.m;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                d.a.o0.d0.h hVar = this.n;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                d.a.p0.e1.h.i.a aVar = this.f16461e;
                if (aVar != null) {
                    aVar.I(i2);
                }
                PbListView pbListView = this.f16462f;
                if (pbListView != null) {
                    pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                    this.f16462f.d(i2);
                }
                NoDataView noDataView = this.o;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    this.o.f(this.f16465i, i2);
                    this.o.setSubTitleTextColor(R.color.CAM_X0105);
                }
                PublishProgressView publishProgressView = this.p;
                if (publishProgressView != null) {
                    publishProgressView.b();
                }
                this.f16464h.e(i2);
            }
            this.r = i2;
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.v);
            }
            this.f16463g.removeOnScrollListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.B);
            this.k.Z(null);
            this.f16461e.a(null);
            this.f16461e.b(null);
            this.f16463g.setOnSrollToBottomListener(null);
            this.f16461e.l(null);
            this.f16461e.Y();
            this.f16463g.setRecyclerListener(null);
            this.k.M();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setTabInForeBackgroundState(false);
            C();
        }
    }

    public void G() {
        d.a.p0.e1.c.a aVar;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f16464h) == null) {
            return;
        }
        List<n> a2 = aVar.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (n nVar : a2) {
            if (nVar instanceof d.a.p0.a0.e0.k) {
                d.a.p0.a0.e0.k kVar = (d.a.p0.a0.e0.k) nVar;
                if (kVar.o != 0 && (b2Var = kVar.f53795e) != null) {
                    int[] d0 = b2Var.d0();
                    kVar.o = d0[0];
                    kVar.p = d0[1];
                }
            }
        }
        d.a.c.e.m.e.a().postDelayed(new b(this), 500L);
    }

    public void H() {
        d.a.p0.e1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.K(true);
    }

    public boolean I(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                Q();
                return;
            }
            d.a.p0.e1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.R();
            }
        }
    }

    public void K() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdTypeRecyclerView = this.f16463g) == null || this.w == null) {
            return;
        }
        if (this.q && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.q = false;
            return;
        }
        this.f16463g.setSelection(0);
        if (!this.w.t()) {
            NoDataView noDataView = this.o;
            if (noDataView != null && noDataView.getVisibility() == 0) {
                if (TbadkCoreApplication.isLogin()) {
                    this.k.d0();
                }
            } else {
                this.w.setRefreshing(true);
            }
        }
        if (!this.w.t()) {
            this.w.setRefreshing(true);
        }
        ScrollFragmentTabHost.s sVar = this.v;
        if (sVar != null) {
            sVar.a();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.w.setVisibility(0);
            this.f16463g.setVisibility(0);
            this.f16462f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f16462f.r(0);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.w.setVisibility(0);
            this.f16463g.setVisibility(0);
            if (this.k.A()) {
                this.f16462f.O();
            } else {
                this.f16462f.g();
            }
            this.f16462f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f16462f.r(d.a.c.e.p.l.g(getContext(), R.dimen.tbds150));
        }
    }

    public final void N(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || z()) {
            return;
        }
        if (this.m == null) {
            this.m = new d.a.o0.d0.g(getContext());
            this.m.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + d.a.c.e.p.l.g(getContext(), R.dimen.tbds60));
            this.m.h();
            this.m.setWrapStyle(true);
        }
        this.m.onChangeSkinType();
        this.m.attachView(this, z);
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || A()) {
            return;
        }
        if (this.n == null) {
            this.n = new d.a.o0.d0.h(getContext(), new h(this));
        }
        this.n.attachView(this, z);
        this.n.o();
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int k2 = d.a.o0.r.d0.b.j().k("key_home_concern_all_status", 0);
            if (this.o == null) {
                this.o = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.e.d(null, getContext().getString(R.string.concern_no_data_title)), null);
            }
            if (k2 == 1) {
                this.o.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.concern_person_no_data_title)));
                this.o.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.GIFT));
            } else {
                this.o.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.concern_no_data_title)));
                this.o.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL));
            }
            this.o.f(this.f16465i, TbadkCoreApplication.getInst().getSkinType());
            this.o.setVisibility(0);
            this.o.bringToFront();
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.l == null) {
                ConcernNotLoginLayout concernNotLoginLayout = new ConcernNotLoginLayout(getContext());
                this.l = concernNotLoginLayout;
                concernNotLoginLayout.b(this.r);
            }
            if (this.l.getParent() != null) {
                return;
            }
            this.w.setVisibility(8);
            this.l.setVisibility(0);
            addView(this.l);
        }
    }

    public void R(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, dataRes, z) == null) {
            this.k.N(z, dataRes, 0, null);
        }
    }

    public void S(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, str, i2) == null) {
            this.k.N(true, null, i2, str);
        }
    }

    public void r() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (bigdaySwipeRefreshLayout = this.w) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.r();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                Q();
                return;
            }
            d.a.p0.e1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.d0();
                N(true);
            }
        }
    }

    public void setCallback(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, lVar) == null) {
            this.j = lVar;
        }
    }

    public void setHeaderViewHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
            d.a.p0.e1.c.a aVar = this.f16464h;
            if (aVar != null) {
                aVar.h(bdUniqueId);
            }
            d.a.p0.e1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.c0(bdUniqueId);
            }
            d.a.p0.e1.h.i.a aVar2 = this.f16461e;
            if (aVar2 != null) {
                aVar2.a0(bdUniqueId);
            }
            CustomMessageListener customMessageListener = this.z;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.z);
            }
            CustomMessageListener customMessageListener2 = this.A;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.A);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(b0 b0Var) {
        d.a.p0.e1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, b0Var) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.a0(b0Var);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, scrollFragmentTabHost) == null) {
            this.s = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.v);
                this.s.w(this.v);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        d.a.p0.e1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.b0(z);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            setViewForeground(false);
            d.a.p0.e1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.K(false);
            }
        }
    }

    public final void t() {
        d.a.o0.d0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (gVar = this.m) == null) {
            return;
        }
        gVar.dettachView(this);
        this.m = null;
    }

    public final void u() {
        d.a.o0.d0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this);
        this.n = null;
    }

    public final void v() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (noDataView = this.o) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f16463g = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f16463g.setFadingEdgeLength(0);
            this.f16463g.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f16463g.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.w = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.f16463g);
            PbListView pbListView = new PbListView(context);
            this.f16462f = pbListView;
            pbListView.a();
            this.f16462f.o(R.color.transparent);
            this.f16462f.v();
            this.f16462f.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f16462f.E(R.dimen.tbfontsize33);
            this.f16462f.y(R.color.CAM_X0110);
            this.f16462f.z(this.y);
            this.f16463g.setNextPage(this.f16462f);
            d.a.c.a.f<?> a2 = d.a.c.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f16465i = (TbPageContext) a2;
            }
            addView(this.w);
            d.a.p0.e1.h.i.a aVar = new d.a.p0.e1.h.i.a(this.f16465i);
            this.f16461e = aVar;
            aVar.B(true);
            this.w.setProgressView(this.f16461e);
            int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
            this.w.setCustomDistances(i2, i2, i2 * 2);
            d.a.p0.e1.c.a aVar2 = new d.a.p0.e1.c.a(context, this.f16463g);
            this.f16464h = aVar2;
            this.k = new d.a.p0.e1.c.d(this.f16465i, this.f16463g, aVar2, this.w);
            this.w.setVisibility(8);
            PublishProgressView publishProgressView = new PublishProgressView(context);
            this.p = publishProgressView;
            addView(publishProgressView, new FrameLayout.LayoutParams(-1, d.a.c.e.p.l.g(getContext(), R.dimen.tbds83)));
            this.p.setVisibility(8);
            D(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.k.Z(this.x);
            this.f16461e.a(new f(this));
            this.f16463g.setOnSrollToBottomListener(new g(this));
            this.f16463g.removeOnScrollListener(this.u);
            this.f16463g.addOnScrollListener(this.u);
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    public void y(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, b2Var) == null) {
            v();
            this.k.B(b2Var);
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            d.a.o0.d0.g gVar = this.m;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            d.a.p0.e1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.O(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.v);
                this.s.w(this.v);
                this.v.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = 3;
        this.t = -1;
        this.u = new c(this);
        this.v = new d(this);
        this.x = new e(this);
        this.y = new i(this);
        this.z = new j(this, 2921058);
        this.A = new k(this, 2921502);
        this.B = new a(this, 2921526);
        w(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernPageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = 3;
        this.t = -1;
        this.u = new c(this);
        this.v = new d(this);
        this.x = new e(this);
        this.y = new i(this);
        this.z = new j(this, 2921058);
        this.A = new k(this, 2921502);
        this.B = new a(this, 2921526);
        w(context);
    }
}
