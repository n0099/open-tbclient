package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fe5;
import com.repackage.g05;
import com.repackage.ig;
import com.repackage.iu6;
import com.repackage.jg;
import com.repackage.ju6;
import com.repackage.jz6;
import com.repackage.k05;
import com.repackage.lu6;
import com.repackage.mu6;
import com.repackage.ou6;
import com.repackage.pi;
import com.repackage.pu6;
import com.repackage.s55;
import com.repackage.sg8;
import com.repackage.su6;
import com.repackage.sz6;
import com.repackage.tm4;
import com.repackage.tu4;
import com.repackage.ur4;
import com.repackage.us6;
import com.repackage.vk8;
import com.repackage.wi4;
import com.repackage.wz5;
import com.repackage.xt4;
import com.repackage.ym;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes3.dex */
public class ScrollFragmentTabHost extends CoordinatorLayout implements mu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public boolean C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public CustomMessageTask G;
    public CustomMessageTask H;
    public View.OnClickListener I;
    public ig<ym> J;
    @Nullable
    public StickyAppBarLayout K;
    @Nullable
    public FixedAppBarLayout L;
    @Nullable
    public NestedScrollHeader M;
    public wz5 N;
    public us6 O;
    public CustomMessageListener P;
    public ig<ym> Q;
    public su6 R;
    public pu6 S;
    public ou6 T;
    public Context a;
    public TbPageContext b;
    public HomeTabBarView c;
    public fe5 d;
    public FrameLayout e;
    public CustomViewPager f;
    public View g;
    public View h;
    public TBSpecificationBtn i;
    public FrameLayout j;
    public boolean k;
    public AlphaAnimation l;
    public AlphaAnimation m;
    public NewScrollFragmentAdapter n;
    public z o;
    public wz5 p;
    public List<y> q;
    public boolean r;
    public boolean s;
    public GestureDetector t;
    public FrameLayout u;
    public TbImageView v;
    public View w;
    public final CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
    public class a implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public a(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || this.a.K == null) {
                    return null;
                }
                this.a.c();
                boolean z = false;
                if (customMessage.getData().booleanValue()) {
                    z = this.a.K.i();
                } else if (this.a.K.f() && this.a.r) {
                    z = true;
                    this.a.K.i();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, Boolean.TRUE));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public b(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (tm4.b() == 1) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{"http://fans.baidu.com/fanstest/wapindex?product_id=1002&version=12.11.0.11&client_type=android&contact_way=qq"});
                } else if (tm4.b() == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921569));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ig<ym> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public c(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ig
        public void onLoaded(ym ymVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, ymVar, str, i) == null) {
                if (ymVar == null || this.a.v == null) {
                    this.a.v.setVisibility(8);
                } else {
                    this.a.v.setImageBitmap(ymVar.p());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i)};
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
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (this.a.C != UbsABTestHelper.isConcernForumCardShow()) {
                    this.a.c.j();
                    if (UbsABTestHelper.isConcernForumCardShow() && this.a.r) {
                        this.a.K();
                        this.a.d0();
                    }
                }
                this.a.setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements s55.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public e(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.repackage.s55.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new StickyAppBarLayout(this.a.a) : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements s55.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public f(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.repackage.s55.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new us6(this.a.a) : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public g(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0 && this.a.getCurrentTabType() == 0) {
                    boolean U = this.a.U();
                    TiebaStatic.log(new StatisticItem("c12350").param("obj_type", U ? 1 : 0));
                    if (U && this.a.n != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        this.a.n.M();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
                this.a.c0(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || this.a.n == null) {
                return;
            }
            TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.N(i));
            this.a.n.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.n == null) {
                return;
            }
            if (this.a.o != null) {
                this.a.o.a(i);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
            if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                if (this.a.d(i) != 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                }
            }
            int q = this.a.n.q(this.a.f.getCurrentItem());
            if (q == 5) {
                if (this.a.s) {
                    this.a.s = false;
                } else {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 0);
                    statisticItem.eventStat();
                }
            }
            if (q == 0) {
                this.a.K();
            }
            View d = this.a.c.d(0);
            if ((d instanceof LinearLayout) && TbadkCoreApplication.isLogin() && UbsABTestHelper.isConcernForumCardShow()) {
                LinearLayout linearLayout = (LinearLayout) d;
                if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (q == 0) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                }
            }
            if (this.a.q != null && this.a.n != null) {
                int q2 = this.a.n.q(this.a.f.getCurrentItem());
                if (q2 == 5) {
                    this.a.setScrollShadow(false);
                    for (y yVar : this.a.q) {
                        yVar.c();
                    }
                } else if (q2 == 1) {
                    this.a.setScrollShadow(false);
                    for (y yVar2 : this.a.q) {
                        yVar2.b();
                    }
                } else if (q2 == 0) {
                    this.a.setScrollShadow(false);
                    for (y yVar3 : this.a.q) {
                        yVar3.a();
                    }
                } else if (q2 == 6) {
                    this.a.setScrollShadow(true);
                } else if (q2 == 7) {
                    this.a.setScrollShadow(true);
                } else if (q2 == 8) {
                    this.a.setScrollShadow(false);
                } else {
                    this.a.c();
                    this.a.setScrollShadow(false);
                }
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(this.a.d(i));
            TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.N(i));
            if (this.a.d(i) == 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        xt4.k().x(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    xt4.k().x("unlogin_hot_top_timestamp", currentTimeMillis);
                }
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.N(i));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements PagerSlidingTabStrip.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public h(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.c
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                if (this.a.d(i) == 1 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b, null)) {
                    this.a.H(i);
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && this.a.f.getCurrentItem() != i) {
                        if (this.a.d(i) != 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                        }
                    }
                    if (this.a.d(i) == 7) {
                        TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "1"));
                    } else if (this.a.d(i) == 8) {
                        TiebaStatic.log(new StatisticItem("c13580"));
                    }
                    TbadkCoreApplication.getInst().setHomeBarShowType(this.a.d(i));
                    TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.N(i));
                    if (this.a.d(i) == 5) {
                        StatisticItem statisticItem = new StatisticItem("c13740");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_type", 0);
                        statisticItem.eventStat();
                        this.a.s = true;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (TbadkCoreApplication.isLogin()) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                xt4.k().x(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                            }
                        } else {
                            xt4.k().x("unlogin_hot_top_timestamp", currentTimeMillis);
                        }
                    }
                    ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                    scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.N(i));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements StickyAppBarLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public i(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.N != null) {
                this.a.N.I();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements NestedScrollHeader.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public j(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.N != null) {
                    this.a.N.I();
                    this.a.N = null;
                }
                if (this.a.b != null) {
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i)};
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
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.j == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof ju6) || ((ju6) customResponsedMessage.getData()).a == null) {
                this.a.j.removeAllViews();
                this.a.j.setVisibility(8);
                return;
            }
            View view2 = ((ju6) customResponsedMessage.getData()).a;
            if (view2.getParent() != null) {
                if (view2.getParent() != this.a.j) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                    this.a.j.removeAllViews();
                    this.a.j.addView(view2);
                }
            } else {
                this.a.j.removeAllViews();
                this.a.j.addView(view2);
            }
            this.a.j.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public l(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > 40.0f) {
                    FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b, null);
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) {
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m extends ig<ym> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public m(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ig
        public void onLoaded(ym ymVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, ymVar, str, i) == null) || this.a.L == null) {
                return;
            }
            if (ymVar == null || ymVar.p() == null) {
                this.a.L.setImageBackgroundVisibility(8);
            } else {
                this.a.L.setImageBackground(ymVar.p());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public n(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.h.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements pu6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public o(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.repackage.pu6
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.n == null) {
                return;
            }
            this.a.setCurrentTab(this.a.n.n(i), false);
            this.a.n.B(i);
        }
    }

    /* loaded from: classes3.dex */
    public class p implements ou6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public p(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.repackage.ou6
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.R.b(i, this.a.S);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i)};
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
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f == null) {
                return;
            }
            if (FullBrowseHelper.checkIsFullBrowseMode()) {
                this.a.f.setScrollable(false, this.a.t);
            } else {
                this.a.f.setScrollable(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i)};
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
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    this.a.a();
                } else {
                    this.a.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i)};
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
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.N == null) {
                return;
            }
            this.a.N.I();
            this.a.N = null;
        }
    }

    /* loaded from: classes3.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageView a;

            public a(t tVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar, imageView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.a.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageView a;

            public b(t tVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar, imageView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.a.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i)};
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
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) this.a.c.d(0);
            if (intValue == 1) {
                if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 1) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (Float.floatToIntBits(imageView.getRotationX()) == Float.floatToIntBits(0.0f)) {
                        ValueAnimator ofInt = ValueAnimator.ofInt(0, 180);
                        ofInt.setDuration(200L);
                        ofInt.setStartDelay(30L);
                        ofInt.addUpdateListener(new a(this, imageView));
                        ofInt.start();
                    }
                }
                if (this.a.c != null) {
                    this.a.O.l(this.a.c.getBackgroundAlpha());
                    this.a.O.k(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.a.K != null) {
                    this.a.O.n(this.a.K);
                }
            } else if (!(linearLayout instanceof LinearLayout) || linearLayout.getChildCount() <= 1) {
            } else {
                ImageView imageView2 = (ImageView) linearLayout.getChildAt(1);
                if (Float.floatToIntBits(imageView2.getRotationX()) == Float.floatToIntBits(180.0f)) {
                    ValueAnimator ofInt2 = ValueAnimator.ofInt(180, 0);
                    ofInt2.setDuration(200L);
                    ofInt2.setStartDelay(30L);
                    ofInt2.addUpdateListener(new b(this, imageView2));
                    ofInt2.start();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i)};
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
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921653 || UbsABTestHelper.isHomeTabModifyABTestA()) {
                return;
            }
            this.a.n.E();
            this.a.f.setAdapter(this.a.n);
            this.a.c.j();
            this.a.setCurrentTab(1);
        }
    }

    /* loaded from: classes3.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextView a;
            public final /* synthetic */ int b;

            public a(v vVar, TextView textView, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar, textView, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = textView;
                this.b = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.a.setMaxWidth(this.b + ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextView a;
            public final /* synthetic */ int b;

            public b(v vVar, TextView textView, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar, textView, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = textView;
                this.b = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.a.setMaxWidth(this.b - ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextView a;
            public final /* synthetic */ String b;

            public c(v vVar, TextView textView, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar, textView, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = textView;
                this.b = str;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.setText(this.b);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i)};
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
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02b3);
            String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02a7);
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) this.a.c.d(0);
            if (intValue == 1) {
                if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    if (string2.equals(textView.getText())) {
                        int measuredWidth = textView.getMeasuredWidth();
                        textView.setText(string);
                        int measureText = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02b3));
                        int measureText2 = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02a7));
                        if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                            ofInt.setDuration(360L);
                            ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                            ofInt.start();
                        }
                    }
                    xt4.k().w("key_home_concern_all_status", 1);
                }
            } else if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                TextView textView2 = (TextView) linearLayout.getChildAt(0);
                if (string.equals(textView2.getText())) {
                    int measuredWidth2 = textView2.getMeasuredWidth();
                    int measureText3 = (int) textView2.getPaint().measureText(string);
                    int measureText4 = (int) textView2.getPaint().measureText(string2);
                    if (measuredWidth2 > 0 && measureText3 > 0 && measureText4 > 0) {
                        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, measureText3 - measureText4);
                        ofInt2.setDuration(360L);
                        ofInt2.addUpdateListener(new b(this, textView2, measuredWidth2));
                        ofInt2.addListener(new c(this, textView2, string2));
                        ofInt2.start();
                    }
                }
                xt4.k().w("key_home_concern_all_status", 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i)};
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
            this.a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.n == null || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.c == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.n.R();
            this.a.n.P();
            this.a.f.setAdapter(this.a.n);
            this.a.c.j();
            this.a.i0();
        }
    }

    /* loaded from: classes3.dex */
    public class x implements CustomMessageTask.CustomRunnable<wi4.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public x(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentTabHost;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<wi4.b> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.b != null && !this.a.b.getPageActivity().isFinishing() && this.a.K != null && this.a.M != null) {
                    ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? this.a.c.getTaskView() : null;
                    if (taskView == null) {
                        return null;
                    }
                    if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof wi4.b)) {
                        wi4.b data = customMessage.getData();
                        int intValue = data.c.intValue() > 0 ? data.c.intValue() * 1000 : 5000;
                        String str = data.g;
                        if (TextUtils.isEmpty(str)) {
                            str = this.a.b.getString(R.string.obfuscated_res_0x7f0f1387);
                        }
                        String fixedText = UtilHelper.getFixedText(str, 20);
                        if (this.a.N != null) {
                            this.a.N.I();
                        }
                        ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                        scrollFragmentTabHost.N = new wz5(scrollFragmentTabHost.b, taskView);
                        this.a.N.O(48);
                        this.a.N.f0(true);
                        this.a.N.L(4);
                        this.a.N.N(intValue);
                        this.a.N.U(true);
                        this.a.N.h0(0);
                        this.a.N.j0(fixedText);
                        return new CustomResponsedMessage<>(2921409, Boolean.TRUE);
                    }
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public y() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface z {
        void a(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollFragmentTabHost(Context context) {
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
        this.s = false;
        this.x = new k(this, 2921652);
        this.y = new q(this, 2921563);
        this.z = new r(this, 2921400);
        this.A = new s(this, 2921415);
        this.B = new t(this, 2921501);
        this.D = new u(this, 2921653);
        this.E = new v(this, 2921502);
        this.F = new w(this, 2921509);
        this.G = new CustomMessageTask(2921409, new x(this));
        this.H = new CustomMessageTask(2921405, new a(this));
        this.I = new b(this);
        this.J = new c(this);
        this.P = new d(this, 2001371);
        this.Q = new m(this);
        this.R = new su6();
        this.S = new o(this);
        this.T = new p(this);
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorHead(String str) {
        String j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, str) == null) {
            fe5 fe5Var = this.d;
            if (fe5Var != null) {
                fe5Var.c(false);
            }
            if (UbsABTestHelper.isHomeTabModifyABTestA()) {
                if (this.L == null || this.d == null) {
                    return;
                }
                HashMap<String, g05> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
                String str2 = null;
                g05 g05Var = colourHeaderConfig != null ? colourHeaderConfig.get(str) : null;
                I(str, g05Var);
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (g05Var != null) {
                    if (skinType == 0) {
                        str2 = g05Var.m();
                        j2 = g05Var.j();
                    } else if (skinType == 1) {
                        str2 = g05Var.o();
                        j2 = g05Var.l();
                    } else if (skinType != 4) {
                        j2 = null;
                    } else {
                        str2 = g05Var.n();
                        j2 = g05Var.k();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        this.L.setImageBackgroundVisibility(8);
                        this.L.setBackgroundColor(sg8.f(j2));
                    } else {
                        this.L.setImageBackgroundVisibility(0);
                        jg.h().m(str2, 10, this.Q, this.b.getUniqueId());
                    }
                    this.d.c(true);
                    if (skinType == 0) {
                        this.d.a(g05Var.p());
                        this.c.c(true, g05Var.p());
                        if (g05Var.p()) {
                            this.L.setLiveSquareLottie("lottie_home_live_entrance/", R.raw.obfuscated_res_0x7f11003e);
                        } else {
                            this.L.setLiveSquareLottie("lottie_home_live_entrance_lh/", R.raw.obfuscated_res_0x7f11003f);
                        }
                        this.L.setSearchStyle(true, g05Var.p());
                        return;
                    }
                    this.d.a(false);
                    this.c.c(false, false);
                    this.L.setLiveSquareLottie("lottie_home_live_entrance_lh/", R.raw.obfuscated_res_0x7f11003f);
                    this.L.setSearchStyle(false, false);
                    return;
                }
                this.L.k();
                this.d.a(!UtilHelper.isNightOrDarkMode());
                this.c.l();
                return;
            }
            O(str);
        }
    }

    public final void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", M(i2));
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public void I(String str, g05 g05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, g05Var) == null) {
            if (g05Var != null) {
                if (!StringUtils.isNull(g05Var.d())) {
                    this.u.setVisibility(0);
                    iu6.h(g05Var, this.v, this.w, this.J, this.b.getUniqueId());
                } else if (!StringUtils.isNull(g05Var.a())) {
                    this.u.setVisibility(0);
                    iu6.g(g05Var, this.v, this.w);
                } else {
                    this.u.setVisibility(8);
                }
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.n;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.A(str);
            }
            if (getResources().getString(R.string.obfuscated_res_0x7f0f1364).equals(str) || getResources().getString(R.string.obfuscated_res_0x7f0f0265).equals(TbadkCoreApplication.getInst().getHomeBarShowTabName())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921722, Boolean.valueOf(this.u.getVisibility() == 0)));
            }
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.n;
            if (newScrollFragmentAdapter == null) {
                return false;
            }
            return newScrollFragmentAdapter.h();
        }
        return invokeV.booleanValue;
    }

    public void K() {
        wz5 wz5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (wz5Var = this.p) == null) {
            return;
        }
        wz5Var.I();
    }

    public void L() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (newScrollFragmentAdapter = this.n) == null) {
            return;
        }
        newScrollFragmentAdapter.i();
    }

    public final int M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return i2 != 4 ? -1 : 5;
                        }
                        return 4;
                    }
                    return 3;
                }
                return 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public String N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.n.p(i2) : (String) invokeI.objValue;
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.K == null || this.d == null) {
            return;
        }
        k05 f2 = sz6.f(str);
        if (f2 != null) {
            TbadkApplication.getInst().setUseLuckyHeader(true);
            String d2 = sz6.d(f2);
            this.K.setBackgroundColor(Color.parseColor(d2));
            this.g.setBackgroundColor(sg8.f(d2));
            this.d.a(false);
        } else {
            TbadkApplication.getInst().setUseLuckyHeader(false);
            ur4.d(this.K).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0203);
            this.d.a(true ^ UtilHelper.isNightOrDarkMode());
        }
        NestedScrollHeader nestedScrollHeader = this.M;
        if (nestedScrollHeader != null) {
            nestedScrollHeader.m();
        }
        this.c.l();
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.n;
            return newScrollFragmentAdapter != null && newScrollFragmentAdapter.getCount() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void Q() {
        StickyAppBarLayout stickyAppBarLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4006);
            this.a = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0744, (ViewGroup) this, true);
            this.u = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090647);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090649);
            this.v = tbImageView;
            tbImageView.setUseNightOrDarkMask(false);
            this.v.setNeedNightShade(false);
            this.w = findViewById(R.id.obfuscated_res_0x7f090648);
            if (UbsABTestHelper.isHomeTabModifyABTestA()) {
                FixedAppBarLayout fixedAppBarLayout = new FixedAppBarLayout(this.a);
                this.L = fixedAppBarLayout;
                addView(fixedAppBarLayout, 2);
            } else {
                StickyAppBarLayout stickyAppBarLayout2 = (StickyAppBarLayout) s55.e().d(1006, new e(this));
                this.K = stickyAppBarLayout2;
                stickyAppBarLayout2.e(this.a);
                addView(this.K, 2);
                vk8.c(this.K, 4);
                this.M = (NestedScrollHeader) findViewById(R.id.obfuscated_res_0x7f090d39);
            }
            this.c = (HomeTabBarView) findViewById(R.id.obfuscated_res_0x7f090d43);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090d41);
            this.e = frameLayout;
            vk8.c(frameLayout, 5);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f091ed9);
            this.f = customViewPager;
            customViewPager.setForm(1);
            this.g = findViewById(R.id.obfuscated_res_0x7f0907ca);
            this.h = findViewById(R.id.obfuscated_res_0x7f0907d7);
            this.i = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090d60);
            this.j = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0903c5);
            if (tm4.b() == 1) {
                tu4 tu4Var = new tu4();
                this.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0867));
                this.i.setTextSize(R.dimen.tbds42);
                this.i.setConfig(tu4Var);
                this.i.setOnClickListener(this.I);
                this.i.setVisibility(0);
            } else if (tm4.b() == 2) {
                tu4 tu4Var2 = new tu4();
                this.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0868));
                this.i.setTextSize(R.dimen.tbds35);
                this.i.setConfig(tu4Var2);
                this.i.setOnClickListener(this.I);
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            this.O = (us6) s55.e().d(1012, new f(this));
            if (UtilHelper.canUseStyleImmersiveSticky() && (stickyAppBarLayout = this.K) != null) {
                stickyAppBarLayout.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.c.setOnPageChangeListener(new g(this));
            this.c.setOnTabItemClickListener(new h(this));
            StickyAppBarLayout stickyAppBarLayout3 = this.K;
            if (stickyAppBarLayout3 != null) {
                stickyAppBarLayout3.setOnHeaderStickyListener(new i(this));
            }
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
                NestedScrollHeader nestedScrollHeader = this.M;
                if (nestedScrollHeader != null) {
                    nestedScrollHeader.setVisibility(8);
                }
                this.c.setMissionEntranceVisibility(true);
                this.c.setEntranceJumpListener(new j(this));
            } else {
                NestedScrollHeader nestedScrollHeader2 = this.M;
                if (nestedScrollHeader2 != null) {
                    nestedScrollHeader2.setVisibility(0);
                }
                this.c.setMissionEntranceVisibility(false);
            }
            i0();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4007);
        }
    }

    public void R(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.d = new fe5(tbPageContext.getPageActivity());
            MessageManager.getInstance().registerListener(this.z);
            MessageManager.getInstance().registerListener(this.A);
            MessageManager.getInstance().registerListener(this.E);
            MessageManager.getInstance().registerListener(this.D);
            MessageManager.getInstance().registerListener(this.B);
            MessageManager.getInstance().registerListener(this.P);
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.y);
            this.G.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.G);
            if (this.b != null) {
                this.x.setPriority(Integer.MAX_VALUE);
                MessageManager.getInstance().registerListener(this.x);
            }
        }
    }

    @RequiresApi(api = 3)
    public void S(FragmentManager fragmentManager, lu6 lu6Var, ConcernPageView.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, fragmentManager, lu6Var, oVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.a, fragmentManager, false, lu6Var, oVar);
                this.n = newScrollFragmentAdapter;
                newScrollFragmentAdapter.H(this);
                this.f.setOffscreenPageLimit(2);
                this.f.setAdapter(this.n);
                int m2 = this.n.m();
                NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.n;
                if (HomePageStatic.a) {
                    m2 = 0;
                }
                this.f.setCurrentItem(newScrollFragmentAdapter2.n(m2));
                this.c.setViewPager(this.f);
                this.c.setConcernTabIndex(this.n.n(0));
                this.t = new GestureDetector(this.a, new l(this));
                if (FullBrowseHelper.checkIsFullBrowseMode()) {
                    this.f.setScrollable(false, this.t);
                } else {
                    this.f.setScrollable(true);
                }
            } finally {
                TTIStats.record("ScrollFragmentTabHost.initViewPager", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.h.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.c == null || (newScrollFragmentAdapter = this.n) == null || !newScrollFragmentAdapter.w()) {
                return false;
            }
            return this.c.g();
        }
        return invokeV.booleanValue;
    }

    public void V() {
        StickyAppBarLayout stickyAppBarLayout;
        HomeTabBarView homeTabBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (stickyAppBarLayout = this.K) == null || stickyAppBarLayout.f() || (homeTabBarView = this.c) == null || homeTabBarView.getTaskView() == null || this.c.getTaskView().getVisibility() == 0) {
            return;
        }
        this.c.i();
    }

    public void W() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (newScrollFragmentAdapter = this.n) == null || HomePageStatic.a) {
            return;
        }
        this.f.setAdapter(newScrollFragmentAdapter);
        this.c.j();
        this.R.a(this.S);
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.n;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.C(i2);
            }
            us6 us6Var = this.O;
            if (us6Var != null) {
                us6Var.k(i2);
            }
            SkinManager.setBackgroundResource(this.h, R.drawable.personalize_tab_shadow);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            wz5 wz5Var = this.N;
            if (wz5Var != null) {
                wz5Var.I();
                this.N = null;
            }
            StickyAppBarLayout stickyAppBarLayout = this.K;
            if (stickyAppBarLayout != null) {
                stickyAppBarLayout.h();
            }
            FixedAppBarLayout fixedAppBarLayout = this.L;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.l();
            }
            K();
            MessageManager.getInstance().unRegisterListener(this.P);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HomeTabBarView homeTabBarView = this.c;
            if (homeTabBarView != null) {
                homeTabBarView.m();
            }
            FixedAppBarLayout fixedAppBarLayout = this.L;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.m();
            }
        }
    }

    @Override // com.repackage.mu6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.k && !T()) {
            this.h.setVisibility(0);
            if (this.l == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.l = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.l.setDuration(300L);
            }
            this.h.startAnimation(this.l);
        }
    }

    public void a0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (newScrollFragmentAdapter = this.n) == null) {
            return;
        }
        newScrollFragmentAdapter.r(this.T);
    }

    @Override // com.repackage.mu6
    public void b(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, yVar) == null) {
            if (this.q == null) {
                this.q = new ArrayList();
            }
            this.q.add(yVar);
        }
    }

    public void b0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (newScrollFragmentAdapter = this.n) == null) {
            return;
        }
        newScrollFragmentAdapter.D();
    }

    @Override // com.repackage.mu6
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.k && T()) {
            if (this.m == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.m = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.m.setDuration(300L);
                this.m.setAnimationListener(new n(this));
            }
            this.h.startAnimation(this.m);
        }
    }

    public final void c0(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || this.b == null || (newScrollFragmentAdapter = this.n) == null || (customViewPager = this.f) == null) {
            return;
        }
        String o2 = newScrollFragmentAdapter.o(customViewPager.getCurrentItem());
        ju6 ju6Var = new ju6();
        ju6Var.b = o2;
        ju6Var.c = i2;
        CustomMessage customMessage = new CustomMessage(2921652);
        customMessage.setTag(this.b.getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921652, ju6Var);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // com.repackage.mu6
    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? this.n.q(i2) : invokeI.intValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && TbadkCoreApplication.isLogin()) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.n;
            int n2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.n(0) : 0;
            if (this.p == null) {
                wz5 wz5Var = new wz5(this.b, this.c.d(n2));
                this.p = wz5Var;
                wz5Var.e0(R.drawable.obfuscated_res_0x7f0802ef);
                this.p.O(16);
                this.p.U(true);
                this.p.h0(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.p.f0(true);
                this.p.N(4000);
            }
            this.p.k0(this.a.getString(R.string.obfuscated_res_0x7f0f0423), "key_concern_forum_tab_tips_show");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, canvas) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY);
            super.dispatchDraw(canvas);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY);
        }
    }

    @Override // com.repackage.mu6
    public void e(y yVar) {
        List<y> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, yVar) == null) || (list = this.q) == null || list.size() <= 0) {
            return;
        }
        this.q.remove(yVar);
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (xt4.k().l("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.n;
            int n2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.n(0) : 0;
            if (this.p == null) {
                wz5 wz5Var = new wz5(this.b, this.c.d(n2));
                this.p = wz5Var;
                wz5Var.e0(R.drawable.obfuscated_res_0x7f0802ee);
                this.p.O(32);
                this.p.U(true);
                this.p.f0(true);
                this.p.i0(pi.f(this.a, R.dimen.obfuscated_res_0x7f0701be));
                this.p.N(4000);
            }
            this.p.l0(this.a.getString(R.string.obfuscated_res_0x7f0f0424), "key_concern_tab_tips", true);
        }
    }

    @Override // com.repackage.mu6
    public void f(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (this.n != null) {
                    this.n.L();
                }
            } finally {
                TTIStats.record("ScrollFragmentTabHost.startFirstLoad", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void g0(DataRes dataRes, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048608, this, dataRes, z2) == null) || (newScrollFragmentAdapter = this.n) == null) {
            return;
        }
        newScrollFragmentAdapter.N(dataRes, z2);
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            CustomViewPager customViewPager = this.f;
            if (customViewPager != null) {
                return customViewPager.getCurrentItem();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.n;
            if (newScrollFragmentAdapter != null) {
                return newScrollFragmentAdapter.l();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.mu6
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.n;
            if (newScrollFragmentAdapter == null) {
                return 0;
            }
            return newScrollFragmentAdapter.q(this.f.getCurrentItem());
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.mu6
    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.e : (FrameLayout) invokeV.objValue;
    }

    public int getVideoRecommendIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.n != null && this.f.getAdapter() != null) {
                int count = this.f.getAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (this.n.q(i2) == 8) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void h0(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048614, this, str, i2, i3) == null) || this.f == null || this.n == null) {
            return;
        }
        if (i2 == -1) {
            pi.N(this.a, R.string.obfuscated_res_0x7f0f0c2b);
        }
        jz6.a("mPagerAdapterError");
        this.n.O(str, i2, i3);
    }

    public final void i0() {
        NestedScrollHeader nestedScrollHeader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (nestedScrollHeader = this.M) == null) {
            return;
        }
        nestedScrollHeader.setGameLayoutVisible(true);
    }

    public void j0(tbclient.Personalized.DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.n == null) {
            return;
        }
        jz6.a("mPagerAdapterSuccess");
        this.n.Q(dataRes, z2, z3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onAttachedToWindow();
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
                this.H.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.H);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onDetachedFromWindow();
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
                MessageManager.getInstance().unRegisterTask(2921405);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5008);
            super.onLayout(z2, i2, i3, i4, i5);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048620, this, i2, i3) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5000);
            super.onMeasure(i2, i3);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5007);
        }
    }

    public void setCurrentTab(int i2, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) || i2 < 0 || (newScrollFragmentAdapter = this.n) == null || i2 >= newScrollFragmentAdapter.getCount()) {
            return;
        }
        this.c.setTabItemClicked(z2);
        this.n.I(i2);
        this.f.setCurrentItem(i2);
    }

    public void setCurrentTabByCode(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, str) == null) || (newScrollFragmentAdapter = this.n) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.s(str), false);
    }

    public void setFakeClickCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (newScrollFragmentAdapter = this.n) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.n(i2), true);
    }

    @Override // com.repackage.mu6
    public void setOnTabSelectedListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, zVar) == null) {
            this.o = zVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bdUniqueId) == null) {
            this.c.setPageUniqueId(bdUniqueId);
            this.z.setTag(bdUniqueId);
            this.A.setTag(bdUniqueId);
            this.E.setTag(bdUniqueId);
            this.D.setTag(bdUniqueId);
            this.B.setTag(bdUniqueId);
            this.F.setTag(bdUniqueId);
            this.y.setTag(bdUniqueId);
            this.x.setTag(bdUniqueId);
        }
    }

    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            this.r = z2;
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.n;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.G(z2);
            }
            fe5 fe5Var = this.d;
            if (fe5Var != null) {
                fe5Var.b(z2);
            }
        }
    }

    public void setScrollShadow(boolean z2) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.k = z2;
            if (!z2 || (view2 = this.g) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public void setShowConcernRedTip(boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) || this.c == null || (newScrollFragmentAdapter = this.n) == null || !newScrollFragmentAdapter.w()) {
            return;
        }
        this.c.setShowConcernRedTip(z2);
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, str) == null) || (newScrollFragmentAdapter = this.n) == null) {
            return;
        }
        newScrollFragmentAdapter.J(str);
    }

    @Override // com.repackage.mu6
    public void setCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i2) == null) || (newScrollFragmentAdapter = this.n) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.n(i2), false);
    }

    public void setCurrentTab(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, str) == null) || (newScrollFragmentAdapter = this.n) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.t(str), false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
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
        this.s = false;
        this.x = new k(this, 2921652);
        this.y = new q(this, 2921563);
        this.z = new r(this, 2921400);
        this.A = new s(this, 2921415);
        this.B = new t(this, 2921501);
        this.D = new u(this, 2921653);
        this.E = new v(this, 2921502);
        this.F = new w(this, 2921509);
        this.G = new CustomMessageTask(2921409, new x(this));
        this.H = new CustomMessageTask(2921405, new a(this));
        this.I = new b(this);
        this.J = new c(this);
        this.P = new d(this, 2001371);
        this.Q = new m(this);
        this.R = new su6();
        this.S = new o(this);
        this.T = new p(this);
        Q();
    }
}
