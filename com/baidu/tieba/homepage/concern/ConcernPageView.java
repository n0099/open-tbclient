package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.l.e.n;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.l1;
import c.a.r0.h1.c.d;
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
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes7.dex */
public class ConcernPageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public final CustomMessageListener C;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.h1.h.i.a f52074e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f52075f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f52076g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.h1.c.a f52077h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f52078i;

    /* renamed from: j  reason: collision with root package name */
    public l f52079j;
    public c.a.r0.h1.c.d k;
    public ConcernNotLoginLayout l;
    public c.a.q0.g0.g m;
    public c.a.q0.g0.h n;
    public NoDataView o;
    public PublishProgressView p;
    public boolean q;
    public int r;
    public ScrollFragmentTabHost s;
    public int t;
    public boolean u;
    public RecyclerView.OnScrollListener v;
    public ScrollFragmentTabHost.s w;
    public BigdaySwipeRefreshLayout x;
    public d.o y;
    public View.OnClickListener z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52080a;

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
            this.f52080a = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l1 l1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof l1) || (l1Var = (l1) customResponsedMessage.getData()) == null || c.a.r0.k3.r0.g.j().r() || this.f52080a.p == null) {
                return;
            }
            this.f52080a.p.updateCurProgressData(l1Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52081e;

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
            this.f52081e = concernPageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52081e.f52077h == null) {
                return;
            }
            this.f52081e.f52077h.d();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52082a;

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
            this.f52082a = concernPageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f52082a.t == i2 || this.f52082a.s == null) {
                return;
            }
            this.f52082a.t = i2;
            if (this.f52082a.t == 1) {
                this.f52082a.s.showShadow();
            } else if (this.f52082a.recyclerViewIsAtTop(recyclerView)) {
                this.f52082a.s.dismissShadow();
            } else {
                this.f52082a.s.showShadow();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52083a;

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
            this.f52083a = concernPageView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52083a.s == null) {
                return;
            }
            this.f52083a.t = -1;
            ConcernPageView concernPageView = this.f52083a;
            if (concernPageView.recyclerViewIsAtTop(concernPageView.f52076g)) {
                this.f52083a.s.dismissShadow();
            } else {
                this.f52083a.s.showShadow();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52084a;

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
            this.f52084a = concernPageView;
        }

        @Override // c.a.r0.h1.c.d.o
        public void a(c.a.q0.d1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                this.f52084a.s();
                this.f52084a.t();
                this.f52084a.f52076g.setSelection(0);
                if (this.f52084a.f52076g.getCount() > 0) {
                    this.f52084a.r();
                    this.f52084a.showListViewNoLoadMoreView();
                } else {
                    this.f52084a.w(true);
                }
                if (this.f52084a.f52079j != null) {
                    this.f52084a.f52079j.b(eVar);
                }
            }
        }

        @Override // c.a.r0.h1.c.d.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f52084a.f52079j != null) {
                    this.f52084a.f52079j.a(true, false);
                }
                this.f52084a.r();
                this.f52084a.s();
                this.f52084a.f52076g.setVisibility(8);
                this.f52084a.x();
            }
        }

        @Override // c.a.r0.h1.c.d.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.f52084a.f52079j != null) {
                    this.f52084a.f52079j.a(z, z2);
                }
                this.f52084a.r();
                this.f52084a.s();
                this.f52084a.t();
                if (this.f52084a.k.C()) {
                    this.f52084a.showListViewNoLoadMoreView();
                } else {
                    this.f52084a.showListViewWithLoadMoreView();
                }
            }
        }

        @Override // c.a.r0.h1.c.d.o
        public void d(String str, c.a.q0.d1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
                this.f52084a.s();
                this.f52084a.t();
                this.f52084a.r();
                this.f52084a.showListViewWithLoadMoreView();
                if (this.f52084a.f52079j != null) {
                    this.f52084a.f52079j.c(str, eVar);
                }
            }
        }

        @Override // c.a.r0.h1.c.d.o
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                if (this.f52084a.f52079j != null) {
                    this.f52084a.f52079j.a(false, false);
                }
                this.f52084a.r();
                this.f52084a.t();
                if (i2 != 1) {
                    this.f52084a.f52076g.setVisibility(8);
                    this.f52084a.showNetRefreshView(true);
                } else if (c.a.e.e.p.j.z()) {
                    this.f52084a.f52078i.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52085e;

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
            this.f52085e = concernPageView;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                c.a.r0.p.d.c().f("page_concern");
                this.f52085e.k.a0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52086e;

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
            this.f52086e = concernPageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52086e.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52087e;

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
            this.f52087e = concernPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f52087e.k != null && c.a.e.e.p.j.A() && TbadkCoreApplication.isLogin()) {
                this.f52087e.k.a0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52088e;

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
            this.f52088e = concernPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52088e.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52089a;

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
            this.f52089a = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f52089a.q = true;
            this.f52089a.reload();
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f52090a;

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
            this.f52090a = concernPageView;
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
                this.f52090a.k.p();
            } else {
                this.f52090a.k.Q();
            }
            if (this.f52090a.o == null) {
                return;
            }
            if (intValue == 1) {
                this.f52090a.o.setTextOption(NoDataViewFactory.e.d(null, this.f52090a.getContext().getString(R.string.concern_person_no_data_title)));
            } else {
                this.f52090a.o.setTextOption(NoDataViewFactory.e.d(null, this.f52090a.getContext().getString(R.string.concern_no_data_title)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface l {
        void a(boolean z, boolean z2);

        void b(c.a.q0.d1.e eVar);

        void c(String str, c.a.q0.d1.e eVar);
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
        this.u = false;
        this.v = new c(this);
        this.w = new d(this);
        this.y = new e(this);
        this.z = new i(this);
        this.A = new j(this, 2921058);
        this.B = new k(this, 2921502);
        this.C = new a(this, 2921526);
    }

    public void completePullRefresh() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bigdaySwipeRefreshLayout = this.x) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.interruptRefresh();
    }

    public void firstLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                y();
                return;
            }
            c.a.r0.h1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.a0();
                w(true);
            }
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) || context == null) {
            return;
        }
        this.u = true;
        BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
        this.f52076g = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f52076g.setFadingEdgeLength(0);
        this.f52076g.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f52076g.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.x = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.f52076g);
        PbListView pbListView = new PbListView(context);
        this.f52075f = pbListView;
        pbListView.a();
        this.f52075f.o(R.color.transparent);
        this.f52075f.v();
        this.f52075f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f52075f.E(R.dimen.tbfontsize33);
        this.f52075f.y(R.color.CAM_X0110);
        this.f52075f.z(this.z);
        this.f52076g.setNextPage(this.f52075f);
        c.a.e.a.f<?> a2 = c.a.e.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f52078i = (TbPageContext) a2;
        }
        if (c.a.q0.b.d.C()) {
            addView(this.x);
        }
        c.a.r0.h1.h.i.a aVar = new c.a.r0.h1.h.i.a(this.f52078i);
        this.f52074e = aVar;
        aVar.w(true);
        this.x.setProgressView(this.f52074e);
        int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
        this.x.setCustomDistances(i2, i2, i2 * 2);
        c.a.r0.h1.c.a aVar2 = new c.a.r0.h1.c.a(context, this.f52076g);
        this.f52077h = aVar2;
        this.k = new c.a.r0.h1.c.d(this.f52078i, this.f52076g, aVar2, this.x);
        this.x.setVisibility(8);
        this.p = new PublishProgressView(context);
        if (c.a.q0.b.d.C()) {
            addView(this.p, new FrameLayout.LayoutParams(-1, c.a.e.e.p.l.g(getContext(), R.dimen.tbds83)));
        }
        this.p.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.X(this.y);
            this.f52074e.a(new f(this));
            this.f52076g.setOnSrollToBottomListener(new g(this));
            this.f52076g.removeOnScrollListener(this.v);
            this.f52076g.addOnScrollListener(this.v);
            MessageManager.getInstance().registerListener(this.C);
        }
    }

    public void insertOneThread(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) {
            t();
            this.k.z(d2Var);
        }
    }

    public boolean isInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.q0.g0.g gVar = this.m;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void notifyListViewDataSetChanged() {
        c.a.r0.h1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f52077h) == null) {
            return;
        }
        aVar.d();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (this.r != i2) {
                ConcernNotLoginLayout concernNotLoginLayout = this.l;
                if (concernNotLoginLayout != null) {
                    concernNotLoginLayout.onChangeSkinType(i2);
                }
                c.a.q0.g0.g gVar = this.m;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                c.a.q0.g0.h hVar = this.n;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                c.a.r0.h1.h.i.a aVar = this.f52074e;
                if (aVar != null) {
                    aVar.D(i2);
                }
                PbListView pbListView = this.f52075f;
                if (pbListView != null) {
                    pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                    this.f52075f.d(i2);
                }
                NoDataView noDataView = this.o;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    this.o.onChangeSkinType(this.f52078i, i2);
                    this.o.setSubTitleTextColor(R.color.CAM_X0105);
                }
                PublishProgressView publishProgressView = this.p;
                if (publishProgressView != null) {
                    publishProgressView.onChangeSkinType();
                }
                this.f52077h.e(i2);
            }
            this.r = i2;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.w);
            }
            this.f52076g.removeOnScrollListener(this.v);
            MessageManager.getInstance().unRegisterListener(this.C);
            this.k.X(null);
            this.f52074e.a(null);
            this.f52074e.b(null);
            this.f52076g.setOnSrollToBottomListener(null);
            this.f52074e.h(null);
            this.f52074e.T();
            this.f52076g.setRecyclerListener(null);
            this.k.K();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setTabInForeBackgroundState(false);
            notifyListViewDataSetChanged();
        }
    }

    public void onScreenSizeChange() {
        c.a.r0.h1.c.a aVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (aVar = this.f52077h) == null) {
            return;
        }
        List<n> a2 = aVar.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (n nVar : a2) {
            if (nVar instanceof c.a.r0.b0.e0.k) {
                c.a.r0.b0.e0.k kVar = (c.a.r0.b0.e0.k) nVar;
                if (kVar.o != 0 && (d2Var = kVar.f15721e) != null) {
                    int[] g0 = d2Var.g0();
                    kVar.o = g0[0];
                    kVar.p = g0[1];
                }
            }
        }
        c.a.e.e.m.e.a().postDelayed(new b(this), 500L);
    }

    public void onViewBackGround() {
        c.a.r0.h1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.I(true);
    }

    public final void r() {
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (gVar = this.m) == null) {
            return;
        }
        gVar.dettachView(this);
        this.m = null;
    }

    public boolean recyclerViewIsAtTop(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void redDotLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                y();
                return;
            }
            c.a.r0.h1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.P();
            }
        }
    }

    public void reload() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bdTypeRecyclerView = this.f52076g) == null || this.x == null) {
            return;
        }
        if (this.q && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.q = false;
            return;
        }
        this.f52076g.setSelection(0);
        if (!this.x.isRefreshing()) {
            NoDataView noDataView = this.o;
            if (noDataView != null && noDataView.getVisibility() == 0) {
                if (TbadkCoreApplication.isLogin()) {
                    this.k.a0();
                }
            } else {
                this.x.setRefreshing(true);
            }
        }
        if (!this.x.isRefreshing()) {
            this.x.setRefreshing(true);
        }
        ScrollFragmentTabHost.s sVar = this.w;
        if (sVar != null) {
            sVar.a();
        }
    }

    public final void s() {
        c.a.q0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this);
        this.n = null;
    }

    public void setCallback(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, lVar) == null) {
            this.f52079j = lVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            c.a.r0.h1.c.a aVar = this.f52077h;
            if (aVar != null) {
                aVar.h(bdUniqueId);
            }
            c.a.r0.h1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.Z(bdUniqueId);
            }
            c.a.r0.h1.h.i.a aVar2 = this.f52074e;
            if (aVar2 != null) {
                aVar2.V(bdUniqueId);
            }
            CustomMessageListener customMessageListener = this.A;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.A);
            }
            CustomMessageListener customMessageListener2 = this.B;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.B);
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, scrollFragmentTabHost) == null) {
            this.s = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.w);
                this.s.addShadowChangeListener(this.w);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        c.a.r0.h1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.Y(z);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            setViewForeground(false);
            c.a.r0.h1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.I(false);
            }
        }
    }

    public void showListViewNoLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.x.setVisibility(0);
            this.f52076g.setVisibility(0);
            this.f52075f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f52075f.r(0);
        }
    }

    public void showListViewWithLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.x.setVisibility(0);
            this.f52076g.setVisibility(0);
            if (this.k.y()) {
                this.f52075f.O();
            } else {
                this.f52075f.g();
            }
            this.f52075f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f52075f.r(c.a.e.e.p.l.g(getContext(), R.dimen.tbds150));
        }
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || u()) {
            return;
        }
        if (this.n == null) {
            this.n = new c.a.q0.g0.h(getContext(), new h(this));
        }
        this.n.attachView(this, z);
        this.n.o();
    }

    public void showRealView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || c.a.q0.b.d.C()) {
            return;
        }
        addView(this.x);
        addView(this.p, new FrameLayout.LayoutParams(-1, c.a.e.e.p.l.g(getContext(), R.dimen.tbds83)));
    }

    public final void t() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (noDataView = this.o) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            c.a.q0.g0.h hVar = this.n;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void updateData(DataRes dataRes, boolean z) {
        c.a.r0.h1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048606, this, dataRes, z) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.L(z, dataRes, 0, null);
    }

    public void updateError(String str, int i2) {
        c.a.r0.h1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048607, this, str, i2) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.L(true, null, i2, str);
    }

    public final void v() {
        c.a.r0.h1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.F();
    }

    public final void w(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.m == null) {
            this.m = new c.a.q0.g0.g(getContext());
            this.m.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + c.a.e.e.p.l.g(getContext(), R.dimen.tbds60));
            this.m.h();
            this.m.setWrapStyle(true);
        }
        this.m.onChangeSkinType();
        this.m.attachView(this, z);
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            int k2 = c.a.q0.s.d0.b.j().k("key_home_concern_all_status", 0);
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
            this.o.onChangeSkinType(this.f52078i, TbadkCoreApplication.getInst().getSkinType());
            this.o.setVisibility(0);
            this.o.bringToFront();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (this.l == null) {
                ConcernNotLoginLayout concernNotLoginLayout = new ConcernNotLoginLayout(getContext());
                this.l = concernNotLoginLayout;
                concernNotLoginLayout.onChangeSkinType(this.r);
            }
            if (this.l.getParent() != null) {
                return;
            }
            this.x.setVisibility(8);
            this.l.setVisibility(0);
            addView(this.l);
        }
    }

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            c.a.r0.h1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.M(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.w);
                this.s.addShadowChangeListener(this.w);
                this.w.a();
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
        this.u = false;
        this.v = new c(this);
        this.w = new d(this);
        this.y = new e(this);
        this.z = new i(this);
        this.A = new j(this, 2921058);
        this.B = new k(this, 2921502);
        this.C = new a(this, 2921526);
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
        this.u = false;
        this.v = new c(this);
        this.w = new d(this);
        this.y = new e(this);
        this.z = new i(this);
        this.A = new j(this, 2921058);
        this.B = new k(this, 2921502);
        this.C = new a(this, 2921526);
    }
}
