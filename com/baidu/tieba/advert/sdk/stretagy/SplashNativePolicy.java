package com.baidu.tieba.advert.sdk.stretagy;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ii;
import com.repackage.mi;
import com.repackage.ml5;
import com.repackage.ng;
import com.repackage.nt4;
import java.io.PrintStream;
/* loaded from: classes3.dex */
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
    public int plgAdType;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(SplashNativePolicy splashNativePolicy, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashNativePolicy, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                switch (this.a) {
                    case 128:
                        ml5.e().p(true);
                        return;
                    case 129:
                        ml5.e().p(false);
                        return;
                    case 130:
                    case 132:
                    case 133:
                        ml5.e().c();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.plgAdType = 0;
        this.loadResult = ii.d().h("splash_policy", 1);
        PrintStream printStream = System.out;
        printStream.println("SplashPolicy loadResult: " + this.loadResult);
    }

    @nt4
    private native void nativeInitSplashPolicy(String str, String str2, int i, int i2, int i3, int i4, int i5);

    @nt4
    private native void nativeReleaseSplash();

    @nt4
    private native void nativeUpdateSplashConfig(int i, int i2, int i3, int i4, int i5);

    @nt4
    private native void onNativeSplashEvent(int i, int i2);

    @nt4
    public void eventCallback(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            PrintStream printStream = System.out;
            printStream.println("SplashPolicy eventCallback=>" + i);
            if (i == 128 || i == 129) {
                int i2 = this.plgAdType;
                ml5.e().k(i2 > 120 ? 1 : i2 == 120 ? 2 : 3);
            } else if (i == 131) {
                ml5.e().k(-1);
            } else if (i == 132) {
                ml5.e().k(-2);
            } else if (i == 130) {
                ml5.e().k(-3);
            }
            if (mi.B()) {
                switch (i) {
                    case 128:
                        ml5.e().p(true);
                        return;
                    case 129:
                        ml5.e().p(false);
                        return;
                    case 130:
                    case 132:
                    case 133:
                        ml5.e().c();
                        return;
                    case 131:
                    default:
                        return;
                }
            }
            ng.a().postAtFrontOfQueue(new a(this, i));
        }
    }

    public boolean initSplashPolicy(boolean z, boolean z2, boolean z3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (this.loadResult) {
                nativeInitSplashPolicy("eventCallback", "(I)V", z ? 32 : 33, z2 ? 17 : 16, z3 ? 48 : 49, i, i2);
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

    public void onSplashEvent(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.loadResult) {
            onNativeSplashEvent(i, 0);
        }
    }

    public void releaseSplash() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.loadResult) {
            nativeReleaseSplash();
        }
    }

    public boolean updateSplashConfig(boolean z, boolean z2, boolean z3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (this.loadResult) {
                nativeUpdateSplashConfig(z ? 32 : 33, z2 ? 17 : 16, z3 ? 48 : 49, i, i2);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void onSplashEvent(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && this.loadResult) {
            if (i2 == 0) {
                this.plgAdType = 123;
            } else if (i2 == 1) {
                this.plgAdType = 113;
            } else if (i2 == 2) {
                this.plgAdType = 122;
            } else if (i2 != 3) {
                this.plgAdType = 112;
            } else {
                this.plgAdType = 120;
            }
            onNativeSplashEvent(i, this.plgAdType);
        }
    }
}
