package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class hl2 extends dl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public hl2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "route";
    }

    @Override // com.baidu.tieba.dl2
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            map.put("fromId", this.c);
            map.put("toId", this.d);
            map.put("toTabIndex", this.g);
            if (!TextUtils.isEmpty(this.e)) {
                map.put("routeType", this.e);
            }
            if (!TextUtils.isEmpty(this.f)) {
                map.put("toPage", this.f);
            }
        }
    }
}
