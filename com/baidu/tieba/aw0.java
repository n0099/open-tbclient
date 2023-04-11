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
/* loaded from: classes3.dex */
public abstract class aw0 implements kv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jx0 a;

    public abstract void f(su0 su0Var);

    public abstract void g(su0 su0Var);

    public abstract void h(su0 su0Var);

    public abstract void i(su0 su0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629455, "Lcom/baidu/tieba/aw0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629455, "Lcom/baidu/tieba/aw0;");
                return;
            }
        }
        xr0.f();
    }

    public aw0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.kv0
    public final <T extends fx0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (jx0) t;
        }
    }

    @Override // com.baidu.tieba.lv0
    public final void c(su0 su0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, su0Var) == null) && su0Var != null && this.a != null) {
            int type = su0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(su0Var);
                            return;
                        }
                        return;
                    }
                    g(su0Var);
                    return;
                }
                f(su0Var);
                return;
            }
            i(su0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) x01.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) x01.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) x01.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) x01.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) x01.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) x01.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) x01.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) x01.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) x01.b(map, "ext_request");
            }
        }
    }
}
