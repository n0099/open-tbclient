package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityLocationAuto;
import d.a.c.e.m.b;
import d.a.c.e.p.l;
import d.a.j0.s2.f0.a;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class UtilityLocation implements TiebaUtilityLocationAuto.HostUtilityLocation {
    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityLocationAuto.HostUtilityLocation
    public void getAppPosInfo(TiebaUtilityLocationAuto.Result<TiebaUtilityLocationAuto.AppPosInfoResult> result) {
        TiebaUtilityLocationAuto.AppPosInfoResult appPosInfoResult = new TiebaUtilityLocationAuto.AppPosInfoResult();
        appPosInfoResult.setResult(a.e().b());
        result.success(appPosInfoResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityLocationAuto.HostUtilityLocation
    public void requestDistance(TiebaUtilityLocationAuto.LocationParam locationParam, TiebaUtilityLocationAuto.Result<TiebaUtilityLocationAuto.DistanceResult> result) {
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
                distanceResult.setResult(Double.valueOf(l.a(b.b(str, 0.0d), b.b(str2, 0.0d), doubleValue, doubleValue2)));
                result.success(distanceResult);
            }
        }
    }
}
