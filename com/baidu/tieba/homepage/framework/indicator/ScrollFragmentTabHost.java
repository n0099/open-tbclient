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
import com.baidu.tieba.aa7;
import com.baidu.tieba.bf6;
import com.baidu.tieba.ej;
import com.baidu.tieba.gh;
import com.baidu.tieba.h75;
import com.baidu.tieba.ha5;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.RecommendFrsControlFragment;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.lz8;
import com.baidu.tieba.m45;
import com.baidu.tieba.mp5;
import com.baidu.tieba.on;
import com.baidu.tieba.p35;
import com.baidu.tieba.q39;
import com.baidu.tieba.q97;
import com.baidu.tieba.qa7;
import com.baidu.tieba.r97;
import com.baidu.tieba.sv4;
import com.baidu.tieba.t97;
import com.baidu.tieba.tf5;
import com.baidu.tieba.u97;
import com.baidu.tieba.w97;
import com.baidu.tieba.x97;
import com.baidu.tieba.yg;
import com.baidu.tieba.z77;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
public class ScrollFragmentTabHost extends CoordinatorLayout implements u97 {
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
    public yg<on> M;
    @Nullable
    public FixedAppBarLayout N;
    public bf6 O;
    public z77 P;
    public CustomMessageListener Q;
    public yg<on> R;
    public aa7 S;
    public x97 T;
    public w97 U;
    public Context a;
    public TbPageContext b;
    public FragmentManager c;
    public t97 d;
    public ConcernPageView.o e;
    public HomeTabBarView f;
    public mp5 g;
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
    public bf6 w;
    public List<s> x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public interface t {
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

    @Override // com.baidu.tieba.u97
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
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
                String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02b9);
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                LinearLayout linearLayout = (LinearLayout) this.a.f.l(0);
                if (intValue == 1) {
                    if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                        TextView textView = (TextView) linearLayout.getChildAt(0);
                        if (string2.equals(textView.getText())) {
                            int measuredWidth = textView.getMeasuredWidth();
                            textView.setText(string);
                            int measureText = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.attention_person));
                            int measureText2 = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02b9));
                            if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                                ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                                ofInt.setDuration(360L);
                                ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                                ofInt.start();
                            }
                        }
                        p35.m().z("key_home_concern_all_status", 1);
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
                    p35.m().z("key_home_concern_all_status", 0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                        this.a.m0();
                    }
                }
                String q = p35.q("key_new_hot_topic_update_time");
                h75 hotNotifyConfig = TbSingleton.getInstance().getHotNotifyConfig();
                if (hotNotifyConfig != null && qa7.b(4320000L) && qa7.a(hotNotifyConfig.b(), q)) {
                    this.a.f.setHotLabelData(hotNotifyConfig);
                }
                this.a.f0();
                this.a.setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements tf5.b {
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

        @Override // com.baidu.tieba.tf5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new z77(this.a.a);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewPager.OnPageChangeListener {
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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    this.a.l = false;
                }
                if (i == 0 && this.a.getCurrentTabType() == 0) {
                    boolean Z = this.a.Z();
                    TiebaStatic.log(new StatisticItem("c12350").param("obj_type", Z ? 1 : 0));
                    if (Z && this.a.u != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        this.a.u.N();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
                this.a.i0(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) || this.a.u == null) {
                return;
            }
            TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.T(i));
            this.a.u.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) {
                return;
            }
            this.a.l = true;
            if (this.a.u == null) {
                return;
            }
            if (this.a.v != null) {
                this.a.v.a(i);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            int s = this.a.u.s(this.a.n.getCurrentItem());
            if (s == 5) {
                if (!this.a.z) {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 0);
                    statisticItem.eventStat();
                } else {
                    this.a.z = false;
                }
                if (this.a.f.o()) {
                    this.a.f.m();
                }
            }
            if (s == 0) {
                this.a.Q();
            }
            View l = this.a.f.l(0);
            if ((l instanceof LinearLayout) && TbadkCoreApplication.isLogin() && UbsABTestHelper.isConcernForumCardShow()) {
                LinearLayout linearLayout = (LinearLayout) l;
                if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (s == 0) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                }
            }
            if (this.a.x != null && this.a.u != null) {
                int s2 = this.a.u.s(this.a.n.getCurrentItem());
                if (s2 == 5) {
                    this.a.setScrollShadow(false);
                    for (s sVar : this.a.x) {
                        sVar.c();
                    }
                } else if (s2 == 1) {
                    this.a.setScrollShadow(false);
                    for (s sVar2 : this.a.x) {
                        sVar2.b();
                    }
                } else if (s2 == 0) {
                    this.a.setScrollShadow(false);
                    for (s sVar3 : this.a.x) {
                        sVar3.a();
                    }
                } else if (s2 == 6) {
                    this.a.setScrollShadow(true);
                } else if (s2 == 7) {
                    this.a.setScrollShadow(true);
                } else if (s2 == 8) {
                    this.a.setScrollShadow(false);
                } else {
                    this.a.c();
                    this.a.setScrollShadow(false);
                }
            }
            TbadkCoreApplication.getInst().setHomeBarShowType(this.a.d(i));
            TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.T(i));
            if (this.a.d(i) == 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        p35.m().A(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    p35.m().A("unlogin_hot_top_timestamp", currentTimeMillis);
                }
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.T(i));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PagerSlidingTabStrip.d {
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
                        p35.m().A(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    p35.m().A("unlogin_hot_top_timestamp", currentTimeMillis);
                }
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.T(i));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendFrsControlFragment.o a;
        public final /* synthetic */ ScrollFragmentTabHost b;

        public e(ScrollFragmentTabHost scrollFragmentTabHost, RecommendFrsControlFragment.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentTabHost, oVar};
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
            this.a = oVar;
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

    /* loaded from: classes4.dex */
    public class f extends yg<on> {
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
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                if (this.a.N != null && onVar != null) {
                    if (onVar.p() != null) {
                        this.a.N.setImageBackground(onVar.p());
                        return;
                    } else {
                        this.a.j0();
                        return;
                    }
                }
                this.a.j0();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class h implements x97 {
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

        @Override // com.baidu.tieba.x97
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.u == null) {
                return;
            }
            this.a.setCurrentTab(this.a.u.p(i), false);
            this.a.u.D(i);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements w97 {
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

        @Override // com.baidu.tieba.w97
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.S.b(i, this.a.T);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.N();
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof RecommendFrsControlFragment.o)) {
                return;
            }
            this.a.g0((RecommendFrsControlFragment.o) customResponsedMessage.getData());
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                this.a.u.S();
                this.a.u.Q();
                this.a.n.setAdapter(this.a.u);
                this.a.f.q();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (sv4.b() == 1) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{"http://fans.baidu.com/fanstest/wapindex?product_id=1002&version=12.11.0.11&client_type=android&contact_way=qq"});
                } else if (sv4.b() == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921569));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends yg<on> {
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
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                if (onVar != null && this.a.B != null) {
                    if (onVar.p() == null) {
                        this.a.k0();
                    }
                    this.a.B.setImageBitmap(onVar.p());
                    return;
                }
                this.a.k0();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            return newScrollFragmentAdapter.h();
        }
        return invokeV.booleanValue;
    }

    public void Q() {
        bf6 bf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bf6Var = this.w) != null) {
            bf6Var.h();
        }
    }

    public void R() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.i();
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null || newScrollFragmentAdapter.getCount() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.p.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f != null && (newScrollFragmentAdapter = this.u) != null && newScrollFragmentAdapter.y()) {
                return this.f.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (newScrollFragmentAdapter = this.u) != null && !HomePageStatic.a) {
            this.n.setAdapter(newScrollFragmentAdapter);
            this.f.q();
            this.S.a(this.T);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.t();
            }
            FixedAppBarLayout fixedAppBarLayout = this.N;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.m();
            }
        }
    }

    public void e0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        newScrollFragmentAdapter.t(this.U);
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
                return newScrollFragmentAdapter.m();
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
            if (newScrollFragmentAdapter != null && (newScrollFragmentAdapter.l() instanceof PersonalizeWrapperFragment)) {
                return ((PersonalizeWrapperFragment) this.u.l()).E1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u97
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null) {
                return 0;
            }
            return newScrollFragmentAdapter.s(this.n.getCurrentItem());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.u97
    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.m;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void h0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.F();
        }
    }

    public final void j0() {
        FixedAppBarLayout fixedAppBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (fixedAppBarLayout = this.N) != null) {
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
        this.R = new f(this);
        this.S = new aa7();
        this.T = new h(this);
        this.U = new i(this);
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorHead(String str) {
        ha5 ha5Var;
        String j2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65564, this, str) != null) || !this.l) {
            return;
        }
        mp5 mp5Var = this.g;
        if (mp5Var != null) {
            mp5Var.c(false);
        }
        if (this.N != null && this.g != null) {
            HashMap<String, ha5> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
            String str2 = null;
            if (colourHeaderConfig != null) {
                ha5Var = colourHeaderConfig.get(str);
            } else {
                ha5Var = null;
            }
            O(str, ha5Var);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (ha5Var != null) {
                if (skinType != 0) {
                    if (skinType != 1) {
                        if (skinType != 4) {
                            j2 = null;
                        } else {
                            str2 = ha5Var.n();
                            j2 = ha5Var.k();
                        }
                    } else {
                        str2 = ha5Var.o();
                        j2 = ha5Var.l();
                    }
                } else {
                    str2 = ha5Var.m();
                    j2 = ha5Var.j();
                }
                if (TextUtils.isEmpty(str2)) {
                    this.N.setImageBackgroundVisibility(8);
                    this.N.setBackgroundColor(lz8.f(j2));
                } else {
                    this.N.setImageBackgroundVisibility(0);
                    zg.h().m(str2, 10, this.R, this.b.getUniqueId());
                }
                l0(skinType, ha5Var.p());
                return;
            }
            j0();
            l0(skinType, true);
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
        this.R = new f(this);
        this.S = new aa7();
        this.T = new h(this);
        this.U = new i(this);
        V();
    }

    public void O(String str, ha5 ha5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ha5Var) == null) {
            boolean z = false;
            if (ha5Var != null) {
                if (!StringUtils.isNull(ha5Var.d())) {
                    this.A.setVisibility(0);
                    q97.h(ha5Var, this.B, this.C, this.M, this.b.getUniqueId());
                } else if (!StringUtils.isNull(ha5Var.a())) {
                    this.A.setVisibility(0);
                    q97.g(ha5Var, this.B, this.C);
                }
            } else {
                k0();
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.C(str);
            }
            if (getResources().getString(R.string.obfuscated_res_0x7f0f141d).equals(str) || getResources().getString(R.string.obfuscated_res_0x7f0f0272).equals(TbadkCoreApplication.getInst().getHomeBarShowTabName())) {
                MessageManager messageManager = MessageManager.getInstance();
                if (this.A.getVisibility() == 0) {
                    z = true;
                }
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921722, Boolean.valueOf(z)));
            }
        }
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
            return this.u.r(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.u97
    public void b(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sVar) == null) {
            if (this.x == null) {
                this.x = new ArrayList();
            }
            this.x.add(sVar);
        }
    }

    @Override // com.baidu.tieba.u97
    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            return this.u.s(i2);
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

    @Override // com.baidu.tieba.u97
    public void e(s sVar) {
        List<s> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, sVar) == null) && (list = this.x) != null && list.size() > 0) {
            this.x.remove(sVar);
        }
    }

    public final void g0(RecommendFrsControlFragment.o oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, oVar) != null) || oVar == null) {
            return;
        }
        gh.a().post(new e(this, oVar));
    }

    public void o0(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.M(z);
        }
    }

    @Override // com.baidu.tieba.u97
    public void setCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048625, this, i2) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.p(i2), false);
        setSecondCurTab(i2, "", "");
    }

    public void setCurrentTabByCode(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, str) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.u(str), false);
        setSecondCurTab(-1, "", str);
    }

    public void setFakeClickCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048629, this, i2) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.p(i2), true);
    }

    @Override // com.baidu.tieba.u97
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
                newScrollFragmentAdapter.H(z);
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
        if ((interceptable == null || interceptable.invokeZ(1048635, this, z) == null) && this.f != null && (newScrollFragmentAdapter = this.u) != null && newScrollFragmentAdapter.y()) {
            this.f.setShowConcernRedTip(z);
        }
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, str) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.L(str);
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

    public void p0(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048622, this, dataRes, z) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.O(dataRes, z);
        }
    }

    public final void N() {
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (fragmentManager = this.c) == null) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.a, fragmentManager, false, this.d, this.e);
        this.u = newScrollFragmentAdapter;
        newScrollFragmentAdapter.J(this);
        this.n.setOffscreenPageLimit(2);
        this.n.setAdapter(this.u);
        int n2 = this.u.n();
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.u;
        if (HomePageStatic.a) {
            n2 = 0;
        }
        this.n.setCurrentItem(newScrollFragmentAdapter2.p(n2));
        this.f.setViewPager(this.n);
        this.f.q();
        this.f.setConcernTabIndex(this.u.p(0));
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            bf6 bf6Var = this.O;
            if (bf6Var != null) {
                bf6Var.h();
                this.O = null;
            }
            FixedAppBarLayout fixedAppBarLayout = this.N;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.l();
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

    public final void f0() {
        HashMap<String, ha5> colourHeaderConfig;
        String m2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) != null) {
            for (ha5 ha5Var : colourHeaderConfig.values()) {
                if (ha5Var != null) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType != 0) {
                        if (skinType != 1) {
                            if (skinType != 4) {
                                m2 = null;
                            } else {
                                m2 = ha5Var.n();
                            }
                        } else {
                            m2 = ha5Var.o();
                        }
                    } else {
                        m2 = ha5Var.m();
                    }
                    zg.h().m(m2, 10, null, this.b.getUniqueId());
                }
            }
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4006);
            this.a = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07b4, (ViewGroup) this, true);
            this.A = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0906b0);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0906b2);
            this.B = tbImageView;
            tbImageView.setUseNightOrDarkMask(false);
            this.B.setNeedNightShade(false);
            this.C = findViewById(R.id.obfuscated_res_0x7f0906b1);
            FixedAppBarLayout fixedAppBarLayout = new FixedAppBarLayout(this.a);
            this.N = fixedAppBarLayout;
            addView(fixedAppBarLayout, 2);
            q39.c(this.N, 3);
            this.f = (HomeTabBarView) findViewById(R.id.obfuscated_res_0x7f090e7a);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090e78);
            this.m = frameLayout;
            q39.c(frameLayout, 4);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f09212b);
            this.n = customViewPager;
            customViewPager.setForm(1);
            this.o = findViewById(R.id.obfuscated_res_0x7f090855);
            this.p = findViewById(R.id.obfuscated_res_0x7f090862);
            this.q = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090e7f);
            if (sv4.b() == 1) {
                m45 m45Var = new m45();
                this.q.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08fb));
                this.q.setTextSize(R.dimen.tbds42);
                this.q.setConfig(m45Var);
                this.q.setOnClickListener(this.L);
                this.q.setVisibility(0);
            } else if (sv4.b() == 2) {
                m45 m45Var2 = new m45();
                this.q.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08fc));
                this.q.setTextSize(R.dimen.tbds35);
                this.q.setConfig(m45Var2);
                this.q.setOnClickListener(this.L);
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            this.P = (z77) tf5.e().d(1012, new b(this));
            this.f.setOnPageChangeListener(new c(this));
            this.f.setOnTabItemClickListener(new d(this));
            SpeedStatsManager.getInstance().addStatsTimeStamp(4007);
        }
    }

    public void W(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.g = new mp5(tbPageContext.getPageActivity());
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

    public void X(FragmentManager fragmentManager, t97 t97Var, ConcernPageView.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, fragmentManager, t97Var, oVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.c = fragmentManager;
                this.d = t97Var;
                this.e = oVar;
                N();
            } finally {
                TTIStats.record("ScrollFragmentTabHost.initViewPager", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void q0(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048623, this, str, i2, i3) == null) && this.n != null && this.u != null) {
            if (i2 == -1) {
                ej.P(this.a, R.string.obfuscated_res_0x7f0f0cfe);
            }
            this.u.P(str, i2, i3);
        }
    }

    public void r0(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.R(dataRes, z, z2);
        }
    }

    @Override // com.baidu.tieba.u97
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || !this.r || Y()) {
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

    @Override // com.baidu.tieba.u97
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !this.r || !Y()) {
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
                    if (this.u.s(i2) == 8) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
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

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.r();
            }
            setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.E(i2);
            }
            z77 z77Var = this.P;
            if (z77Var != null) {
                z77Var.j(i2);
            }
            SkinManager.setBackgroundResource(this.p, R.drawable.personalize_tab_shadow);
        }
    }

    public final void i0(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i2) == null) && this.b != null && (newScrollFragmentAdapter = this.u) != null && (customViewPager = this.n) != null) {
            String q2 = newScrollFragmentAdapter.q(customViewPager.getCurrentItem());
            r97 r97Var = new r97();
            r97Var.b = q2;
            r97Var.c = i2;
            CustomMessage customMessage = new CustomMessage(2921652);
            customMessage.setTag(this.b.getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921652, r97Var);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void l0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
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

    public void m0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || !TbadkCoreApplication.isLogin()) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
        int i2 = 0;
        if (newScrollFragmentAdapter != null) {
            i2 = newScrollFragmentAdapter.p(0);
        }
        if (this.w == null) {
            bf6 bf6Var = new bf6(this.b, this.f.l(i2));
            this.w = bf6Var;
            bf6Var.L(R.drawable.bg_tip_blue_up_left);
            this.w.o(16);
            this.w.x(true);
            this.w.Q(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
            this.w.N(true);
            this.w.n(4000);
        }
        this.w.T(this.a.getString(R.string.obfuscated_res_0x7f0f0455), "key_concern_forum_tab_tips_show");
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            int i2 = 0;
            if (p35.m().n("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                i2 = newScrollFragmentAdapter.p(0);
            }
            if (this.w == null) {
                bf6 bf6Var = new bf6(this.b, this.f.l(i2));
                this.w = bf6Var;
                bf6Var.L(R.drawable.bg_tip_blue_up);
                this.w.o(32);
                this.w.x(true);
                this.w.N(true);
                this.w.R(ej.g(this.a, R.dimen.obfuscated_res_0x7f0701be));
                this.w.n(4000);
            }
            this.w.U(this.a.getString(R.string.obfuscated_res_0x7f0f0456), "key_concern_tab_tips", true);
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
        if ((interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 >= 0 && (newScrollFragmentAdapter = this.u) != null && i2 < newScrollFragmentAdapter.getCount()) {
            this.f.setTabItemClicked(z);
            this.u.K(i2);
            this.n.setCurrentItem(i2);
        }
    }

    public void setCurrentTab(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, str) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.v(str), false);
        setSecondCurTab(-1, str, "");
    }

    public void setSecondCurTab(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048634, this, i2, str, str2) == null) {
            if (this.u.u(str2) == this.u.w() && (this.u.l() instanceof PersonalizeWrapperFragment)) {
                PersonalizeWrapperFragment personalizeWrapperFragment = (PersonalizeWrapperFragment) this.u.l();
                if (i2 != -1) {
                    personalizeWrapperFragment.J1(i2);
                } else if (!TextUtils.isEmpty(str)) {
                    personalizeWrapperFragment.I1(str);
                } else if (!TextUtils.isEmpty(str2)) {
                    personalizeWrapperFragment.H1(str2);
                }
            } else if (this.u.l() == null) {
                this.h = true;
                this.i = i2;
                this.k = str2;
                this.j = str;
            }
        }
    }
}
