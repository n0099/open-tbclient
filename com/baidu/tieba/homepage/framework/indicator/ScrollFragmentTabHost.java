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
import androidx.annotation.NonNull;
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
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.d18;
import com.baidu.tieba.da5;
import com.baidu.tieba.dt6;
import com.baidu.tieba.dx5;
import com.baidu.tieba.e18;
import com.baidu.tieba.f18;
import com.baidu.tieba.fz7;
import com.baidu.tieba.g28;
import com.baidu.tieba.gea;
import com.baidu.tieba.gt6;
import com.baidu.tieba.h18;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.RecommendFrsControlFragment;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.i18;
import com.baidu.tieba.in5;
import com.baidu.tieba.k18;
import com.baidu.tieba.kia;
import com.baidu.tieba.l18;
import com.baidu.tieba.lia;
import com.baidu.tieba.lla;
import com.baidu.tieba.ng5;
import com.baidu.tieba.q18;
import com.baidu.tieba.qja;
import com.baidu.tieba.us6;
import com.baidu.tieba.yc5;
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
public class ScrollFragmentTabHost extends CoordinatorLayout implements i18 {
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
    public BdResourceCallback<BdImage> M;
    @Nullable
    public FixedAppBarLayout N;
    public us6 O;
    public fz7 P;
    public CustomMessageListener Q;
    public final Object R;
    public final gt6<d18> S;

    /* renamed from: T  reason: collision with root package name */
    public BdResourceCallback<BdImage> f1117T;
    public q18 U;
    public l18 V;
    public k18 W;
    public Context a;
    public TbPageContext b;
    public FragmentManager c;
    public h18 d;
    public ConcernPageView.s e;
    public HomeTabBarView f;
    public dx5 g;
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
    public t v;
    public us6 w;
    public List<s> x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public interface t {
        void a(int i);
    }

