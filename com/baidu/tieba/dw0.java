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
/* loaded from: classes4.dex */
public abstract class dw0 implements nv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mx0 a;

    public abstract void f(vu0 vu0Var);

    public abstract void g(vu0 vu0Var);

    public abstract void h(vu0 vu0Var);

    public abstract void i(vu0 vu0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718828, "Lcom/baidu/tieba/dw0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718828, "Lcom/baidu/tieba/dw0;");
                return;
            }
        }
        as0.f();
    }

    public dw0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.nv0
    public final <T extends ix0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (mx0) t;
        }
    }

    @Override // com.baidu.tieba.ov0
    public final void c(vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, vu0Var) == null) && vu0Var != null && this.a != null) {
            int type = vu0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(vu0Var);
                            return;
                        }
                        return;
                    }
                    g(vu0Var);
                    return;
                }
                f(vu0Var);
                return;
            }
            i(vu0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) a11.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) a11.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) a11.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) a11.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) a11.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) a11.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) a11.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) a11.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) a11.b(map, "ext_request");
            }
        }
    }
}
