package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.p5a;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.header.PersonHeaderBackgroundController;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bx9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int S = 5000;

    /* renamed from: T  reason: collision with root package name */
    public static final float f1093T;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public int B;
    public int C;
    public GradientDrawable D;
    public FrameLayout E;
    public FrameLayout.LayoutParams F;
    public AlphaAnimation G;
    public AlphaAnimation H;
    public cw9 I;
    public ww9 J;
    public ValueAnimator K;
    public long L;
    public boolean M;
    public int N;
    public int O;
    public boolean P;
    public Runnable Q;
    public xu9 R;
    public TbPageContext a;
    public NoNetworkView b;
    public View c;
    public ua9 d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public iv9 i;
    public boolean j;
    public BdUniqueId k;
    public cv9 l;
    public BaseFragment m;
    public float[] n;
    public float o;
    public int p;
    public LottieSlideLoadingLayout q;
    public PersonHeaderBackgroundController r;
    public AppBarLayout s;
    public FrameLayout t;
    public NewPagerSlidingTabBaseStrip u;
    public View v;
    public CustomViewPager w;
    public m x;
    public LinearLayout y;
    public FrameLayout z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bx9 bx9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var, Integer.valueOf(i)};
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
            this.a = bx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.a.N == ((Integer) customResponsedMessage.getData()).intValue() && this.a.M) {
                SafeHandler.getInst().removeCallbacks(this.a.Q);
                this.a.V();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        public b(bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.M) {
                return;
            }
            this.a.V();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements xu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        public c(bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx9Var;
        }

        @Override // com.baidu.tieba.xu9
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.F.height = -2;
                this.a.E.setLayoutParams(this.a.F);
            }
        }

        @Override // com.baidu.tieba.xu9
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.P = z;
            if (this.a.I != null && this.a.I.B() != null) {
                this.a.I.B().setOpen(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ra5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        @Override // com.baidu.tieba.ra5
        public void onLoadingEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public d(bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx9Var;
        }

        @Override // com.baidu.tieba.ra5
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SafeHandler.getInst().postDelayed(this.a.Q, bx9.S);
                this.a.M = true;
                bx9 bx9Var = this.a;
                bx9Var.N = bx9Var.x.d();
                this.a.M();
                this.a.x.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        public e(bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx9Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            boolean z;
            boolean z2;
            boolean z3;
            float abs;
            boolean z4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    if (i == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    UtilHelper.changeStatusBarIconAndTextColor(z4, this.a.a.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.a.a.getPageActivity());
                }
                LottieSlideLoadingLayout lottieSlideLoadingLayout = this.a.q;
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                lottieSlideLoadingLayout.setEnableSlideLoading(z);
                int abs2 = Math.abs(i);
                ww9 ww9Var = this.a.J;
                if (abs2 == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ww9Var.i(z2);
                ww9 ww9Var2 = this.a.J;
                float f = abs2;
                if (f > this.a.o / 2.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                ww9Var2.m(z3);
                if (this.a.o == 0.0d) {
                    abs = 0.0f;
                } else {
                    abs = Math.abs(f / this.a.o);
                }
                this.a.J.h(abs);
                if (abs < 1.0f) {
                    this.a.n = new float[]{bx9.f1093T, bx9.f1093T, bx9.f1093T, bx9.f1093T, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.a.D.setCornerRadii(this.a.n);
                    this.a.t.setBackgroundDrawable(this.a.D);
                    this.a.O();
                } else {
                    this.a.n = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.a.D.setCornerRadii(this.a.n);
                    this.a.t.setBackgroundDrawable(this.a.D);
                    this.a.Y();
                }
                int i2 = this.a.C - this.a.B;
                if (this.a.C > 0 && Math.abs(i) >= i2) {
                    this.a.q.o();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public f(bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx9Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.x.h(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(bx9 bx9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var, Integer.valueOf(i)};
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
            this.a = bx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.J != null) {
                this.a.J.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

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

        public h(bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx9Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.G.reset();
                this.a.G = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

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

        public i(bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx9Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.v.setVisibility(8);
                this.a.H.reset();
                this.a.H = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        public j(bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.B == 0) {
                bx9 bx9Var = this.a;
                bx9Var.B = bx9Var.E.getMeasuredHeight();
                bx9 bx9Var2 = this.a;
                bx9Var2.o = bx9Var2.E.getMeasuredHeight() - this.a.J.e().getMeasuredHeight();
                if (this.a.r != null) {
                    bx9 bx9Var3 = this.a;
                    bx9Var3.O = bx9Var3.p + this.a.J.e().getMeasuredHeight() + this.a.E.getMeasuredHeight() + this.a.u.getMeasuredHeight();
                    int i = 0;
                    if (!this.a.j && this.a.i.j() != null && this.a.i.j().getNewGodData() != null && this.a.i.j().getNewGodData().isNewGod()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.a.F.height = this.a.O;
                    this.a.E.setLayoutParams(this.a.F);
                    bx9 bx9Var4 = this.a;
                    int i2 = bx9Var4.O;
                    if (z) {
                        i = bw9.b0;
                    }
                    bx9Var4.O = i2 + i;
                    this.a.F.height = -2;
                    this.a.E.setLayoutParams(this.a.F);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(bx9 bx9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var, Integer.valueOf(i)};
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
            this.a = bx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof p5a)) {
                SparseArray<p5a.a> sparseArray = ((p5a) customResponsedMessage.getData()).a;
                if (sparseArray.size() <= 0) {
                    return;
                }
                p5a.a aVar = sparseArray.get(2);
                if (this.a.I != null && aVar != null) {
                    this.a.I.I(aVar.a);
                }
                p5a.a aVar2 = sparseArray.get(4);
                p5a.a aVar3 = sparseArray.get(3);
                p5a.a aVar4 = sparseArray.get(1);
                p5a.a aVar5 = sparseArray.get(7);
                p5a.a aVar6 = sparseArray.get(8);
                if (this.a.i != null) {
                    if (this.a.i.w != null && this.a.i.w.b != null && aVar2 != null) {
                        this.a.i.w.b.putBoolean("person_center_item_red_tip_show", aVar2.a);
                    }
                    if (aVar3 != null && this.a.i.v != null && this.a.i.v.b != null) {
                        this.a.i.v.b.putBoolean("person_center_item_red_tip_show", aVar3.a);
                    }
                    if (aVar4 != null && this.a.i.u != null && this.a.i.u.b != null) {
                        this.a.i.u.b.putBoolean("person_center_item_red_tip_show", aVar4.a);
                    }
                    if (aVar5 != null && this.a.i.x != null && this.a.i.x.b != null) {
                        this.a.i.x.b.putBoolean("person_center_item_red_tip_show", aVar5.a);
                    }
                    if (aVar6 != null && this.a.i.y != null && this.a.i.y.b != null) {
                        this.a.i.y.b.putBoolean("person_center_item_red_tip_show", aVar6.a);
                        this.a.i.y.b.putString("person_center_item_txt", String.valueOf(aVar6.b));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(bx9 bx9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var, Integer.valueOf(i)};
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
            this.a = bx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData) && (userPendantData = (UserPendantData) customResponsedMessage.getData()) != null) {
                this.a.I.K(userPendantData.getImgUrl());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;
        public List<PersonCenterTabBaseFragment> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(bx9 bx9Var, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx9Var, fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(bx9Var.a.getResources().getString(R.string.obfuscated_res_0x7f0f1061));
            this.a.add(bx9Var.a.getResources().getString(R.string.obfuscated_res_0x7f0f1064));
            this.a.add(bx9Var.a.getResources().getString(R.string.obfuscated_res_0x7f0f1060));
            ArrayList arrayList2 = new ArrayList();
            this.b = arrayList2;
            arrayList2.add(PersonCenterMainTabFragment.a2(bx9Var.L, bx9Var.j));
            this.b.add(PersonCenterThreadTabFragment.g2(bx9Var.L, bx9Var.j));
            this.b.add(PersonCenterDynamicTabFragment.d2(bx9Var.L, bx9Var.j));
        }

        public PersonCenterTabBaseFragment e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i < this.b.size()) {
                    return this.b.get(i);
                }
                return null;
            }
            return (PersonCenterTabBaseFragment) invokeI.objValue;
        }

        public final String f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.a.get(i);
            }
            return (String) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                return e(i);
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                return f(i);
            }
            return (CharSequence) invokeI.objValue;
        }

        public void h(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                for (int i2 = 0; i2 < this.a.size() && (personCenterTabBaseFragment = this.b.get(i2)) != null; i2++) {
                    if (i2 == i) {
                        personCenterTabBaseFragment.setPrimary(true);
                    } else {
                        personCenterTabBaseFragment.setPrimary(false);
                    }
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || ListUtils.isEmpty(this.b)) {
                return;
            }
            for (int i = 0; i < this.b.size(); i++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.U1(false);
                }
            }
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (ListUtils.isEmpty(this.b)) {
                    return -1;
                }
                for (int i = 0; i < this.b.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                    if (personCenterTabBaseFragment != null && personCenterTabBaseFragment.isPrimary()) {
                        return personCenterTabBaseFragment.V1();
                    }
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public void g(int i) {
            List<PersonCenterTabBaseFragment> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (list = this.b) != null && list.size() > 0) {
                int size = this.b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i2);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }

        public void i(iv9 iv9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, iv9Var) == null) && iv9Var != null && !ListUtils.isEmpty(this.b)) {
                for (int i = 0; i < this.b.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                    if (personCenterTabBaseFragment instanceof PersonCenterMainTabFragment) {
                        ((PersonCenterMainTabFragment) personCenterTabBaseFragment).c2(iv9Var);
                    }
                }
            }
        }

        public void j(iv9 iv9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, iv9Var) == null) && iv9Var != null && iv9Var.i() != null && !ListUtils.isEmpty(this.b)) {
                for (int i = 0; i < this.b.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.X1(iv9Var.C);
                        personCenterTabBaseFragment.Y1(iv9Var.i());
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<PersonCenterTabBaseFragment> list = this.b;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947660486, "Lcom/baidu/tieba/bx9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947660486, "Lcom/baidu/tieba/bx9;");
                return;
            }
        }
        f1093T = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    }

    public cw9 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.I;
        }
        return (cw9) invokeV.objValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.d.resetData();
                this.d.a();
                this.l.k();
                return;
            }
            this.l.o();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.o();
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.v.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.N = -1;
            this.M = false;
            LottieSlideLoadingLayout lottieSlideLoadingLayout = this.q;
            if (lottieSlideLoadingLayout != null) {
                lottieSlideLoadingLayout.o();
            }
        }
    }

    public bx9(BaseFragment baseFragment, dv9 dv9Var, BdUniqueId bdUniqueId, boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, dv9Var, bdUniqueId, Boolean.valueOf(z), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        float f2 = f1093T;
        this.n = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
        this.o = 674.0f;
        this.M = false;
        this.N = -1;
        this.Q = new b(this);
        this.R = new c(this);
        this.m = baseFragment;
        this.a = baseFragment.getPageContext();
        this.k = bdUniqueId;
        this.j = z;
        this.L = j2;
        this.l = dv9Var.k();
        R(dv9Var.e);
    }

    public final void P(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            g gVar = new g(this, 2005016);
            this.h = gVar;
            gVar.setTag(this.k);
            tbPageContext.registerListener(this.h);
        }
    }

    public void W(ua9 ua9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ua9Var) == null) {
            this.d = ua9Var;
        }
    }

    public void X(uta utaVar) {
        ww9 ww9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, utaVar) == null) && (ww9Var = this.J) != null) {
            ww9Var.j(utaVar);
        }
    }

    public void O() {
        AlphaAnimation alphaAnimation;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && S() && (alphaAnimation = this.H) == null && alphaAnimation == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.H = alphaAnimation2;
            alphaAnimation2.setFillAfter(true);
            this.H.setDuration(300L);
            this.H.setAnimationListener(new i(this));
            this.v.startAnimation(this.H);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            cw9 cw9Var = this.I;
            if (cw9Var != null) {
                cw9Var.G();
            }
            ValueAnimator valueAnimator = this.K;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.K.removeAllListeners();
                this.K.removeAllUpdateListeners();
                this.K = null;
            }
            SafeHandler.getInst().removeCallbacks(this.Q);
        }
    }

    public final void Q(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            k kVar = new k(this, 2001435);
            this.e = kVar;
            kVar.setTag(this.k);
            tbPageContext.registerListener(this.e);
            l lVar = new l(this, 2016485);
            this.f = lVar;
            lVar.setTag(this.k);
            tbPageContext.registerListener(this.f);
            a aVar = new a(this, 2921435);
            this.g = aVar;
            aVar.setTag(this.k);
            tbPageContext.registerListener(this.g);
        }
    }

    public final void R(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            this.c = view2;
            this.p = UtilHelper.getStatusBarHeight();
            this.q = (LottieSlideLoadingLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091ba5);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ba8);
            this.r = new PersonHeaderBackgroundController(this.a, tbImageView, this.c.findViewById(R.id.obfuscated_res_0x7f091ba3), this.j);
            this.q.l(tbImageView);
            TbPageContext tbPageContext = this.a;
            View view3 = this.c;
            this.J = new ww9(tbPageContext, view3, view3.findViewById(R.id.obfuscated_res_0x7f091bc9), this.j);
            FrameLayout frameLayout = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091ba9);
            this.E = frameLayout;
            this.F = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            this.q.l(this.E);
            this.q.j(new d(this));
            AppBarLayout appBarLayout = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091ba0);
            this.s = appBarLayout;
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new e(this));
            this.t = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091bcb);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f091bca);
            this.u = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.u.setRectPaintColor(R.color.CAM_X0302);
            this.u.E(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds46), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds46), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds10), BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds46), true);
            this.u.setIndicatorOffset(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds64));
            this.u.setIndicatorOvershot(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds8));
            this.u.setIndicatorRadius(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds8));
            this.u.setIndicatorMarginBottom(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds0));
            this.u.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds166), -1));
            this.u.setOnPageChangeListener(new f(this));
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.D = gradientDrawable;
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            this.D.setCornerRadii(this.n);
            this.t.setBackgroundDrawable(this.D);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091bc5);
            this.v = findViewById;
            SkinManager.setBackgroundResource(findViewById, R.drawable.personalize_tab_shadow);
            this.w = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091bd5);
            m mVar = new m(this, this.m.getActivity().getSupportFragmentManager());
            this.x = mVar;
            this.w.setAdapter(mVar);
            this.w.setOffscreenPageLimit(this.x.b.size());
            this.x.notifyDataSetChanged();
            this.u.setViewPager(this.w);
            this.w.setCurrentItem(1);
            cw9 cw9Var = new cw9(this.a, this.j);
            this.I = cw9Var;
            cw9Var.H(this.R);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            this.E.addView(this.I.C(), layoutParams);
            if (this.J.f()) {
                Q(this.a);
            }
            P(this.a);
            this.b = (NoNetworkView) this.c.findViewById(R.id.obfuscated_res_0x7f091bc0);
            this.y = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091b9b);
            this.z = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091b9c);
            this.A = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091bc1);
        }
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            ww9 ww9Var = this.J;
            if (ww9Var != null) {
                ww9Var.g(i2);
            }
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.u;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
                this.u.setRectPaintColor(R.color.CAM_X0302);
                this.u.H();
            }
            GradientDrawable gradientDrawable = this.D;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            }
            cw9 cw9Var = this.I;
            if (cw9Var != null) {
                cw9Var.F(i2);
            }
            m mVar = this.x;
            if (mVar != null) {
                mVar.g(i2);
            }
            NoNetworkView noNetworkView = this.b;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a, i2);
            }
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.c, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.v, R.drawable.personalize_tab_shadow);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !S() && this.G == null) {
            this.v.setVisibility(0);
            if (this.G == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.G = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.G.setDuration(300L);
                this.G.setAnimationListener(new h(this));
                this.v.startAnimation(this.G);
            }
        }
    }

    public void Z(iv9 iv9Var, boolean z, PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048590, this, new Object[]{iv9Var, Boolean.valueOf(z), personStatus}) != null) || iv9Var == null) {
            return;
        }
        this.i = iv9Var;
        this.y.setVisibility(8);
        this.A.setVisibility(0);
        ww9 ww9Var = this.J;
        if (ww9Var != null) {
            ww9Var.l(iv9Var, personStatus);
        }
        cw9 cw9Var = this.I;
        if (cw9Var != null) {
            cw9Var.p(iv9Var);
        }
        PersonHeaderBackgroundController personHeaderBackgroundController = this.r;
        if (personHeaderBackgroundController != null) {
            personHeaderBackgroundController.e(this.i.j());
        }
        this.E.post(new j(this));
        this.x.j(iv9Var);
        this.x.i(iv9Var);
        if (ListUtils.isEmpty(iv9Var.f())) {
            this.l.l();
            BdUtilHelper.showToast(this.a.getContext(), this.a.getString(R.string.data_load_error));
            return;
        }
        PersonRedTipManager.getInstance().syncRedTipState(this.j);
        int size = iv9Var.f().size();
        for (int i2 = 0; i2 < size; i2++) {
            bn bnVar = iv9Var.f().get(i2);
            if (bnVar != null && (bnVar instanceof qv9)) {
                this.l.l();
                return;
            }
        }
        if (!z) {
            this.l.A(true, iv9Var.f());
        }
    }
}
