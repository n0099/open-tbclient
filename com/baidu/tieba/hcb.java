package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public class hcb implements gcb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hcb() {
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

    @Override // com.baidu.tieba.gcb
    public String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                if (yab.d().e() != null && yab.d().e().c() != null) {
                    return yab.d().e().c().a(obj);
                }
                return new Gson().toJson(obj);
            } catch (Exception e) {
                bfb.b(e.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gcb
    public <T> T b(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cls)) == null) {
            try {
                if (yab.d().e() != null && yab.d().e().c() != null) {
                    return (T) yab.d().e().c().b(str, cls);
                }
                return (T) new Gson().fromJson(str, (Class<Object>) cls);
            } catch (Exception e) {
                bfb.b(e.getMessage());
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gcb
    public <T> T c(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            try {
                if (yab.d().e() != null && yab.d().e().c() != null) {
                    return (T) yab.d().e().c().c(str, type);
                }
                return (T) new Gson().fromJson(str, type);
            } catch (Exception e) {
                bfb.b(e.getMessage());
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }
}
