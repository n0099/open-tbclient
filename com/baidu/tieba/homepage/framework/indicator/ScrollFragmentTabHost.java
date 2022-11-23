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
import com.baidu.tbadk.core.util.FullBrowseHelper;
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
import com.baidu.tieba.c66;
import com.baidu.tieba.h07;
import com.baidu.tieba.h55;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.i07;
import com.baidu.tieba.in;
import com.baidu.tieba.k07;
import com.baidu.tieba.l07;
import com.baidu.tieba.n07;
import com.baidu.tieba.o07;
import com.baidu.tieba.oz4;
import com.baidu.tieba.qj5;
import com.baidu.tieba.qy4;
import com.baidu.tieba.r07;
import com.baidu.tieba.rn8;
import com.baidu.tieba.sa5;
import com.baidu.tieba.sg;
import com.baidu.tieba.tg;
import com.baidu.tieba.ty6;
import com.baidu.tieba.uq4;
import com.baidu.tieba.vr8;
import com.baidu.tieba.yi;
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
public class ScrollFragmentTabHost extends CoordinatorLayout implements l07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GestureDetector A;
    public FrameLayout B;
    public TbImageView C;
    public View D;
    public final CustomMessageListener E;
    public final CustomMessageListener F;
    public CustomMessageListener G;
    public CustomMessageListener H;
    public CustomMessageListener I;
    public CustomMessageListener J;
    public boolean K;
    public CustomMessageListener L;
    public CustomMessageListener M;
    public CustomMessageListener N;
    public View.OnClickListener O;
    public sg<in> P;
    @Nullable
    public FixedAppBarLayout Q;
    public c66 R;
    public ty6 S;
    public CustomMessageListener T;
    public sg<in> U;
    public r07 V;
    public o07 W;
    public Context a;
    public n07 a0;
    public TbPageContext b;
    public FragmentManager c;
    public k07 d;
    public ConcernPageView.o e;
    public HomeTabBarView f;
    public qj5 g;
    public boolean h;
    public int i;
    public String j;
    public String k;
    public FrameLayout l;
    public CustomViewPager m;
    public View n;
    public View o;
    public TBSpecificationBtn p;
    public FrameLayout q;
    public boolean r;
    public AlphaAnimation s;
    public AlphaAnimation t;
    public NewScrollFragmentAdapter u;
    public w v;
    public c66 w;
    public List<v> x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public interface w {
        void a(int i);
    }

    public final int R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
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

    @Override // com.baidu.tieba.l07
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageView a;

            public a(r rVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar, imageView};
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

            public b(r rVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar, imageView};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                LinearLayout linearLayout = (LinearLayout) this.a.f.m(0);
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
                        this.a.S.k(this.a.f.getBackgroundAlpha());
                        this.a.S.j(TbadkCoreApplication.getInst().getSkinType());
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
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextView a;
            public final /* synthetic */ int b;

            public a(s sVar, TextView textView, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, textView, Integer.valueOf(i)};
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

            public b(s sVar, TextView textView, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, textView, Integer.valueOf(i)};
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

            public c(s sVar, TextView textView, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, textView, str};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02bd);
                String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02b1);
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                LinearLayout linearLayout = (LinearLayout) this.a.f.m(0);
                if (intValue == 1) {
                    if ((linearLayout instanceof LinearLayout) && linearLayout.getChildCount() > 0 && (linearLayout.getChildAt(0) instanceof TextView)) {
                        TextView textView = (TextView) linearLayout.getChildAt(0);
                        if (string2.equals(textView.getText())) {
                            int measuredWidth = textView.getMeasuredWidth();
                            textView.setText(string);
                            int measureText = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02bd));
                            int measureText2 = (int) textView.getPaint().measureText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02b1));
                            if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                                ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                                ofInt.setDuration(360L);
                                ofInt.addUpdateListener(new a(this, textView, measuredWidth));
                                ofInt.start();
                            }
                        }
                        qy4.k().w("key_home_concern_all_status", 1);
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
                    qy4.k().w("key_home_concern_all_status", 0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (uq4.b() == 1) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{"http://fans.baidu.com/fanstest/wapindex?product_id=1002&version=12.11.0.11&client_type=android&contact_way=qq"});
                } else if (uq4.b() == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921569));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends sg<in> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, inVar, str, i) == null) {
                if (inVar != null && this.a.C != null) {
                    this.a.C.setImageBitmap(inVar.p());
                } else {
                    this.a.C.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
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
                if (this.a.K != UbsABTestHelper.isConcernForumCardShow()) {
                    this.a.f.s();
                    if (UbsABTestHelper.isConcernForumCardShow() && this.a.y) {
                        this.a.P();
                        this.a.h0();
                    }
                }
                this.a.e0();
                this.a.setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements sa5.b {
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

        @Override // com.baidu.tieba.sa5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new ty6(this.a.a);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ViewPager.OnPageChangeListener {
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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0 && this.a.getCurrentTabType() == 0) {
                    boolean Y = this.a.Y();
                    TiebaStatic.log(new StatisticItem("c12350").param("obj_type", Y ? 1 : 0));
                    if (Y && this.a.u != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        this.a.u.O();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
                this.a.g0(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) || this.a.u == null) {
                return;
            }
            TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.S(i));
            this.a.u.onPageScrolled(i, f, i2);
            View redDotTip = this.a.f.getRedDotTip();
            if (redDotTip != null && ((Integer) redDotTip.getTag(R.id.obfuscated_res_0x7f090e2d)).intValue() == i && redDotTip.getVisibility() == 0) {
                redDotTip.setVisibility(8);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.a.u == null) {
                return;
            }
            if (this.a.v != null) {
                this.a.v.a(i);
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
            int s = this.a.u.s(this.a.m.getCurrentItem());
            if (s == 5) {
                if (this.a.z) {
                    this.a.z = false;
                } else {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 0);
                    statisticItem.eventStat();
                }
                if (this.a.f.p()) {
                    this.a.f.n();
                }
            }
            if (s == 0) {
                this.a.P();
            }
            View m = this.a.f.m(0);
            if ((m instanceof LinearLayout) && TbadkCoreApplication.isLogin() && UbsABTestHelper.isConcernForumCardShow()) {
                LinearLayout linearLayout = (LinearLayout) m;
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
                int s2 = this.a.u.s(this.a.m.getCurrentItem());
                if (s2 == 5) {
                    this.a.setScrollShadow(false);
                    for (v vVar : this.a.x) {
                        vVar.c();
                    }
                } else if (s2 == 1) {
                    this.a.setScrollShadow(false);
                    for (v vVar2 : this.a.x) {
                        vVar2.b();
                    }
                } else if (s2 == 0) {
                    this.a.setScrollShadow(false);
                    for (v vVar3 : this.a.x) {
                        vVar3.a();
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
            TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.S(i));
            if (this.a.d(i) == 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.isLogin()) {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        qy4.k().x(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                    }
                } else {
                    qy4.k().x("unlogin_hot_top_timestamp", currentTimeMillis);
                }
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.a;
            scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.S(i));
            View redDotTip = this.a.f.getRedDotTip();
            if (redDotTip != null && ((Integer) redDotTip.getTag(R.id.obfuscated_res_0x7f090e2d)).intValue() == i && redDotTip.getVisibility() == 0) {
                redDotTip.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements PagerSlidingTabStrip.c {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.c
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                if (this.a.d(i) != 1 && FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b, null)) {
                    return;
                }
                this.a.K(i);
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && this.a.m.getCurrentItem() != i) {
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
                TbadkCoreApplication.getInst().setHomeBarShowTabName(this.a.S(i));
                if (this.a.d(i) == 5) {
                    StatisticItem statisticItem = new StatisticItem("c13740");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 0);
                    statisticItem.eventStat();
                    this.a.z = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            qy4.k().x(TbadkCoreApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        qy4.k().x("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                }
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setColorHead(scrollFragmentTabHost.S(i));
                View redDotTip = this.a.f.getRedDotTip();
                if (redDotTip != null && ((Integer) redDotTip.getTag(R.id.obfuscated_res_0x7f090e2d)).intValue() == i && redDotTip.getVisibility() == 0) {
                    redDotTip.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements HomeTabBarView.e {
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

        @Override // com.baidu.tieba.homepage.personalize.view.HomeTabBarView.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.R != null) {
                    this.a.R.h();
                    this.a.R = null;
                }
                if (this.a.b != null) {
                    UrlManager.getInstance().dealOneLink(this.a.b, new String[]{str});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

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
    }

    /* loaded from: classes4.dex */
    public class i extends sg<in> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, inVar, str, i) == null) && this.a.Q != null && inVar != null) {
                if (inVar.p() == null) {
                    this.a.Q.setImageBackgroundVisibility(8);
                } else {
                    this.a.Q.setImageBackground(inVar.p());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Animation.AnimationListener {
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

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.o.setVisibility(8);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.q != null) {
                if ((customResponsedMessage.getData() instanceof i07) && ((i07) customResponsedMessage.getData()).a != null) {
                    View view2 = ((i07) customResponsedMessage.getData()).a;
                    if (view2.getParent() != null) {
                        if (view2.getParent() != this.a.q) {
                            ((ViewGroup) view2.getParent()).removeView(view2);
                            this.a.q.removeAllViews();
                            this.a.q.addView(view2);
                        }
                    } else {
                        this.a.q.removeAllViews();
                        this.a.q.addView(view2);
                    }
                    this.a.q.setVisibility(0);
                    return;
                }
                this.a.q.removeAllViews();
                this.a.q.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements o07 {
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

        @Override // com.baidu.tieba.o07
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.u == null) {
                return;
            }
            this.a.setCurrentTab(this.a.u.p(i), false);
            this.a.u.E(i);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements n07 {
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

        @Override // com.baidu.tieba.n07
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.V.b(i, this.a.W);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.M();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.m == null) {
                return;
            }
            if (FullBrowseHelper.checkIsFullBrowseMode()) {
                this.a.m.setScrollable(false, this.a.A);
            } else {
                this.a.m.setScrollable(true);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.R != null) {
                this.a.R.h();
                this.a.R = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentTabHost a;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.h && customResponsedMessage.getCmd() == 2921751) {
                ScrollFragmentTabHost scrollFragmentTabHost = this.a;
                scrollFragmentTabHost.setSecondCurTab(scrollFragmentTabHost.i, this.a.j, this.a.k);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.u != null && customResponsedMessage != null && customResponsedMessage.getData() != null && this.a.f != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.u.T();
                this.a.u.R();
                this.a.m.setAdapter(this.a.u);
                this.a.f.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class v {
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

        public v() {
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
        this.h = false;
        this.z = false;
        this.E = new k(this, 2921652);
        this.F = new n(this, 2921653);
        this.G = new o(this, 2921563);
        this.H = new p(this, 2921400);
        this.I = new q(this, 2921415);
        this.J = new r(this, 2921501);
        this.L = new s(this, 2921502);
        this.M = new t(this, 2921751);
        this.N = new u(this, 2921509);
        this.O = new a(this);
        this.P = new b(this);
        this.T = new c(this, 2001371);
        this.U = new i(this);
        this.V = new r07();
        this.W = new l(this);
        this.a0 = new m(this);
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorHead(String str) {
        h55 h55Var;
        String j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            qj5 qj5Var = this.g;
            if (qj5Var != null) {
                qj5Var.c(false);
            }
            if (this.Q != null && this.g != null) {
                HashMap<String, h55> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
                String str2 = null;
                if (colourHeaderConfig != null) {
                    h55Var = colourHeaderConfig.get(str);
                } else {
                    h55Var = null;
                }
                N(str, h55Var);
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (h55Var != null) {
                    if (skinType != 0) {
                        if (skinType != 1) {
                            if (skinType != 4) {
                                j2 = null;
                            } else {
                                str2 = h55Var.n();
                                j2 = h55Var.k();
                            }
                        } else {
                            str2 = h55Var.o();
                            j2 = h55Var.l();
                        }
                    } else {
                        str2 = h55Var.m();
                        j2 = h55Var.j();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        this.Q.setImageBackgroundVisibility(8);
                        this.Q.setBackgroundColor(rn8.f(j2));
                    } else {
                        this.Q.setImageBackgroundVisibility(0);
                        tg.h().m(str2, 10, this.U, this.b.getUniqueId());
                    }
                    this.g.c(true);
                    if (skinType == 0) {
                        this.g.a(h55Var.p());
                        this.f.j(true, h55Var.p());
                        this.Q.setSearchStyle(true, h55Var.p());
                        return;
                    }
                    this.g.a(false);
                    this.f.j(false, false);
                    this.Q.setSearchStyle(false, false);
                    return;
                }
                this.Q.l();
                this.g.a(!UtilHelper.isNightOrDarkMode());
                this.f.u();
            }
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
        this.h = false;
        this.z = false;
        this.E = new k(this, 2921652);
        this.F = new n(this, 2921653);
        this.G = new o(this, 2921563);
        this.H = new p(this, 2921400);
        this.I = new q(this, 2921415);
        this.J = new r(this, 2921501);
        this.L = new s(this, 2921502);
        this.M = new t(this, 2921751);
        this.N = new u(this, 2921509);
        this.O = new a(this);
        this.P = new b(this);
        this.T = new c(this, 2001371);
        this.U = new i(this);
        this.V = new r07();
        this.W = new l(this);
        this.a0 = new m(this);
        U();
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", R(i2));
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public String S(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return this.u.r(i2);
        }
        return (String) invokeI.objValue;
    }

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            setColorHead(TbadkCoreApplication.getInst().getHomeBarShowTabName());
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.F(i2);
            }
            ty6 ty6Var = this.S;
            if (ty6Var != null) {
                ty6Var.j(i2);
            }
            SkinManager.setBackgroundResource(this.o, R.drawable.personalize_tab_shadow);
        }
    }

    @Override // com.baidu.tieba.l07
    public void b(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, vVar) == null) {
            if (this.x == null) {
                this.x = new ArrayList();
            }
            this.x.add(vVar);
        }
    }

    @Override // com.baidu.tieba.l07
    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            return this.u.s(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, canvas) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY);
            super.dispatchDraw(canvas);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tieba.l07
    public void e(v vVar) {
        List<v> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, vVar) == null) && (list = this.x) != null && list.size() > 0) {
            this.x.remove(vVar);
        }
    }

    public void j0(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.N(z);
        }
    }

    @Override // com.baidu.tieba.l07
    public void setCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048621, this, i2) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.p(i2), false);
        setSecondCurTab(i2, "", "");
    }

    public void setCurrentTabByCode(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048624, this, str) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.u(str), false);
        setSecondCurTab(-1, "", str);
    }

    public void setFakeClickCurrentTab(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048625, this, i2) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.p(i2), true);
    }

    @Override // com.baidu.tieba.l07
    public void setOnTabSelectedListener(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, wVar) == null) {
            this.v = wVar;
        }
    }

    public void setPrimary(boolean z) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.y = z;
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.I(z);
            }
            if (!z && (tbPageContext = this.b) != null) {
                StatusbarColorUtils.setStatusBarDarkIcon(tbPageContext.getPageActivity(), !UtilHelper.isNightOrDarkMode());
            }
        }
    }

    public void setScrollShadow(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.r = z;
            if (z && (view2 = this.n) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && this.f != null && (newScrollFragmentAdapter = this.u) != null && newScrollFragmentAdapter.y()) {
            this.f.setShowConcernRedTip(z);
        }
    }

    public void setVideoThreadId(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, str) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.M(str);
        }
    }

    public void k0(DataRes dataRes, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048614, this, dataRes, z) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.P(dataRes, z);
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

    public void L() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f != null && (newScrollFragmentAdapter = this.u) != null && newScrollFragmentAdapter.z()) {
            NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.u;
            if (newScrollFragmentAdapter2 != null) {
                i2 = newScrollFragmentAdapter2.o();
            } else {
                i2 = -1;
            }
            View m2 = this.f.m(i2);
            if (this.f.getTabStrip() != null && m2 != null) {
                this.f.i((this.f.getTabStrip().getLeft() + m2.getRight()) - UtilHelper.getDimenPixelSize(R.dimen.tbds36), m2.getTop(), m2, i2);
            }
        }
    }

    public final void M() {
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (fragmentManager = this.c) == null) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = new NewScrollFragmentAdapter(this.a, fragmentManager, false, this.d, this.e);
        this.u = newScrollFragmentAdapter;
        newScrollFragmentAdapter.K(this);
        this.m.setOffscreenPageLimit(2);
        this.m.setAdapter(this.u);
        int n2 = this.u.n();
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.u;
        if (HomePageStatic.a) {
            n2 = 0;
        }
        this.m.setCurrentItem(newScrollFragmentAdapter2.p(n2));
        this.f.setViewPager(this.m);
        this.f.setConcernTabIndex(this.u.p(0));
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921409);
            c66 c66Var = this.R;
            if (c66Var != null) {
                c66Var.h();
                this.R = null;
            }
            FixedAppBarLayout fixedAppBarLayout = this.Q;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.m();
            }
            P();
            MessageManager.getInstance().unRegisterListener(this.T);
            MessageManager.getInstance().unRegisterListener(this.M);
            MessageManager.getInstance().unRegisterListener(this.F);
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.v();
            }
        }
    }

    public final void e0() {
        HashMap<String, h55> colourHeaderConfig;
        String m2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) != null) {
            for (h55 h55Var : colourHeaderConfig.values()) {
                if (h55Var != null) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType != 0) {
                        if (skinType != 1) {
                            if (skinType != 4) {
                                m2 = null;
                            } else {
                                m2 = h55Var.n();
                            }
                        } else {
                            m2 = h55Var.o();
                        }
                    } else {
                        m2 = h55Var.m();
                    }
                    tg.h().m(m2, 10, null, this.b.getUniqueId());
                }
            }
        }
    }

    public void N(String str, h55 h55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, h55Var) == null) {
            boolean z = false;
            if (h55Var != null) {
                if (!StringUtils.isNull(h55Var.d())) {
                    this.B.setVisibility(0);
                    h07.h(h55Var, this.C, this.D, this.P, this.b.getUniqueId());
                } else if (!StringUtils.isNull(h55Var.a())) {
                    this.B.setVisibility(0);
                    h07.g(h55Var, this.C, this.D);
                } else {
                    this.B.setVisibility(8);
                }
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                newScrollFragmentAdapter.D(str);
            }
            if (getResources().getString(R.string.obfuscated_res_0x7f0f13ab).equals(str) || getResources().getString(R.string.obfuscated_res_0x7f0f026e).equals(TbadkCoreApplication.getInst().getHomeBarShowTabName())) {
                MessageManager messageManager = MessageManager.getInstance();
                if (this.B.getVisibility() == 0) {
                    z = true;
                }
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921722, Boolean.valueOf(z)));
            }
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null) {
                return false;
            }
            return newScrollFragmentAdapter.h();
        }
        return invokeV.booleanValue;
    }

    public void P() {
        c66 c66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (c66Var = this.w) != null) {
            c66Var.h();
        }
    }

    public void Q() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.i();
        }
    }

    public boolean T() {
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

    public final boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.o.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f != null && (newScrollFragmentAdapter = this.u) != null && newScrollFragmentAdapter.y()) {
                return this.f.q();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (newScrollFragmentAdapter = this.u) != null && !HomePageStatic.a) {
            this.m.setAdapter(newScrollFragmentAdapter);
            this.f.s();
            this.V.a(this.W);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            HomeTabBarView homeTabBarView = this.f;
            if (homeTabBarView != null) {
                homeTabBarView.w();
            }
            FixedAppBarLayout fixedAppBarLayout = this.Q;
            if (fixedAppBarLayout != null) {
                fixedAppBarLayout.n();
            }
        }
    }

    public void d0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        newScrollFragmentAdapter.t(this.a0);
    }

    public void f0() {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.G();
        }
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            CustomViewPager customViewPager = this.m;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                return newScrollFragmentAdapter.m();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l07
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter == null) {
                return 0;
            }
            return newScrollFragmentAdapter.s(this.m.getCurrentItem());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l07
    public FrameLayout getFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.l;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onAttachedToWindow();
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

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4006);
            this.a = getContext();
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07ab, (ViewGroup) this, true);
            this.B = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09068e);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090690);
            this.C = tbImageView;
            tbImageView.setUseNightOrDarkMask(false);
            this.C.setNeedNightShade(false);
            this.D = findViewById(R.id.obfuscated_res_0x7f09068f);
            FixedAppBarLayout fixedAppBarLayout = new FixedAppBarLayout(this.a);
            this.Q = fixedAppBarLayout;
            addView(fixedAppBarLayout, 2);
            this.f = (HomeTabBarView) findViewById(R.id.obfuscated_res_0x7f090ddb);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090dd9);
            this.l = frameLayout;
            vr8.c(frameLayout, 5);
            CustomViewPager customViewPager = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f09207f);
            this.m = customViewPager;
            customViewPager.setForm(1);
            this.n = findViewById(R.id.divider_line);
            this.o = findViewById(R.id.obfuscated_res_0x7f090833);
            this.p = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090de0);
            this.q = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0903fe);
            if (uq4.b() == 1) {
                oz4 oz4Var = new oz4();
                this.p.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f088f));
                this.p.setTextSize(R.dimen.tbds42);
                this.p.setConfig(oz4Var);
                this.p.setOnClickListener(this.O);
                this.p.setVisibility(0);
            } else if (uq4.b() == 2) {
                oz4 oz4Var2 = new oz4();
                this.p.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0890));
                this.p.setTextSize(R.dimen.tbds35);
                this.p.setConfig(oz4Var2);
                this.p.setOnClickListener(this.O);
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
            this.S = (ty6) sa5.e().d(1012, new d(this));
            this.f.setOnPageChangeListener(new e(this));
            this.f.setOnTabItemClickListener(new f(this));
            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
                this.f.setMissionEntranceVisibility(true);
                this.f.setEntranceJumpListener(new g(this));
            } else {
                this.f.setMissionEntranceVisibility(false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(4007);
        }
    }

    public void V(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.g = new qj5(tbPageContext.getPageActivity());
            MessageManager.getInstance().registerListener(this.H);
            MessageManager.getInstance().registerListener(this.I);
            MessageManager.getInstance().registerListener(this.L);
            MessageManager.getInstance().registerListener(this.J);
            MessageManager.getInstance().registerListener(this.T);
            MessageManager.getInstance().registerListener(this.N);
            MessageManager.getInstance().registerListener(this.G);
            MessageManager.getInstance().registerListener(this.M);
            MessageManager.getInstance().registerListener(this.F);
            if (this.b != null) {
                this.E.setPriority(Integer.MAX_VALUE);
                MessageManager.getInstance().registerListener(this.E);
            }
        }
    }

    @RequiresApi(api = 3)
    public void W(FragmentManager fragmentManager, k07 k07Var, ConcernPageView.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, fragmentManager, k07Var, oVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.c = fragmentManager;
                this.d = k07Var;
                this.e = oVar;
                M();
                this.A = new GestureDetector(this.a, new h(this));
                if (FullBrowseHelper.checkIsFullBrowseMode()) {
                    this.m.setScrollable(false, this.A);
                } else {
                    this.m.setScrollable(true);
                }
            } finally {
                TTIStats.record("ScrollFragmentTabHost.initViewPager", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void setSecondCurTab(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048630, this, i2, str, str2) == null) {
            if (this.u.u(str2) == this.u.w() && (this.u.l() instanceof PersonalizeWrapperFragment)) {
                PersonalizeWrapperFragment personalizeWrapperFragment = (PersonalizeWrapperFragment) this.u.l();
                if (i2 != -1) {
                    personalizeWrapperFragment.x1(i2);
                } else if (!TextUtils.isEmpty(str)) {
                    personalizeWrapperFragment.v1(str);
                } else if (!TextUtils.isEmpty(str2)) {
                    personalizeWrapperFragment.u1(str2);
                }
            } else if (this.u.l() == null) {
                this.h = true;
                this.i = i2;
                this.k = str2;
                this.j = str;
            }
        }
    }

    @Override // com.baidu.tieba.l07
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !this.r || X()) {
            return;
        }
        this.o.setVisibility(0);
        if (this.s == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.s = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.s.setDuration(300L);
        }
        this.o.startAnimation(this.s);
    }

    @Override // com.baidu.tieba.l07
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || !this.r || !X()) {
            return;
        }
        if (this.t == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.t = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.t.setDuration(300L);
            this.t.setAnimationListener(new j(this));
        }
        this.o.startAnimation(this.t);
    }

    public int getVideoRecommendIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.u != null && this.m.getAdapter() != null) {
                int count = this.m.getAdapter().getCount();
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

    public final void g0(int i2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i2) == null) && this.b != null && (newScrollFragmentAdapter = this.u) != null && (customViewPager = this.m) != null) {
            String q2 = newScrollFragmentAdapter.q(customViewPager.getCurrentItem());
            i07 i07Var = new i07();
            i07Var.b = q2;
            i07Var.c = i2;
            CustomMessage customMessage = new CustomMessage(2921652);
            customMessage.setTag(this.b.getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921652, i07Var);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || !TbadkCoreApplication.isLogin()) {
            return;
        }
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
        int i2 = 0;
        if (newScrollFragmentAdapter != null) {
            i2 = newScrollFragmentAdapter.p(0);
        }
        if (this.w == null) {
            c66 c66Var = new c66(this.b, this.f.m(i2));
            this.w = c66Var;
            c66Var.L(R.drawable.obfuscated_res_0x7f0802f5);
            this.w.o(16);
            this.w.x(true);
            this.w.P(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
            this.w.M(true);
            this.w.n(4000);
        }
        this.w.S(this.a.getString(R.string.obfuscated_res_0x7f0f043c), "key_concern_forum_tab_tips_show");
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int i2 = 0;
            if (qy4.k().l("key_concern_tab_tips_switch", 0) == 0) {
                return;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.u;
            if (newScrollFragmentAdapter != null) {
                i2 = newScrollFragmentAdapter.p(0);
            }
            if (this.w == null) {
                c66 c66Var = new c66(this.b, this.f.m(i2));
                this.w = c66Var;
                c66Var.L(R.drawable.obfuscated_res_0x7f0802f4);
                this.w.o(32);
                this.w.x(true);
                this.w.M(true);
                this.w.Q(yi.g(this.a, R.dimen.obfuscated_res_0x7f0701be));
                this.w.n(4000);
            }
            this.w.T(this.a.getString(R.string.obfuscated_res_0x7f0f043d), "key_concern_tab_tips", true);
        }
    }

    public void l0(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048615, this, str, i2, i3) == null) && this.m != null && this.u != null) {
            if (i2 == -1) {
                yi.O(this.a, R.string.obfuscated_res_0x7f0f0c81);
            }
            this.u.Q(str, i2, i3);
        }
    }

    public void m0(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (newScrollFragmentAdapter = this.u) != null) {
            newScrollFragmentAdapter.S(dataRes, z, z2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5008);
            super.onLayout(z, i2, i3, i4, i5);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY);
        }
    }

    public void setCurrentTab(int i2, boolean z) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 >= 0 && (newScrollFragmentAdapter = this.u) != null && i2 < newScrollFragmentAdapter.getCount()) {
            this.f.setTabItemClicked(z);
            this.u.L(i2);
            this.m.setCurrentItem(i2);
        }
    }

    public void setCurrentTab(String str) {
        NewScrollFragmentAdapter newScrollFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, str) != null) || (newScrollFragmentAdapter = this.u) == null) {
            return;
        }
        setCurrentTab(newScrollFragmentAdapter.v(str), false);
        setSecondCurTab(-1, str, "");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bdUniqueId) == null) {
            this.f.setPageUniqueId(bdUniqueId);
            this.H.setTag(bdUniqueId);
            this.I.setTag(bdUniqueId);
            this.L.setTag(bdUniqueId);
            this.J.setTag(bdUniqueId);
            this.N.setTag(bdUniqueId);
            this.G.setTag(bdUniqueId);
            this.E.setTag(bdUniqueId);
        }
    }
}
