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
public final class WirelessNetworkType {
    public static final /* synthetic */ WirelessNetworkType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final WirelessNetworkType MOBILE_2G;
    public static final WirelessNetworkType MOBILE_3G;
    public static final WirelessNetworkType MOBILE_4G;
    public static final WirelessNetworkType NETWORKTYPE_INVALID;
    public static final WirelessNetworkType NETWORKTYPE_WAP;
    public static final WirelessNetworkType UNKNOWN_NETWORK;
    public static final WirelessNetworkType WIFI;
    public transient /* synthetic */ FieldHolder $fh;
    public int type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-886672620, "Lcom/baidu/tieba/advert/sdk/data/WirelessNetworkType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-886672620, "Lcom/baidu/tieba/advert/sdk/data/WirelessNetworkType;");
                return;
            }
        }
        UNKNOWN_NETWORK = new WirelessNetworkType("UNKNOWN_NETWORK", 0, 0);
        WIFI = new WirelessNetworkType("WIFI", 1, 1);
        MOBILE_2G = new WirelessNetworkType("MOBILE_2G", 2, 2);
        MOBILE_3G = new WirelessNetworkType("MOBILE_3G", 3, 3);
        MOBILE_4G = new WirelessNetworkType("MOBILE_4G", 4, 4);
        NETWORKTYPE_INVALID = new WirelessNetworkType("NETWORKTYPE_INVALID", 5, 5);
        WirelessNetworkType wirelessNetworkType = new WirelessNetworkType("NETWORKTYPE_WAP", 6, 6);
        NETWORKTYPE_WAP = wirelessNetworkType;
        $VALUES = new WirelessNetworkType[]{UNKNOWN_NETWORK, WIFI, MOBILE_2G, MOBILE_3G, MOBILE_4G, NETWORKTYPE_INVALID, wirelessNetworkType};
    }

    public WirelessNetworkType(String str, int i, int i2) {
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

    public static WirelessNetworkType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WirelessNetworkType) Enum.valueOf(WirelessNetworkType.class, str) : (WirelessNetworkType) invokeL.objValue;
    }

    public static WirelessNetworkType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WirelessNetworkType[]) $VALUES.clone() : (WirelessNetworkType[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : invokeV.intValue;
    }
}
