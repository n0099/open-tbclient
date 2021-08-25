package com.baidu.tieba.advert.sdk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AdSplashStyle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class SplashElement {
        public static final /* synthetic */ SplashElement[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SplashElement LABEL;
        public static final SplashElement LOGO;
        public static final SplashElement SKIP;
        public static final SplashElement VOICE;
        public static final SplashElement WIFI_TIP;
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
            LOGO = new SplashElement("LOGO", 0);
            SKIP = new SplashElement("SKIP", 1);
            LABEL = new SplashElement("LABEL", 2);
            VOICE = new SplashElement("VOICE", 3);
            SplashElement splashElement = new SplashElement("WIFI_TIP", 4);
            WIFI_TIP = splashElement;
            $VALUES = new SplashElement[]{LOGO, SKIP, LABEL, VOICE, splashElement};
        }

        public SplashElement(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SplashElement valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SplashElement) Enum.valueOf(SplashElement.class, str) : (SplashElement) invokeL.objValue;
        }

        public static SplashElement[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SplashElement[]) $VALUES.clone() : (SplashElement[]) invokeV.objValue;
        }
    }

    public AdSplashStyle() {
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
        TbadkCoreApplication.getInst().getString(R.string.advert_label);
    }
}
