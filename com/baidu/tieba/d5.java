package com.baidu.tieba;

import com.badlogic.gdx.utils.JsonValue;
import com.baidu.tieba.i7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class d5 extends y4 implements i7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d5() {
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

    @Override // com.baidu.tieba.y4, com.baidu.tieba.i7.c
    public void a(i7 i7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, i7Var, jsonValue) == null) {
            ((Integer) i7Var.l("minParticleCount", Integer.TYPE, jsonValue)).intValue();
            ((Integer) i7Var.l("maxParticleCount", Integer.TYPE, jsonValue)).intValue();
        }
    }
}
