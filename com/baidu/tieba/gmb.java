package com.baidu.tieba;

import android.animation.Animator;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.PxUtils;
import com.fun.ad.sdk.internal.api.utils.ViewUtils;
/* loaded from: classes6.dex */
public class gmb implements FunSplashAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTSplashAd a;
    public final View b;
    public final Pair<Integer, Integer> c;
    public final int d;
    public final int e;
    public boolean f;
    public int g;
    public int h;
    public FrameLayout i;
    public FunSplashAdInteractionListener j;

    public gmb(TTSplashAd tTSplashAd) {
        Integer valueOf;
        int round;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tTSplashAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = PxUtils.dp2px(16.0f);
        this.e = PxUtils.dp2px(100.0f);
        this.i = new FrameLayout(FunAdSdk.getAppContext());
        tTSplashAd.setSplashClickEyeListener(new a(this));
        this.a = tTSplashAd;
        this.b = tTSplashAd.getSplashView();
        int[] splashClickEyeSizeToDp = tTSplashAd.getSplashClickEyeSizeToDp();
        if (splashClickEyeSizeToDp == null || splashClickEyeSizeToDp.length != 2) {
            DisplayMetrics displayMetrics = FunAdSdk.getAppContext().getResources().getDisplayMetrics();
            int round2 = Math.round(Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) * 0.3f);
            valueOf = Integer.valueOf(round2);
            round = Math.round((round2 * 16) / 9.0f);
        } else {
            valueOf = Integer.valueOf(PxUtils.dp2px(splashClickEyeSizeToDp[0]));
            round = PxUtils.dp2px(splashClickEyeSizeToDp[1]);
        }
        this.c = Pair.create(valueOf, Integer.valueOf(round));
    }

    public final void a(ViewGroup viewGroup, float f, float f2, int[] iArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, Float.valueOf(f), Float.valueOf(f2), iArr, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            ViewUtils.removeFromParent(this.b);
            this.b.setScaleX(1.0f);
            this.b.setScaleY(1.0f);
            this.b.setX(0.0f);
            this.b.setY(0.0f);
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            float f3 = (f2 - iArr2[1]) + iArr[1];
            this.i.addView(this.b, -1, -1);
            viewGroup.addView(this.i, new FrameLayout.LayoutParams(i, i2));
            this.i.setTranslationX((f - iArr2[0]) + iArr[0]);
            this.i.setTranslationY(f3);
            this.a.splashClickEyeAnimationFinish();
        }
    }

    @Override // com.fun.ad.sdk.FunSplashAd
    public void removeMiniWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            FrameLayout frameLayout = this.i;
            if (frameLayout != null) {
                ViewUtils.removeFromParent(frameLayout);
                this.i = null;
            }
            this.j = null;
        }
    }

    @Override // com.fun.ad.sdk.FunSplashAd
    public boolean showMiniWindow(Activity activity, boolean z, FunSplashAdInteractionListener funSplashAdInteractionListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, Boolean.valueOf(z), funSplashAdInteractionListener})) == null) {
            if (activity != null) {
                if (!this.f) {
                    LogPrinter.d("showMiniWindow failed without support", new Object[0]);
                    return false;
                } else if (this.i == null) {
                    LogPrinter.d("showMiniWindow failed:Can't showMiniWindow again", new Object[0]);
                    return false;
                } else {
                    this.j = funSplashAdInteractionListener;
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(16908290);
                    int[] iArr = new int[2];
                    this.b.getLocationOnScreen(iArr);
                    int width = this.b.getWidth();
                    int height = this.b.getHeight();
                    int i = this.g;
                    int i2 = this.h;
                    if (i == 0 || i2 == 0) {
                        LogPrinter.d("showMiniWindow failed without invalid origin view width and height", new Object[0]);
                        return false;
                    }
                    int intValue = ((Integer) this.c.first).intValue();
                    int intValue2 = ((Integer) this.c.second).intValue();
                    float f = intValue / width;
                    float f2 = intValue2 / height;
                    float f3 = (i - this.d) - intValue;
                    float f4 = (i2 - this.e) - intValue2;
                    ViewUtils.removeFromParent(this.b);
                    viewGroup.addView(this.b, new FrameLayout.LayoutParams(width, height));
                    this.b.setPivotX(0.0f);
                    this.b.setPivotY(0.0f);
                    if (z) {
                        this.b.animate().scaleX(f).scaleY(f2).x(f3).y(f4).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(300L).setListener(new b(this, viewGroup2, f3, f4, iArr, intValue, intValue2));
                        return true;
                    }
                    a(viewGroup2, f3, f4, iArr, intValue, intValue2);
                    return true;
                }
            }
            throw new IllegalArgumentException();
        }
        return invokeCommon.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements ISplashClickEyeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gmb a;

        public a(gmb gmbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gmbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gmbVar;
        }

        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
        public boolean isSupportSplashClickEye(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.a.f = z;
                LogPrinter.d("isSupportSplashClickEye:" + z, new Object[0]);
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
        public void onSplashClickEyeAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
        public void onSplashClickEyeAnimationFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                ViewUtils.removeFromParent(this.a.i);
                this.a.i = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ gmb g;

        public b(gmb gmbVar, ViewGroup viewGroup, float f, float f2, int[] iArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gmbVar, viewGroup, Float.valueOf(f), Float.valueOf(f2), iArr, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = gmbVar;
            this.a = viewGroup;
            this.b = f;
            this.c = f2;
            this.d = iArr;
            this.e = i;
            this.f = i2;
        }

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

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.g.a(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }
}
