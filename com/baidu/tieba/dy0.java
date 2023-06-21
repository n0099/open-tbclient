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
public abstract class dy0 implements nx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mz0 a;

    public abstract void f(vw0 vw0Var);

    public abstract void g(vw0 vw0Var);

    public abstract void h(vw0 vw0Var);

    public abstract void i(vw0 vw0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947720750, "Lcom/baidu/tieba/dy0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947720750, "Lcom/baidu/tieba/dy0;");
                return;
            }
        }
        au0.f();
    }

    public dy0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.nx0
    public final <T extends iz0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (mz0) t;
        }
    }

    @Override // com.baidu.tieba.ox0
    public final void c(vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, vw0Var) == null) && vw0Var != null && this.a != null) {
            int type = vw0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(vw0Var);
                            return;
                        }
                        return;
                    }
                    g(vw0Var);
                    return;
                }
                f(vw0Var);
                return;
            }
            i(vw0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) a31.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) a31.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) a31.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) a31.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) a31.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) a31.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) a31.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) a31.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) a31.b(map, "ext_request");
            }
        }
    }
}
