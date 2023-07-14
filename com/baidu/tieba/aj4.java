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
/* loaded from: classes5.dex */
public class aj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HttpRequestBuilder a(@NonNull yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, yi4Var)) == null) {
            return b(yi4Var, null);
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    @NonNull
    public static HttpRequestBuilder b(@NonNull yi4 yi4Var, @Nullable zi4 zi4Var) {
        InterceptResult invokeLL;
        HttpCommonRequestBuilder o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, yi4Var, zi4Var)) == null) {
            if (zi4Var == null) {
                zi4Var = zi4.g();
            }
            String str = yi4Var.b;
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
                    return zi4Var.getRequest();
                case 1:
                    return zi4Var.headerRequest();
                case 2:
                    o = zi4Var.o();
                    break;
                case 3:
                    o = zi4Var.postRequest();
                    break;
                case 4:
                    o = zi4Var.putRequest();
                    break;
                case 5:
                    o = zi4Var.deleteRequest();
                    break;
                case 6:
                    o = zi4Var.y();
                    break;
                case 7:
                    o = zi4Var.a();
                    break;
                default:
                    return zi4Var.getRequest();
            }
            RequestBody requestBody = yi4Var.d;
            if (requestBody != null) {
                o.requestBody(requestBody);
            }
            return o;
        }
        return (HttpRequestBuilder) invokeLL.objValue;
    }
}
