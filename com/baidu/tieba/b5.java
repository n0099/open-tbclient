package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.download.lightdownload.LightFileUtils;
import com.baidu.tieba.i7;
import com.baidu.tieba.q7;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b5<T> implements i7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q7<String, b> a;
    public u6<b> b;
    public u6<a> c;
    public T d;

    /* loaded from: classes5.dex */
    public static class a<T> implements i7.c {
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

        @Override // com.baidu.tieba.i7.c
        public void a(i7 i7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, i7Var, jsonValue) == null) {
                this.a = (String) i7Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) i7Var.l("type", String.class, jsonValue);
                try {
                    this.b = n8.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements i7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public f7 a;
        public b5 b;

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
            new q7();
            this.a = new f7();
        }

        @Override // com.baidu.tieba.i7.c
        public void a(i7 i7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, i7Var, jsonValue) == null) {
                q7 q7Var = (q7) i7Var.l("data", q7.class, jsonValue);
                this.a.b((int[]) i7Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public b5() {
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
        this.a = new q7<>();
        this.b = new u6<>(true, 3, b.class);
        this.c = new u6<>();
    }

    @Override // com.baidu.tieba.i7.c
    public void a(i7 i7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, i7Var, jsonValue) == null) {
            q7<String, b> q7Var = (q7) i7Var.l("unique", q7.class, jsonValue);
            this.a = q7Var;
            q7.a<String, b> b2 = q7Var.b();
            b2.c();
            while (b2.hasNext()) {
                ((b) b2.next().b).b = this;
            }
            u6<b> u6Var = (u6) i7Var.m("data", u6.class, b.class, jsonValue);
            this.b = u6Var;
            u6.b<b> it = u6Var.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
            this.c.b((u6) i7Var.m("assets", u6.class, a.class, jsonValue));
            this.d = (T) i7Var.l(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE, null, jsonValue);
        }
    }

    public u6<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (u6) invokeV.objValue;
    }
}
