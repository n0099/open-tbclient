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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.header.PersonHeaderBackgroundController;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.yf8;
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
/* loaded from: classes4.dex */
public class fa8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int S = 5000;
    public static final float T;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public int B;
    public int C;
    public GradientDrawable D;
    public FrameLayout E;
    public FrameLayout.LayoutParams F;
    public AlphaAnimation G;
    public AlphaAnimation H;
    public g98 I;
    public aa8 J;
    public ValueAnimator K;
    public long L;
    public boolean M;
    public int N;
    public int O;
    public boolean P;
    public Runnable Q;
    public b88 R;
    public TbPageContext a;
    public NoNetworkView b;
    public View c;
    public xo7 d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public m88 i;
    public boolean j;
    public BdUniqueId k;
    public g88 l;
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

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fa8 fa8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var, Integer.valueOf(i)};
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
            this.a = fa8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.a.N == ((Integer) customResponsedMessage.getData()).intValue() && this.a.M) {
                gh.a().removeCallbacks(this.a.Q);
                this.a.V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        public b(fa8 fa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.M) {
                this.a.V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b88 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        public c(fa8 fa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa8Var;
        }

        @Override // com.baidu.tieba.b88
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.P = z;
                if (this.a.I == null || this.a.I.B() == null) {
                    return;
                }
                this.a.I.B().setOpen(z);
            }
        }

        @Override // com.baidu.tieba.b88
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.F.height = -2;
                this.a.E.setLayoutParams(this.a.F);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements cz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        public d(fa8 fa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa8Var;
        }

        @Override // com.baidu.tieba.cz4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.cz4
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                gh.a().postDelayed(this.a.Q, fa8.S);
                this.a.M = true;
                fa8 fa8Var = this.a;
                fa8Var.N = fa8Var.x.d();
                this.a.M();
                this.a.x.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        public e(fa8 fa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa8Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, this.a.a.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.a.a.getPageActivity());
                }
                this.a.q.setEnableSlideLoading(i == 0);
                int abs = Math.abs(i);
                this.a.J.i(abs == 0);
                float f = abs;
                this.a.J.m(f > this.a.o / 2.0f);
                float abs2 = ((double) this.a.o) == 0.0d ? 0.0f : Math.abs(f / this.a.o);
                this.a.J.h(abs2);
                if (abs2 >= 1.0f) {
                    this.a.n = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.a.D.setCornerRadii(this.a.n);
                    this.a.t.setBackgroundDrawable(this.a.D);
                    this.a.Y();
                } else {
                    this.a.n = new float[]{fa8.T, fa8.T, fa8.T, fa8.T, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.a.D.setCornerRadii(this.a.n);
                    this.a.t.setBackgroundDrawable(this.a.D);
                    this.a.O();
                }
                int i2 = this.a.C - this.a.B;
                if (this.a.C <= 0 || Math.abs(i) < i2) {
                    return;
                }
                this.a.q.o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        public f(fa8 fa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa8Var;
        }

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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.x.h(i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(fa8 fa8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var, Integer.valueOf(i)};
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
            this.a = fa8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.a.J == null) {
                return;
            }
            this.a.J.n();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        public h(fa8 fa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa8Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.G.reset();
                this.a.G = null;
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
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        public i(fa8 fa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa8Var;
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
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        public j(fa8 fa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            fa8 fa8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.B == 0) {
                fa8 fa8Var2 = this.a;
                fa8Var2.B = fa8Var2.E.getMeasuredHeight();
                this.a.o = fa8Var.E.getMeasuredHeight() - this.a.J.e().getMeasuredHeight();
                if (this.a.r != null) {
                    fa8 fa8Var3 = this.a;
                    fa8Var3.O = fa8Var3.p + this.a.J.e().getMeasuredHeight() + this.a.E.getMeasuredHeight() + this.a.u.getMeasuredHeight();
                    boolean z = (this.a.j || this.a.i.j() == null || this.a.i.j().getNewGodData() == null || !this.a.i.j().getNewGodData().isNewGod()) ? false : true;
                    this.a.F.height = this.a.O;
                    this.a.E.setLayoutParams(this.a.F);
                    this.a.O += z ? f98.b0 : 0;
                    this.a.F.height = -2;
                    this.a.E.setLayoutParams(this.a.F);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(fa8 fa8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var, Integer.valueOf(i)};
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
            this.a = fa8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof yf8)) {
                SparseArray<yf8.a> sparseArray = ((yf8) customResponsedMessage.getData()).a;
                if (sparseArray.size() <= 0) {
                    return;
                }
                yf8.a aVar = sparseArray.get(2);
                if (this.a.I != null && aVar != null) {
                    this.a.I.I(aVar.a);
                }
                yf8.a aVar2 = sparseArray.get(4);
                yf8.a aVar3 = sparseArray.get(3);
                yf8.a aVar4 = sparseArray.get(1);
                yf8.a aVar5 = sparseArray.get(7);
                yf8.a aVar6 = sparseArray.get(8);
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
                    if (aVar6 == null || this.a.i.y == null || this.a.i.y.b == null) {
                        return;
                    }
                    this.a.i.y.b.putBoolean("person_center_item_red_tip_show", aVar6.a);
                    this.a.i.y.b.putString("person_center_item_txt", String.valueOf(aVar6.b));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(fa8 fa8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var, Integer.valueOf(i)};
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
            this.a = fa8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || (userPendantData = (UserPendantData) customResponsedMessage.getData()) == null) {
                return;
            }
            this.a.I.K(userPendantData.getImgUrl());
        }
    }

    /* loaded from: classes4.dex */
    public class m extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;
        public List<PersonCenterTabBaseFragment> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(fa8 fa8Var, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa8Var, fragmentManager};
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
            arrayList.add(fa8Var.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e49));
            this.a.add(fa8Var.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e4c));
            this.a.add(fa8Var.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e48));
            ArrayList arrayList2 = new ArrayList();
            this.b = arrayList2;
            arrayList2.add(PersonCenterMainTabFragment.w1(fa8Var.L, fa8Var.j));
            this.b.add(PersonCenterThreadTabFragment.D1(fa8Var.L, fa8Var.j));
            this.b.add(PersonCenterDynamicTabFragment.A1(fa8Var.L, fa8Var.j));
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.b)) {
                return;
            }
            for (int i = 0; i < this.b.size(); i++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.q1(false);
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
                        return personCenterTabBaseFragment.r1();
                    }
                }
                return -1;
            }
            return invokeV.intValue;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.a.get(i) : (String) invokeI.objValue;
        }

        public void g(int i) {
            List<PersonCenterTabBaseFragment> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (list = this.b) == null || list.size() <= 0) {
                return;
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i2);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.onChangeSkinType(i);
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

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? e(i) : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? f(i) : (CharSequence) invokeI.objValue;
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

        public void i(m88 m88Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, m88Var) == null) || m88Var == null || ListUtils.isEmpty(this.b)) {
                return;
            }
            for (int i = 0; i < this.b.size(); i++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                if (personCenterTabBaseFragment instanceof PersonCenterMainTabFragment) {
                    ((PersonCenterMainTabFragment) personCenterTabBaseFragment).z1(m88Var);
                }
            }
        }

        public void j(m88 m88Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, m88Var) == null) || m88Var == null || m88Var.i() == null || ListUtils.isEmpty(this.b)) {
                return;
            }
            for (int i = 0; i < this.b.size(); i++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.b.get(i);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.t1(m88Var.C);
                    personCenterTabBaseFragment.u1(m88Var.i());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947757516, "Lcom/baidu/tieba/fa8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947757516, "Lcom/baidu/tieba/fa8;");
                return;
            }
        }
        T = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    }

    public fa8(BaseFragment baseFragment, h88 h88Var, BdUniqueId bdUniqueId, boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, h88Var, bdUniqueId, Boolean.valueOf(z), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        float f2 = T;
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
        this.l = h88Var.k();
        R(h88Var.e);
    }

    public g98 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.I : (g98) invokeV.objValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.d.resetData();
                this.d.b();
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

    public final void P(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            g gVar = new g(this, 2005016);
            this.h = gVar;
            gVar.setTag(this.k);
            tbPageContext.registerListener(this.h);
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
            this.q = (LottieSlideLoadingLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918e4);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0918e6);
            this.r = new PersonHeaderBackgroundController(this.a, tbImageView, this.c.findViewById(R.id.obfuscated_res_0x7f0918e2), this.j);
            this.q.l(tbImageView);
            TbPageContext tbPageContext = this.a;
            View view3 = this.c;
            this.J = new aa8(tbPageContext, view3, view3.findViewById(R.id.obfuscated_res_0x7f091907), this.j);
            FrameLayout frameLayout = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918e7);
            this.E = frameLayout;
            this.F = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            this.q.l(this.E);
            this.q.j(new d(this));
            AppBarLayout appBarLayout = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918df);
            this.s = appBarLayout;
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new e(this));
            this.t = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091909);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f091908);
            this.u = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.u.setRectPaintColor(R.color.CAM_X0302);
            this.u.B(ej.f(this.a.getPageActivity(), R.dimen.tbds46), ej.f(this.a.getPageActivity(), R.dimen.tbds46), ej.f(this.a.getPageActivity(), R.dimen.tbds10), ej.f(this.a.getPageActivity(), R.dimen.tbds46), true);
            this.u.setIndicatorOffset(ej.f(this.a.getPageActivity(), R.dimen.tbds64));
            this.u.setIndicatorOvershot(ej.f(this.a.getPageActivity(), R.dimen.tbds8));
            this.u.setIndicatorRadius(ej.f(this.a.getPageActivity(), R.dimen.tbds8));
            this.u.setIndicatorMarginBottom(ej.f(this.a.getPageActivity(), R.dimen.tbds0));
            this.u.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(ej.f(this.a.getPageActivity(), R.dimen.tbds166), -1));
            this.u.setOnPageChangeListener(new f(this));
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.D = gradientDrawable;
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            this.D.setCornerRadii(this.n);
            this.t.setBackgroundDrawable(this.D);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091903);
            this.v = findViewById;
            SkinManager.setBackgroundResource(findViewById, R.drawable.personalize_tab_shadow);
            this.w = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091913);
            m mVar = new m(this, this.m.getActivity().getSupportFragmentManager());
            this.x = mVar;
            this.w.setAdapter(mVar);
            this.w.setOffscreenPageLimit(this.x.b.size());
            this.x.notifyDataSetChanged();
            this.u.setViewPager(this.w);
            this.w.setCurrentItem(1);
            g98 g98Var = new g98(this.a, this.j);
            this.I = g98Var;
            g98Var.H(this.R);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            this.E.addView(this.I.C(), layoutParams);
            if (this.J.f()) {
                Q(this.a);
            }
            P(this.a);
            this.b = (NoNetworkView) this.c.findViewById(R.id.obfuscated_res_0x7f0918fe);
            this.y = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918da);
            this.z = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918db);
            this.A = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918ff);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.v.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            aa8 aa8Var = this.J;
            if (aa8Var != null) {
                aa8Var.g(i2);
            }
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.u;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
                this.u.setRectPaintColor(R.color.CAM_X0302);
                this.u.G();
            }
            GradientDrawable gradientDrawable = this.D;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            }
            g98 g98Var = this.I;
            if (g98Var != null) {
                g98Var.F(i2);
            }
            m mVar = this.x;
            if (mVar != null) {
                mVar.g(i2);
            }
            NoNetworkView noNetworkView = this.b;
            if (noNetworkView != null) {
                noNetworkView.d(this.a, i2);
            }
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.c, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.v, R.drawable.personalize_tab_shadow);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g98 g98Var = this.I;
            if (g98Var != null) {
                g98Var.G();
            }
            ValueAnimator valueAnimator = this.K;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.K.removeAllListeners();
                this.K.removeAllUpdateListeners();
                this.K = null;
            }
            gh.a().removeCallbacks(this.Q);
        }
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

    public void W(xo7 xo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, xo7Var) == null) {
            this.d = xo7Var;
        }
    }

    public void X(cz8 cz8Var) {
        aa8 aa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, cz8Var) == null) || (aa8Var = this.J) == null) {
            return;
        }
        aa8Var.j(cz8Var);
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

    public void Z(m88 m88Var, boolean z, PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{m88Var, Boolean.valueOf(z), personStatus}) == null) || m88Var == null) {
            return;
        }
        this.i = m88Var;
        this.y.setVisibility(8);
        this.A.setVisibility(0);
        aa8 aa8Var = this.J;
        if (aa8Var != null) {
            aa8Var.l(m88Var, personStatus);
        }
        g98 g98Var = this.I;
        if (g98Var != null) {
            g98Var.p(m88Var);
        }
        PersonHeaderBackgroundController personHeaderBackgroundController = this.r;
        if (personHeaderBackgroundController != null) {
            personHeaderBackgroundController.e(this.i.j());
        }
        this.E.post(new j(this));
        this.x.j(m88Var);
        this.x.i(m88Var);
        if (ListUtils.isEmpty(m88Var.f())) {
            this.l.l();
            ej.N(this.a.getContext(), this.a.getString(R.string.obfuscated_res_0x7f0f048c));
            return;
        }
        PersonRedTipManager.getInstance().syncRedTipState(this.j);
        int size = m88Var.f().size();
        for (int i2 = 0; i2 < size; i2++) {
            Cdo cdo = m88Var.f().get(i2);
            if (cdo != null && (cdo instanceof u88)) {
                this.l.l();
                return;
            }
        }
        if (z) {
            return;
        }
        this.l.y(true, m88Var.f());
    }
}
