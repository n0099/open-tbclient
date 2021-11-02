package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import b.a.q0.a.o;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
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
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes9.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public CustomMessageTask F;
    public CustomMessageTask G;
    public StickyAppBarLayout H;
    public NestedScrollHeader I;
    public b.a.r0.f0.g J;
    public b.a.r0.h1.c.b K;
    public boolean L;
    public b.a.r0.h1.d.f.b M;
    public b.a.r0.h1.d.e N;
    public b.a.r0.h1.d.d O;

    /* renamed from: e  reason: collision with root package name */
    public Context f49510e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f49511f;

    /* renamed from: g  reason: collision with root package name */
    public HomeTabBarView f49512g;

    /* renamed from: h  reason: collision with root package name */
    public PluginErrorTipView f49513h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f49514i;
    public FrameLayout j;
    public CustomViewPager k;
    public View l;
    public View m;
    public TBSpecificationBtn n;
    public boolean o;
    public AlphaAnimation p;
    public AlphaAnimation q;
    public NewScrollFragmentAdapter r;
    public t s;
    public b.a.r0.f0.g t;
    public List<s> u;
    public boolean v;
    public boolean w;
    public GestureDetector x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes9.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49515e;

        public a(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49515e = scrollFragmentTabHost;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 0 && this.f49515e.getCurrentTabType() == 0) {
                boolean isShowConcernRedTip = this.f49515e.isShowConcernRedTip();
                TiebaStatic.log(new StatisticItem("c12350").param("obj_type", isShowConcernRedTip ? 1 : 0));
                if (isShowConcernRedTip && this.f49515e.r != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                    this.f49515e.r.startRedDotConcernLoad();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                this.f49515e.r.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f49515e.s != null) {
                    this.f49515e.s.a(i2);
                }
                b.a.q0.s.n.b.i().n(this.f49515e.r.getItemType(i2) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) {
                    if (this.f49515e.getTabType(i2) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int itemType = this.f49515e.r.getItemType(this.f49515e.k.getCurrentItem());
                if (itemType == 5) {
                    if (this.f49515e.w) {
                        this.f49515e.w = false;
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c13740");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_type", 0);
                        statisticItem.eventStat();
                    }
                }
                if (itemType == 0) {
                    this.f49515e.dismissConcernTabTips();
                }
                View tabView = this.f49515e.f49512g.getTabView(0);
                if ((tabView instanceof LinearLayout) && TbadkCoreApplication.isLogin() && b.a.q0.b.d.i()) {
                    LinearLayout linearLayout = (LinearLayout) tabView;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (itemType == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (this.f49515e.u != null && this.f49515e.r != null) {
                    int itemType2 = this.f49515e.r.getItemType(this.f49515e.k.getCurrentItem());
                    if (itemType2 == 5) {
                        this.f49515e.setScrollShadow(false);
                        for (s sVar : this.f49515e.u) {
                            sVar.c();
                        }
                    } else if (itemType2 == 1) {
                        this.f49515e.setScrollShadow(false);
                        for (s sVar2 : this.f49515e.u) {
                            sVar2.b();
                        }
                    } else if (itemType2 == 0) {
                        this.f49515e.setScrollShadow(false);
                        for (s sVar3 : this.f49515e.u) {
                            sVar3.a();
                        }
                    } else if (itemType2 == 6) {
                        this.f49515e.setScrollShadow(true);
                    } else if (itemType2 == 7) {
                        this.f49515e.setScrollShadow(true);
                    } else if (itemType2 == 8) {
                        this.f49515e.setScrollShadow(false);
                    } else {
                        this.f49515e.dismissShadow();
                        this.f49515e.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(this.f49515e.getTabType(i2));
                if (this.f49515e.getTabType(i2) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            return;
                        }
                        b.a.q0.s.e0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                        return;
                    }
                    b.a.q0.s.e0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements PagerSlidingTabStrip.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49516a;

        public b(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49516a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.c
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                if (this.f49516a.getTabType(i2) == 1 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f49516a.f49511f, null)) {
                    this.f49516a.v(i2);
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if ((i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) && this.f49516a.k.getCurrentItem() != i2) {
                        if (this.f49516a.getTabType(i2) != 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                        }
                    }
                    if (this.f49516a.getTabType(i2) == 7) {
                        TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "1"));
                    } else if (this.f49516a.getTabType(i2) == 8) {
                        TiebaStatic.log(new StatisticItem("c13580"));
                    }
                    TbadkCoreApplication.getInst().setHomeBarShowType(this.f49516a.getTabType(i2));
                    if (this.f49516a.getTabType(i2) == 5) {
                        StatisticItem statisticItem = new StatisticItem("c13740");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_type", 0);
                        statisticItem.eventStat();
                        this.f49516a.w = true;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (TbadkCoreApplication.isLogin()) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                return;
                            }
                            b.a.q0.s.e0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                            return;
                        }
                        b.a.q0.s.e0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements StickyAppBarLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49517a;

        public c(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49517a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f49517a.J != null) {
                this.f49517a.J.I();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements NestedScrollHeader.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49518a;

        public d(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49518a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f49518a.J != null) {
                    this.f49518a.J.I();
                    this.f49518a.J = null;
                }
                if (this.f49518a.f49511f != null) {
                    UrlManager.getInstance().dealOneLink(this.f49518a.f49511f, new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements NestedScrollHeader.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49519a;

        public e(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49519a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f49519a.J != null) {
                    this.f49519a.J.I();
                    this.f49519a.J = null;
                }
                if (this.f49519a.f49511f != null) {
                    UrlManager.getInstance().dealOneLink(this.f49519a.f49511f, new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49520e;

        public f(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49520e = scrollFragmentTabHost;
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
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > 40.0f) {
                    FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f49520e.f49511f, null);
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
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
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

    /* loaded from: classes9.dex */
    public class g implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49521a;

        public g(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49521a = scrollFragmentTabHost;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f49521a.m.setVisibility(8);
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

    /* loaded from: classes9.dex */
    public class h implements b.a.r0.h1.d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49522a;

        public h(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49522a = scrollFragmentTabHost;
        }

        @Override // b.a.r0.h1.d.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f49522a.setCurrentTab(this.f49522a.r.getItemPosition(i2), false);
                this.f49522a.r.notifyJumpToLastReadPosition(i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements b.a.r0.h1.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49523a;

        public i(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49523a = scrollFragmentTabHost;
        }

        @Override // b.a.r0.h1.d.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f49523a.M.b(i2, this.f49523a.N);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49524a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ScrollFragmentTabHost scrollFragmentTabHost, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49524a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f49524a.k == null) {
                return;
            }
            if (FullBrowseHelper.checkIsFullBrowseMode()) {
                this.f49524a.k.setScrollable(false, this.f49524a.x);
            } else {
                this.f49524a.k.setScrollable(true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49525a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ScrollFragmentTabHost scrollFragmentTabHost, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49525a = scrollFragmentTabHost;
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
                    this.f49525a.showShadow();
                } else {
                    this.f49525a.dismissShadow();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49526a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ScrollFragmentTabHost scrollFragmentTabHost, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49526a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f49526a.J == null) {
                return;
            }
            this.f49526a.J.I();
            this.f49526a.J = null;
        }
    }

    /* loaded from: classes9.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49527a;

        /* loaded from: classes9.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f49528e;

            public a(m mVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, imageView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49528e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f49528e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f49529e;

            public b(m mVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, imageView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49529e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f49529e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ScrollFragmentTabHost scrollFragmentTabHost, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49527a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) this.f49527a.f49512g.getTabView(0);
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
                if (this.f49527a.f49512g != null) {
                    this.f49527a.K.l(this.f49527a.f49512g.getBackgroundAlpha());
                    this.f49527a.K.k(TbadkCoreApplication.getInst().getSkinType());
                }
                this.f49527a.K.n(this.f49527a.H);
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

    /* loaded from: classes9.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49530a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ScrollFragmentTabHost scrollFragmentTabHost, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49530a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.f49530a.L == b.a.q0.b.d.i()) {
                return;
            }
            this.f49530a.f49512g.notifyDataSetChanged();
            if (b.a.q0.b.d.i() && this.f49530a.v) {
                this.f49530a.dismissConcernTabTips();
                this.f49530a.showConcernTabForumTips();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49531a;

        /* loaded from: classes9.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f49532e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f49533f;

            public a(o oVar, TextView textView, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, textView, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49532e = textView;
                this.f49533f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f49532e.setMaxWidth(this.f49533f + ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f49534e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f49535f;

            public b(o oVar, TextView textView, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, textView, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49534e = textView;
                this.f49535f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f49534e.setMaxWidth(this.f49535f - ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f49536e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f49537f;

            public c(o oVar, TextView textView, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, textView, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49536e = textView;
                this.f49537f = str;
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
                    this.f49536e.setText(this.f49537f);
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
        public o(ScrollFragmentTabHost scrollFragmentTabHost, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49531a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            String string = this.f49531a.getResources().getString(R.string.attention_person);
            String string2 = this.f49531a.getResources().getString(R.string.attention);
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) this.f49531a.f49512g.getTabView(0);
            if (intValue == 1) {
                if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    if (string2.equals(textView.getText())) {
                        int measuredWidth = textView.getMeasuredWidth();
                        textView.setText(string);
                        int measureText = (int) textView.getPaint().measureText(this.f49531a.getResources().getString(R.string.attention_person));
                        int measureText2 = (int) textView.getPaint().measureText(this.f49531a.getResources().getString(R.string.attention));
                        if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                            ofInt.setDuration(360L);
                            ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                            ofInt.start();
                        }
                    }
                    b.a.q0.s.e0.b.j().v("key_home_concern_all_status", 1);
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
                b.a.q0.s.e0.b.j().v("key_home_concern_all_status", 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49538a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ScrollFragmentTabHost scrollFragmentTabHost, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49538a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f49538a.r == null || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f49538a.f49512g == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f49538a.r.updatePersonalizePage();
            this.f49538a.r.updateFragmentTabItems();
            this.f49538a.k.setAdapter(this.f49538a.r);
            this.f49538a.f49512g.notifyDataSetChanged();
            this.f49538a.z();
        }
    }

    /* loaded from: classes9.dex */
    public class q implements CustomMessageTask.CustomRunnable<o.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49539e;

        public q(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49539e = scrollFragmentTabHost;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<o.b> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f49539e.f49511f != null && !this.f49539e.f49511f.getPageActivity().isFinishing() && this.f49539e.H != null && this.f49539e.I != null) {
                    ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? this.f49539e.f49512g.getTaskView() : this.f49539e.I.getTaskView();
                    if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof o.b)) {
                        o.b data = customMessage.getData();
                        int intValue = data.f11809c.intValue() > 0 ? data.f11809c.intValue() * 1000 : 5000;
                        String str = data.f11813g;
                        if (TextUtils.isEmpty(str)) {
                            str = this.f49539e.f49511f.getString(R.string.task_float_tip_toast);
                        }
                        String fixedText = UtilHelper.getFixedText(str, 20);
                        if (this.f49539e.J != null) {
                            this.f49539e.J.I();
                        }
                        ScrollFragmentTabHost scrollFragmentTabHost = this.f49539e;
                        scrollFragmentTabHost.J = new b.a.r0.f0.g(scrollFragmentTabHost.f49511f, taskView);
                        this.f49539e.J.O(48);
                        this.f49539e.J.h0(true);
                        this.f49539e.J.L(4);
                        this.f49539e.J.N(intValue);
                        this.f49539e.J.U(true);
                        this.f49539e.J.j0(0);
                        this.f49539e.J.l0(fixedText);
                        return new CustomResponsedMessage<>(2921409, Boolean.TRUE);
                    }
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class r implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f49540e;

        public r(ScrollFragmentTabHost scrollFragmentTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49540e = scrollFragmentTabHost;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || this.f49540e.H == null) {
                    return null;
                }
                this.f49540e.dismissShadow();
                boolean z = false;
                if (customMessage.getData().booleanValue()) {
                    z = this.f49540e.H.showHeader();
                } else if (this.f49540e.H.isSticky() && this.f49540e.v) {
                    z = true;
                    this.f49540e.H.showHeader();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, Boolean.TRUE));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes9.dex */
    public interface t {
        void a(int i2);
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
        this.w = false;
        this.y = new j(this, 2921563);
        this.z = new k(this, 2921400);
        this.A = new l(this, 2921415);
        this.B = new m(this, 2921501);
        this.C = new n(this, 2001371);
        this.D = new o(this, 2921502);
        this.E = new p(this, 2921509);
        this.F = new CustomMessageTask(2921409, new q(this));
        this.G = new CustomMessageTask(2921405, new r(this));
        this.M = new b.a.r0.h1.d.f.b();
        this.N = new h(this);
        this.O = new i(this);
        x();
    }

    public void addShadowChangeListener(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sVar) == null) {
            if (this.u == null) {
                this.u = new ArrayList();
            }
            this.u.add(sVar);
        }
    }

    public void clearShadowChangeListener() {
        List<s> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.u) == null) {
            return;
        }
        list.clear();
    }

    public void dismissConcernTabTips() {
        b.a.r0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.t) == null) {
            return;
        }
        gVar.I();
    }

    public void dismissShadow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.o && y()) {
            if (this.q == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.q = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.q.setDuration(300L);
                this.q.setAnimationListener(new g(this));
            }
            this.m.startAnimation(this.q);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY);
            super.dispatchDraw(canvas);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY);
        }
    }

    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.r.forceRefresh();
        }
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CustomViewPager customViewPager = this.k;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                return newScrollFragmentAdapter.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r.getItemType(this.k.getCurrentItem()) : invokeV.intValue;
    }

    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (FrameLayout) invokeV.objValue;
    }

    public int getTabType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.r.getItemType(i2) : invokeI.intValue;
    }

    public int getVideoRecommendIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.k.getAdapter() != null) {
                int count = this.k.getAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (this.r.getItemType(i2) == 8) {
                        return i2;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean hasContentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            return newScrollFragmentAdapter != null && newScrollFragmentAdapter.getCount() > 0;
        }
        return invokeV.booleanValue;
    }

    public void initTab(TbPageContext tbPageContext, NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, tbPageContext, bVar) == null) {
            this.f49511f = tbPageContext;
            this.f49514i.addNetworkChangeListener(bVar);
            MessageManager.getInstance().registerListener(this.z);
            MessageManager.getInstance().registerListener(this.A);
            MessageManager.getInstance().registerListener(this.D);
            MessageManager.getInstance().registerListener(this.B);
            MessageManager.getInstance().registerListener(this.C);
            MessageManager.getInstance().registerListener(this.E);
            MessageManager.getInstance().registerListener(this.y);
            this.F.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.F);
        }
    }

    @RequiresApi(api = 3)
    public void initViewPager(FragmentManager fragmentManager, b.a.r0.h1.d.b bVar, ConcernPageView.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, fragmentManager, bVar, lVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.f49510e, fragmentManager, bVar, lVar);
                this.r = newScrollFragmentAdapter;
                newScrollFragmentAdapter.setScrollFragmentTabHost(this);
                this.k.setOffscreenPageLimit(1);
                this.k.setAdapter(this.r);
                int defaultPageType = this.r.getDefaultPageType();
                NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.r;
                if (HomePageStatic.f49368a) {
                    defaultPageType = 0;
                }
                this.k.setCurrentItem(newScrollFragmentAdapter2.getItemPosition(defaultPageType));
                this.f49512g.setViewPager(this.k);
                this.f49512g.setConcernTabIndex(this.r.getItemPosition(0));
                this.x = new GestureDetector(this.f49510e, new f(this));
                if (FullBrowseHelper.checkIsFullBrowseMode()) {
                    this.k.setScrollable(false, this.x);
                } else {
                    this.k.setScrollable(true);
                }
            } finally {
                TTIStats.record("ScrollFragmentTabHost.initViewPager", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public boolean isShowConcernRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f49512g == null || !this.r.isConcernFragmentCreate()) {
                return false;
            }
            return this.f49512g.isShowConcernRedTip();
        }
        return invokeV.booleanValue;
    }

    public int judgeCurrentPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                int itemType = newScrollFragmentAdapter.getItemType(this.k.getCurrentItem());
                if (itemType == 6) {
                    return 2;
                }
                if (itemType == 5) {
                    return 1;
                }
                if (itemType == 1) {
                    return 0;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void logMissionEntranceStatistic() {
        StickyAppBarLayout stickyAppBarLayout;
        HomeTabBarView homeTabBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (stickyAppBarLayout = this.H) == null || stickyAppBarLayout.isSticky() || (homeTabBarView = this.f49512g) == null || homeTabBarView.getTaskView() == null || this.f49512g.getTaskView().getVisibility() == 0) {
            return;
        }
        this.f49512g.logShowStatics();
    }

    public void notifyDataSetChanged() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (newScrollFragmentAdapter = this.r) == null || HomePageStatic.f49368a) {
            return;
        }
        this.k.setAdapter(newScrollFragmentAdapter);
        this.f49512g.notifyDataSetChanged();
        this.M.a(this.N);
    }

    public void notifyListViewBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onAttachedToWindow();
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
                this.G.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.G);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        PluginErrorTipView pluginErrorTipView;
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            b.a.q0.s.u.c.d(this.H).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
            this.I.onChangeSkinType();
            this.f49512g.onChangeSkinType();
            TbPageContext tbPageContext = this.f49511f;
            if (tbPageContext != null && (noNetworkView = this.f49514i) != null) {
                noNetworkView.onChangeSkinType(tbPageContext, i2);
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.onChangeSkin(i2);
            }
            TbPageContext tbPageContext2 = this.f49511f;
            if (tbPageContext2 != null && (pluginErrorTipView = this.f49513h) != null) {
                pluginErrorTipView.onChangeSkinType(tbPageContext2, i2);
            }
            b.a.r0.h1.c.b bVar = this.K;
            if (bVar != null) {
                bVar.k(i2);
            }
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0203);
            SkinManager.setBackgroundResource(this.m, R.drawable.personalize_tab_shadow);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            b.a.r0.f0.g gVar = this.J;
            if (gVar != null) {
                gVar.I();
                this.J = null;
            }
            dismissConcernTabTips();
            MessageManager.getInstance().unRegisterListener(this.C);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDetachedFromWindow();
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
                MessageManager.getInstance().unRegisterTask(2921405);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5008);
            super.onLayout(z, i2, i3, i4, i5);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5000);
            super.onMeasure(i2, i3);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5007);
        }
    }

    public void onResume() {
        HomeTabBarView homeTabBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (homeTabBarView = this.f49512g) == null) {
            return;
        }
        homeTabBarView.onResume();
    }

    public void onSwitchToHomeTAB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.r.getLastBrowseTabByCache(this.O);
        }
    }

    public void reloadCurrentTab() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.reloadCurrentTab();
    }

    public void removeShadowChangeListener(s sVar) {
        List<s> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, sVar) == null) || (list = this.u) == null || list.size() <= 0) {
            return;
        }
        this.u.remove(sVar);
    }

    public void setCurrentTab(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || i2 < 0 || i2 >= this.r.getCount()) {
            return;
        }
        this.f49512g.setTabItemClicked(z);
        this.r.setTargetItemIndex(i2);
        this.k.setCurrentItem(i2);
    }

    public void setFakeClickCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            setCurrentTab(this.r.getItemPosition(i2), true);
        }
    }

    public void setOnTabSelectedListener(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, tVar) == null) {
            this.s = tVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bdUniqueId) == null) {
            this.f49512g.setPageUniqueId(bdUniqueId);
            this.z.setTag(bdUniqueId);
            this.A.setTag(bdUniqueId);
            this.D.setTag(bdUniqueId);
            this.B.setTag(bdUniqueId);
            this.E.setTag(bdUniqueId);
            this.y.setTag(bdUniqueId);
        }
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.v = z;
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.setPrimary(z);
            }
            NoNetworkView noNetworkView = this.f49514i;
            if (noNetworkView == null || !z) {
                return;
            }
            noNetworkView.setVisibility(b.a.e.e.p.j.A() ? 8 : 0);
        }
    }

    public void setScrollShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.o = z;
            if (z) {
                View view = this.l;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            View view2 = this.l;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && this.f49512g != null && this.r.isConcernFragmentCreate()) {
            this.f49512g.setShowConcernRedTip(z);
        }
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, str) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.setVideoThreadId(str);
    }

    public void showConcernTabForumTips() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && TbadkCoreApplication.isLogin()) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int itemPosition = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.getItemPosition(0) : 0;
            if (this.t == null) {
                b.a.r0.f0.g gVar = new b.a.r0.f0.g(this.f49511f, this.f49512g.getTabView(itemPosition));
                this.t = gVar;
                gVar.g0(R.drawable.bg_tip_blue_up_left);
                this.t.O(16);
                this.t.U(true);
                this.t.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.t.h0(true);
                this.t.N(4000);
            }
            this.t.m0(this.f49510e.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void showConcernTabTips() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (b.a.q0.s.e0.b.j().k("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int itemPosition = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.getItemPosition(0) : 0;
            if (this.t == null) {
                b.a.r0.f0.g gVar = new b.a.r0.f0.g(this.f49511f, this.f49512g.getTabView(itemPosition));
                this.t = gVar;
                gVar.g0(R.drawable.bg_tip_blue_up);
                this.t.O(32);
                this.t.U(true);
                this.t.h0(true);
                this.t.k0(b.a.e.e.p.l.g(this.f49510e, R.dimen.ds16));
                this.t.N(4000);
            }
            this.t.n0(this.f49510e.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void showShadow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.o && !y()) {
            this.m.setVisibility(0);
            if (this.p == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.p = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.p.setDuration(300L);
            }
            this.m.startAnimation(this.p);
        }
    }

    public void startFirstLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (this.r != null) {
                    this.r.startFirstLoad();
                }
            } finally {
                TTIStats.record("ScrollFragmentTabHost.startFirstLoad", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void updateConcernData(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048620, this, dataRes, z) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.updateConcernData(dataRes, z);
    }

    public void updateError(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048621, this, str, i2, i3) == null) || this.k == null) {
            return;
        }
        this.r.updateError(str, i2, i3);
    }

    public void updatePersonalizeData(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.updatePersonalizeData(dataRes, z, z2);
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", w(i2));
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final int w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i2)) == null) {
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

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4006);
            this.f49510e = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
            this.H = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
            this.I = (NestedScrollHeader) findViewById(R.id.home_nested_header);
            this.f49512g = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
            this.f49513h = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
            this.f49514i = (NoNetworkView) findViewById(R.id.view_no_network);
            this.j = (FrameLayout) findViewById(R.id.home_pager_container);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
            this.k = customViewPager;
            customViewPager.setForm(1);
            this.l = findViewById(R.id.divider_line);
            this.m = findViewById(R.id.divider_shadow);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
            this.n = tBSpecificationBtn;
            tBSpecificationBtn.setVisibility(8);
            this.K = new b.a.r0.h1.c.b(this.f49510e);
            this.L = b.a.q0.b.d.i();
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.H.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) this.j.getLayoutParams())).topMargin = 0;
            this.f49512g.setOnPageChangeListener(new a(this));
            this.f49512g.setOnTabItemClickListener(new b(this));
            this.H.setOnHeaderStickyListener(new c(this));
            this.I.setEntranceJumpListener(new d(this));
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
                this.I.setVisibility(8);
                this.f49512g.setMissionEntranceVisibility(true);
                this.f49512g.setEntranceJumpListener(new e(this));
            } else {
                this.I.setVisibility(0);
                this.f49512g.setMissionEntranceVisibility(false);
            }
            z();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4007);
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.m.getVisibility() == 0 : invokeV.booleanValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            boolean d2 = b.a.q0.g1.b.c.d();
            this.I.setGameLayoutVisible(!d2);
            this.I.setTaskViewVisible(!d2);
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            setCurrentTab(this.r.getItemPosition(i2), false);
        }
    }

    public void setCurrentTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            setCurrentTab(this.r.getPositionByTabName(str), false);
        }
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
        this.w = false;
        this.y = new j(this, 2921563);
        this.z = new k(this, 2921400);
        this.A = new l(this, 2921415);
        this.B = new m(this, 2921501);
        this.C = new n(this, 2001371);
        this.D = new o(this, 2921502);
        this.E = new p(this, 2921509);
        this.F = new CustomMessageTask(2921409, new q(this));
        this.G = new CustomMessageTask(2921405, new r(this));
        this.M = new b.a.r0.h1.d.f.b();
        this.N = new h(this);
        this.O = new i(this);
        x();
    }
}
