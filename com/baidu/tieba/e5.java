package com.baidu.tieba;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7;
import com.baidu.tieba.p7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e5 implements p7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k5 a;
    public b7<l5> b;
    public n5<?, ?> c;
    public float d;

    public e5() {
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
        this.b = new b7<>(true, 3, l5.class);
        d(0.016666668f);
    }

    @Override // com.baidu.tieba.p7.c
    public void a(p7 p7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, p7Var, jsonValue) == null) {
            String str = (String) p7Var.l("name", String.class, jsonValue);
            this.a = (k5) p7Var.l("emitter", k5.class, jsonValue);
            this.b.b((b7) p7Var.m("influencers", b7.class, l5.class, jsonValue));
            this.c = (n5) p7Var.l("renderer", n5.class, jsonValue);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.dispose();
            b7.b<l5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            update(f1.b.e());
        }
    }

    public void c(n1 n1Var, i5 i5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, n1Var, i5Var) == null) {
            this.a.f(n1Var, i5Var);
            b7.b<l5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().f(n1Var, i5Var);
            }
            this.c.f(n1Var, i5Var);
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
            b7.b<l5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }
}
