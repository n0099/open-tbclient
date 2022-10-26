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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.ah5;
import com.baidu.tieba.ax6;
import com.baidu.tieba.e36;
import com.baidu.tieba.eo;
import com.baidu.tieba.ey4;
import com.baidu.tieba.fj;
import com.baidu.tieba.hh;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.j95;
import com.baidu.tieba.k95;
import com.baidu.tieba.lp8;
import com.baidu.tieba.my6;
import com.baidu.tieba.q27;
import com.baidu.tieba.r9;
import com.baidu.tieba.u19;
import com.baidu.tieba.ux4;
import com.baidu.tieba.w9;
import com.baidu.tieba.xw6;
import com.baidu.tieba.yo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernPageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public q27 a;
    public PbListView b;
    public BdTypeRecyclerView c;
    public xw6 d;
    public TbPageContext e;
    public o f;
    public ax6 g;
    public ConcernNotLoginLayout h;
    public j95 i;
    public k95 j;
    public NoDataView k;
    public PublishProgressView l;
    public boolean m;
    public int n;
    public ScrollFragmentTabHost o;
    public int p;
    public boolean q;
    public my6 r;
    public u19 s;
    public RecyclerView.OnScrollListener t;
    public ScrollFragmentTabHost.u u;
    public BigdaySwipeRefreshLayout v;
    public ax6.o w;
    public View.OnClickListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public interface o {
        void a(boolean z, boolean z2);

        void b(ah5 ah5Var);

        void c(String str, ah5 ah5Var);
    }

    /* loaded from: classes4.dex */
    public class h implements ax6.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.s != null) {
                    this.a.a.s.g();
                }
            }
        }

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

        @Override // com.baidu.tieba.ax6.o
        public void a(ah5 ah5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ah5Var) != null) {
                return;
            }
            this.a.x();
            this.a.y();
            this.a.c.setSelection(0);
            if (this.a.c.getCount() > 0) {
                this.a.w();
                this.a.T();
            } else {
                this.a.V(true);
            }
            if (this.a.f != null) {
                this.a.f.b(ah5Var);
            }
        }

        @Override // com.baidu.tieba.ax6.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.f != null) {
                    this.a.f.a(true, false);
                }
                this.a.w();
                this.a.x();
                this.a.c.setVisibility(8);
                this.a.r.q(false);
                this.a.X();
            }
        }

        @Override // com.baidu.tieba.ax6.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.f != null) {
                    this.a.f.a(z, z2);
                }
                if (!this.a.D() && this.a.s != null) {
                    hh.a().postDelayed(new a(this), 300L);
                }
                if (this.a.s != null) {
                    this.a.s.i(2000);
                }
                this.a.w();
                this.a.x();
                this.a.y();
                if (this.a.g.C()) {
                    this.a.T();
                } else {
                    this.a.U();
                }
            }
        }

        @Override // com.baidu.tieba.ax6.o
        public void d(String str, ah5 ah5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, ah5Var) == null) {
                this.a.x();
                this.a.y();
                this.a.w();
                this.a.U();
                if (this.a.f != null) {
                    this.a.f.c(str, ah5Var);
                }
            }
        }

        @Override // com.baidu.tieba.ax6.o
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                if (this.a.f != null) {
                    this.a.f.a(false, false);
                }
                this.a.w();
                this.a.y();
                if (i == 1) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.e.showToast(str);
                        return;
                    }
                    return;
                }
                this.a.c.setVisibility(8);
                this.a.r.q(false);
                this.a.W(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public a(ConcernPageView concernPageView) {
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.H();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ConcernPageView concernPageView, int i) {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.m = true;
            this.a.S();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ConcernPageView concernPageView, int i) {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
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
                    this.a.k.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0436)));
                } else {
                    this.a.k.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0435)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ConcernPageView concernPageView, int i) {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            PublishProgressData publishProgressData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof PublishProgressData) && (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) != null && !lp8.k().s() && lp8.k().i() != null && this.a.l != null) {
                this.a.l.c(publishProgressData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d != null) {
                    this.a.d.d();
                }
                this.a.I();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i == 0 && this.a.s != null) {
                    this.a.s.i(100);
                }
                if (i == 1 && this.a.s != null) {
                    this.a.s.d();
                }
                if (this.a.s != null && !this.a.D()) {
                    this.a.s.g();
                }
                if (this.a.p == i || this.a.o == null) {
                    return;
                }
                this.a.p = i;
                if (this.a.p == 1) {
                    this.a.o.a();
                } else if (this.a.Q(recyclerView)) {
                    this.a.o.c();
                } else {
                    this.a.o.a();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (this.a.r != null) {
                    this.a.r.j();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends ScrollFragmentTabHost.u {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.u
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.o == null) {
                return;
            }
            this.a.p = -1;
            ConcernPageView concernPageView = this.a;
            if (concernPageView.Q(concernPageView.c)) {
                this.a.o.c();
            } else {
                this.a.o.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ey4.g {
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

        @Override // com.baidu.tieba.ey4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                yo5.c().f("page_concern");
                this.a.g.update();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements ey4.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public j(ConcernPageView concernPageView) {
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

        @Override // com.baidu.tieba.ey4.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.s != null) {
                this.a.s.h(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ey4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public k(ConcernPageView concernPageView) {
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

        @Override // com.baidu.tieba.ey4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (this.a.s != null) {
                    this.a.s.h(false);
                }
                if (this.a.s != null) {
                    this.a.s.i(2000);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public l(ConcernPageView concernPageView) {
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.H();
        }
    }

    /* loaded from: classes4.dex */
    public class m implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public m(ConcernPageView concernPageView) {
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

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.a.s != null) {
                    this.a.s.e(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public n(ConcernPageView concernPageView) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null && BdNetTypeUtil.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                this.a.g.update();
            }
        }
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
        this.t = new f(this);
        this.u = new g(this);
        this.w = new h(this);
        this.x = new a(this);
        this.y = new b(this, 2921058);
        this.z = new c(this, 2921502);
        this.A = new d(this, 2921526);
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.n != i2) {
                ConcernNotLoginLayout concernNotLoginLayout = this.h;
                if (concernNotLoginLayout != null) {
                    concernNotLoginLayout.b(i2);
                }
                j95 j95Var = this.i;
                if (j95Var != null) {
                    j95Var.onChangeSkinType();
                }
                k95 k95Var = this.j;
                if (k95Var != null) {
                    k95Var.onChangeSkinType();
                }
                q27 q27Var = this.a;
                if (q27Var != null) {
                    q27Var.H(i2);
                }
                PbListView pbListView = this.b;
                if (pbListView != null) {
                    pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
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
                my6 my6Var = this.r;
                if (my6Var != null) {
                    my6Var.n();
                }
                u19 u19Var = this.s;
                if (u19Var != null) {
                    u19Var.i(2000);
                }
            }
            this.n = i2;
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
        this.t = new f(this);
        this.u = new g(this);
        this.w = new h(this);
        this.x = new a(this);
        this.y = new b(this, 2921058);
        this.z = new c(this, 2921502);
        this.A = new d(this, 2921526);
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
        this.t = new f(this);
        this.u = new g(this);
        this.w = new h(this);
        this.x = new a(this);
        this.y = new b(this, 2921058);
        this.z = new c(this, 2921502);
        this.A = new d(this, 2921526);
    }

    public void B(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            C(threadData, false);
        }
    }

    public boolean Q(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, recyclerView)) == null) {
            if (recyclerView == null || !recyclerView.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setCallback(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, oVar) == null) {
            this.f = oVar;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, scrollFragmentTabHost) == null) {
            this.o = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.u);
                this.o.b(this.u);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        ax6 ax6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048607, this, z) == null) && (ax6Var = this.g) != null) {
            ax6Var.Y(z);
        }
    }

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            ax6 ax6Var = this.g;
            if (ax6Var != null) {
                ax6Var.M(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.o;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.u);
                this.o.b(this.u);
                this.u.a();
            }
        }
    }

    public void C(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, threadData, z) == null) {
            y();
            this.g.z(threadData, z);
        }
    }

    public void a0(DataRes dataRes, boolean z) {
        ax6 ax6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048602, this, dataRes, z) == null) && (ax6Var = this.g) != null) {
            ax6Var.L(z, dataRes, 0, null);
        }
    }

    public void b0(String str, int i2) {
        ax6 ax6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048603, this, str, i2) == null) && (ax6Var = this.g) != null) {
            ax6Var.L(true, null, i2, str);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.X(this.w);
            this.a.f(new i(this));
            this.a.g(new j(this));
            this.a.m(new k(this));
            this.c.setOnSrollToBottomListener(new l(this));
            this.c.removeOnScrollListener(this.t);
            this.c.addOnScrollListener(this.t);
            this.c.setRecyclerListener(new m(this));
            MessageManager.getInstance().registerListener(this.A);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.o;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.u);
            }
            this.c.removeOnScrollListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.A);
            this.g.X(null);
            this.a.f(null);
            this.a.g(null);
            this.c.setOnSrollToBottomListener(null);
            this.a.m(null);
            this.a.Z();
            this.c.setRecyclerListener(null);
            this.g.K();
        }
    }

    public void O() {
        xw6 xw6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || (xw6Var = this.d) == null) {
            return;
        }
        List<eo> a2 = xw6Var.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (eo eoVar : a2) {
            if (eoVar instanceof e36) {
                e36 e36Var = (e36) eoVar;
                if (e36Var.j != 0 && (threadData = e36Var.a) != null) {
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    e36Var.j = imageWidthAndHeight[0];
                    e36Var.k = imageWidthAndHeight[1];
                }
            }
        }
        hh.a().postDelayed(new e(this), 500L);
    }

    public void S() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (bdTypeRecyclerView = this.c) != null && this.v != null) {
            if (this.m && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                this.m = false;
                return;
            }
            this.c.setSelection(0);
            if (!this.v.t()) {
                NoDataView noDataView = this.k;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.g.update();
                    }
                } else {
                    this.v.setRefreshing(true);
                }
            }
            if (!this.v.t()) {
                this.v.setRefreshing(true);
            }
            ScrollFragmentTabHost.u uVar = this.u;
            if (uVar != null) {
                uVar.a();
            }
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.v.setVisibility(0);
            this.c.setVisibility(0);
            this.r.q(true);
            if (this.g.y()) {
                this.b.R();
            } else {
                this.b.g();
            }
            this.b.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.t(fj.f(getContext(), R.dimen.tbds150));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ux4.k().h("key_reaction_guide_show_number", false);
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            j95 j95Var = this.i;
            if (j95Var != null) {
                return j95Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            k95 k95Var = this.j;
            if (k95Var != null) {
                return k95Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void H() {
        ax6 ax6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (ax6Var = this.g) == null) {
            return;
        }
        ax6Var.F();
    }

    public void I() {
        my6 my6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (my6Var = this.r) != null) {
            my6Var.f();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            xw6 xw6Var = this.d;
            if (xw6Var != null) {
                xw6Var.d();
            }
            I();
        }
    }

    public void M() {
        u19 u19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (u19Var = this.s) != null) {
            u19Var.i(2000);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            setTabInForeBackgroundState(false);
            J();
        }
    }

    public void P() {
        ax6 ax6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (ax6Var = this.g) != null) {
            ax6Var.I(true);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                Y();
                return;
            }
            ax6 ax6Var = this.g;
            if (ax6Var != null) {
                ax6Var.P();
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            setViewForeground(false);
            ax6 ax6Var = this.g;
            if (ax6Var != null) {
                ax6Var.I(false);
            }
        }
    }

    public void u() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (bigdaySwipeRefreshLayout = this.v) != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                Y();
                return;
            }
            ax6 ax6Var = this.g;
            if (ax6Var != null) {
                ax6Var.update();
                V(true);
            }
        }
    }

    public final void w() {
        j95 j95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (j95Var = this.i) != null) {
            j95Var.dettachView(this);
            this.i = null;
        }
    }

    public final void x() {
        k95 k95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (k95Var = this.j) != null) {
            k95Var.dettachView(this);
            this.j = null;
        }
    }

    public final void y() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (noDataView = this.k) != null) {
            noDataView.setVisibility(8);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.v.setVisibility(0);
            this.c.setVisibility(0);
            this.r.q(true);
            this.b.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.t(0);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.h == null) {
                ConcernNotLoginLayout concernNotLoginLayout = new ConcernNotLoginLayout(getContext());
                this.h = concernNotLoginLayout;
                concernNotLoginLayout.b(this.n);
            }
            if (this.h.getParent() != null) {
                return;
            }
            this.v.setVisibility(8);
            this.r.q(false);
            this.h.setVisibility(0);
            addView(this.h);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && !UbsABTestHelper.isLaunchUpA()) {
            addView(this.r.k(), 0);
            addView(this.v);
            addView(this.l, new FrameLayout.LayoutParams(-1, fj.f(getContext(), R.dimen.tbds83)));
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048597, this, z) != null) || F()) {
            return;
        }
        if (this.i == null) {
            this.i = new j95(getContext());
            this.i.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + fj.f(getContext(), R.dimen.tbds60));
            this.i.i();
            this.i.setWrapStyle(true);
        }
        this.i.onChangeSkinType();
        this.i.attachView(this, z);
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048598, this, z) != null) || G()) {
            return;
        }
        if (this.j == null) {
            this.j = new k95(getContext(), new n(this));
        }
        this.j.attachView(this, z);
        this.j.p();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bdUniqueId) == null) {
            xw6 xw6Var = this.d;
            if (xw6Var != null) {
                xw6Var.h(bdUniqueId);
            }
            ax6 ax6Var = this.g;
            if (ax6Var != null) {
                ax6Var.Z(bdUniqueId);
            }
            q27 q27Var = this.a;
            if (q27Var != null) {
                q27Var.b0(bdUniqueId);
            }
            CustomMessageListener customMessageListener = this.y;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.y);
            }
            CustomMessageListener customMessageListener2 = this.z;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.z);
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            int l2 = ux4.k().l("key_home_concern_all_status", 0);
            if (this.k == null) {
                this.k = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0435)), null);
            }
            if (l2 == 1) {
                this.k.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0436)));
                this.k.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.GIFT));
            } else {
                this.k.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0435)));
                this.k.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL));
            }
            this.k.f(this.e, TbadkCoreApplication.getInst().getSkinType());
            this.k.setVisibility(0);
            this.k.bringToFront();
        }
    }

    public void z(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, context) != null) || context == null) {
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
        my6 my6Var = new my6(this, this.c);
        this.r = my6Var;
        my6Var.p(context.getString(R.string.obfuscated_res_0x7f0f1380));
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.v = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.c);
        PbListView pbListView = new PbListView(context);
        this.b = pbListView;
        pbListView.a();
        this.b.p(R.color.transparent);
        this.b.y();
        this.b.F(SkinManager.getColor(R.color.CAM_X0107));
        this.b.H(R.dimen.tbfontsize33);
        this.b.B(R.color.CAM_X0110);
        this.b.C(this.x);
        this.c.setNextPage(this.b);
        r9 a2 = w9.a(context);
        if (a2 instanceof TbPageContext) {
            this.e = (TbPageContext) a2;
        }
        this.r.o(this.e);
        if (UbsABTestHelper.isLaunchUpA()) {
            addView(this.v);
        }
        q27 q27Var = new q27(this.e);
        this.a = q27Var;
        q27Var.A(true);
        this.v.setProgressView(this.a);
        int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
        this.v.setCustomDistances(i2, i2, i2 * 2);
        xw6 xw6Var = new xw6(context, this.c);
        this.d = xw6Var;
        this.g = new ax6(this.e, this.c, xw6Var, this.v);
        this.v.setVisibility(8);
        this.r.q(false);
        this.l = new PublishProgressView(context);
        if (UbsABTestHelper.isLaunchUpA()) {
            addView(this.l, new FrameLayout.LayoutParams(-1, fj.f(getContext(), R.dimen.tbds83)));
        }
        this.l.setVisibility(8);
        K(TbadkCoreApplication.getInst().getSkinType());
        if (this.s == null) {
            this.s = new u19(this.e, this.c);
        }
    }
}
