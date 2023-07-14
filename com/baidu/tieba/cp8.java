package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65536, null, j)) == null) {
            if (j == 0) {
                return false;
            }
            da5 p = da5.p();
            if (!TimeHelper.isSameDay(p.r("key_chat_room_last_timestamp@" + j + "_" + TbadkCoreApplication.getCurrentAccount(), 0L), System.currentTimeMillis())) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public static void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65537, null, j) == null) && j != 0) {
            da5 p = da5.p();
            p.H("key_chat_room_last_timestamp@" + j + "_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
        }
    }
}
