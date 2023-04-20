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
public abstract class bw0 implements lv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kx0 a;

    public abstract void f(tu0 tu0Var);

    public abstract void g(tu0 tu0Var);

    public abstract void h(tu0 tu0Var);

    public abstract void i(tu0 tu0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659246, "Lcom/baidu/tieba/bw0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659246, "Lcom/baidu/tieba/bw0;");
                return;
            }
        }
        yr0.f();
    }

    public bw0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.lv0
    public final <T extends gx0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (kx0) t;
        }
    }

    @Override // com.baidu.tieba.mv0
    public final void c(tu0 tu0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, tu0Var) == null) && tu0Var != null && this.a != null) {
            int type = tu0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(tu0Var);
                            return;
                        }
                        return;
                    }
                    g(tu0Var);
                    return;
                }
                f(tu0Var);
                return;
            }
            i(tu0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) y01.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) y01.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) y01.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) y01.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) y01.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) y01.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) y01.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) y01.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) y01.b(map, "ext_request");
            }
        }
    }
}
