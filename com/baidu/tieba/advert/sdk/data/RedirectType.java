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
public final class RedirectType {
    public static final /* synthetic */ RedirectType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final RedirectType APPMANAGE;
    public static final RedirectType SDKBROWSER;
    public static final RedirectType SDKWEBVIEW;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(319250818, "Lcom/baidu/tieba/advert/sdk/data/RedirectType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(319250818, "Lcom/baidu/tieba/advert/sdk/data/RedirectType;");
                return;
            }
        }
        SDKBROWSER = new RedirectType("SDKBROWSER", 0, 0);
        SDKWEBVIEW = new RedirectType("SDKWEBVIEW", 1, 1);
        RedirectType redirectType = new RedirectType("APPMANAGE", 2, 2);
        APPMANAGE = redirectType;
        $VALUES = new RedirectType[]{SDKBROWSER, SDKWEBVIEW, redirectType};
    }

    public RedirectType(String str, int i, int i2) {
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
        this.value = i2;
    }

    public static RedirectType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (RedirectType) Enum.valueOf(RedirectType.class, str);
        }
        return (RedirectType) invokeL.objValue;
    }

    public static RedirectType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (RedirectType[]) $VALUES.clone();
        }
        return (RedirectType[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.value;
        }
        return invokeV.intValue;
    }
}
