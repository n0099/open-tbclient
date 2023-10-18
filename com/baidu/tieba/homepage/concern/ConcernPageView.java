package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.bv7;
import com.baidu.tieba.cx7;
import com.baidu.tieba.e77;
import com.baidu.tieba.ev7;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.gi5;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.in6;
import com.baidu.tieba.j18;
import com.baidu.tieba.j37;
import com.baidu.tieba.jn6;
import com.baidu.tieba.k4;
import com.baidu.tieba.kn6;
import com.baidu.tieba.l45;
import com.baidu.tieba.mva;
import com.baidu.tieba.o77;
import com.baidu.tieba.oma;
import com.baidu.tieba.p77;
import com.baidu.tieba.q77;
import com.baidu.tieba.rk6;
import com.baidu.tieba.s87;
import com.baidu.tieba.sq5;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.u85;
import com.baidu.tieba.vo6;
import com.baidu.tieba.wo6;
import com.baidu.tieba.wz5;
import com.baidu.tieba.x67;
import com.baidu.tieba.xv7;
import com.baidu.tieba.yh;
import com.baidu.tieba.zo6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.List;
import kotlin.Pair;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class ConcernPageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean G;
    public transient /* synthetic */ FieldHolder $fh;
    public final q77.a A;
    public final CustomMessageListener B;
    public View.OnClickListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final CustomMessageListener F;
    public j18 a;
    public PbListView b;
    public BdRecyclerView c;
    public x67 d;
    public bv7 e;
    public TbPageContext<?> f;
    public s g;
    public ev7 h;
    public in6 i;
    public LoadingView j;
    public gi5 k;
    public NoDataView l;
    public PublishProgressView m;
    public boolean n;
    public int o;
    public ScrollFragmentTabHost p;
    public int q;
    public boolean r;
    public cx7 s;
    public mva t;
    public ConcernFragment u;
    public RecyclerView.OnScrollListener v;
    public BdListView.p w;
    public ScrollFragmentTabHost.s x;
    public BigdaySwipeRefreshLayout y;
    public ev7.o z;

    /* loaded from: classes6.dex */
    public interface s {
        void a(boolean z, boolean z2);

        void b(sq5 sq5Var);

        void c(String str, sq5 sq5Var);
    }

    /* loaded from: classes6.dex */
    public class n implements ev7.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.t != null) {
                    this.a.a.t.g();
                }
            }
        }

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

        @Override // com.baidu.tieba.ev7.o
        public void a(sq5 sq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, sq5Var) != null) {
                return;
            }
            this.a.F();
            this.a.G();
            this.a.c.setSelection(0);
            if (ConcernPageView.G) {
                if (this.a.c.getWrappedAdapter() != null && this.a.c.getWrappedAdapter().getItemCount() > 0) {
                    this.a.E();
                    this.a.e0();
                } else {
                    this.a.g0(true);
                }
            } else if (((BdTypeRecyclerView) this.a.c).getCount() > 0) {
                this.a.E();
                this.a.e0();
            } else {
                this.a.g0(true);
            }
            if (this.a.g != null) {
                this.a.g.b(sq5Var);
            }
        }

        @Override // com.baidu.tieba.ev7.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.g != null) {
                    this.a.g.a(true, false);
                }
                this.a.E();
                this.a.F();
                this.a.c.setVisibility(8);
                this.a.s.r(false);
                this.a.i0();
            }
        }

        @Override // com.baidu.tieba.ev7.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.g != null) {
                    this.a.g.a(z, z2);
                }
                if (!this.a.L() && this.a.t != null) {
                    SafeHandler.getInst().postDelayed(new a(this), 300L);
                }
                if (this.a.t != null) {
                    this.a.t.i(2000);
                }
                this.a.E();
                this.a.F();
                this.a.G();
                if (this.a.h != null && this.a.h.D()) {
                    this.a.e0();
                } else {
                    this.a.f0();
                }
            }
        }

        @Override // com.baidu.tieba.ev7.o
        public void d(String str, sq5 sq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, sq5Var) == null) {
                this.a.F();
                this.a.G();
                this.a.E();
                this.a.f0();
                if (this.a.g != null) {
                    this.a.g.c(str, sq5Var);
                }
            }
        }

        @Override // com.baidu.tieba.ev7.o
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                if (this.a.g != null) {
                    this.a.g.a(false, false);
                }
                this.a.E();
                this.a.G();
                if (i == 1) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.f.showToast(str);
                        return;
                    }
                    return;
                }
                this.a.c.setVisibility(8);
                this.a.s.r(false);
                this.a.h0(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements l45.f {
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

        @Override // com.baidu.tieba.l45.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (this.a.t != null) {
                    this.a.t.h(false);
                }
                if (this.a.t != null) {
                    this.a.t.i(2000);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements RecyclerView.RecyclerListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.a.t != null) {
                    this.a.t.e(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ConcernPageView.G) {
                    this.a.i.s();
                    this.a.F();
                    this.a.g0(true);
                } else if (this.a.h != null && BdNetTypeUtil.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                    this.a.h.b0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ViewHelper.checkUpIsLogin(this.a.getContext());
                HomePageStatic.a = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.Q();
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ConcernPageView concernPageView, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.n = true;
            this.a.d0();
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ConcernPageView concernPageView, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (this.a.h != null) {
                    if (intValue == 1) {
                        this.a.h.p();
                    } else {
                        this.a.h.R();
                    }
                }
                if (this.a.l == null) {
                    return;
                }
                if (intValue == 1) {
                    this.a.l.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f04c2)));
                } else {
                    this.a.l.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f04c1)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ConcernPageView concernPageView, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof PublishProgressData) && (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) != null && !WriteMsgHolder.isFromVideoHotTopic() && WriteMsgHolder.getCurrentWriteActivityFromTag() != null && this.a.m != null) {
                this.a.m.c(publishProgressData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e != null) {
                    this.a.e.d();
                }
                this.a.R();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i == 0 && this.a.t != null) {
                    this.a.t.i(100);
                }
                if (i == 1 && this.a.t != null) {
                    this.a.t.d();
                }
                if (this.a.t != null && !this.a.L()) {
                    this.a.t.g();
                }
                if (this.a.q == i || this.a.p == null) {
                    return;
                }
                this.a.q = i;
                if (this.a.q == 1) {
                    this.a.p.a();
                } else if (this.a.b0(recyclerView)) {
                    this.a.p.c();
                } else {
                    this.a.p.a();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (this.a.s != null) {
                    this.a.s.j();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.Q();
        }
    }

    /* loaded from: classes6.dex */
    public class l extends ScrollFragmentTabHost.s {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.p == null) {
                return;
            }
            this.a.q = -1;
            ConcernPageView concernPageView = this.a;
            if (concernPageView.b0(concernPageView.c)) {
                this.a.p.c();
            } else {
                this.a.p.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends zo6<u85> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ConcernPageView concernPageView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = concernPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zo6
        public void onEvent(@NonNull u85 u85Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, u85Var) != null) || !"recommend_user".equals(u85Var.b())) {
                return;
            }
            this.b.D();
        }
    }

    /* loaded from: classes6.dex */
    public class o implements q77.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public o(ConcernPageView concernPageView) {
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

        @Override // com.baidu.tieba.q77.a
        public void a(j37 j37Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j37Var) == null) {
                this.a.y.setRefreshing(false);
                this.a.E();
                this.a.G();
                if (j37Var == null) {
                    oma.a(this.a.u, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "onDataRes data null"));
                } else if (j37Var.d != 0) {
                    if (ListUtils.isEmpty(j37Var.a)) {
                        this.a.h0(true);
                        oma.a(this.a.u, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "onDataRes data empty, show NetRefreshView"));
                    }
                } else {
                    this.a.F();
                    if (ListUtils.isEmpty(j37Var.a)) {
                        this.a.b.O(8);
                        this.a.i0();
                    } else {
                        this.a.b.O(0);
                        if (j37Var.c) {
                            this.a.f0();
                        } else {
                            this.a.e0();
                        }
                    }
                    oma.c(this.a.u, new Pair[0]);
                    this.a.d.setList(j37Var.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ConcernPageView concernPageView, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || !ConcernPageView.G) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            UpdateAttentionMessage.UpdateAttentionData data = updateAttentionMessage.getData();
            if (data.blockData != null) {
                return;
            }
            if (!data.isSucc) {
                BdToast.makeText(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
            } else if (!data.isAttention && this.a.i != null && !TextUtils.isEmpty(data.toUid) && this.a.i.z(data.toUid)) {
                this.a.i.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements l45.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public q(ConcernPageView concernPageView) {
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

        @Override // com.baidu.tieba.l45.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                wz5.c().f("page_concern");
                if (this.a.h != null) {
                    this.a.h.b0();
                }
                if (this.a.i != null) {
                    this.a.i.s();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements l45.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public r(ConcernPageView concernPageView) {
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

        @Override // com.baidu.tieba.l45.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.t != null) {
                this.a.t.h(true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-416744247, "Lcom/baidu/tieba/homepage/concern/ConcernPageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-416744247, "Lcom/baidu/tieba/homepage/concern/ConcernPageView;");
                return;
            }
        }
        G = O();
    }

    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return UbsABTestHelper.isConcernFeedTest();
        }
        return invokeV.booleanValue;
    }

    public void B() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bigdaySwipeRefreshLayout = this.y) != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                j0();
                return;
            }
            ev7 ev7Var = this.h;
            if (ev7Var != null) {
                ev7Var.b0();
                g0(true);
            }
            in6 in6Var = this.i;
            if (in6Var != null) {
                in6Var.s();
                g0(true);
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new xv7.b().execute(new Integer[0]);
            TiebaStatic.log(new StatisticItem("c13572"));
            in6 in6Var = this.i;
            if (in6Var != null) {
                in6Var.l();
            }
        }
    }

    public final void E() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (loadingView = this.j) != null) {
            loadingView.dettachView(this);
            this.j = null;
        }
    }

    public final void F() {
        gi5 gi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (gi5Var = this.k) != null) {
            gi5Var.dettachView(this);
            this.k = null;
        }
    }

    public final void G() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (noDataView = this.l) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return SharedPrefHelper.getInstance().getBoolean("key_reaction_guide_show_number", false);
        }
        return invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            LoadingView loadingView = this.j;
            if (loadingView != null) {
                return loadingView.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            gi5 gi5Var = this.k;
            if (gi5Var != null) {
                return gi5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ev7 ev7Var = this.h;
            if (ev7Var != null) {
                ev7Var.G();
            }
            in6 in6Var = this.i;
            if (in6Var != null) {
                in6Var.t();
            }
        }
    }

    public void R() {
        cx7 cx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (cx7Var = this.s) != null) {
            cx7Var.f();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            x67 x67Var = this.d;
            if (x67Var != null) {
                x67Var.notifyDataSetChanged();
            }
            bv7 bv7Var = this.e;
            if (bv7Var != null) {
                bv7Var.d();
            }
            R();
        }
    }

    public void U() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (bdRecyclerView = this.c) != null) {
            bdRecyclerView.setOnSrollToBottomListener(this.w);
        }
    }

    public void W() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (bdRecyclerView = this.c) != null) {
            bdRecyclerView.setOnSrollToBottomListener(null);
        }
    }

    public void X() {
        mva mvaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (mvaVar = this.t) != null) {
            mvaVar.i(2000);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            setTabInForeBackgroundState(false);
            S();
        }
    }

    public void a0() {
        ev7 ev7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (ev7Var = this.h) != null) {
            ev7Var.J(true);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                j0();
                return;
            }
            ev7 ev7Var = this.h;
            if (ev7Var != null) {
                ev7Var.Q();
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            setViewForeground(false);
            ev7 ev7Var = this.h;
            if (ev7Var != null) {
                ev7Var.J(false);
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
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = false;
        this.o = 3;
        this.q = -1;
        this.r = false;
        this.v = new j(this);
        this.w = new k(this);
        this.x = new l(this);
        this.z = new n(this);
        this.A = new o(this);
        this.B = new p(this, 2001115);
        this.C = new e(this);
        this.D = new f(this, 2921058);
        this.E = new g(this, 2921502);
        this.F = new h(this, 2921526);
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (this.o != i2) {
                LoadingView loadingView = this.j;
                if (loadingView != null) {
                    loadingView.onChangeSkinType();
                }
                gi5 gi5Var = this.k;
                if (gi5Var != null) {
                    gi5Var.onChangeSkinType();
                }
                j18 j18Var = this.a;
                if (j18Var != null) {
                    j18Var.D(i2);
                }
                PbListView pbListView = this.b;
                if (pbListView != null) {
                    pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                    this.b.e(i2);
                }
                NoDataView noDataView = this.l;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    this.l.f(this.f, i2);
                    this.l.setSubTitleTextColor(R.color.CAM_X0105);
                    SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
                }
                PublishProgressView publishProgressView = this.m;
                if (publishProgressView != null) {
                    publishProgressView.b();
                }
                bv7 bv7Var = this.e;
                if (bv7Var != null) {
                    bv7Var.e(i2);
                }
                x67 x67Var = this.d;
                if (x67Var != null) {
                    x67Var.b();
                }
                cx7 cx7Var = this.s;
                if (cx7Var != null) {
                    cx7Var.o();
                }
                mva mvaVar = this.t;
                if (mvaVar != null) {
                    mvaVar.i(2000);
                }
            }
            this.o = i2;
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
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = false;
        this.o = 3;
        this.q = -1;
        this.r = false;
        this.v = new j(this);
        this.w = new k(this);
        this.x = new l(this);
        this.z = new n(this);
        this.A = new o(this);
        this.B = new p(this, 2001115);
        this.C = new e(this);
        this.D = new f(this, 2921058);
        this.E = new g(this, 2921502);
        this.F = new h(this, 2921526);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernPageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.n = false;
        this.o = 3;
        this.q = -1;
        this.r = false;
        this.v = new j(this);
        this.w = new k(this);
        this.x = new l(this);
        this.z = new n(this);
        this.A = new o(this);
        this.B = new p(this, 2001115);
        this.C = new e(this);
        this.D = new f(this, 2921058);
        this.E = new g(this, 2921502);
        this.F = new h(this, 2921526);
    }

    public void J(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) {
            K(threadData, false);
        }
    }

    public boolean b0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, recyclerView)) == null) {
            if (recyclerView == null || !recyclerView.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setCallback(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, sVar) == null) {
            this.g = sVar;
        }
    }

    public void setConcernFragment(ConcernFragment concernFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, concernFragment) == null) {
            this.u = concernFragment;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, scrollFragmentTabHost) == null) {
            this.p = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.x);
                this.p.b(this.x);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        ev7 ev7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && (ev7Var = this.h) != null) {
            ev7Var.Z(z);
        }
    }

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            ev7 ev7Var = this.h;
            if (ev7Var != null) {
                ev7Var.N(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.p;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.x);
                this.p.b(this.x);
                this.x.a();
            }
        }
    }

    public void K(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, threadData, z) == null) {
            G();
            if (G) {
                in6 in6Var = this.i;
                if (in6Var != null) {
                    in6Var.q(threadData);
                    return;
                }
                return;
            }
            ev7 ev7Var = this.h;
            if (ev7Var != null) {
                ev7Var.A(threadData, z);
            }
        }
    }

    public void l0(DataRes dataRes, boolean z) {
        ev7 ev7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048611, this, dataRes, z) == null) && (ev7Var = this.h) != null) {
            ev7Var.M(z, dataRes, 0, null);
        }
    }

    public void m0(String str, int i2) {
        ev7 ev7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048612, this, str, i2) == null) && (ev7Var = this.h) != null) {
            ev7Var.M(true, null, i2, str);
        }
    }

    public void H(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, context) != null) || context == null) {
            return;
        }
        this.r = true;
        if (G) {
            this.c = new BdRecyclerView(context);
        } else {
            this.c = new BdTypeRecyclerView(context);
        }
        this.c.setLayoutManager(new LinearLayoutManager(context));
        this.c.setFadingEdgeLength(0);
        this.c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        cx7 cx7Var = new cx7(this, this.c);
        this.s = cx7Var;
        cx7Var.q(context.getString(R.string.tab_name_concern));
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.y = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.c);
        this.y.setFocusable(true);
        this.y.setFocusableInTouchMode(true);
        this.y.setDescendantFocusability(393216);
        PbListView pbListView = new PbListView(context);
        this.b = pbListView;
        pbListView.a();
        this.b.s(R.color.transparent);
        this.b.B();
        this.b.J(SkinManager.getColor(R.color.CAM_X0107));
        this.b.L(R.dimen.tbfontsize33);
        this.b.F(R.color.CAM_X0110);
        this.b.G(this.C);
        this.c.setNextPage(this.b);
        BdPageContext<?> a2 = k4.a(context);
        if (a2 instanceof TbPageContext) {
            this.f = (TbPageContext) a2;
        }
        this.s.p(this.f);
        j18 j18Var = new j18(this.f);
        this.a = j18Var;
        j18Var.w(true);
        this.y.setProgressView(this.a);
        int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
        this.y.setCustomDistances(i2, i2, i2 * 2);
        if (G) {
            FeedTemplateAdapter feedTemplateAdapter = new FeedTemplateAdapter();
            this.d = feedTemplateAdapter;
            feedTemplateAdapter.e(new p77(new kn6()));
            x67 x67Var = this.d;
            jn6 jn6Var = new jn6();
            jn6Var.b("2");
            x67Var.c(new o77(jn6Var));
            this.d.j(new s87());
            this.d.j(new e77());
            this.d.f(this.c);
            in6 in6Var = new in6(this.f.getPageActivity());
            this.i = in6Var;
            in6Var.y(this.u);
            this.i.e(this.A);
        } else {
            bv7 bv7Var = new bv7(context, (BdTypeRecyclerView) this.c);
            this.e = bv7Var;
            this.h = new ev7(this.f, (BdTypeRecyclerView) this.c, bv7Var, this.y);
        }
        this.y.setVisibility(8);
        this.s.r(false);
        PublishProgressView publishProgressView = new PublishProgressView(context);
        this.m = publishProgressView;
        publishProgressView.setVisibility(8);
        T(TbadkCoreApplication.getInst().getSkinType());
        if (this.t == null) {
            this.t = new mva(this.f, this.c);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ev7 ev7Var = this.h;
            if (ev7Var != null) {
                ev7Var.Y(this.z);
            }
            this.a.a(new q(this));
            this.a.b(new r(this));
            this.a.e(new a(this));
            this.c.setOnSrollToBottomListener(this.w);
            this.c.removeOnScrollListener(this.v);
            this.c.addOnScrollListener(this.v);
            this.c.setRecyclerListener(new b(this));
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.p;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.x);
            }
            this.c.removeOnScrollListener(this.v);
            MessageManager.getInstance().unRegisterListener(this.F);
            MessageManager.getInstance().unRegisterListener(this.B);
            ev7 ev7Var = this.h;
            if (ev7Var != null) {
                ev7Var.Y(null);
            }
            this.a.a(null);
            this.a.b(null);
            this.c.setOnSrollToBottomListener(null);
            this.a.e(null);
            this.a.U();
            this.c.setRecyclerListener(null);
            ev7 ev7Var2 = this.h;
            if (ev7Var2 != null) {
                ev7Var2.L();
            }
            in6 in6Var = this.i;
            if (in6Var != null) {
                in6Var.m();
            }
        }
    }

    public void d0() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (bdRecyclerView = this.c) != null && this.y != null) {
            if (this.n && bdRecyclerView.getFirstVisiblePosition() != 0) {
                this.n = false;
                return;
            }
            this.c.setSelection(0);
            if (!this.y.t()) {
                NoDataView noDataView = this.l;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (G) {
                            this.i.s();
                            G();
                            g0(true);
                        } else {
                            ev7 ev7Var = this.h;
                            if (ev7Var != null) {
                                ev7Var.b0();
                            }
                        }
                    }
                } else {
                    this.y.setRefreshing(true);
                }
            }
            if (!this.y.t()) {
                this.y.setRefreshing(true);
            }
            ScrollFragmentTabHost.s sVar = this.x;
            if (sVar != null) {
                sVar.a();
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.l == null) {
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f04bf), new d(this)));
                this.l = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOTLOGIN), NoDataViewFactory.e.d(null, getContext().getResources().getString(R.string.obfuscated_res_0x7f0f04c7)), a2);
            }
            this.y.setVisibility(8);
            this.s.r(false);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            this.l.f(this.f, TbadkCoreApplication.getInst().getSkinType());
            this.l.setVisibility(0);
            this.l.bringToFront();
        }
    }

    public void Z() {
        bv7 bv7Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (bv7Var = this.e) == null) {
            return;
        }
        List<yh> a2 = bv7Var.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (yh yhVar : a2) {
            if (yhVar instanceof rk6) {
                rk6 rk6Var = (rk6) yhVar;
                if (rk6Var.j != 0 && (threadData = rk6Var.a) != null) {
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    rk6Var.j = imageWidthAndHeight[0];
                    rk6Var.k = imageWidthAndHeight[1];
                }
            }
        }
        SafeHandler.getInst().postDelayed(new i(this), 500L);
    }

    public void f0() {
        in6 in6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.y.setVisibility(0);
            this.c.setVisibility(0);
            this.s.r(true);
            ev7 ev7Var = this.h;
            if ((ev7Var != null && ev7Var.z()) || ((in6Var = this.i) != null && in6Var.o())) {
                this.b.U();
            } else {
                this.b.h();
            }
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.w(BdUtilHelper.getDimens(getContext(), R.dimen.tbds150));
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.y.setVisibility(0);
            this.c.setVisibility(0);
            this.s.r(true);
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.w(0);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            addView(this.s.k(), 0);
            addView(this.y);
            addView(this.m, new FrameLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), R.dimen.tbds83)));
        }
    }

    public final void g0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048606, this, z) != null) || N()) {
            return;
        }
        if (this.j == null) {
            this.j = new LoadingView(getContext());
            this.j.setBottomMargin(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + BdUtilHelper.getDimens(getContext(), R.dimen.tbds60));
            this.j.cancelCenterVertical();
            this.j.setWrapStyle(true);
        }
        this.j.onChangeSkinType();
        this.j.attachView(this, z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bdUniqueId) == null) {
            bv7 bv7Var = this.e;
            if (bv7Var != null) {
                bv7Var.h(bdUniqueId);
            }
            ev7 ev7Var = this.h;
            if (ev7Var != null) {
                ev7Var.a0(bdUniqueId);
            }
            j18 j18Var = this.a;
            if (j18Var != null) {
                j18Var.W(bdUniqueId);
            }
            CustomMessageListener customMessageListener = this.D;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.D);
            }
            CustomMessageListener customMessageListener2 = this.E;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.E);
            }
            wo6.b().b(new vo6(bdUniqueId, u85.class), new m(this, u85.class));
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048607, this, z) != null) || P()) {
            return;
        }
        if (this.k == null) {
            this.k = new gi5(getContext(), new c(this));
        }
        this.k.attachView(this, z);
        this.k.o();
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int i2 = SharedPrefHelper.getInstance().getInt("key_home_concern_all_status", 0);
            if (this.l == null) {
                this.l = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOPOST), NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f04c1)), null);
            }
            if (i2 == 0) {
                this.l.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f04c2)));
                this.l.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOFOLLOW));
            } else {
                this.l.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f04c1)));
                this.l.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOPOST));
            }
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            this.l.f(this.f, TbadkCoreApplication.getInst().getSkinType());
            this.l.setVisibility(0);
            this.l.bringToFront();
        }
    }
}
