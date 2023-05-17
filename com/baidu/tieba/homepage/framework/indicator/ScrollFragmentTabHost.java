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
import com.baidu.tieba.aj5;
import com.baidu.tieba.an6;
import com.baidu.tieba.ar7;
import com.baidu.tieba.cn;
import com.baidu.tieba.cr7;
import com.baidu.tieba.cu9;
import com.baidu.tieba.dr7;
import com.baidu.tieba.du9;
import com.baidu.tieba.ev9;
import com.baidu.tieba.ex9;
import com.baidu.tieba.fr7;
import com.baidu.tieba.gr7;
import com.baidu.tieba.gt5;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.RecommendFrsControlFragment;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.hp7;
import com.baidu.tieba.ia5;
import com.baidu.tieba.jr7;
import com.baidu.tieba.jx4;
import com.baidu.tieba.kg;
import com.baidu.tieba.ld5;
import com.baidu.tieba.lg;
import com.baidu.tieba.m75;
import com.baidu.tieba.o65;
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
import com.baidu.tieba.wp9;
import com.baidu.tieba.zq7;
import com.baidu.tieba.zr7;
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
/* loaded from: classes5.dex */
public class ScrollFragmentTabHost extends CoordinatorLayout implements dr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public FrameLayout B;
    public TbImageView C;
    public View D;
    public final CustomMessageListener E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public CustomMessageListener H;
    public boolean I;
    public CustomMessageListener J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public View.OnClickListener M;
    public kg<cn> N;
    @Nullable
    public FixedAppBarLayout O;
    public an6 P;
    public hp7 Q;
    public CustomMessageListener R;
    public kg<cn> S;
    public jr7 T;
    public gr7 U;
    public fr7 V;
    public Context a;
    public TbPageContext b;
    public FragmentManager c;
    public cr7 d;
    public ConcernPageView.s e;
    public HomeTabBarView f;
    public gt5 g;
    public boolean h;
    public int i;
    public String j;
    public String k;
    public boolean l;
    public int m;
    public FrameLayout n;
    public CustomViewPager o;
    public View p;
    public View q;
    public TBSpecificationBtn r;
    public boolean s;
    public AlphaAnimation t;
    public AlphaAnimation u;
    public NewScrollFragmentAdapter v;
    public s w;
    public an6 x;
    public List<r> y;
    public boolean z;

    /* loaded from: classes5.dex */
    public interface s {
        void a(int i);
    }

    public final int U(int i2) {
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

    @Override // com.baidu.tieba.dr7
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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
                        this.a.Q.k(this.a.f.getBackgroundAlpha());
                        this.a.Q.j(TbadkCoreApplication.getInst().getSkinType());
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

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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
                String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02e1);
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                LinearLayout linearLayout = (LinearLayout) this.a.f.l(0);
                if (intValue == 1) {
                    if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                        TextView textView = (TextView) linearLayout.getChildAt(0);
                        if (string2.equals(textView.getText())) {
                            int measuredWidth = textView.getMeasuredWidth();
                            textView.setText(string);
                            int measureText = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.attention_person));
                            int measureText2 = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02e1));
                            if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                                ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                                ofInt.setDuration(360L);
                                ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                                ofInt.start();
                            }
                        }
                        o65.m().z("key_home_concern_all_status", 1);
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
                    o65.m().z("key_home_concern_all_status", 0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.I != UbsABTestHelper.isConcernForumCardShow()) {
                    this.a.f.q();
                    if (UbsABTestHelper.isConcernForumCardShow() && this.a.z) {
                        this.a.S();
                        this.a.q0();
                    }
                }
                String q = o65.q("key_new_hot_topic_update_time");
                ia5 hotNotifyConfig = TbSingleton.getInstance().getHotNotifyConfig();
                if (hotNotifyConfig != null && zr7.b(4320000L) && zr7.a(hotNotifyConfig.b(), q)) {
                    this.a.f.setHotLabelData(hotNotifyConfig);
                }
                if (!zq7.m(TbSingleton.getInstance().getColourHeaderConfig(), TbSingleton.getInstance().getLastColourHeaderConfigs())) {
                    return;
                }
                this.a.j0();
                this.a.setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
                TbSingleton.getInstance().setLastColourHeaderConfigs(TbSingleton.getInstance().getColourHeaderConfig());
                this.a.v.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements aj5.b {
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

        @Override // com.baidu.tieba.aj5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new hp7(this.a.a);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            this.a.O(i);
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
                this.a.A = true;
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        o65.m().A(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    o65.m().A("unlogin_hot_top_timestamp", currentTimeMillis);
                }
            }
            if (this.a.m != i) {
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.W(i));
            }
            this.a.m = i;
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class e extends kg<cn> {
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
        @Override // com.baidu.tieba.kg
        public void onLoaded(cn cnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, cnVar, str, i) == null) {
                if (this.a.O != null && cnVar != null) {
                    if (cnVar.p() != null) {
                        Object tag = this.a.O.getTag(R.id.obfuscated_res_0x7f090f39);
                        if ((tag instanceof String) && !tag.equals(str)) {
                            return;
                        }
                        this.a.O.setImageBackground(cnVar.p());
                        return;
                    }
                    this.a.n0();
                    return;
                }
                this.a.n0();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.q.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements gr7 {
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

        @Override // com.baidu.tieba.gr7
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.v == null) {
                return;
            }
            this.a.setCurrentTab(this.a.v.s(i), false);
            this.a.v.I(i);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements fr7 {
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

        @Override // com.baidu.tieba.fr7
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.T.b(i, this.a.U);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.v.M();
                this.a.f.q();
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.W(scrollFragmentTabHost.o.getCurrentItem()));
                if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof RecommendFrsControlFragment.n)) {
                    return;
                }
                this.a.k0((RecommendFrsControlFragment.n) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.P != null) {
                this.a.P.h();
                this.a.P = null;
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.v != null && customResponsedMessage != null && customResponsedMessage.getData() != null && this.a.f != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.v.Y();
                this.a.v.W();
                this.a.o.setAdapter(this.a.v);
                this.a.f.q();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (jx4.b() == 1) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{"http://fans.baidu.com/fanstest/wapindex?product_id=1002&version=12.11.0.11&client_type=android&contact_way=qq"});
                } else if (jx4.b() == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921569));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends kg<cn> {
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
        @Override // com.baidu.tieba.kg
        public void onLoaded(cn cnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, cnVar, str, i) == null) {
                if (cnVar != null && this.a.C != null) {
                    if (cnVar.p() == null) {
                        this.a.o0();
                    }
                    this.a.C.setImageBitmap(cnVar.p());
                    return;
                }
                this.a.o0();
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                boolean c0 = scrollFragmentTabHost.c0();
                TiebaStatic.log(new StatisticItem("c12350").param("obj_type", c0 ? 1 : 0));
                if (c0 && scrollFragmentTabHost.v != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                    scrollFragmentTabHost.v.T();
                }
            }
            scrollFragmentTabHost.m0(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            ScrollFragmentTabHost scrollFragmentTabHost;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) || (scrollFragmentTabHost = this.a.get()) == null || scrollFragmentTabHost.v == null) {
                return;
            }
            TbadkCoreApplication.getInst().setHomeBarShowTabName(scrollFragmentTabHost.W(i));
            scrollFragmentTabHost.v.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ScrollFragmentTabHost scrollFragmentTabHost;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || (scrollFragmentTabHost = this.a.get()) == null) {
                return;
            }
            scrollFragmentTabHost.l = true;
            if (scrollFragmentTabHost.v == null) {
                return;
            }
            if (scrollFragmentTabHost.w != null) {
                scrollFragmentTabHost.w.a(i);
            }
            scrollFragmentTabHost.v0(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            int x = scrollFragmentTabHost.v.x(scrollFragmentTabHost.o.getCurrentItem());
            if (x == 5) {
                if (!scrollFragmentTabHost.A) {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 0);
                    statisticItem.eventStat();
                } else {
                    scrollFragmentTabHost.A = false;
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
            if (scrollFragmentTabHost.y != null && scrollFragmentTabHost.v != null) {
                int x2 = scrollFragmentTabHost.v.x(scrollFragmentTabHost.o.getCurrentItem());
                if (x2 == 5) {
                    scrollFragmentTabHost.setScrollShadow(false);
                    for (r rVar : scrollFragmentTabHost.y) {
                        rVar.c();
                    }
                } else if (x2 == 1) {
                    scrollFragmentTabHost.setScrollShadow(false);
                    for (r rVar2 : scrollFragmentTabHost.y) {
                        rVar2.b();
                    }
                } else if (x2 == 0) {
                    scrollFragmentTabHost.setScrollShadow(false);
                    for (r rVar3 : scrollFragmentTabHost.y) {
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
            TbadkCoreApplication.getInst().setHomeBarShowTabName(scrollFragmentTabHost.W(i));
            if (scrollFragmentTabHost.d(i) == 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        o65.m().A(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    o65.m().A("unlogin_hot_top_timestamp", currentTimeMillis);
                }
            }
            scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.W(i));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
            if (newScrollFragmentAdapter == null) {
                return false;
            }
            return newScrollFragmentAdapter.k();
        }
        return invokeV.booleanValue;
    }

    public void S() {
        an6 an6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (an6Var = this.x) != null) {
            an6Var.h();
        }
    }

    public void T() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (newScrollFragmentAdapter = this.v) != null) {
            newScrollFragmentAdapter.l();
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
            if (newScrollFragmentAdapter == null || newScrollFragmentAdapter.getCount() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.q.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f != null && (newScrollFragmentAdapter = this.v) != null && newScrollFragmentAdapter.D()) {
                return this.f.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (newScrollFragmentAdapter = this.v) != null && !HomePageStatic.a) {
            this.o.setAdapter(newScrollFragmentAdapter);
            this.f.q();
            this.T.a(this.U);
        }
    }

    public void g0() {
        FixedAppBarLayout fixedAppBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (fixedAppBarLayout = this.O) != null) {
            fixedAppBarLayout.n();
        }
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            CustomViewPager customViewPager = this.o;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
            if (newScrollFragmentAdapter != null && (newScrollFragmentAdapter.o() instanceof PersonalizeWrapperFragment)) {
                return ((PersonalizeWrapperFragment) this.v.o()).I1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dr7
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
            if (newScrollFragmentAdapter == null) {
                return 0;
            }
            return newScrollFragmentAdapter.x(this.o.getCurrentItem());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dr7
    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.n;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.t();
            }
            FixedAppBarLayout fixedAppBarLayout = this.O;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.o();
            }
        }
    }

    public void i0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || (newScrollFragmentAdapter = this.v) == null) {
            return;
        }
        newScrollFragmentAdapter.y(this.V);
    }

    public void l0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (newScrollFragmentAdapter = this.v) != null) {
            newScrollFragmentAdapter.K();
        }
    }

    public final void n0() {
        FixedAppBarLayout fixedAppBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (fixedAppBarLayout = this.O) != null) {
            fixedAppBarLayout.setImageBackgroundVisibility(0);
            this.O.setImageDrawable(SkinManager.getDrawable(R.drawable.color_header_bg));
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
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
        this.m = -1;
        this.A = false;
        this.E = new i(this, 2921653);
        this.F = new j(this, 2921400);
        this.G = new k(this, 2921415);
        this.H = new l(this, 2921501);
        this.J = new m(this, 2921502);
        this.K = new n(this, 2921751);
        this.L = new o(this, 2921509);
        this.M = new p(this);
        this.N = new q(this);
        this.R = new a(this, 2001371);
        this.S = new e(this);
        this.T = new jr7();
        this.U = new g(this);
        this.V = new h(this);
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorHead(String str) {
        ld5 ld5Var;
        String h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65566, this, str) == null) && this.l && this.O != null && this.g != null) {
            HashMap<String, ld5> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
            String str2 = null;
            if (colourHeaderConfig != null) {
                ld5Var = colourHeaderConfig.get(str);
            } else {
                ld5Var = null;
            }
            Q(str, ld5Var);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (ld5Var != null) {
                if (skinType != 0) {
                    if (skinType != 4) {
                        h2 = null;
                    } else {
                        str2 = ld5Var.l();
                        h2 = ld5Var.i();
                    }
                } else {
                    str2 = ld5Var.k();
                    h2 = ld5Var.h();
                }
                this.O.setTag(R.id.obfuscated_res_0x7f090f39, str2);
                if (TextUtils.isEmpty(str2)) {
                    this.O.setImageBackgroundVisibility(8);
                    this.O.setBackgroundColor(wp9.f(h2));
                } else {
                    this.O.setImageBackgroundVisibility(0);
                    lg.h().m(str2, 10, this.S, this.b.getUniqueId());
                }
                p0(skinType, ld5Var.m());
                return;
            }
            this.O.setTag(R.id.obfuscated_res_0x7f090f39, null);
            n0();
            p0(skinType, true);
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
        this.m = -1;
        this.A = false;
        this.E = new i(this, 2921653);
        this.F = new j(this, 2921400);
        this.G = new k(this, 2921415);
        this.H = new l(this, 2921501);
        this.J = new m(this, 2921502);
        this.K = new n(this, 2921751);
        this.L = new o(this, 2921509);
        this.M = new p(this);
        this.N = new q(this);
        this.R = new a(this, 2001371);
        this.S = new e(this);
        this.T = new jr7();
        this.U = new g(this);
        this.V = new h(this);
        Y();
    }

    public final void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", U(i2));
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public String V(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return this.v.t(i2);
        }
        return (String) invokeI.objValue;
    }

    public String W(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return this.v.u(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.dr7
    public void b(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, rVar) == null) {
            if (this.y == null) {
                this.y = new ArrayList();
            }
            this.y.add(rVar);
        }
    }

    @Override // com.baidu.tieba.dr7
    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            return this.v.x(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, canvas) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY);
            super.dispatchDraw(canvas);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tieba.dr7
    public void e(r rVar) {
        List<r> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, rVar) == null) && (list = this.y) != null && list.size() > 0) {
            this.y.remove(rVar);
        }
    }

    public void s0(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z) == null) && (newScrollFragmentAdapter = this.v) != null) {
            newScrollFragmentAdapter.S(z);
        }
    }

    public void setCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048624, this, i2) != null) || (newScrollFragmentAdapter = this.v) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.s(i2), false);
        setSecondCurTab(i2, "", "");
    }

    public void setCurrentTabByCode(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, str) != null) || (newScrollFragmentAdapter = this.v) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.z(str), false);
        setSecondCurTab(-1, "", str);
    }

    public void setFakeClickCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048628, this, i2) != null) || (newScrollFragmentAdapter = this.v) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.s(i2), true);
    }

    @Override // com.baidu.tieba.dr7
    public void setOnTabSelectedListener(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, sVar) == null) {
            this.w = sVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, bdUniqueId) == null) {
            this.f.setPageUniqueId(bdUniqueId);
            this.F.setTag(bdUniqueId);
            this.G.setTag(bdUniqueId);
            this.J.setTag(bdUniqueId);
            this.H.setTag(bdUniqueId);
            this.L.setTag(bdUniqueId);
        }
    }

    public void setPrimary(boolean z) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.z = z;
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
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
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.s = z;
            if (z && (view2 = this.p) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048634, this, z) == null) && this.f != null && (newScrollFragmentAdapter = this.v) != null && newScrollFragmentAdapter.D()) {
            this.f.setShowConcernRedTip(z);
        }
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, str) == null) && (newScrollFragmentAdapter = this.v) != null) {
            newScrollFragmentAdapter.R(str);
        }
    }

    public final void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            ev9 b2 = ex9.a().b().b();
            b2.a = W(i2);
            b2.c = d(i2);
            b2.d = V(i2);
            b2.b = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048619, this, i2, i3) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5000);
            super.onMeasure(i2, i3);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5007);
        }
    }

    public void t0(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048636, this, dataRes, z) == null) && (newScrollFragmentAdapter = this.v) != null) {
            newScrollFragmentAdapter.U(dataRes, z);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c == null) {
            return;
        }
        cu9.a("ScrollFragmentTabHost attachAdapter");
        NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.a, this.c, false, this.d, this.e);
        this.v = newScrollFragmentAdapter;
        newScrollFragmentAdapter.P(this);
        this.o.setOffscreenPageLimit(2);
        this.o.setAdapter(this.v);
        int q2 = this.v.q();
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.v;
        if (HomePageStatic.a) {
            q2 = 0;
        }
        int s2 = newScrollFragmentAdapter2.s(q2);
        this.o.setCurrentItem(s2);
        this.f.setViewPager(this.o);
        this.f.q();
        this.f.setConcernTabIndex(this.v.s(0));
        v0(s2);
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || !TbadkCoreApplication.isLogin()) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
        int i2 = 0;
        if (newScrollFragmentAdapter != null) {
            i2 = newScrollFragmentAdapter.s(0);
        }
        if (this.x == null) {
            an6 an6Var = new an6(this.b, this.f.l(i2));
            this.x = an6Var;
            an6Var.L(R.drawable.bg_tip_blue_up_left);
            this.x.o(16);
            this.x.x(true);
            this.x.Q(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
            this.x.N(true);
            this.x.n(4000);
        }
        this.x.T(this.a.getString(R.string.obfuscated_res_0x7f0f04af), "key_concern_forum_tab_tips_show");
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            int i2 = 0;
            if (o65.m().n("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
            if (newScrollFragmentAdapter != null) {
                i2 = newScrollFragmentAdapter.s(0);
            }
            if (this.x == null) {
                an6 an6Var = new an6(this.b, this.f.l(i2));
                this.x = an6Var;
                an6Var.L(R.drawable.bg_tip_blue_up);
                this.x.o(32);
                this.x.x(true);
                this.x.N(true);
                this.x.R(ri.g(this.a, R.dimen.obfuscated_res_0x7f0701be));
                this.x.n(4000);
            }
            this.x.U(this.a.getString(R.string.obfuscated_res_0x7f0f04b0), "key_concern_tab_tips", true);
        }
    }

    public void Q(String str, ld5 ld5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ld5Var) == null) {
            if (ld5Var != null) {
                if (!StringUtils.isNull(ld5Var.c())) {
                    this.B.setVisibility(0);
                    zq7.h(ld5Var, this.C, this.D, this.N, this.b.getUniqueId());
                } else if (!StringUtils.isNull(ld5Var.a())) {
                    this.B.setVisibility(0);
                    zq7.g(ld5Var, this.C, this.D);
                }
            } else {
                o0();
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.H(str);
            }
        }
    }

    public final void p0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.g.c(true);
            if (i2 == 0) {
                this.g.a(z);
                this.f.i(true, z);
                this.O.setSearchStyle(true, z);
                return;
            }
            this.g.a(false);
            this.f.i(false, false);
            this.O.setSearchStyle(false, false);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            cu9.a("ScrollFragmentTabHost init");
            SpeedStatsManager.getInstance().addStatsTimeStamp(4006);
            this.a = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d082c, (ViewGroup) this, true);
            this.B = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090736);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090738);
            this.C = tbImageView;
            tbImageView.setUseNightOrDarkMask(false);
            this.C.setNeedNightShade(false);
            this.D = findViewById(R.id.obfuscated_res_0x7f090737);
            FixedAppBarLayout fixedAppBarLayout = new FixedAppBarLayout(this.a);
            this.O = fixedAppBarLayout;
            addView(fixedAppBarLayout, 2);
            du9.c(this.O, 3);
            this.f = (HomeTabBarView) findViewById(R.id.obfuscated_res_0x7f090f3f);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090f3d);
            this.n = frameLayout;
            du9.c(frameLayout, 4);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f092273);
            this.o = customViewPager;
            customViewPager.setForm(1);
            this.p = findViewById(R.id.obfuscated_res_0x7f0908e3);
            this.q = findViewById(R.id.obfuscated_res_0x7f0908f0);
            this.r = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090f44);
            if (jx4.b() == 1) {
                m75 m75Var = new m75();
                this.r.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09a0));
                this.r.setTextSize(R.dimen.tbds42);
                this.r.setConfig(m75Var);
                this.r.setOnClickListener(this.M);
                this.r.setVisibility(0);
            } else if (jx4.b() == 2) {
                m75 m75Var2 = new m75();
                this.r.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09a1));
                this.r.setTextSize(R.dimen.tbds35);
                this.r.setConfig(m75Var2);
                this.r.setOnClickListener(this.M);
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            this.Q = (hp7) aj5.e().d(1012, new b(this));
            this.f.setOnPageChangeListener(new t(this));
            this.f.setOnTabItemClickListener(new c(this));
            SpeedStatsManager.getInstance().addStatsTimeStamp(4007);
        }
    }

    public void Z(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.g = new gt5(tbPageContext.getPageActivity());
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.G);
            MessageManager.getInstance().registerListener(this.J);
            MessageManager.getInstance().registerListener(this.H);
            MessageManager.getInstance().registerListener(this.R);
            MessageManager.getInstance().registerListener(this.L);
            MessageManager.getInstance().registerListener(this.K);
            MessageManager.getInstance().registerListener(this.E);
        }
    }

    @Override // com.baidu.tieba.dr7
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !this.s || b0()) {
            return;
        }
        this.q.setVisibility(0);
        if (this.t == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.t = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.t.setDuration(300L);
        }
        this.q.startAnimation(this.t);
    }

    @Override // com.baidu.tieba.dr7
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !this.s || !b0()) {
            return;
        }
        if (this.u == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.u = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.u.setDuration(300L);
            this.u.setAnimationListener(new f(this));
        }
        this.q.startAnimation(this.u);
    }

    public int getVideoRecommendIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.v != null && this.o.getAdapter() != null) {
                int count = this.o.getAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (this.v.x(i2) == 8) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            FrameLayout frameLayout = this.B;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            View view2 = this.D;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            TbImageView tbImageView = this.C;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                this.C.setImageDrawable(SkinManager.getDrawable(R.drawable.color_card_bg));
            }
        }
    }

    public void a0(FragmentManager fragmentManager, cr7 cr7Var, ConcernPageView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, fragmentManager, cr7Var, sVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.c = fragmentManager;
                this.d = cr7Var;
                this.e = sVar;
                P();
            } finally {
                TTIStats.record("ScrollFragmentTabHost.initViewPager", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void u0(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048637, this, str, i2, i3) == null) && this.o != null && this.v != null) {
            if (i2 == -1) {
                ri.P(this.a, R.string.obfuscated_res_0x7f0f0db6);
            }
            this.v.V(str, i2, i3);
        }
    }

    public void w0(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (newScrollFragmentAdapter = this.v) != null) {
            newScrollFragmentAdapter.X(dataRes, z, z2);
        }
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.r();
            }
            setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.v;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.J(i2);
            }
            hp7 hp7Var = this.Q;
            if (hp7Var != null) {
                hp7Var.j(i2);
            }
            SkinManager.setBackgroundResource(this.q, R.drawable.personalize_tab_shadow);
        }
    }

    public final void k0(RecommendFrsControlFragment.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, nVar) != null) || nVar == null) {
            return;
        }
        cu9.a("ScrollFragmentTabHost recoverSelectedTab:" + nVar.b() + " SecondTab:" + nVar.a());
        sg.a().post(new d(this, nVar));
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            an6 an6Var = this.P;
            if (an6Var != null) {
                an6Var.h();
                this.P = null;
            }
            FixedAppBarLayout fixedAppBarLayout = this.O;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.m();
            }
            S();
            MessageManager.getInstance().unRegisterListener(this.R);
            MessageManager.getInstance().unRegisterListener(this.K);
            MessageManager.getInstance().unRegisterListener(this.E);
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.s();
            }
        }
    }

    public final void j0() {
        HashMap<String, ld5> colourHeaderConfig;
        String k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) != null) {
            for (ld5 ld5Var : colourHeaderConfig.values()) {
                if (ld5Var != null) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType != 0) {
                        if (skinType != 4) {
                            k2 = null;
                        } else {
                            k2 = ld5Var.l();
                        }
                    } else {
                        k2 = ld5Var.k();
                    }
                    lg.h().m(k2, 10, null, this.b.getUniqueId());
                }
            }
        }
    }

    public final void m0(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i2) == null) && this.b != null && (newScrollFragmentAdapter = this.v) != null && (customViewPager = this.o) != null) {
            String t2 = newScrollFragmentAdapter.t(customViewPager.getCurrentItem());
            ar7 ar7Var = new ar7();
            ar7Var.b = t2;
            ar7Var.c = i2;
            CustomMessage customMessage = new CustomMessage(2921652);
            customMessage.setTag(this.b.getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921652, ar7Var);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5008);
            super.onLayout(z, i2, i3, i4, i5);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY);
        }
    }

    public void setCurrentTab(int i2, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 >= 0 && (newScrollFragmentAdapter = this.v) != null && i2 < newScrollFragmentAdapter.getCount()) {
            this.f.setTabItemClicked(z);
            this.v.Q(i2);
            this.o.setCurrentItem(i2);
        }
    }

    public void setCurrentTab(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048626, this, str) != null) || (newScrollFragmentAdapter = this.v) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.A(str), false);
        setSecondCurTab(-1, str, "");
    }

    public void setSecondCurTab(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048633, this, i2, str, str2) == null) {
            if (this.v.z(str2) == this.v.B() && (this.v.o() instanceof PersonalizeWrapperFragment)) {
                PersonalizeWrapperFragment personalizeWrapperFragment = (PersonalizeWrapperFragment) this.v.o();
                if (i2 != -1) {
                    personalizeWrapperFragment.N1(i2);
                } else if (!TextUtils.isEmpty(str)) {
                    personalizeWrapperFragment.M1(str);
                } else if (!TextUtils.isEmpty(str2)) {
                    personalizeWrapperFragment.L1(str2);
                }
            } else if (this.v.o() == null) {
                this.h = true;
                this.i = i2;
                this.k = str2;
                this.j = str;
            }
        }
    }
}
