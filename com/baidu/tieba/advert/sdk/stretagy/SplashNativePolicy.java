package com.baidu.tieba.advert.sdk.stretagy;

import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b85;
import com.baidu.tieba.y66;
import com.baidu.tieba.zh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
/* loaded from: classes5.dex */
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

    @b85
    private native void nativeInitSplashPolicy(String str, String str2, int i, int i2, int i3, int i4, int i5);

    @b85
    private native void nativeReleaseSplash();

    @b85
    private native void nativeUpdateSplashConfig(int i, int i2, int i3, int i4, int i5);

    @b85
    private native void onNativeSplashEvent(int i, int i2);

    /* loaded from: classes5.dex */
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
                        y66.d().l(true);
                        return;
                    case 129:
                        y66.d().l(false);
                        return;
                    case 130:
                    case 132:
                    case 133:
                        y66.d().b();
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
        this.loadResult = zh.d().h("splash_policy", 1);
        PrintStream printStream = System.out;
        printStream.println("SplashPolicy loadResult: " + this.loadResult);
    }

    @b85
    public void eventCallback(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            PrintStream printStream = System.out;
            printStream.println("SplashPolicy eventCallback=>" + i);
            if (i != 128 && i != 129) {
                if (i == 131) {
                    y66.d().i(-1);
                } else if (i == 132) {
                    y66.d().i(-2);
                } else if (i == 130) {
                    y66.d().i(-3);
                }
            } else {
                int i3 = this.plgAdType;
                if (i3 > 120) {
                    i2 = 1;
                } else if (i3 == 120) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
                y66.d().i(i2);
            }
            if (BdUtilHelper.isMainThread()) {
                switch (i) {
                    case 128:
                        y66.d().l(true);
                        return;
                    case 129:
                        y66.d().l(false);
                        return;
                    case 130:
                    case 132:
                    case 133:
                        y66.d().b();
                        return;
                    case 131:
                    default:
                        return;
                }
            }
            SafeHandler.getInst().postAtFrontOfQueue(new a(this, i));
        }
    }

    public boolean initSplashPolicy(boolean z, boolean z2, boolean z3, int i, int i2) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (this.loadResult) {
                if (z) {
                    i3 = 32;
                } else {
                    i3 = 33;
                }
                if (z2) {
                    i4 = 17;
                } else {
                    i4 = 16;
                }
                if (z3) {
                    i5 = 48;
                } else {
                    i5 = 49;
                }
                nativeInitSplashPolicy("eventCallback", "(I)V", i3, i4, i5, i, i2);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean updateSplashConfig(boolean z, boolean z2, boolean z3, int i, int i2) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (this.loadResult) {
                if (z) {
                    i3 = 32;
                } else {
                    i3 = 33;
                }
                if (z2) {
                    i4 = 17;
                } else {
                    i4 = 16;
                }
                if (z3) {
                    i5 = 48;
                } else {
                    i5 = 49;
                }
                nativeUpdateSplashConfig(i3, i4, i5, i, i2);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean nativePolicyEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.loadResult;
        }
        return invokeV.booleanValue;
    }

    public void releaseSplash() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.loadResult) {
            nativeReleaseSplash();
        }
    }

    public void onSplashEvent(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.loadResult) {
            onNativeSplashEvent(i, 0);
        }
    }

    public void onSplashEvent(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && this.loadResult) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            this.plgAdType = 112;
                        } else {
                            this.plgAdType = 120;
                        }
                    } else {
                        this.plgAdType = 122;
                    }
                } else {
                    this.plgAdType = 113;
                }
            } else {
                this.plgAdType = 123;
            }
            onNativeSplashEvent(i, this.plgAdType);
        }
    }
}
