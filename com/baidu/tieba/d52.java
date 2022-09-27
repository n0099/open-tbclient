package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.tieba.ab2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public ta2 a;
    public db2 b;

    /* loaded from: classes3.dex */
    public class a extends pb2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ d52 c;

        public a(@NonNull d52 d52Var, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d52Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d52Var;
            this.a = str;
            this.b = str2;
            if (d52.c) {
                Log.d("SwanAppV8Daemon", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.tieba.qb2
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.pb2, com.baidu.tieba.qb2
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.b() : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // com.baidu.tieba.pb2, com.baidu.tieba.qb2
        public void c(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ta2Var) == null) {
                if (this.c.b != null) {
                    this.c.b.a(ta2Var);
                }
                ta2Var.y0();
            }
        }

        @Override // com.baidu.tieba.pb2, com.baidu.tieba.qb2
        public void d(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ta2Var) == null) {
                super.d(ta2Var);
            }
        }

        @Override // com.baidu.tieba.qb2
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947655464, "Lcom/baidu/tieba/d52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947655464, "Lcom/baidu/tieba/d52;");
                return;
            }
        }
        c = vj1.a;
    }

    public d52(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = za2.b(c(), new a(this, str, str2), null);
        this.a.addJavascriptInterface(new c52(this.a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public final ab2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ab2.b bVar = new ab2.b();
            bVar.c(3);
            bVar.b(b52.b());
            return bVar.a();
        }
        return (ab2) invokeV.objValue;
    }

    public ta2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ta2) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ta2 ta2Var = this.a;
            if (ta2Var != null) {
                ta2Var.k0();
                this.a = null;
            }
            this.b = null;
        }
    }

    public void f(db2 db2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, db2Var) == null) {
            this.b = db2Var;
        }
    }
}
