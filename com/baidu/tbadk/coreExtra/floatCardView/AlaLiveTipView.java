package com.baidu.tbadk.coreExtra.floatCardView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.LiveRemindNormalConfigData;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tbadk.mutiprocess.live.LiveStartClickDataEvent;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.gu4;
import com.baidu.tieba.hu4;
import com.baidu.tieba.iz4;
import com.baidu.tieba.os4;
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
import com.baidu.tieba.u75;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaLiveTipView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public TbPageContext<?> a;
    public Context b;
    public TBLottieAnimationView c;
    public FrameLayout d;
    public TBLottieAnimationView e;
    public HeadImageView f;
    public ViewGroup g;
    public TextView h;
    public View i;
    public View j;
    public LiveRemindNormalConfigData k;
    public LiveRemindRecommendData l;
    public int m;
    public int n;
    public boolean o;
    public long p;
    public int q;
    public boolean r;
    public boolean s;
    public Runnable t;
    public String u;
    public String v;
    public String w;
    public boolean x;
    public String y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ AlaLiveTipView b;

        public a(AlaLiveTipView alaLiveTipView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = alaLiveTipView;
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AlaLiveTipView d;

        public b(AlaLiveTipView alaLiveTipView, View view2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView, view2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = alaLiveTipView;
            this.a = view2;
            this.b = i;
            this.c = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                IntEvaluator intEvaluator = new IntEvaluator();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.a.getLayoutParams().width = intEvaluator.evaluate(animatedFraction, Integer.valueOf(this.b), Integer.valueOf(this.c)).intValue();
                int i = this.c;
                int i2 = this.b;
                if (i - i2 > i2 && !this.d.v()) {
                    this.d.setBubbleClickable(true);
                }
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ AlaLiveTipView b;

        public c(AlaLiveTipView alaLiveTipView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = alaLiveTipView;
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ AlaLiveTipView b;

        public d(AlaLiveTipView alaLiveTipView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = alaLiveTipView;
            this.a = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.setVisibility(8);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AlaLiveTipView alaLiveTipView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView, Integer.valueOf(i)};
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
            this.a = alaLiveTipView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921728 && !customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                this.a.setData(gu4.a().b, gu4.a().c(this.a.m), false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AlaLiveTipView alaLiveTipView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView, Integer.valueOf(i)};
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
            this.a = alaLiveTipView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921733 && this.a.m == 2) {
                this.a.setData(gu4.a().b, gu4.a().c(this.a.m), false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AlaLiveTipView alaLiveTipView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView, Integer.valueOf(i)};
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
            this.a = alaLiveTipView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.C(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        public h(AlaLiveTipView alaLiveTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTipView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        public i(AlaLiveTipView alaLiveTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTipView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.playAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        public j(AlaLiveTipView alaLiveTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTipView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        public k(AlaLiveTipView alaLiveTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTipView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && this.a.q == 2) {
                this.a.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        public l(AlaLiveTipView alaLiveTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaLiveTipView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.a.r && !this.a.s) {
                    this.a.N(false);
                }
                this.a.setBubbleClickable(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AlaLiveTipView d;

        public m(AlaLiveTipView alaLiveTipView, View view2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTipView, view2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = alaLiveTipView;
            this.a = view2;
            this.b = i;
            this.c = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                IntEvaluator intEvaluator = new IntEvaluator();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.a.getLayoutParams().width = intEvaluator.evaluate(animatedFraction, Integer.valueOf(this.b), Integer.valueOf(this.c)).intValue();
                this.a.requestLayout();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveTipView(Context context) {
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
        this.o = true;
        this.p = 0L;
        this.r = false;
        this.s = true;
        this.t = null;
        this.u = "";
        this.v = "";
        this.w = "";
        this.x = false;
        this.z = new e(this, 2921728);
        this.A = new f(this, 2921733);
        this.B = new g(this, 2001304);
        t(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBubbleClickable(boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65550, this, z) == null) && (viewGroup = this.g) != null && this.o) {
            viewGroup.setClickable(z);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LiveRemindRecommendData liveRemindRecommendData = this.l;
            if (liveRemindRecommendData == null) {
                z();
                return;
            }
            String b2 = iz4.b(liveRemindRecommendData);
            if (StringUtils.isNull(b2)) {
                o("");
            } else {
                o(b2);
            }
        }
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                E();
                return;
            }
            LiveRemindRecommendData liveRemindRecommendData = this.l;
            if (liveRemindRecommendData != null) {
                this.f.K(liveRemindRecommendData.getLiveIconSrc(), 10, false);
            }
            O(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            O(i2);
            this.f.setSkinType(i2);
            SkinManager.setBackgroundShapeDrawable(this.g, ri.f(this.b, R.dimen.tbds74), R.color.CAM_X0310, R.color.CAM_X0310);
            os4 d2 = os4.d(this.h);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.c.cancelAnimation();
                this.i.clearAnimation();
                return;
            }
            this.c.playAnimation();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            O(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            B(z);
            N(false);
            if (this.x) {
                J();
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.g.getAnimation() == null) {
            if (this.o) {
                this.g.setVisibility(0);
            }
            m(this.g, ri.f(this.b, R.dimen.tbds74), ri.f(this.b, R.dimen.tbds74), new j(this), 100L, 0L);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (x()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_CLICK);
                l(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (u()) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_BIGPIC_RECOMMON_CLICK);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.addParam("fid", this.u);
                statisticItem2.addParam("fname", this.v);
                statisticItem2.addParam("tid", this.w);
                statisticItem2.addParam("obj_type", "1");
                TiebaStatic.log(statisticItem2);
            } else if (y()) {
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_NORMAL_CLICK);
                statisticItem3.addParam("obj_type", this.n);
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (x()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("fid", this.u);
                statisticItem.addParam("fname", this.v);
                statisticItem.addParam("tid", this.w);
                statisticItem.addParam("obj_type", "1");
                l(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (u()) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_BIGPIC_RECOMMON_SHOW);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.addParam("fid", this.u);
                statisticItem2.addParam("fname", this.v);
                statisticItem2.addParam("tid", this.w);
                statisticItem2.addParam("obj_type", "1");
                TiebaStatic.log(statisticItem2);
            } else if (y()) {
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_NORMAL_SHOW);
                statisticItem3.addParam("obj_type", this.n);
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (x()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_CLICK);
                l(statisticItem);
                TiebaStatic.log(statisticItem);
                return;
            }
            String str = "2";
            if (u()) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_BIGPIC_RECOMMON_CLICK);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.addParam("fid", this.u);
                statisticItem2.addParam("fname", this.v);
                statisticItem2.addParam("tid", this.w);
                statisticItem2.addParam("obj_type", "2");
                TiebaStatic.log(statisticItem2);
            } else if (y()) {
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_CLICK);
                LiveRemindRecommendData liveRemindRecommendData = this.l;
                String str2 = "";
                if (liveRemindRecommendData == null || liveRemindRecommendData.getYyExtData() == null) {
                    str = "";
                } else {
                    str2 = this.l.getYyExtData().mYyUid;
                    if (this.l.getYyExtData().isYyGame) {
                        str = "3";
                    }
                }
                statisticItem3.addParam("obj_type", this.n);
                statisticItem3.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem3.addParam("fid", this.u);
                statisticItem3.addParam("fname", this.v);
                statisticItem3.addParam("tid", this.w);
                statisticItem3.addParam("obj_param1", str2);
                statisticItem3.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
                l(statisticItem3);
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String str = "2";
            if (x()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("fid", this.u);
                statisticItem.addParam("fname", this.v);
                statisticItem.addParam("tid", this.w);
                statisticItem.addParam("obj_type", "2");
                l(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (u()) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_BIGPIC_RECOMMON_SHOW);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.addParam("fid", this.u);
                statisticItem2.addParam("fname", this.v);
                statisticItem2.addParam("tid", this.w);
                statisticItem2.addParam("obj_type", "2");
                TiebaStatic.log(statisticItem2);
            } else if (y()) {
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_SHOW);
                statisticItem3.addParam("obj_type", this.n);
                statisticItem3.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem3.addParam("fid", this.u);
                statisticItem3.addParam("fname", this.v);
                statisticItem3.addParam("tid", this.w);
                LiveRemindRecommendData liveRemindRecommendData = this.l;
                String str2 = "";
                if (liveRemindRecommendData == null || liveRemindRecommendData.getYyExtData() == null) {
                    str = "";
                } else {
                    str2 = this.l.getYyExtData().mYyUid;
                    if (this.l.getYyExtData().isYyGame) {
                        str = "3";
                    }
                }
                statisticItem3.addParam("obj_param1", str2);
                statisticItem3.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
                l(statisticItem3);
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.g.setVisibility(8);
            this.g.clearAnimation();
            removeCallbacks(this.t);
        }
    }

    public final void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                if (this.s) {
                    D(true);
                    q(this.i, this.d);
                    this.s = false;
                }
                if (!this.e.isAnimating()) {
                    this.e.cancelAnimation();
                    this.e.setSpeed(0.7f);
                    this.e.setRepeatMode(1);
                    this.e.setRepeatCount(-1);
                    this.e.post(new i(this));
                }
                if (this.f.getVisibility() == 0) {
                    hu4.b().f(LiveRemindConfig.Scene.LIVE_BUBBLE);
                    L();
                    return;
                }
                return;
            }
            D(false);
            if (this.e.isAnimating()) {
                this.e.cancelAnimation();
            }
            this.g.clearAnimation();
            if (this.s) {
                return;
            }
            q(this.d, this.i);
            this.s = true;
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (!u() && !y()) {
                if (x()) {
                    if (i2 == 0) {
                        setNormalLottieIcon("lottie_home_live_entrance/", R.raw.obfuscated_res_0x7f110040);
                        return;
                    } else {
                        setNormalLottieIcon("lottie_home_live_entrance_lh/", R.raw.obfuscated_res_0x7f110041);
                        return;
                    }
                }
                return;
            }
            setNormalLottieIcon("lottie_home_live_entrance_lh/", R.raw.obfuscated_res_0x7f110041);
        }
    }

    public void getPageContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Context context = this.b;
            if (context instanceof BaseActivity) {
                this.a = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.a = ((BaseFragmentActivity) context).getPageContext();
            }
        }
    }

    public final void l(StatisticItem statisticItem) {
        LiveRemindRecommendData liveRemindRecommendData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, statisticItem) == null) || (liveRemindRecommendData = this.l) == null || liveRemindRecommendData.getYyExtData() == null) {
            return;
        }
        YyExtData yyExtData = this.l.getYyExtData();
        statisticItem.param("liveid", this.l.getRoomId().longValue());
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
        statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSSID, yyExtData.mSsid);
        statisticItem.param(TiebaStatic.YYParams.YYUID, yyExtData.mYyUid);
        statisticItem.param("template_id", yyExtData.mTemplateId);
        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        statisticItem.param(TiebaStatic.Params.VID, this.l.getFeedId());
    }

    public final void m(View view2, int i2, int i3, AnimatorListenerAdapter animatorListenerAdapter, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), animatorListenerAdapter, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, view2.getTranslationX());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new m(this, view2, i2, i3));
            ofFloat2.setDuration(j2);
            ofFloat2.addUpdateListener(new a(this, view2));
            AnimatorSet animatorSet = new AnimatorSet();
            if (animatorListenerAdapter != null) {
                animatorSet.addListener(animatorListenerAdapter);
            }
            animatorSet.setStartDelay(j3);
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.start();
        }
    }

    public final void n(View view2, int i2, int i3, AnimatorListenerAdapter animatorListenerAdapter, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), animatorListenerAdapter, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(view2.getTranslationX(), 0.0f);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new b(this, view2, i2, i3));
            ofFloat2.setDuration(j2);
            ofFloat2.addUpdateListener(new c(this, view2));
            AnimatorSet animatorSet = new AnimatorSet();
            if (animatorListenerAdapter != null) {
                animatorSet.addListener(animatorListenerAdapter);
            }
            animatorSet.setStartDelay(j3);
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.start();
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                if (StringUtils.isNull(str)) {
                    new AlaTabFeedActivityConfig(getContext()).start();
                    return;
                } else {
                    UrlManager.getInstance().dealOneLink(this.a, new String[]{str}, true);
                    return;
                }
            }
            LiveStartClickDataEvent liveStartClickDataEvent = new LiveStartClickDataEvent();
            liveStartClickDataEvent.viewTag = str;
            u75.i(liveStartClickDataEvent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onAttachedToWindow();
            setData(gu4.a().b, gu4.a().c(this.m), true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            iz4.e();
            if (view2.getId() != R.id.obfuscated_res_0x7f0901c5 && view2.getId() != R.id.obfuscated_res_0x7f090200) {
                z();
                H();
                return;
            }
            if (this.q == 1) {
                p();
            }
            A();
            N(false);
            K();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDetachedFromWindow();
            this.s = true;
            M();
            MessageManager.getInstance().unRegisterListener(this.z);
            MessageManager.getInstance().unRegisterListener(this.A);
            MessageManager.getInstance().unRegisterListener(this.B);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ViewGroup viewGroup = this.g;
            m(viewGroup, viewGroup.getWidth(), ri.f(this.b, R.dimen.tbds74), new l(this), 500L, this.p);
        }
    }

    public final void q(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view2, view3) == null) {
            view3.setAlpha(0.0f);
            view3.setVisibility(0);
            view3.animate().alpha(1.0f).setDuration(800L).setListener(null);
            view2.animate().alpha(0.0f).setDuration(800L).setListener(new d(this, view2));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.q == 2 && this.p >= 0) {
                this.t = new h(this);
                sg.a().postDelayed(this.t, this.p);
                return;
            }
            this.r = false;
            removeCallbacks(this.t);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.g.getLayoutParams().width = -2;
            this.g.measure(0, 0);
            n(this.g, ri.f(this.b, R.dimen.tbds74), this.g.getMeasuredWidth(), new k(this), 500L, 1500L);
        }
    }

    public void setData(LiveRemindNormalConfigData liveRemindNormalConfigData, LiveRemindRecommendData liveRemindRecommendData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048602, this, liveRemindNormalConfigData, liveRemindRecommendData, z) == null) {
            this.k = liveRemindNormalConfigData;
            this.l = liveRemindRecommendData;
            this.x = z;
            if (liveRemindNormalConfigData == null) {
                F(true);
            } else if (liveRemindRecommendData != null && !w(liveRemindRecommendData)) {
                this.q = this.l.getDisappearType();
                this.p = this.l.getDisappearSecond() * 1000;
                this.h.setText(this.l.getDesc());
                B(false);
                if (hu4.b().j(LiveRemindConfig.Scene.LIVE_BUBBLE)) {
                    N(true);
                    G();
                } else if (this.x) {
                    J();
                }
                r();
            } else {
                F(false);
            }
        }
    }

    public void setForumInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, str, str2, str3) == null) {
            this.u = str;
            this.v = str2;
            this.w = str3;
        }
    }

    public void setHasBubble(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.o = z;
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    public void setNormalLottieIcon(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048605, this, str, i2) == null) || str.equals(this.y)) {
            return;
        }
        this.y = str;
        this.c.cancelAnimation();
        this.c.setImageAssetsFolder(str);
        this.c.setAnimation(i2);
        this.c.setRepeatMode(1);
        this.c.setRepeatCount(-1);
        this.c.setSpeed(0.67f);
        this.c.playAnimation();
    }

    public void setShowFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setViewLocate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.m = i2;
        }
    }

    public final void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00fd, (ViewGroup) this, true);
            this.b = context;
            this.i = findViewById(R.id.obfuscated_res_0x7f0916bc);
            this.c = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0916bd);
            this.d = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090272);
            this.g = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0901c5);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0901c4);
            this.j = findViewById(R.id.obfuscated_res_0x7f090200);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901ff);
            this.e = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f0901fe);
            this.f = headImageView;
            headImageView.setIsRound(true);
            this.f.setDefaultResource(17170445);
            this.f.setPlaceHolder(1);
            this.f.setRadius(ri.f(this.b, R.dimen.tbds37));
            this.f.setDrawBorder(true);
            this.f.setBorderWidth(R.dimen.L_X02);
            this.f.setBorderColor(SkinManager.getColor(R.color.CAM_X0622));
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.g.setOnClickListener(this);
            setBubbleClickable(false);
            C(TbadkCoreApplication.getInst().getSkinType());
            getPageContext();
            MessageManager.getInstance().registerListener(this.z);
            MessageManager.getInstance().registerListener(this.A);
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.m == 2 : invokeV.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            ViewGroup viewGroup = this.g;
            return viewGroup != null && viewGroup.isClickable();
        }
        return invokeV.booleanValue;
    }

    public final boolean w(LiveRemindRecommendData liveRemindRecommendData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, liveRemindRecommendData)) == null) ? liveRemindRecommendData == null || StringUtils.isNull(liveRemindRecommendData.getLiveIconSrc()) || StringUtils.isNull(liveRemindRecommendData.getDesc()) : invokeL.booleanValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.m == 1 : invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.m == 3 : invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            LiveRemindNormalConfigData liveRemindNormalConfigData = this.k;
            if (liveRemindNormalConfigData != null && !StringUtils.isNull(liveRemindNormalConfigData.getNormalIconScheme())) {
                o(iz4.a(this.k.getNormalIconScheme(), this.m));
            } else {
                o("");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveTipView(Context context, AttributeSet attributeSet) {
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
        this.o = true;
        this.p = 0L;
        this.r = false;
        this.s = true;
        this.t = null;
        this.u = "";
        this.v = "";
        this.w = "";
        this.x = false;
        this.z = new e(this, 2921728);
        this.A = new f(this, 2921733);
        this.B = new g(this, 2001304);
        t(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = true;
        this.p = 0L;
        this.r = false;
        this.s = true;
        this.t = null;
        this.u = "";
        this.v = "";
        this.w = "";
        this.x = false;
        this.z = new e(this, 2921728);
        this.A = new f(this, 2921733);
        this.B = new g(this, 2001304);
        t(context);
    }
}
