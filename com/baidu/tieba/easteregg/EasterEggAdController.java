package com.baidu.tieba.easteregg;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.easteregg.EasterEggAdController;
import com.baidu.tieba.easteregg.data.EasterEggAdData;
import com.baidu.tieba.easteregg.view.CountDownView;
import com.baidu.tieba.easteregg.view.EasterEggAdEdgeFloat;
import com.baidu.tieba.easteregg.view.EasterEggAdView;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lpa;
import com.baidu.tieba.nu6;
import com.baidu.tieba.xz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J \u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/tieba/easteregg/EasterEggAdController;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "easterEggAdData", "Lcom/baidu/tieba/easteregg/data/EasterEggAdData;", "easterEggAdEdgeFloat", "Lcom/baidu/tieba/easteregg/view/EasterEggAdEdgeFloat;", "easterEggAdView", "Lcom/baidu/tieba/easteregg/view/EasterEggAdView;", "getEasterEggAdView", "()Lcom/baidu/tieba/easteregg/view/EasterEggAdView;", "easterEggAdView$delegate", "Lkotlin/Lazy;", "onScreenSizeChangedCallback", "com/baidu/tieba/easteregg/EasterEggAdController$onScreenSizeChangedCallback$1", "Lcom/baidu/tieba/easteregg/EasterEggAdController$onScreenSizeChangedCallback$1;", "showStartTime", "", "url", "", "viewHeight", "", "clickCheckReq", "", "objLocate", "clickStat", "isSuccess", "", "hideAd", "showAd", "showCheckReq", "showStat", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EasterEggAdController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final int b;
    public String c;
    public long d;
    public EasterEggAdData e;
    public final Lazy f;
    public final c g;
    public final EasterEggAdEdgeFloat h;

    /* loaded from: classes5.dex */
    public static final class a implements ThirdStatisticHelper.ThirdStatisticCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggAdController a;
        public final /* synthetic */ EasterEggAdData b;
        public final /* synthetic */ int c;

        public a(EasterEggAdController easterEggAdController, EasterEggAdData easterEggAdData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggAdController, easterEggAdData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggAdController;
            this.b = easterEggAdData;
            this.c = i;
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.k(this.b, false, this.c);
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
                return;
            }
            this.a.k(this.b, true, this.c);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggAdController a;

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

        public b(EasterEggAdController easterEggAdController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggAdController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggAdController;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                DefaultLog.getInstance().i("easterEgg", "彩蛋广告执行退场动画执行完成");
                this.a.l().b();
                this.a.h.e();
                YunDialogManager.unMarkShowingDialogName("easterEgg");
                lpa.i.a().l(false);
                nu6.b().b(new xz6());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements EdgeFloat.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggAdController a;

        public c(EasterEggAdController easterEggAdController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggAdController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggAdController;
        }

        @Override // com.baidu.tieba.edgefloat.EdgeFloat.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.h.f(i, EasterEggAdEdgeFloat.c.a());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, this.a.b);
                layoutParams.gravity = 80;
                this.a.l().setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggAdController a;

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

        public d(EasterEggAdController easterEggAdController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggAdController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggAdController;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                DefaultLog.getInstance().i("easterEgg", "彩蛋广告入场动画执行完成，开始倒计时");
                this.a.l().i();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements ThirdStatisticHelper.ThirdStatisticCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggAdController a;
        public final /* synthetic */ EasterEggAdData b;

        public e(EasterEggAdController easterEggAdController, EasterEggAdData easterEggAdData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggAdController, easterEggAdData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggAdController;
            this.b = easterEggAdData;
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.r(this.b, false);
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.r(this.b, true);
            }
        }
    }

    public EasterEggAdController(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.b = UtilHelper.getDimenPixelSize(R.dimen.tbds286);
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<EasterEggAdView>(this) { // from class: com.baidu.tieba.easteregg.EasterEggAdController$easterEggAdView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EasterEggAdController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes5.dex */
            public static final class a implements CountDownView.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EasterEggAdController a;

                public a(EasterEggAdController easterEggAdController) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {easterEggAdController};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = easterEggAdController;
                }

                @Override // com.baidu.tieba.easteregg.view.CountDownView.a
                public void a(CountDownView.CloseType closeType) {
                    String str;
                    EasterEggAdData easterEggAdData;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, closeType) == null) {
                        Intrinsics.checkNotNullParameter(closeType, "closeType");
                        if (closeType == CountDownView.CloseType.CLICK) {
                            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append(EasterEggAdData.KEY_EASTER_EGG_AD);
                            sb.append(TbadkCoreApplication.getCurrentAccount());
                            str = this.a.c;
                            sb.append(str);
                            sharedPrefHelper.putBoolean(sb.toString(), true);
                            EasterEggAdController easterEggAdController = this.a;
                            easterEggAdData = easterEggAdController.e;
                            if (easterEggAdData == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("easterEggAdData");
                                easterEggAdData = null;
                            }
                            easterEggAdController.j(easterEggAdData, 4);
                        }
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.i("easterEgg", "彩蛋广告关闭，关闭类型：" + closeType.name());
                        this.a.m();
                    }
                }
            }

            /* loaded from: classes5.dex */
            public static final class b implements EasterEggAdView.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EasterEggAdController a;

                public b(EasterEggAdController easterEggAdController) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {easterEggAdController};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = easterEggAdController;
                }

                @Override // com.baidu.tieba.easteregg.view.EasterEggAdView.a
                public void a() {
                    EasterEggAdData easterEggAdData;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        DefaultLog.getInstance().i("easterEgg", "彩蛋广告内容点击");
                        EasterEggAdController easterEggAdController = this.a;
                        easterEggAdData = easterEggAdController.e;
                        if (easterEggAdData == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("easterEggAdData");
                            easterEggAdData = null;
                        }
                        easterEggAdController.j(easterEggAdData, 1);
                        this.a.m();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EasterEggAdView invoke() {
                InterceptResult invokeV;
                Activity activity2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (EasterEggAdView) invokeV.objValue;
                }
                activity2 = this.this$0.a;
                EasterEggAdView easterEggAdView = new EasterEggAdView(activity2, null, 0, 6, null);
                EasterEggAdController easterEggAdController = this.this$0;
                easterEggAdView.setCountDownCloseCallback(new a(easterEggAdController));
                easterEggAdView.setOnContentClickCallback(new b(easterEggAdController));
                return easterEggAdView;
            }
        });
        this.g = new c(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()), this.b);
        layoutParams.gravity = 80;
        l().setLayoutParams(layoutParams);
        this.h = new EasterEggAdEdgeFloat(this.a, 83, 0, TbadkCoreApplication.getInst().getNormalMainTabBarHeight(), false, CollectionsKt__CollectionsJVMKt.listOf("MainTabActivity"), l(), this.g);
    }

    public final void o(EasterEggAdData easterEggAdData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, easterEggAdData) == null) {
            Intrinsics.checkNotNullParameter(easterEggAdData, "easterEggAdData");
            lpa.i.a().l(true);
            DefaultLog.getInstance().i("easterEgg", "彩蛋广告开始展示");
            this.e = easterEggAdData;
            l().g(easterEggAdData);
            l().setTranslationY(this.b);
            this.h.g();
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(this.b, 0.0f);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.qz6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        EasterEggAdController.p(EasterEggAdController.this, valueAnimator2);
                    }
                }
            });
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
            valueAnimator.addListener(new d(this));
            valueAnimator.setDuration(500L);
            DefaultLog.getInstance().i("easterEgg", "彩蛋广告执行入场动画");
            valueAnimator.start();
            this.c = easterEggAdData.getUrl();
            q(easterEggAdData);
        }
    }

    public static final void n(EasterEggAdController this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            EasterEggAdView l = this$0.l();
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                l.setTranslationY(((Float) animatedValue).floatValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final void p(EasterEggAdController this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            EasterEggAdView l = this$0.l();
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                l.setTranslationY(((Float) animatedValue).floatValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public final void j(EasterEggAdData easterEggAdData, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, easterEggAdData, i) == null) {
            List<String> clickStatisticsUrls = easterEggAdData.getClickStatisticsUrls();
            if (clickStatisticsUrls != null && !clickStatisticsUrls.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                k(easterEggAdData, false, i);
                return;
            }
            List<String> clickStatisticsUrls2 = easterEggAdData.getClickStatisticsUrls();
            if (clickStatisticsUrls2 != null) {
                for (String str : clickStatisticsUrls2) {
                    ThirdStatisticHelper.sendReq(str, new a(this, easterEggAdData, i));
                }
            }
        }
    }

    public final void r(EasterEggAdData easterEggAdData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, easterEggAdData, z) == null) {
            TiebaStatic.log(new StatisticItem("c15274").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", easterEggAdData.getResType()).param("obj_param1", !z ? 1 : 0));
        }
    }

    public final void k(EasterEggAdData easterEggAdData, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{easterEggAdData, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            TiebaStatic.log(new StatisticItem("c15275").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", i).param("obj_type", easterEggAdData.getResType()).param("obj_param1", !z ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, (System.currentTimeMillis() / 1000) - this.d));
        }
    }

    public final EasterEggAdView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (EasterEggAdView) this.f.getValue();
        }
        return (EasterEggAdView) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            DefaultLog.getInstance().i("easterEgg", "彩蛋广告开始隐藏");
            int i = 0;
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, this.b);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pz6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        EasterEggAdController.n(EasterEggAdController.this, valueAnimator2);
                    }
                }
            });
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
            valueAnimator.addListener(new b(this));
            valueAnimator.setDuration(250L);
            valueAnimator.setInterpolator(new FastOutLinearInInterpolator());
            DefaultLog.getInstance().i("easterEgg", "彩蛋广告执行退场动画");
            valueAnimator.start();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = StringUtil.NULL_STRING;
            }
            Integer num = lpa.i.a().c().get(currentAccount);
            if (num != null) {
                i = num.intValue();
            }
            lpa.i.a().c().put(currentAccount, Integer.valueOf(i + 1));
        }
    }

    public final void q(EasterEggAdData easterEggAdData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, easterEggAdData) == null) {
            this.d = System.currentTimeMillis() / 1000;
            List<String> showStatisticsUrls = easterEggAdData.getShowStatisticsUrls();
            if (showStatisticsUrls != null && !showStatisticsUrls.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                r(easterEggAdData, false);
                return;
            }
            List<String> showStatisticsUrls2 = easterEggAdData.getShowStatisticsUrls();
            if (showStatisticsUrls2 != null) {
                for (String str : showStatisticsUrls2) {
                    ThirdStatisticHelper.sendReq(str, new e(this, easterEggAdData));
                }
            }
        }
    }
}
