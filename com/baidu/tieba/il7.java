package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.tab.TabData;
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
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes6.dex */
public class il7 implements TabLayout.OnTabSelectedListener {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern v;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public RelativeLayout b;
    public BdTypeRecyclerView c;
    public FrameLayout d;
    public TabLayout e;
    public TabLayout f;
    public PbListView g;
    public jl7 h;
    public BannerView i;
    public u25 j;
    public ThemeColorInfo k;
    public String l;
    public boolean m;
    public boolean n;
    public int o;
    public final int p;
    public int q;
    public View.OnClickListener r;
    public BannerView.b s;
    public CustomMessageListener t;
    public CustomMessageListener u;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il7 a;

        public a(il7 il7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null) {
                this.a.a.onScrollToBottom();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(il7 il7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (view2 = viewHolder.itemView) != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.k();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il7 a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public c(il7 il7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il7Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, str, z) != null) || !z || !this.a.i.i() || this.a.m || this.a.c == null) {
                return;
            }
            this.a.m = true;
            this.a.c.addHeaderView(this.a.i, 1);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il7 a;

        public d(il7 il7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il7Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.m();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il7 a;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
            }
        }

        public e(il7 il7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il7Var;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
                this.a.d0();
                this.a.T(tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) && tab != null) {
                if (tab.getTag() instanceof Integer) {
                    int intValue = ((Integer) tab.getTag()).intValue();
                    il7 il7Var = this.a;
                    il7Var.J(intValue, il7Var.e, true);
                }
                this.a.S(tab);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il7 a;

        public f(il7 il7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o().p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(il7 il7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var, Integer.valueOf(i)};
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
            this.a = il7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.H(str);
                this.a.G(str);
                this.a.h.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(il7 il7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var, Integer.valueOf(i)};
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
            this.a = il7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.n();
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class i {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-714770576, "Lcom/baidu/tieba/il7$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-714770576, "Lcom/baidu/tieba/il7$i;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947857429, "Lcom/baidu/tieba/il7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947857429, "Lcom/baidu/tieba/il7;");
                return;
            }
        }
        v = Pattern.compile("(/p/){1}(\\d+)");
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.s();
            this.c.setOnSrollToBottomListener(null);
            this.c.setOnTouchListener(null);
            E(this.e);
            E(this.f);
        }
    }

    public void D() {
        jl7 jl7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jl7Var = this.h) != null) {
            jl7Var.p();
        }
    }

    public void F() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bannerView = this.i) != null) {
            this.m = false;
            this.c.removeHeaderView(bannerView);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ce7 ce7Var = new ce7();
            ce7Var.a = 301;
            ce7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ce7Var));
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.h.q();
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.c.setVisibility(0);
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.c.setNextPage(this.g);
            this.g.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.g.G(null);
            this.g.U();
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            ce7 ce7Var = new ce7();
            ce7Var.a = 301;
            ce7Var.b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ce7Var));
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ce7 ce7Var = new ce7();
            ce7Var.a = 301;
            ce7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ce7Var));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            H(null);
            G(null);
            this.h.t();
        }
    }

    public jl7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.h;
        }
        return (jl7) invokeV.objValue;
    }

    public BdTypeRecyclerView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.c;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.b;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final ThemeElement r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.k == null) {
                return null;
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                return this.k.dark;
            }
            return this.k.day;
        }
        return (ThemeElement) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public void y() {
        jl7 jl7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (jl7Var = this.h) != null) {
            jl7Var.p();
        }
    }

    public il7(FrsGoodFragment frsGoodFragment, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment, view2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.i = null;
        this.m = false;
        this.n = false;
        this.o = 0;
        this.r = new a(this);
        this.s = new d(this);
        this.t = new g(this, 2016331);
        this.u = new h(this, 2921746);
        this.a = frsGoodFragment;
        x(view2, z);
        this.p = xi.g(this.a.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.q = xi.g(this.a.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    public final void E(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, tabLayout) == null) && tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && this.a.l2() != null) {
            this.a.l2().h0(str);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && !z) {
            ce7 ce7Var = new ce7();
            ce7Var.a = 301;
            ce7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ce7Var));
        }
    }

    public void M(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            FrameLayout frameLayout = this.d;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            frameLayout.setVisibility(i2);
            Y(z);
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.c.setSelection(i2);
        }
    }

    public void O(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hoVar) == null) {
            this.h.B(hoVar);
        }
    }

    public void P(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onScrollListener) == null) {
            this.c.setOnScrollListener(onScrollListener);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            je7 je7Var = new je7();
            je7Var.a = 301;
            je7Var.c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, je7Var));
        }
    }

    public final void T(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, tab) == null) && tab != null && tab.getCustomView() != null) {
            ((qa5) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).s(R.color.CAM_X0108);
        }
    }

    public final void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (z) {
                this.f.setVisibility(8);
            } else if (this.f.getTabCount() > 1) {
                this.f.setVisibility(0);
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, tab) == null) {
            d0();
            T(tab);
        }
    }

    public void B() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || o() == null) {
            return;
        }
        List<xn> l = o().l();
        if (ListUtils.isEmpty(l)) {
            return;
        }
        for (xn xnVar : l) {
            if (xnVar instanceof r45) {
                r45 r45Var = (r45) xnVar;
                if (r45Var.u != 0 && (threadData = r45Var.t) != null) {
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    r45Var.u = imageWidthAndHeight[0];
                    r45Var.v = imageWidthAndHeight[1];
                }
            }
        }
        yg.a().postDelayed(new f(this), 500L);
    }

    public void C(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumData, userData) != null) || this.m || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().e()) {
            return;
        }
        u25 frsBannerData = forumData.getFrsBannerData();
        this.j = frsBannerData;
        t(frsBannerData);
        this.i.k();
        this.c.removeHeaderView(this.i);
        if (this.j.getType() == 1 && !TextUtils.isEmpty(this.j.b())) {
            this.i.setData(this.a.getPageContext(), this.j.b());
            if (this.j.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
            }
        }
    }

    public final void U(TabData tabData, TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, tabData, tabLayout) == null) {
            int min = Math.min(tabData.size(), 9);
            if (tabLayout.getTabCount() > min) {
                int tabCount = tabLayout.getTabCount() - min;
                for (int i2 = 0; i2 < tabCount; i2++) {
                    tabLayout.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
            if (linearLayout == null) {
                return;
            }
            for (int i3 = 0; i3 < min; i3++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    if (linearLayout.getChildAt(i3) != null) {
                        linearLayout.getChildAt(i3).setPadding(0, 0, 0, 0);
                    }
                }
                if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.a.getContext());
                    qa5 qa5Var = new qa5();
                    qa5Var.s(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(qa5Var);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.p);
                    int i4 = this.q;
                    layoutParams.setMargins(i4 / 2, 0, i4 / 2, 0);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tabAt.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(tabData.get(i3).a, 10, "..."));
                tabAt.setTag(Integer.valueOf(tabData.get(i3).b));
                if (tabData.get(i3).b == this.o) {
                    tabAt.select();
                }
            }
        }
    }

    public void H(String str) {
        ThreadData threadData;
        l4a l4aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || ListUtils.isEmpty(this.h.l())) {
            return;
        }
        Iterator<xn> it = this.h.m().iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            i2++;
            xn next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof b46) && !(next instanceof w66)) {
                    if ((next instanceof r45) && (threadData = ((r45) next).t) != null && (l4aVar = threadData.funAdData) != null) {
                        l4aVar.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i3 + 1 == i2 && (next instanceof w66)) {
                    it.remove();
                }
                if (next instanceof b46) {
                    b46 b46Var = (b46) next;
                    if ((b46Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) b46Var.a()).a)) {
                        it.remove();
                        i3 = i2;
                    }
                }
            }
        }
    }

    public void z(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            jl7 jl7Var = this.h;
            if (jl7Var != null) {
                jl7Var.D();
                this.h.p();
                this.h.r(i2);
            }
            FrsGoodFragment frsGoodFragment = this.a;
            if (frsGoodFragment != null && frsGoodFragment.getBaseFragmentActivity() == null && this.a.getBaseFragmentActivity().getLayoutMode() != null) {
                h05 layoutMode = this.a.getBaseFragmentActivity().getLayoutMode();
                if (i2 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.l(z);
                this.a.getBaseFragmentActivity().getLayoutMode().k(this.b);
            }
            BannerView bannerView = this.i;
            if (bannerView != null) {
                bannerView.j();
            }
            PbListView pbListView = this.g;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
                this.g.e(i2);
            }
            ThemeElement r = r();
            if (r != null && !wi.isEmpty(r.font_color)) {
                this.l = r.font_color;
            }
            v(this.e);
            v(this.f);
        }
    }

    public final void J(int i2, TabLayout tabLayout, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), tabLayout, Boolean.valueOf(z)}) != null) || tabLayout == null) {
            return;
        }
        for (int i3 = 0; i3 < tabLayout.getTabCount(); i3++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
            if (tabAt != null && (tabAt.getTag() instanceof Integer)) {
                if (((Integer) tabAt.getTag()).intValue() == i2) {
                    if (z) {
                        tabAt.select();
                    } else {
                        tabLayout.setScrollPosition(i3, 0.0f, true);
                        S(tabAt);
                    }
                } else if (!z) {
                    T(tabAt);
                }
            }
        }
    }

    public void R(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, frsViewData) == null) && frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<a35> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            iq7 iq7Var = new iq7();
            iq7Var.b = 0;
            iq7Var.a = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f029c);
            tabData.add(iq7Var);
            for (a35 a35Var : good_classify) {
                if (a35Var != null && a35Var.a() > 0 && !TextUtils.isEmpty(a35Var.b()) && !TextUtils.isEmpty(a35Var.b().trim())) {
                    iq7 iq7Var2 = new iq7();
                    iq7Var2.b = a35Var.a();
                    iq7Var2.a = a35Var.b();
                    tabData.add(iq7Var2);
                }
            }
            if (ListUtils.getCount(tabData) <= 1) {
                return;
            }
            w();
            this.n = true;
            U(tabData, this.e);
            U(tabData, this.f);
        }
    }

    public final void S(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, tab) == null) && tab.getCustomView() != null) {
            qa5 qa5Var = (qa5) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (wi.isEmpty(this.l)) {
                qa5Var.s(R.color.CAM_X0105);
            } else {
                qa5Var.r(eu8.b(this.l));
            }
        }
    }

    public void V(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, themeColorInfo) == null) && themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            this.k = themeColorInfo;
            ThemeElement r = r();
            if (r != null && !wi.isEmpty(r.font_color)) {
                this.l = r.font_color;
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, tab) == null) && tab != null && tab.getCustomView() != null) {
            if (!this.n && (tab.getTag() instanceof Integer)) {
                int intValue = ((Integer) tab.getTag()).intValue();
                this.o = intValue;
                this.a.r2(intValue);
            }
            S(tab);
        }
    }

    public final void u(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            TabLayout tabLayout = (TabLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c91);
            this.f = tabLayout;
            tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
            this.f.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e(this));
        }
    }

    public void W(ArrayList<xn> arrayList, int i2, FrsViewData frsViewData, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{arrayList, Integer.valueOf(i2), frsViewData, Integer.valueOf(i3)}) == null) {
            if (arrayList == null || arrayList.size() <= 0) {
                ae7 ae7Var = new ae7();
                ArrayList<xn> arrayList2 = new ArrayList<>();
                arrayList2.add(ae7Var);
                arrayList = arrayList2;
            }
            this.h.w(arrayList, frsViewData);
            this.n = false;
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.c.setNextPage(this.g);
            this.g.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.g.G(this.r);
            this.g.g();
            this.g.H(this.a.getResources().getString(R.string.list_click_load_more));
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.c.setNextPage(this.g);
            this.g.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.g.G(null);
            this.g.g();
            this.g.H(this.a.getResources().getString(R.string.list_has_no_more));
        }
    }

    public final void m() {
        u25 u25Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (u25Var = this.j) == null) {
            return;
        }
        String d2 = u25Var.d();
        if (this.j.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.a.getPageContext().getPageActivity(), d2, false, "frs_banner")));
        } else if (this.j.a() == 2) {
            if (d2.contains("tieba.baidu.com")) {
                Matcher matcher = v.matcher(d2);
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
        } else if (this.j.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = i.a[nativePageType.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
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
        } else if (this.j.a() == 4) {
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(d2, "frs_banner")));
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, tab) == null) && tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                bp7.q0.f = intValue;
                if (!this.n) {
                    this.o = intValue;
                    J(intValue, this.f, false);
                    this.a.r2(this.o);
                    jo6.b().e(false);
                    p2a.g().h(this.a.getUniqueId(), false);
                }
            }
            S(tab);
        }
    }

    public final void t(u25 u25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, u25Var) != null) || this.i != null) {
            return;
        }
        this.i = new BannerView(this.a.getPageContext().getPageActivity());
        this.i.setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a)));
        this.i.setVisibility(8);
        this.i.setBannerViewClickListener(this.s);
        this.i.setBannerData(u25Var);
        this.i.setBannerViewEvent(new c(this));
    }

    public final void v(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, tabLayout) == null) && tabLayout != null) {
            for (int i2 = 0; i2 < tabLayout.getTabCount(); i2++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    qa5 qa5Var = (qa5) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                    if (!tabAt.isSelected()) {
                        qa5Var.s(R.color.CAM_X0108);
                    } else if (wi.isEmpty(this.l)) {
                        qa5Var.s(R.color.CAM_X0105);
                    } else {
                        qa5Var.r(eu8.b(this.l));
                    }
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.e == null) {
            TabLayout tabLayout = (TabLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0354, (ViewGroup) null);
            this.e = tabLayout;
            tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
            this.e.setLayoutParams(new RecyclerView.LayoutParams(-1, xi.g(this.a.getContext(), R.dimen.tbds126)));
            this.e.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            v(this.e);
            this.c.addHeaderView(this.e);
        }
    }

    public final void x(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048620, this, view2, z) == null) {
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c90);
            u(view2);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090c92);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.c.setFadingEdgeLength(0);
            this.c.setOverScrollMode(2);
            this.c.setRecyclerListener(new b(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.c;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.c.getPaddingBottom());
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.g = pbListView;
            pbListView.a();
            this.g.s(R.color.transparent);
            this.g.w(xi.g(this.a.getActivity(), R.dimen.tbds182));
            this.g.B();
            this.g.L(R.dimen.tbfontsize33);
            this.g.J(SkinManager.getColor(R.color.CAM_X0107));
            this.g.F(R.color.CAM_X0110);
            this.c.setOnSrollToBottomListener(this.a);
            this.d = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090cf3);
            this.h = new jl7(this.a, this.c);
            L(false);
            this.a.registerListener(this.t);
            this.a.registerListener(this.u);
        }
    }
}
