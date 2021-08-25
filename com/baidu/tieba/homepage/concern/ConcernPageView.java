package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.l.e.n;
import c.a.p0.b1.d0;
import c.a.p0.s.f0.f;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.k1;
import c.a.q0.f1.c.d;
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
    public final CustomMessageListener B;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.f1.h.i.a f51887e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f51888f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f51889g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.f1.c.a f51890h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f51891i;

    /* renamed from: j  reason: collision with root package name */
    public l f51892j;
    public c.a.q0.f1.c.d k;
    public ConcernNotLoginLayout l;
    public c.a.p0.f0.g m;
    public c.a.p0.f0.h n;
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

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51893a;

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
            this.f51893a = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k1 k1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof k1) || (k1Var = (k1) customResponsedMessage.getData()) == null || k1Var.e() || this.f51893a.p == null) {
                return;
            }
            this.f51893a.p.updateCurProgressData(k1Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51894e;

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
            this.f51894e = concernPageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51894e.f51890h == null) {
                return;
            }
            this.f51894e.f51890h.d();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51895a;

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
            this.f51895a = concernPageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f51895a.t == i2 || this.f51895a.s == null) {
                return;
            }
            this.f51895a.t = i2;
            if (this.f51895a.t == 1) {
                this.f51895a.s.showShadow();
            } else if (this.f51895a.recyclerViewIsAtTop(recyclerView)) {
                this.f51895a.s.dismissShadow();
            } else {
                this.f51895a.s.showShadow();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51896a;

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
            this.f51896a = concernPageView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51896a.s == null) {
                return;
            }
            this.f51896a.t = -1;
            ConcernPageView concernPageView = this.f51896a;
            if (concernPageView.recyclerViewIsAtTop(concernPageView.f51889g)) {
                this.f51896a.s.dismissShadow();
            } else {
                this.f51896a.s.showShadow();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51897a;

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
            this.f51897a = concernPageView;
        }

        @Override // c.a.q0.f1.c.d.o
        public void a(c.a.p0.b1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f51897a.s();
                this.f51897a.t();
                this.f51897a.f51889g.setSelection(0);
                if (this.f51897a.f51889g.getCount() > 0) {
                    this.f51897a.r();
                    this.f51897a.showListViewNoLoadMoreView();
                } else {
                    this.f51897a.x(true);
                }
                if (this.f51897a.f51892j != null) {
                    this.f51897a.f51892j.b(cVar);
                }
            }
        }

        @Override // c.a.q0.f1.c.d.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f51897a.f51892j != null) {
                    this.f51897a.f51892j.a(true, false);
                }
                this.f51897a.r();
                this.f51897a.s();
                this.f51897a.f51889g.setVisibility(8);
                this.f51897a.y();
            }
        }

        @Override // c.a.q0.f1.c.d.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.f51897a.f51892j != null) {
                    this.f51897a.f51892j.a(z, z2);
                }
                this.f51897a.r();
                this.f51897a.s();
                this.f51897a.t();
                if (this.f51897a.k.E()) {
                    this.f51897a.showListViewNoLoadMoreView();
                } else {
                    this.f51897a.showListViewWithLoadMoreView();
                }
            }
        }

        @Override // c.a.q0.f1.c.d.o
        public void d(String str, c.a.p0.b1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
                this.f51897a.s();
                this.f51897a.t();
                this.f51897a.r();
                this.f51897a.showListViewWithLoadMoreView();
                if (this.f51897a.f51892j != null) {
                    this.f51897a.f51892j.c(str, cVar);
                }
            }
        }

        @Override // c.a.q0.f1.c.d.o
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                if (this.f51897a.f51892j != null) {
                    this.f51897a.f51892j.a(false, false);
                }
                this.f51897a.r();
                this.f51897a.t();
                if (i2 != 1) {
                    this.f51897a.f51889g.setVisibility(8);
                    this.f51897a.showNetRefreshView(true);
                } else if (c.a.e.e.p.j.z()) {
                    this.f51897a.f51891i.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51898e;

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
            this.f51898e = concernPageView;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                c.a.q0.o.d.c().f("page_concern");
                this.f51898e.k.d0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51899e;

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
            this.f51899e = concernPageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51899e.w();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51900e;

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
            this.f51900e = concernPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f51900e.k != null && c.a.e.e.p.j.A() && TbadkCoreApplication.isLogin()) {
                this.f51900e.k.d0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51901e;

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
            this.f51901e = concernPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51901e.w();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51902a;

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
            this.f51902a = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f51902a.q = true;
            this.f51902a.reload();
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernPageView f51903a;

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
            this.f51903a = concernPageView;
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
                this.f51903a.k.r();
            } else {
                this.f51903a.k.S();
            }
            if (this.f51903a.o == null) {
                return;
            }
            if (intValue == 1) {
                this.f51903a.o.setTextOption(NoDataViewFactory.e.d(null, this.f51903a.getContext().getString(R.string.concern_person_no_data_title)));
            } else {
                this.f51903a.o.setTextOption(NoDataViewFactory.e.d(null, this.f51903a.getContext().getString(R.string.concern_no_data_title)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface l {
        void a(boolean z, boolean z2);

        void b(c.a.p0.b1.c cVar);

        void c(String str, c.a.p0.b1.c cVar);
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
        u(context);
    }

    public void completePullRefresh() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bigdaySwipeRefreshLayout = this.w) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.interruptRefresh();
    }

    public void firstLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                z();
                return;
            }
            c.a.q0.f1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.d0();
                x(true);
            }
        }
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k.Z(this.x);
            this.f51887e.a(new f(this));
            this.f51889g.setOnSrollToBottomListener(new g(this));
            this.f51889g.removeOnScrollListener(this.u);
            this.f51889g.addOnScrollListener(this.u);
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    public void insertOneThread(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c2Var) == null) {
            t();
            this.k.B(c2Var);
        }
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.f0.g gVar = this.m;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void notifyListViewDataSetChanged() {
        c.a.q0.f1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f51890h) == null) {
            return;
        }
        aVar.d();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.r != i2) {
                ConcernNotLoginLayout concernNotLoginLayout = this.l;
                if (concernNotLoginLayout != null) {
                    concernNotLoginLayout.onChangeSkinType(i2);
                }
                c.a.p0.f0.g gVar = this.m;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                c.a.p0.f0.h hVar = this.n;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                c.a.q0.f1.h.i.a aVar = this.f51887e;
                if (aVar != null) {
                    aVar.D(i2);
                }
                PbListView pbListView = this.f51888f;
                if (pbListView != null) {
                    pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                    this.f51888f.d(i2);
                }
                NoDataView noDataView = this.o;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    this.o.onChangeSkinType(this.f51891i, i2);
                    this.o.setSubTitleTextColor(R.color.CAM_X0105);
                }
                PublishProgressView publishProgressView = this.p;
                if (publishProgressView != null) {
                    publishProgressView.onChangeSkinType();
                }
                this.f51890h.e(i2);
            }
            this.r = i2;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.v);
            }
            this.f51889g.removeOnScrollListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.B);
            this.k.Z(null);
            this.f51887e.a(null);
            this.f51887e.b(null);
            this.f51889g.setOnSrollToBottomListener(null);
            this.f51887e.h(null);
            this.f51887e.T();
            this.f51889g.setRecyclerListener(null);
            this.k.M();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setTabInForeBackgroundState(false);
            notifyListViewDataSetChanged();
        }
    }

    public void onScreenSizeChange() {
        c.a.q0.f1.c.a aVar;
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f51890h) == null) {
            return;
        }
        List<n> a2 = aVar.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (n nVar : a2) {
            if (nVar instanceof c.a.q0.a0.d0.k) {
                c.a.q0.a0.d0.k kVar = (c.a.q0.a0.d0.k) nVar;
                if (kVar.o != 0 && (c2Var = kVar.f15245e) != null) {
                    int[] g0 = c2Var.g0();
                    kVar.o = g0[0];
                    kVar.p = g0[1];
                }
            }
        }
        c.a.e.e.m.e.a().postDelayed(new b(this), 500L);
    }

    public void onViewBackGround() {
        c.a.q0.f1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.K(true);
    }

    public final void r() {
        c.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (gVar = this.m) == null) {
            return;
        }
        gVar.dettachView(this);
        this.m = null;
    }

    public boolean recyclerViewIsAtTop(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void redDotLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                z();
                return;
            }
            c.a.q0.f1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.R();
            }
        }
    }

    public void reload() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bdTypeRecyclerView = this.f51889g) == null || this.w == null) {
            return;
        }
        if (this.q && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.q = false;
            return;
        }
        this.f51889g.setSelection(0);
        if (!this.w.isRefreshing()) {
            NoDataView noDataView = this.o;
            if (noDataView != null && noDataView.getVisibility() == 0) {
                if (TbadkCoreApplication.isLogin()) {
                    this.k.d0();
                }
            } else {
                this.w.setRefreshing(true);
            }
        }
        if (!this.w.isRefreshing()) {
            this.w.setRefreshing(true);
        }
        ScrollFragmentTabHost.s sVar = this.v;
        if (sVar != null) {
            sVar.a();
        }
    }

    public final void s() {
        c.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this);
        this.n = null;
    }

    public void setCallback(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, lVar) == null) {
            this.f51892j = lVar;
        }
    }

    public void setHeaderViewHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bdUniqueId) == null) {
            c.a.q0.f1.c.a aVar = this.f51890h;
            if (aVar != null) {
                aVar.h(bdUniqueId);
            }
            c.a.q0.f1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.c0(bdUniqueId);
            }
            c.a.q0.f1.h.i.a aVar2 = this.f51887e;
            if (aVar2 != null) {
                aVar2.V(bdUniqueId);
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

    public void setRecommendFrsNavigationAnimDispatcher(d0 d0Var) {
        c.a.q0.f1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, d0Var) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.a0(d0Var);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, scrollFragmentTabHost) == null) {
            this.s = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.v);
                this.s.addShadowChangeListener(this.v);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        c.a.q0.f1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.b0(z);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            setViewForeground(false);
            c.a.q0.f1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.K(false);
            }
        }
    }

    public void showListViewNoLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.w.setVisibility(0);
            this.f51889g.setVisibility(0);
            this.f51888f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f51888f.r(0);
        }
    }

    public void showListViewWithLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.w.setVisibility(0);
            this.f51889g.setVisibility(0);
            if (this.k.A()) {
                this.f51888f.O();
            } else {
                this.f51888f.g();
            }
            this.f51888f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f51888f.r(c.a.e.e.p.l.g(getContext(), R.dimen.tbds150));
        }
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || v()) {
            return;
        }
        if (this.n == null) {
            this.n = new c.a.p0.f0.h(getContext(), new h(this));
        }
        this.n.attachView(this, z);
        this.n.o();
    }

    public final void t() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (noDataView = this.o) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f51889g = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f51889g.setFadingEdgeLength(0);
            this.f51889g.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f51889g.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.w = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.f51889g);
            PbListView pbListView = new PbListView(context);
            this.f51888f = pbListView;
            pbListView.a();
            this.f51888f.o(R.color.transparent);
            this.f51888f.v();
            this.f51888f.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f51888f.E(R.dimen.tbfontsize33);
            this.f51888f.y(R.color.CAM_X0110);
            this.f51888f.z(this.y);
            this.f51889g.setNextPage(this.f51888f);
            c.a.e.a.f<?> a2 = c.a.e.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f51891i = (TbPageContext) a2;
            }
            addView(this.w);
            c.a.q0.f1.h.i.a aVar = new c.a.q0.f1.h.i.a(this.f51891i);
            this.f51887e = aVar;
            aVar.w(true);
            this.w.setProgressView(this.f51887e);
            int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
            this.w.setCustomDistances(i2, i2, i2 * 2);
            c.a.q0.f1.c.a aVar2 = new c.a.q0.f1.c.a(context, this.f51889g);
            this.f51890h = aVar2;
            this.k = new c.a.q0.f1.c.d(this.f51891i, this.f51889g, aVar2, this.w);
            this.w.setVisibility(8);
            PublishProgressView publishProgressView = new PublishProgressView(context);
            this.p = publishProgressView;
            addView(publishProgressView, new FrameLayout.LayoutParams(-1, c.a.e.e.p.l.g(getContext(), R.dimen.tbds83)));
            this.p.setVisibility(8);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void updateData(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048605, this, dataRes, z) == null) {
            this.k.N(z, dataRes, 0, null);
        }
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, str, i2) == null) {
            this.k.N(true, null, i2, str);
        }
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            c.a.p0.f0.h hVar = this.n;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        c.a.q0.f1.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.H();
    }

    public final void x(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.m == null) {
            this.m = new c.a.p0.f0.g(getContext());
            this.m.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + c.a.e.e.p.l.g(getContext(), R.dimen.tbds60));
            this.m.h();
            this.m.setWrapStyle(true);
        }
        this.m.onChangeSkinType();
        this.m.attachView(this, z);
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            int k2 = c.a.p0.s.d0.b.j().k("key_home_concern_all_status", 0);
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
            this.o.onChangeSkinType(this.f51891i, TbadkCoreApplication.getInst().getSkinType());
            this.o.setVisibility(0);
            this.o.bringToFront();
        }
    }

    public final void z() {
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
            this.w.setVisibility(8);
            this.l.setVisibility(0);
            addView(this.l);
        }
    }

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            c.a.q0.f1.c.d dVar = this.k;
            if (dVar != null) {
                dVar.O(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.v);
                this.s.addShadowChangeListener(this.v);
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
        u(context);
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
        u(context);
    }
}
