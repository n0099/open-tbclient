package com.baidu.tieba;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c7;
import com.baidu.tieba.q7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f5 implements q7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l5 a;
    public c7<m5> b;
    public o5<?, ?> c;
    public float d;

    public f5() {
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
        new Matrix4();
        new Vector3(1.0f, 1.0f, 1.0f);
        this.b = new c7<>(true, 3, m5.class);
        d(0.016666668f);
    }

    @Override // com.baidu.tieba.q7.c
    public void a(q7 q7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, q7Var, jsonValue) == null) {
            String str = (String) q7Var.l("name", String.class, jsonValue);
            this.a = (l5) q7Var.l("emitter", l5.class, jsonValue);
            this.b.b((c7) q7Var.m("influencers", c7.class, m5.class, jsonValue));
            this.c = (o5) q7Var.l("renderer", o5.class, jsonValue);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.dispose();
            c7.b<m5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            update(g1.b.e());
        }
    }

    public void c(o1 o1Var, j5 j5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, o1Var, j5Var) == null) {
            this.a.f(o1Var, j5Var);
            c7.b<m5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().f(o1Var, j5Var);
            }
            this.c.f(o1Var, j5Var);
        }
    }

    public final void d(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.d = f;
        }
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            d(f);
            this.a.update();
            c7.b<m5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }
}
