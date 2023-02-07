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
public abstract class dx0 implements nw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public my0 a;

    public abstract void f(vv0 vv0Var);

    public abstract void g(vv0 vv0Var);

    public abstract void h(vv0 vv0Var);

    public abstract void i(vv0 vv0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947719789, "Lcom/baidu/tieba/dx0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947719789, "Lcom/baidu/tieba/dx0;");
                return;
            }
        }
        at0.f();
    }

    public dx0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.nw0
    public final <T extends iy0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (my0) t;
        }
    }

    @Override // com.baidu.tieba.ow0
    public final void c(vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, vv0Var) == null) && vv0Var != null && this.a != null) {
            int type = vv0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(vv0Var);
                            return;
                        }
                        return;
                    }
                    g(vv0Var);
                    return;
                }
                f(vv0Var);
                return;
            }
            i(vv0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) z11.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) z11.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) z11.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) z11.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) z11.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) z11.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) z11.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) z11.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) z11.b(map, "ext_request");
            }
        }
    }
}
