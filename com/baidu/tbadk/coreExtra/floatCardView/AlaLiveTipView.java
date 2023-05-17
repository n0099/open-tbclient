package com.baidu.tbadk.coreExtra.floatCardView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.LiveRemindNormalConfigData;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tbadk.mutiprocess.live.LiveStartClickDataEvent;
import com.baidu.tbadk.switchs.GifLibrarySwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.b65;
import com.baidu.tieba.c65;
import com.baidu.tieba.el5;
import com.baidu.tieba.ib5;
import com.baidu.tieba.m9;
import com.baidu.tieba.o65;
import com.baidu.tieba.p45;
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class AlaLiveTipView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AnimatorSet A;
    public boolean B;
    public boolean C;
    public boolean D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public TbPageContext<?> a;
    public Context b;
    public FrameLayout c;
    public TBLottieAnimationView d;
    public HeadImageView e;
    public ViewGroup f;
    public TextView g;
    public View h;
    public View i;
    public TbAlphaVideo j;
    public ImageView k;
    public LiveRemindNormalConfigData l;
    public LiveRemindRecommendData m;
    public int n;
    public boolean o;
    public long p;
    public int q;
    public boolean r;
    public boolean s;
    public Runnable t;
    public int u;
    public String v;
    public String w;
    public String x;
    public boolean y;
    public AnimatorSet z;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AlaLiveTipView d;

        public a(AlaLiveTipView alaLiveTipView, View view2, int i, int i2) {
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
                if (i - i2 > i2 && !this.d.H()) {
                    this.d.setBubbleClickable(true);
                }
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ AlaLiveTipView b;

        public b(AlaLiveTipView alaLiveTipView, View view2) {
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

    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
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

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AlaLiveTipView alaLiveTipView, int i) {
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
                this.a.setData(b65.a().b, b65.a().c(this.a.n), false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921733 && this.a.n == 2) {
                this.a.setData(b65.a().b, b65.a().c(this.a.n), false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.R(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements RequestListener<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTipView a;

        public g(AlaLiveTipView alaLiveTipView) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawable, obj, target, dataSource, Boolean.valueOf(z)})) == null) {
                o65.m().B("key_live_bubble_icon_cache_key", this.a.l.getNormalIconUrl());
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, target, Boolean.valueOf(z)})) == null) {
                this.a.k.post(new n(this.a, null));
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h extends AnimatorListenerAdapter {
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

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.a.C();
            this.a.B();
        }
    }

    /* loaded from: classes4.dex */
    public class i extends AnimatorListenerAdapter {
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

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, animator) != null) || this.a.q != 2) {
                return;
            }
            this.a.z();
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.r && !this.a.s) {
                    this.a.h0(false);
                }
                this.a.setBubbleClickable(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AlaLiveTipView d;

        public k(AlaLiveTipView alaLiveTipView, View view2, int i, int i2) {
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

    /* loaded from: classes4.dex */
    public class l implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ AlaLiveTipView b;

        public l(AlaLiveTipView alaLiveTipView, View view2) {
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

    /* loaded from: classes4.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AlaLiveTipView> a;

        public m(AlaLiveTipView alaLiveTipView) {
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
            this.a = new WeakReference<>(alaLiveTipView);
        }

        public /* synthetic */ m(AlaLiveTipView alaLiveTipView, d dVar) {
            this(alaLiveTipView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveTipView alaLiveTipView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (alaLiveTipView = this.a.get()) == null) {
                return;
            }
            alaLiveTipView.r = true;
        }
    }

    /* loaded from: classes4.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AlaLiveTipView> a;

        public n(AlaLiveTipView alaLiveTipView) {
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
            this.a = new WeakReference<>(alaLiveTipView);
        }

        public /* synthetic */ n(AlaLiveTipView alaLiveTipView, d dVar) {
            this(alaLiveTipView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveTipView alaLiveTipView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (alaLiveTipView = this.a.get()) == null) {
                return;
            }
            alaLiveTipView.O();
        }
    }

    /* loaded from: classes4.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AlaLiveTipView> a;

        public o(AlaLiveTipView alaLiveTipView) {
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
            this.a = new WeakReference<>(alaLiveTipView);
        }

        public /* synthetic */ o(AlaLiveTipView alaLiveTipView, d dVar) {
            this(alaLiveTipView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaLiveTipView alaLiveTipView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (alaLiveTipView = this.a.get()) != null && alaLiveTipView.B) {
                alaLiveTipView.d.playAnimation();
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
        this.v = "";
        this.w = "";
        this.x = "";
        this.y = false;
        this.B = true;
        this.E = new d(this, 2921728);
        this.F = new e(this, 2921733);
        this.G = new f(this, 2001304);
        E(context);
    }

    public final void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (z) {
                if (this.s) {
                    X(true);
                    A(this.h, this.c);
                    this.s = false;
                }
                if (!this.d.isAnimating()) {
                    this.d.cancelAnimation();
                    this.d.setSpeed(0.7f);
                    this.d.setRepeatMode(1);
                    this.d.setRepeatCount(-1);
                    this.d.post(new o(this, null));
                }
                if (this.e.getVisibility() == 0) {
                    c65.b().f(LiveRemindConfig.Scene.LIVE_BUBBLE);
                    f0();
                    return;
                }
                return;
            }
            if (this.d.isAnimating()) {
                this.d.cancelAnimation();
                this.f.clearAnimation();
            }
            if (!this.s) {
                X(false);
                A(this.c, this.h);
                this.s = true;
            }
        }
    }

    public final void r(StatisticItem statisticItem) {
        LiveRemindRecommendData liveRemindRecommendData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, statisticItem) == null) && (liveRemindRecommendData = this.m) != null && liveRemindRecommendData.getYyExtData() != null) {
            YyExtData yyExtData = this.m.getYyExtData();
            statisticItem.param("liveid", this.m.getRoomId().longValue());
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
            statisticItem.param(TiebaStatic.YYParams.YYSSID, yyExtData.mSsid);
            statisticItem.param(TiebaStatic.YYParams.YYUID, yyExtData.mYyUid);
            statisticItem.param("template_id", yyExtData.mTemplateId);
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.param(TiebaStatic.Params.VID, this.m.getFeedId());
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
        this.v = "";
        this.w = "";
        this.x = "";
        this.y = false;
        this.B = true;
        this.E = new d(this, 2921728);
        this.F = new e(this, 2921733);
        this.G = new f(this, 2001304);
        E(context);
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
        this.v = "";
        this.w = "";
        this.x = "";
        this.y = false;
        this.B = true;
        this.E = new d(this, 2921728);
        this.F = new e(this, 2921733);
        this.G = new f(this, 2001304);
        E(context);
    }

    public void setData(LiveRemindNormalConfigData liveRemindNormalConfigData, LiveRemindRecommendData liveRemindRecommendData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048618, this, liveRemindNormalConfigData, liveRemindRecommendData, z) == null) {
            this.l = liveRemindNormalConfigData;
            this.m = liveRemindRecommendData;
            this.y = z;
            if (liveRemindNormalConfigData == null) {
                a0(true);
            } else if (liveRemindRecommendData != null && !I(liveRemindRecommendData)) {
                this.q = this.m.getDisappearType();
                this.p = this.m.getDisappearSecond() * 1000;
                this.g.setText(this.m.getDesc());
                P(false);
                if (c65.b().j(LiveRemindConfig.Scene.LIVE_BUBBLE)) {
                    h0(true);
                    b0();
                } else if (this.y) {
                    d0();
                }
            } else {
                a0(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBubbleClickable(boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65554, this, z) == null) && (viewGroup = this.f) != null && this.o) {
            viewGroup.setClickable(z);
        }
    }

    public int D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (G() || K() || i2 != 0) {
                return R.raw.icon_ala_videotab_live_night;
            }
            return R.raw.icon_ala_videotab_live;
        }
        return invokeI.intValue;
    }

    public final boolean I(LiveRemindRecommendData liveRemindRecommendData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, liveRemindRecommendData)) == null) {
            if (liveRemindRecommendData != null && !StringUtils.isNull(liveRemindRecommendData.getLiveIconSrc()) && !StringUtils.isNull(liveRemindRecommendData.getDesc())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                p();
                return;
            }
            q();
            LiveRemindRecommendData liveRemindRecommendData = this.m;
            if (liveRemindRecommendData != null) {
                this.e.N(liveRemindRecommendData.getLiveIconSrc(), 10, false);
            }
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (GifLibrarySwitch.getIsOn()) {
                Y(z);
            } else {
                Z(z);
            }
        }
    }

    public final void Y(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048599, this, z) != null) || (imageView = this.k) == null) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof GifDrawable) {
            GifDrawable gifDrawable = (GifDrawable) drawable;
            if (z && gifDrawable.isRunning()) {
                gifDrawable.stop();
            } else if (this.B) {
                gifDrawable.start();
            }
        }
    }

    public final void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            P(z);
            h0(false);
            if (this.y) {
                d0();
            }
        }
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            boolean z = false;
            if (!G() && !K()) {
                if (J()) {
                    if (i2 == 0) {
                        z = true;
                    }
                    t(z);
                    return;
                }
                return;
            }
            t(false);
        }
    }

    public void setHasBubble(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.o = z;
            ViewGroup viewGroup = this.f;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            viewGroup.setVisibility(i2);
        }
    }

    public void setNormalBottomMarginParams(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i2;
                this.j.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setShowFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.u = i2;
        }
    }

    public void setViewLocate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.n = i2;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            if (z) {
                this.j.setAssetsAndPlay("home_live_entrance.mp4");
            } else {
                this.j.setAssetsAndPlay("home_live_entrance_lh.mp4");
            }
        }
    }

    public final void A(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            view3.setAlpha(0.0f);
            view3.setVisibility(0);
            view3.animate().alpha(1.0f).setDuration(800L).setListener(null);
            view2.animate().alpha(0.0f).setDuration(800L).setListener(new c(this, view2));
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.q == 2 && this.p >= 0) {
                this.t = new m(this, null);
                sg.a().postDelayed(this.t, this.p);
                return;
            }
            this.r = false;
            removeCallbacks(this.t);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.getLayoutParams().width = -2;
            this.f.measure(0, 0);
            x(this.f, ri.g(this.b, R.dimen.tbds74), this.f.getMeasuredWidth(), new i(this), 500L, BoxAccountManager.GET_SHARE_LOGIN_INFO_DEFAULT_TIMEOUT);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LiveRemindNormalConfigData liveRemindNormalConfigData = this.l;
            if (liveRemindNormalConfigData != null && !StringUtils.isNull(liveRemindNormalConfigData.getNormalIconScheme())) {
                y(ib5.a(this.l.getNormalIconScheme(), this.n));
            } else {
                y("");
            }
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.o) {
                this.f.setVisibility(0);
            }
            if (this.f.getAnimation() == null) {
                u(this.f, ri.g(this.b, R.dimen.tbds74), ri.g(this.b, R.dimen.tbds74), new h(this), 100L, 0L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDetachedFromWindow();
            this.s = true;
            g0();
            s();
            MessageManager.getInstance().unRegisterListener(this.E);
            MessageManager.getInstance().unRegisterListener(this.F);
            MessageManager.getInstance().unRegisterListener(this.G);
        }
    }

    public final void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.ala_live_tip_view, (ViewGroup) this, true);
            this.b = context;
            this.h = findViewById(R.id.normal_ala_container);
            this.j = (TbAlphaVideo) findViewById(R.id.normal_ala_entrance_img);
            this.k = (ImageView) findViewById(R.id.normal_ala_entrance_img_glide);
            this.c = (FrameLayout) findViewById(R.id.anchor_recommend_ala_entrance_view);
            this.f = (ViewGroup) findViewById(R.id.ala_bubble_view);
            this.g = (TextView) findViewById(R.id.ala_bubble_content);
            this.i = findViewById(R.id.ala_living_user_container);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.ala_living_lottie);
            this.d = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.ala_living_head_image);
            this.e = headImageView;
            headImageView.setIsRound(true);
            this.e.setDefaultResource(17170445);
            this.e.setPlaceHolder(1);
            this.e.setRadius(ri.g(this.b, R.dimen.tbds37));
            this.e.setDrawBorder(true);
            this.e.setBorderWidth(R.dimen.L_X02);
            this.e.setBorderColor(SkinManager.getColor(R.color.CAM_X0622));
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.f.setOnClickListener(this);
            setBubbleClickable(false);
            R(TbadkCoreApplication.getInst().getSkinType());
            getPageContext();
            MessageManager.getInstance().registerListener(this.E);
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.G);
            F();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (GifLibrarySwitch.getIsOn()) {
                this.k.setVisibility(0);
                this.j.setVisibility(8);
                return;
            }
            this.j.setVisibility(0);
            this.k.setVisibility(8);
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.n == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ViewGroup viewGroup = this.f;
            if (viewGroup != null && viewGroup.isClickable()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.n == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.n == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            LiveRemindRecommendData liveRemindRecommendData = this.m;
            if (liveRemindRecommendData == null) {
                M();
                return;
            }
            String b2 = ib5.b(liveRemindRecommendData);
            if (StringUtils.isNull(b2)) {
                y("");
            } else {
                y(b2);
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.B = false;
            U();
        }
    }

    public void T() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.B = true;
            if (this.D) {
                Y(false);
            }
            if (this.C && (tBLottieAnimationView = this.d) != null) {
                tBLottieAnimationView.playAnimation();
            }
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            V();
            W();
        }
    }

    public final void V() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (imageView = this.k) == null) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof GifDrawable) {
            GifDrawable gifDrawable = (GifDrawable) drawable;
            if (gifDrawable.isRunning()) {
                this.D = true;
                gifDrawable.stop();
            }
        }
    }

    public final void W() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (tBLottieAnimationView = this.d) != null && tBLottieAnimationView.isAnimating()) {
            this.C = true;
            this.d.pauseAnimation();
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f.setVisibility(8);
            this.f.clearAnimation();
            removeCallbacks(this.t);
        }
    }

    public void getPageContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            Context context = this.b;
            if (context instanceof BaseActivity) {
                this.a = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.a = ((BaseFragmentActivity) context).getPageContext();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onAttachedToWindow();
            setData(b65.a().b, b65.a().c(this.n), true);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (GifLibrarySwitch.getIsOn()) {
                O();
            } else {
                i0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (GifLibrarySwitch.getIsOn()) {
                Q();
            } else {
                i0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            AnimatorSet animatorSet = this.A;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.A.removeAllListeners();
                this.A = null;
            }
            AnimatorSet animatorSet2 = this.z;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
                this.z.removeAllListeners();
                this.z = null;
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            ViewGroup viewGroup = this.f;
            u(viewGroup, viewGroup.getWidth(), ri.g(this.b, R.dimen.tbds74), new j(this), 500L, this.p);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            String s = o65.m().s("key_live_bubble_icon_cache_key", "");
            int D = D(TbadkCoreApplication.getInst().getSkinType());
            Context context = this.b;
            boolean z = false;
            if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) this.b).isDestroyed())) {
                z = true;
            }
            if (!z) {
                Glide.with(this.b).load(s).error(Glide.with(this.b).load(Integer.valueOf(D))).into(this.k);
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (J()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_CLICK);
                r(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (G()) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_BIGPIC_RECOMMON_CLICK);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.addParam("fid", this.v);
                statisticItem2.addParam("fname", this.w);
                statisticItem2.addParam("tid", this.x);
                statisticItem2.addParam("obj_type", "1");
                TiebaStatic.log(statisticItem2);
            } else if (K()) {
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_NORMAL_CLICK);
                statisticItem3.addParam("obj_type", this.u);
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (J()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("fid", this.v);
                statisticItem.addParam("fname", this.w);
                statisticItem.addParam("tid", this.x);
                statisticItem.addParam("obj_type", "1");
                r(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (G()) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_BIGPIC_RECOMMON_SHOW);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.addParam("fid", this.v);
                statisticItem2.addParam("fname", this.w);
                statisticItem2.addParam("tid", this.x);
                statisticItem2.addParam("obj_type", "1");
                TiebaStatic.log(statisticItem2);
            } else if (K()) {
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_NORMAL_SHOW);
                statisticItem3.addParam("obj_type", this.u);
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.l == null) {
            return;
        }
        RequestOptions diskCacheStrategy = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
        Context context = this.b;
        boolean z = false;
        if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) this.b).isDestroyed())) {
            z = true;
        }
        if (!z) {
            Glide.with(this.b).load(this.l.getNormalIconUrl()).apply((BaseRequestOptions<?>) diskCacheStrategy).listener(new g(this)).into(this.k);
        }
    }

    public void R(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            i0(i2);
            this.e.setSkinType(i2);
            SkinManager.setBackgroundShapeDrawable(this.f, ri.g(this.b, R.dimen.tbds74), R.color.CAM_X0310, R.color.CAM_X0310);
            p45 d2 = p45.d(this.g);
            d2.C(R.string.F_X01);
            d2.B(R.dimen.T_X09);
            d2.w(R.color.CAM_X0101);
        }
    }

    public final void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (z) {
                if (this.j.e()) {
                    this.j.h();
                }
            } else if (this.j.d() || this.j.f()) {
                this.j.i();
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (J()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_CLICK);
                r(statisticItem);
                TiebaStatic.log(statisticItem);
                return;
            }
            String str = "2";
            if (G()) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_BIGPIC_RECOMMON_CLICK);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.addParam("fid", this.v);
                statisticItem2.addParam("fname", this.w);
                statisticItem2.addParam("tid", this.x);
                statisticItem2.addParam("obj_type", "2");
                TiebaStatic.log(statisticItem2);
            } else if (K()) {
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_CLICK);
                LiveRemindRecommendData liveRemindRecommendData = this.m;
                String str2 = "";
                if (liveRemindRecommendData == null || liveRemindRecommendData.getYyExtData() == null) {
                    str = "";
                } else {
                    str2 = this.m.getYyExtData().mYyUid;
                    if (this.m.getYyExtData().isYyGame) {
                        str = "3";
                    }
                }
                statisticItem3.addParam("obj_type", this.u);
                statisticItem3.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem3.addParam("fid", this.v);
                statisticItem3.addParam("fname", this.w);
                statisticItem3.addParam("tid", this.x);
                statisticItem3.addParam("obj_param1", str2);
                statisticItem3.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
                r(statisticItem3);
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            String str = "2";
            if (J()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("fid", this.v);
                statisticItem.addParam("fname", this.w);
                statisticItem.addParam("tid", this.x);
                statisticItem.addParam("obj_type", "2");
                r(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (G()) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_BIGPIC_RECOMMON_SHOW);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.addParam("fid", this.v);
                statisticItem2.addParam("fname", this.w);
                statisticItem2.addParam("tid", this.x);
                statisticItem2.addParam("obj_type", "2");
                TiebaStatic.log(statisticItem2);
            } else if (K()) {
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_SHOW);
                statisticItem3.addParam("obj_type", this.u);
                statisticItem3.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem3.addParam("fid", this.v);
                statisticItem3.addParam("fname", this.w);
                statisticItem3.addParam("tid", this.x);
                LiveRemindRecommendData liveRemindRecommendData = this.m;
                String str2 = "";
                if (liveRemindRecommendData == null || liveRemindRecommendData.getYyExtData() == null) {
                    str = "";
                } else {
                    str2 = this.m.getYyExtData().mYyUid;
                    if (this.m.getYyExtData().isYyGame) {
                        str = "3";
                    }
                }
                statisticItem3.addParam("obj_param1", str2);
                statisticItem3.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
                r(statisticItem3);
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, view2) != null) || FullBrowseHelper.checkAndShowFullBrowseModeDialog(m9.a(getContext()))) {
            return;
        }
        ib5.e();
        if (view2.getId() != R.id.ala_bubble_view && view2.getId() != R.id.ala_living_user_container) {
            M();
            c0();
            return;
        }
        if (this.q == 1) {
            z();
        }
        N();
        h0(false);
        e0();
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
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
            el5.i(liveStartClickDataEvent);
        }
    }

    public void setForumInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048619, this, str, str2, str3) == null) {
            this.v = str;
            this.w = str2;
            this.x = str3;
        }
    }

    public final void u(View view2, int i2, int i3, AnimatorListenerAdapter animatorListenerAdapter, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), animatorListenerAdapter, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, view2.getTranslationX());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new k(this, view2, i2, i3));
            ofFloat2.setDuration(j2);
            ofFloat2.addUpdateListener(new l(this, view2));
            AnimatorSet animatorSet = new AnimatorSet();
            this.z = animatorSet;
            if (animatorListenerAdapter != null) {
                animatorSet.addListener(animatorListenerAdapter);
            }
            this.z.setStartDelay(j3);
            this.z.play(ofFloat).with(ofFloat2);
            this.z.start();
        }
    }

    public final void x(View view2, int i2, int i3, AnimatorListenerAdapter animatorListenerAdapter, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), animatorListenerAdapter, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(view2.getTranslationX(), 0.0f);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new a(this, view2, i2, i3));
            ofFloat2.setDuration(j2);
            ofFloat2.addUpdateListener(new b(this, view2));
            AnimatorSet animatorSet = new AnimatorSet();
            this.A = animatorSet;
            if (animatorListenerAdapter != null) {
                animatorSet.addListener(animatorListenerAdapter);
            }
            this.A.setStartDelay(j3);
            this.A.play(ofFloat).with(ofFloat2);
            this.A.start();
        }
    }
}
