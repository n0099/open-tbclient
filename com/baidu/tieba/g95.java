package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class g95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, long j, int i, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Integer.valueOf(i), str2, Integer.valueOf(i2), str3, objArr}) == null) {
            dh dhVar = new dh();
            dhVar.c("cmd", Integer.valueOf(i));
            if (!TextUtils.isEmpty(str2)) {
                dhVar.b("action", str2);
            }
            dhVar.b("errNo", String.valueOf(i2));
            if (!TextUtils.isEmpty(str3) && i2 != 0) {
                dhVar.b(StatConstants.KEY_EXT_ERR_MSG, str3);
            }
            if (objArr != null && objArr.length > 0) {
                dhVar.c(objArr);
            }
            if (i2 == 0) {
                BdStatisticsManager.getInstance().debug(str, j, null, dhVar);
            } else {
                BdStatisticsManager.getInstance().error(str, j, (String) null, dhVar);
            }
        }
    }
}
