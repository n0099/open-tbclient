package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tieba.b7;
import com.baidu.tieba.p7;
import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i5 implements p7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x7 a;
    public b7 b;
    public b7 c;
    public Object d;

    /* loaded from: classes4.dex */
    public class a implements p7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Class b;

        public a() {
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

        @Override // com.baidu.tieba.p7.c
        public void a(p7 p7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, p7Var, jsonValue) == null) {
                this.a = (String) p7Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) p7Var.l("type", String.class, jsonValue);
                try {
                    this.b = u8.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements p7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public m7 a;
        public i5 b;

        public b() {
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
            new x7();
            this.a = new m7();
        }

        @Override // com.baidu.tieba.p7.c
        public void a(p7 p7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, p7Var, jsonValue) == null) {
                x7 x7Var = (x7) p7Var.l("data", x7.class, jsonValue);
                this.a.b((int[]) p7Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public i5() {
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
        this.a = new x7();
        this.b = new b7(true, 3, b.class);
        this.c = new b7();
    }

    @Override // com.baidu.tieba.p7.c
    public void a(p7 p7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, p7Var, jsonValue) == null) {
            x7 x7Var = (x7) p7Var.l("unique", x7.class, jsonValue);
            this.a = x7Var;
            x7.a b2 = x7Var.b();
            b2.c();
            while (b2.hasNext()) {
                ((b) ((x7.b) b2.next()).b).b = this;
            }
            b7 b7Var = (b7) p7Var.m("data", b7.class, b.class, jsonValue);
            this.b = b7Var;
            b7.b it = b7Var.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b = this;
            }
            this.c.b((b7) p7Var.m("assets", b7.class, a.class, jsonValue));
            this.d = p7Var.l("resource", null, jsonValue);
        }
    }

    public b7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (b7) invokeV.objValue;
    }
}
