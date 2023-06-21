package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, long j, int i, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Integer.valueOf(i), str2, Integer.valueOf(i2), str3, objArr}) == null) {
            ch chVar = new ch();
            chVar.c("cmd", Integer.valueOf(i));
            if (!TextUtils.isEmpty(str2)) {
                chVar.b("action", str2);
            }
            chVar.b("errNo", String.valueOf(i2));
            if (!TextUtils.isEmpty(str3) && i2 != 0) {
                chVar.b(StatConstants.KEY_EXT_ERR_MSG, str3);
            }
            if (objArr != null && objArr.length > 0) {
                chVar.c(objArr);
            }
            if (i2 == 0) {
                BdStatisticsManager.getInstance().debug(str, j, null, chVar);
            } else {
                BdStatisticsManager.getInstance().error(str, j, (String) null, chVar);
            }
        }
    }
}
