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
public class d39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c39 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof c39)) {
                return null;
            }
            return (c39) iLegoAdvert;
        }
        return (c39) invokeL.objValue;
    }

    public static void b(c39 c39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, c39Var) == null) && c39Var != null && c39Var.getParallelCharge() != null) {
            y31.b(c39Var.getParallelCharge().b);
            Iterator<String> it = c39Var.getParallelCharge().c.iterator();
            while (it.hasNext()) {
                y31.b(it.next());
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
            x31.e(clogBuilder);
        }
    }

    public static boolean d(c39 c39Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c39Var)) == null) {
            if (c39Var == null || c39Var.getParallelCharge() == null) {
                return false;
            }
            String str = c39Var.getParallelCharge().a;
            y31.b(str);
            if (!TextUtils.isEmpty(str)) {
                z = true;
            } else {
                z = false;
            }
            Iterator<String> it = c39Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!z && TextUtils.isEmpty(next)) {
                    z = false;
                } else {
                    z = true;
                }
                y31.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
