package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPreferences a;

    public dt7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = TbadkCoreApplication.getInst().getSharedPreferences("frs_guide_sp", 0);
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && !"0".equals(str) && !"0".equals(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public long b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!a(str, str2)) {
                return 0L;
            }
            return this.a.getLong(str + '_' + str2 + "_show_time", 0L);
        }
        return invokeLL.longValue;
    }

    public void c(String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) != null) || !a(str, str2)) {
            return;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.putLong(str + '_' + str2 + "_show_time", j);
        if (z) {
            edit.putBoolean(str + '_' + str2 + "_show", true);
        }
        edit.apply();
    }
}
