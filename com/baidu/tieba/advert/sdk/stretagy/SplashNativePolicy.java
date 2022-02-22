package com.baidu.tieba.advert.sdk.stretagy;

import c.a.d.f.m.e;
import c.a.d.f.p.j;
import c.a.t0.s.b0.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
/* loaded from: classes12.dex */
public class SplashNativePolicy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SPLASH_BEAR_CHANNEL_FAIL = 82;
    public static final int SPLASH_BEAR_CHANNEL_SUCC = 81;
    public static final int SPLASH_BEAR_CLOSE = 33;
    public static final int SPLASH_BEAR_OPEN = 32;
    public static final int SPLASH_CMD_ERROR = 133;
    public static final int SPLASH_CMD_FIRST_TIMEOUT = 131;
    public static final int SPLASH_CMD_JUMP_MAIN = 130;
    public static final int SPLASH_CMD_LAST_TIMEOUT = 132;
    public static final int SPLASH_CMD_SHOW_BEAR = 128;
    public static final int SPLASH_CMD_SHOW_PLG = 129;
    public static final int SPLASH_PLG_BUSYNESS = 123;
    public static final int SPLASH_PLG_CHANNEL_FAIL = 66;
    public static final int SPLASH_PLG_CHANNEL_SUCC = 65;
    public static final int SPLASH_PLG_CLOSE = 16;
    public static final int SPLASH_PLG_CPC = 120;
    public static final int SPLASH_PLG_CPC_CLOSE = 49;
    public static final int SPLASH_PLG_CPC_OPEN = 48;
    public static final int SPLASH_PLG_HIGH = 122;
    public static final int SPLASH_PLG_NORMAL = 113;
    public static final int SPLASH_PLG_OPEN = 17;
    public static final int SPLASH_PLG_OTHERS = 112;
    public static final int SPLASH_REQUEST_START = 96;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean loadResult;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f42062e;

        public a(SplashNativePolicy splashNativePolicy, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashNativePolicy, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42062e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.f42062e) {
                    case 128:
                        c.a.u0.y.a.g.a.d().n(true);
                        return;
                    case SplashNativePolicy.SPLASH_CMD_SHOW_PLG /* 129 */:
                        c.a.u0.y.a.g.a.d().n(false);
                        return;
                    case 130:
                    case 132:
                    case SplashNativePolicy.SPLASH_CMD_ERROR /* 133 */:
                        c.a.u0.y.a.g.a.d().b();
                        return;
                    case 131:
                    default:
                        return;
                }
            }
        }
    }

    public SplashNativePolicy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.loadResult = j.d().h("splash_policy", 1);
        PrintStream printStream = System.out;
        printStream.println("SplashPolicy loadResult: " + this.loadResult);
    }

    @o
    private native void nativeInitSplashPolicy(String str, String str2, int i2, int i3, int i4, int i5, int i6);

    @o
    private native void nativeReleaseSplash();

    @o
    private native void nativeUpdateSplashConfig(int i2, int i3, int i4, int i5, int i6);

    @o
    private native void onNativeSplashEvent(int i2, int i3);

    @o
    public void eventCallback(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            PrintStream printStream = System.out;
            printStream.println("SplashPolicy eventCallback=>" + i2);
            e.a().post(new a(this, i2));
        }
    }

    public boolean initSplashPolicy(boolean z, boolean z2, boolean z3, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (this.loadResult) {
                nativeInitSplashPolicy("eventCallback", "(I)V", z ? 32 : 33, z2 ? 17 : 16, z3 ? 48 : 49, i2, i3);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean nativePolicyEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.loadResult : invokeV.booleanValue;
    }

    public void onSplashEvent(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.loadResult) {
            onNativeSplashEvent(i2, 0);
        }
    }

    public void releaseSplash() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.loadResult) {
            nativeReleaseSplash();
        }
    }

    public boolean updateSplashConfig(boolean z, boolean z2, boolean z3, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (this.loadResult) {
                nativeUpdateSplashConfig(z ? 32 : 33, z2 ? 17 : 16, z3 ? 48 : 49, i2, i3);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void onSplashEvent(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) && this.loadResult) {
            onNativeSplashEvent(i2, i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? 112 : 120 : 122 : 113 : 123);
        }
    }
}
