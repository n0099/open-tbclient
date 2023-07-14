package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.download.lightdownload.LightFileUtils;
import com.baidu.tieba.h7;
import com.baidu.tieba.p7;
import com.baidu.tieba.t6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a5<T> implements h7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p7<String, b> a;
    public t6<b> b;
    public t6<a> c;
    public T d;

    /* loaded from: classes5.dex */
    public static class a<T> implements h7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Class<T> b;

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

        @Override // com.baidu.tieba.h7.c
        public void a(h7 h7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, h7Var, jsonValue) == null) {
                this.a = (String) h7Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) h7Var.l("type", String.class, jsonValue);
                try {
                    this.b = m8.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements h7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e7 a;
        public a5 b;

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
            new p7();
            this.a = new e7();
        }

        @Override // com.baidu.tieba.h7.c
        public void a(h7 h7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, h7Var, jsonValue) == null) {
                p7 p7Var = (p7) h7Var.l("data", p7.class, jsonValue);
                this.a.b((int[]) h7Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public a5() {
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
        this.a = new p7<>();
        this.b = new t6<>(true, 3, b.class);
        this.c = new t6<>();
    }

    @Override // com.baidu.tieba.h7.c
    public void a(h7 h7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, h7Var, jsonValue) == null) {
            p7<String, b> p7Var = (p7) h7Var.l("unique", p7.class, jsonValue);
            this.a = p7Var;
            p7.a<String, b> b2 = p7Var.b();
            b2.c();
            while (b2.hasNext()) {
                ((b) b2.next().b).b = this;
            }
            t6<b> t6Var = (t6) h7Var.m("data", t6.class, b.class, jsonValue);
            this.b = t6Var;
            t6.b<b> it = t6Var.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
            this.c.b((t6) h7Var.m("assets", t6.class, a.class, jsonValue));
            this.d = (T) h7Var.l(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE, null, jsonValue);
        }
    }

    public t6<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (t6) invokeV.objValue;
    }
}
