package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import d.a.r0.a.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes5.dex */
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
    public d.a.s0.e0.e J;
    public d.a.s0.e1.c.b K;
    public boolean L;
    public d.a.s0.e1.d.f.b M;
    public d.a.s0.e1.d.e N;
    public d.a.s0.e1.d.d O;

    /* renamed from: e  reason: collision with root package name */
    public Context f16555e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f16556f;

    /* renamed from: g  reason: collision with root package name */
    public HomeTabBarView f16557g;

    /* renamed from: h  reason: collision with root package name */
    public PluginErrorTipView f16558h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f16559i;
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
    public d.a.s0.e0.e t;
    public List<s> u;
    public boolean v;
    public boolean w;
    public GestureDetector x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16560e;

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
            this.f16560e = scrollFragmentTabHost;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 0 && this.f16560e.getCurrentTabType() == 0) {
                boolean H = this.f16560e.H();
                TiebaStatic.log(new StatisticItem("c12350").param("obj_type", H ? 1 : 0));
                if (H && this.f16560e.r != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                    this.f16560e.r.L();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                this.f16560e.r.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f16560e.s != null) {
                    this.f16560e.s.a(i2);
                }
                d.a.r0.r.n.b.i().n(this.f16560e.r.p(i2) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) {
                    if (this.f16560e.B(i2) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int p = this.f16560e.r.p(this.f16560e.k.getCurrentItem());
                if (p == 5) {
                    if (this.f16560e.w) {
                        this.f16560e.w = false;
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c13740");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_type", this.f16560e.J() ? 1 : 0);
                        statisticItem.eventStat();
                    }
                }
                if (p == 0) {
                    this.f16560e.x();
                }
                View c2 = this.f16560e.f16557g.c(0);
                if ((c2 instanceof LinearLayout) && TbadkCoreApplication.isLogin() && d.a.r0.b.d.h()) {
                    LinearLayout linearLayout = (LinearLayout) c2;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (p == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (this.f16560e.u != null && this.f16560e.r != null) {
                    int p2 = this.f16560e.r.p(this.f16560e.k.getCurrentItem());
                    if (p2 == 5) {
                        this.f16560e.setScrollShadow(false);
                        for (s sVar : this.f16560e.u) {
                            sVar.c();
                        }
                    } else if (p2 == 1) {
                        this.f16560e.setScrollShadow(false);
                        for (s sVar2 : this.f16560e.u) {
                            sVar2.b();
                        }
                    } else if (p2 == 0) {
                        this.f16560e.setScrollShadow(false);
                        for (s sVar3 : this.f16560e.u) {
                            sVar3.a();
                        }
                    } else if (p2 == 6) {
                        this.f16560e.setScrollShadow(true);
                    } else if (p2 == 7) {
                        this.f16560e.setScrollShadow(true);
                    } else if (p2 == 8) {
                        this.f16560e.setScrollShadow(false);
                    } else {
                        this.f16560e.y();
                        this.f16560e.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(this.f16560e.B(i2));
                if (this.f16560e.B(i2) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            d.a.r0.r.d0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        d.a.r0.r.d0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (this.f16560e.f16557g.f()) {
                        this.f16560e.f16557g.setShowHotTopicRedTip(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PagerSlidingTabStrip.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16561a;

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
            this.f16561a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.c
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                if (this.f16561a.B(i2) == 1 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f16561a.f16556f, null)) {
                    this.f16561a.v(i2);
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if ((i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) && this.f16561a.k.getCurrentItem() != i2) {
                        if (this.f16561a.B(i2) != 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                        }
                    }
                    if (this.f16561a.B(i2) == 7) {
                        TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "1"));
                    } else if (this.f16561a.B(i2) == 8) {
                        TiebaStatic.log(new StatisticItem("c13580"));
                    }
                    TbadkCoreApplication.getInst().setHomeBarShowType(this.f16561a.B(i2));
                    if (this.f16561a.B(i2) == 5) {
                        StatisticItem statisticItem = new StatisticItem("c13740");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_type", this.f16561a.J() ? 1 : 0);
                        statisticItem.eventStat();
                        this.f16561a.w = true;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (TbadkCoreApplication.isLogin()) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                d.a.r0.r.d0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                            }
                        } else {
                            d.a.r0.r.d0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                        }
                        if (this.f16561a.f16557g.f()) {
                            this.f16561a.f16557g.setShowHotTopicRedTip(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements StickyAppBarLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16562a;

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
            this.f16562a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f16562a.J != null) {
                this.f16562a.J.I();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements NestedScrollHeader.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16563a;

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
            this.f16563a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f16563a.J != null) {
                    this.f16563a.J.I();
                    this.f16563a.J = null;
                }
                if (this.f16563a.f16556f != null) {
                    UrlManager.getInstance().dealOneLink(this.f16563a.f16556f, new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements NestedScrollHeader.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16564a;

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
            this.f16564a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f16564a.J != null) {
                    this.f16564a.J.I();
                    this.f16564a.J = null;
                }
                if (this.f16564a.f16556f != null) {
                    UrlManager.getInstance().dealOneLink(this.f16564a.f16556f, new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16565e;

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
            this.f16565e = scrollFragmentTabHost;
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
                    FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f16565e.f16556f, null);
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

    /* loaded from: classes5.dex */
    public class g implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16566a;

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
            this.f16566a = scrollFragmentTabHost;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f16566a.m.setVisibility(8);
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

    /* loaded from: classes5.dex */
    public class h implements d.a.s0.e1.d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16567a;

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
            this.f16567a = scrollFragmentTabHost;
        }

        @Override // d.a.s0.e1.d.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16567a.setCurrentTab(this.f16567a.r.o(i2), false);
                this.f16567a.r.z(i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements d.a.s0.e1.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16568a;

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
            this.f16568a = scrollFragmentTabHost;
        }

        @Override // d.a.s0.e1.d.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16568a.M.b(i2, this.f16568a.N);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16569a;

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
            this.f16569a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f16569a.k == null) {
                return;
            }
            if (FullBrowseHelper.checkIsFullBrowseMode()) {
                this.f16569a.k.setScrollable(false, this.f16569a.x);
            } else {
                this.f16569a.k.setScrollable(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16570a;

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
            this.f16570a = scrollFragmentTabHost;
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
                    this.f16570a.V();
                } else {
                    this.f16570a.y();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16571a;

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
            this.f16571a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f16571a.J == null) {
                return;
            }
            this.f16571a.J.I();
            this.f16571a.J = null;
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16572a;

        /* loaded from: classes5.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f16573e;

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
                this.f16573e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f16573e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f16574e;

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
                this.f16574e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f16574e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
            this.f16572a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) this.f16572a.f16557g.c(0);
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
                if (this.f16572a.f16557g != null) {
                    this.f16572a.K.l(this.f16572a.f16557g.getBackgroundAlpha());
                    this.f16572a.K.k(TbadkCoreApplication.getInst().getSkinType());
                }
                this.f16572a.K.n(this.f16572a.H);
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

    /* loaded from: classes5.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16575a;

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
            this.f16575a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.f16575a.L == d.a.r0.b.d.h()) {
                return;
            }
            this.f16575a.f16557g.j();
            if (d.a.r0.b.d.h() && this.f16575a.v) {
                this.f16575a.x();
                this.f16575a.T();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16576a;

        /* loaded from: classes5.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16577e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f16578f;

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
                this.f16577e = textView;
                this.f16578f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f16577e.setMaxWidth(this.f16578f + ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16579e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f16580f;

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
                this.f16579e = textView;
                this.f16580f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f16579e.setMaxWidth(this.f16580f - ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16581e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f16582f;

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
                this.f16581e = textView;
                this.f16582f = str;
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
                    this.f16581e.setText(this.f16582f);
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
            this.f16576a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            String string = this.f16576a.getResources().getString(R.string.attention_person);
            String string2 = this.f16576a.getResources().getString(R.string.attention);
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) this.f16576a.f16557g.c(0);
            if (intValue == 1) {
                if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    if (string2.equals(textView.getText())) {
                        int measuredWidth = textView.getMeasuredWidth();
                        textView.setText(string);
                        int measureText = (int) textView.getPaint().measureText(this.f16576a.getResources().getString(R.string.attention_person));
                        int measureText2 = (int) textView.getPaint().measureText(this.f16576a.getResources().getString(R.string.attention));
                        if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                            ofInt.setDuration(360L);
                            ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                            ofInt.start();
                        }
                    }
                    d.a.r0.r.d0.b.j().v("key_home_concern_all_status", 1);
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
                d.a.r0.r.d0.b.j().v("key_home_concern_all_status", 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16583a;

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
            this.f16583a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f16583a.r == null || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f16583a.f16557g == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f16583a.r.Q();
            this.f16583a.r.O();
            this.f16583a.k.setAdapter(this.f16583a.r);
            this.f16583a.f16557g.setHotTopicTabIndex(this.f16583a.r.n());
            this.f16583a.f16557g.j();
            this.f16583a.Z();
        }
    }

    /* loaded from: classes5.dex */
    public class q implements CustomMessageTask.CustomRunnable<p.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16584e;

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
            this.f16584e = scrollFragmentTabHost;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<p.b> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f16584e.f16556f != null && !this.f16584e.f16556f.getPageActivity().isFinishing() && this.f16584e.H != null && this.f16584e.I != null) {
                    ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? this.f16584e.f16557g.getTaskView() : this.f16584e.I.getTaskView();
                    if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof p.b)) {
                        p.b data = customMessage.getData();
                        int intValue = data.f54669c.intValue() > 0 ? data.f54669c.intValue() * 1000 : 5000;
                        String str = data.f54673g;
                        if (TextUtils.isEmpty(str)) {
                            str = this.f16584e.f16556f.getString(R.string.task_float_tip_toast);
                        }
                        String fixedText = UtilHelper.getFixedText(str, 20);
                        if (this.f16584e.J != null) {
                            this.f16584e.J.I();
                        }
                        ScrollFragmentTabHost scrollFragmentTabHost = this.f16584e;
                        scrollFragmentTabHost.J = new d.a.s0.e0.e(scrollFragmentTabHost.f16556f, taskView);
                        this.f16584e.J.O(48);
                        this.f16584e.J.h0(true);
                        this.f16584e.J.L(4);
                        this.f16584e.J.N(intValue);
                        this.f16584e.J.U(true);
                        this.f16584e.J.j0(0);
                        this.f16584e.J.l0(fixedText);
                        return new CustomResponsedMessage<>(2921409, Boolean.TRUE);
                    }
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class r implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16585e;

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
            this.f16585e = scrollFragmentTabHost;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || this.f16585e.H == null) {
                    return null;
                }
                this.f16585e.y();
                boolean z = false;
                if (customMessage.getData().booleanValue()) {
                    z = this.f16585e.H.f();
                } else if (this.f16585e.H.d() && this.f16585e.v) {
                    z = true;
                    this.f16585e.H.f();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, Boolean.TRUE));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        this.M = new d.a.s0.e1.d.f.b();
        this.N = new h(this);
        this.O = new i(this);
        D();
    }

    public final int A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
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

    public int B(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.r.p(i2) : invokeI.intValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            return newScrollFragmentAdapter != null && newScrollFragmentAdapter.getCount() > 0;
        }
        return invokeV.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16555e = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
            this.H = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
            this.I = (NestedScrollHeader) findViewById(R.id.home_nested_header);
            this.f16557g = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
            this.f16558h = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
            this.f16559i = (NoNetworkView) findViewById(R.id.view_no_network);
            this.j = (FrameLayout) findViewById(R.id.home_pager_container);
            this.k = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
            this.l = findViewById(R.id.divider_line);
            this.m = findViewById(R.id.divider_shadow);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
            this.n = tBSpecificationBtn;
            tBSpecificationBtn.setVisibility(8);
            this.K = new d.a.s0.e1.c.b(this.f16555e);
            this.L = d.a.r0.b.d.h();
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.H.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) this.j.getLayoutParams())).topMargin = 0;
            this.f16557g.setOnPageChangeListener(new a(this));
            this.f16557g.setOnTabItemClickListener(new b(this));
            this.H.setOnHeaderStickyListener(new c(this));
            this.I.setEntranceJumpListener(new d(this));
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
                this.I.setVisibility(8);
                this.f16557g.setMissionEntranceVisibility(true);
                this.f16557g.setEntranceJumpListener(new e(this));
            } else {
                this.I.setVisibility(0);
                this.f16557g.setMissionEntranceVisibility(false);
            }
            Z();
        }
    }

    public void E(TbPageContext tbPageContext, NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, bVar) == null) {
            this.f16556f = tbPageContext;
            this.f16559i.a(bVar);
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
    public void F(FragmentManager fragmentManager, d.a.s0.e1.d.b bVar, ConcernPageView.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, fragmentManager, bVar, lVar) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.f16555e, fragmentManager, bVar, lVar);
            this.r = newScrollFragmentAdapter;
            newScrollFragmentAdapter.H(this);
            this.k.setOffscreenPageLimit(2);
            this.k.setAdapter(this.r);
            int m2 = this.r.m();
            NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.r;
            if (HomePageStatic.f16400a) {
                m2 = 0;
            }
            this.k.setCurrentItem(newScrollFragmentAdapter2.o(m2));
            this.f16557g.setViewPager(this.k);
            this.f16557g.setConcernTabIndex(this.r.o(0));
            if (this.r.n() != -1) {
                this.f16557g.setHotTopicTabIndex(this.r.n());
                this.f16557g.setShowHotTopicRedTip(I());
            }
            this.x = new GestureDetector(this.f16555e, new f(this));
            if (FullBrowseHelper.checkIsFullBrowseMode()) {
                this.k.setScrollable(false, this.x);
            } else {
                this.k.setScrollable(true);
            }
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f16557g == null || !this.r.u()) {
                return false;
            }
            return this.f16557g.e();
        }
        return invokeV.booleanValue;
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbadkCoreApplication.isLogin()) {
                return !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && currentTimeMillis - d.a.r0.r.d0.b.j().l(TbadkCoreApplication.getCurrentAccount(), 0L) >= 86400000;
            }
            return currentTimeMillis - d.a.r0.r.d0.b.j().l("unlogin_hot_top_timestamp", 0L) >= 86400000;
        }
        return invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f16557g == null || (newScrollFragmentAdapter = this.r) == null || !newScrollFragmentAdapter.v()) {
                return false;
            }
            return this.f16557g.f();
        }
        return invokeV.booleanValue;
    }

    public void K() {
        StickyAppBarLayout stickyAppBarLayout;
        HomeTabBarView homeTabBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (stickyAppBarLayout = this.H) == null || stickyAppBarLayout.d() || (homeTabBarView = this.f16557g) == null || homeTabBarView.getTaskView() == null || this.f16557g.getTaskView().getVisibility() == 0) {
            return;
        }
        this.f16557g.i();
    }

    public void L() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (newScrollFragmentAdapter = this.r) == null || HomePageStatic.f16400a) {
            return;
        }
        this.k.setAdapter(newScrollFragmentAdapter);
        this.f16557g.j();
        this.M.a(this.N);
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    public void N(int i2) {
        PluginErrorTipView pluginErrorTipView;
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            d.a.r0.r.u.c.d(this.H).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
            this.I.p();
            this.f16557g.k();
            TbPageContext tbPageContext = this.f16556f;
            if (tbPageContext != null && (noNetworkView = this.f16559i) != null) {
                noNetworkView.c(tbPageContext, i2);
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.A(i2);
            }
            TbPageContext tbPageContext2 = this.f16556f;
            if (tbPageContext2 != null && (pluginErrorTipView = this.f16558h) != null) {
                pluginErrorTipView.e(tbPageContext2, i2);
            }
            d.a.s0.e1.c.b bVar = this.K;
            if (bVar != null) {
                bVar.k(i2);
            }
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0203);
            SkinManager.setBackgroundResource(this.m, R.drawable.personalize_tab_shadow);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            d.a.s0.e0.e eVar = this.J;
            if (eVar != null) {
                eVar.I();
                this.J = null;
            }
            x();
            MessageManager.getInstance().unRegisterListener(this.C);
        }
    }

    public void P() {
        HomeTabBarView homeTabBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (homeTabBarView = this.f16557g) == null) {
            return;
        }
        homeTabBarView.l();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.r.q(this.O);
        }
    }

    public void R() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.B();
    }

    public void S(s sVar) {
        List<s> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, sVar) == null) || (list = this.u) == null || list.size() <= 0) {
            return;
        }
        this.u.remove(sVar);
    }

    public void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && TbadkCoreApplication.isLogin()) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int o2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.o(0) : 0;
            if (this.t == null) {
                d.a.s0.e0.e eVar = new d.a.s0.e0.e(this.f16556f, this.f16557g.c(o2));
                this.t = eVar;
                eVar.g0(R.drawable.bg_tip_blue_up_left);
                this.t.O(16);
                this.t.U(true);
                this.t.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.t.h0(true);
                this.t.N(4000);
            }
            this.t.m0(this.f16555e.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (d.a.r0.r.d0.b.j().k("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int o2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.o(0) : 0;
            if (this.t == null) {
                d.a.s0.e0.e eVar = new d.a.s0.e0.e(this.f16556f, this.f16557g.c(o2));
                this.t = eVar;
                eVar.g0(R.drawable.bg_tip_blue_up);
                this.t.O(32);
                this.t.U(true);
                this.t.h0(true);
                this.t.k0(d.a.c.e.p.l.g(this.f16555e, R.dimen.ds16));
                this.t.N(4000);
            }
            this.t.n0(this.f16555e.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.o && !G()) {
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

    public void W() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.K();
    }

    public void X(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, dataRes, z) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.M(dataRes, z);
    }

    public void Y(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048600, this, str, i2, i3) == null) || this.k == null) {
            return;
        }
        this.r.N(str, i2, i3);
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            boolean d2 = d.a.r0.c1.b.e.d();
            this.I.setGameLayoutVisible(!d2);
            this.I.setTaskViewVisible(!d2);
        }
    }

    public void a0(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.P(dataRes, z, z2);
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                return newScrollFragmentAdapter.l();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r.p(this.k.getCurrentItem()) : invokeV.intValue;
    }

    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.j : (FrameLayout) invokeV.objValue;
    }

    public int getVideoRecommendIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.k.getAdapter() != null) {
                int count = this.k.getAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (this.r.p(i2) == 8) {
                        return i2;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onAttachedToWindow();
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
                this.G.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(this.G);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onDetachedFromWindow();
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
                MessageManager.getInstance().unRegisterTask(2921405);
            }
        }
    }

    public void setCurrentTab(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || i2 < 0 || i2 >= this.r.getCount()) {
            return;
        }
        this.f16557g.setTabItemClicked(z);
        this.r.I(i2);
        this.k.setCurrentItem(i2);
    }

    public void setFakeClickCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            setCurrentTab(this.r.o(i2), true);
        }
    }

    public void setOnTabSelectedListener(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, tVar) == null) {
            this.s = tVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bdUniqueId) == null) {
            this.f16557g.setPageUniqueId(bdUniqueId);
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
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.v = z;
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.G(z);
            }
            NoNetworkView noNetworkView = this.f16559i;
            if (noNetworkView == null || !z) {
                return;
            }
            noNetworkView.setVisibility(d.a.c.e.p.j.A() ? 8 : 0);
        }
    }

    public void setScrollShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
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
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && this.f16557g != null && this.r.u()) {
            this.f16557g.setShowConcernRedTip(z);
        }
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.J(str);
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", A(i2));
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public void w(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, sVar) == null) {
            if (this.u == null) {
                this.u = new ArrayList();
            }
            this.u.add(sVar);
        }
    }

    public void x() {
        d.a.s0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (eVar = this.t) == null) {
            return;
        }
        eVar.I();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && this.o && G()) {
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

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.r.k();
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            setCurrentTab(this.r.o(i2), false);
        }
    }

    public void setCurrentTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            setCurrentTab(this.r.r(str), false);
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
        this.M = new d.a.s0.e1.d.f.b();
        this.N = new h(this);
        this.O = new i(this);
        D();
    }
}
