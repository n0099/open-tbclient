package com.baidu.tieba.downloadmanager.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/tieba/downloadmanager/data/DownloadManageModeCardType;", "", "(Ljava/lang/String;I)V", "INITIALIZE", "ENTER_MANAGE_MODE", "EXIT_MANAGE_MODE", "downloadmanager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloadManageModeCardType {
    public static final /* synthetic */ DownloadManageModeCardType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DownloadManageModeCardType ENTER_MANAGE_MODE;
    public static final DownloadManageModeCardType EXIT_MANAGE_MODE;
    public static final DownloadManageModeCardType INITIALIZE;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ DownloadManageModeCardType[] $values() {
        return new DownloadManageModeCardType[]{INITIALIZE, ENTER_MANAGE_MODE, EXIT_MANAGE_MODE};
    }

    public static DownloadManageModeCardType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (DownloadManageModeCardType) Enum.valueOf(DownloadManageModeCardType.class, str) : (DownloadManageModeCardType) invokeL.objValue;
    }

    public static DownloadManageModeCardType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (DownloadManageModeCardType[]) $VALUES.clone() : (DownloadManageModeCardType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-965832428, "Lcom/baidu/tieba/downloadmanager/data/DownloadManageModeCardType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-965832428, "Lcom/baidu/tieba/downloadmanager/data/DownloadManageModeCardType;");
                return;
            }
        }
        INITIALIZE = new DownloadManageModeCardType("INITIALIZE", 0);
        ENTER_MANAGE_MODE = new DownloadManageModeCardType("ENTER_MANAGE_MODE", 1);
        EXIT_MANAGE_MODE = new DownloadManageModeCardType("EXIT_MANAGE_MODE", 2);
        $VALUES = $values();
    }

    public DownloadManageModeCardType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
    }
}
