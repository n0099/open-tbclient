package com.baidu.tieba.advert.sdk.data;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class AdSplashStyle$SplashElement {
    public static final /* synthetic */ AdSplashStyle$SplashElement[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdSplashStyle$SplashElement LABEL;
    public static final AdSplashStyle$SplashElement LOGO;
    public static final AdSplashStyle$SplashElement SKIP;
    public static final AdSplashStyle$SplashElement VOICE;
    public static final AdSplashStyle$SplashElement WIFI_TIP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2031944218, "Lcom/baidu/tieba/advert/sdk/data/AdSplashStyle$SplashElement;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2031944218, "Lcom/baidu/tieba/advert/sdk/data/AdSplashStyle$SplashElement;");
                return;
            }
        }
        LOGO = new AdSplashStyle$SplashElement("LOGO", 0);
        SKIP = new AdSplashStyle$SplashElement("SKIP", 1);
        LABEL = new AdSplashStyle$SplashElement("LABEL", 2);
        VOICE = new AdSplashStyle$SplashElement("VOICE", 3);
        AdSplashStyle$SplashElement adSplashStyle$SplashElement = new AdSplashStyle$SplashElement("WIFI_TIP", 4);
        WIFI_TIP = adSplashStyle$SplashElement;
        $VALUES = new AdSplashStyle$SplashElement[]{LOGO, SKIP, LABEL, VOICE, adSplashStyle$SplashElement};
    }

    public AdSplashStyle$SplashElement(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static AdSplashStyle$SplashElement valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (AdSplashStyle$SplashElement) Enum.valueOf(AdSplashStyle$SplashElement.class, str);
        }
        return (AdSplashStyle$SplashElement) invokeL.objValue;
    }

    public static AdSplashStyle$SplashElement[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (AdSplashStyle$SplashElement[]) $VALUES.clone();
        }
        return (AdSplashStyle$SplashElement[]) invokeV.objValue;
    }
}