    public final int V(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
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

    @Override // com.baidu.tieba.i18
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
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
            public final /* synthetic */ ImageView a;

            public a(m mVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, imageView};
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

            public b(m mVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, imageView};
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
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes6.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextView a;
            public final /* synthetic */ int b;

            public a(n nVar, TextView textView, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, textView, Integer.valueOf(i)};
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

            public b(n nVar, TextView textView, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, textView, Integer.valueOf(i)};
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

            public c(n nVar, TextView textView, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, textView, str};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                String string = this.a.getResources().getString(R.string.attention_person);
                String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02e9);
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                LinearLayout linearLayout = (LinearLayout) this.a.f.l(0);
                if (intValue == 1) {
                    if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                        TextView textView = (TextView) linearLayout.getChildAt(0);
                        if (string2.equals(textView.getText())) {
                            int measuredWidth = textView.getMeasuredWidth();
                            textView.setText(string);
                            int measureText = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.attention_person));
                            int measureText2 = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02e9));
                            if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                                ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                                ofInt.setDuration(360L);
                                ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                                ofInt.start();
                            }
                        }
                        SharedPrefHelper.getInstance().putInt("key_home_concern_all_status", 1);
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
                    SharedPrefHelper.getInstance().putInt("key_home_concern_all_status", 0);
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
                        this.a.S();
                        this.a.t0();
                    }
                }
                String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_new_hot_topic_update_time");
                yc5 hotNotifyConfig = TbSingleton.getInstance().getHotNotifyConfig();
                if (hotNotifyConfig != null && g28.b(4320000L) && g28.a(hotNotifyConfig.b(), sharedPrefKeyWithAccount)) {
                    this.a.f.setHotLabelData(hotNotifyConfig);
                }
                if (!e18.m(TbSingleton.getInstance().getColourHeaderConfig(), TbSingleton.getInstance().getLastColourHeaderConfigs())) {
                    return;
                }
                this.a.l0();
                this.a.n0();
                TbSingleton.getInstance().setLastColourHeaderConfigs(TbSingleton.getInstance().getColourHeaderConfig());
                this.a.u.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends gt6<d18> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ScrollFragmentTabHost scrollFragmentTabHost, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = scrollFragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gt6
        public void onEvent(@NonNull d18 d18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, d18Var) != null) {
                return;
            }
            this.b.A0(d18Var.b(), d18Var.a());
        }
    }

    /* loaded from: classes6.dex */
    public class c implements in5.b {
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

        @Override // com.baidu.tieba.in5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new fz7(this.a.a);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PagerSlidingTabStrip.c {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.c
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, view2, i) != null) {
                return;
            }
            this.a.N(i);
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
                        SharedPrefHelper.getInstance().putLong(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                        return;
                    }
                    return;
                }
                SharedPrefHelper.getInstance().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment.n a;
        public final /* synthetic */ ScrollFragmentTabHost b;

        public e(ScrollFragmentTabHost scrollFragmentTabHost, RecommendFrsControlFragment.n nVar) {
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
    public class f extends BdResourceCallback<BdImage> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) && this.a.N != null && bdImage != null) {
                if (bdImage.getRawBitmap() != null) {
                    Object tag = this.a.N.getTag(R.id.obfuscated_res_0x7f090f85);
                    if ((tag instanceof String) && !tag.equals(str)) {
                        return;
                    }
                    this.a.N.setImageBackground(bdImage.getRawBitmap());
                    return;
                }
                this.a.q0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Animation.AnimationListener {
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

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.p.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements l18 {
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

        @Override // com.baidu.tieba.l18
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.u == null) {
                return;
            }
            this.a.setCurrentTab(this.a.u.s(i), false);
            this.a.u.J(i);
        }
    }

    /* loaded from: classes6.dex */
    public class i implements k18 {
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

        @Override // com.baidu.tieba.k18
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.U.b(i, this.a.V);
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
                this.a.u.M();
                this.a.f.q();
                this.a.n0();
                if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof RecommendFrsControlFragment.n)) {
                    return;
                }
                this.a.m0((RecommendFrsControlFragment.n) customResponsedMessage.getData());
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
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.O != null) {
                this.a.O.h();
                this.a.O = null;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.h && customResponsedMessage.getCmd() == 2921751) {
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setSecondCurTab(scrollFragmentTabHost.i, this.a.j, this.a.k);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
                this.a.u.a0();
                this.a.u.Y();
                this.a.n.setAdapter(this.a.u);
                this.a.f.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (GlobalBuildConfig.getHomepageTestBtnType() == 1) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{"http://fans.baidu.com/fanstest/wapindex?product_id=1002&version=12.11.0.11&client_type=android&contact_way=qq"});
                } else if (GlobalBuildConfig.getHomepageTestBtnType() == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921569));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        public r(ScrollFragmentTabHost scrollFragmentTabHost) {
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
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                if (bdImage != null && this.a.B != null) {
                    if (bdImage.getRawBitmap() == null) {
                        this.a.r0();
                    }
                    this.a.B.setImageBitmap(bdImage.getRawBitmap());
                    return;
                }
                this.a.r0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class s {
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

        public s() {
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
    public static class u implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ScrollFragmentTabHost> a;

        public u(ScrollFragmentTabHost scrollFragmentTabHost) {
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
                boolean e0 = scrollFragmentTabHost.e0();
                TiebaStatic.log(new StatisticItem("c12350").param("obj_type", e0 ? 1 : 0));
                if (e0 && scrollFragmentTabHost.u != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                    scrollFragmentTabHost.u.U();
                }
            }
            scrollFragmentTabHost.p0(i);
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
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (scrollFragmentTabHost = this.a.get()) != null) {
                scrollFragmentTabHost.l = true;
                if (scrollFragmentTabHost.u == null) {
                    return;
                }
                if (scrollFragmentTabHost.v != null) {
                    scrollFragmentTabHost.v.a(i);
                }
                scrollFragmentTabHost.y0(i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
                int x = scrollFragmentTabHost.u.x(scrollFragmentTabHost.n.getCurrentItem());
                if (x == 5) {
                    if (scrollFragmentTabHost.z) {
                        scrollFragmentTabHost.z = false;
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c13740");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("obj_type", 0);
                        statisticItem.eventStat();
                    }
                    if (scrollFragmentTabHost.f.o()) {
                        scrollFragmentTabHost.f.m();
                    }
                }
                if (x == 0) {
                    scrollFragmentTabHost.S();
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
                        for (s sVar : scrollFragmentTabHost.x) {
                            sVar.c();
                        }
                    } else if (x2 == 1) {
                        scrollFragmentTabHost.setScrollShadow(false);
                        for (s sVar2 : scrollFragmentTabHost.x) {
                            sVar2.b();
                        }
                    } else if (x2 == 0) {
                        scrollFragmentTabHost.setScrollShadow(false);
                        for (s sVar3 : scrollFragmentTabHost.x) {
                            sVar3.a();
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
                            SharedPrefHelper.getInstance().putLong(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        SharedPrefHelper.getInstance().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                }
                scrollFragmentTabHost.n0();
            }
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

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null) {
                return false;
            }
            return newScrollFragmentAdapter.k();
        }
        return invokeV.booleanValue;
    }

    public void S() {
        us6 us6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (us6Var = this.w) != null) {
            us6Var.h();
        }
    }

    public void T() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.l();
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null || newScrollFragmentAdapter.getCount() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.p.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f != null && (newScrollFragmentAdapter = this.u) != null && newScrollFragmentAdapter.E()) {
                return this.f.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (newScrollFragmentAdapter = this.u) != null && !HomePageStatic.a) {
            this.n.setAdapter(newScrollFragmentAdapter);
            this.f.q();
            this.U.a(this.V);
        }
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
                return ((PersonalizeWrapperFragment) this.u.o()).W1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i18
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

    @Override // com.baidu.tieba.i18
    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.m;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void i0() {
        FixedAppBarLayout fixedAppBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (fixedAppBarLayout = this.N) != null) {
            fixedAppBarLayout.o();
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.t();
            }
            FixedAppBarLayout fixedAppBarLayout = this.N;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.p();
            }
        }
    }

    public void k0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048613, this) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        newScrollFragmentAdapter.y(this.W);
    }

    public void o0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.L();
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

    public final void q0() {
        FixedAppBarLayout fixedAppBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (fixedAppBarLayout = this.N) != null) {
            fixedAppBarLayout.setImageBackgroundVisibility(0);
            this.N.setImageDrawable(SkinManager.getDrawable(R.drawable.color_header_bg));
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
        this.D = new j(this, 2921653);
        this.E = new k(this, 2921400);
        this.F = new l(this, 2921415);
        this.G = new m(this, 2921501);
        this.I = new n(this, 2921502);
        this.J = new o(this, 2921751);
        this.K = new p(this, 2921509);
        this.L = new q(this);
        this.M = new r(this);
        this.Q = new a(this, 2001371);
        this.R = new Object();
        this.S = new b(this, d18.class);
        this.f1117T = new f(this);
        this.U = new q18();
        this.V = new h(this);
        this.W = new i(this);
        a0();
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
        this.D = new j(this, 2921653);
        this.E = new k(this, 2921400);
        this.F = new l(this, 2921415);
        this.G = new m(this, 2921501);
        this.I = new n(this, 2921502);
        this.J = new o(this, 2921751);
        this.K = new p(this, 2921509);
        this.L = new q(this);
        this.M = new r(this);
        this.Q = new a(this, 2001371);
        this.R = new Object();
        this.S = new b(this, d18.class);
        this.f1117T = new f(this);
        this.U = new q18();
        this.V = new h(this);
        this.W = new i(this);
        a0();
    }

    public final void A0(String str, int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, str, i2) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        newScrollFragmentAdapter.Q(str, i2);
        n0();
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

    public void w0(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048640, this, dataRes, z) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.W(dataRes, z);
        }
    }

    public final void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", V(i2));
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    @Nullable
    public final ng5 U(ng5 ng5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ng5Var)) == null) {
            if (ng5Var != null && ng5Var.o()) {
                return ng5Var.n(W(this.n.getCurrentItem()));
            }
            return ng5Var;
        }
        return (ng5) invokeL.objValue;
    }

    public final int W(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null) {
                return 0;
            }
            return newScrollFragmentAdapter.C(i2);
        }
        return invokeI.intValue;
    }

    public String X(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            return this.u.t(i2);
        }
        return (String) invokeI.objValue;
    }

    public String Y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null) {
                return "";
            }
            return newScrollFragmentAdapter.u(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.i18
    public void b(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sVar) == null) {
            if (this.x == null) {
                this.x = new ArrayList();
            }
            this.x.add(sVar);
        }
    }

    @Override // com.baidu.tieba.i18
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

    @Override // com.baidu.tieba.i18
    public void e(s sVar) {
        List<s> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, sVar) == null) && (list = this.x) != null && list.size() > 0) {
            this.x.remove(sVar);
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

    @Override // com.baidu.tieba.i18
    public void setOnTabSelectedListener(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, tVar) == null) {
            this.v = tVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bdUniqueId) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.r = z;
            if (z && (view2 = this.o) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048635, this, z) == null) && this.f != null && (newScrollFragmentAdapter = this.u) != null && newScrollFragmentAdapter.E()) {
            this.f.setShowConcernRedTip(z);
        }
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, str) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.S(str);
        }
    }

    public void v0(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048639, this, z) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.T(z);
        }
    }

    public final void y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            qja b2 = lla.a().b().b();
            b2.a = Y(i2);
            b2.c = d(i2);
            b2.d = X(i2);
            b2.b = i2;
        }
    }

    public void c0(FragmentManager fragmentManager, h18 h18Var, ConcernPageView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, fragmentManager, h18Var, sVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.c = fragmentManager;
                this.d = h18Var;
                this.e = sVar;
                O();
            } finally {
                TTIStats.record("ScrollFragmentTabHost.initViewPager", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void x0(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048641, this, str, i2, i3) == null) && this.n != null && this.u != null) {
            if (i2 == -1) {
                BdUtilHelper.showToast(this.a, (int) R.string.obfuscated_res_0x7f0f0e29);
            }
            this.u.X(str, i2, i3);
        }
    }

    public void z0(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.Z(dataRes, z, z2);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.c == null) {
            return;
        }
        kia.a("ScrollFragmentTabHost attachAdapter");
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
        y0(s2);
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048637, this) != null) || !TbadkCoreApplication.isLogin()) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
        int i2 = 0;
        if (newScrollFragmentAdapter != null) {
            i2 = newScrollFragmentAdapter.s(0);
        }
        if (this.w == null) {
            us6 us6Var = new us6(this.b, this.f.l(i2));
            this.w = us6Var;
            us6Var.L(R.drawable.bg_tip_blue_up_left);
            this.w.o(16);
            this.w.x(true);
            this.w.Q(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
            this.w.N(true);
            this.w.n(4000);
        }
        this.w.T(this.a.getString(R.string.obfuscated_res_0x7f0f04bf), "key_concern_forum_tab_tips_show");
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            int i2 = 0;
            if (SharedPrefHelper.getInstance().getInt("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                i2 = newScrollFragmentAdapter.s(0);
            }
            if (this.w == null) {
                us6 us6Var = new us6(this.b, this.f.l(i2));
                this.w = us6Var;
                us6Var.L(R.drawable.bg_tip_blue_up);
                this.w.o(32);
                this.w.x(true);
                this.w.N(true);
                this.w.R(BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f0701be));
                this.w.n(4000);
            }
            this.w.U(this.a.getString(R.string.obfuscated_res_0x7f0f04c0), "key_concern_tab_tips", true);
        }
    }

    public final void P(ng5 ng5Var) {
        String h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ng5Var) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str = null;
            if (ng5Var != null) {
                if (skinType != 0) {
                    if (skinType != 4) {
                        h2 = null;
                    } else {
                        str = ng5Var.m();
                        h2 = ng5Var.i();
                    }
                } else {
                    str = ng5Var.l();
                    h2 = ng5Var.h();
                }
                this.N.setTag(R.id.obfuscated_res_0x7f090f85, str);
                if (TextUtils.isEmpty(str)) {
                    this.N.setImageBackgroundVisibility(8);
                    this.N.setBackgroundColor(gea.f(h2));
                } else {
                    this.N.setImageBackgroundVisibility(0);
                    q0();
                    BdResourceLoader.getInstance().loadResource(str, 10, this.f1117T, this.b.getUniqueId());
                }
                s0(skinType, ng5Var.p());
                return;
            }
            this.N.setTag(R.id.obfuscated_res_0x7f090f85, null);
            q0();
            s0(skinType, true);
        }
    }

    public void b0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.g = new dx5(tbPageContext.getPageActivity());
            MessageManager.getInstance().registerListener(this.E);
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.I);
            MessageManager.getInstance().registerListener(this.G);
            MessageManager.getInstance().registerListener(this.Q);
            MessageManager.getInstance().registerListener(this.K);
            MessageManager.getInstance().registerListener(this.J);
            MessageManager.getInstance().registerListener(this.D);
            dt6.b().a(this.R, this.S);
        }
    }

    public final void Q(String str, ng5 ng5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, ng5Var) == null) {
            if (ng5Var != null) {
                if (!StringUtils.isNull(ng5Var.c())) {
                    this.A.setVisibility(0);
                    e18.h(ng5Var, this.B, this.C, this.M, this.b.getUniqueId());
                } else if (!StringUtils.isNull(ng5Var.a())) {
                    this.A.setVisibility(0);
                    e18.g(ng5Var, this.B, this.C);
                }
            } else {
                r0();
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.I(str);
            }
        }
    }

    public final void s0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
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

    @Override // com.baidu.tieba.i18
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || !this.r || d0()) {
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

    @Override // com.baidu.tieba.i18
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !this.r || !d0()) {
            return;
        }
        if (this.t == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.t = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.t.setDuration(300L);
            this.t.setAnimationListener(new g(this));
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

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
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

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            kia.a("ScrollFragmentTabHost init");
            SpeedStatsManager.getInstance().addStatsTimeStamp(4006);
            this.a = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d087d, (ViewGroup) this, true);
            this.A = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090758);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09075a);
            this.B = tbImageView;
            tbImageView.setUseNightOrDarkMask(false);
            this.B.setNeedNightShade(false);
            this.C = findViewById(R.id.obfuscated_res_0x7f090759);
            FixedAppBarLayout fixedAppBarLayout = new FixedAppBarLayout(this.a);
            this.N = fixedAppBarLayout;
            addView(fixedAppBarLayout, 2);
            lia.c(this.N, 3);
            this.f = (HomeTabBarView) findViewById(R.id.obfuscated_res_0x7f090f8b);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090f89);
            this.m = frameLayout;
            lia.c(frameLayout, 4);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f092390);
            this.n = customViewPager;
            customViewPager.setForm(1);
            this.o = findViewById(R.id.obfuscated_res_0x7f09090d);
            this.p = findViewById(R.id.obfuscated_res_0x7f09091b);
            this.q = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090f90);
            if (GlobalBuildConfig.getHomepageTestBtnType() == 1) {
                da5 da5Var = new da5();
                this.q.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09f3));
                this.q.setTextSize(R.dimen.tbds42);
                this.q.setConfig(da5Var);
                this.q.setOnClickListener(this.L);
                this.q.setVisibility(0);
            } else if (GlobalBuildConfig.getHomepageTestBtnType() == 2) {
                da5 da5Var2 = new da5();
                this.q.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09f4));
                this.q.setTextSize(R.dimen.tbds35);
                this.q.setConfig(da5Var2);
                this.q.setOnClickListener(this.L);
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            this.P = (fz7) in5.e().d(1012, new c(this));
            this.f.setOnPageChangeListener(new u(this));
            this.f.setOnTabItemClickListener(new d(this));
            SpeedStatsManager.getInstance().addStatsTimeStamp(4007);
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.r();
            }
            if (this.n != null) {
                n0();
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.K(i2);
            }
            fz7 fz7Var = this.P;
            if (fz7Var != null) {
                fz7Var.j(i2);
            }
            SkinManager.setBackgroundResource(this.p, R.drawable.personalize_tab_shadow);
        }
    }

    public final void m0(RecommendFrsControlFragment.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, nVar) != null) || nVar == null) {
            return;
        }
        kia.a("ScrollFragmentTabHost recoverSelectedTab:" + nVar.b() + " SecondTab:" + nVar.a());
        SafeHandler.getInst().post(new e(this, nVar));
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            us6 us6Var = this.O;
            if (us6Var != null) {
                us6Var.h();
                this.O = null;
            }
            FixedAppBarLayout fixedAppBarLayout = this.N;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.n();
            }
            S();
            MessageManager.getInstance().unRegisterListener(this.Q);
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.D);
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.s();
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.onDestroy();
            }
            dt6.b().unregister(this.R);
        }
    }

    public final void l0() {
        HashMap<String, ng5> colourHeaderConfig;
        String l2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) != null) {
            for (ng5 ng5Var : colourHeaderConfig.values()) {
                if (ng5Var != null) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType != 0) {
                        if (skinType != 4) {
                            l2 = null;
                        } else {
                            l2 = ng5Var.m();
                        }
                    } else {
                        l2 = ng5Var.l();
                    }
                    BdResourceLoader.getInstance().loadResource(l2, 10, null, this.b.getUniqueId());
                }
            }
        }
    }

    public final void n0() {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || !this.l || this.N == null || this.g == null || (customViewPager = this.n) == null) {
            return;
        }
        String Y = Y(customViewPager.getCurrentItem());
        HashMap<String, ng5> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
        ng5 ng5Var = null;
        if (colourHeaderConfig != null) {
            ng5Var = colourHeaderConfig.get(Y);
        }
        ng5 U = U(ng5Var);
        P(U);
        Q(Y, U);
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

    public final void p0(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048622, this, i2) == null) && this.b != null && (newScrollFragmentAdapter = this.u) != null && (customViewPager = this.n) != null) {
            String t2 = newScrollFragmentAdapter.t(customViewPager.getCurrentItem());
            f18 f18Var = new f18();
            f18Var.b = t2;
            f18Var.c = i2;
            CustomMessage customMessage = new CustomMessage(2921652);
            customMessage.setTag(this.b.getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921652, f18Var);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void setCurrentTab(int i2, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 >= 0 && (newScrollFragmentAdapter = this.u) != null && i2 < newScrollFragmentAdapter.getCount()) {
            this.f.setTabItemClicked(z);
            this.u.R(i2);
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
        if (interceptable == null || interceptable.invokeILL(1048634, this, i2, str, str2) == null) {
            if (this.u.z(str2) == this.u.B() && (this.u.o() instanceof PersonalizeWrapperFragment)) {
                PersonalizeWrapperFragment personalizeWrapperFragment = (PersonalizeWrapperFragment) this.u.o();
                if (i2 != -1) {
                    personalizeWrapperFragment.b2(i2);
                } else if (!TextUtils.isEmpty(str)) {
                    personalizeWrapperFragment.a2(str);
                } else if (!TextUtils.isEmpty(str2)) {
                    personalizeWrapperFragment.Z1(str2);
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
