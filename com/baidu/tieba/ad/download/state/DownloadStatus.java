package com.baidu.tieba.ad.download.state;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class DownloadStatus {
    public static final /* synthetic */ DownloadStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DownloadStatus STATUS_DOWNLOADING;
    public static final DownloadStatus STATUS_INSTALL_SUCCESS;
    public static final DownloadStatus STATUS_NONE;
    public static final DownloadStatus STATUS_PAUSED;
    public static final DownloadStatus STATUS_SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;
    public final int status;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1600386138, "Lcom/baidu/tieba/ad/download/state/DownloadStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1600386138, "Lcom/baidu/tieba/ad/download/state/DownloadStatus;");
                return;
            }
        }
        STATUS_NONE = new DownloadStatus("STATUS_NONE", 0, 0);
        STATUS_DOWNLOADING = new DownloadStatus("STATUS_DOWNLOADING", 1, 1);
        STATUS_PAUSED = new DownloadStatus("STATUS_PAUSED", 2, 2);
        STATUS_SUCCESS = new DownloadStatus("STATUS_SUCCESS", 3, 3);
        DownloadStatus downloadStatus = new DownloadStatus("STATUS_INSTALL_SUCCESS", 4, 4);
        STATUS_INSTALL_SUCCESS = downloadStatus;
        $VALUES = new DownloadStatus[]{STATUS_NONE, STATUS_DOWNLOADING, STATUS_PAUSED, STATUS_SUCCESS, downloadStatus};
    }

    public DownloadStatus(String str, int i2, int i3) {
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
        this.status = i3;
    }

    public static DownloadStatus parse(int i2) {
        InterceptResult invokeI;
        DownloadStatus[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (DownloadStatus downloadStatus : values()) {
                if (downloadStatus.ordinal() == i2) {
                    return downloadStatus;
                }
            }
            return STATUS_NONE;
        }
        return (DownloadStatus) invokeI.objValue;
    }

    public static DownloadStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (DownloadStatus) Enum.valueOf(DownloadStatus.class, str) : (DownloadStatus) invokeL.objValue;
    }

    public static DownloadStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (DownloadStatus[]) $VALUES.clone() : (DownloadStatus[]) invokeV.objValue;
    }
}
