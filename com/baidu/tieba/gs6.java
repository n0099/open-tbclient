package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class gs6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern r;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public RelativeLayout b;
    public BdTypeRecyclerView c;
    public FrameLayout d;
    public PbListView e;
    public fs6 f;
    public BannerView g;
    public zs4 h;
    public boolean i;
    public RelativeLayout j;
    public ao6 k;
    public boolean l;
    public o39 m;
    public BannerView.b n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs6 a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f.l();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(gs6 gs6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs6Var, Integer.valueOf(i)};
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
            this.a = gs6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<xn> j = this.a.f.j();
                if (ListUtils.isEmpty(j)) {
                    return;
                }
                if (!ListUtils.isEmpty(j)) {
                    for (xn xnVar : j) {
                        if (xnVar instanceof wu4) {
                            wu4 wu4Var = (wu4) xnVar;
                            if (wu4Var.u != 0 && (threadData = wu4Var.t) != null) {
                                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                                wu4Var.u = imageWidthAndHeight[0];
                                wu4Var.v = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                ah.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs6 a;

        public a(gs6 gs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (view2 = viewHolder.itemView) != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.obfuscated_res_0x7f09002d);
                if (playVoiceBnt != null) {
                    playVoiceBnt.k();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.obfuscated_res_0x7f09002b);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
                if (this.a.m != null) {
                    this.a.m.e(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs6 a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(gs6 gs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs6Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, str, z) != null) || !z || !this.a.g.i() || this.a.i || this.a.c == null) {
                return;
            }
            this.a.i = true;
            this.a.c.t(this.a.g, 1);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs6 a;

        public c(gs6 gs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs6Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.j();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs6 a;

        public d(gs6 gs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.removeHeaderView(this.a.j);
                this.a.c.t(this.a.j, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(gs6 gs6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs6Var, Integer.valueOf(i)};
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
            this.a = gs6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.B(str);
                this.a.A(str);
                this.a.f.p();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(gs6 gs6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs6Var, Integer.valueOf(i)};
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
            this.a = gs6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.l();
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-765594053, "Lcom/baidu/tieba/gs6$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-765594053, "Lcom/baidu/tieba/gs6$h;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804543, "Lcom/baidu/tieba/gs6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804543, "Lcom/baidu/tieba/gs6;");
                return;
            }
        }
        r = Pattern.compile("(/p/){1}(\\d+)");
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.l) {
                return false;
            }
            this.e.E(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a6f));
            this.e.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qj6 qj6Var = new qj6();
            qj6Var.a = 503;
            qj6Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, qj6Var));
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.m();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.c.setVisibility(0);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c.setNextPage(this.e);
            this.e.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.e.S();
        }
    }

    public void Q() {
        o39 o39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (o39Var = this.m) != null) {
            o39Var.i(2000);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            qj6 qj6Var = new qj6();
            qj6Var.a = 503;
            qj6Var.b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, qj6Var));
        }
    }

    public fs6 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.f;
        }
        return (fs6) invokeV.objValue;
    }

    public BdTypeRecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.c;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public void s() {
        fs6 fs6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (fs6Var = this.f) != null) {
            fs6Var.l();
        }
    }

    public void t() {
        o39 o39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (o39Var = this.m) != null) {
            o39Var.d();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f.o();
            this.c.setOnSrollToBottomListener(null);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f.l();
        }
    }

    public void z() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (bannerView = this.g) != null) {
            this.i = false;
            this.c.removeHeaderView(bannerView);
        }
    }

    public gs6(FrsNewAreaFragment frsNewAreaFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.g = null;
        this.i = false;
        this.l = true;
        this.n = new c(this);
        this.o = new e(this, 2921414);
        this.p = new f(this, 2016331);
        this.q = new g(this, 2921746);
        this.a = frsNewAreaFragment;
        r(view2);
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.Z1() != null) {
            this.a.Z1().M(str);
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && !z) {
            qj6 qj6Var = new qj6();
            qj6Var.a = 503;
            qj6Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, qj6Var));
        }
    }

    public void G(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            FrameLayout frameLayout = this.d;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            frameLayout.setVisibility(i);
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c.setSelection(i);
        }
    }

    public void J(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hoVar) == null) {
            this.f.u(hoVar);
        }
    }

    public void K(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onScrollListener) == null) {
            this.c.setOnScrollListener(onScrollListener);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            xj6 xj6Var = new xj6();
            xj6Var.a = 503;
            xj6Var.c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, xj6Var));
        }
    }

    public void u(int i, int i2) {
        o39 o39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048605, this, i, i2) == null) && (o39Var = this.m) != null) {
            o39Var.i(100);
        }
    }

    public void B(String str) {
        ThreadData threadData;
        jp8 jp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !StringUtils.isNull(str) && !ListUtils.isEmpty(this.f.j())) {
            Iterator<xn> it = this.f.j().iterator();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                xn next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof qr5)) {
                    it.remove();
                }
                if (next instanceof xo5) {
                    xo5 xo5Var = (xo5) next;
                    if ((xo5Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) xo5Var.a()).a)) {
                        it.remove();
                        i2 = i;
                    }
                } else if ((next instanceof wu4) && (threadData = ((wu4) next).t) != null && (jp8Var = threadData.funAdData) != null && jp8Var.i()) {
                    it.remove();
                    i3 = i;
                }
            }
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.l = z;
            if (z) {
                this.e.E(TbadkCoreApplication.getInst().getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0a6e));
                BdTypeRecyclerView bdTypeRecyclerView = this.c;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.e.b()) {
                    this.e.S();
                    this.a.b();
                    return;
                }
                this.e.f();
                return;
            }
            this.e.E(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a6f));
            this.e.f();
        }
    }

    public final List<FrsTabInfo> k(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().a.iterator();
            while (true) {
                if (it.hasNext()) {
                    FrsTabInfo next = it.next();
                    if (next.tab_id.intValue() == 503) {
                        i = next.tab_type.intValue();
                        break;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().b) {
                if (frsTabInfo.tab_type.intValue() == i) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void M(ArrayList<xn> arrayList, int i, FrsViewData frsViewData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{arrayList, Integer.valueOf(i), frsViewData, Integer.valueOf(i2)}) == null) {
            ArrayList<xn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
                oj6 oj6Var = new oj6();
                ArrayList<xn> arrayList2 = new ArrayList<>();
                arrayList2.add(oj6Var);
                switchThreadDataToThreadCardInfo = arrayList2;
            }
            if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                List<FrsTabInfo> k = k(frsViewData);
                if (ListUtils.isEmpty(k)) {
                    RelativeLayout relativeLayout = this.j;
                    if (relativeLayout != null) {
                        this.c.removeHeaderView(relativeLayout);
                    }
                } else if (this.j != null) {
                    this.c.post(new d(this));
                }
                if (frsViewData != null && frsViewData.getIsBrandForum()) {
                    FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(k, 0);
                    if (frsViewData != null && this.a.a2() != null && frsTabInfo != null) {
                        this.a.a2().P(frsTabInfo.tab_id.intValue());
                    }
                } else if (this.k != null && frsViewData.getForum() != null) {
                    this.k.i(k);
                    this.k.j(frsViewData.getForum().getId());
                    if (UbsABTestHelper.isFrsNewAreaTabSortTestA() && FrsTabTestHelper.HAVE_NOT_RECORD_SORT != FrsTabTestHelper.getFrsNewAreaTabSort()) {
                        this.k.g(mv6.d(FrsTabTestHelper.getFrsNewAreaTabSort()));
                    }
                }
            }
            this.f.q(switchThreadDataToThreadCardInfo, frsViewData);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.c.setNextPage(this.e);
            this.e.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.e.f();
            this.e.E(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1a));
        }
    }

    public final void j() {
        zs4 zs4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (zs4Var = this.h) == null) {
            return;
        }
        String d2 = zs4Var.d();
        if (this.h.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.a.getPageContext().getPageActivity(), d2, false, "frs_banner")));
        } else if (this.h.a() == 2) {
            if (d2.contains("tieba.baidu.com")) {
                Matcher matcher = r.matcher(d2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        } else if (this.h.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i = h.a[nativePageType.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                        createNormalCfg2.setForumId(isNativeAddress.id);
                        createNormalCfg2.setStartFrom(3);
                        this.a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                        return;
                    }
                    return;
                }
                this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                return;
            }
            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{d2});
            if (!StringUtils.isNull(d2) && d2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
            }
        } else if (this.h.a() == 4) {
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(d2, "frs_banner")));
        }
    }

    public final void l() {
        ThreadData threadData;
        jp8 jp8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            fs6 fs6Var = this.f;
            if (fs6Var != null && !ListUtils.isEmpty(fs6Var.j())) {
                Iterator<xn> it = this.f.j().iterator();
                while (it.hasNext()) {
                    xn next = it.next();
                    if (!(next instanceof xo5) && !(next instanceof qr5)) {
                        if ((next instanceof wu4) && (threadData = ((wu4) next).t) != null && (jp8Var = threadData.funAdData) != null) {
                            jp8Var.p(true);
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                }
            }
            A(null);
            this.f.p();
        }
    }

    public final void q(zs4 zs4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, zs4Var) != null) || this.g != null) {
            return;
        }
        this.g = new BannerView(this.a.getPageContext().getPageActivity());
        this.g.setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a)));
        this.g.setVisibility(8);
        this.g.setBannerViewClickListener(this.n);
        this.g.setBannerData(zs4Var);
        this.g.setBannerViewEvent(new b(this));
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            fs6 fs6Var = this.f;
            if (fs6Var != null) {
                fs6Var.w();
                this.f.l();
                this.f.n(i);
            }
            rq4 layoutMode = this.a.getBaseFragmentActivity().getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.b);
            BannerView bannerView = this.g;
            if (bannerView != null) {
                bannerView.j();
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.G(SkinManager.getColor(R.color.CAM_X0107));
                this.e.d(i);
            }
            this.k.h();
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b5a);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090b5c);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.c.setFadingEdgeLength(0);
            this.c.setOverScrollMode(2);
            this.c.setRecyclerListener(new a(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.c;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.c.getPaddingBottom());
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.e = pbListView;
            pbListView.a();
            this.e.q(R.color.transparent);
            this.e.u(yi.g(this.a.getActivity(), R.dimen.tbds182));
            this.e.z();
            this.e.I(R.dimen.tbfontsize33);
            this.e.G(SkinManager.getColor(R.color.CAM_X0107));
            this.e.C(R.color.CAM_X0110);
            this.c.setOnSrollToBottomListener(this.a);
            this.d = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090bbc);
            this.f = new fs6(this.a, this.c);
            F(false);
            this.j = new RelativeLayout(this.a.getContext());
            this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.k = new ao6(this.a, this.j);
            this.a.registerListener(this.o);
            this.a.registerListener(this.p);
            this.a.registerListener(this.q);
            if (this.m == null) {
                this.m = new o39(this.a.getPageContext(), this.c);
            }
        }
    }

    public void x(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048608, this, forumData, userData) != null) || this.i || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().e()) {
            return;
        }
        zs4 frsBannerData = forumData.getFrsBannerData();
        this.h = frsBannerData;
        q(frsBannerData);
        this.g.k();
        this.c.removeHeaderView(this.g);
        if (this.h.getType() == 1 && !TextUtils.isEmpty(this.h.b())) {
            this.g.setData(this.a.getPageContext(), this.h.b());
            if (this.h.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
            }
        }
    }
}
