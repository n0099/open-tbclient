package com.baidu.tieba.advert.sdk.data;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class LandingPageType {
    public static final /* synthetic */ LandingPageType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LandingPageType BROWSER;
    public static final LandingPageType DOWNLOAD;
    public static final LandingPageType UNKNOW;
    public static final LandingPageType WEBVIEW;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1244117438, "Lcom/baidu/tieba/advert/sdk/data/LandingPageType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1244117438, "Lcom/baidu/tieba/advert/sdk/data/LandingPageType;");
                return;
            }
        }
        UNKNOW = new LandingPageType("UNKNOW", 0, 0);
        WEBVIEW = new LandingPageType("WEBVIEW", 1, 1);
        BROWSER = new LandingPageType("BROWSER", 2, 2);
        LandingPageType landingPageType = new LandingPageType("DOWNLOAD", 3, 3);
        DOWNLOAD = landingPageType;
        $VALUES = new LandingPageType[]{UNKNOW, WEBVIEW, BROWSER, landingPageType};
    }

    public LandingPageType(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i3;
    }

    public static LandingPageType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LandingPageType) Enum.valueOf(LandingPageType.class, str) : (LandingPageType) invokeL.objValue;
    }

    public static LandingPageType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LandingPageType[]) $VALUES.clone() : (LandingPageType[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
