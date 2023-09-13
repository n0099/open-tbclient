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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes5.dex */
public class eq7 implements TabLayout.OnTabSelectedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public RelativeLayout b;
    public BdTypeRecyclerView c;
    public FrameLayout d;
    public TabLayout e;
    public TabLayout f;
    public PbListView g;
    public fq7 h;
    public BannerView i;
    public l25 j;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        public a(eq7 eq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eq7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null) {
                this.a.a.onScrollToBottom();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(eq7 eq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var};
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
                    playVoiceBnt.h();
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

    /* loaded from: classes5.dex */
    public class c implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public c(eq7 eq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eq7Var;
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

    /* loaded from: classes5.dex */
    public class d implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        public d(eq7 eq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eq7Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                zv7.a(this.a.j, this.a.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
            }
        }

        public e(eq7 eq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eq7Var;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
                this.a.c0();
                this.a.S(tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) && tab != null) {
                if (tab.getTag() instanceof Integer) {
                    int intValue = ((Integer) tab.getTag()).intValue();
                    eq7 eq7Var = this.a;
                    eq7Var.I(intValue, eq7Var.e, true);
                }
                this.a.R(tab);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        public f(eq7 eq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eq7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n().p();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(eq7 eq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var, Integer.valueOf(i)};
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
            this.a = eq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.G(str);
                this.a.F(str);
                this.a.h.t();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(eq7 eq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq7Var, Integer.valueOf(i)};
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
            this.a = eq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m();
            }
        }
    }

    public eq7(FrsGoodFragment frsGoodFragment, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment, view2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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
        w(view2, z);
        this.p = BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.q = BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    public final void D(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, tabLayout) == null) && tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && this.a.A2() != null) {
            this.a.A2().Z(str);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            zv7.c(z, 301);
        }
    }

    public void L(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            FrameLayout frameLayout = this.d;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            frameLayout.setVisibility(i);
            X(z);
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.c.setSelection(i);
        }
    }

    public void N(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mnVar) == null) {
            this.h.B(mnVar);
        }
    }

    public void O(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onScrollListener) == null) {
            this.c.setOnScrollListener(onScrollListener);
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            wi7 wi7Var = new wi7();
            wi7Var.a = 301;
            wi7Var.c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, wi7Var));
        }
    }

    public final void S(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, tab) == null) && tab != null && tab.getCustomView() != null) {
            ((pa5) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).t(R.color.CAM_X0108);
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048610, this, tab) == null) {
            c0();
            S(tab);
        }
    }

    public void A() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || n() == null) {
            return;
        }
        List<cn> l = n().l();
        if (ListUtils.isEmpty(l)) {
            return;
        }
        for (cn cnVar : l) {
            if (cnVar instanceof h45) {
                h45 h45Var = (h45) cnVar;
                if (h45Var.u != 0 && (threadData = h45Var.t) != null) {
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    h45Var.u = imageWidthAndHeight[0];
                    h45Var.v = imageWidthAndHeight[1];
                }
            }
        }
        SafeHandler.getInst().postDelayed(new f(this), 500L);
    }

    public void B(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumData, userData) != null) || this.m || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().e()) {
            return;
        }
        l25 frsBannerData = forumData.getFrsBannerData();
        this.j = frsBannerData;
        s(frsBannerData);
        this.i.k();
        this.c.removeHeaderView(this.i);
        if (this.j.getType() == 1 && !TextUtils.isEmpty(this.j.b())) {
            this.i.setData(this.a.getPageContext(), this.j.b());
            if (this.j.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
            }
        }
    }

    public final void T(TabData tabData, TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, tabData, tabLayout) == null) {
            int min = Math.min(tabData.size(), 9);
            if (tabLayout.getTabCount() > min) {
                int tabCount = tabLayout.getTabCount() - min;
                for (int i = 0; i < tabCount; i++) {
                    tabLayout.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
            if (linearLayout == null) {
                return;
            }
            for (int i2 = 0; i2 < min; i2++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    if (linearLayout.getChildAt(i2) != null) {
                        linearLayout.getChildAt(i2).setPadding(0, 0, 0, 0);
                    }
                }
                if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.a.getContext());
                    pa5 pa5Var = new pa5();
                    pa5Var.t(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(pa5Var);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.p);
                    int i3 = this.q;
                    layoutParams.setMargins(i3 / 2, 0, i3 / 2, 0);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tabAt.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(tabData.get(i2).a, 10, "..."));
                tabAt.setTag(Integer.valueOf(tabData.get(i2).b));
                if (tabData.get(i2).b == this.o) {
                    tabAt.select();
                }
            }
        }
    }

    public void C() {
        fq7 fq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (fq7Var = this.h) != null) {
            fq7Var.p();
        }
    }

    public void E() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bannerView = this.i) != null) {
            this.m = false;
            this.c.removeHeaderView(bannerView);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            zv7.b(301);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h.q();
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.c.setVisibility(0);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.c.setNextPage(this.g);
            this.g.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.g.G(null);
            this.g.U();
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            pi7 pi7Var = new pi7();
            pi7Var.a = 301;
            pi7Var.b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, pi7Var));
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            pi7 pi7Var = new pi7();
            pi7Var.a = 301;
            pi7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, pi7Var));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            G(null);
            F(null);
            this.h.t();
        }
    }

    public fq7 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.h;
        }
        return (fq7) invokeV.objValue;
    }

    public BdTypeRecyclerView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.c;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.b;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final ThemeElement q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
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

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public void x() {
        fq7 fq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (fq7Var = this.h) != null) {
            fq7Var.p();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.h.s();
            this.c.setOnSrollToBottomListener(null);
            this.c.setOnTouchListener(null);
            D(this.e);
            D(this.f);
        }
    }

    public void G(String str) {
        ThreadData threadData;
        rha rhaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || ListUtils.isEmpty(this.h.l())) {
            return;
        }
        Iterator<cn> it = this.h.m().iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            cn next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof a46) && !(next instanceof v66)) {
                    if ((next instanceof h45) && (threadData = ((h45) next).t) != null && (rhaVar = threadData.funAdData) != null) {
                        rhaVar.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof v66)) {
                    it.remove();
                }
                if (next instanceof a46) {
                    a46 a46Var = (a46) next;
                    if ((a46Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) a46Var.a()).a)) {
                        it.remove();
                        i2 = i;
                    }
                }
            }
        }
    }

    public void y(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            fq7 fq7Var = this.h;
            if (fq7Var != null) {
                fq7Var.D();
                this.h.p();
                this.h.r(i);
            }
            FrsGoodFragment frsGoodFragment = this.a;
            if (frsGoodFragment != null && frsGoodFragment.getBaseFragmentActivity() == null && this.a.getBaseFragmentActivity().getLayoutMode() != null) {
                BDLayoutMode layoutMode = this.a.getBaseFragmentActivity().getLayoutMode();
                if (i == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.setNightMode(z);
                this.a.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.b);
            }
            BannerView bannerView = this.i;
            if (bannerView != null) {
                bannerView.j();
            }
            PbListView pbListView = this.g;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
                this.g.e(i);
            }
            ThemeElement q = q();
            if (q != null && !ei.isEmpty(q.font_color)) {
                this.l = q.font_color;
            }
            u(this.e);
            u(this.f);
        }
    }

    public final void I(int i, TabLayout tabLayout, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), tabLayout, Boolean.valueOf(z)}) != null) || tabLayout == null) {
            return;
        }
        for (int i2 = 0; i2 < tabLayout.getTabCount(); i2++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
            if (tabAt != null && (tabAt.getTag() instanceof Integer)) {
                if (((Integer) tabAt.getTag()).intValue() == i) {
                    if (z) {
                        tabAt.select();
                    } else {
                        tabLayout.setScrollPosition(i2, 0.0f, true);
                        R(tabAt);
                    }
                } else if (!z) {
                    S(tabAt);
                }
            }
        }
    }

    public void Q(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, frsViewData) == null) && frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<r25> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            jv7 jv7Var = new jv7();
            jv7Var.b = 0;
            jv7Var.a = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f029d);
            tabData.add(jv7Var);
            for (r25 r25Var : good_classify) {
                if (r25Var != null && r25Var.a() > 0 && !TextUtils.isEmpty(r25Var.b()) && !TextUtils.isEmpty(r25Var.b().trim())) {
                    jv7 jv7Var2 = new jv7();
                    jv7Var2.b = r25Var.a();
                    jv7Var2.a = r25Var.b();
                    tabData.add(jv7Var2);
                }
            }
            if (ListUtils.getCount(tabData) <= 1) {
                return;
            }
            v();
            this.n = true;
            T(tabData, this.e);
            T(tabData, this.f);
        }
    }

    public final void R(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, tab) == null) && tab.getCustomView() != null) {
            pa5 pa5Var = (pa5) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (ei.isEmpty(this.l)) {
                pa5Var.t(R.color.CAM_X0105);
            } else {
                pa5Var.s(ColorUtils.parseColor(this.l));
            }
        }
    }

    public void U(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, themeColorInfo) == null) && themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            this.k = themeColorInfo;
            ThemeElement q = q();
            if (q != null && !ei.isEmpty(q.font_color)) {
                this.l = q.font_color;
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, tab) == null) && tab != null && tab.getCustomView() != null) {
            if (!this.n && (tab.getTag() instanceof Integer)) {
                int intValue = ((Integer) tab.getTag()).intValue();
                this.o = intValue;
                this.a.G2(intValue);
            }
            R(tab);
        }
    }

    public final void t(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view2) == null) {
            TabLayout tabLayout = (TabLayout) view2.findViewById(R.id.obfuscated_res_0x7f090cb8);
            this.f = tabLayout;
            tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
            this.f.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e(this));
        }
    }

    public void V(ArrayList<cn> arrayList, int i, FrsViewData frsViewData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{arrayList, Integer.valueOf(i), frsViewData, Integer.valueOf(i2)}) == null) {
            if (arrayList == null || arrayList.size() <= 0) {
                ni7 ni7Var = new ni7();
                ArrayList<cn> arrayList2 = new ArrayList<>();
                arrayList2.add(ni7Var);
                arrayList = arrayList2;
            }
            this.h.w(arrayList, frsViewData);
            this.n = false;
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.c.setNextPage(this.g);
            this.g.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.g.G(this.r);
            this.g.g();
            this.g.H(this.a.getResources().getString(R.string.list_click_load_more));
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.c.setNextPage(this.g);
            this.g.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.g.G(null);
            this.g.g();
            this.g.H(this.a.getResources().getString(R.string.list_has_no_more));
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, tab) == null) && tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                xt7.q0.f = intValue;
                if (!this.n) {
                    this.o = intValue;
                    I(intValue, this.f, false);
                    this.a.G2(this.o);
                    ep6.b().e(false);
                    vfa.g().h(this.a.getUniqueId(), false);
                }
            }
            R(tab);
        }
    }

    public final void s(l25 l25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, l25Var) != null) || this.i != null) {
            return;
        }
        this.i = new BannerView(this.a.getPageContext().getPageActivity());
        this.i.setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a)));
        this.i.setVisibility(8);
        this.i.setBannerViewClickListener(this.s);
        this.i.setBannerData(l25Var);
        this.i.setBannerViewEvent(new c(this));
    }

    public final void u(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, tabLayout) == null) && tabLayout != null) {
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    pa5 pa5Var = (pa5) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                    if (!tabAt.isSelected()) {
                        pa5Var.t(R.color.CAM_X0108);
                    } else if (ei.isEmpty(this.l)) {
                        pa5Var.t(R.color.CAM_X0105);
                    } else {
                        pa5Var.s(ColorUtils.parseColor(this.l));
                    }
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && this.e == null) {
            TabLayout tabLayout = (TabLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d036a, (ViewGroup) null);
            this.e = tabLayout;
            tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
            this.e.setLayoutParams(new RecyclerView.LayoutParams(-1, BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds126)));
            this.e.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            u(this.e);
            this.c.addHeaderView(this.e);
        }
    }

    public final void w(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048618, this, view2, z) == null) {
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090cb7);
            t(view2);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090cb9);
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
            this.g.w(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds182));
            this.g.B();
            this.g.L(R.dimen.tbfontsize33);
            this.g.J(SkinManager.getColor(R.color.CAM_X0107));
            this.g.F(R.color.CAM_X0110);
            this.c.setOnSrollToBottomListener(this.a);
            this.d = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d1a);
            this.h = new fq7(this.a, this.c);
            K(false);
            this.a.registerListener(this.t);
            this.a.registerListener(this.u);
        }
    }
}
