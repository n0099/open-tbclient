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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.repackage.b9;
import com.repackage.bu6;
import com.repackage.cu4;
import com.repackage.f9;
import com.repackage.fy5;
import com.repackage.g45;
import com.repackage.h45;
import com.repackage.iz6;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.oi5;
import com.repackage.pg;
import com.repackage.uo;
import com.repackage.vb5;
import com.repackage.vt4;
import com.repackage.ym8;
import com.repackage.yt6;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes3.dex */
public class ConcernPageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iz6 a;
    public PbListView b;
    public BdTypeRecyclerView c;
    public yt6 d;
    public TbPageContext<?> e;
    public l f;
    public bu6 g;
    public ConcernNotLoginLayout h;
    public g45 i;
    public h45 j;
    public NoDataView k;
    public PublishProgressView l;
    public boolean m;
    public int n;
    public ScrollFragmentTabHost o;
    public int p;
    public boolean q;
    public RecyclerView.OnScrollListener r;
    public ScrollFragmentTabHost.v s;
    public BigdaySwipeRefreshLayout t;
    public bu6.o u;
    public View.OnClickListener v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public final CustomMessageListener y;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernPageView concernPageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView, Integer.valueOf(i)};
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
            this.a = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PublishProgressData publishProgressData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof PublishProgressData) || (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) == null || ym8.k().s() || ym8.k().i() == null || this.a.l == null) {
                return;
            }
            this.a.l.c(publishProgressData);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public b(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernPageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null) {
                return;
            }
            this.a.d.d();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public c(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernPageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) || this.a.p == i || this.a.o == null) {
                return;
            }
            this.a.p = i;
            if (this.a.p == 1) {
                this.a.o.X();
            } else if (this.a.J(recyclerView)) {
                this.a.o.B();
            } else {
                this.a.o.X();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ScrollFragmentTabHost.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public d(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernPageView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.v
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.o == null) {
                return;
            }
            this.a.p = -1;
            ConcernPageView concernPageView = this.a;
            if (concernPageView.J(concernPageView.c)) {
                this.a.o.B();
            } else {
                this.a.o.X();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements bu6.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public e(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernPageView;
        }

        @Override // com.repackage.bu6.o
        public void a(vb5 vb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vb5Var) == null) {
                this.a.u();
                this.a.v();
                this.a.c.setSelection(0);
                if (this.a.c.getCount() > 0) {
                    this.a.t();
                    this.a.M();
                } else {
                    this.a.O(true);
                }
                if (this.a.f != null) {
                    this.a.f.b(vb5Var);
                }
            }
        }

        @Override // com.repackage.bu6.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.f != null) {
                    this.a.f.a(true, false);
                }
                this.a.t();
                this.a.u();
                this.a.c.setVisibility(8);
                this.a.Q();
            }
        }

        @Override // com.repackage.bu6.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.f != null) {
                    this.a.f.a(z, z2);
                }
                this.a.t();
                this.a.u();
                this.a.v();
                if (this.a.g.C()) {
                    this.a.M();
                } else {
                    this.a.N();
                }
            }
        }

        @Override // com.repackage.bu6.o
        public void d(String str, vb5 vb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, vb5Var) == null) {
                this.a.u();
                this.a.v();
                this.a.t();
                this.a.N();
                if (this.a.f != null) {
                    this.a.f.c(str, vb5Var);
                }
            }
        }

        @Override // com.repackage.bu6.o
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                if (this.a.f != null) {
                    this.a.f.a(false, false);
                }
                this.a.t();
                this.a.v();
                if (i != 1) {
                    this.a.c.setVisibility(8);
                    this.a.P(true);
                } else if (mi.z()) {
                    this.a.e.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements cu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public f(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernPageView;
        }

        @Override // com.repackage.cu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                oi5.c().f("page_concern");
                this.a.g.update();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public g(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernPageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public h(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null && mi.A() && TbadkCoreApplication.isLogin()) {
                this.a.g.update();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public i(ConcernPageView concernPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.C();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ConcernPageView concernPageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView, Integer.valueOf(i)};
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
            this.a = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.m = true;
            this.a.L();
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ConcernPageView concernPageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView, Integer.valueOf(i)};
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
            this.a = concernPageView;
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
                this.a.g.p();
            } else {
                this.a.g.Q();
            }
            if (this.a.k == null) {
                return;
            }
            if (intValue == 1) {
                this.a.k.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f041a)));
            } else {
                this.a.k.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0419)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(boolean z, boolean z2);

        void b(vb5 vb5Var);

        void c(String str, vb5 vb5Var);
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
        this.m = false;
        this.n = 3;
        this.p = -1;
        this.q = false;
        this.r = new c(this);
        this.s = new d(this);
        this.u = new e(this);
        this.v = new i(this);
        this.w = new j(this, 2921058);
        this.x = new k(this, 2921502);
        this.y = new a(this, 2921526);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g45 g45Var = this.i;
            if (g45Var != null) {
                return g45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h45 h45Var = this.j;
            if (h45Var != null) {
                return h45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void C() {
        bu6 bu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bu6Var = this.g) == null) {
            return;
        }
        bu6Var.F();
    }

    public void D() {
        yt6 yt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (yt6Var = this.d) == null) {
            return;
        }
        yt6Var.d();
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (this.n != i2) {
                ConcernNotLoginLayout concernNotLoginLayout = this.h;
                if (concernNotLoginLayout != null) {
                    concernNotLoginLayout.b(i2);
                }
                g45 g45Var = this.i;
                if (g45Var != null) {
                    g45Var.onChangeSkinType();
                }
                h45 h45Var = this.j;
                if (h45Var != null) {
                    h45Var.onChangeSkinType();
                }
                iz6 iz6Var = this.a;
                if (iz6Var != null) {
                    iz6Var.H(i2);
                }
                PbListView pbListView = this.b;
                if (pbListView != null) {
                    pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                    this.b.d(i2);
                }
                NoDataView noDataView = this.k;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    this.k.f(this.e, i2);
                    this.k.setSubTitleTextColor(R.color.CAM_X0105);
                }
                PublishProgressView publishProgressView = this.l;
                if (publishProgressView != null) {
                    publishProgressView.b();
                }
                this.d.e(i2);
            }
            this.n = i2;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.o;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.T(this.s);
            }
            this.c.removeOnScrollListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.y);
            this.g.X(null);
            this.a.f(null);
            this.a.g(null);
            this.c.setOnSrollToBottomListener(null);
            this.a.m(null);
            this.a.Y();
            this.c.setRecyclerListener(null);
            this.g.K();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setTabInForeBackgroundState(false);
            D();
        }
    }

    public void H() {
        yt6 yt6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (yt6Var = this.d) == null) {
            return;
        }
        List<uo> a2 = yt6Var.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (uo uoVar : a2) {
            if (uoVar instanceof fy5) {
                fy5 fy5Var = (fy5) uoVar;
                if (fy5Var.j != 0 && (threadData = fy5Var.a) != null) {
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    fy5Var.j = imageWidthAndHeight[0];
                    fy5Var.k = imageWidthAndHeight[1];
                }
            }
        }
        pg.a().postDelayed(new b(this), 500L);
    }

    public void I() {
        bu6 bu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bu6Var = this.g) == null) {
            return;
        }
        bu6Var.I(true);
    }

    public boolean J(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                R();
                return;
            }
            bu6 bu6Var = this.g;
            if (bu6Var != null) {
                bu6Var.P();
            }
        }
    }

    public void L() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.c) == null || this.t == null) {
            return;
        }
        if (this.m && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.m = false;
            return;
        }
        this.c.setSelection(0);
        if (!this.t.t()) {
            NoDataView noDataView = this.k;
            if (noDataView != null && noDataView.getVisibility() == 0) {
                if (TbadkCoreApplication.isLogin()) {
                    this.g.update();
                }
            } else {
                this.t.setRefreshing(true);
            }
        }
        if (!this.t.t()) {
            this.t.setRefreshing(true);
        }
        ScrollFragmentTabHost.v vVar = this.s;
        if (vVar != null) {
            vVar.a();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.t.setVisibility(0);
            this.c.setVisibility(0);
            this.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.t(0);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.t.setVisibility(0);
            this.c.setVisibility(0);
            if (this.g.y()) {
                this.b.Q();
            } else {
                this.b.g();
            }
            this.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.t(oi.f(getContext(), R.dimen.tbds150));
        }
    }

    public final void O(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || A()) {
            return;
        }
        if (this.i == null) {
            this.i = new g45(getContext());
            this.i.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + oi.f(getContext(), R.dimen.tbds60));
            this.i.i();
            this.i.setWrapStyle(true);
        }
        this.i.onChangeSkinType();
        this.i.attachView(this, z);
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || B()) {
            return;
        }
        if (this.j == null) {
            this.j = new h45(getContext(), new h(this));
        }
        this.j.attachView(this, z);
        this.j.p();
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int l2 = vt4.k().l("key_home_concern_all_status", 0);
            if (this.k == null) {
                this.k = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0419)), null);
            }
            if (l2 == 1) {
                this.k.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f041a)));
                this.k.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.GIFT));
            } else {
                this.k.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0419)));
                this.k.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL));
            }
            this.k.f(this.e, TbadkCoreApplication.getInst().getSkinType());
            this.k.setVisibility(0);
            this.k.bringToFront();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.h == null) {
                ConcernNotLoginLayout concernNotLoginLayout = new ConcernNotLoginLayout(getContext());
                this.h = concernNotLoginLayout;
                concernNotLoginLayout.b(this.n);
            }
            if (this.h.getParent() != null) {
                return;
            }
            this.t.setVisibility(8);
            this.h.setVisibility(0);
            addView(this.h);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || UbsABTestHelper.isLaunchUpA()) {
            return;
        }
        addView(this.t);
        addView(this.l, new FrameLayout.LayoutParams(-1, oi.f(getContext(), R.dimen.tbds83)));
    }

    public void T(DataRes dataRes, boolean z) {
        bu6 bu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048595, this, dataRes, z) == null) || (bu6Var = this.g) == null) {
            return;
        }
        bu6Var.L(z, dataRes, 0, null);
    }

    public void U(String str, int i2) {
        bu6 bu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048596, this, str, i2) == null) || (bu6Var = this.g) == null) {
            return;
        }
        bu6Var.L(true, null, i2, str);
    }

    public void r() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bigdaySwipeRefreshLayout = this.t) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.r();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                R();
                return;
            }
            bu6 bu6Var = this.g;
            if (bu6Var != null) {
                bu6Var.update();
                O(true);
            }
        }
    }

    public void setCallback(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, lVar) == null) {
            this.f = lVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            yt6 yt6Var = this.d;
            if (yt6Var != null) {
                yt6Var.h(bdUniqueId);
            }
            bu6 bu6Var = this.g;
            if (bu6Var != null) {
                bu6Var.Z(bdUniqueId);
            }
            iz6 iz6Var = this.a;
            if (iz6Var != null) {
                iz6Var.a0(bdUniqueId);
            }
            CustomMessageListener customMessageListener = this.w;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.w);
            }
            CustomMessageListener customMessageListener2 = this.x;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.x);
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, scrollFragmentTabHost) == null) {
            this.o = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.T(this.s);
                this.o.y(this.s);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        bu6 bu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (bu6Var = this.g) == null) {
            return;
        }
        bu6Var.Y(z);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            setViewForeground(false);
            bu6 bu6Var = this.g;
            if (bu6Var != null) {
                bu6Var.I(false);
            }
        }
    }

    public final void t() {
        g45 g45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (g45Var = this.i) == null) {
            return;
        }
        g45Var.dettachView(this);
        this.i = null;
    }

    public final void u() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (h45Var = this.j) == null) {
            return;
        }
        h45Var.dettachView(this);
        this.j = null;
    }

    public final void v() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (noDataView = this.k) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public void w(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, context) == null) || context == null) {
            return;
        }
        this.q = true;
        BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
        this.c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.c.setFadingEdgeLength(0);
        this.c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.t = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.c);
        PbListView pbListView = new PbListView(context);
        this.b = pbListView;
        pbListView.a();
        this.b.p(R.color.transparent);
        this.b.x();
        this.b.E(SkinManager.getColor(R.color.CAM_X0107));
        this.b.G(R.dimen.tbfontsize33);
        this.b.A(R.color.CAM_X0110);
        this.b.B(this.v);
        this.c.setNextPage(this.b);
        b9<?> a2 = f9.a(context);
        if (a2 instanceof TbPageContext) {
            this.e = (TbPageContext) a2;
        }
        if (UbsABTestHelper.isLaunchUpA()) {
            addView(this.t);
        }
        iz6 iz6Var = new iz6(this.e);
        this.a = iz6Var;
        iz6Var.A(true);
        this.t.setProgressView(this.a);
        int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
        this.t.setCustomDistances(i2, i2, i2 * 2);
        yt6 yt6Var = new yt6(context, this.c);
        this.d = yt6Var;
        this.g = new bu6(this.e, this.c, yt6Var, this.t);
        this.t.setVisibility(8);
        this.l = new PublishProgressView(context);
        if (UbsABTestHelper.isLaunchUpA()) {
            addView(this.l, new FrameLayout.LayoutParams(-1, oi.f(getContext(), R.dimen.tbds83)));
        }
        this.l.setVisibility(8);
        E(TbadkCoreApplication.getInst().getSkinType());
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.g.X(this.u);
            this.a.f(new f(this));
            this.c.setOnSrollToBottomListener(new g(this));
            this.c.removeOnScrollListener(this.r);
            this.c.addOnScrollListener(this.r);
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    public void y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, threadData) == null) {
            v();
            this.g.z(threadData);
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            bu6 bu6Var = this.g;
            if (bu6Var != null) {
                bu6Var.M(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.o;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.T(this.s);
                this.o.y(this.s);
                this.s.a();
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
        this.m = false;
        this.n = 3;
        this.p = -1;
        this.q = false;
        this.r = new c(this);
        this.s = new d(this);
        this.u = new e(this);
        this.v = new i(this);
        this.w = new j(this, 2921058);
        this.x = new k(this, 2921502);
        this.y = new a(this, 2921526);
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
        this.m = false;
        this.n = 3;
        this.p = -1;
        this.q = false;
        this.r = new c(this);
        this.s = new d(this);
        this.u = new e(this);
        this.v = new i(this);
        this.w = new j(this, 2921058);
        this.x = new k(this, 2921502);
        this.y = new a(this, 2921526);
    }
}
