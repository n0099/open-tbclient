package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.ViewUtils;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class dva extends rua<SplashAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean e;
    public WeakReference<b> f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dva(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.SPLASH), pid, true, false, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new WeakReference<>(null);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new oua(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            SplashAD splashAD = (SplashAD) obj;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            this.e = false;
            a aVar = new a(this, r0, funAdSlot);
            onLoadStart(funAdSlot);
            SplashAD splashAD = new SplashAD(context.getApplicationContext(), this.mPid.pid, aVar, 0);
            SplashAD[] splashADArr = {splashAD};
            splashAD.fetchAdOnly();
        }
    }

    /* loaded from: classes5.dex */
    public class a implements SplashADZoomOutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final /* synthetic */ SplashAD[] c;
        public final /* synthetic */ FunAdSlot d;
        public final /* synthetic */ dva e;

        public a(dva dvaVar, SplashAD[] splashADArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dvaVar, splashADArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dvaVar;
            this.c = splashADArr;
            this.d = funAdSlot;
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public boolean isSupportZoomOut() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogPrinter.d("isSupportZoomOut", new Object[0]);
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.e.onAdShow(this.c[0], this.a, new String[0]);
                this.a = true;
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                LogPrinter.d();
                this.e.onAdLoaded((dva) this.c[0]);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adError) == null) {
                int errorCode = adError.getErrorCode();
                LogPrinter.e("onNoAD code: " + errorCode + ", message: " + adError.getErrorMsg(), new Object[0]);
                if (errorCode != 4005) {
                    this.e.onError(errorCode, adError.getErrorMsg());
                    return;
                }
                this.e.onAdError(this.c[0], adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOutPlayFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                LogPrinter.d("onZoomOutPlayFinish", new Object[0]);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.e.onAdClicked(this.c[0], this.b, new String[0]);
                this.b = true;
                b bVar = this.e.f.get();
                if (bVar != null) {
                    String sid = this.d.getSid();
                    FunSplashAdInteractionListener funSplashAdInteractionListener = bVar.e;
                    if (funSplashAdInteractionListener != null) {
                        funSplashAdInteractionListener.onAdClicked(sid);
                    }
                }
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.e.e = true;
                b bVar = this.e.f.get();
                if (bVar != null) {
                    bVar.c = true;
                }
                LogPrinter.d("onZoomOut", new Object[0]);
                this.e.onAdClose(this.c[0]);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                dva dvaVar = this.e;
                if (!dvaVar.e) {
                    dvaVar.onAdClose(this.c[0]);
                    return;
                }
                b bVar = dvaVar.f.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements FunSplashAd {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hva a;
        public SplashAD b;
        public boolean c;
        public ViewGroup d;
        public FunSplashAdInteractionListener e;

        /* loaded from: classes5.dex */
        public class a implements hva.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }
        }

        public b(SplashAD splashAD) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAD};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = splashAD;
        }

        @Override // com.fun.ad.sdk.FunSplashAd
        public void removeMiniWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                a();
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hva hvaVar = this.a;
                if (hvaVar != null) {
                    hvaVar.g = null;
                    hvaVar.h = null;
                }
                ViewUtils.removeFromParent(this.d);
                this.d = null;
                this.a = null;
                this.b = null;
                this.e = null;
            }
        }

        @Override // com.fun.ad.sdk.FunSplashAd
        public boolean showMiniWindow(Activity activity, boolean z, FunSplashAdInteractionListener funSplashAdInteractionListener) {
            InterceptResult invokeCommon;
            b bVar;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, Boolean.valueOf(z), funSplashAdInteractionListener})) == null) {
                if (activity != null) {
                    if (!this.c) {
                        LogPrinter.d("isZoomOutPulled == false, will not show mini window", new Object[0]);
                        return false;
                    }
                    hva hvaVar = this.a;
                    if (hvaVar == null) {
                        return false;
                    }
                    this.e = funSplashAdInteractionListener;
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
                    a aVar = new a(this);
                    hvaVar.getClass();
                    LogPrinter.d("zoomOut startZoomOut activity", new Object[0]);
                    com.fun.module.gdt.q qVar = null;
                    if (viewGroup != null && viewGroup2 != null) {
                        if (hvaVar.g != null && hvaVar.h != null) {
                            int[] iArr = new int[2];
                            viewGroup.getLocationOnScreen(iArr);
                            int[] iArr2 = hvaVar.k;
                            int i2 = iArr2[0] - iArr[0];
                            int i3 = iArr2[1] - iArr[1];
                            ViewUtils.removeFromParent(hvaVar.h);
                            viewGroup.addView(hvaVar.h, new FrameLayout.LayoutParams(hvaVar.i, hvaVar.j));
                            hvaVar.h.setX(i2);
                            hvaVar.h.setY(i3);
                            View view2 = hvaVar.h;
                            hvaVar.g = null;
                            hvaVar.h = null;
                            if (view2 != null) {
                                Context context = viewGroup2.getContext();
                                int[] iArr3 = new int[2];
                                view2.getLocationOnScreen(iArr3);
                                int width = view2.getWidth();
                                int height = view2.getHeight();
                                int width2 = viewGroup.getWidth();
                                int height2 = viewGroup.getHeight();
                                if (width2 == 0) {
                                    width2 = hvaVar.l;
                                }
                                if (height2 == 0) {
                                    height2 = hvaVar.m;
                                }
                                int i4 = hvaVar.a;
                                float f = i4 / width;
                                int i5 = hvaVar.b;
                                float f2 = i5 / height;
                                if (hvaVar.e == 0) {
                                    i = hvaVar.c;
                                } else {
                                    i = (width2 - hvaVar.c) - i4;
                                }
                                float f3 = i;
                                float f4 = (height2 - hvaVar.d) - i5;
                                LogPrinter.d("zoomOut animationContainerWidth:" + width2 + " animationContainerHeight:" + height2, new Object[0]);
                                StringBuilder sb = new StringBuilder();
                                sb.append("zoomOut splashScreenX:");
                                sb.append(iArr3[0]);
                                sb.append(" splashScreenY:");
                                sb.append(iArr3[1]);
                                LogPrinter.d(sb.toString(), new Object[0]);
                                LogPrinter.d("zoomOut splashWidth:" + width + " splashHeight:" + height, new Object[0]);
                                LogPrinter.d("zoomOut width:" + hvaVar.a + " height:" + hvaVar.b, new Object[0]);
                                LogPrinter.d("zoomOut animationDistX:" + f3 + " animationDistY:" + f4, new Object[0]);
                                ViewUtils.removeFromParent(view2);
                                viewGroup.addView(view2, new FrameLayout.LayoutParams(width, height));
                                com.fun.module.gdt.q qVar2 = new com.fun.module.gdt.q(context, hvaVar.c);
                                view2.setPivotX(0.0f);
                                view2.setPivotY(0.0f);
                                if (z) {
                                    view2.animate().scaleX(f).scaleY(f2).x(f3).y(f4).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(hvaVar.f).setListener(new gva(hvaVar, aVar, view2, viewGroup2, f3, f4, iArr3, qVar2));
                                } else {
                                    hvaVar.a(view2, viewGroup2, f3, f4, iArr3, qVar2, aVar);
                                }
                                bVar = this;
                                qVar = qVar2;
                                bVar.d = qVar;
                                return true;
                            }
                        } else {
                            LogPrinter.d("zoomOut splashAD or splashView is null", new Object[0]);
                        }
                    } else {
                        LogPrinter.d("zoomOut animationContainer or zoomOutContainer is null", new Object[0]);
                    }
                    bVar = this;
                    bVar.d = qVar;
                    return true;
                }
                throw new IllegalArgumentException();
            }
            return invokeCommon.booleanValue;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            SplashAD splashAD = (SplashAD) obj;
            onShowStart(splashAD);
            splashAD.showAd(viewGroup);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunSplashAd showSplashInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, obj)) == null) {
            SplashAD splashAD = (SplashAD) obj;
            onShowStart(splashAD);
            splashAD.showAd(viewGroup);
            b bVar = new b(splashAD);
            this.f = new WeakReference<>(bVar);
            View decorView = activity.getWindow().getDecorView();
            if (bVar.a == null) {
                bVar.a = new hva(decorView.getContext());
            }
            hva hvaVar = bVar.a;
            hvaVar.g = bVar.b;
            hvaVar.h = viewGroup;
            viewGroup.getLocationOnScreen(hvaVar.k);
            hvaVar.i = viewGroup.getWidth();
            hvaVar.j = viewGroup.getHeight();
            hvaVar.l = decorView.getWidth();
            hvaVar.m = decorView.getHeight();
            return bVar;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
