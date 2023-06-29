package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a8a;
import com.baidu.tieba.ex7;
import com.baidu.tieba.ey7;
import com.baidu.tieba.fx7;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.RecommendFrsControlFragment;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.hx7;
import com.baidu.tieba.in;
import com.baidu.tieba.ix7;
import com.baidu.tieba.j05;
import com.baidu.tieba.jv7;
import com.baidu.tieba.kd5;
import com.baidu.tieba.kx7;
import com.baidu.tieba.lx7;
import com.baidu.tieba.mn5;
import com.baidu.tieba.oa5;
import com.baidu.tieba.ox7;
import com.baidu.tieba.qg;
import com.baidu.tieba.r95;
import com.baidu.tieba.rg;
import com.baidu.tieba.s2a;
import com.baidu.tieba.ux5;
import com.baidu.tieba.xg5;
import com.baidu.tieba.xi;
import com.baidu.tieba.y6a;
import com.baidu.tieba.yg;
import com.baidu.tieba.yr6;
import com.baidu.tieba.z6a;
import com.baidu.tieba.z9a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class ScrollFragmentTabHost extends CoordinatorLayout implements ix7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A;
    public TbImageView B;
    public View C;
    public final CustomMessageListener D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public boolean H;
    public CustomMessageListener I;
    public CustomMessageListener J;
    public CustomMessageListener K;
    public View.OnClickListener L;
    public qg<in> M;
    @Nullable
    public FixedAppBarLayout N;
    public yr6 O;
    public jv7 P;
    public CustomMessageListener Q;
    public qg<in> R;
    public ox7 S;

    /* renamed from: T  reason: collision with root package name */
    public lx7 f1105T;
    public kx7 U;
    public Context a;
    public TbPageContext b;
    public FragmentManager c;
    public hx7 d;
    public ConcernPageView.s e;
    public HomeTabBarView f;
    public ux5 g;
    public boolean h;
    public int i;
    public String j;
    public String k;
    public boolean l;
    public FrameLayout m;
    public CustomViewPager n;
    public View o;
    public View p;
    public TBSpecificationBtn q;
    public boolean r;
    public AlphaAnimation s;
    public AlphaAnimation t;
    public NewScrollFragmentAdapter u;
    public s v;
    public yr6 w;
    public List<r> x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public interface s {
        void a(int i);
    }

    public final int S(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
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

    @Override // com.baidu.tieba.ix7
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes6.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageView a;

            public a(l lVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, imageView};
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

        /* loaded from: classes6.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageView a;

            public b(l lVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, imageView};
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
        public l(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                LinearLayout linearLayout = (LinearLayout) this.a.f.l(0);
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
                    if (this.a.f != null) {
                        this.a.P.k(this.a.f.getBackgroundAlpha());
                        this.a.P.j(TbadkCoreApplication.getInst().getSkinType());
                    }
                } else if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 1) {
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
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes6.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextView a;
            public final /* synthetic */ int b;

            public a(m mVar, TextView textView, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, textView, Integer.valueOf(i)};
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

        /* loaded from: classes6.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextView a;
            public final /* synthetic */ int b;

            public b(m mVar, TextView textView, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, textView, Integer.valueOf(i)};
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

        /* loaded from: classes6.dex */
        public class c implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextView a;
            public final /* synthetic */ String b;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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

            public c(m mVar, TextView textView, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, textView, str};
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
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.setText(this.b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                String string = this.a.getResources().getString(R.string.attention_person);
                String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02e8);
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                LinearLayout linearLayout = (LinearLayout) this.a.f.l(0);
                if (intValue == 1) {
                    if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                        TextView textView = (TextView) linearLayout.getChildAt(0);
                        if (string2.equals(textView.getText())) {
                            int measuredWidth = textView.getMeasuredWidth();
                            textView.setText(string);
                            int measureText = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.attention_person));
                            int measureText2 = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02e8));
                            if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                                ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                                ofInt.setDuration(360L);
                                ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                                ofInt.start();
                            }
                        }
                        r95.p().F("key_home_concern_all_status", 1);
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
                    r95.p().F("key_home_concern_all_status", 0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
                if (this.a.H != UbsABTestHelper.isConcernForumCardShow()) {
                    this.a.f.q();
                    if (UbsABTestHelper.isConcernForumCardShow() && this.a.y) {
                        this.a.Q();
                        this.a.o0();
                    }
                }
                String t = r95.t("key_new_hot_topic_update_time");
                kd5 hotNotifyConfig = TbSingleton.getInstance().getHotNotifyConfig();
                if (hotNotifyConfig != null && ey7.b(4320000L) && ey7.a(hotNotifyConfig.b(), t)) {
                    this.a.f.setHotLabelData(hotNotifyConfig);
                }
                if (!ex7.m(TbSingleton.getInstance().getColourHeaderConfig(), TbSingleton.getInstance().getLastColourHeaderConfigs())) {
                    return;
                }
                this.a.h0();
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.U(scrollFragmentTabHost.n.getCurrentItem()));
                TbSingleton.getInstance().setLastColourHeaderConfigs(TbSingleton.getInstance().getColourHeaderConfig());
                this.a.u.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mn5.b {
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

        @Override // com.baidu.tieba.mn5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new jv7(this.a.a);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PagerSlidingTabStrip.d {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.d
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, view2, i) != null) {
                return;
            }
            this.a.M(i);
            if (this.a.d(i) == 7) {
                TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "1"));
            } else if (this.a.d(i) == 8) {
                TiebaStatic.log(new StatisticItem("c13580"));
            }
            if (this.a.d(i) == 5) {
                StatisticItem statisticItem = new StatisticItem("c13740");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_type", 0);
                statisticItem.eventStat();
                this.a.z = true;
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        r95.p().H(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                        return;
                    }
                    return;
                }
                r95.p().H("unlogin_hot_top_timestamp", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment.n a;
        public final /* synthetic */ ScrollFragmentTabHost b;

        public d(ScrollFragmentTabHost scrollFragmentTabHost, RecommendFrsControlFragment.n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = scrollFragmentTabHost;
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.setCurrentTab(this.a.b());
                if (!TextUtils.isEmpty(this.a.a())) {
                    this.b.setSecondCurTab(-1, this.a.a(), "");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends qg<in> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, inVar, str, i) == null) && this.a.N != null && inVar != null) {
                if (inVar.p() != null) {
                    Object tag = this.a.N.getTag(R.id.obfuscated_res_0x7f090f56);
                    if ((tag instanceof String) && !tag.equals(str)) {
                        return;
                    }
                    this.a.N.setImageBackground(inVar.p());
                    return;
                }
                this.a.l0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

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

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.p.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements lx7 {
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

        @Override // com.baidu.tieba.lx7
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.u == null) {
                return;
            }
            this.a.setCurrentTab(this.a.u.s(i), false);
            this.a.u.I(i);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements kx7 {
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

        @Override // com.baidu.tieba.kx7
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.S.b(i, this.a.f1105T);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
                this.a.u.M();
                this.a.f.q();
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.U(scrollFragmentTabHost.n.getCurrentItem()));
                if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof RecommendFrsControlFragment.n)) {
                    return;
                }
                this.a.i0((RecommendFrsControlFragment.n) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.O != null) {
                this.a.O.h();
                this.a.O = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.h && customResponsedMessage.getCmd() == 2921751) {
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setSecondCurTab(scrollFragmentTabHost.i, this.a.j, this.a.k);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.u != null && customResponsedMessage != null && customResponsedMessage.getData() != null && this.a.f != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.u.Y();
                this.a.u.W();
                this.a.n.setAdapter(this.a.u);
                this.a.f.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (j05.b() == 1) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{"http://fans.baidu.com/fanstest/wapindex?product_id=1002&version=12.11.0.11&client_type=android&contact_way=qq"});
                } else if (j05.b() == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921569));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends qg<in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public q(ScrollFragmentTabHost scrollFragmentTabHost) {
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
        @Override // com.baidu.tieba.qg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, inVar, str, i) == null) {
                if (inVar != null && this.a.B != null) {
                    if (inVar.p() == null) {
                        this.a.m0();
                    }
                    this.a.B.setImageBitmap(inVar.p());
                    return;
                }
                this.a.m0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public r() {
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
    }

    /* loaded from: classes6.dex */
    public static class t implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ScrollFragmentTabHost> a;

        public t(ScrollFragmentTabHost scrollFragmentTabHost) {
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
            this.a = new WeakReference<>(scrollFragmentTabHost);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            ScrollFragmentTabHost scrollFragmentTabHost;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (scrollFragmentTabHost = this.a.get()) == null) {
                return;
            }
            if (i != 0) {
                scrollFragmentTabHost.l = false;
            }
            if (i == 0 && scrollFragmentTabHost.getCurrentTabType() == 0) {
                boolean a0 = scrollFragmentTabHost.a0();
                TiebaStatic.log(new StatisticItem("c12350").param("obj_type", a0 ? 1 : 0));
                if (a0 && scrollFragmentTabHost.u != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                    scrollFragmentTabHost.u.T();
                }
            }
            scrollFragmentTabHost.k0(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            ScrollFragmentTabHost scrollFragmentTabHost;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) || (scrollFragmentTabHost = this.a.get()) == null || scrollFragmentTabHost.u == null) {
                return;
            }
            scrollFragmentTabHost.u.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ScrollFragmentTabHost scrollFragmentTabHost;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || (scrollFragmentTabHost = this.a.get()) == null) {
                return;
            }
            scrollFragmentTabHost.l = true;
            if (scrollFragmentTabHost.u == null) {
                return;
            }
            if (scrollFragmentTabHost.v != null) {
                scrollFragmentTabHost.v.a(i);
            }
            scrollFragmentTabHost.t0(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            int x = scrollFragmentTabHost.u.x(scrollFragmentTabHost.n.getCurrentItem());
            if (x == 5) {
                if (!scrollFragmentTabHost.z) {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 0);
                    statisticItem.eventStat();
                } else {
                    scrollFragmentTabHost.z = false;
                }
                if (scrollFragmentTabHost.f.o()) {
                    scrollFragmentTabHost.f.m();
                }
            }
            if (x == 0) {
                scrollFragmentTabHost.Q();
            }
            View l = scrollFragmentTabHost.f.l(0);
            if ((l instanceof LinearLayout) && TbadkCoreApplication.isLogin() && UbsABTestHelper.isConcernForumCardShow()) {
                LinearLayout linearLayout = (LinearLayout) l;
                if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (x == 0) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                }
            }
            if (scrollFragmentTabHost.x != null && scrollFragmentTabHost.u != null) {
                int x2 = scrollFragmentTabHost.u.x(scrollFragmentTabHost.n.getCurrentItem());
                if (x2 == 5) {
                    scrollFragmentTabHost.setScrollShadow(false);
                    for (r rVar : scrollFragmentTabHost.x) {
                        rVar.c();
                    }
                } else if (x2 == 1) {
                    scrollFragmentTabHost.setScrollShadow(false);
                    for (r rVar2 : scrollFragmentTabHost.x) {
                        rVar2.b();
                    }
                } else if (x2 == 0) {
                    scrollFragmentTabHost.setScrollShadow(false);
                    for (r rVar3 : scrollFragmentTabHost.x) {
                        rVar3.a();
                    }
                } else if (x2 == 6) {
                    scrollFragmentTabHost.setScrollShadow(true);
                } else if (x2 == 7) {
                    scrollFragmentTabHost.setScrollShadow(true);
                } else if (x2 == 8) {
                    scrollFragmentTabHost.setScrollShadow(false);
                } else {
                    scrollFragmentTabHost.c();
                    scrollFragmentTabHost.setScrollShadow(false);
                }
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(scrollFragmentTabHost.d(i));
            if (scrollFragmentTabHost.d(i) == 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        r95.p().H(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    r95.p().H("unlogin_hot_top_timestamp", currentTimeMillis);
                }
            }
            scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.U(i));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1701702303, "Lcom/baidu/tieba/homepage/framework/indicator/ScrollFragmentTabHost;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1701702303, "Lcom/baidu/tieba/homepage/framework/indicator/ScrollFragmentTabHost;");
            }
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null) {
                return false;
            }
            return newScrollFragmentAdapter.k();
        }
        return invokeV.booleanValue;
    }

    public void Q() {
        yr6 yr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (yr6Var = this.w) != null) {
            yr6Var.h();
        }
    }

    public void R() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.l();
        }
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null || newScrollFragmentAdapter.getCount() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.p.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f != null && (newScrollFragmentAdapter = this.u) != null && newScrollFragmentAdapter.D()) {
                return this.f.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (newScrollFragmentAdapter = this.u) != null && !HomePageStatic.a) {
            this.n.setAdapter(newScrollFragmentAdapter);
            this.f.q();
            this.S.a(this.f1105T);
        }
    }

    public void e0() {
        FixedAppBarLayout fixedAppBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (fixedAppBarLayout = this.N) != null) {
            fixedAppBarLayout.n();
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.t();
            }
            FixedAppBarLayout fixedAppBarLayout = this.N;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.o();
            }
        }
    }

    public void g0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        newScrollFragmentAdapter.y(this.U);
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            CustomViewPager customViewPager = this.n;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                return newScrollFragmentAdapter.p();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getCurrentSecondName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null && (newScrollFragmentAdapter.o() instanceof PersonalizeWrapperFragment)) {
                return ((PersonalizeWrapperFragment) this.u.o()).J1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ix7
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null) {
                return 0;
            }
            return newScrollFragmentAdapter.x(this.n.getCurrentItem());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ix7
    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.m;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void j0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.K();
        }
    }

    public final void l0() {
        FixedAppBarLayout fixedAppBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (fixedAppBarLayout = this.N) != null) {
            fixedAppBarLayout.setImageBackgroundVisibility(0);
            this.N.setImageDrawable(SkinManager.getDrawable(R.drawable.color_header_bg));
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onDetachedFromWindow();
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
                MessageManager.getInstance().unRegisterTask(2921405);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollFragmentTabHost(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = false;
        this.l = true;
        this.z = false;
        this.D = new i(this, 2921653);
        this.E = new j(this, 2921400);
        this.F = new k(this, 2921415);
        this.G = new l(this, 2921501);
        this.I = new m(this, 2921502);
        this.J = new n(this, 2921751);
        this.K = new o(this, 2921509);
        this.L = new p(this);
        this.M = new q(this);
        this.Q = new a(this, 2001371);
        this.R = new e(this);
        this.S = new ox7();
        this.f1105T = new g(this);
        this.U = new h(this);
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorHead(String str) {
        xg5 xg5Var;
        String h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, this, str) == null) && this.l && this.N != null && this.g != null) {
            HashMap<String, xg5> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
            String str2 = null;
            if (colourHeaderConfig != null) {
                xg5Var = colourHeaderConfig.get(str);
            } else {
                xg5Var = null;
            }
            O(str, xg5Var);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (xg5Var != null) {
                if (skinType != 0) {
                    if (skinType != 4) {
                        h2 = null;
                    } else {
                        str2 = xg5Var.l();
                        h2 = xg5Var.i();
                    }
                } else {
                    str2 = xg5Var.k();
                    h2 = xg5Var.h();
                }
                this.N.setTag(R.id.obfuscated_res_0x7f090f56, str2);
                if (TextUtils.isEmpty(str2)) {
                    this.N.setImageBackgroundVisibility(8);
                    this.N.setBackgroundColor(s2a.f(h2));
                } else {
                    this.N.setImageBackgroundVisibility(0);
                    l0();
                    rg.h().m(str2, 10, this.R, this.b.getUniqueId());
                }
                n0(skinType, xg5Var.m());
                return;
            }
            this.N.setTag(R.id.obfuscated_res_0x7f090f56, null);
            l0();
            n0(skinType, true);
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
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = false;
        this.l = true;
        this.z = false;
        this.D = new i(this, 2921653);
        this.E = new j(this, 2921400);
        this.F = new k(this, 2921415);
        this.G = new l(this, 2921501);
        this.I = new m(this, 2921502);
        this.J = new n(this, 2921751);
        this.K = new o(this, 2921509);
        this.L = new p(this);
        this.M = new q(this);
        this.Q = new a(this, 2001371);
        this.R = new e(this);
        this.S = new ox7();
        this.f1105T = new g(this);
        this.U = new h(this);
        W();
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", S(i2));
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public String T(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return this.u.t(i2);
        }
        return (String) invokeI.objValue;
    }

    public String U(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null) {
                return "";
            }
            return newScrollFragmentAdapter.u(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.ix7
    public void b(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, rVar) == null) {
            if (this.x == null) {
                this.x = new ArrayList();
            }
            this.x.add(rVar);
        }
    }

    @Override // com.baidu.tieba.ix7
    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            return this.u.x(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, canvas) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY);
            super.dispatchDraw(canvas);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tieba.ix7
    public void e(r rVar) {
        List<r> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, rVar) == null) && (list = this.x) != null && list.size() > 0) {
            this.x.remove(rVar);
        }
    }

    public void q0(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.S(z);
        }
    }

    public void setCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048626, this, i2) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.s(i2), false);
        setSecondCurTab(i2, "", "");
    }

    public void setCurrentTabByCode(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048629, this, str) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.z(str), false);
        setSecondCurTab(-1, "", str);
    }

    public void setFakeClickCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048630, this, i2) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.s(i2), true);
    }

    @Override // com.baidu.tieba.ix7
    public void setOnTabSelectedListener(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, sVar) == null) {
            this.v = sVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bdUniqueId) == null) {
            this.f.setPageUniqueId(bdUniqueId);
            this.E.setTag(bdUniqueId);
            this.F.setTag(bdUniqueId);
            this.I.setTag(bdUniqueId);
            this.G.setTag(bdUniqueId);
            this.K.setTag(bdUniqueId);
        }
    }

    public void setPrimary(boolean z) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.y = z;
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.O(z);
            }
            if (!z && (tbPageContext = this.b) != null) {
                StatusbarColorUtils.setStatusBarDarkIcon(tbPageContext.getPageActivity(), !UtilHelper.isNightOrDarkMode());
            }
        }
    }

    public void setScrollShadow(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.r = z;
            if (z && (view2 = this.o) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048636, this, z) == null) && this.f != null && (newScrollFragmentAdapter = this.u) != null && newScrollFragmentAdapter.D()) {
            this.f.setShowConcernRedTip(z);
        }
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, str) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.R(str);
        }
    }

    public final void t0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            a8a b2 = z9a.a().b().b();
            b2.a = U(i2);
            b2.c = d(i2);
            b2.d = T(i2);
            b2.b = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048621, this, i2, i3) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5000);
            super.onMeasure(i2, i3);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5007);
        }
    }

    public void r0(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048624, this, dataRes, z) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.U(dataRes, z);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c == null) {
            return;
        }
        y6a.a("ScrollFragmentTabHost attachAdapter");
        NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.a, this.c, false, this.d, this.e);
        this.u = newScrollFragmentAdapter;
        newScrollFragmentAdapter.P(this);
        this.n.setOffscreenPageLimit(2);
        this.n.setAdapter(this.u);
        int q2 = this.u.q();
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.u;
        if (HomePageStatic.a) {
            q2 = 0;
        }
        int s2 = newScrollFragmentAdapter2.s(q2);
        this.n.setCurrentItem(s2);
        this.f.setViewPager(this.n);
        this.f.q();
        this.f.setConcernTabIndex(this.u.s(0));
        t0(s2);
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048617, this) != null) || !TbadkCoreApplication.isLogin()) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
        int i2 = 0;
        if (newScrollFragmentAdapter != null) {
            i2 = newScrollFragmentAdapter.s(0);
        }
        if (this.w == null) {
            yr6 yr6Var = new yr6(this.b, this.f.l(i2));
            this.w = yr6Var;
            yr6Var.L(R.drawable.bg_tip_blue_up_left);
            this.w.o(16);
            this.w.x(true);
            this.w.Q(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
            this.w.N(true);
            this.w.n(4000);
        }
        this.w.T(this.a.getString(R.string.obfuscated_res_0x7f0f04bb), "key_concern_forum_tab_tips_show");
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            int i2 = 0;
            if (r95.p().q("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                i2 = newScrollFragmentAdapter.s(0);
            }
            if (this.w == null) {
                yr6 yr6Var = new yr6(this.b, this.f.l(i2));
                this.w = yr6Var;
                yr6Var.L(R.drawable.bg_tip_blue_up);
                this.w.o(32);
                this.w.x(true);
                this.w.N(true);
                this.w.R(xi.g(this.a, R.dimen.obfuscated_res_0x7f0701be));
                this.w.n(4000);
            }
            this.w.U(this.a.getString(R.string.obfuscated_res_0x7f0f04bc), "key_concern_tab_tips", true);
        }
    }

    public void O(String str, xg5 xg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, xg5Var) == null) {
            if (xg5Var != null) {
                if (!StringUtils.isNull(xg5Var.c())) {
                    this.A.setVisibility(0);
                    ex7.h(xg5Var, this.B, this.C, this.M, this.b.getUniqueId());
                } else if (!StringUtils.isNull(xg5Var.a())) {
                    this.A.setVisibility(0);
                    ex7.g(xg5Var, this.B, this.C);
                }
            } else {
                m0();
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.H(str);
            }
        }
    }

    public final void n0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.g.c(true);
            if (i2 == 0) {
                this.g.a(z);
                this.f.i(true, z);
                this.N.setSearchStyle(true, z);
                return;
            }
            this.g.a(false);
            this.f.i(false, false);
            this.N.setSearchStyle(false, false);
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            y6a.a("ScrollFragmentTabHost init");
            SpeedStatsManager.getInstance().addStatsTimeStamp(4006);
            this.a = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0853, (ViewGroup) this, true);
            this.A = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090744);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090746);
            this.B = tbImageView;
            tbImageView.setUseNightOrDarkMask(false);
            this.B.setNeedNightShade(false);
            this.C = findViewById(R.id.obfuscated_res_0x7f090745);
            FixedAppBarLayout fixedAppBarLayout = new FixedAppBarLayout(this.a);
            this.N = fixedAppBarLayout;
            addView(fixedAppBarLayout, 2);
            z6a.c(this.N, 3);
            this.f = (HomeTabBarView) findViewById(R.id.obfuscated_res_0x7f090f5c);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090f5a);
            this.m = frameLayout;
            z6a.c(frameLayout, 4);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f092311);
            this.n = customViewPager;
            customViewPager.setForm(1);
            this.o = findViewById(R.id.obfuscated_res_0x7f0908f8);
            this.p = findViewById(R.id.obfuscated_res_0x7f090905);
            this.q = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090f61);
            if (j05.b() == 1) {
                oa5 oa5Var = new oa5();
                this.q.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09df));
                this.q.setTextSize(R.dimen.tbds42);
                this.q.setConfig(oa5Var);
                this.q.setOnClickListener(this.L);
                this.q.setVisibility(0);
            } else if (j05.b() == 2) {
                oa5 oa5Var2 = new oa5();
                this.q.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09e0));
                this.q.setTextSize(R.dimen.tbds35);
                this.q.setConfig(oa5Var2);
                this.q.setOnClickListener(this.L);
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            this.P = (jv7) mn5.e().d(1012, new b(this));
            this.f.setOnPageChangeListener(new t(this));
            this.f.setOnTabItemClickListener(new c(this));
            SpeedStatsManager.getInstance().addStatsTimeStamp(4007);
        }
    }

    public void X(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.g = new ux5(tbPageContext.getPageActivity());
            MessageManager.getInstance().registerListener(this.E);
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.I);
            MessageManager.getInstance().registerListener(this.G);
            MessageManager.getInstance().registerListener(this.Q);
            MessageManager.getInstance().registerListener(this.K);
            MessageManager.getInstance().registerListener(this.J);
            MessageManager.getInstance().registerListener(this.D);
        }
    }

    public void Y(FragmentManager fragmentManager, hx7 hx7Var, ConcernPageView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, fragmentManager, hx7Var, sVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.c = fragmentManager;
                this.d = hx7Var;
                this.e = sVar;
                N();
            } finally {
                TTIStats.record("ScrollFragmentTabHost.initViewPager", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void s0(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048625, this, str, i2, i3) == null) && this.n != null && this.u != null) {
            if (i2 == -1) {
                xi.P(this.a, R.string.obfuscated_res_0x7f0f0e0f);
            }
            this.u.V(str, i2, i3);
        }
    }

    public void u0(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.X(dataRes, z, z2);
        }
    }

    @Override // com.baidu.tieba.ix7
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || !this.r || Z()) {
            return;
        }
        this.p.setVisibility(0);
        if (this.s == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.s = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.s.setDuration(300L);
        }
        this.p.startAnimation(this.s);
    }

    @Override // com.baidu.tieba.ix7
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !this.r || !Z()) {
            return;
        }
        if (this.t == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.t = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.t.setDuration(300L);
            this.t.setAnimationListener(new f(this));
        }
        this.p.startAnimation(this.t);
    }

    public int getVideoRecommendIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.u != null && this.n.getAdapter() != null) {
                int count = this.n.getAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (this.u.x(i2) == 8) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            View view2 = this.C;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            TbImageView tbImageView = this.B;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                this.B.setImageDrawable(SkinManager.getDrawable(R.drawable.color_card_bg));
            }
        }
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.r();
            }
            CustomViewPager customViewPager = this.n;
            if (customViewPager != null) {
                setColorHead(U(customViewPager.getCurrentItem()));
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.J(i2);
            }
            jv7 jv7Var = this.P;
            if (jv7Var != null) {
                jv7Var.j(i2);
            }
            SkinManager.setBackgroundResource(this.p, R.drawable.personalize_tab_shadow);
        }
    }

    public final void i0(RecommendFrsControlFragment.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, nVar) != null) || nVar == null) {
            return;
        }
        y6a.a("ScrollFragmentTabHost recoverSelectedTab:" + nVar.b() + " SecondTab:" + nVar.a());
        yg.a().post(new d(this, nVar));
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            yr6 yr6Var = this.O;
            if (yr6Var != null) {
                yr6Var.h();
                this.O = null;
            }
            FixedAppBarLayout fixedAppBarLayout = this.N;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.m();
            }
            Q();
            MessageManager.getInstance().unRegisterListener(this.Q);
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.D);
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.s();
            }
        }
    }

    public final void h0() {
        HashMap<String, xg5> colourHeaderConfig;
        String k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) != null) {
            for (xg5 xg5Var : colourHeaderConfig.values()) {
                if (xg5Var != null) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType != 0) {
                        if (skinType != 4) {
                            k2 = null;
                        } else {
                            k2 = xg5Var.l();
                        }
                    } else {
                        k2 = xg5Var.k();
                    }
                    rg.h().m(k2, 10, null, this.b.getUniqueId());
                }
            }
        }
    }

    public final void k0(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i2) == null) && this.b != null && (newScrollFragmentAdapter = this.u) != null && (customViewPager = this.n) != null) {
            String t2 = newScrollFragmentAdapter.t(customViewPager.getCurrentItem());
            fx7 fx7Var = new fx7();
            fx7Var.b = t2;
            fx7Var.c = i2;
            CustomMessage customMessage = new CustomMessage(2921652);
            customMessage.setTag(this.b.getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921652, fx7Var);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5008);
            super.onLayout(z, i2, i3, i4, i5);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY);
        }
    }

    public void setCurrentTab(int i2, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 >= 0 && (newScrollFragmentAdapter = this.u) != null && i2 < newScrollFragmentAdapter.getCount()) {
            this.f.setTabItemClicked(z);
            this.u.Q(i2);
            this.n.setCurrentItem(i2);
        }
    }

    public void setCurrentTab(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, str) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.A(str), false);
        setSecondCurTab(-1, str, "");
    }

    public void setSecondCurTab(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048635, this, i2, str, str2) == null) {
            if (this.u.z(str2) == this.u.B() && (this.u.o() instanceof PersonalizeWrapperFragment)) {
                PersonalizeWrapperFragment personalizeWrapperFragment = (PersonalizeWrapperFragment) this.u.o();
                if (i2 != -1) {
                    personalizeWrapperFragment.O1(i2);
                } else if (!TextUtils.isEmpty(str)) {
                    personalizeWrapperFragment.N1(str);
                } else if (!TextUtils.isEmpty(str2)) {
                    personalizeWrapperFragment.M1(str2);
                }
            } else if (this.u.o() == null) {
                this.h = true;
                this.i = i2;
                this.k = str2;
                this.j = str;
            }
        }
    }
}
