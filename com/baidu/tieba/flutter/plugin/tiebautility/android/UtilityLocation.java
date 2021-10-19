package com.baidu.tieba.flutter.plugin.tiebautility.android;

import c.a.e.e.m.b;
import c.a.e.e.p.l;
import c.a.r0.z2.j0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityLocationAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AppPosInfo;
/* loaded from: classes7.dex */
public class UtilityLocation implements TiebaUtilityLocationAuto.HostUtilityLocation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityLocation() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityLocationAuto.HostUtilityLocation
    public void getAppPosInfo(TiebaUtilityLocationAuto.Result<TiebaUtilityLocationAuto.AppPosInfoResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, result) == null) {
            TiebaUtilityLocationAuto.AppPosInfoResult appPosInfoResult = new TiebaUtilityLocationAuto.AppPosInfoResult();
            appPosInfoResult.setResult(a.e().b());
            result.success(appPosInfoResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityLocationAuto.HostUtilityLocation
    public void requestDistance(TiebaUtilityLocationAuto.LocationParam locationParam, TiebaUtilityLocationAuto.Result<TiebaUtilityLocationAuto.DistanceResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationParam, result) == null) {
            TiebaUtilityLocationAuto.DistanceResult distanceResult = new TiebaUtilityLocationAuto.DistanceResult();
            double doubleValue = locationParam.getLatitude().doubleValue();
            double doubleValue2 = locationParam.getLongitude().doubleValue();
            boolean z = true;
            boolean z2 = UtilHelper.isDecimal(String.valueOf(doubleValue)) && UtilHelper.isDecimal(String.valueOf(doubleValue2));
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo c2 = a.e().c();
                String str = c2.latitude;
                String str2 = c2.longitude;
                if ((UtilHelper.isDecimal(str) && UtilHelper.isDecimal(str2)) ? false : false) {
                    distanceResult.setResult(Double.valueOf(l.a(b.c(str, 0.0d), b.c(str2, 0.0d), doubleValue, doubleValue2)));
                    result.success(distanceResult);
                }
            }
        }
    }
}
