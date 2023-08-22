package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a29 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof a29)) {
                return null;
            }
            return (a29) iLegoAdvert;
        }
        return (a29) invokeL.objValue;
    }

    public static void b(a29 a29Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, a29Var) == null) && a29Var != null && a29Var.getParallelCharge() != null) {
            u31.b(a29Var.getParallelCharge().b);
            Iterator<String> it = a29Var.getParallelCharge().c.iterator();
            while (it.hasNext()) {
                u31.b(it.next());
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
            t31.e(clogBuilder);
        }
    }

    public static boolean d(a29 a29Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, a29Var)) == null) {
            if (a29Var == null || a29Var.getParallelCharge() == null) {
                return false;
            }
            String str = a29Var.getParallelCharge().a;
            u31.b(str);
            if (!TextUtils.isEmpty(str)) {
                z = true;
            } else {
                z = false;
            }
            Iterator<String> it = a29Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!z && TextUtils.isEmpty(next)) {
                    z = false;
                } else {
                    z = true;
                }
                u31.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
