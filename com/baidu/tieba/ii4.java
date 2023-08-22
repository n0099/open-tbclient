package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.RequestBody;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes6.dex */
public class ii4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HttpRequestBuilder a(@NonNull gi4 gi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gi4Var)) == null) {
            return b(gi4Var, null);
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    @NonNull
    public static HttpRequestBuilder b(@NonNull gi4 gi4Var, @Nullable hi4 hi4Var) {
        InterceptResult invokeLL;
        HttpCommonRequestBuilder o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, gi4Var, hi4Var)) == null) {
            if (hi4Var == null) {
                hi4Var = hi4.g();
            }
            String str = gi4Var.b;
            char c = 65535;
            switch (str.hashCode()) {
                case -531492226:
                    if (str.equals(HttpOptions.METHOD_NAME)) {
                        c = 2;
                        break;
                    }
                    break;
                case 70454:
                    if (str.equals("GET")) {
                        c = 0;
                        break;
                    }
                    break;
                case 79599:
                    if (str.equals(HttpPut.METHOD_NAME)) {
                        c = 4;
                        break;
                    }
                    break;
                case 2213344:
                    if (str.equals("HEAD")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2461856:
                    if (str.equals("POST")) {
                        c = 3;
                        break;
                    }
                    break;
                case 80083237:
                    if (str.equals(HttpTrace.METHOD_NAME)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (str.equals("CONNECT")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (str.equals(HttpDelete.METHOD_NAME)) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return hi4Var.getRequest();
                case 1:
                    return hi4Var.headerRequest();
                case 2:
                    o = hi4Var.o();
                    break;
                case 3:
                    o = hi4Var.postRequest();
                    break;
                case 4:
                    o = hi4Var.putRequest();
                    break;
                case 5:
                    o = hi4Var.deleteRequest();
                    break;
                case 6:
                    o = hi4Var.y();
                    break;
                case 7:
                    o = hi4Var.a();
                    break;
                default:
                    return hi4Var.getRequest();
            }
            RequestBody requestBody = gi4Var.d;
            if (requestBody != null) {
                o.requestBody(requestBody);
            }
            return o;
        }
        return (HttpRequestBuilder) invokeLL.objValue;
    }
}
