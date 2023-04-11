package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.NestedNoScrollViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ak6;
import com.baidu.tieba.eo9;
import com.baidu.tieba.er5;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.ii;
import com.baidu.tieba.kb5;
import com.baidu.tieba.p45;
import com.baidu.tieba.rn7;
import com.baidu.tieba.tn7;
import com.baidu.tieba.un7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeWrapperTabHost extends CoordinatorLayout implements un7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbPageContext b;
    public er5 c;
    public PagerSlidingTabStrip d;
    public AppBarLayout e;
    public FrameLayout f;
    public NestedNoScrollViewPager g;
    public View h;
    public FrameLayout i;
    public boolean j;
    public AlphaAnimation k;
    public AlphaAnimation l;
    public NewScrollFragmentAdapter m;
    public ScrollFragmentTabHost.s n;
    public List<ScrollFragmentTabHost.r> o;
    public boolean p;
    public final CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    @Nullable
    public ak6 v;
    public CustomMessageListener w;

    @Override // com.baidu.tieba.un7
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalizeWrapperTabHost personalizeWrapperTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperTabHost, Integer.valueOf(i)};
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
            this.a = personalizeWrapperTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.i != null) {
                if ((customResponsedMessage.getData() instanceof rn7) && ((rn7) customResponsedMessage.getData()).a != null) {
                    View view2 = ((rn7) customResponsedMessage.getData()).a;
                    if (view2.getParent() != null) {
                        if (view2.getParent() != this.a.i) {
                            ((ViewGroup) view2.getParent()).removeView(view2);
                            this.a.i.removeAllViews();
                            this.a.i.addView(view2);
                        }
                    } else {
                        this.a.i.removeAllViews();
                        this.a.i.addView(view2);
                    }
                    this.a.i.setVisibility(0);
                    return;
                }
                this.a.i.removeAllViews();
                this.a.i.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonalizeWrapperTabHost personalizeWrapperTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperTabHost, Integer.valueOf(i)};
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
            this.a = personalizeWrapperTabHost;
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
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalizeWrapperTabHost personalizeWrapperTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperTabHost, Integer.valueOf(i)};
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
            this.a = personalizeWrapperTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.e != null) {
                this.a.e.setExpanded(true, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalizeWrapperTabHost personalizeWrapperTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperTabHost, Integer.valueOf(i)};
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
            this.a = personalizeWrapperTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.v != null) {
                this.a.v.d();
                this.a.v = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonalizeWrapperTabHost personalizeWrapperTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperTabHost, Integer.valueOf(i)};
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
            this.a = personalizeWrapperTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.m != null && customResponsedMessage != null && customResponsedMessage.getData() != null && this.a.d != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.m.Y();
                this.a.m.W();
                this.a.g.setAdapter(this.a.m);
                this.a.d.C();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonalizeWrapperTabHost personalizeWrapperTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperTabHost, Integer.valueOf(i)};
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
            this.a = personalizeWrapperTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            this.a.v(TbadkCoreApplication.getInst().getHomeBarShowTabName());
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperTabHost a;

        public g(PersonalizeWrapperTabHost personalizeWrapperTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizeWrapperTabHost;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.E(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) || this.a.m == null) {
                return;
            }
            this.a.m.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.a.m == null) {
                return;
            }
            if (this.a.n != null) {
                this.a.n.a(i);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            if (this.a.m.x(this.a.g.getCurrentItem()) == 5) {
                if (!this.a.p) {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 0);
                    statisticItem.eventStat();
                } else {
                    this.a.p = false;
                }
            }
            if (this.a.o != null && this.a.m != null) {
                int x = this.a.m.x(this.a.g.getCurrentItem());
                if (x == 5) {
                    this.a.setScrollShadow(false);
                    for (ScrollFragmentTabHost.r rVar : this.a.o) {
                        rVar.c();
                    }
                } else if (x == 1) {
                    this.a.setScrollShadow(false);
                    for (ScrollFragmentTabHost.r rVar2 : this.a.o) {
                        rVar2.b();
                    }
                } else if (x == 0) {
                    this.a.setScrollShadow(false);
                    for (ScrollFragmentTabHost.r rVar3 : this.a.o) {
                        rVar3.a();
                    }
                } else if (x == 6) {
                    this.a.setScrollShadow(true);
                } else if (x == 7) {
                    this.a.setScrollShadow(true);
                } else if (x == 8) {
                    this.a.setScrollShadow(false);
                } else {
                    this.a.c();
                    this.a.setScrollShadow(false);
                }
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(this.a.d(i));
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) this.a.d.getLayoutParams();
            if (this.a.d(i) != 1) {
                layoutParams.setScrollFlags(2);
            } else {
                layoutParams.setScrollFlags(1);
            }
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            personalizeWrapperTabHost.v(personalizeWrapperTabHost.u(i));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperTabHost a;

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

        public h(PersonalizeWrapperTabHost personalizeWrapperTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizeWrapperTabHost;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.h.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalizeWrapperTabHost(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = new a(this, 2921652);
        this.r = new b(this, 2921400);
        this.s = new c(this, 2921792);
        this.t = new d(this, 2921415);
        this.u = new e(this, 2921509);
        this.w = new f(this, 2001371);
        x(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalizeWrapperTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = new a(this, 2921652);
        this.r = new b(this, 2921400);
        this.s = new c(this, 2921792);
        this.t = new d(this, 2921415);
        this.u = new e(this, 2921509);
        this.w = new f(this, 2001371);
        x(context);
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            v(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.m;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.J(i);
            }
            SkinManager.setBackgroundResource(this.h, R.drawable.personalize_tab_shadow);
        }
    }

    public void G(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && (newScrollFragmentAdapter = this.m) != null) {
            newScrollFragmentAdapter.S(z);
        }
    }

    @Override // com.baidu.tieba.un7
    public void b(ScrollFragmentTabHost.r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rVar) == null) {
            if (this.o == null) {
                this.o = new ArrayList();
            }
            this.o.add(rVar);
        }
    }

    @Override // com.baidu.tieba.un7
    public int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return this.m.x(i);
        }
        return invokeI.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, canvas) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY);
            super.dispatchDraw(canvas);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tieba.un7
    public void e(ScrollFragmentTabHost.r rVar) {
        List<ScrollFragmentTabHost.r> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, rVar) == null) && (list = this.o) != null && list.size() > 0) {
            this.o.remove(rVar);
        }
    }

    public void setCurrentTab(int i) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048600, this, i) != null) || (newScrollFragmentAdapter = this.m) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.s(i), false);
    }

    public void setCurrentTabByCode(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, str) != null) || (newScrollFragmentAdapter = this.m) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.z(str), false);
    }

    public void setFakeClickCurrentTab(int i) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048604, this, i) != null) || (newScrollFragmentAdapter = this.m) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.s(i), true);
    }

    @Override // com.baidu.tieba.un7
    public void setOnTabSelectedListener(ScrollFragmentTabHost.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, sVar) == null) {
            this.n = sVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bdUniqueId) == null) {
            this.r.setTag(bdUniqueId);
            this.t.setTag(bdUniqueId);
            this.u.setTag(bdUniqueId);
            this.q.setTag(bdUniqueId);
        }
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.m;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.O(z);
            }
            er5 er5Var = this.c;
            if (er5Var != null) {
                er5Var.b(z);
            }
        }
    }

    public void setScrollShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.j = z;
        }
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, str) == null) && (newScrollFragmentAdapter = this.m) != null) {
            newScrollFragmentAdapter.R(str);
        }
    }

    public String u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            return this.m.u(i);
        }
        return (String) invokeI.objValue;
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            er5 er5Var = this.c;
            if (er5Var != null) {
                er5Var.a(!UtilHelper.isNightOrDarkMode());
            }
            F();
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.m;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.H(str);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5000);
            super.onMeasure(i, i2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5007);
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AppBarLayout appBarLayout = this.e;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true, true);
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.m;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.K();
            }
        }
    }

    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.m;
            if (newScrollFragmentAdapter != null) {
                return newScrollFragmentAdapter.p();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getCurrentSecondTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return u(this.g.getCurrentItem());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.un7
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.m;
            if (newScrollFragmentAdapter == null) {
                return 0;
            }
            return newScrollFragmentAdapter.x(this.g.getCurrentItem());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.un7
    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.f;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.m;
            if (newScrollFragmentAdapter == null || newScrollFragmentAdapter.getCount() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            ak6 ak6Var = this.v;
            if (ak6Var != null) {
                ak6Var.d();
                this.v = null;
            }
            MessageManager.getInstance().unRegisterListener(this.w);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921758));
        }
    }

    @Override // com.baidu.tieba.un7
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !this.j || A()) {
            return;
        }
        this.h.setVisibility(0);
        if (this.k == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.k = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.k.setDuration(300L);
        }
        this.h.startAnimation(this.k);
    }

    @Override // com.baidu.tieba.un7
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !this.j || !A()) {
            return;
        }
        if (this.l == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.l = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.l.setDuration(300L);
            this.l.setAnimationListener(new h(this));
        }
        this.h.startAnimation(this.l);
    }

    public final void E(int i) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && this.b != null && (newScrollFragmentAdapter = this.m) != null && (nestedNoScrollViewPager = this.g) != null) {
            String t = newScrollFragmentAdapter.t(nestedNoScrollViewPager.getCurrentItem());
            rn7 rn7Var = new rn7();
            rn7Var.b = t;
            rn7Var.c = i;
            CustomMessage customMessage = new CustomMessage(2921652);
            customMessage.setTag(this.b.getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921652, rn7Var);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void y(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.c = new er5(tbPageContext.getPageActivity());
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.t);
            MessageManager.getInstance().registerListener(this.w);
            MessageManager.getInstance().registerListener(this.u);
            MessageManager.getInstance().registerListener(this.s);
            if (this.b != null) {
                this.q.setPriority(Integer.MAX_VALUE);
                MessageManager.getInstance().registerListener(this.q);
            }
        }
    }

    public final void F() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.d != null) {
            HashMap<String, kb5> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
            if (colourHeaderConfig != null) {
                kb5 kb5Var = colourHeaderConfig.get(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1442));
                if (kb5Var != null) {
                    PagerSlidingTabStrip pagerSlidingTabStrip = this.d;
                    if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    pagerSlidingTabStrip.s(z, kb5Var.m());
                    return;
                }
                this.d.D();
                return;
            }
            this.d.D();
        }
    }

    public void H(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, str, i, i2) == null) && this.g != null && this.m != null) {
            if (i == -1 && ii.E()) {
                ii.P(this.a, R.string.obfuscated_res_0x7f0f0d1b);
            }
            this.m.V(str, i, i2);
        }
    }

    public void I(DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (newScrollFragmentAdapter = this.m) != null) {
            newScrollFragmentAdapter.X(dataRes, z, z2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5008);
            super.onLayout(z, i, i2, i3, i4);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY);
        }
    }

    public void setCurrentTab(int i, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && i >= 0 && (newScrollFragmentAdapter = this.m) != null && i < newScrollFragmentAdapter.getCount()) {
            this.d.setTabItemClicked(z);
            this.m.Q(i);
            this.g.setCurrentItem(i);
        }
    }

    public void setCurrentTab(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, str) != null) || (newScrollFragmentAdapter = this.m) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.A(str), false);
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4006);
            this.a = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07f1, (ViewGroup) this, true);
            this.e = (AppBarLayout) findViewById(R.id.obfuscated_res_0x7f0902ae);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f091fd4);
            this.d = pagerSlidingTabStrip;
            pagerSlidingTabStrip.setIsFromSecondtab(true);
            this.d.setTextNormalColor(R.color.CAM_X0107);
            this.d.setTextPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            this.d.A(ii.g(context, R.dimen.T_X07), ii.g(context, R.dimen.T_X07), ii.g(context, R.dimen.tbds0), false);
            this.d.setHorizontalFadingEdgeEnabled(true);
            this.d.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007));
            this.d.setBackResId(R.color.transparent);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090efb);
            this.f = frameLayout;
            eo9.c(frameLayout, 4);
            this.g = (NestedNoScrollViewPager) findViewById(R.id.obfuscated_res_0x7f091fdd);
            this.h = findViewById(R.id.obfuscated_res_0x7f0908d0);
            this.i = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09043c);
            this.d.setOnPageChangeListener(new g(this));
            SpeedStatsManager.getInstance().addStatsTimeStamp(4007);
        }
    }

    public void z(FragmentManager fragmentManager, tn7 tn7Var, ConcernPageView.r rVar) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048615, this, fragmentManager, tn7Var, rVar) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.a, fragmentManager, true, tn7Var, rVar);
            this.m = newScrollFragmentAdapter;
            newScrollFragmentAdapter.P(this);
            this.g.setOffscreenPageLimit(1);
            this.g.setAdapter(this.m);
            int q = this.m.q();
            NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.m;
            if (HomePageStatic.a) {
                q = 0;
            }
            this.g.setCurrentItem(newScrollFragmentAdapter2.s(q));
            this.d.setViewPager(this.g);
            this.d.setConcernTabIndex(this.m.s(0));
            if (p45.m().i("key_home_page_first_dismiss_tab", false) && (appBarLayout = this.e) != null) {
                appBarLayout.setExpanded(false, false);
            } else {
                p45.m().w("key_home_page_first_dismiss_tab", true);
            }
        }
    }
}
