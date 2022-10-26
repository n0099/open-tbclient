package com.baidu.tieba;

import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class gd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static id4 a(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            Response executeSync = ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) qa4.g().getRequest().requestFrom(6)).requestSubFrom(i)).url(str)).build().executeSync();
            if (executeSync == null) {
                return null;
            }
            return new ed4(executeSync);
        }
        return (id4) invokeLI.objValue;
    }
}
