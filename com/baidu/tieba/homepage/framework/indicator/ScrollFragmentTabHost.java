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
import d.a.p0.a.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
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
    public d.a.q0.e0.e J;
    public d.a.q0.e1.c.b K;
    public boolean L;
    public d.a.q0.e1.d.f.b M;
    public d.a.q0.e1.d.e N;
    public d.a.q0.e1.d.d O;

    /* renamed from: e  reason: collision with root package name */
    public Context f16650e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f16651f;

    /* renamed from: g  reason: collision with root package name */
    public HomeTabBarView f16652g;

    /* renamed from: h  reason: collision with root package name */
    public PluginErrorTipView f16653h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f16654i;
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
    public d.a.q0.e0.e t;
    public List<s> u;
    public boolean v;
    public boolean w;
    public GestureDetector x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16655e;

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
            this.f16655e = scrollFragmentTabHost;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 0 && this.f16655e.getCurrentTabType() == 0) {
                boolean H = this.f16655e.H();
                TiebaStatic.log(new StatisticItem("c12350").param("obj_type", H ? 1 : 0));
                if (H && this.f16655e.r != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                    this.f16655e.r.H();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                this.f16655e.r.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f16655e.s != null) {
                    this.f16655e.s.a(i2);
                }
                d.a.p0.s.n.b.i().n(this.f16655e.r.l(i2) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) {
                    if (this.f16655e.B(i2) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int l = this.f16655e.r.l(this.f16655e.k.getCurrentItem());
                if (l == 5) {
                    if (this.f16655e.w) {
                        this.f16655e.w = false;
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c13740");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_type", this.f16655e.J() ? 1 : 0);
                        statisticItem.eventStat();
                    }
                }
                if (l == 0) {
                    this.f16655e.x();
                }
                View c2 = this.f16655e.f16652g.c(0);
                if ((c2 instanceof LinearLayout) && TbadkCoreApplication.isLogin() && d.a.p0.b.d.i()) {
                    LinearLayout linearLayout = (LinearLayout) c2;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (l == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (this.f16655e.u != null && this.f16655e.r != null) {
                    int l2 = this.f16655e.r.l(this.f16655e.k.getCurrentItem());
                    if (l2 == 5) {
                        this.f16655e.setScrollShadow(false);
                        for (s sVar : this.f16655e.u) {
                            sVar.c();
                        }
                    } else if (l2 == 1) {
                        this.f16655e.setScrollShadow(false);
                        for (s sVar2 : this.f16655e.u) {
                            sVar2.b();
                        }
                    } else if (l2 == 0) {
                        this.f16655e.setScrollShadow(false);
                        for (s sVar3 : this.f16655e.u) {
                            sVar3.a();
                        }
                    } else if (l2 == 6) {
                        this.f16655e.setScrollShadow(true);
                    } else if (l2 == 7) {
                        this.f16655e.setScrollShadow(true);
                    } else if (l2 == 8) {
                        this.f16655e.setScrollShadow(false);
                    } else {
                        this.f16655e.y();
                        this.f16655e.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(this.f16655e.B(i2));
                if (this.f16655e.B(i2) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            d.a.p0.s.d0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        d.a.p0.s.d0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (this.f16655e.f16652g.f()) {
                        this.f16655e.f16652g.setShowHotTopicRedTip(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PagerSlidingTabStrip.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16656a;

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
            this.f16656a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.c
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                if (this.f16656a.B(i2) == 1 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f16656a.f16651f, null)) {
                    this.f16656a.v(i2);
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if ((i2 == 0 || i2 == 1 || (i2 == 2 && homeBarShowType == 1)) && this.f16656a.k.getCurrentItem() != i2) {
                        if (this.f16656a.B(i2) != 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                        }
                    }
                    if (this.f16656a.B(i2) == 7) {
                        TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "1"));
                    } else if (this.f16656a.B(i2) == 8) {
                        TiebaStatic.log(new StatisticItem("c13580"));
                    }
                    TbadkCoreApplication.getInst().setHomeBarShowType(this.f16656a.B(i2));
                    if (this.f16656a.B(i2) == 5) {
                        StatisticItem statisticItem = new StatisticItem("c13740");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_type", this.f16656a.J() ? 1 : 0);
                        statisticItem.eventStat();
                        this.f16656a.w = true;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (TbadkCoreApplication.isLogin()) {
                            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                d.a.p0.s.d0.b.j().w(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                            }
                        } else {
                            d.a.p0.s.d0.b.j().w("unlogin_hot_top_timestamp", currentTimeMillis);
                        }
                        if (this.f16656a.f16652g.f()) {
                            this.f16656a.f16652g.setShowHotTopicRedTip(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements StickyAppBarLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16657a;

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
            this.f16657a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f16657a.J != null) {
                this.f16657a.J.I();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NestedScrollHeader.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16658a;

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
            this.f16658a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f16658a.J != null) {
                    this.f16658a.J.I();
                    this.f16658a.J = null;
                }
                if (this.f16658a.f16651f != null) {
                    UrlManager.getInstance().dealOneLink(this.f16658a.f16651f, new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements NestedScrollHeader.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16659a;

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
            this.f16659a = scrollFragmentTabHost;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f16659a.J != null) {
                    this.f16659a.J.I();
                    this.f16659a.J = null;
                }
                if (this.f16659a.f16651f != null) {
                    UrlManager.getInstance().dealOneLink(this.f16659a.f16651f, new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16660e;

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
            this.f16660e = scrollFragmentTabHost;
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
                    FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f16660e.f16651f, null);
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

    /* loaded from: classes4.dex */
    public class g implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16661a;

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
            this.f16661a = scrollFragmentTabHost;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f16661a.m.setVisibility(8);
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
    public class h implements d.a.q0.e1.d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16662a;

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
            this.f16662a = scrollFragmentTabHost;
        }

        @Override // d.a.q0.e1.d.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16662a.setCurrentTab(this.f16662a.r.k(i2), false);
                this.f16662a.r.v(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements d.a.q0.e1.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16663a;

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
            this.f16663a = scrollFragmentTabHost;
        }

        @Override // d.a.q0.e1.d.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16663a.M.b(i2, this.f16663a.N);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16664a;

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
            this.f16664a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f16664a.k == null) {
                return;
            }
            if (FullBrowseHelper.checkIsFullBrowseMode()) {
                this.f16664a.k.setScrollable(false, this.f16664a.x);
            } else {
                this.f16664a.k.setScrollable(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16665a;

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
            this.f16665a = scrollFragmentTabHost;
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
                    this.f16665a.V();
                } else {
                    this.f16665a.y();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16666a;

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
            this.f16666a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f16666a.J == null) {
                return;
            }
            this.f16666a.J.I();
            this.f16666a.J = null;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16667a;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f16668e;

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
                this.f16668e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f16668e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImageView f16669e;

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
                this.f16669e = imageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f16669e.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
            this.f16667a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) this.f16667a.f16652g.c(0);
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
                if (this.f16667a.f16652g != null) {
                    this.f16667a.K.l(this.f16667a.f16652g.getBackgroundAlpha());
                    this.f16667a.K.k(TbadkCoreApplication.getInst().getSkinType());
                }
                this.f16667a.K.n(this.f16667a.H);
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
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16670a;

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
            this.f16670a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.f16670a.L == d.a.p0.b.d.i()) {
                return;
            }
            this.f16670a.f16652g.i();
            if (d.a.p0.b.d.i() && this.f16670a.v) {
                this.f16670a.x();
                this.f16670a.T();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16671a;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16672e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f16673f;

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
                this.f16672e = textView;
                this.f16673f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f16672e.setMaxWidth(this.f16673f + ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16674e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f16675f;

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
                this.f16674e = textView;
                this.f16675f = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f16674e.setMaxWidth(this.f16675f - ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TextView f16676e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f16677f;

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
                this.f16676e = textView;
                this.f16677f = str;
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
                    this.f16676e.setText(this.f16677f);
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
            this.f16671a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            String string = this.f16671a.getResources().getString(R.string.attention_person);
            String string2 = this.f16671a.getResources().getString(R.string.attention);
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            LinearLayout linearLayout = (LinearLayout) this.f16671a.f16652g.c(0);
            if (intValue == 1) {
                if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    if (string2.equals(textView.getText())) {
                        int measuredWidth = textView.getMeasuredWidth();
                        textView.setText(string);
                        int measureText = (int) textView.getPaint().measureText(this.f16671a.getResources().getString(R.string.attention_person));
                        int measureText2 = (int) textView.getPaint().measureText(this.f16671a.getResources().getString(R.string.attention));
                        if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                            ofInt.setDuration(360L);
                            ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                            ofInt.start();
                        }
                    }
                    d.a.p0.s.d0.b.j().v("key_home_concern_all_status", 1);
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
                d.a.p0.s.d0.b.j().v("key_home_concern_all_status", 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16678a;

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
            this.f16678a = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f16678a.r == null || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f16678a.f16652g == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f16678a.r.M();
            this.f16678a.r.K();
            this.f16678a.k.setAdapter(this.f16678a.r);
            this.f16678a.f16652g.setHotTopicTabIndex(this.f16678a.r.j());
            this.f16678a.f16652g.i();
            this.f16678a.Z();
        }
    }

    /* loaded from: classes4.dex */
    public class q implements CustomMessageTask.CustomRunnable<p.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16679e;

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
            this.f16679e = scrollFragmentTabHost;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<p.b> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f16679e.f16651f != null && !this.f16679e.f16651f.getPageActivity().isFinishing() && this.f16679e.H != null && this.f16679e.I != null) {
                    ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? this.f16679e.f16652g.getTaskView() : this.f16679e.I.getTaskView();
                    if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof p.b)) {
                        p.b data = customMessage.getData();
                        int intValue = data.f51875c.intValue() > 0 ? data.f51875c.intValue() * 1000 : 5000;
                        String str = data.f51879g;
                        if (TextUtils.isEmpty(str)) {
                            str = this.f16679e.f16651f.getString(R.string.task_float_tip_toast);
                        }
                        String fixedText = UtilHelper.getFixedText(str, 20);
                        if (this.f16679e.J != null) {
                            this.f16679e.J.I();
                        }
                        ScrollFragmentTabHost scrollFragmentTabHost = this.f16679e;
                        scrollFragmentTabHost.J = new d.a.q0.e0.e(scrollFragmentTabHost.f16651f, taskView);
                        this.f16679e.J.O(48);
                        this.f16679e.J.h0(true);
                        this.f16679e.J.L(4);
                        this.f16679e.J.N(intValue);
                        this.f16679e.J.U(true);
                        this.f16679e.J.j0(0);
                        this.f16679e.J.l0(fixedText);
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
    public class r implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentTabHost f16680e;

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
            this.f16680e = scrollFragmentTabHost;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || this.f16680e.H == null) {
                    return null;
                }
                this.f16680e.y();
                boolean z = false;
                if (customMessage.getData().booleanValue()) {
                    z = this.f16680e.H.f();
                } else if (this.f16680e.H.d() && this.f16680e.v) {
                    z = true;
                    this.f16680e.H.f();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, Boolean.TRUE));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
        this.M = new d.a.q0.e1.d.f.b();
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.r.l(i2) : invokeI.intValue;
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
            this.f16650e = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
            this.H = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
            this.I = (NestedScrollHeader) findViewById(R.id.home_nested_header);
            this.f16652g = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
            this.f16653h = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
            this.f16654i = (NoNetworkView) findViewById(R.id.view_no_network);
            this.j = (FrameLayout) findViewById(R.id.home_pager_container);
            this.k = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
            this.l = findViewById(R.id.divider_line);
            this.m = findViewById(R.id.divider_shadow);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
            this.n = tBSpecificationBtn;
            tBSpecificationBtn.setVisibility(8);
            this.K = new d.a.q0.e1.c.b(this.f16650e);
            this.L = d.a.p0.b.d.i();
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.H.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            }
            ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) this.j.getLayoutParams())).topMargin = 0;
            this.f16652g.setOnPageChangeListener(new a(this));
            this.f16652g.setOnTabItemClickListener(new b(this));
            this.H.setOnHeaderStickyListener(new c(this));
            this.I.setEntranceJumpListener(new d(this));
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
                this.I.setVisibility(8);
                this.f16652g.setMissionEntranceVisibility(true);
                this.f16652g.setEntranceJumpListener(new e(this));
            } else {
                this.I.setVisibility(0);
                this.f16652g.setMissionEntranceVisibility(false);
            }
            Z();
        }
    }

    public void E(TbPageContext tbPageContext, NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, bVar) == null) {
            this.f16651f = tbPageContext;
            this.f16654i.a(bVar);
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
    public void F(FragmentManager fragmentManager, d.a.q0.e1.d.b bVar, ConcernPageView.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, fragmentManager, bVar, lVar) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.f16650e, fragmentManager, bVar, lVar);
            this.r = newScrollFragmentAdapter;
            newScrollFragmentAdapter.A(this);
            this.k.setOffscreenPageLimit(2);
            this.k.setAdapter(this.r);
            int i2 = this.r.i();
            NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.r;
            if (HomePageStatic.f16495a) {
                i2 = 0;
            }
            this.k.setCurrentItem(newScrollFragmentAdapter2.k(i2));
            this.f16652g.setViewPager(this.k);
            this.f16652g.setConcernTabIndex(this.r.k(0));
            if (this.r.j() != -1) {
                this.f16652g.setHotTopicTabIndex(this.r.j());
                this.f16652g.setShowHotTopicRedTip(I());
            }
            this.x = new GestureDetector(this.f16650e, new f(this));
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
            if (this.f16652g == null || !this.r.q()) {
                return false;
            }
            return this.f16652g.e();
        }
        return invokeV.booleanValue;
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbadkCoreApplication.isLogin()) {
                return !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && currentTimeMillis - d.a.p0.s.d0.b.j().l(TbadkCoreApplication.getCurrentAccount(), 0L) >= 86400000;
            }
            return currentTimeMillis - d.a.p0.s.d0.b.j().l("unlogin_hot_top_timestamp", 0L) >= 86400000;
        }
        return invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f16652g == null || (newScrollFragmentAdapter = this.r) == null || !newScrollFragmentAdapter.r()) {
                return false;
            }
            return this.f16652g.f();
        }
        return invokeV.booleanValue;
    }

    public void K() {
        StickyAppBarLayout stickyAppBarLayout;
        HomeTabBarView homeTabBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (stickyAppBarLayout = this.H) == null || stickyAppBarLayout.d() || (homeTabBarView = this.f16652g) == null || homeTabBarView.getTaskView() == null || this.f16652g.getTaskView().getVisibility() == 0) {
            return;
        }
        this.f16652g.h();
    }

    public void L() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (newScrollFragmentAdapter = this.r) == null || HomePageStatic.f16495a) {
            return;
        }
        this.k.setAdapter(newScrollFragmentAdapter);
        this.f16652g.i();
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
            d.a.p0.s.u.c.d(this.H).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
            this.I.p();
            this.f16652g.j();
            TbPageContext tbPageContext = this.f16651f;
            if (tbPageContext != null && (noNetworkView = this.f16654i) != null) {
                noNetworkView.c(tbPageContext, i2);
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.w(i2);
            }
            TbPageContext tbPageContext2 = this.f16651f;
            if (tbPageContext2 != null && (pluginErrorTipView = this.f16653h) != null) {
                pluginErrorTipView.e(tbPageContext2, i2);
            }
            d.a.q0.e1.c.b bVar = this.K;
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
            d.a.q0.e0.e eVar = this.J;
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
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (homeTabBarView = this.f16652g) == null) {
            return;
        }
        homeTabBarView.k();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.r.m(this.O);
        }
    }

    public void R() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.x();
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
            int k2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.k(0) : 0;
            if (this.t == null) {
                d.a.q0.e0.e eVar = new d.a.q0.e0.e(this.f16651f, this.f16652g.c(k2));
                this.t = eVar;
                eVar.g0(R.drawable.bg_tip_blue_up_left);
                this.t.O(16);
                this.t.U(true);
                this.t.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.t.h0(true);
                this.t.N(4000);
            }
            this.t.m0(this.f16650e.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (d.a.p0.s.d0.b.j().k("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.r;
            int k2 = newScrollFragmentAdapter != null ? newScrollFragmentAdapter.k(0) : 0;
            if (this.t == null) {
                d.a.q0.e0.e eVar = new d.a.q0.e0.e(this.f16651f, this.f16652g.c(k2));
                this.t = eVar;
                eVar.g0(R.drawable.bg_tip_blue_up);
                this.t.O(32);
                this.t.U(true);
                this.t.h0(true);
                this.t.k0(d.a.d.e.p.l.g(this.f16650e, R.dimen.ds16));
                this.t.N(4000);
            }
            this.t.n0(this.f16650e.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
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
        newScrollFragmentAdapter.G();
    }

    public void X(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, dataRes, z) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.I(dataRes, z);
    }

    public void Y(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048600, this, str, i2, i3) == null) || this.k == null) {
            return;
        }
        this.r.J(str, i2, i3);
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            boolean d2 = d.a.p0.e1.b.e.d();
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
        newScrollFragmentAdapter.L(dataRes, z, z2);
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
                return newScrollFragmentAdapter.h();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r.l(this.k.getCurrentItem()) : invokeV.intValue;
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
                    if (this.r.l(i2) == 8) {
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
        this.f16652g.setTabItemClicked(z);
        this.r.B(i2);
        this.k.setCurrentItem(i2);
    }

    public void setFakeClickCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            setCurrentTab(this.r.k(i2), true);
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
            this.f16652g.setPageUniqueId(bdUniqueId);
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
                newScrollFragmentAdapter.z(z);
            }
            NoNetworkView noNetworkView = this.f16654i;
            if (noNetworkView == null || !z) {
                return;
            }
            noNetworkView.setVisibility(d.a.d.e.p.j.A() ? 8 : 0);
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
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && this.f16652g != null && this.r.q()) {
            this.f16652g.setShowConcernRedTip(z);
        }
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || (newScrollFragmentAdapter = this.r) == null) {
            return;
        }
        newScrollFragmentAdapter.F(str);
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
        d.a.q0.e0.e eVar;
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
            this.r.g();
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            setCurrentTab(this.r.k(i2), false);
        }
    }

    public void setCurrentTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            setCurrentTab(this.r.n(str), false);
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
        this.M = new d.a.q0.e1.d.f.b();
        this.N = new h(this);
        this.O = new i(this);
        D();
    }
}
