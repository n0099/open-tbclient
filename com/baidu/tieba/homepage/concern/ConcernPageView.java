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
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.aj6;
import com.baidu.tieba.bj6;
import com.baidu.tieba.bm7;
import com.baidu.tieba.cj6;
import com.baidu.tieba.do9;
import com.baidu.tieba.dx6;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.g17;
import com.baidu.tieba.g9;
import com.baidu.tieba.h07;
import com.baidu.tieba.h95;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.i07;
import com.baidu.tieba.i1a;
import com.baidu.tieba.ii;
import com.baidu.tieba.ik6;
import com.baidu.tieba.in;
import com.baidu.tieba.j07;
import com.baidu.tieba.jg;
import com.baidu.tieba.jk6;
import com.baidu.tieba.k07;
import com.baidu.tieba.mk6;
import com.baidu.tieba.nh6;
import com.baidu.tieba.op5;
import com.baidu.tieba.oy5;
import com.baidu.tieba.pg5;
import com.baidu.tieba.q45;
import com.baidu.tieba.qg5;
import com.baidu.tieba.rn7;
import com.baidu.tieba.sz6;
import com.baidu.tieba.ur7;
import com.baidu.tieba.vm7;
import com.baidu.tieba.yl7;
import com.baidu.tieba.z45;
import com.baidu.tieba.zu6;
import com.baidu.tieba.zz6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
    public static final boolean G;
    public transient /* synthetic */ FieldHolder $fh;
    public final j07.a<dx6> A;
    public final CustomMessageListener B;
    public View.OnClickListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final CustomMessageListener F;
    public ur7 a;
    public PbListView b;
    public BdRecyclerView c;
    public sz6 d;
    public yl7 e;
    public TbPageContext<?> f;
    public r g;
    public bm7 h;
    public k07 i;
    public ConcernNotLoginLayout j;
    public pg5 k;
    public qg5 l;
    public NoDataView m;
    public PublishProgressView n;
    public boolean o;
    public int p;
    public ScrollFragmentTabHost q;
    public int r;
    public boolean s;
    public rn7 t;
    public i1a u;
    public RecyclerView.OnScrollListener v;
    public BdListView.p w;
    public ScrollFragmentTabHost.r x;
    public BigdaySwipeRefreshLayout y;
    public bm7.o z;

    /* loaded from: classes4.dex */
    public interface r {
        void a(boolean z, boolean z2);

        void b(op5 op5Var);

        void c(String str, op5 op5Var);
    }

    /* loaded from: classes4.dex */
    public class m implements bm7.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.u != null) {
                    this.a.a.u.g();
                }
            }
        }

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

        @Override // com.baidu.tieba.bm7.o
        public void a(op5 op5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, op5Var) != null) {
                return;
            }
            this.a.E();
            this.a.F();
            this.a.c.setSelection(0);
            if (ConcernPageView.G) {
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
                this.a.g.b(op5Var);
            }
        }

        @Override // com.baidu.tieba.bm7.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.g != null) {
                    this.a.g.a(true, false);
                }
                this.a.D();
                this.a.E();
                this.a.c.setVisibility(8);
                this.a.t.r(false);
                this.a.h0();
            }
        }

        @Override // com.baidu.tieba.bm7.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.g != null) {
                    this.a.g.a(z, z2);
                }
                if (!this.a.K() && this.a.u != null) {
                    jg.a().postDelayed(new a(this), 300L);
                }
                if (this.a.u != null) {
                    this.a.u.i(2000);
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

        @Override // com.baidu.tieba.bm7.o
        public void d(String str, op5 op5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, op5Var) == null) {
                this.a.E();
                this.a.F();
                this.a.D();
                this.a.e0();
                if (this.a.g != null) {
                    this.a.g.c(str, op5Var);
                }
            }
        }

        @Override // com.baidu.tieba.bm7.o
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
                this.a.t.r(false);
                this.a.g0(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements z45.f {
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

        @Override // com.baidu.tieba.z45.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (this.a.u != null) {
                    this.a.u.h(false);
                }
                if (this.a.u != null) {
                    this.a.u.i(2000);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.u != null) {
                    this.a.u.e(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.i.d();
                    this.a.E();
                    this.a.f0(true);
                } else if (this.a.h != null && BdNetTypeUtil.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                    this.a.h.update();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.P();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ConcernPageView concernPageView, int i) {
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
            this.a.o = true;
            this.a.c0();
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (this.a.h != null) {
                    if (intValue == 1) {
                        this.a.h.p();
                    } else {
                        this.a.h.R();
                    }
                }
                if (this.a.m == null) {
                    return;
                }
                if (intValue == 1) {
                    this.a.m.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0457)));
                } else {
                    this.a.m.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0456)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            PublishProgressData publishProgressData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof PublishProgressData) && (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) != null && !do9.g() && do9.a() != null && this.a.n != null) {
                this.a.n.c(publishProgressData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
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

    /* loaded from: classes4.dex */
    public class i extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i == 0 && this.a.u != null) {
                    this.a.u.i(100);
                }
                if (i == 1 && this.a.u != null) {
                    this.a.u.d();
                }
                if (this.a.u != null && !this.a.K()) {
                    this.a.u.g();
                }
                if (this.a.r == i || this.a.q == null) {
                    return;
                }
                this.a.r = i;
                if (this.a.r == 1) {
                    this.a.q.a();
                } else if (this.a.a0(recyclerView)) {
                    this.a.q.c();
                } else {
                    this.a.q.a();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (this.a.t != null) {
                    this.a.t.j();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.P();
        }
    }

    /* loaded from: classes4.dex */
    public class k extends ScrollFragmentTabHost.r {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.r
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.q == null) {
                return;
            }
            this.a.r = -1;
            ConcernPageView concernPageView = this.a;
            if (concernPageView.a0(concernPageView.c)) {
                this.a.q.c();
            } else {
                this.a.q.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends mk6<h95> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ConcernPageView concernPageView, Class cls) {
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
        @Override // com.baidu.tieba.mk6
        public void onEvent(@NonNull h95 h95Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, h95Var) != null) || !"recommend_user".equals(h95Var.getType())) {
                return;
            }
            this.b.C();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements j07.a<dx6> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j07.a
        /* renamed from: b */
        public void a(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dx6Var) == null) {
                this.a.y.setRefreshing(false);
                this.a.D();
                this.a.F();
                if (dx6Var == null) {
                    return;
                }
                if (dx6Var.c != 0) {
                    if (ListUtils.isEmpty(dx6Var.a)) {
                        this.a.g0(true);
                        return;
                    }
                    return;
                }
                this.a.E();
                if (ListUtils.isEmpty(dx6Var.a)) {
                    this.a.b.M(8);
                    this.a.h0();
                } else {
                    this.a.b.M(0);
                    if (dx6Var.b) {
                        this.a.e0();
                    } else {
                        this.a.d0();
                    }
                }
                this.a.d.setList(dx6Var.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ConcernPageView concernPageView, int i) {
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

    /* loaded from: classes4.dex */
    public class p implements z45.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernPageView a;

        public p(ConcernPageView concernPageView) {
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

        @Override // com.baidu.tieba.z45.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                oy5.c().f("page_concern");
                if (this.a.h != null) {
                    this.a.h.update();
                }
                if (this.a.i != null) {
                    this.a.i.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements z45.h {
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

        @Override // com.baidu.tieba.z45.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.u != null) {
                this.a.u.h(true);
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
        G = N();
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
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bigdaySwipeRefreshLayout = this.y) != null) {
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
            bm7 bm7Var = this.h;
            if (bm7Var != null) {
                bm7Var.update();
                f0(true);
            }
            k07 k07Var = this.i;
            if (k07Var != null) {
                k07Var.d();
                f0(true);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new vm7.b().execute(new Integer[0]);
            TiebaStatic.log(new StatisticItem("c13572"));
            k07 k07Var = this.i;
            if (k07Var != null) {
                k07Var.a();
            }
        }
    }

    public final void D() {
        pg5 pg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pg5Var = this.k) != null) {
            pg5Var.dettachView(this);
            this.k = null;
        }
    }

    public final void E() {
        qg5 qg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (qg5Var = this.l) != null) {
            qg5Var.dettachView(this);
            this.l = null;
        }
    }

    public final void F() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (noDataView = this.m) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return q45.m().i("key_reaction_guide_show_number", false);
        }
        return invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            pg5 pg5Var = this.k;
            if (pg5Var != null) {
                return pg5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            qg5 qg5Var = this.l;
            if (qg5Var != null) {
                return qg5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            bm7 bm7Var = this.h;
            if (bm7Var != null) {
                bm7Var.G();
            }
            k07 k07Var = this.i;
            if (k07Var != null) {
                k07Var.e();
            }
        }
    }

    public void Q() {
        rn7 rn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (rn7Var = this.t) != null) {
            rn7Var.f();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            sz6 sz6Var = this.d;
            if (sz6Var != null) {
                sz6Var.notifyDataSetChanged();
            }
            yl7 yl7Var = this.e;
            if (yl7Var != null) {
                yl7Var.d();
            }
            Q();
        }
    }

    public void T() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (bdRecyclerView = this.c) != null) {
            bdRecyclerView.setOnSrollToBottomListener(this.w);
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
        i1a i1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (i1aVar = this.u) != null) {
            i1aVar.i(2000);
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
        bm7 bm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (bm7Var = this.h) != null) {
            bm7Var.J(true);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                i0();
                return;
            }
            bm7 bm7Var = this.h;
            if (bm7Var != null) {
                bm7Var.Q();
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            setViewForeground(false);
            bm7 bm7Var = this.h;
            if (bm7Var != null) {
                bm7Var.J(false);
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
        this.o = false;
        this.p = 3;
        this.r = -1;
        this.s = false;
        this.v = new i(this);
        this.w = new j(this);
        this.x = new k(this);
        this.z = new m(this);
        this.A = new n(this);
        this.B = new o(this, 2001115);
        this.C = new d(this);
        this.D = new e(this, 2921058);
        this.E = new f(this, 2921502);
        this.F = new g(this, 2921526);
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (this.p != i2) {
                ConcernNotLoginLayout concernNotLoginLayout = this.j;
                if (concernNotLoginLayout != null) {
                    concernNotLoginLayout.b(i2);
                }
                pg5 pg5Var = this.k;
                if (pg5Var != null) {
                    pg5Var.onChangeSkinType();
                }
                qg5 qg5Var = this.l;
                if (qg5Var != null) {
                    qg5Var.onChangeSkinType();
                }
                ur7 ur7Var = this.a;
                if (ur7Var != null) {
                    ur7Var.H(i2);
                }
                PbListView pbListView = this.b;
                if (pbListView != null) {
                    pbListView.H(SkinManager.getColor(R.color.CAM_X0109));
                    this.b.e(i2);
                }
                NoDataView noDataView = this.m;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    this.m.f(this.f, i2);
                    this.m.setSubTitleTextColor(R.color.CAM_X0105);
                }
                PublishProgressView publishProgressView = this.n;
                if (publishProgressView != null) {
                    publishProgressView.b();
                }
                yl7 yl7Var = this.e;
                if (yl7Var != null) {
                    yl7Var.e(i2);
                }
                sz6 sz6Var = this.d;
                if (sz6Var != null) {
                    sz6Var.b();
                }
                rn7 rn7Var = this.t;
                if (rn7Var != null) {
                    rn7Var.o();
                }
                i1a i1aVar = this.u;
                if (i1aVar != null) {
                    i1aVar.i(2000);
                }
            }
            this.p = i2;
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
        this.o = false;
        this.p = 3;
        this.r = -1;
        this.s = false;
        this.v = new i(this);
        this.w = new j(this);
        this.x = new k(this);
        this.z = new m(this);
        this.A = new n(this);
        this.B = new o(this, 2001115);
        this.C = new d(this);
        this.D = new e(this, 2921058);
        this.E = new f(this, 2921502);
        this.F = new g(this, 2921526);
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
        this.o = false;
        this.p = 3;
        this.r = -1;
        this.s = false;
        this.v = new i(this);
        this.w = new j(this);
        this.x = new k(this);
        this.z = new m(this);
        this.A = new n(this);
        this.B = new o(this, 2001115);
        this.C = new d(this);
        this.D = new e(this, 2921058);
        this.E = new f(this, 2921502);
        this.F = new g(this, 2921526);
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

    public void setCallback(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, rVar) == null) {
            this.g = rVar;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, scrollFragmentTabHost) == null) {
            this.q = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.x);
                this.q.b(this.x);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        bm7 bm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (bm7Var = this.h) != null) {
            bm7Var.Z(z);
        }
    }

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            bm7 bm7Var = this.h;
            if (bm7Var != null) {
                bm7Var.N(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.q;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.x);
                this.q.b(this.x);
                this.x.a();
            }
        }
    }

    public void J(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, threadData, z) == null) {
            F();
            if (G) {
                k07 k07Var = this.i;
                if (k07Var != null) {
                    k07Var.c(threadData);
                    return;
                }
                return;
            }
            bm7 bm7Var = this.h;
            if (bm7Var != null) {
                bm7Var.A(threadData, z);
            }
        }
    }

    public void k0(DataRes dataRes, boolean z) {
        bm7 bm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048611, this, dataRes, z) == null) && (bm7Var = this.h) != null) {
            bm7Var.M(z, dataRes, 0, null);
        }
    }

    public void l0(String str, int i2) {
        bm7 bm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048612, this, str, i2) == null) && (bm7Var = this.h) != null) {
            bm7Var.M(true, null, i2, str);
        }
    }

    public void G(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, context) != null) || context == null) {
            return;
        }
        this.s = true;
        if (G) {
            if (zu6.a.getBaseContext() == null) {
                zu6.a.a(TbadkCoreApplication.getInst());
            }
            this.c = new BdRecyclerView(context);
        } else {
            this.c = new BdTypeRecyclerView(context);
        }
        this.c.setLayoutManager(new LinearLayoutManager(context));
        this.c.setFadingEdgeLength(0);
        this.c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        rn7 rn7Var = new rn7(this, this.c);
        this.t = rn7Var;
        rn7Var.q(context.getString(R.string.tab_name_concern));
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.y = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.c);
        this.y.setFocusable(true);
        this.y.setFocusableInTouchMode(true);
        this.y.setDescendantFocusability(393216);
        PbListView pbListView = new PbListView(context);
        this.b = pbListView;
        pbListView.a();
        this.b.r(R.color.transparent);
        this.b.A();
        this.b.H(SkinManager.getColor(R.color.CAM_X0107));
        this.b.J(R.dimen.tbfontsize33);
        this.b.D(R.color.CAM_X0110);
        this.b.E(this.C);
        this.c.setNextPage(this.b);
        a9<?> a2 = g9.a(context);
        if (a2 instanceof TbPageContext) {
            this.f = (TbPageContext) a2;
        }
        this.t.p(this.f);
        if (UbsABTestHelper.isLaunchUpA()) {
            addView(this.y);
        }
        ur7 ur7Var = new ur7(this.f);
        this.a = ur7Var;
        ur7Var.A(true);
        this.y.setProgressView(this.a);
        int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
        this.y.setCustomDistances(i2, i2, i2 * 2);
        if (G) {
            FeedTemplateAdapter feedTemplateAdapter = new FeedTemplateAdapter();
            this.d = feedTemplateAdapter;
            feedTemplateAdapter.e(new i07(new cj6()));
            sz6 sz6Var = this.d;
            bj6 bj6Var = new bj6();
            bj6Var.b("2");
            sz6Var.c(new h07(bj6Var));
            this.d.j(new g17());
            this.d.j(new zz6());
            this.d.f(this.c);
            k07 k07Var = new k07(this.f.getPageActivity(), new aj6(this.f.getPageActivity()));
            this.i = k07Var;
            k07Var.f(this.A);
        } else {
            yl7 yl7Var = new yl7(context, (BdTypeRecyclerView) this.c);
            this.e = yl7Var;
            this.h = new bm7(this.f, (BdTypeRecyclerView) this.c, yl7Var, this.y);
        }
        this.y.setVisibility(8);
        this.t.r(false);
        this.n = new PublishProgressView(context);
        if (UbsABTestHelper.isLaunchUpA()) {
            addView(this.n, new FrameLayout.LayoutParams(-1, ii.g(getContext(), R.dimen.tbds83)));
        }
        this.n.setVisibility(8);
        S(TbadkCoreApplication.getInst().getSkinType());
        if (this.u == null) {
            this.u = new i1a(this.f, this.c);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            bm7 bm7Var = this.h;
            if (bm7Var != null) {
                bm7Var.Y(this.z);
            }
            this.a.f(new p(this));
            this.a.g(new q(this));
            this.a.m(new a(this));
            this.c.setOnSrollToBottomListener(this.w);
            this.c.removeOnScrollListener(this.v);
            this.c.addOnScrollListener(this.v);
            this.c.setRecyclerListener(new b(this));
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    public void c0() {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (bdRecyclerView = this.c) != null && this.y != null) {
            if (this.o && bdRecyclerView.getFirstVisiblePosition() != 0) {
                this.o = false;
                return;
            }
            this.c.setSelection(0);
            if (!this.y.t()) {
                NoDataView noDataView = this.m;
                if (noDataView != null && noDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (G) {
                            this.i.d();
                            F();
                            f0(true);
                        } else {
                            bm7 bm7Var = this.h;
                            if (bm7Var != null) {
                                bm7Var.update();
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
            ScrollFragmentTabHost.r rVar = this.x;
            if (rVar != null) {
                rVar.a();
            }
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.q;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.x);
            }
            this.c.removeOnScrollListener(this.v);
            MessageManager.getInstance().unRegisterListener(this.F);
            MessageManager.getInstance().unRegisterListener(this.B);
            bm7 bm7Var = this.h;
            if (bm7Var != null) {
                bm7Var.Y(null);
            }
            this.a.f(null);
            this.a.g(null);
            this.c.setOnSrollToBottomListener(null);
            this.a.m(null);
            this.a.Y();
            this.c.setRecyclerListener(null);
            bm7 bm7Var2 = this.h;
            if (bm7Var2 != null) {
                bm7Var2.L();
            }
        }
    }

    public void Y() {
        yl7 yl7Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (yl7Var = this.e) == null) {
            return;
        }
        List<in> a2 = yl7Var.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (in inVar : a2) {
            if (inVar instanceof nh6) {
                nh6 nh6Var = (nh6) inVar;
                if (nh6Var.j != 0 && (threadData = nh6Var.a) != null) {
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    nh6Var.j = imageWidthAndHeight[0];
                    nh6Var.k = imageWidthAndHeight[1];
                }
            }
        }
        jg.a().postDelayed(new h(this), 500L);
    }

    public void e0() {
        k07 k07Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.y.setVisibility(0);
            this.c.setVisibility(0);
            this.t.r(true);
            bm7 bm7Var = this.h;
            if ((bm7Var != null && bm7Var.z()) || ((k07Var = this.i) != null && k07Var.b())) {
                this.b.S();
            } else {
                this.b.h();
            }
            this.b.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.v(ii.g(getContext(), R.dimen.tbds150));
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.y.setVisibility(0);
            this.c.setVisibility(0);
            this.t.r(true);
            this.b.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.v(0);
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.j == null) {
                ConcernNotLoginLayout concernNotLoginLayout = new ConcernNotLoginLayout(getContext());
                this.j = concernNotLoginLayout;
                concernNotLoginLayout.b(this.p);
            }
            if (this.j.getParent() != null) {
                return;
            }
            this.y.setVisibility(8);
            this.t.r(false);
            this.j.setVisibility(0);
            addView(this.j);
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && !UbsABTestHelper.isLaunchUpA()) {
            addView(this.t.k(), 0);
            addView(this.y);
            addView(this.n, new FrameLayout.LayoutParams(-1, ii.g(getContext(), R.dimen.tbds83)));
        }
    }

    public final void f0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048606, this, z) != null) || M()) {
            return;
        }
        if (this.k == null) {
            this.k = new pg5(getContext());
            this.k.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + ii.g(getContext(), R.dimen.tbds60));
            this.k.i();
            this.k.setWrapStyle(true);
        }
        this.k.onChangeSkinType();
        this.k.attachView(this, z);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bdUniqueId) == null) {
            yl7 yl7Var = this.e;
            if (yl7Var != null) {
                yl7Var.h(bdUniqueId);
            }
            bm7 bm7Var = this.h;
            if (bm7Var != null) {
                bm7Var.a0(bdUniqueId);
            }
            ur7 ur7Var = this.a;
            if (ur7Var != null) {
                ur7Var.a0(bdUniqueId);
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
            jk6.b().a(new ik6(bdUniqueId, this), new l(this, h95.class));
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048607, this, z) != null) || O()) {
            return;
        }
        if (this.l == null) {
            this.l = new qg5(getContext(), new c(this));
        }
        this.l.attachView(this, z);
        this.l.p();
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int n2 = q45.m().n("key_home_concern_all_status", 0);
            if (this.m == null) {
                this.m = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0456)), null);
            }
            if (n2 == 1) {
                this.m.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0457)));
                this.m.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.GIFT));
            } else {
                this.m.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0456)));
                this.m.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL));
            }
            this.m.f(this.f, TbadkCoreApplication.getInst().getSkinType());
            this.m.setVisibility(0);
            this.m.bringToFront();
        }
    }
}
