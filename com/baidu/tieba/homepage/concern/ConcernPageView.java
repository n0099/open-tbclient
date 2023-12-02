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
import com.baidu.tieba.a5;
import com.baidu.tieba.ar6;
import com.baidu.tieba.bc7;
import com.baidu.tieba.br6;
import com.baidu.tieba.c26;
import com.baidu.tieba.cc7;
import com.baidu.tieba.dc7;
import com.baidu.tieba.dn6;
import com.baidu.tieba.er6;
import com.baidu.tieba.fb7;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.fk5;
import com.baidu.tieba.fp5;
import com.baidu.tieba.gd7;
import com.baidu.tieba.gh8;
import com.baidu.tieba.hb7;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.jdb;
import com.baidu.tieba.mqa;
import com.baidu.tieba.np6;
import com.baidu.tieba.ob7;
import com.baidu.tieba.op6;
import com.baidu.tieba.p55;
import com.baidu.tieba.pi;
import com.baidu.tieba.pp6;
import com.baidu.tieba.q67;
import com.baidu.tieba.qb7;
import com.baidu.tieba.rb7;
import com.baidu.tieba.sb8;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.w95;
import com.baidu.tieba.wa8;
import com.baidu.tieba.yc8;
import com.baidu.tieba.za8;
import com.baidu.tieba.zs5;
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
    public static final boolean H;
    public transient /* synthetic */ FieldHolder $fh;
    public za8.o A;
    public final dc7.a B;
    public final CustomMessageListener C;
    public View.OnClickListener D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public final CustomMessageListener G;
    public gh8 a;
    public PbListView b;
    public BdRecyclerView c;
    public hb7 d;
    public wa8 e;
    public TbPageContext<?> f;
    public t g;
    public za8 h;
    public np6 i;
    public LoadingView j;
    public fk5 k;
    public NoDataView l;
    public PublishProgressView m;
    public boolean n;
    public int o;
    public ScrollFragmentTabHost p;
    public int q;
    public boolean r;
    public yc8 s;
    public jdb t;
    public ConcernFragment u;
    public BdUniqueId v;
    public RecyclerView.OnScrollListener w;
    public BdListView.p x;
    public ScrollFragmentTabHost.s y;
    public BigdaySwipeRefreshLayout z;

    /* loaded from: classes6.dex */
    public interface t {
        void a(boolean z, boolean z2);

        void b(zs5 zs5Var);

        void c(String str, zs5 zs5Var);
    }

    /* loaded from: classes6.dex */
    public class a implements p55.h {
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

        @Override // com.baidu.tieba.p55.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.t != null) {
                this.a.t.f(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements p55.f {
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

        @Override // com.baidu.tieba.p55.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (this.a.t != null) {
                    this.a.t.f(false);
                }
                if (this.a.t != null) {
                    this.a.t.g(2000);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements RecyclerView.RecyclerListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.a.t != null) {
                    this.a.t.d(view2);
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
                if (ConcernPageView.H) {
                    this.a.i.f();
                    this.a.E();
                    this.a.e0(true);
                } else if (this.a.h != null && BdNetTypeUtil.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                    this.a.h.b0();
                }
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ViewHelper.checkUpIsLogin(this.a.getContext());
                HomePageStatic.a = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.O();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.n = true;
            this.a.b0();
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
                    this.a.l.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f04cc)));
                } else {
                    this.a.l.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f04cb)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ConcernPageView concernPageView, int i) {
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
    public class j implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e != null) {
                    this.a.e.d();
                }
                this.a.P();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i == 0 && this.a.t != null) {
                    this.a.t.g(100);
                }
                if (i == 1 && this.a.t != null) {
                    this.a.t.c();
                }
                if (this.a.q == i || this.a.p == null) {
                    return;
                }
                this.a.q = i;
                if (this.a.q == 1) {
                    this.a.p.a();
                } else if (this.a.Z(recyclerView)) {
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
            this.a.O();
        }
    }

    /* loaded from: classes6.dex */
    public class m extends ScrollFragmentTabHost.s {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.p == null) {
                return;
            }
            this.a.q = -1;
            ConcernPageView concernPageView = this.a;
            if (concernPageView.Z(concernPageView.c)) {
                this.a.p.c();
            } else {
                this.a.p.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends er6<w95> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ConcernPageView concernPageView, Class cls) {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull w95 w95Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w95Var) != null) || !"recommend_user".equals(w95Var.b())) {
                return;
            }
            this.b.C();
        }
    }

    /* loaded from: classes6.dex */
    public class o implements za8.o {
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

        @Override // com.baidu.tieba.za8.o
        public void a(zs5 zs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, zs5Var) != null) {
                return;
            }
            this.a.E();
            this.a.F();
            this.a.c.setSelection(0);
            if (ConcernPageView.H) {
                if (this.a.c.getWrappedAdapter() != null && this.a.c.getWrappedAdapter().getItemCount() > 0) {
                    this.a.D();
                    this.a.c0();
                } else {
                    this.a.e0(true);
                }
            } else if (((BdTypeRecyclerView) this.a.c).getCount() > 0) {
                this.a.D();
                this.a.c0();
            } else {
                this.a.e0(true);
            }
            if (this.a.g != null) {
                this.a.g.b(zs5Var);
            }
        }

        @Override // com.baidu.tieba.za8.o
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
                this.a.g0();
            }
        }

        @Override // com.baidu.tieba.za8.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.g != null) {
                    this.a.g.a(z, z2);
                }
                if (this.a.t != null) {
                    this.a.t.g(2000);
                }
                this.a.D();
                this.a.E();
                this.a.F();
                if (this.a.h != null && this.a.h.D()) {
                    this.a.c0();
                } else {
                    this.a.d0();
                }
            }
        }

        @Override // com.baidu.tieba.za8.o
        public void d(String str, zs5 zs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, zs5Var) == null) {
                this.a.E();
                this.a.F();
                this.a.D();
                this.a.d0();
                if (this.a.g != null) {
                    this.a.g.c(str, zs5Var);
                }
            }
        }

        @Override // com.baidu.tieba.za8.o
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
                this.a.f0(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements fb7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc7 a;
        public final /* synthetic */ ConcernPageView b;

        public p(ConcernPageView concernPageView, cc7 cc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernPageView, cc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = concernPageView;
            this.a = cc7Var;
        }

        @Override // com.baidu.tieba.fb7.c
        public void a(@NonNull rb7<?> rb7Var, @NonNull qb7<?, ?> qb7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, rb7Var, qb7Var, i) == null) {
                this.a.a(rb7Var, qb7Var, i);
                fp5.a.h(this.b.v);
            }
        }

        @Override // com.baidu.tieba.fb7.c
        public void b(@NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView) == null) {
                this.a.b(recyclerView);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements dc7.a {
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

        @Override // com.baidu.tieba.dc7.a
        public void a(q67 q67Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q67Var) == null) {
                this.a.z.setRefreshing(false);
                this.a.D();
                this.a.F();
                if (q67Var == null) {
                    return;
                }
                if (q67Var.d != 0) {
                    if (ListUtils.isEmpty(q67Var.a)) {
                        this.a.f0(true);
                        return;
                    }
                    return;
                }
                this.a.E();
                if (ListUtils.isEmpty(q67Var.a)) {
                    this.a.b.O(8);
                    this.a.g0();
                } else {
                    this.a.b.O(0);
                    if (q67Var.c) {
                        this.a.d0();
                    } else {
                        this.a.c0();
                    }
                }
                this.a.d.setList(q67Var.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(ConcernPageView concernPageView, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || !ConcernPageView.H) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            UpdateAttentionMessage.UpdateAttentionData data = updateAttentionMessage.getData();
            if (data.blockData != null) {
                return;
            }
            if (!data.isSucc) {
                BdToast.makeText(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
            } else if (!data.isAttention && this.a.i != null && !TextUtils.isEmpty(data.toUid) && this.a.i.y(data.toUid)) {
                this.a.i.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements p55.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public s(ConcernPageView concernPageView) {
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

        @Override // com.baidu.tieba.p55.g
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                c26.c().f("page_concern");
                if (this.a.h != null) {
                    this.a.h.b0();
                }
                if (this.a.i != null) {
                    this.a.i.f();
                }
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
        H = M();
    }

    public static boolean M() {
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
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bigdaySwipeRefreshLayout = this.z) != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new sb8.b().execute(new Integer[0]);
            TiebaStatic.log(new StatisticItem("c13572"));
            np6 np6Var = this.i;
            if (np6Var != null) {
                np6Var.n();
            }
        }
    }

    public final void D() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (loadingView = this.j) != null) {
            loadingView.dettachView(this);
            this.j = null;
        }
    }

    public final void E() {
        fk5 fk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (fk5Var = this.k) != null) {
            fk5Var.dettachView(this);
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

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            LoadingView loadingView = this.j;
            if (loadingView != null) {
                return loadingView.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            fk5 fk5Var = this.k;
            if (fk5Var != null) {
                return fk5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            za8 za8Var = this.h;
            if (za8Var != null) {
                za8Var.G();
            }
            np6 np6Var = this.i;
            if (np6Var != null) {
                np6Var.g();
            }
        }
    }

    public void P() {
        yc8 yc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (yc8Var = this.s) != null) {
            yc8Var.f();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            hb7 hb7Var = this.d;
            if (hb7Var != null) {
                hb7Var.notifyDataSetChanged();
            }
            wa8 wa8Var = this.e;
            if (wa8Var != null) {
                wa8Var.d();
            }
            P();
        }
    }

    public void S() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (bdRecyclerView = this.c) != null) {
            bdRecyclerView.setOnSrollToBottomListener(this.x);
        }
    }

    public void U() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (bdRecyclerView = this.c) != null) {
            bdRecyclerView.setOnSrollToBottomListener(null);
        }
    }

    public void V() {
        jdb jdbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (jdbVar = this.t) != null) {
            jdbVar.g(2000);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            setTabInForeBackgroundState(false);
            Q();
        }
    }

    public void Y() {
        za8 za8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (za8Var = this.h) != null) {
            za8Var.J(true);
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                h0();
                return;
            }
            za8 za8Var = this.h;
            if (za8Var != null) {
                za8Var.Q();
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            setViewForeground(false);
            za8 za8Var = this.h;
            if (za8Var != null) {
                za8Var.J(false);
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
        this.w = new k(this);
        this.x = new l(this);
        this.y = new m(this);
        this.A = new o(this);
        this.B = new q(this);
        this.C = new r(this, 2001115);
        this.D = new f(this);
        this.E = new g(this, 2921058);
        this.F = new h(this, 2921502);
        this.G = new i(this, 2921526);
    }

    public void R(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (this.o != i2) {
                LoadingView loadingView = this.j;
                if (loadingView != null) {
                    loadingView.onChangeSkinType();
                }
                fk5 fk5Var = this.k;
                if (fk5Var != null) {
                    fk5Var.onChangeSkinType();
                }
                gh8 gh8Var = this.a;
                if (gh8Var != null) {
                    gh8Var.D(i2);
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
                wa8 wa8Var = this.e;
                if (wa8Var != null) {
                    wa8Var.e(i2);
                }
                hb7 hb7Var = this.d;
                if (hb7Var != null) {
                    hb7Var.f();
                }
                yc8 yc8Var = this.s;
                if (yc8Var != null) {
                    yc8Var.o();
                }
                jdb jdbVar = this.t;
                if (jdbVar != null) {
                    jdbVar.g(2000);
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
        this.w = new k(this);
        this.x = new l(this);
        this.y = new m(this);
        this.A = new o(this);
        this.B = new q(this);
        this.C = new r(this, 2001115);
        this.D = new f(this);
        this.E = new g(this, 2921058);
        this.F = new h(this, 2921502);
        this.G = new i(this, 2921526);
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
        this.w = new k(this);
        this.x = new l(this);
        this.y = new m(this);
        this.A = new o(this);
        this.B = new q(this);
        this.C = new r(this, 2001115);
        this.D = new f(this);
        this.E = new g(this, 2921058);
        this.F = new h(this, 2921502);
        this.G = new i(this, 2921526);
    }

    public void I(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) {
            J(threadData, false);
        }
    }

    public boolean Z(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, recyclerView)) == null) {
            if (recyclerView == null || !recyclerView.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setCallback(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, tVar) == null) {
            this.g = tVar;
        }
    }

    public void setConcernFragment(ConcernFragment concernFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, concernFragment) == null) {
            this.u = concernFragment;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, scrollFragmentTabHost) == null) {
            this.p = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.y);
                this.p.b(this.y);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        za8 za8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (za8Var = this.h) != null) {
            za8Var.Z(z);
        }
    }

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            za8 za8Var = this.h;
            if (za8Var != null) {
                za8Var.N(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.p;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.y);
                this.p.b(this.y);
                this.y.a();
            }
        }
    }

    public void J(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, threadData, z) == null) {
            F();
            if (H) {
                np6 np6Var = this.i;
                if (np6Var != null) {
                    np6Var.r(threadData);
                    return;
                }
                return;
            }
            za8 za8Var = this.h;
            if (za8Var != null) {
                za8Var.A(threadData, z);
            }
        }
    }

    public void j0(DataRes dataRes, boolean z) {
        za8 za8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048610, this, dataRes, z) == null) && (za8Var = this.h) != null) {
            za8Var.M(z, dataRes, 0, null);
        }
    }

    public void k0(String str, int i2) {
        za8 za8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048611, this, str, i2) == null) && (za8Var = this.h) != null) {
            za8Var.M(true, null, i2, str);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            mqa.c().f(true);
            if (!TbadkCoreApplication.isLogin()) {
                h0();
                return;
            }
            za8 za8Var = this.h;
            if (za8Var != null) {
                za8Var.b0();
                e0(true);
            }
            np6 np6Var = this.i;
            if (np6Var != null) {
                np6Var.f();
                e0(true);
            }
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.z.setVisibility(0);
            this.c.setVisibility(0);
            this.s.r(true);
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.w(0);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            addView(this.s.k(), 0);
            addView(this.z);
            addView(this.m, new FrameLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), R.dimen.tbds83)));
        }
    }

    public void G(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, context) != null) || context == null) {
            return;
        }
        this.r = true;
        if (H) {
            this.c = new BdRecyclerView(context);
        } else {
            this.c = new BdTypeRecyclerView(context);
        }
        this.c.setLayoutManager(new LinearLayoutManager(context));
        this.c.setFadingEdgeLength(0);
        this.c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        yc8 yc8Var = new yc8(this, this.c);
        this.s = yc8Var;
        yc8Var.q(context.getString(R.string.tab_name_concern));
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.z = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.c);
        this.z.setFocusable(true);
        this.z.setFocusableInTouchMode(true);
        this.z.setDescendantFocusability(393216);
        PbListView pbListView = new PbListView(context);
        this.b = pbListView;
        pbListView.a();
        this.b.s(R.color.transparent);
        this.b.B();
        this.b.J(SkinManager.getColor(R.color.CAM_X0107));
        this.b.L(R.dimen.tbfontsize33);
        this.b.F(R.color.CAM_X0110);
        this.b.G(this.D);
        this.c.setNextPage(this.b);
        BdPageContext<?> a2 = a5.a(context);
        if (a2 instanceof TbPageContext) {
            this.f = (TbPageContext) a2;
        }
        this.s.p(this.f);
        gh8 gh8Var = new gh8(this.f);
        this.a = gh8Var;
        gh8Var.w(true);
        this.z.setProgressView(this.a);
        int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
        this.z.setCustomDistances(i2, i2, i2 * 2);
        if (H) {
            this.d = new FeedTemplateAdapter();
            this.d.d(new p(this, new cc7(new pp6())));
            hb7 hb7Var = this.d;
            op6 op6Var = new op6();
            op6Var.b("2");
            hb7Var.b(new bc7(op6Var));
            this.d.j(new gd7());
            this.d.j(new ob7());
            this.d.e(this.c);
            np6 np6Var = new np6(this.f.getPageActivity());
            this.i = np6Var;
            np6Var.x(this.u);
            this.i.h(this.B);
        } else {
            wa8 wa8Var = new wa8(context, (BdTypeRecyclerView) this.c);
            this.e = wa8Var;
            this.h = new za8(this.f, (BdTypeRecyclerView) this.c, wa8Var, this.z);
        }
        this.z.setVisibility(8);
        this.s.r(false);
        PublishProgressView publishProgressView = new PublishProgressView(context);
        this.m = publishProgressView;
        publishProgressView.setVisibility(8);
        R(TbadkCoreApplication.getInst().getSkinType());
        if (this.t == null) {
            this.t = new jdb(this.f, this.c);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            za8 za8Var = this.h;
            if (za8Var != null) {
                za8Var.Y(this.A);
            }
            this.a.a(new s(this));
            this.a.b(new a(this));
            this.a.e(new b(this));
            this.c.setOnSrollToBottomListener(this.x);
            this.c.removeOnScrollListener(this.w);
            this.c.addOnScrollListener(this.w);
            this.c.setRecyclerListener(new c(this));
            MessageManager.getInstance().registerListener(this.G);
            MessageManager.getInstance().registerListener(this.C);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.p;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.y);
            }
            this.c.removeOnScrollListener(this.w);
            MessageManager.getInstance().unRegisterListener(this.G);
            MessageManager.getInstance().unRegisterListener(this.C);
            za8 za8Var = this.h;
            if (za8Var != null) {
                za8Var.Y(null);
            }
            this.a.a(null);
            this.a.b(null);
            this.c.setOnSrollToBottomListener(null);
            this.a.e(null);
            this.a.U();
            this.c.setRecyclerListener(null);
            za8 za8Var2 = this.h;
            if (za8Var2 != null) {
                za8Var2.L();
            }
            np6 np6Var = this.i;
            if (np6Var != null) {
                np6Var.a();
            }
        }
    }

    public void b0() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (bdRecyclerView = this.c) != null && this.z != null) {
            if (this.n && bdRecyclerView.getFirstVisiblePosition() != 0) {
                this.n = false;
                return;
            }
            this.c.setSelection(0);
            if (!this.z.t()) {
                NoDataView noDataView = this.l;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (H) {
                            this.i.f();
                            F();
                            e0(true);
                        } else {
                            za8 za8Var = this.h;
                            if (za8Var != null) {
                                za8Var.b0();
                            }
                        }
                    }
                } else {
                    this.z.setRefreshing(true);
                }
            }
            if (!this.z.t()) {
                this.z.setRefreshing(true);
            }
            ScrollFragmentTabHost.s sVar = this.y;
            if (sVar != null) {
                sVar.a();
            }
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.l == null) {
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f04c9), new e(this)));
                this.l = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOTLOGIN), NoDataViewFactory.e.d(null, getContext().getResources().getString(R.string.obfuscated_res_0x7f0f04d1)), a2);
            }
            this.z.setVisibility(8);
            this.s.r(false);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            this.l.f(this.f, TbadkCoreApplication.getInst().getSkinType());
            this.l.setVisibility(0);
            this.l.bringToFront();
            ConcernFragment concernFragment = this.u;
            if (concernFragment != null) {
                fp5.a.h(concernFragment.getUniqueId());
            }
        }
    }

    public void X() {
        wa8 wa8Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (wa8Var = this.e) == null) {
            return;
        }
        List<pi> a2 = wa8Var.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (pi piVar : a2) {
            if (piVar instanceof dn6) {
                dn6 dn6Var = (dn6) piVar;
                if (dn6Var.j != 0 && (threadData = dn6Var.a) != null) {
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    dn6Var.j = imageWidthAndHeight[0];
                    dn6Var.k = imageWidthAndHeight[1];
                }
            }
        }
        SafeHandler.getInst().postDelayed(new j(this), 500L);
    }

    public void d0() {
        np6 np6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.z.setVisibility(0);
            this.c.setVisibility(0);
            this.s.r(true);
            za8 za8Var = this.h;
            if ((za8Var != null && za8Var.z()) || ((np6Var = this.i) != null && np6Var.p())) {
                this.b.U();
            } else {
                this.b.h();
            }
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.w(BdUtilHelper.getDimens(getContext(), R.dimen.tbds150));
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048605, this, z) != null) || L()) {
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

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048606, this, z) != null) || N()) {
            return;
        }
        if (this.k == null) {
            this.k = new fk5(getContext(), new d(this));
        }
        this.k.attachView(this, z);
        this.k.q();
        ConcernFragment concernFragment = this.u;
        if (concernFragment != null) {
            fp5.a.a(concernFragment.getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair<>("error_info", "home follow net error"));
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bdUniqueId) == null) {
            this.v = bdUniqueId;
            wa8 wa8Var = this.e;
            if (wa8Var != null) {
                wa8Var.h(bdUniqueId);
            }
            za8 za8Var = this.h;
            if (za8Var != null) {
                za8Var.a0(bdUniqueId);
            }
            gh8 gh8Var = this.a;
            if (gh8Var != null) {
                gh8Var.W(bdUniqueId);
            }
            CustomMessageListener customMessageListener = this.E;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.E);
            }
            CustomMessageListener customMessageListener2 = this.F;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.F);
            }
            br6.b().b(new ar6(bdUniqueId, w95.class), new n(this, w95.class));
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            int i2 = SharedPrefHelper.getInstance().getInt("key_home_concern_all_status", 0);
            if (this.l == null) {
                this.l = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOPOST), NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f04cb)), null);
            }
            if (i2 == 0) {
                this.l.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f04cc)));
                this.l.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOFOLLOW));
            } else {
                this.l.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f04cb)));
                this.l.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOPOST));
            }
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            this.l.f(this.f, TbadkCoreApplication.getInst().getSkinType());
            this.l.setVisibility(0);
            this.l.bringToFront();
        }
    }
}
