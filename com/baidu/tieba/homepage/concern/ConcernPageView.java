package com.baidu.tieba.homepage.concern;

import android.content.Context;
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
import com.repackage.av4;
import com.repackage.aw6;
import com.repackage.d07;
import com.repackage.d9;
import com.repackage.g65;
import com.repackage.h65;
import com.repackage.h9;
import com.repackage.lu6;
import com.repackage.n06;
import com.repackage.nl5;
import com.repackage.oi;
import com.repackage.on;
import com.repackage.ou6;
import com.repackage.qi;
import com.repackage.rg;
import com.repackage.ru4;
import com.repackage.vd5;
import com.repackage.vm8;
import com.repackage.wy8;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes3.dex */
public class ConcernPageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public d07 a;
    public PbListView b;
    public BdTypeRecyclerView c;
    public lu6 d;
    public TbPageContext<?> e;
    public o f;
    public ou6 g;
    public ConcernNotLoginLayout h;
    public g65 i;
    public h65 j;
    public NoDataView k;
    public PublishProgressView l;
    public boolean m;
    public int n;
    public ScrollFragmentTabHost o;
    public int p;
    public boolean q;
    public aw6 r;
    public wy8 s;
    public RecyclerView.OnScrollListener t;
    public ScrollFragmentTabHost.y u;
    public BigdaySwipeRefreshLayout v;
    public ou6.o w;
    public View.OnClickListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.F();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.m = true;
            this.a.Q();
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.k.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f042a)));
            } else {
                this.a.k.setTextOption(NoDataViewFactory.e.d(null, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0429)));
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PublishProgressData publishProgressData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof PublishProgressData) || (publishProgressData = (PublishProgressData) customResponsedMessage.getData()) == null || vm8.k().s() || vm8.k().i() == null || this.a.l == null) {
                return;
            }
            this.a.l.c(publishProgressData);
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.G();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.s.d();
                }
                if (i == 1 && this.a.s != null) {
                    this.a.s.c();
                }
                if (this.a.p == i || this.a.o == null) {
                    return;
                }
                this.a.p = i;
                if (this.a.p == 1) {
                    this.a.o.a();
                } else if (this.a.O(recyclerView)) {
                    this.a.o.c();
                } else {
                    this.a.o.a();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (this.a.r != null) {
                    this.a.r.j();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends ScrollFragmentTabHost.y {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.y
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.o == null) {
                return;
            }
            this.a.p = -1;
            ConcernPageView concernPageView = this.a;
            if (concernPageView.O(concernPageView.c)) {
                this.a.o.c();
            } else {
                this.a.o.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements ou6.o {
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

        @Override // com.repackage.ou6.o
        public void a(vd5 vd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vd5Var) == null) {
                this.a.w();
                this.a.x();
                this.a.c.setSelection(0);
                if (this.a.c.getCount() > 0) {
                    this.a.v();
                    this.a.R();
                } else {
                    this.a.T(true);
                }
                if (this.a.f != null) {
                    this.a.f.b(vd5Var);
                }
            }
        }

        @Override // com.repackage.ou6.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.f != null) {
                    this.a.f.a(true, false);
                }
                this.a.v();
                this.a.w();
                this.a.c.setVisibility(8);
                this.a.r.q(false);
                this.a.V();
            }
        }

        @Override // com.repackage.ou6.o
        public void c(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.f != null) {
                    this.a.f.a(z, z2);
                }
                this.a.v();
                this.a.w();
                this.a.x();
                if (this.a.g.C()) {
                    this.a.R();
                } else {
                    this.a.S();
                }
            }
        }

        @Override // com.repackage.ou6.o
        public void d(String str, vd5 vd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, vd5Var) == null) {
                this.a.w();
                this.a.x();
                this.a.v();
                this.a.S();
                if (this.a.f != null) {
                    this.a.f.c(str, vd5Var);
                }
            }
        }

        @Override // com.repackage.ou6.o
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                if (this.a.f != null) {
                    this.a.f.a(false, false);
                }
                this.a.v();
                this.a.x();
                if (i != 1) {
                    this.a.c.setVisibility(8);
                    this.a.r.q(false);
                    this.a.U(true);
                } else if (oi.z()) {
                    this.a.e.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements av4.g {
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

        @Override // com.repackage.av4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && TbadkCoreApplication.isLogin()) {
                nl5.c().f("page_concern");
                this.a.g.update();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements av4.h {
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

        @Override // com.repackage.av4.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.s == null) {
                return;
            }
            this.a.s.h(true);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements av4.f {
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

        @Override // com.repackage.av4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || this.a.s == null) {
                return;
            }
            this.a.s.h(false);
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.a.s != null) {
                    this.a.s.f(view2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null && oi.A() && TbadkCoreApplication.isLogin()) {
                this.a.g.update();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface o {
        void a(boolean z, boolean z2);

        void b(vd5 vd5Var);

        void c(String str, vd5 vd5Var);
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

    public void A(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            B(threadData, false);
        }
    }

    public void B(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData, z) == null) {
            x();
            this.g.z(threadData, z);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g65 g65Var = this.i;
            if (g65Var != null) {
                return g65Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            h65 h65Var = this.j;
            if (h65Var != null) {
                return h65Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void F() {
        ou6 ou6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (ou6Var = this.g) == null) {
            return;
        }
        ou6Var.F();
    }

    public void G() {
        aw6 aw6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aw6Var = this.r) == null) {
            return;
        }
        aw6Var.f();
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            lu6 lu6Var = this.d;
            if (lu6Var != null) {
                lu6Var.d();
            }
            G();
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (this.n != i2) {
                ConcernNotLoginLayout concernNotLoginLayout = this.h;
                if (concernNotLoginLayout != null) {
                    concernNotLoginLayout.b(i2);
                }
                g65 g65Var = this.i;
                if (g65Var != null) {
                    g65Var.onChangeSkinType();
                }
                h65 h65Var = this.j;
                if (h65Var != null) {
                    h65Var.onChangeSkinType();
                }
                d07 d07Var = this.a;
                if (d07Var != null) {
                    d07Var.H(i2);
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
                aw6 aw6Var = this.r;
                if (aw6Var != null) {
                    aw6Var.n();
                }
            }
            this.n = i2;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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

    public void K() {
        wy8 wy8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (wy8Var = this.s) == null) {
            return;
        }
        wy8Var.e();
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setTabInForeBackgroundState(false);
            H();
        }
    }

    public void M() {
        lu6 lu6Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (lu6Var = this.d) == null) {
            return;
        }
        List<on> a2 = lu6Var.a();
        if (ListUtils.isEmpty(a2)) {
            return;
        }
        for (on onVar : a2) {
            if (onVar instanceof n06) {
                n06 n06Var = (n06) onVar;
                if (n06Var.j != 0 && (threadData = n06Var.a) != null) {
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    n06Var.j = imageWidthAndHeight[0];
                    n06Var.k = imageWidthAndHeight[1];
                }
            }
        }
        rg.a().postDelayed(new e(this), 500L);
    }

    public void N() {
        ou6 ou6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (ou6Var = this.g) == null) {
            return;
        }
        ou6Var.I(true);
    }

    public boolean O(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                W();
                return;
            }
            ou6 ou6Var = this.g;
            if (ou6Var != null) {
                ou6Var.P();
            }
        }
    }

    public void Q() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bdTypeRecyclerView = this.c) == null || this.v == null) {
            return;
        }
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
        ScrollFragmentTabHost.y yVar = this.u;
        if (yVar != null) {
            yVar.a();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.v.setVisibility(0);
            this.c.setVisibility(0);
            this.r.q(true);
            this.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.t(0);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.v.setVisibility(0);
            this.c.setVisibility(0);
            this.r.q(true);
            if (this.g.y()) {
                this.b.Q();
            } else {
                this.b.g();
            }
            this.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.t(qi.f(getContext(), R.dimen.tbds150));
        }
    }

    public final void T(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || D()) {
            return;
        }
        if (this.i == null) {
            this.i = new g65(getContext());
            this.i.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + qi.f(getContext(), R.dimen.tbds60));
            this.i.i();
            this.i.setWrapStyle(true);
        }
        this.i.onChangeSkinType();
        this.i.attachView(this, z);
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || E()) {
            return;
        }
        if (this.j == null) {
            this.j = new h65(getContext(), new n(this));
        }
        this.j.attachView(this, z);
        this.j.p();
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int l2 = ru4.k().l("key_home_concern_all_status", 0);
            if (this.k == null) {
                this.k = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0429)), null);
            }
            if (l2 == 1) {
                this.k.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f042a)));
                this.k.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.GIFT));
            } else {
                this.k.setTextOption(NoDataViewFactory.e.d(null, getContext().getString(R.string.obfuscated_res_0x7f0f0429)));
                this.k.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.SINGALL));
            }
            this.k.f(this.e, TbadkCoreApplication.getInst().getSkinType());
            this.k.setVisibility(0);
            this.k.bringToFront();
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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

    public void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || UbsABTestHelper.isLaunchUpA()) {
            return;
        }
        addView(this.r.k(), 0);
        addView(this.v);
        addView(this.l, new FrameLayout.LayoutParams(-1, qi.f(getContext(), R.dimen.tbds83)));
    }

    public void Y(DataRes dataRes, boolean z) {
        ou6 ou6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048600, this, dataRes, z) == null) || (ou6Var = this.g) == null) {
            return;
        }
        ou6Var.L(z, dataRes, 0, null);
    }

    public void Z(String str, int i2) {
        ou6 ou6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048601, this, str, i2) == null) || (ou6Var = this.g) == null) {
            return;
        }
        ou6Var.L(true, null, i2, str);
    }

    public void setCallback(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, oVar) == null) {
            this.f = oVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bdUniqueId) == null) {
            lu6 lu6Var = this.d;
            if (lu6Var != null) {
                lu6Var.h(bdUniqueId);
            }
            ou6 ou6Var = this.g;
            if (ou6Var != null) {
                ou6Var.Z(bdUniqueId);
            }
            d07 d07Var = this.a;
            if (d07Var != null) {
                d07Var.b0(bdUniqueId);
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

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, scrollFragmentTabHost) == null) {
            this.o = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.u);
                this.o.b(this.u);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        ou6 ou6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || (ou6Var = this.g) == null) {
            return;
        }
        ou6Var.Y(z);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            setViewForeground(false);
            ou6 ou6Var = this.g;
            if (ou6Var != null) {
                ou6Var.I(false);
            }
        }
    }

    public void t() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (bigdaySwipeRefreshLayout = this.v) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.r();
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                W();
                return;
            }
            ou6 ou6Var = this.g;
            if (ou6Var != null) {
                ou6Var.update();
                T(true);
            }
        }
    }

    public final void v() {
        g65 g65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (g65Var = this.i) == null) {
            return;
        }
        g65Var.dettachView(this);
        this.i = null;
    }

    public final void w() {
        h65 h65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (h65Var = this.j) == null) {
            return;
        }
        h65Var.dettachView(this);
        this.j = null;
    }

    public final void x() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (noDataView = this.k) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public void y(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, context) == null) || context == null) {
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
        aw6 aw6Var = new aw6(this, this.c);
        this.r = aw6Var;
        aw6Var.p(context.getString(R.string.obfuscated_res_0x7f0f134a));
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
        this.v = bigdaySwipeRefreshLayout;
        bigdaySwipeRefreshLayout.addView(this.c);
        PbListView pbListView = new PbListView(context);
        this.b = pbListView;
        pbListView.a();
        this.b.p(R.color.transparent);
        this.b.x();
        this.b.E(SkinManager.getColor(R.color.CAM_X0107));
        this.b.G(R.dimen.tbfontsize33);
        this.b.A(R.color.CAM_X0110);
        this.b.B(this.x);
        this.c.setNextPage(this.b);
        d9<?> a2 = h9.a(context);
        if (a2 instanceof TbPageContext) {
            this.e = (TbPageContext) a2;
        }
        this.r.o(this.e);
        if (UbsABTestHelper.isLaunchUpA()) {
            addView(this.v);
        }
        d07 d07Var = new d07(this.e);
        this.a = d07Var;
        d07Var.A(true);
        this.v.setProgressView(this.a);
        int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
        this.v.setCustomDistances(i2, i2, i2 * 2);
        lu6 lu6Var = new lu6(context, this.c);
        this.d = lu6Var;
        this.g = new ou6(this.e, this.c, lu6Var, this.v);
        this.v.setVisibility(8);
        this.r.q(false);
        this.l = new PublishProgressView(context);
        if (UbsABTestHelper.isLaunchUpA()) {
            addView(this.l, new FrameLayout.LayoutParams(-1, qi.f(getContext(), R.dimen.tbds83)));
        }
        this.l.setVisibility(8);
        I(TbadkCoreApplication.getInst().getSkinType());
        if (this.s == null) {
            this.s = new wy8(this.e, this.c);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
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

    public void setViewForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            ou6 ou6Var = this.g;
            if (ou6Var != null) {
                ou6Var.M(z);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.o;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.u);
                this.o.b(this.u);
                this.u.a();
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
}
