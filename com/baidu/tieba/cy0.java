package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class cy0 implements mx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lz0 a;

    public abstract void f(uw0 uw0Var);

    public abstract void g(uw0 uw0Var);

    public abstract void h(uw0 uw0Var);

    public abstract void i(uw0 uw0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947690959, "Lcom/baidu/tieba/cy0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947690959, "Lcom/baidu/tieba/cy0;");
                return;
            }
        }
        zt0.f();
    }

    public cy0(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j(map);
    }

    @Override // com.baidu.tieba.mx0
    public final <T extends hz0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (lz0) t;
        }
    }

    @Override // com.baidu.tieba.nx0
    public final void c(uw0 uw0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, uw0Var) == null) && uw0Var != null && this.a != null) {
            int type = uw0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(uw0Var);
                            return;
                        }
                        return;
                    }
                    g(uw0Var);
                    return;
                }
                f(uw0Var);
                return;
            }
            i(uw0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) z21.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) z21.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) z21.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) z21.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) z21.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) z21.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) z21.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) z21.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) z21.b(map, "ext_request");
            }
        }
    }
}
