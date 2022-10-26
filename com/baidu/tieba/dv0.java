package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
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
public abstract class dv0 implements nu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mw0 a;

    public abstract void f(vt0 vt0Var);

    public abstract void g(vt0 vt0Var);

    public abstract void h(vt0 vt0Var);

    public abstract void i(vt0 vt0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947717867, "Lcom/baidu/tieba/dv0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947717867, "Lcom/baidu/tieba/dv0;");
                return;
            }
        }
        ar0.f();
    }

    public dv0(Map map) {
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

    @Override // com.baidu.tieba.nu0
    public final void d(iw0 iw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iw0Var) == null) {
            this.a = (mw0) iw0Var;
        }
    }

    @Override // com.baidu.tieba.ou0
    public final void c(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, vt0Var) == null) && vt0Var != null && this.a != null) {
            int type = vt0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(vt0Var);
                            return;
                        }
                        return;
                    }
                    g(vt0Var);
                    return;
                }
                f(vt0Var);
                return;
            }
            i(vt0Var);
        }
    }

    public void j(Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) zz0.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) zz0.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) zz0.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) zz0.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) zz0.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) zz0.b(map, "from");
            }
            if (map.containsKey(Config.EVENT_PAGE_MAPPING)) {
                String str7 = (String) zz0.b(map, Config.EVENT_PAGE_MAPPING);
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) zz0.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) zz0.b(map, "ext_request");
            }
        }
    }
}
