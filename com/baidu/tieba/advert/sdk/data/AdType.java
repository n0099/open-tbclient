package com.baidu.tieba.advert.sdk.data;

import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class AdType {
    public static final /* synthetic */ AdType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdType BANNER;
    public static final AdType INTERS;
    public static final AdType NATIVE;
    public static final AdType SPLASH;
    public transient /* synthetic */ FieldHolder $fh;
    public int typeId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(526168923, "Lcom/baidu/tieba/advert/sdk/data/AdType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(526168923, "Lcom/baidu/tieba/advert/sdk/data/AdType;");
                return;
            }
        }
        BANNER = new AdType("BANNER", 0, 13);
        INTERS = new AdType("INTERS", 1, 11);
        SPLASH = new AdType("SPLASH", 2, 12);
        AdType adType = new AdType(Constant.TYPE_NATIVE, 3, 14);
        NATIVE = adType;
        $VALUES = new AdType[]{BANNER, INTERS, SPLASH, adType};
    }

    public AdType(String str, int i2, int i3) {
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
        this.typeId = i3;
    }

    public static AdType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdType) Enum.valueOf(AdType.class, str) : (AdType) invokeL.objValue;
    }

    public static AdType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdType[]) $VALUES.clone() : (AdType[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.typeId : invokeV.intValue;
    }
}
