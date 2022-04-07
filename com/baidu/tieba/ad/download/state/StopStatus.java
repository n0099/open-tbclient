package com.baidu.tieba.ad.download.state;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class StopStatus {
    public static final /* synthetic */ StopStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final StopStatus DOWNLOAD_FAIL;
    public static final StopStatus DOWNLOAD_UNSTART;
    public static final StopStatus PARAMETER_ERROR;
    public static final StopStatus UNKNOW_ERROR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(824695840, "Lcom/baidu/tieba/ad/download/state/StopStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(824695840, "Lcom/baidu/tieba/ad/download/state/StopStatus;");
                return;
            }
        }
        UNKNOW_ERROR = new StopStatus("UNKNOW_ERROR", 0);
        DOWNLOAD_FAIL = new StopStatus("DOWNLOAD_FAIL", 1);
        DOWNLOAD_UNSTART = new StopStatus("DOWNLOAD_UNSTART", 2);
        StopStatus stopStatus = new StopStatus("PARAMETER_ERROR", 3);
        PARAMETER_ERROR = stopStatus;
        $VALUES = new StopStatus[]{UNKNOW_ERROR, DOWNLOAD_FAIL, DOWNLOAD_UNSTART, stopStatus};
    }

    public StopStatus(String str, int i) {
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

    public static StopStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (StopStatus) Enum.valueOf(StopStatus.class, str) : (StopStatus) invokeL.objValue;
    }

    public static StopStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (StopStatus[]) $VALUES.clone() : (StopStatus[]) invokeV.objValue;
    }
}
