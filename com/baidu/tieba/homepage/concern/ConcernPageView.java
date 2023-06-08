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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.R;
import com.baidu.tieba.bea;
import com.baidu.tieba.d56;
import com.baidu.tieba.fe5;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.g87;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.k57;
import com.baidu.tieba.k9;
import com.baidu.tieba.m0a;
import com.baidu.tieba.mq6;
import com.baidu.tieba.mw7;
import com.baidu.tieba.n95;
import com.baidu.tieba.n97;
import com.baidu.tieba.nq6;
import com.baidu.tieba.o87;
import com.baidu.tieba.oq6;
import com.baidu.tieba.p08;
import com.baidu.tieba.p87;
import com.baidu.tieba.q87;
import com.baidu.tieba.q9;
import com.baidu.tieba.r87;
import com.baidu.tieba.rv7;
import com.baidu.tieba.uv5;
import com.baidu.tieba.vi;
import com.baidu.tieba.vm5;
import com.baidu.tieba.vn;
import com.baidu.tieba.vr6;
import com.baidu.tieba.vu7;
import com.baidu.tieba.w95;
import com.baidu.tieba.wg;
import com.baidu.tieba.wm5;
import com.baidu.tieba.wo6;
import com.baidu.tieba.wr6;
import com.baidu.tieba.yu7;
import com.baidu.tieba.z77;
import com.baidu.tieba.zr6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class ConcernPageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public View.OnClickListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public final CustomMessageListener E;
    public p08 a;
    public PbListView b;
    public BdRecyclerView c;
    public z77 d;
    public vu7 e;
    public TbPageContext<?> f;
    public s g;
    public yu7 h;
    public r87 i;
    public vm5 j;
    public wm5 k;
    public NoDataView l;
    public PublishProgressView m;
    public boolean n;
    public int o;
    public ScrollFragmentTabHost p;
    public int q;
    public boolean r;
    public mw7 s;
    public bea t;
    public RecyclerView.OnScrollListener u;
    public BdListView.p v;
    public ScrollFragmentTabHost.r w;
    public BigdaySwipeRefreshLayout x;
    public yu7.o y;
    public final q87.a<k57> z;

    /* loaded from: classes6.dex */
    public interface s {
        void a(boolean z, boolean z2);

        void b(uv5 uv5Var);

        void c(String str, uv5 uv5Var);
    }

    /* loaded from: classes6.dex */
    public class n implements yu7.o {
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

        @Override // com.baidu.tieba.yu7.o
        public void a(uv5 uv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, uv5Var) != null) {
                return;
            }
            this.a.E();
            this.a.F();
            this.a.c.setSelection(0);
            if (ConcernPageView.F) {
                if (this.a.c.getWrappedAdapter() != null && this.a.c.getWrappedAdapter().getItemCount() > 0) {
                    this.a.D();
                    this.a.d0();
                } else {
                    this.a.f0(true);
                }
            } else if (((BdTypeRecyclerView) this.a.c).getCount() > 0) {
                this.a.D();
                this.a.d0();
            } else {
                this.a.f0(true);
            }
            if (this.a.g != null) {
                this.a.g.b(uv5Var);
            }
        }

        @Override // com.baidu.tieba.yu7.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.g != null) {
                    this.a.g.a(true, false);
                }
                this.a.D();
                this.a.E();
                this.a.c.setVisibility(8);
                this.a.s.r(false);
                this.a.h0();
            }
        }

        @Override // com.baidu.tieba.yu7.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.g != null) {
                    this.a.g.a(z, z2);
                }
                if (!this.a.K() && this.a.t != null) {
                    wg.a().postDelayed(new a(this), 300L);
                }
                if (this.a.t != null) {
                    this.a.t.i(2000);
                }
                this.a.D();
                this.a.E();
                this.a.F();
                if (this.a.h != null && this.a.h.D()) {
                    this.a.d0();
                } else {
                    this.a.e0();
                }
            }
        }

        @Override // com.baidu.tieba.yu7.o
        public void d(String str, uv5 uv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, uv5Var) == null) {
                this.a.E();
                this.a.F();
                this.a.D();
                this.a.e0();
                if (this.a.g != null) {
                    this.a.g.c(str, uv5Var);
                }
            }
        }

        @Override // com.baidu.tieba.yu7.o
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                if (this.a.g != null) {
                    this.a.g.a(false, false);
                }
                this.a.D();
                this.a.F();
                if (i == 1) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.f.showToast(str);
                        return;
                    }
                    return;
                }
                this.a.c.setVisibility(8);
                this.a.s.r(false);
                this.a.g0(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements w95.f {
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

        @Override // com.baidu.tieba.w95.f
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
                if (ConcernPageView.F) {
                    this.a.i.d();
                    this.a.E();
                    this.a.f0(true);
                } else if (this.a.h != null && BdNetTypeUtil.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                    this.a.h.update();
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
            this.a.P();
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
            this.a.c0();
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
                    this.a.l.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f04b5)));
                } else {
                    this.a.l.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f04b4)));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof PublishProgressData) && (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) != null && !m0a.g() && m0a.a() != null && this.a.m != null) {
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
                this.a.Q();
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
                if (this.a.t != null && !this.a.K()) {
                    this.a.t.g();
                }
                if (this.a.q == i || this.a.p == null) {
                    return;
                }
                this.a.q = i;
                if (this.a.q == 1) {
                    this.a.p.a();
                } else if (this.a.a0(recyclerView)) {
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
            this.a.P();
        }
    }

    /* loaded from: classes6.dex */
    public class l extends ScrollFragmentTabHost.r {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.r
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.p == null) {
                return;
            }
            this.a.q = -1;
            ConcernPageView concernPageView = this.a;
            if (concernPageView.a0(concernPageView.c)) {
                this.a.p.c();
            } else {
                this.a.p.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends zr6<fe5> {
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
        @Override // com.baidu.tieba.zr6
        public void onEvent(@NonNull fe5 fe5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, fe5Var) != null) || !"recommend_user".equals(fe5Var.getType())) {
                return;
            }
            this.b.C();
        }
    }

    /* loaded from: classes6.dex */
    public class o implements q87.a<k57> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q87.a
        /* renamed from: b */
        public void a(k57 k57Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k57Var) == null) {
                this.a.x.setRefreshing(false);
                this.a.D();
                this.a.F();
                if (k57Var == null) {
                    return;
                }
                if (k57Var.c != 0) {
                    if (ListUtils.isEmpty(k57Var.a)) {
                        this.a.g0(true);
                        return;
                    }
                    return;
                }
                this.a.E();
                if (ListUtils.isEmpty(k57Var.a)) {
                    this.a.b.O(8);
                    this.a.h0();
                } else {
                    this.a.b.O(0);
                    if (k57Var.b) {
                        this.a.e0();
                    } else {
                        this.a.d0();
                    }
                }
                this.a.d.setList(k57Var.a);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || !ConcernPageView.F) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            UpdateAttentionMessage.a data = updateAttentionMessage.getData();
            if (data.i != null) {
                return;
            }
            if (!data.a) {
                BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().b);
                b.g(BdToast.ToastIcon.FAILURE);
                b.d(3000);
                b.o();
            } else if (!data.d && this.a.i != null && !TextUtils.isEmpty(data.c) && this.a.i.g(data.c)) {
                this.a.i.e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements w95.g {
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

        @Override // com.baidu.tieba.w95.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                d56.c().f("page_concern");
                if (this.a.h != null) {
                    this.a.h.update();
                }
                if (this.a.i != null) {
                    this.a.i.d();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements w95.h {
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

        @Override // com.baidu.tieba.w95.h
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
        F = N();
    }

    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return UbsABTestHelper.isConcernFeedTest();
        }
        return invokeV.booleanValue;
    }

    public void A() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bigdaySwipeRefreshLayout = this.x) != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                i0();
                return;
            }
            yu7 yu7Var = this.h;
            if (yu7Var != null) {
                yu7Var.update();
                f0(true);
            }
            r87 r87Var = this.i;
            if (r87Var != null) {
                r87Var.d();
                f0(true);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new rv7.b().execute(new Integer[0]);
            TiebaStatic.log(new StatisticItem("c13572"));
            r87 r87Var = this.i;
            if (r87Var != null) {
                r87Var.a();
            }
        }
    }

    public final void D() {
        vm5 vm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (vm5Var = this.j) != null) {
            vm5Var.dettachView(this);
            this.j = null;
        }
    }

    public final void E() {
        wm5 wm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (wm5Var = this.k) != null) {
            wm5Var.dettachView(this);
            this.k = null;
        }
    }

    public final void F() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (noDataView = this.l) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return n95.m().i("key_reaction_guide_show_number", false);
        }
        return invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            vm5 vm5Var = this.j;
            if (vm5Var != null) {
                return vm5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            wm5 wm5Var = this.k;
            if (wm5Var != null) {
                return wm5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            yu7 yu7Var = this.h;
            if (yu7Var != null) {
                yu7Var.G();
            }
            r87 r87Var = this.i;
            if (r87Var != null) {
                r87Var.e();
            }
        }
    }

    public void Q() {
        mw7 mw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (mw7Var = this.s) != null) {
            mw7Var.f();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            z77 z77Var = this.d;
            if (z77Var != null) {
                z77Var.notifyDataSetChanged();
            }
            vu7 vu7Var = this.e;
            if (vu7Var != null) {
                vu7Var.d();
            }
            Q();
        }
    }

    public void T() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (bdRecyclerView = this.c) != null) {
            bdRecyclerView.setOnSrollToBottomListener(this.v);
        }
    }

    public void V() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (bdRecyclerView = this.c) != null) {
            bdRecyclerView.setOnSrollToBottomListener(null);
        }
    }

    public void W() {
        bea beaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (beaVar = this.t) != null) {
            beaVar.i(2000);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            setTabInForeBackgroundState(false);
            R();
        }
    }

    public void Z() {
        yu7 yu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (yu7Var = this.h) != null) {
            yu7Var.J(true);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                i0();
                return;
            }
            yu7 yu7Var = this.h;
            if (yu7Var != null) {
                yu7Var.Q();
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            setViewForeground(false);
            yu7 yu7Var = this.h;
            if (yu7Var != null) {
                yu7Var.J(false);
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
        this.u = new j(this);
        this.v = new k(this);
        this.w = new l(this);
        this.y = new n(this);
        this.z = new o(this);
        this.A = new p(this, 2001115);
        this.B = new e(this);
        this.C = new f(this, 2921058);
        this.D = new g(this, 2921502);
        this.E = new h(this, 2921526);
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (this.o != i2) {
                vm5 vm5Var = this.j;
                if (vm5Var != null) {
                    vm5Var.onChangeSkinType();
                }
                wm5 wm5Var = this.k;
                if (wm5Var != null) {
                    wm5Var.onChangeSkinType();
                }
                p08 p08Var = this.a;
                if (p08Var != null) {
                    p08Var.H(i2);
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
                vu7 vu7Var = this.e;
                if (vu7Var != null) {
                    vu7Var.e(i2);
                }
                z77 z77Var = this.d;
                if (z77Var != null) {
                    z77Var.b();
                }
                mw7 mw7Var = this.s;
                if (mw7Var != null) {
                    mw7Var.o();
                }
                bea beaVar = this.t;
                if (beaVar != null) {
                    beaVar.i(2000);
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
        this.u = new j(this);
        this.v = new k(this);
        this.w = new l(this);
        this.y = new n(this);
        this.z = new o(this);
        this.A = new p(this, 2001115);
        this.B = new e(this);
        this.C = new f(this, 2921058);
        this.D = new g(this, 2921502);
        this.E = new h(this, 2921526);
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
        this.u = new j(this);
        this.v = new k(this);
        this.w = new l(this);
        this.y = new n(this);
        this.z = new o(this);
        this.A = new p(this, 2001115);
        this.B = new e(this);
        this.C = new f(this, 2921058);
        this.D = new g(this, 2921502);
        this.E = new h(this, 2921526);
    }

    public void I(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) {
            J(threadData, false);
        }
    }

    public boolean a0(RecyclerView recyclerView) {
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

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, scrollFragmentTabHost) == null) {
            this.p = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.w);
                this.p.b(this.w);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        yu7 yu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (yu7Var = this.h) != null) {
            yu7Var.Z(z);
        }
    }

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            yu7 yu7Var = this.h;
            if (yu7Var != null) {
                yu7Var.N(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.p;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.w);
                this.p.b(this.w);
                this.w.a();
            }
        }
    }

    public void J(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, threadData, z) == null) {
            F();
            if (F) {
                r87 r87Var = this.i;
                if (r87Var != null) {
                    r87Var.c(threadData);
                    return;
                }
                return;
            }
            yu7 yu7Var = this.h;
            if (yu7Var != null) {
                yu7Var.A(threadData, z);
            }
        }
    }

    public void k0(DataRes dataRes, boolean z) {
        yu7 yu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048611, this, dataRes, z) == null) && (yu7Var = this.h) != null) {
            yu7Var.M(z, dataRes, 0, null);
        }
    }

    public void l0(String str, int i2) {
        yu7 yu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048612, this, str, i2) == null) && (yu7Var = this.h) != null) {
            yu7Var.M(true, null, i2, str);
        }
    }

    public void G(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, context) != null) || context == null) {
            return;
        }
        this.r = true;
        if (F) {
            this.c = new BdRecyclerView(context);
        } else {
            this.c = new BdTypeRecyclerView(context);
        }
        this.c.setLayoutManager(new LinearLayoutManager(context));
        this.c.setFadingEdgeLength(0);
        this.c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        mw7 mw7Var = new mw7(this, this.c);
        this.s = mw7Var;
        mw7Var.q(context.getString(R.string.tab_name_concern));
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.x = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.c);
        this.x.setFocusable(true);
        this.x.setFocusableInTouchMode(true);
        this.x.setDescendantFocusability(393216);
        PbListView pbListView = new PbListView(context);
        this.b = pbListView;
        pbListView.a();
        this.b.s(R.color.transparent);
        this.b.B();
        this.b.J(SkinManager.getColor(R.color.CAM_X0107));
        this.b.L(R.dimen.tbfontsize33);
        this.b.F(R.color.CAM_X0110);
        this.b.G(this.B);
        this.c.setNextPage(this.b);
        k9<?> a2 = q9.a(context);
        if (a2 instanceof TbPageContext) {
            this.f = (TbPageContext) a2;
        }
        this.s.p(this.f);
        p08 p08Var = new p08(this.f);
        this.a = p08Var;
        p08Var.A(true);
        this.x.setProgressView(this.a);
        int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
        this.x.setCustomDistances(i2, i2, i2 * 2);
        if (F) {
            FeedTemplateAdapter feedTemplateAdapter = new FeedTemplateAdapter();
            this.d = feedTemplateAdapter;
            feedTemplateAdapter.e(new p87(new oq6()));
            z77 z77Var = this.d;
            nq6 nq6Var = new nq6();
            nq6Var.b("2");
            z77Var.c(new o87(nq6Var));
            this.d.j(new n97());
            this.d.j(new g87());
            this.d.f(this.c);
            r87 r87Var = new r87(this.f.getPageActivity(), new mq6(this.f.getPageActivity()));
            this.i = r87Var;
            r87Var.f(this.z);
        } else {
            vu7 vu7Var = new vu7(context, (BdTypeRecyclerView) this.c);
            this.e = vu7Var;
            this.h = new yu7(this.f, (BdTypeRecyclerView) this.c, vu7Var, this.x);
        }
        this.x.setVisibility(8);
        this.s.r(false);
        PublishProgressView publishProgressView = new PublishProgressView(context);
        this.m = publishProgressView;
        publishProgressView.setVisibility(8);
        S(TbadkCoreApplication.getInst().getSkinType());
        if (this.t == null) {
            this.t = new bea(this.f, this.c);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            yu7 yu7Var = this.h;
            if (yu7Var != null) {
                yu7Var.Y(this.y);
            }
            this.a.f(new q(this));
            this.a.g(new r(this));
            this.a.m(new a(this));
            this.c.setOnSrollToBottomListener(this.v);
            this.c.removeOnScrollListener(this.u);
            this.c.addOnScrollListener(this.u);
            this.c.setRecyclerListener(new b(this));
            MessageManager.getInstance().registerListener(this.E);
            MessageManager.getInstance().registerListener(this.A);
        }
    }

    public void c0() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (bdRecyclerView = this.c) != null && this.x != null) {
            if (this.n && bdRecyclerView.getFirstVisiblePosition() != 0) {
                this.n = false;
                return;
            }
            this.c.setSelection(0);
            if (!this.x.t()) {
                NoDataView noDataView = this.l;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (F) {
                            this.i.d();
                            F();
                            f0(true);
                        } else {
                            yu7 yu7Var = this.h;
                            if (yu7Var != null) {
                                yu7Var.update();
                            }
                        }
                    }
                } else {
                    this.x.setRefreshing(true);
                }
            }
            if (!this.x.t()) {
                this.x.setRefreshing(true);
            }
            ScrollFragmentTabHost.r rVar = this.w;
            if (rVar != null) {
                rVar.a();
            }
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.l == null) {
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f04b2), new d(this)));
                this.l = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOTLOGIN), NoDataViewFactory.e.d(null, getContext().getResources().getString(R.string.obfuscated_res_0x7f0f04ba)), a2);
            }
            this.x.setVisibility(8);
            this.s.r(false);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            this.l.f(this.f, TbadkCoreApplication.getInst().getSkinType());
            this.l.setVisibility(0);
            this.l.bringToFront();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.p;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.w);
            }
            this.c.removeOnScrollListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.E);
            MessageManager.getInstance().unRegisterListener(this.A);
            yu7 yu7Var = this.h;
            if (yu7Var != null) {
                yu7Var.Y(null);
            }
            this.a.f(null);
            this.a.g(null);
            this.c.setOnSrollToBottomListener(null);
            this.a.m(null);
            this.a.Y();
            this.c.setRecyclerListener(null);
            yu7 yu7Var2 = this.h;
            if (yu7Var2 != null) {
                yu7Var2.L();
            }
        }
    }

    public void Y() {
        vu7 vu7Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (vu7Var = this.e) == null) {
            return;
        }
        List<vn> a2 = vu7Var.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (vn vnVar : a2) {
            if (vnVar instanceof wo6) {
                wo6 wo6Var = (wo6) vnVar;
                if (wo6Var.j != 0 && (threadData = wo6Var.a) != null) {
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    wo6Var.j = imageWidthAndHeight[0];
                    wo6Var.k = imageWidthAndHeight[1];
                }
            }
        }
        wg.a().postDelayed(new i(this), 500L);
    }

    public void e0() {
        r87 r87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.x.setVisibility(0);
            this.c.setVisibility(0);
            this.s.r(true);
            yu7 yu7Var = this.h;
            if ((yu7Var != null && yu7Var.z()) || ((r87Var = this.i) != null && r87Var.b())) {
                this.b.U();
            } else {
                this.b.h();
            }
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.w(vi.g(getContext(), R.dimen.tbds150));
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.x.setVisibility(0);
            this.c.setVisibility(0);
            this.s.r(true);
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.w(0);
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            addView(this.s.k(), 0);
            addView(this.x);
            addView(this.m, new FrameLayout.LayoutParams(-1, vi.g(getContext(), R.dimen.tbds83)));
        }
    }

    public final void f0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048606, this, z) != null) || M()) {
            return;
        }
        if (this.j == null) {
            this.j = new vm5(getContext());
            this.j.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + vi.g(getContext(), R.dimen.tbds60));
            this.j.i();
            this.j.setWrapStyle(true);
        }
        this.j.onChangeSkinType();
        this.j.attachView(this, z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bdUniqueId) == null) {
            vu7 vu7Var = this.e;
            if (vu7Var != null) {
                vu7Var.h(bdUniqueId);
            }
            yu7 yu7Var = this.h;
            if (yu7Var != null) {
                yu7Var.a0(bdUniqueId);
            }
            p08 p08Var = this.a;
            if (p08Var != null) {
                p08Var.a0(bdUniqueId);
            }
            CustomMessageListener customMessageListener = this.C;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.C);
            }
            CustomMessageListener customMessageListener2 = this.D;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.D);
            }
            wr6.b().a(new vr6(bdUniqueId, this), new m(this, fe5.class));
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048607, this, z) != null) || O()) {
            return;
        }
        if (this.k == null) {
            this.k = new wm5(getContext(), new c(this));
        }
        this.k.attachView(this, z);
        this.k.p();
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int n2 = n95.m().n("key_home_concern_all_status", 0);
            if (this.l == null) {
                this.l = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOPOST), NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f04b4)), null);
            }
            if (n2 == 0) {
                this.l.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f04b5)));
                this.l.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOFOLLOW));
            } else {
                this.l.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f04b4)));
                this.l.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOPOST));
            }
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            this.l.f(this.f, TbadkCoreApplication.getInst().getSkinType());
            this.l.setVisibility(0);
            this.l.bringToFront();
        }
    }
}
