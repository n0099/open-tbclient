package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class e02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public f02 b;

    /* loaded from: classes5.dex */
    public interface b {
        void a(c42 c42Var);
    }

    @NonNull
    public abstract c42 d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract c42 e(@NonNull JSONObject jSONObject);

    public abstract boolean i();

    /* loaded from: classes5.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e02 b;

        public a(e02 e02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e02Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.e02.b
        public void a(c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c42Var) == null) {
                if (e02.c) {
                    Log.d("SwanAutoSyncApiHandler", this.b.a + " async callback: " + c42Var.toString());
                }
                this.b.b.d(this.a, c42Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947680450, "Lcom/baidu/tieba/e02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947680450, "Lcom/baidu/tieba/e02;");
                return;
            }
        }
        c = ms1.a;
    }

    public e02(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    public c42 f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull f02 f02Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, f02Var)) == null) {
            this.b = f02Var;
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
            }
            if (i()) {
                return h(jSONObject);
            }
            return g(jSONObject, str);
        }
        return (c42) invokeLLL.objValue;
    }

    public final c42 g(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " start handle async");
            }
            c42 d = d(jSONObject, new a(this, str));
            if (!d.h("isSync", Boolean.FALSE)) {
                if (c) {
                    Log.e("SwanAutoSyncApiHandler", this.a + " handleAsync encounter error, json exception");
                }
                return new c42(1001, "make result json error");
            }
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " end handle async, processing in other thread, sync result: " + d.toString());
            }
            return d;
        }
        return (c42) invokeLL.objValue;
    }

    public final c42 h(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " start handle sync");
            }
            c42 e = e(jSONObject);
            if (!e.h("isSync", Boolean.TRUE)) {
                if (c) {
                    Log.e("SwanAutoSyncApiHandler", this.a + " handleSync encounter error, json exception");
                }
                return new c42(1001, "make result json error");
            }
            if (c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " end handle sync, result: " + e.toString());
            }
            return e;
        }
        return (c42) invokeL.objValue;
    }
}
