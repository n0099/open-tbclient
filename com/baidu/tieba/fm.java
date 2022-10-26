package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fm implements IStatisticManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void onPatchResult(int i, String str, int i2, String str2, IStatisticManager.StatisticExtendInfo statisticExtendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, statisticExtendInfo}) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void onUninstallResult(int i, String str, int i2, String str2, IStatisticManager.StatisticExtendInfo statisticExtendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, statisticExtendInfo}) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordDownloadResult(int i, String str, int i2, String str2, IStatisticManager.StatisticExtendInfo statisticExtendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, statisticExtendInfo}) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordException(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, str2) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordPeriod(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordResult(long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
        }
    }

    public fm() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInstallResult(int i, String str, int i2, String str2, IStatisticManager.StatisticExtendInfo statisticExtendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, statisticExtendInfo}) == null) {
            em.c(str, i, i2);
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInvokeResult(int i, String str, int i2, String str2, IStatisticManager.StatisticExtendInfo statisticExtendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, statisticExtendInfo}) == null) {
            if (i == 14) {
                em.a(str, i2);
            }
            em.d(str, i, i2);
        }
    }
}
