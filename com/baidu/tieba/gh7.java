package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class gh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fh7 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof fh7)) {
                return null;
            }
            return (fh7) iLegoAdvert;
        }
        return (fh7) invokeL.objValue;
    }

    public static void b(fh7 fh7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, fh7Var) == null) && fh7Var != null && fh7Var.getParallelCharge() != null) {
            j01.b(fh7Var.getParallelCharge().b);
            Iterator it = fh7Var.getParallelCharge().c.iterator();
            while (it.hasNext()) {
                j01.b((String) it.next());
            }
        }
    }

    public static void c(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, advertAppInfo) == null) && d(a(advertAppInfo))) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.EXCEPTION).k("1").l(DpStatConstants.FILECACHE_CLOSE_TYPE_OPT_DISABLE).p(advertAppInfo.g);
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.h;
            if (iLegoAdvert != null) {
                clogBuilder.m(String.valueOf(iLegoAdvert.getGoodsStyle()));
            }
            i01.b(clogBuilder);
        }
    }

    public static boolean d(fh7 fh7Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fh7Var)) == null) {
            if (fh7Var == null || fh7Var.getParallelCharge() == null) {
                return false;
            }
            String str = fh7Var.getParallelCharge().a;
            j01.b(str);
            if (!TextUtils.isEmpty(str)) {
                z = true;
            } else {
                z = false;
            }
            Iterator it = fh7Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!z && TextUtils.isEmpty(str2)) {
                    z = false;
                } else {
                    z = true;
                }
                j01.b(str2);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
