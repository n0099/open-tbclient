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
public final class MobileDeviceType {
    public static final /* synthetic */ MobileDeviceType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MobileDeviceType ADROID_PAD;
    public static final MobileDeviceType ANDROID_PHONE;
    public static final MobileDeviceType IPAD;
    public static final MobileDeviceType IPHONE;
    public static final MobileDeviceType IPOD;
    public static final MobileDeviceType UNKNOWN_DEVICE;
    public transient /* synthetic */ FieldHolder $fh;
    public int type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1273246010, "Lcom/baidu/tieba/advert/sdk/data/MobileDeviceType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1273246010, "Lcom/baidu/tieba/advert/sdk/data/MobileDeviceType;");
                return;
            }
        }
        UNKNOWN_DEVICE = new MobileDeviceType("UNKNOWN_DEVICE", 0, 0);
        IPHONE = new MobileDeviceType("IPHONE", 1, 1);
        IPAD = new MobileDeviceType("IPAD", 2, 2);
        IPOD = new MobileDeviceType("IPOD", 3, 3);
        ANDROID_PHONE = new MobileDeviceType("ANDROID_PHONE", 4, 4);
        MobileDeviceType mobileDeviceType = new MobileDeviceType("ADROID_PAD", 5, 5);
        ADROID_PAD = mobileDeviceType;
        $VALUES = new MobileDeviceType[]{UNKNOWN_DEVICE, IPHONE, IPAD, IPOD, ANDROID_PHONE, mobileDeviceType};
    }

    public MobileDeviceType(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = i2;
    }

    public static MobileDeviceType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (MobileDeviceType) Enum.valueOf(MobileDeviceType.class, str);
        }
        return (MobileDeviceType) invokeL.objValue;
    }

    public static MobileDeviceType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (MobileDeviceType[]) $VALUES.clone();
        }
        return (MobileDeviceType[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }
}
