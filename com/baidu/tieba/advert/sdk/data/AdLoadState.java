package com.baidu.tieba.advert.sdk.data;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class AdLoadState {
    public static final /* synthetic */ AdLoadState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdLoadState DISMISSED;
    public static final AdLoadState FAILED;
    public static final AdLoadState FORCESHOW;
    public static final AdLoadState INIT;
    public static final AdLoadState LOADING;
    public static final AdLoadState SHOWED;
    public static final AdLoadState SUCCEED;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1604763786, "Lcom/baidu/tieba/advert/sdk/data/AdLoadState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1604763786, "Lcom/baidu/tieba/advert/sdk/data/AdLoadState;");
                return;
            }
        }
        INIT = new AdLoadState(TornadoLiteRuntime.STATE_INIT, 0);
        LOADING = new AdLoadState("LOADING", 1);
        SUCCEED = new AdLoadState("SUCCEED", 2);
        FAILED = new AdLoadState("FAILED", 3);
        SHOWED = new AdLoadState("SHOWED", 4);
        DISMISSED = new AdLoadState("DISMISSED", 5);
        AdLoadState adLoadState = new AdLoadState("FORCESHOW", 6);
        FORCESHOW = adLoadState;
        $VALUES = new AdLoadState[]{INIT, LOADING, SUCCEED, FAILED, SHOWED, DISMISSED, adLoadState};
    }

    public AdLoadState(String str, int i) {
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

    public static AdLoadState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (AdLoadState) Enum.valueOf(AdLoadState.class, str);
        }
        return (AdLoadState) invokeL.objValue;
    }

    public static AdLoadState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (AdLoadState[]) $VALUES.clone();
        }
        return (AdLoadState[]) invokeV.objValue;
    }
}
