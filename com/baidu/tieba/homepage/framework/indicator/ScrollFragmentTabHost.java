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
import com.baidu.tieba.aq4;
import com.baidu.tieba.c45;
import com.baidu.tieba.cm4;
import com.baidu.tieba.ej;
import com.baidu.tieba.fi5;
import com.baidu.tieba.fy6;
import com.baidu.tieba.g45;
import com.baidu.tieba.gy6;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.hv4;
import com.baidu.tieba.iy6;
import com.baidu.tieba.jy6;
import com.baidu.tieba.ly6;
import com.baidu.tieba.m37;
import com.baidu.tieba.my4;
import com.baidu.tieba.my6;
import com.baidu.tieba.o95;
import com.baidu.tieba.ol8;
import com.baidu.tieba.on;
import com.baidu.tieba.ox4;
import com.baidu.tieba.py6;
import com.baidu.tieba.rw6;
import com.baidu.tieba.sp8;
import com.baidu.tieba.x36;
import com.baidu.tieba.yg;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentTabHost extends CoordinatorLayout implements jy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public final CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public boolean G;
    public CustomMessageListener H;
    public CustomMessageListener I;
    public CustomMessageListener J;
    public CustomMessageListener K;
    public CustomMessageTask L;
    public CustomMessageTask M;
    public View.OnClickListener N;
    public yg<on> O;
    @Nullable
    public StickyAppBarLayout P;
    @Nullable
    public FixedAppBarLayout Q;
    @Nullable
    public NestedScrollHeader R;
    public x36 S;
    public rw6 T;
    public CustomMessageListener U;
    public yg<on> V;
    public py6 W;
    public Context a;
    public my6 a0;
    public TbPageContext b;
    public ly6 b0;
    public HomeTabBarView c;
    public fi5 d;
    public boolean e;
    public int f;
    public String g;
    public String h;
    public FrameLayout i;
    public CustomViewPager j;
    public View k;
    public View l;
    public TBSpecificationBtn m;
    public FrameLayout n;
    public boolean o;
    public AlphaAnimation p;
    public AlphaAnimation q;
    public NewScrollFragmentAdapter r;
    public z s;
    public x36 t;
    public List<y> u;
    public boolean v;
    public boolean w;
    public GestureDetector x;
    public FrameLayout y;
    public TbImageView z;

    /* loaded from: classes4.dex */
    public class a implements CustomMessageTask.CustomRunnable<cm4.b> {
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
        public CustomResponsedMessage<?> run(CustomMessage<cm4.b> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.b != null && !this.a.b.getPageActivity().isFinishing() && this.a.P != null && this.a.R != null) {
                    ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? this.a.c.getTaskView() : null;
                    if (taskView == null) {
                        return null;
                    }
                    if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof cm4.b)) {
                        cm4.b data = customMessage.getData();
                        int intValue = data.c.intValue() > 0 ? data.c.intValue() * 1000 : 5000;
                        String str = data.g;
                        if (TextUtils.isEmpty(str)) {
                            str = this.a.b.getString(R.string.obfuscated_res_0x7f0f1397);
                        }
                        String fixedText = UtilHelper.getFixedText(str, 20);
                        if (this.a.S != null) {
                            this.a.S.N();
                        }
                        ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                        scrollFragmentTabHost.S = new x36(scrollFragmentTabHost.b, taskView);
                        this.a.S.T(48);
                        this.a.S.r0(true);
                        this.a.S.Q(4);
                        this.a.S.S(intValue);
                        this.a.S.c0(true);
                        this.a.S.u0(0);
                        this.a.S.w0(fixedText);
                        return new CustomResponsedMessage<>(2921409, Boolean.TRUE);
                    }
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CustomMessageTask.CustomRunnable<Boolean> {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || this.a.P == null) {
                    return null;
                }
                this.a.c();
                boolean z = false;
                if (customMessage.getData().booleanValue()) {
                    z = this.a.P.i();
                } else if (this.a.P.f() && this.a.v) {
                    z = true;
                    this.a.P.i();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, Boolean.TRUE));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (aq4.b() == 1) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{"http://fans.baidu.com/fanstest/wapindex?product_id=1002&version=12.11.0.11&client_type=android&contact_way=qq"});
                } else if (aq4.b() == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921569));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public d(ScrollFragmentTabHost scrollFragmentTabHost) {
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
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                if (onVar == null || this.a.z == null) {
                    this.a.z.setVisibility(8);
                } else {
                    this.a.z.setImageBitmap(onVar.p());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
                if (this.a.G != UbsABTestHelper.isConcernForumCardShow()) {
                    this.a.c.j();
                    if (UbsABTestHelper.isConcernForumCardShow() && this.a.v) {
                        this.a.O();
                        this.a.h0();
                    }
                }
                this.a.setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements o95.a {
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

        @Override // com.baidu.tieba.o95.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new rw6(this.a.a) : invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                    boolean Y = this.a.Y();
                    TiebaStatic.log(new StatisticItem("c12350").param("obj_type", Y ? 1 : 0));
                    if (Y && this.a.r != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        this.a.r.N();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
                this.a.g0(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || this.a.r == null) {
                return;
            }
            TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.R(i));
            this.a.r.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.r == null) {
                return;
            }
            if (this.a.s != null) {
                this.a.s.a(i);
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
            int r = this.a.r.r(this.a.j.getCurrentItem());
            if (r == 5) {
                if (this.a.w) {
                    this.a.w = false;
                } else {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 0);
                    statisticItem.eventStat();
                }
            }
            if (r == 0) {
                this.a.O();
            }
            View d = this.a.c.d(0);
            if ((d instanceof LinearLayout) && TbadkCoreApplication.isLogin() && UbsABTestHelper.isConcernForumCardShow()) {
                LinearLayout linearLayout = (LinearLayout) d;
                if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (r == 0) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                }
            }
            if (this.a.u != null && this.a.r != null) {
                int r2 = this.a.r.r(this.a.j.getCurrentItem());
                if (r2 == 5) {
                    this.a.setScrollShadow(false);
                    for (y yVar : this.a.u) {
                        yVar.c();
                    }
                } else if (r2 == 1) {
                    this.a.setScrollShadow(false);
                    for (y yVar2 : this.a.u) {
                        yVar2.b();
                    }
                } else if (r2 == 0) {
                    this.a.setScrollShadow(false);
                    for (y yVar3 : this.a.u) {
                        yVar3.a();
                    }
                } else if (r2 == 6) {
                    this.a.setScrollShadow(true);
                } else if (r2 == 7) {
                    this.a.setScrollShadow(true);
                } else if (r2 == 8) {
                    this.a.setScrollShadow(false);
                } else {
                    this.a.c();
                    this.a.setScrollShadow(false);
                }
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(this.a.d(i));
            TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.R(i));
            if (this.a.d(i) == 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        ox4.k().x(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    ox4.k().x("unlogin_hot_top_timestamp", currentTimeMillis);
                }
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.R(i));
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.L(i);
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && this.a.j.getCurrentItem() != i) {
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
                    TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.R(i));
                    if (this.a.d(i) == 5) {
                        StatisticItem statisticItem = new StatisticItem("c13740");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_type", 0);
                        statisticItem.eventStat();
                        this.a.w = true;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (TbadkCoreApplication.isLogin()) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ox4.k().x(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                            }
                        } else {
                            ox4.k().x("unlogin_hot_top_timestamp", currentTimeMillis);
                        }
                    }
                    ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                    scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.R(i));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.S != null) {
                this.a.S.N();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements NestedScrollHeader.f {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.S != null) {
                    this.a.S.N();
                    this.a.S = null;
                }
                if (this.a.b != null) {
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.n == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof gy6) || ((gy6) customResponsedMessage.getData()).a == null) {
                this.a.n.removeAllViews();
                this.a.n.setVisibility(8);
                return;
            }
            View view2 = ((gy6) customResponsedMessage.getData()).a;
            if (view2.getParent() != null) {
                if (view2.getParent() != this.a.n) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                    this.a.n.removeAllViews();
                    this.a.n.addView(view2);
                }
            } else {
                this.a.n.removeAllViews();
                this.a.n.addView(view2);
            }
            this.a.n.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class m extends yg<on> {
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
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) || this.a.Q == null || onVar == null) {
                return;
            }
            if (onVar.p() == null) {
                this.a.Q.setImageBackgroundVisibility(8);
            } else {
                this.a.Q.setImageBackground(onVar.p());
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.l.setVisibility(8);
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

    /* loaded from: classes4.dex */
    public class o implements my6 {
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

        @Override // com.baidu.tieba.my6
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.r == null) {
                return;
            }
            this.a.setCurrentTab(this.a.r.o(i), false);
            this.a.r.C(i);
        }
    }

    /* loaded from: classes4.dex */
    public class p implements ly6 {
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

        @Override // com.baidu.tieba.ly6
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.W.b(i, this.a.a0);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.j == null) {
                return;
            }
            if (FullBrowseHelper.checkIsFullBrowseMode()) {
                this.a.j.setScrollable(false, this.a.x);
            } else {
                this.a.j.setScrollable(true);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.S == null) {
                return;
            }
            this.a.S.N();
            this.a.S = null;
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
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
                    this.a.T.l(this.a.c.getBackgroundAlpha());
                    this.a.T.k(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.a.P != null) {
                    this.a.T.n(this.a.P);
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

    /* loaded from: classes4.dex */
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
            this.a.r.F();
            this.a.j.setAdapter(this.a.r);
            this.a.c.j();
            this.a.setCurrentTab(1);
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
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
            String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02bc);
            String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02b0);
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) this.a.c.d(0);
            if (intValue == 1) {
                if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    if (string2.equals(textView.getText())) {
                        int measuredWidth = textView.getMeasuredWidth();
                        textView.setText(string);
                        int measureText = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02bc));
                        int measureText2 = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02b0));
                        if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                            ofInt.setDuration(360L);
                            ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                            ofInt.start();
                        }
                    }
                    ox4.k().w("key_home_concern_all_status", 1);
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
                ox4.k().w("key_home_concern_all_status", 0);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.e && customResponsedMessage.getCmd() == 2921746) {
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setSecondCurTab(scrollFragmentTabHost.f, this.a.g, this.a.h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.r == null || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.c == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.r.S();
            this.a.r.Q();
            this.a.j.setAdapter(this.a.r);
            this.a.c.j();
            this.a.m0();
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
        this.e = false;
        this.w = false;
        this.B = new k(this, 2921652);
        this.C = new q(this, 2921563);
        this.D = new r(this, 2921400);
        this.E = new s(this, 2921415);
        this.F = new t(this, 2921501);
        this.H = new u(this, 2921653);
        this.I = new v(this, 2921502);
        this.J = new w(this, 2921746);
        this.K = new x(this, 2921509);
        this.L = new CustomMessageTask(2921409, new a(this));
        this.M = new CustomMessageTask(2921405, new b(this));
        this.N = new c(this);
        this.O = new d(this);
        this.U = new e(this, 2001371);
        this.V = new m(this);
        this.W = new py6();
        this.a0 = new o(this);
        this.b0 = new p(this);
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorHead(String str) {
        String j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, str) == null) {
            fi5 fi5Var = this.d;
            if (fi5Var != null) {
                fi5Var.c(false);
            }
            if (UbsABTestHelper.isHomeTabModifyABTestA()) {
                if (this.Q == null || this.d == null) {
                    return;
                }
                HashMap<String, c45> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
                String str2 = null;
                c45 c45Var = colourHeaderConfig != null ? colourHeaderConfig.get(str) : null;
                M(str, c45Var);
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (c45Var != null) {
                    if (skinType == 0) {
                        str2 = c45Var.m();
                        j2 = c45Var.j();
                    } else if (skinType == 1) {
                        str2 = c45Var.o();
                        j2 = c45Var.l();
                    } else if (skinType != 4) {
                        j2 = null;
                    } else {
                        str2 = c45Var.n();
                        j2 = c45Var.k();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        this.Q.setImageBackgroundVisibility(8);
                        this.Q.setBackgroundColor(ol8.f(j2));
                    } else {
                        this.Q.setImageBackgroundVisibility(0);
                        zg.h().m(str2, 10, this.V, this.b.getUniqueId());
                    }
                    this.d.c(true);
                    if (skinType == 0) {
                        this.d.a(c45Var.p());
                        this.c.c(true, c45Var.p());
                        this.Q.setSearchStyle(true, c45Var.p());
                        return;
                    }
                    this.d.a(false);
                    this.c.c(false, false);
                    this.Q.setSearchStyle(false, false);
                    return;
                }
                this.Q.l();
                this.d.a(!UtilHelper.isNightOrDarkMode());
                this.c.l();
                return;
            }
            S(str);
        }
    }

    public final void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", Q(i2));
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public void M(String str, c45 c45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, c45Var) == null) {
            if (c45Var != null) {
                if (!StringUtils.isNull(c45Var.d())) {
                    this.y.setVisibility(0);
                    fy6.h(c45Var, this.z, this.A, this.O, this.b.getUniqueId());
                } else if (!StringUtils.isNull(c45Var.a())) {
                    this.y.setVisibility(0);
                    fy6.g(c45Var, this.z, this.A);
                } else {
                    this.y.setVisibility(8);
                }
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.B(str);
            }
            if (getResources().getString(R.string.obfuscated_res_0x7f0f1373).equals(str) || getResources().getString(R.string.obfuscated_res_0x7f0f026d).equals(TbadkCoreApplication.getInst().getHomeBarShowTabName())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921722, Boolean.valueOf(this.y.getVisibility() == 0)));
            }
        }
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter == null) {
                return false;
            }
            return newScrollFragmentAdapter.h();
        }
        return invokeV.booleanValue;
    }

    public void O() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x36Var = this.t) == null) {
            return;
        }
        x36Var.N();
    }

    public void P() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.i();
    }

    public final int Q(int i2) {
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

    public String R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.r.q(i2) : (String) invokeI.objValue;
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.P == null || this.d == null) {
            return;
        }
        g45 f2 = m37.f(str);
        if (f2 != null) {
            TbadkApplication.getInst().setUseLuckyHeader(true);
            String d2 = m37.d(f2);
            this.P.setBackgroundColor(Color.parseColor(d2));
            this.k.setBackgroundColor(ol8.f(d2));
            this.d.a(false);
        } else {
            TbadkApplication.getInst().setUseLuckyHeader(false);
            hv4.d(this.P).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0203);
            this.d.a(true ^ UtilHelper.isNightOrDarkMode());
        }
        NestedScrollHeader nestedScrollHeader = this.R;
        if (nestedScrollHeader != null) {
            nestedScrollHeader.k();
        }
        this.c.l();
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            return newScrollFragmentAdapter != null && newScrollFragmentAdapter.getCount() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void U() {
        StickyAppBarLayout stickyAppBarLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4006);
            this.a = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0791, (ViewGroup) this, true);
            this.y = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090676);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090678);
            this.z = tbImageView;
            tbImageView.setUseNightOrDarkMask(false);
            this.z.setNeedNightShade(false);
            this.A = findViewById(R.id.obfuscated_res_0x7f090677);
            if (UbsABTestHelper.isHomeTabModifyABTestA()) {
                FixedAppBarLayout fixedAppBarLayout = new FixedAppBarLayout(this.a);
                this.Q = fixedAppBarLayout;
                addView(fixedAppBarLayout, 2);
            } else {
                StickyAppBarLayout stickyAppBarLayout2 = new StickyAppBarLayout(this.a);
                this.P = stickyAppBarLayout2;
                stickyAppBarLayout2.e(this.a);
                addView(this.P, 2);
                sp8.c(this.P, 4);
                this.R = (NestedScrollHeader) findViewById(R.id.obfuscated_res_0x7f090d94);
            }
            this.c = (HomeTabBarView) findViewById(R.id.obfuscated_res_0x7f090da1);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090d9c);
            this.i = frameLayout;
            sp8.c(frameLayout, 5);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f092029);
            this.j = customViewPager;
            customViewPager.setForm(1);
            this.k = findViewById(R.id.divider_line);
            this.l = findViewById(R.id.obfuscated_res_0x7f090819);
            this.m = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090dbb);
            this.n = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0903e9);
            if (aq4.b() == 1) {
                my4 my4Var = new my4();
                this.m.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0878));
                this.m.setTextSize(R.dimen.tbds42);
                this.m.setConfig(my4Var);
                this.m.setOnClickListener(this.N);
                this.m.setVisibility(0);
            } else if (aq4.b() == 2) {
                my4 my4Var2 = new my4();
                this.m.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0879));
                this.m.setTextSize(R.dimen.tbds35);
                this.m.setConfig(my4Var2);
                this.m.setOnClickListener(this.N);
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            this.T = (rw6) o95.e().d(1012, new f(this));
            if (UtilHelper.canUseStyleImmersiveSticky() && (stickyAppBarLayout = this.P) != null) {
                stickyAppBarLayout.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            this.c.setOnPageChangeListener(new g(this));
            this.c.setOnTabItemClickListener(new h(this));
            StickyAppBarLayout stickyAppBarLayout3 = this.P;
            if (stickyAppBarLayout3 != null) {
                stickyAppBarLayout3.setOnHeaderStickyListener(new i(this));
            }
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
                NestedScrollHeader nestedScrollHeader = this.R;
                if (nestedScrollHeader != null) {
                    nestedScrollHeader.setVisibility(8);
                }
                this.c.setMissionEntranceVisibility(true);
                this.c.setEntranceJumpListener(new j(this));
            } else {
                NestedScrollHeader nestedScrollHeader2 = this.R;
                if (nestedScrollHeader2 != null) {
                    nestedScrollHeader2.setVisibility(0);
                }
                this.c.setMissionEntranceVisibility(false);
            }
            m0();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4007);
        }
    }

    public void V(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.d = new fi5(tbPageContext.getPageActivity());
            MessageManager.getInstance().registerListener(this.D);
            MessageManager.getInstance().registerListener(this.E);
            MessageManager.getInstance().registerListener(this.I);
            MessageManager.getInstance().registerListener(this.H);
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.U);
            MessageManager.getInstance().registerListener(this.K);
            MessageManager.getInstance().registerListener(this.C);
            MessageManager.getInstance().registerListener(this.J);
            this.L.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.L);
            if (this.b != null) {
                this.B.setPriority(Integer.MAX_VALUE);
                MessageManager.getInstance().registerListener(this.B);
            }
        }
    }

    @RequiresApi(api = 3)
    public void W(FragmentManager fragmentManager, iy6 iy6Var, ConcernPageView.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, fragmentManager, iy6Var, oVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.a, fragmentManager, false, iy6Var, oVar);
                this.r = newScrollFragmentAdapter;
                newScrollFragmentAdapter.I(this);
                this.j.setOffscreenPageLimit(2);
                this.j.setAdapter(this.r);
                int n2 = this.r.n();
                NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.r;
                if (HomePageStatic.a) {
                    n2 = 0;
                }
                this.j.setCurrentItem(newScrollFragmentAdapter2.o(n2));
                this.c.setViewPager(this.j);
                this.c.setConcernTabIndex(this.r.o(0));
                this.x = new GestureDetector(this.a, new l(this));
                if (FullBrowseHelper.checkIsFullBrowseMode()) {
                    this.j.setScrollable(false, this.x);
                } else {
                    this.j.setScrollable(true);
                }
            } finally {
                TTIStats.record("ScrollFragmentTabHost.initViewPager", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.c == null || (newScrollFragmentAdapter = this.r) == null || !newScrollFragmentAdapter.x()) {
                return false;
            }
            return this.c.g();
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        StickyAppBarLayout stickyAppBarLayout;
        HomeTabBarView homeTabBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (stickyAppBarLayout = this.P) == null || stickyAppBarLayout.f() || (homeTabBarView = this.c) == null || homeTabBarView.getTaskView() == null || this.c.getTaskView().getVisibility() == 0) {
            return;
        }
        this.c.i();
    }

    @Override // com.baidu.tieba.jy6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.o && !X()) {
            this.l.setVisibility(0);
            if (this.p == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.p = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.p.setDuration(300L);
            }
            this.l.startAnimation(this.p);
        }
    }

    public void a0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (newScrollFragmentAdapter = this.r) == null || HomePageStatic.a) {
            return;
        }
        this.j.setAdapter(newScrollFragmentAdapter);
        this.c.j();
        this.W.a(this.a0);
    }

    @Override // com.baidu.tieba.jy6
    public void b(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, yVar) == null) {
            if (this.u == null) {
                this.u = new ArrayList();
            }
            this.u.add(yVar);
        }
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.D(i2);
            }
            rw6 rw6Var = this.T;
            if (rw6Var != null) {
                rw6Var.k(i2);
            }
            SkinManager.setBackgroundResource(this.l, R.drawable.personalize_tab_shadow);
        }
    }

    @Override // com.baidu.tieba.jy6
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.o && X()) {
            if (this.q == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.q = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.q.setDuration(300L);
                this.q.setAnimationListener(new n(this));
            }
            this.l.startAnimation(this.q);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            x36 x36Var = this.S;
            if (x36Var != null) {
                x36Var.N();
                this.S = null;
            }
            StickyAppBarLayout stickyAppBarLayout = this.P;
            if (stickyAppBarLayout != null) {
                stickyAppBarLayout.h();
            }
            FixedAppBarLayout fixedAppBarLayout = this.Q;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.m();
            }
            O();
            MessageManager.getInstance().unRegisterListener(this.U);
            MessageManager.getInstance().unRegisterListener(this.J);
        }
    }

    @Override // com.baidu.tieba.jy6
    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? this.r.r(i2) : invokeI.intValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            HomeTabBarView homeTabBarView = this.c;
            if (homeTabBarView != null) {
                homeTabBarView.m();
            }
            FixedAppBarLayout fixedAppBarLayout = this.Q;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.n();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, canvas) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY);
            super.dispatchDraw(canvas);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tieba.jy6
    public void e(y yVar) {
        List<y> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, yVar) == null) || (list = this.u) == null || list.size() <= 0) {
            return;
        }
        this.u.remove(yVar);
    }

    public void e0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.s(this.b0);
    }

    @Override // com.baidu.tieba.jy6
    public void f(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
        }
    }

    public void f0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.E();
    }

    public final void g0(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || this.b == null || (newScrollFragmentAdapter = this.r) == null || (customViewPager = this.j) == null) {
            return;
        }
        String p2 = newScrollFragmentAdapter.p(customViewPager.getCurrentItem());
        gy6 gy6Var = new gy6();
        gy6Var.b = p2;
        gy6Var.c = i2;
        CustomMessage customMessage = new CustomMessage(2921652);
        customMessage.setTag(this.b.getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921652, gy6Var);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            CustomViewPager customViewPager = this.j;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                return newScrollFragmentAdapter.m();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jy6
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter == null) {
                return 0;
            }
            return newScrollFragmentAdapter.r(this.j.getCurrentItem());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jy6
    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.i : (FrameLayout) invokeV.objValue;
    }

    public int getVideoRecommendIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.r != null && this.j.getAdapter() != null) {
                int count = this.j.getAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (this.r.r(i2) == 8) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && TbadkCoreApplication.isLogin()) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int o2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.o(0) : 0;
            if (this.t == null) {
                x36 x36Var = new x36(this.b, this.c.d(o2));
                this.t = x36Var;
                x36Var.q0(R.drawable.obfuscated_res_0x7f0802f5);
                this.t.T(16);
                this.t.c0(true);
                this.t.u0(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.t.r0(true);
                this.t.S(4000);
            }
            this.t.x0(this.a.getString(R.string.obfuscated_res_0x7f0f0432), "key_concern_forum_tab_tips_show");
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (ox4.k().l("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int o2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.o(0) : 0;
            if (this.t == null) {
                x36 x36Var = new x36(this.b, this.c.d(o2));
                this.t = x36Var;
                x36Var.q0(R.drawable.obfuscated_res_0x7f0802f4);
                this.t.T(32);
                this.t.c0(true);
                this.t.r0(true);
                this.t.v0(ej.f(this.a, R.dimen.obfuscated_res_0x7f0701be));
                this.t.S(4000);
            }
            this.t.y0(this.a.getString(R.string.obfuscated_res_0x7f0f0433), "key_concern_tab_tips", true);
        }
    }

    public void j0(boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.M(z2);
    }

    public void k0(DataRes dataRes, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048613, this, dataRes, z2) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.O(dataRes, z2);
    }

    public void l0(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048614, this, str, i2, i3) == null) || this.j == null || this.r == null) {
            return;
        }
        if (i2 == -1) {
            ej.M(this.a, R.string.obfuscated_res_0x7f0f0c59);
        }
        this.r.P(str, i2, i3);
    }

    public final void m0() {
        NestedScrollHeader nestedScrollHeader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (nestedScrollHeader = this.R) == null) {
            return;
        }
        nestedScrollHeader.setGameLayoutVisible(true);
    }

    public void n0(tbclient.Personalized.DataRes dataRes, boolean z2, boolean z3) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.R(dataRes, z2, z3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onAttachedToWindow();
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
                this.M.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.M);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) || i2 < 0 || (newScrollFragmentAdapter = this.r) == null || i2 >= newScrollFragmentAdapter.getCount()) {
            return;
        }
        this.c.setTabItemClicked(z2);
        this.r.K(i2);
        this.j.setCurrentItem(i2);
    }

    public void setCurrentTabByCode(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, str) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.t(str), false);
        setSecondCurTab(-1, "", str);
    }

    public void setFakeClickCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.o(i2), true);
    }

    @Override // com.baidu.tieba.jy6
    public void setOnTabSelectedListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, zVar) == null) {
            this.s = zVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bdUniqueId) == null) {
            this.c.setPageUniqueId(bdUniqueId);
            this.D.setTag(bdUniqueId);
            this.E.setTag(bdUniqueId);
            this.I.setTag(bdUniqueId);
            this.H.setTag(bdUniqueId);
            this.F.setTag(bdUniqueId);
            this.K.setTag(bdUniqueId);
            this.C.setTag(bdUniqueId);
            this.B.setTag(bdUniqueId);
        }
    }

    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            this.v = z2;
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.H(z2);
            }
            fi5 fi5Var = this.d;
            if (fi5Var != null) {
                fi5Var.b(z2);
            }
        }
    }

    public void setScrollShadow(boolean z2) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.o = z2;
            if (!z2 || (view2 = this.k) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public void setSecondCurTab(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048630, this, i2, str, str2) == null) && UbsABTestHelper.isHomeTabModifyABTestA() && this.r.t(str2) == this.r.v()) {
            if (this.r.l() instanceof PersonalizeWrapperFragment) {
                PersonalizeWrapperFragment personalizeWrapperFragment = (PersonalizeWrapperFragment) this.r.l();
                if (i2 != -1) {
                    personalizeWrapperFragment.w1(i2);
                } else if (!TextUtils.isEmpty(str)) {
                    personalizeWrapperFragment.v1(str);
                } else if (TextUtils.isEmpty(str2)) {
                } else {
                    personalizeWrapperFragment.u1(str2);
                }
            } else if (this.r.l() == null) {
                this.e = true;
                this.f = i2;
                this.h = str2;
                this.g = str;
            }
        }
    }

    public void setShowConcernRedTip(boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) || this.c == null || (newScrollFragmentAdapter = this.r) == null || !newScrollFragmentAdapter.x()) {
            return;
        }
        this.c.setShowConcernRedTip(z2);
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, str) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.L(str);
    }

    @Override // com.baidu.tieba.jy6
    public void setCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i2) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.o(i2), false);
        setSecondCurTab(i2, "", "");
    }

    public void setCurrentTab(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, str) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.u(str), false);
        setSecondCurTab(-1, str, "");
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
        this.e = false;
        this.w = false;
        this.B = new k(this, 2921652);
        this.C = new q(this, 2921563);
        this.D = new r(this, 2921400);
        this.E = new s(this, 2921415);
        this.F = new t(this, 2921501);
        this.H = new u(this, 2921653);
        this.I = new v(this, 2921502);
        this.J = new w(this, 2921746);
        this.K = new x(this, 2921509);
        this.L = new CustomMessageTask(2921409, new a(this));
        this.M = new CustomMessageTask(2921405, new b(this));
        this.N = new c(this);
        this.O = new d(this);
        this.U = new e(this, 2001371);
        this.V = new m(this);
        this.W = new py6();
        this.a0 = new o(this);
        this.b0 = new p(this);
        U();
    }
}
