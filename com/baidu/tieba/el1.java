package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes3.dex */
public class el1 extends um2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public el1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.in1
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? uz1.v(String.format("%s/api/subscribe/v1/relation/get", sz1.c())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.format("%s/ma/tips", Q()) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.in1
    public HttpRequest F(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, map)) == null) ? P("ma/accredit_v1", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? uz1.w(String.format("%s/ma/grs/brand/applist", Q()), true) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public HttpRequest M(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, map)) == null) ? P("ma/user/openid", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? String.format("%s/ma/ai", Q()) : (String) invokeV.objValue;
    }

    public final HttpRequest P(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, map)) == null) {
            HttpUrl parse = HttpUrl.parse(Q());
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
            for (Map.Entry<String, String> entry : tz1.b().d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            ba4 ba4Var = new ba4();
            ba4Var.b = "POST";
            ba4Var.a = uz1.w(build.toString(), true);
            ba4Var.d = w73.b(map);
            ba4Var.f = true;
            ba4Var.g = true;
            ba4Var.h = false;
            HttpRequestBuilder a = da4.a(ba4Var);
            ca4.g().u(a, ba4Var);
            return a.build();
        }
        return (HttpRequest) invokeLL.objValue;
    }

    public final String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? uz1.a : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public HttpRequest a(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, map)) == null) ? P("ma/user/checksessionkey", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? uz1.w(String.format("%s/ma/update", Q()), true) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? uz1.v(String.format("%s/ma/history/sync", Q())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? String.format("%s/ma/component/comment/bos_auth", "https://ossapi.baidu.com") : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public HttpRequest g(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, context, map)) == null) ? P("ma/user/swanid", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? fm2.n().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.in1
    public HttpRequest o(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, map)) == null) ? P("ma/accredit_data", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? uz1.v(String.format("%s/ma/history/list", Q())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in1
    public HttpRequest s(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, context, map)) == null) ? P("ma/login", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.in1
    public HttpRequest u(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, context, map)) == null) ? P("ma/open/data", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.in1
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? uz1.v(String.format("%s/ma/reset", Q())) : (String) invokeV.objValue;
    }
}
