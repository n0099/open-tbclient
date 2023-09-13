package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Response;
/* loaded from: classes5.dex */
public class bl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static dl4 a(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            Response executeSync = li4.g().getRequest().requestFrom(6).requestSubFrom(i).url(str).build().executeSync();
            if (executeSync == null) {
                return null;
            }
            return new zk4(executeSync);
        }
        return (dl4) invokeLI.objValue;
    }
}
